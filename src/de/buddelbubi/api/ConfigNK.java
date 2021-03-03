package de.buddelbubi.api;

import java.util.HashMap;
import java.util.Map;

import cn.nukkit.Server;
import net.minidev.json.JSONObject;

public class ConfigNK {

	HashMap<String, Object> data;
	
	public ConfigNK() {
		this.data = new HashMap<String, Object>();
	}
	public ConfigNK(Map map) {
		this.data = new HashMap<String, Object>(map);
		try {
			
	
		for(String key : data.keySet()) {
			
			data.put(key, (Object) data.get(key).toString().replace("&", "§"));
		}
		} catch (Exception e) {
			e.printStackTrace();
			
			Server.getInstance().getLogger().info("Please send this error code in the LobbyNK discussion tab. (Not reviews) - https://cloudburstmc.org/threads/lobbynk.623/\nDiscord would work as well: Buddelbubi#5018");
			
			Server.getInstance().getLogger().error("One of your LobbyNK Config Files is orrupted!!! Please reset your config files.");
			System.exit(1);
			
		}
	}
	
	public boolean has(String key) {
		if(this.data.containsKey(key)) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getInt(String key) {
		try {
		return Integer.valueOf((String) this.data.get(key));
		} catch (Exception e) {
			Server.getInstance().getLogger().warning("§4Your option §c" + key +" §4is orrupted or not an integer!");
			return 0;
			
		}
		
	}
	public Map getAll() {
		return this.data;
	}
	public JSONObject getJson() {
		return new JSONObject(this.data);
	}
	public Object get(String key) {
		return this.data.get(key);
		
	}
	
	public String getString(String key) {
		MultiLobbyManager.lobbyworlds.remove("");
		return String.valueOf(this.data.get(key));
		
	}
	public boolean getBoolean(String key) {
		if(this.data.get(key).toString().equals("true")) {
			return true;
		} else if(this.data.get(key).toString().equals("false")) {
			return false;
		} else {
			System.out.print("Error while reading boolean: " + data.get(key));
			return false;
		}
		
	}
	public void remove(String key) {
		this.data.remove(key);
	}

	public double getDouble(String key) {
		// TODO Auto-generated method stub
		return Double.parseDouble(this.data.get(key).toString());
	}
	public void set(String key, Object obj) {
		this.data.put(key, obj);
	}
	public void save() {
		
	}
	public boolean exists(String string) {
		if(this.data.containsKey(string)) {
			return true;
		} else
		return false;
	}
}
