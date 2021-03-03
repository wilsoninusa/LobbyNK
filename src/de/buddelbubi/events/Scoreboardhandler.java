package de.buddelbubi.events;

import java.io.File;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.utils.Config;
import de.buddelbubi.api.ConfigNK;
import de.buddelbubi.api.ScoreboardAPI;
import de.buddelbubi.implementedcode.network.DisplaySlot;
import de.buddelbubi.implementedcode.network.Scoreboard;
import de.buddelbubi.implementedcode.network.ScoreboardDisplay;

public class Scoreboardhandler{
	
/*	static int frame = 1;
	static Scoreboard sco = ScoreboardAPI.createScoreboard();
public static void scoreHandler() {
	
	ConfigNK c = de.buddelbubi.Lobbynk.config;
	ConfigNK sc = de.buddelbubi.Lobbynk.scoreboard;
	
	if(c.getBoolean("scoreboard")) {
		for(int i = 1; i == c.getInt("scoreboardframes"); i++) {
			
			if(sc.get("Frame" + i + ".title") == null) {
				sc.set("Frame"+ i +".title", "§l§cLobbyNK by Buddelbubi");
			}if(sc.get("Frame" + i + ".line1") == null) {
				sc.set("Frame"+ i +".line1", "§r");
			}if(sc.get("Frame" + i + ".line2") == null) {
				sc.set("Frame"+ i +".line2", "§7Welcome on NukkitX");
			}if(sc.get("Frame" + i + ".line3") == null) {
				sc.set("Frame"+ i +".line3", "§r");
			}if(sc.get("Frame" + i + ".line4") == null) {
				sc.set("Frame"+ i +".line4", "§cPlease rate LobbyNK");
			}if(sc.get("Frame" + i + ".line5") == null) {
				sc.set("Frame"+ i +".line5", "§cWith 5 stars ;D");
			}if(sc.get("Frame" + i + ".line6") == null) {
				sc.set("Frame"+ i +".line6", "");
			}if(sc.get("Frame" + i + ".line7") == null) {
				sc.set("Frame"+ i +".line7", "");
			}if(sc.get("Frame" + i + ".line8") == null) {
				sc.set("Frame"+ i +".line8", "");
			}if(sc.get("Frame" + i + ".line9") == null) {
				sc.set("Frame"+ i +".line9", "");
			}if(sc.get("Frame" + i + ".line10") == null) {
				sc.set("Frame"+ i +".line10", "");
			}
			
		}
		sc.save();
		loadScoreboard();
		
		
	}
}
public static void loadScoreboard() {
	ConfigNK c = de.buddelbubi.Lobbynk.config;
	ConfigNK sc = de.buddelbubi.Lobbynk.scoreboard;
	Server.getInstance().getScheduler().scheduleDelayedTask(Server.getInstance().getPluginManager().getPlugin("LobbyNK"), new Runnable() {
		
		@Override
		public void run() {
			
			ScoreboardDisplay scd = sco.addDisplay(DisplaySlot.SIDEBAR, "RESTART SERVER", sc.getString("Frame" + frame + ".title"));
			scd.addLine(sc.getString("Frame" + frame + ".line1"), 0);
			scd.addLine(sc.getString("Frame" + frame + ".line2"), 1);
			scd.addLine(sc.getString("Frame" + frame + ".line3"), 2);
			scd.addLine(sc.getString("Frame" + frame + ".line4"), 3);
			scd.addLine(sc.getString("Frame" + frame + ".line5"), 4);
			scd.addLine(sc.getString("Frame" + frame + ".line6"), 5);
			scd.addLine(sc.getString("Frame" + frame + ".line7"), 6);
			scd.addLine(sc.getString("Frame" + frame + ".line8"), 7);
			scd.addLine(sc.getString("Frame" + frame + ".line9"), 8);
			scd.addLine(sc.getString("Frame" + frame + ".line10"), 9);
			if(frame == c.getInt("scoreboardframes")) {
				frame = 0;
			}
			frame++;
			for(Player p : Server.getInstance().getOnlinePlayers().values()) {
				sco.hideFor(p);
				de.buddelbubi.api.ScoreboardAPI.setScoreboard(p, sco);
				sco.showFor(p);
			}
			
		}
		
	}, 10);
	loadScoreboard();
}
*/
}
