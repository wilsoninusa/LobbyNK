package de.buddelbubi.events;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;

import javax.imageio.ImageIO;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.block.Block;
import cn.nukkit.blockentity.BlockEntity;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.event.player.PlayerInteractEvent.Action;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.element.ElementButtonImageData;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.item.Item;
import cn.nukkit.level.Level;
import cn.nukkit.level.Location;
import cn.nukkit.level.ParticleEffect;
import cn.nukkit.level.Sound;
import cn.nukkit.math.Vector3;
import cn.nukkit.utils.Config;
import de.buddelbubi.Lobbynk;
import de.buddelbubi.api.ConfigNK;
import de.buddelbubi.api.MultiLobbyManager;
import de.buddelbubi.api.NukkitConnection;

public class onInteract implements Listener {
	public static HashSet<String> ls = new HashSet<String>();
	public static boolean inter = false;
	@EventHandler(priority=EventPriority.HIGH)
	public void onInteract(PlayerInteractEvent e) {
		
		Player p = e.getPlayer();
		ConfigNK c = de.buddelbubi.Lobbynk.config;
		ConfigNK d = de.buddelbubi.Lobbynk.delaydata;
		ConfigNK i = de.buddelbubi.Lobbynk.images;
		ConfigNK l = de.buddelbubi.Lobbynk.lang;
		ConfigNK h = de.buddelbubi.Lobbynk.hotbar;
		ConfigNK m = de.buddelbubi.Lobbynk.saves;
		String[] compass = h.getString("CompassItem").split(":");
		String[] gadgets = h.getString("GadgetsItem").split(":");
		String[] hider = h.getString("HidePlayerItem").split(":");
		String[] lobby = h.getString("LobbyItem").split(":");
		String[] settings = h.getString("SettingsItem").split(":");
		String[] forcefield = h.getString("ForcefieldItem").split(":");
		String[] silentlobby = h.getString("SilentlobbyItem").split(":");
		String[] frienditem = h.getString("FriendItem").split(":");
		
		if(!c.getBoolean("multiworld") 
				|| MultiLobbyManager.lobbyworlds.contains(e.getPlayer().getLevel().getName()) &&
				!(Lobbynk.saves.exists(e.getPlayer().getName() + ".build"))) {
			
				if(m.getAll().containsKey(p.getName() + ".build")) {
				if(m.get(p.getName()+ ".build") != null) return;
				}
				if(c.getBoolean("spawnprotection")) e.setCancelled(true);
		if(!d.getAll().containsKey(p.getName())) {
			d.set(p.getName(), false);
		}
		if(d.getBoolean(p.getName())) {
			
		}else {
			d.set(p.getName(), true);
			d.save();
			Server.getInstance().getScheduler().scheduleDelayedTask(Server.getInstance().getPluginManager().getPlugin("LobbyNK"), new Runnable() {
				
				@Override
				public void run() {
					d.set(p.getName(), false);
					d.save();
					
				}
			},10);
		
		if(p.getInventory().getItemInHand().getId() == Integer.parseInt(compass[0]) && e.getAction() != Action.PHYSICAL) {
			e.setCancelled(true);
			inter = true;
			if(c.getBoolean("soundeffects")) {
				e.getPlayer().getLevel().addSound(new Vector3(e.getPlayer().getX(), e.getPlayer().getY(), e.getPlayer().getZ()), Sound.BLOCK_ITEMFRAME_REMOVE_ITEM, 1, 1, Collections.singletonList(e.getPlayer()));
				}
		
			FormWindowSimple gui = new FormWindowSimple(l.getString(p.getLocale().toString() + "_" +"Compass.name"), l.getString(p.getLocale().toString() + "_" +"Compass.subtitle"));
			
	
			if(!l.has(p.getPlayer().getLocale().toString() +"_"+ "Compass.Slot" + c.getInt("Gamesamount"))) {
				e.getPlayer().sendMessage("§cYou didn't setup this many slots yet. Do /lobby gen [amount]");
				return;
			}
			for(int dds = 1; dds  != c.getInt("Gamesamount") +1; dds++) {
				String compassname = l.getString(p.getLocale().toString() + "_" +"Compass.Slot"+ dds);
				if(l.getString(p.getLocale().toString() + "_" +"Compass.Slot" + dds).contains("%playercounter[")) {
					int index = 1;
					for(int in = 1; in < l.getString(p.getLocale().toString() + "_" +"Compass.Slot"+dds).split("\\s+").length; in++) {
						if(l.getString(p.getLocale().toString() + "_" +"Compass.Slot"+dds).split("\\s+")[in].startsWith("%playercounter")) index = in;
						
					}
					String addressstring = l.getString(p.getLocale().toString() + "_" +"Compass.Slot" + dds).split("\\s+")[index].replace("%playercounter[", "").replace("]", "");
					String[] address = addressstring.split(":");
					if(addressstring.contains("꞉")) address = addressstring.split("꞉");
					NukkitConnection con;
					if(address.length == 2) {
						con = new NukkitConnection(address[0], Integer.parseInt(address[1]));
					} else con = new NukkitConnection(address[0], 19132);
					if(con.canConnect()) {
						compassname = compassname.replace("%playercounter[", "("+ con.getOnlinePlayers() + "/" + con.getMaxPlayers() + ")").replace(addressstring, "");
					}else compassname = compassname.replace("%playercounter[", "§cOffline").replace(addressstring, "");
				}
				if(c.getBoolean("CompassImages")) {
					
					ElementButtonImageData image = new ElementButtonImageData(i.getString("Slot" +dds +".mode"), i.getString("Slot"+dds));
					gui.addButton(new ElementButton(compassname, image));
				} else {
					gui.addButton(new ElementButton(compassname));	
				}
			}
			p.showFormWindow(gui);
			
			

		} else if(p.getInventory().getItemInHand().getId() == Integer.parseInt(hider[0]) && e.getAction() != Action.PHYSICAL) {
			e.setCancelled(true);
			FormWindowSimple gui1 = new FormWindowSimple(l.getString(p.getLocale().toString() + "_" +"playershider.name"), "");
			ElementButtonImageData hideall = new ElementButtonImageData("path", "textures/items/dye_powder_lime.png");
			ElementButtonImageData hidevip = new ElementButtonImageData("path", "textures/items/dye_powder_purple.png");
			ElementButtonImageData hidenoone = new ElementButtonImageData("path", "textures/items/dye_powder_red.png");
			gui1.addButton(new ElementButton(l.getString(p.getLocale().toString() + "_" +"playershider.hideall"), hideall));
			gui1.addButton(new ElementButton(l.getString(p.getLocale().toString() + "_" +"playershider.hidevip"), hidevip));
			gui1.addButton(new ElementButton(l.getString(p.getLocale().toString() + "_" +"playershider.hidenoone"), hidenoone));
			p.showFormWindow(gui1);
			
			if(c.getBoolean("soundeffects")) {
				e.getPlayer().getLevel().addSound(new Vector3(e.getPlayer().getX(), e.getPlayer().getY(), e.getPlayer().getZ()), Sound.BLOCK_ITEMFRAME_REMOVE_ITEM, 1, 1, Collections.singletonList(e.getPlayer()));
				}
			
		} else if(p.getInventory().getItemInHand().getId() == Integer.parseInt(gadgets[0]) && e.getAction() != Action.PHYSICAL) {
			e.setCancelled(true);
			if(c.getBoolean("soundeffects")) {
				e.getPlayer().getLevel().addSound(new Vector3(e.getPlayer().getX(), e.getPlayer().getY(), e.getPlayer().getZ()), Sound.RANDOM_CHESTOPEN, 1, 1, Collections.singletonList(e.getPlayer()));
				}
			
			FormWindowSimple gui = new FormWindowSimple(l.getString(p.getLocale().toString() + "_" +"Chest.name"), l.getString(p.getLocale().toString() + "_" +"Chest.subtitle"));
			if(e.getPlayer().hasPermission("lobbynk.gadgets.walkingparticles")) {
			ElementButtonImageData effects = new ElementButtonImageData("path", "textures/gui/newgui/Bundle/PaintBrush.png");
			gui.addButton(new ElementButton(l.getString(p.getLocale().toString() + "_" +"Chest.Walkingparticles"), effects));
			}
			if(e.getPlayer().hasPermission("lobbynk.gadgets.cosmetics")) {
				ElementButtonImageData cmts = new ElementButtonImageData("path", "textures/ui/icon_armor.png");
				gui.addButton(new ElementButton(l.getString(p.getLocale().toString() + "_" +"Chest.Cosmetics"), cmts));
			}
			if(p.hasPermission("lobbynk.gadgets.effects")) {
				ElementButtonImageData effe = new ElementButtonImageData("path", "textures/items/potion_bottle_heal.png");
				gui.addButton(new ElementButton(l.getString(p.getLocale().toString() + "_" +"Chest.effects"), effe));
			}
			
			if(!(p.hasPermission("lobbynk.gadgets.walkingparticles") && p.hasPermission("lobbynk.gadgets.cosmetics") && p.hasPermission("lobbynk.gadgets.effects"))) {
				gui.setContent(l.getString(p.getLocale().toString() + "_" +"nopermission"));
			}
			if(e.getPlayer().hasPermission("lobbynk.gadgets.pets")) {
				ElementButtonImageData effects = new ElementButtonImageData("path", "textures/items/egg_npc.png");
				gui.addButton(new ElementButton(l.getString(p.getLocale().toString() + "_" +"Chest.Pets"), effects));
				}
			if(e.getPlayer().hasPermission("lobbynk.remove")) {
			gui.addButton(new ElementButton(l.getString(p.getLocale().toString() + "_" +"Chest.remove")));
			}
			p.showFormWindow(gui);
		} else if(p.getInventory().getItemInHand().getId() == Integer.parseInt(lobby[0]) && e.getAction() != Action.PHYSICAL) {
			if(!c.getBoolean("multilobby")) {
				e.getPlayer().sendMessage("§cMultilobby isn't activated! I would rather remove the LobbySelector from your hotbar.yml");
				return;
			}
			FormWindowSimple gui = new FormWindowSimple(l.getString(p.getLocale().toString() + "_" +"lobbyselector"), "");
			for(String s : de.buddelbubi.api.MultiLobbyManager.lobbyworlds) {
				Boolean cl = false;
				if(e.getPlayer().getLevel().getName().equals(s)) cl = true;
				if(s.startsWith("VIP-")) {
					if(p.hasPermission("lobbynk.lobby" +s.replace("VIP-", ""))) {
						ElementButton eb = new ElementButton((l.getString(p.getLocale().toString() + "_" +"lobbyselector.vipprefix") + s.replace("VIP-", "") + " " + l.getString(p.getLocale().toString() + "_" +"Lobbyselector.Playercounter")).replace("%inlobby", Server.getInstance().getLevelByName(s).getPlayers().size() + "").replace("%maxlobby", c.getInt("maxplayersperlobby") + ""));
						if(cl) { eb.addImage(new ElementButtonImageData("path", "textures/persona_thumbnails/alex_hair_thumbnail_0.png"));
						} else {
							if(Server.getInstance().getLevelByName(s).getPlayers().size() != c.getInt("maxplayersperlobby")) {
								eb.addImage(new ElementButtonImageData("path", "textures/items/dye_powder_lime.png"));
							} else {
								eb.addImage(new ElementButtonImageData("path", "textures/items/dye_powder_red.png"));
							}
						}
					
						
						gui.addButton(eb);
					}
				}else {
					ElementButton eb = new ElementButton((l.getString(p.getLocale().toString() + "_" +"lobbyselector.prefix") + s + " " + l.getString(p.getLocale().toString() + "_" +"Lobbyselector.Playercounter")).replace("%inlobby", Server.getInstance().getLevelByName(s).getPlayers().size() + "").replace("%maxlobby", c.getInt("maxplayersperlobby") + ""));
					if(cl) { eb.addImage(new ElementButtonImageData("path", i.getString("currentlobby")));} else {
						if(Server.getInstance().getLevelByName(s).getPlayers().size() != c.getInt("maxplayersperlobby")) {
							eb.addImage(new ElementButtonImageData("path", i.getString("nonfulllobby")));
						} else {
							eb.addImage(new ElementButtonImageData("path", i.getString("fulllobby")));
						}
					}
				gui.addButton(eb);
			}}
			
			for(String s : MultiLobbyManager.lobbyservers.keySet()) {
				Config loc = new Config(new File(Server.getInstance().getPluginManager().getPlugin("LobbyNK").getDataFolder(), "locations.yml"));
				String[] address = loc.getString("server." + s).split(":");
				
				if(s.contains("onlineplayers") || loc.getString(s).contains("maxplayers")) {
					NukkitConnection con = new NukkitConnection(address[0], Integer.parseInt(address[1]));
							if(con.canConnect()) {
							
								ElementButton eb = new ElementButton(l.getString(p.getLocale().toString() + "_" +"lobbyselector.serverprefix") + s.replace("server.", "").replace("onlineplayers", String.valueOf(con.getOnlinePlayers())).replace("maxplayers", String.valueOf(con.getMaxPlayers())), new ElementButtonImageData("path", i.getString("serverpicture")));
								gui.addButton(eb);
							} else {
								ElementButton eb = new ElementButton(l.getString(p.getLocale().toString() + "_" +"lobbyselector.serverprefix") + s.replace("server.", "").replace("onlineplayers", "§cOffline§a").replace("maxplayers", "").replace("/", ""), new ElementButtonImageData("path", i.getString("serverpicture")));
								gui.addButton(eb);
							}
				} else {
				ElementButton eb = new ElementButton(l.getString(p.getLocale().toString() + "_" +"lobbyselector.serverprefix") + s.replace("server.", ""), new ElementButtonImageData("path", i.getString("serverpicture")));
				gui.addButton(eb);
				}
			}
			p.showFormWindow(gui);
			ls.add(e.getPlayer().getName());
			
		} else if(p.getInventory().getItemInHand().getId() == Integer.parseInt(settings[0]) && e.getAction() != Action.PHYSICAL) {
			e.setCancelled(true);
			if(!de.buddelbubi.Lobbynk.playersettings.containsKey(e.getPlayer().getName() + ".doublejump")) {
				de.buddelbubi.Lobbynk.playersettings.put(e.getPlayer().getName() + ".doublejump", true);
				de.buddelbubi.Lobbynk.playersettings.put(e.getPlayer().getName() + ".fly", false);
				de.buddelbubi.Lobbynk.playersettings.put(e.getPlayer().getName() + ".jumppad", true);
				de.buddelbubi.Lobbynk.playersettings.put(e.getPlayer().getName() + ".forcefield", false);
			}
			FormWindowSimple gui = new FormWindowSimple(l.getString(p.getLocale().toString() + "_" +"settings"), "");
			if(Boolean.valueOf(de.buddelbubi.Lobbynk.playersettings.getAsString(e.getPlayer().getName() + ".doublejump")) && p.hasPermission("lobbynk.doublejump")) {
				ElementButton dj = new ElementButton("§a" + l.getString(p.getLocale().toString() + "_" +"settings.doublejump"));
				dj.addImage(new ElementButtonImageData("path", "textures/gui/newgui/mob_effects/jump_boost_effect.png"));
				gui.addButton(dj);
			} else if(p.hasPermission("lobbynk.doublejump")){
				ElementButton dj = new ElementButton("§c" + l.getString(p.getLocale().toString() + "_" +"settings.doublejump"));
				dj.addImage(new ElementButtonImageData("path", "textures/gui/newgui/mob_effects/jump_boost_effect.png"));
				gui.addButton(dj);
			}
			if(Boolean.valueOf(de.buddelbubi.Lobbynk.playersettings.getAsString(e.getPlayer().getName() + ".fly")) && e.getPlayer().hasPermission("lobbynk.fly")) {
				ElementButton fly = new ElementButton("§a" + l.getString(p.getLocale().toString() + "_" +"settings.fly"));
				fly.addImage(new ElementButtonImageData("path", "textures/gui/newgui/mob_effects/levitation_effect.png"));
				gui.addButton(fly);
			} else if(p.hasPermission("lobbynk.fly")){
				ElementButton fly = new ElementButton("§c" + l.getString(p.getLocale().toString() + "_" +"settings.fly"));
				fly.addImage(new ElementButtonImageData("path", "textures/gui/newgui/mob_effects/levitation_effect.png"));
				gui.addButton(fly);
			}
			if(Boolean.valueOf(de.buddelbubi.Lobbynk.playersettings.getAsString(e.getPlayer().getName() + ".jumppad"))) {
				ElementButton jumppad = new ElementButton("§a" + l.getString(p.getLocale().toString() + "_" +"settings.jumppad"));
				jumppad.addImage(new ElementButtonImageData("path", "textures/items/emerald.png"));
				gui.addButton(jumppad);
			} else{
				ElementButton jumppad = new ElementButton("§c" + l.getString(p.getLocale().toString() + "_" +"settings.jumppad"));
				jumppad.addImage(new ElementButtonImageData("path", "textures/items/emerald.png"));
				gui.addButton(jumppad);
			}
			if(Boolean.valueOf(de.buddelbubi.Lobbynk.playersettings.getAsString(e.getPlayer().getName() + ".forcefield")) && e.getPlayer().hasPermission("lobbynk.forcefield")) {
				ElementButton ff = new ElementButton("§a" + l.getString(p.getLocale().toString() + "_" +"settings.forcefield"));
				ff.addImage(new ElementButtonImageData("path", "textures/items/ender_eye.png"));
				gui.addButton(ff);
			} else if(e.getPlayer().hasPermission("lobbynk.forcefield")){
				ElementButton ff = new ElementButton("§c" + l.getString(p.getLocale().toString() + "_" +"settings.forcefield"));
				ff.addImage(new ElementButtonImageData("path", "textures/items/ender_eye.png"));
				gui.addButton(ff);
			}
			try {
				if(Server.getInstance().getPluginManager().getPlugin("FriendSystem").isEnabled()) {
					
					ElementButton ff = new ElementButton("§eFriends");
					ff.addImage(new ElementButtonImageData("path", "textures/ui/multiplayer_glyph_color.png"));
					gui.addButton(ff);
					
				} 
			} catch (Exception e2) {
				
			}
			if(e.getPlayer().hasPermission("lobbynk.pet.settings") && PetEvents.map.containsKey(p)) {
				
				ElementButton pet = new ElementButton(l.getString(p.getLocale().toString() + "_" +"Chest.Petsettings"));
				pet.addImage(new ElementButtonImageData("path", "textures/items/egg_npc.png"));
				gui.addButton(pet);
				
			}
			p.showFormWindow(gui);
			
		}	if(p.getInventory().getItemInHand().getId() == Item.STAINED_GLASS_PANE){
			e.setCancelled(true);
			
		    /*Location loc = p.getLocation();
		    int radius = 1;
		    for(double y = 0; y <= 9; y+=0.05) {
		        double x = radius * Math.cos(y);
		        double z = radius * Math.sin(y);
		        Location part = new Location((float) (loc.getX() + x), (float) (loc.getY() + y/4 ), (float) (loc.getZ() + z));
		      
		        loc.getLevel().addParticleEffect(part, ParticleEffect.REDSTONE_ORE_DUST);
		    }
			*/
		}else if(p.getInventory().getItemInHand().getId() == Integer.parseInt(forcefield[0])) {
			e.setCancelled(true);
			if(p.hasPermission("lobbynk.forcefield")) {
				
				if(de.buddelbubi.Lobbynk.playersettings.containsKey(p.getName() + ".forcefield") && Boolean.valueOf(de.buddelbubi.Lobbynk.playersettings.get(p.getName() + ".forcefield").toString())) {
					e.getPlayer().sendMessage(l.getString(p.getLocale().toString() + "_" +"settings.disabled").replace("%mode", l.getString(p.getLocale().toString() + "_" +"settings.forcefield"))); 
					 de.buddelbubi.Lobbynk.playersettings.put(e.getPlayer().getName() + ".forcefield", false);
				} else {
					e.getPlayer().sendMessage(l.getString(p.getLocale().toString() + "_" +"settings.enabled").replace("%mode", l.getString(p.getLocale().toString() + "_" +"settings.forcefield"))); 
					 de.buddelbubi.Lobbynk.playersettings.put(e.getPlayer().getName() + ".forcefield", true);
				}
				
			} else p.sendMessage(l.getString(p.getLocale().toString() + "_" +"nopermission"));
			
		}else if(p.getInventory().getItemInHand().getId() == Integer.parseInt(silentlobby[0])){
			e.setCancelled(true);
			int lobbys = 0;
			if(!c.getBoolean("multilobby")) {
				e.getPlayer().sendMessage("§cMultilobby isn't activated! I would rather remove the SilentLobbyItem from your hotbar.yml");
				return;
			}
			for(String s : MultiLobbyManager.lobbyworlds) {
				if(s.startsWith("VIP-") && p.hasPermission("lobbynk.VIP." + s.replace("VIP-", ""))) {
					if(Server.getInstance().getLevelByName(s).getPlayers().size() < c.getInt("maxplayersperlobby") || p.hasPermission("lobbynk.fulllobby")) {
						lobbys++;
						Config loc = new Config(new File(Server.getInstance().getPluginManager().getPlugin("LobbyNK").getDataFolder(), "locations.yml"));
					
						 if(loc.exists("spawn.x." +s)) {
							
							double x = loc.getDouble("spawn.x."+s);
							double y = loc.getDouble("spawn.y."+s);
							double z = loc.getDouble("spawn.z."+s);
							float yaw = (float) loc.getDouble("spawn.yaw."+s);
							float pitch = (float) loc.getDouble("spawn.pitch."+s);
							Level le = Server.getInstance().getLevelByName(loc.getString("spawn.world."+s));
							Location tp = new Location(x,y,z,yaw,pitch,le);

							e.getPlayer().teleport(tp);
							e.getPlayer().sendMessage(l.getString(p.getLocale().toString() + "_" +"lobbyconnected").replace("%lobby", s.replace("VIP-", "")));
						break;
					}
					
				}
				
			}}
			if(lobbys == 0) {
				p.sendMessage(l.getString(p.getLocale().toString() + "_" +"everylobbyisfull"));
			}
		}else if(p.getInventory().getItemInHand().getId() == Integer.parseInt(frienditem[0])){
			try {
				if(Server.getInstance().getPluginManager().getPlugin("FriendSystem").isEnabled()) {
					
				
				Server.getInstance().dispatchCommand(p, new Config(new File(Server.getInstance().getPluginManager().getPlugin("FriendSystem").getDataFolder() , "config.yml")).getString("Commands.Friend.Name"));
					
				} else {
					p.sendMessage("§cThis Item requies the Plugin FriendSystem by Mundschutziii.");
				}
			} catch (Exception e2) {
				p.sendMessage("§cThis Item requies the Plugin FriendSystem by Mundschutziii.");
			}
			
			
		}else {
	
			if(c.getBoolean("disableInteract") && !p.isCreative()) {
				e.setCancelled(true);
			} else {
				e.setCancelled(false);
			}
			}
		}}
		
		if(c.getBoolean("disableInteract") && e.getAction() == Action.PHYSICAL) {
			if((!c.getBoolean("multiworld") || MultiLobbyManager.lobbyworlds.contains(e.getPlayer().getLevel().getName())) && !Lobbynk.saves.getBoolean(e.getPlayer().getName() + ".build")) {
		 if(e.getBlock().getId() == Block.FARMLAND || e.getBlock().getId() == Block.WHEAT_BLOCK) {
			 e.setCancelled(true);
			 Block b = e.getBlock();
			 b.getLevel().setBlock(new Vector3(b.getX(), b.getY(), b.getZ()), Block.get(b.getId()));
		 }
			}
		}
		}
}
