package de.buddelbubi.setup;

import java.io.File;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.element.Element;
import cn.nukkit.form.element.ElementInput;
import cn.nukkit.form.element.ElementSlider;
import cn.nukkit.form.element.ElementToggle;
import cn.nukkit.form.response.FormResponse;
import cn.nukkit.form.window.FormWindow;
import cn.nukkit.form.window.FormWindowCustom;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.utils.Config;
import net.minidev.json.JSONObject;

public class SetupEventManager implements Listener {
	public static int step =0;
	public static boolean isp = false;
	public static String sstring = "";
	public static int windowid = 0;
	Config c = new Config(new File(Server.getInstance().getPluginManager().getPlugin("LobbyNK").getDataFolder(), "config.yml"));

	
	@EventHandler
	public void onFormResponse(PlayerFormRespondedEvent e) {
		try {
			
	
		Player p = e.getPlayer();
		
		
		
		if(e.getWindow() instanceof FormWindowSimple) {
		sstring = "config";
		
			FormWindowCustom fw = new FormWindowCustom("§cConfig.yml" + "§7Edit your main Config");
			
			for(String s : c.getKeys()) {
				if(s.equalsIgnoreCase("Configversion")) continue;
				if(c.isBoolean(s)) {
						fw.addElement(new ElementToggle("§e"+ s, c.getBoolean(s)));
					
				} else if(c.isInt(s)){
					if(c.getInt(s) <= 10) {
						fw.addElement(new ElementSlider("§e"+s, 0, 10, 1,c.getInt(s)));
					} else if(c.getInt(s) <= 100) {
						fw.addElement(new ElementSlider("§e"+s, 0, 100, 1, c.getInt(s)));
					} else if(c.getInt(s) <= 10000) {
						fw.addElement(new ElementSlider("§e"+s, 0, 10000, 10, c.getInt(s)));
					} else fw.addElement(new ElementInput("§e" +s , c.getInt(s) + ""));
				} else {
					fw.addElement(new ElementInput("§e" +s , c.getString(s)));
				}
			}
			p.showFormWindow(fw);
		} else {
			
			FormWindowCustom f = (FormWindowCustom) e.getWindow();
		for(int i = 0; i <= f.getResponse().getResponses().size(); i++) {
			Object response = f.getResponse().getResponses().get(i);
		
			
			
			
		}
			
			
		}
		
		} catch (Exception e2) {
			
		}
		}
	
	

	
	
	
}
