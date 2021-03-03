package de.buddelbubi.events;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.defaults.GiveCommand;
import cn.nukkit.event.Event;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.player.PlayerQuitEvent;
import cn.nukkit.event.player.PlayerRespawnEvent;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemFirework.FireworkExplosion;
import cn.nukkit.level.Level;
import cn.nukkit.level.Location;
import cn.nukkit.math.Vector3;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.DummyBossBar;
import de.buddelbubi.Lobbynk;
import de.buddelbubi.api.ConfigNK;
import de.buddelbubi.api.MultiLobbyManager;
import de.buddelbubi.api.player;
import de.buddelbubi.api.spawnFirework;

public class onJoin implements Listener{


	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerRespawnEvent e) {
		if(!e.isFirstSpawn()) return;
		if(!de.buddelbubi.Lobbynk.playersettings.containsKey(e.getPlayer().getName() + ".jumppad")) {
		de.buddelbubi.Lobbynk.playersettings.put(e.getPlayer().getName() + ".jumppad", true);
		}
		ConfigNK c = de.buddelbubi.Lobbynk.config;
		
		String[] devices = new String[] {"Unknown", "Android", "iOS", "MacOS", "FireOS", "GearVR", "HoloLens", "Windows 10", "Windows", "Dedicated", "PlayStation 4", "Switch"};
		
		if(c.getBoolean("DeviceDisplay")) {
			String device = "Unknown";
			switch (e.getPlayer().getLoginChainData().getDeviceOS()) {
			case 0:
				device = "Unknown";
				break;
			case 1:
				device = "Android"; 
				break;
			case 2:
				device = "iOS";
				break;
			case 3:
				device = "MacOS";
				break;
			case 4:
				device = "FireOS";
				break;
			case 5:
				device = "GearVR";
				break;
			case 6:
				device = "HoloLens";
				break;
			case 7:
				device = "Windows 10";
				break;
			case 8:
				device = "Windows";
				break;
			case 9:
				device = "Dedicated";
				break;
			case 10:
				device = "PlayStation 4";
				break;
			case 11:
				device = "Switch";
				break;
			default: 
				device = "Unknown";
				break;
			}
			
			e.getPlayer().setNameTag(e.getPlayer().getDisplayName() +"\n§7" + device);
			
		}
		
		
ConfigNK lang = de.buddelbubi.Lobbynk.lang;
if(!c.getBoolean("multiworld") || MultiLobbyManager.lobbyworlds.contains(e.getPlayer().getLevel().getName())) {
	de.buddelbubi.events.onTeleport.invs.put(e.getPlayer().getName(), e.getPlayer().getInventory().getContents());
	de.buddelbubi.events.onTeleport.xp.put(e.getPlayer().getName(), e.getPlayer().getExperience());
	de.buddelbubi.events.onTeleport.level.put(e.getPlayer().getName(), e.getPlayer().getExperienceLevel());
Server.getInstance().getScheduler().scheduleDelayedTask(new Runnable() {
	
	@Override
	public void run() {
			de.buddelbubi.api.player.giveHotbar(e.getPlayer());
			
			Server.getInstance().getScheduler().scheduleDelayedTask(new Runnable() {
				
				@Override
				public void run() {
					if(e.getPlayer().getGamemode() != 1) {
						for(DummyBossBar b : e.getPlayer().getDummyBossBars().values()) {
							b.destroy();
						}
						if(c.getBoolean("Bossbar")) {
							
							e.getPlayer().createBossBar(lang.getString(e.getPlayer().getLocale().toString() +"_"+"Bossbar").replace("%p", e.getPlayer().getName()), c.getInt("bossbarpoints"));
						
						}
						if(MultiLobbyManager.lobbyworlds.contains(e.getPlayer().getLevel().getName())) {
					de.buddelbubi.api.player.giveHotbar(e.getPlayer());
						}
					}
				}
			}, 20);
		
		
	}
}, 2);
}
		if(c.getBoolean("alwaysspawn") && !c.getBoolean("multilobby")) {
			Config loc = new Config(new File(Server.getInstance().getPluginPath() +"/LobbyNK", "locations.yml"));
			String world = "";
			if(MultiLobbyManager.lobbyworlds.isEmpty() && c.getBoolean("multiworld")) {
				Server.getInstance().getLogger().critical("§4No lobbyworlds found. Please add a lobbyworld");
				return;
			}
			if(c.getBoolean("multilobby")) {world = "." + MultiLobbyManager.getLobby();}
		
			if(loc.getString("spawn.world"+world) != null) {
				try {
					
				
			double x = loc.getDouble("spawn.x"+world);
			double y = loc.getDouble("spawn.y"+world);
			double z = loc.getDouble("spawn.z"+world);
			float yaw = (float) loc.getDouble("spawn.yaw"+world);
			float pitch = (float) loc.getDouble("spawn.pitch"+world);
			Level le = Server.getInstance().getLevelByName(loc.getString("spawn.world"+world));
			Location tp = new Location(x,y,z,yaw,pitch,le);
			
			if(c.getBoolean("alwaysspawn")) e.setRespawnPosition(tp);
			
					
					
				if(c.getBoolean("fireworkonspawn"))	de.buddelbubi.api.spawnFirework.spawnFirework(e.getPlayer());
					
		
				} catch (Exception e2) {
					System.out.print("[LobbyNK] >>>> Missing SpawnLocation for this world! Please do /lobby set spawn in world "+ world);
				}
		}else {System.out.println("LobbyNK | Error orrupted: No spawnlocation");
		e.getPlayer().teleport(e.getPlayer().getLevel().getSpawnLocation());
		} } else {
			if(!c.getBoolean("multiworld") || MultiLobbyManager.lobbyworlds.contains(e.getPlayer().getLevel().getName())) 
			de.buddelbubi.api.spawnFirework.spawnFirework(e.getPlayer());
		}
		if(c.getBoolean("multilobby")) {
			
			Config loc = new Config(new File(Server.getInstance().getPluginPath() +"/LobbyNK", "locations.yml"));
			String world = "";
			if(MultiLobbyManager.lobbyworlds.isEmpty() && c.getBoolean("multiworld")) {
				Server.getInstance().getLogger().critical("§4No lobbyworlds found. Please add a lobbyworld");
				return;
			}
			if(c.getBoolean("multilobby")) {world = "." + MultiLobbyManager.getLobby();}
		
			if(loc.getString("spawn.world"+world) != null) {
				try {
					
				
			double x = loc.getDouble("spawn.x"+world);
			double y = loc.getDouble("spawn.y"+world);
			double z = loc.getDouble("spawn.z"+world);
			float yaw = (float) loc.getDouble("spawn.yaw"+world);
			float pitch = (float) loc.getDouble("spawn.pitch"+world);
			Level le = Server.getInstance().getLevelByName(loc.getString("spawn.world"+world));
			Location tp = new Location(x,y,z,yaw,pitch,le);
		//	if(c.getBoolean("alwaysspawn")) e.getPlayer().teleport(tp);
			if(c.getBoolean("alwaysspawn")) e.setRespawnPosition(tp);
				}catch (Exception ex) {
					// TODO: handle exception
				}}
Server.getInstance().getScheduler().scheduleDelayedTask(Server.getInstance().getPluginManager().getPlugin("LobbyNK"), new Runnable() {
				
				@Override
				public void run() {
					
					if(c.getBoolean("alwaysspawn")) {
						
					player.toSpawn(e.getPlayer());
					}
					de.buddelbubi.api.spawnFirework.spawnFirework(e.getPlayer());
					
				}
			}, 30);
		}
		
	}

}
