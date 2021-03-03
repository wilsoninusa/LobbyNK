package de.buddelbubi.api;



import java.util.HashMap;
import java.util.Map;

import cn.nukkit.Player;
import de.buddelbubi.implementedcode.network.DisplaySlot;
import de.buddelbubi.implementedcode.network.Scoreboard;
import de.buddelbubi.implementedcode.network.ScoreboardDisplay;

public class scoreb {
	
	public static Map<String, Scoreboard> sbs = new HashMap<>();
	
	static Scoreboard sc = ScoreboardAPI.createScoreboard();
	
	public static void setScoreboard(Player p) {
		sbs.get(p.getName()).showFor(p);
		
	}
	public static void hideScoreboard(Player p) {
		if(sbs.containsKey(p.getName())) {
		sbs.get(p.getName()).hideFor(p);
		} else loadScoreboard(p);
		
	}
	
	
	public static void loadScoreboard(Player p) {
		
		
		Scoreboard sc = ScoreboardAPI.createScoreboard();
		ScoreboardDisplay scd = sc
				.addDisplay
				(DisplaySlot.SIDEBAR, 
						"dumy",
						de.buddelbubi.Lobbynk.lang.getString(p.getLocale().toString() + "_"+ "Scoreboard.Header"));
		
		for(int i = 0; i < 10; i++) {
			scd.addLine(de.buddelbubi.Lobbynk.lang.getString(p.getLocale().toString() + "_"+ "Scoreboard.Line" + (i+1)).replace("%player", p.getName()), i);
		
		}
		if(sbs.containsKey(p.getName())) {
			sbs.get(p.getName()).hideFor(p);
			sbs.remove(p.getName());
			
		}
		sbs.put(p.getName(), sc);
		
		
	}
	
}

