package de.buddelbubi.events;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.defaults.GamemodeCommand;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerTeleportEvent;
import cn.nukkit.inventory.Inventory;
import cn.nukkit.item.Item;
import cn.nukkit.level.Level;
import cn.nukkit.level.Sound;
import cn.nukkit.math.Vector3;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.DummyBossBar;
import de.buddelbubi.api.ConfigNK;
import de.buddelbubi.api.MultiLobbyManager;
import de.buddelbubi.api.scoreb;

public class onTeleport implements Listener{
	
	
	public static Map<String, Map<Integer, Item>> invs = new HashMap<String, Map<Integer, Item>>();
	public static Map<String, Integer> xp = new HashMap<String, Integer>(); 
	public static Map<String, Integer> level = new HashMap<String, Integer>(); 
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onTeleport(PlayerTeleportEvent e) {
		ConfigNK c = de.buddelbubi.Lobbynk.config;
		ConfigNK s = de.buddelbubi.Lobbynk.saves;
		if(e.isCancelled()) return;
		if(c.getBoolean("multiworld")) {
			if(MultiLobbyManager.lobbyworlds.contains(e.getTo().getLevel().getName()) && !MultiLobbyManager.lobbyworlds.contains(e.getFrom().getLevel().getName())) {
				if(e.getPlayer().getGamemode() != 1) {
				de.buddelbubi.events.onTeleport.xp.put(e.getPlayer().getName(), e.getPlayer().getExperience());
				de.buddelbubi.events.onTeleport.level.put(e.getPlayer().getName(), e.getPlayer().getExperienceLevel());
				
				invs.put(e.getPlayer().getName(), e.getPlayer().getInventory().getContents());
				}
				Level level = e.getTo().getLevel();
				Vector3 vec = new Vector3(e.getTo().getX(), e.getTo().getY(), e.getTo().getZ());
				if(c.getBoolean("soundeffects")) {
				level.addSound(vec, Sound.MOB_SHULKER_TELEPORT, 1, 1, Collections.singletonList(e.getPlayer()));
				}
				if(c.getBoolean("scoreboard")) {
					if(scoreb.sbs.containsKey(e.getPlayer())) {
				scoreb.setScoreboard(e.getPlayer());
					} else {
						
						scoreb.loadScoreboard(e.getPlayer());
						scoreb.setScoreboard(e.getPlayer());
					}
					
				}
				de.buddelbubi.api.player.giveHotbar(e.getPlayer());
				
			
				
			} else {
				if(s.getAll().containsKey(e.getPlayer().getName() + ".hidden")) {
					if(s.getBoolean(e.getPlayer().getName() + ".hidden")) {
					s.set(e.getPlayer().getName() + ".hidden", false);
				for(Player o : Server.getInstance().getOnlinePlayers().values()) {
					
					e.getPlayer().showPlayer(o);
				}}
				}
				
				
				
				if(c.getBoolean("multiworldSaveInventory") && MultiLobbyManager.lobbyworlds.contains(e.getFrom().getLevel().getName()) && !MultiLobbyManager.lobbyworlds.contains(e.getTo().getLevel().getName())) {
					if(invs.containsKey(e.getPlayer().getName())) {
					e.getPlayer().getInventory().clearAll();
				e.getPlayer().getInventory().setContents(invs.get(e.getPlayer().getName()));
				e.getPlayer().setExperience(de.buddelbubi.events.onTeleport.xp.get(e.getPlayer().getName()), de.buddelbubi.events.onTeleport.level.get(e.getPlayer().getName()));
				e.getPlayer().getInventory().sendContents(e.getPlayer());
					} else {
						e.getPlayer().getInventory().clearAll();
					
					}
					
					
				}
if(MultiLobbyManager.lobbyworlds.contains(e.getFrom().getLevel().getName()) && !MultiLobbyManager.lobbyworlds.contains(e.getTo().getLevel().getName())) {				
				e.getPlayer().setGamemode(Server.getInstance().getDefaultGamemode());
				e.getPlayer().setMaxHealth(20);
				e.getPlayer().setHealth(20);
				e.getPlayer().setAllowFlight(false);
				e.getPlayer().removeAllEffects();
				if(c.getBoolean("scoreboard")) {
					if(scoreb.sbs.containsKey(e.getPlayer())) {
					scoreb.hideScoreboard(e.getPlayer());
					} else {
						scoreb.loadScoreboard(e.getPlayer());
						scoreb.hideScoreboard(e.getPlayer());
					}
					}
		
			
				for(DummyBossBar b : e.getPlayer().getDummyBossBars().values()) {
					b.destroy();
				}
}
				
				
			}
		} else {
		
			Level level = e.getTo().getLevel();
			Vector3 vec = new Vector3(e.getTo().getX(), e.getTo().getY(), e.getTo().getZ());
			if(c.getBoolean("soundeffects") && e.getPlayer().spawned) {
				Server.getInstance().getScheduler().scheduleDelayedTask(new Runnable() {
					@Override
					public void run() {
						try {
							
						
						level.addSound(vec, Sound.MOB_SHULKER_TELEPORT, 1, 1, Collections.singletonList(e.getPlayer()));} catch (Exception e) {
							
						}
					}	}, 5);
			
			}
		}
	}

}
