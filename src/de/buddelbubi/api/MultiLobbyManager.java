package de.buddelbubi.api;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import cn.nukkit.Server;
import cn.nukkit.level.Level;
import cn.nukkit.level.Location;
import cn.nukkit.utils.Config;

public class MultiLobbyManager {

	
	public static List<String> lobbyworlds = new ArrayList<>();
	public static Map<String, String> lobbyservers = new HashMap<String, String>();
	
 	
	public static void registerAllLobbyworlds() {
		
		Config loc = new Config(new File(Server.getInstance().getPluginPath() + "/LobbyNK", "locations.yml"));
		if(de.buddelbubi.Lobbynk.config.getBoolean("multilobby-useallworlds")) {
			for(Level s : Server.getInstance().getLevels().values()) {
				
					lobbyworlds.add(s.getName());
					
					
				
			}
		} else {
		for(String s : loc.getKeys()) {
			if(s.contains("spawn.world") && s.contains(loc.getString(s))) {
				lobbyworlds.add(loc.getString(s));
				
			}
		}}
		
		Collections.sort(lobbyworlds);
	}
	
	public static void registerAllLobbyservers() {
		
		Config loc = new Config(new File(Server.getInstance().getPluginPath() + "/LobbyNK", "locations.yml"));
		
		for(String s : loc.getKeys()) {
			
			if(s.startsWith("server.")) {
				if(!lobbyworlds.contains(s.replace("server.", ""))) {
					
					lobbyservers.put(s.replace("server.", ""), loc.getString(s));
					
					
				} else Server.getInstance().getLogger().alert("§cLobbyNK >>> Lobbyworld and Lobbyserver are called the same way. Lobbyworld overwrites server! §e(" + s.replace("server.", "") + ")");
				
			}
			
		}
		
		
		
	}
	public static String getLobby() {
		if(lobbyworlds.size() == 0) return "nosetup";
		for(String s : lobbyworlds) {
			if(s.startsWith("VIP-")) continue;
			
			try {
				if(Server.getInstance().getLevelByName(s).getPlayers().size() < de.buddelbubi.Lobbynk.config.getInt("maxplayersperlobby")) {
					
					return s;
					
				} 
			} catch (Exception e) {
				Server.getInstance().getLogger().critical("§4LOBBY WORLD DELETED!!! Please remove it from your locations.yml");
				lobbyworlds.remove(s);
				
			}
		}
		
	
		return "error";
		
	}
}
