package de.buddelbubi.setup;

import cn.nukkit.Player;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.window.FormWindowSimple;

public class MainSetup {

	
	public static void startSetup(Player p) {
		
		FormWindowSimple fw = new FormWindowSimple("§cWelcome to the Setup of LobbyNK", "§7Lets get started. Which configuration do you want to change?");
		fw.addButton(new ElementButton("Config.yml"));
		p.showFormWindow(fw);
		de.buddelbubi.setup.SetupEventManager.isp = true;
		
		
	}
	
	
}
