package de.buddelbubi.setup;

import java.io.File;
import java.io.InputStream;
import java.util.LinkedHashMap;

import cn.nukkit.Server;
import cn.nukkit.item.Item;
import cn.nukkit.utils.Config;

public class ConfigGenerator {

	
	public static void genConfig() {
		
		
		Server.getInstance().getPluginManager().getPlugin("LobbyNK").saveResource("config.yml");
		Server.getInstance().getPluginManager().getPlugin("LobbyNK").saveResource("hotbar.yml");
		try {
		 new Config(new File(Server.getInstance().getPluginManager().getPlugin("LobbyNK").getDataFolder(), "config.yml"), Config.YAML, new LinkedHashMap<String, Object>() {{
	 			put("Configversion", 0);
             put("Bossbar", true);
             put("NoHunger", true);
             put("NoDamage", true);
             put("spawnprotection", true);
             put("CompassImages", true);
             put("Gamesamount", 8);
             put("Gamemode", 2);
             put("MaxPetSize", 20);
             put("Inventorychange", false);
             put("Joinquitmessage", true);
             put("Jointitle", true);
             put("multiworld", false);
             put("multilobby", true);
             put("multilobby-useallworlds", false);
             put("maxplayersperlobby", 24);
             put("multiworldSaveInventory", true);
             put("Teleporttitle", true);
             put("Teleportchat", true);
             put("disableWeather", true);
             put("disableInteract", true);
             put("timelock", true);
             put("time", 7000);
             put("maxHealth", 1);
             put("jumppadblock", 133);
             put("Chatsystem", true);
             put("Level", 2020);
             put("scoreboard", true);
             put("alwaysspawn", true);
             put("fireworkonspawn", true);
             put("bossbarpoints", 100);
             put("soundeffects", true);
             put("NoExplosions", true);
             put("DeviceDisplay", true);
             put("language", "english");
             put("multilanguage", true);
          
         }
});

		} catch (Exception e) {
			Server.getInstance().getLogger().critical("§cAn LobbyNK File is corrupted: config.yml");
			System.exit(1);
		}
try {
new Config(new File(Server.getInstance().getPluginManager().getPlugin("LobbyNK").getDataFolder(), "images.yml"), Config.YAML, new LinkedHashMap<String, Object>() {{
 put("Slot1", "textures/items/diamond.png");
 put("Slot2", "textures/items/iron_ingot.png");
 put("Slot3", "textures/items/gold_ingot.png");
 put("Slot4", "textures/items/emerald.png");
 put("Slot5", "textures/items/coal.png");
 put("Slot6", "textures/items/glowstone_dust.png");
 put("Slot7", "textures/items/book_enchanted.png");
 put("Slot8", "textures/items/nether_star.png");
 put("Slot1.mode", "path");
 put("Slot2.mode", "path");
 put("Slot3.mode", "path");
 put("Slot4.mode", "path");
 put("Slot5.mode", "path");
 put("Slot6.mode", "path");
 put("Slot7.mode", "path");
 put("Slot8.mode", "path"); 
 put("serverpicture", "textures/ui/servers.png");
 put("currentlobby", "textures/persona_thumbnails/alex_hair_thumbnail_0.png");
 put("fulllobby", "textures/items/dye_powder_red.png");
 put("nonfulllobby", "textures/items/dye_powder_lime.png");
 put("INFO!", "You may change change to custom images using a server resourcepack!");

}
});

} catch (Exception e) {
	Server.getInstance().getLogger().critical("§cAn LobbyNK File is corrupted: images.yml");
	System.exit(1);
}
try {
new Config(new File(Server.getInstance().getPluginManager().getPlugin("LobbyNK").getDataFolder(), "hotbar.yml"), Config.YAML, new LinkedHashMap<String, Object>() {{
		   put("configversion", 2);
        put("Slot1.Item", "404:0");
        put("Slot1.Itemname", "&cSettings");
        put("Slot2.Item", "369:0");
        put("Slot2.Itemname", "&aHide players");
        put("Slot3.Item", "160:8");
        put("Slot3.Itemname", "");
        put("Slot4.Item", "160:8");
        put("Slot4.Itemname", "");
        put("Slot5.Item", "345:0");
        put("Slot5.Itemname", "&cNavigator");
        put("Slot6.Item", "160:8");
        put("Slot6.Itemname", "");
        put("Slot7.Item", "160:8");
        put("Slot7.Itemname", "");
        put("Slot8.Item", "54:0");
        put("Slot8.Itemname", "&eGadgets");
        put("Slot9.Item", "399:0");
        put("Slot9.Itemname", "&bLobbySelector");
        
        //VIP
        
        put("Slot1.VIP.Item", "404:0");
        put("Slot1.VIP.Itemname", "&cSettings");
        put("Slot2.VIP.Item", "369:0");
        put("Slot2.VIP.Itemname", "&aHide players");
        put("Slot3.VIP.Item", "46:0");
        put("Slot3.VIP.Itemname", "&cSilentLobby");
        put("Slot4.VIP.Item", "160:8");
        put("Slot4.VIP.Itemname", "");
        put("Slot5.VIP.Item", "345:0");
        put("Slot5.VIP.Itemname", "&cNavigator");
        put("Slot6.VIP.Item", "160:8");
        put("Slot6.VIP.Itemname", "");
        put("Slot7.VIP.Item", "381:0");
        put("Slot7.VIP.Itemname", "&2Forcefield");
        put("Slot8.VIP.Item", "54:0");
        put("Slot8.VIP.Itemname", "&eGadgets");
        put("Slot9.VIP.Item", "399:0");
        put("Slot9.VIP.Itemname", "&bLobbySelector");
        //triggerItems
        put("CompassItem", "345:0");
        put("HidePlayerItem", "369:0");
        put("GadgetsItem", "54:0");
        put("LobbyItem", Item.NETHER_STAR + ":0");
        put("SettingsItem", Item.COMPARATOR + ":0");
        put("ForcefieldItem", Item.ENDER_EYE + ":0");
        put("SilentlobbyItem", Item.TNT + ":0");
        put("FriendItem", Item.SKULL + ":3");
        

     }
});
	} catch (Exception e) {
		Server.getInstance().getLogger().critical("§cAn LobbyNK File is corrupted: horbar.yml");
		System.exit(1);
	}
try {
	new Config(new File(Server.getInstance().getPluginManager().getPlugin("LobbyNK").getDataFolder(), "compasscommands.yml"), Config.YAML, new LinkedHashMap<String, Object>() {{
     put("Slot1.command", "none");
     put("Slot2.command", "none");
     put("Slot3.command", "none");
     put("Slot4.command", "none");
     put("Slot5.command", "none");
     put("Slot6.command", "none");
     put("Slot7.command", "none");
     put("Slot8.command", "none");
     put("Slot1.disableloc", false);
     put("Slot2.disableloc", false);
     put("Slot3.disableloc", false);
     put("Slot4.disableloc", false);
     put("Slot5.disableloc", false);
     put("Slot6.disableloc", false);
     put("Slot7.disableloc", false);
     put("Slot8.disableloc", false);
     put("Information", "Change none to your command without slash.");
    
 }
});
} catch (Exception e) {
	Server.getInstance().getLogger().critical("§cAn LobbyNK File is corrupted: compasscommands.yml");
	System.exit(1);
}
	try {
		

	new Config(new File(Server.getInstance().getPluginManager().getPlugin("LobbyNK").getDataFolder(), "chat.yml"), Config.YAML, new LinkedHashMap<String, Object>() {{
		 put("Owner", "&4Owner &8: &7%p &8>> &7 %msg");
		 put("Admin", "&4Admin &8: &7%p &8>> &7 %msg");
		 put("Developer", "&bDeveloper &8: &7%p &8>> &7 %msg");
		 put("Moderator", "&cModerator &8: &7%p &8>> &7 %msg");
		 put("Builder", "&eBuilder &8: &7%p &8>> &7 %msg");
		 put("Supporter", "&2Supporter &8: &7%p &8>> &7 %msg");
		 put("Youtuber", "&5Youtuber &8: &7%p &8>> &7 %msg");
		 put("Premium", "&6Premium &8: &7%p &8>> &7 %msg");
		 put("Custom1", "&1Custom1 &8: &7%p &8>> &7 %msg");
		 put("Custom2", "&1Custom2 &8: &7%p &8>> &7 %msg");
		 put("Custom3", "&1Custom3 &8: &7%p &8>> &7 %msg");
		 put("Default", "&7%p >> %msg");

		}
		});
	} catch (Exception e) {
		Server.getInstance().getLogger().critical("§cAn LobbyNK File is corrupted: chat.yml");
		System.exit(1);
	}
Config en = new Config(new File(Server.getInstance().getPluginManager().getPlugin("LobbyNK").getDataFolder() + "/lang", "english.yml"));
en.save();

try {
new Config(new File(Server.getInstance().getPluginManager().getPlugin("LobbyNK").getDataFolder() + "/lang", "german.yml"), Config.YAML, new LinkedHashMap<String, Object>() {{
	
	put("languagecode", "de");
	put("Joinprefix", "&8[&a+&8] &7%p");
	put("Quitprefix", "&8[&c-&8] &7%p");
	put("FirstjoinMessage", "&6%p&a spielt das erste mal hier");
	put("Jointitle1", "&a&lWillkommen");
	put("Jointitle2", "&2%p");
	put("nopermission", "&cKeine Rechte");
 put("Bossbar", "&eDies kannst du in german.yml ändern");
 put("Compass.name", "&cKompass");
 put("Compass.subtitle", "&cWähle dein Spiel");
 put("Compass.Slot1", "&eSlot1");
 put("Compass.Slot2", "&eSlot2");
 put("Compass.Slot3", "&eSlot3");
 put("Compass.Slot4", "&eSlot4");
 put("Compass.Slot5", "&eSlot5");
 put("Compass.Slot6", "&eSlot6");
 put("Compass.Slot7", "&eSlot7");
 put("Compass.Slot8", "&eSlot8");
 put("Playerhider.name", "&eVerstecke Spieler");
 put("Chest.name", "&bEffekte");
 put("Chest.subtitle", "&bWähle einen Effekt aus");
 put("Locations.Set", "&aErfolgreich &6%loc &agesetzt");
 put("Locations.Teleport.Chat", "&aDu wurdest zu %game &ateleportiert");
 put("Locations.Teleport.Title", "&eDu bist nun bei &6%game");
 put("Locations.Teleport.missing", "&cDiese Location wurde bisher noch nicht gesetzt");
 put("Build.true.own", "&aDu kannst nun bauen/abbauen");
 put("Build.false.own", "&aDu kannst nicht länger bauen");
 put("Build.true.other", "&6%p &akann nun bauen/abbauen");
 put("Build.false.other", "&6%p &akann nicht länger bauen/abbauen");
 put("Build.notallowed", "");
 put("Playeronly", "&cNur Spieler können das tun");
 put("Playeroffline", "&cDieser Spieler ist nicht online");
 put("Help", "&8[&fLobby&cNK&8] &7 >> &fDieser Befehl wurde nicht gefunden. Gehe bitte auf unsere Seite und lies die Beschreibung: &chttps://nukkitx.com/resources/lobbynk.380/");
 put("spawn.tp", "&aDu wurdest zum Spawn teleportiert");
 put("spawn.set", "&aSpawn erfolgreich gesetzt");
 put("playershider.hideall", "&aVerstecke jeden");
 put("playershider.hidevip", "&5Verstecke jeden außer VIP`s");
 put("playershider.hidenoone", "&cVerstecke niemanden");
 put("playershider.name", "&eSpieler verstecken");
 put("playershider.hidenall", "&aNanu.. Wo sind denn alle hin? Du hast alle Spieler verschwinden lassen :O");
 put("playershider.hidenvip", "&aJeder, von &5VIP's &aabgesehen ist nun versteckt");
 put("playershider.hidennoone", "&aJeder ist wieder sichtbar :D");
 put("Effectselected", "&aDu hat nun den Effekt &e%effect");
 put("Effectremoved", "&cDu hat nun den Effekt &e%effect &centfernt");
 put("Chest.Walkingparticles", "&ePartickel");
 put("Chest.Pets", "&eHaustiere");
 put("Pet.nametag", "&e%player's Haustier");
 put("Chest.Petsettings", "&eHaustiereinstellungen");
 put("Chest.Pet.chicken", "&eHuhn");
 put("Chest.Pet.cow", "&eKuh");
 put("Chest.Pet.pig", "&eSchwein");
 put("Chest.Pet.sheep", "&eSchaf");
 put("Chest.Pet.squid", "&eTintenfisch");
 put("Chest.Pet.polarbear", "&eEisbär");
 put("Chest.Pet.cat", "&eKatze");
 put("Chest.Pet.dog", "&eHund");
 put("Chest.Pet.parrot", "&ePapagei");
 put("Chest.Pet.llama", "&eLama");
 put("Chest.Pet.donkey", "&eEsel");
 put("Chest.Pet.horse", "&ePferd");
 put("Chest.Pet.zombiehorse", "&eZombiepferd");
 put("Chest.Pet.skeletonhorse", "&eSkelettpferd");
 put("Chest.Pet.fish", "&eFisch");
 put("Chest.Pet.turtle", "&eSchildkröte");
 put("Chest.Pet.dolphin", "&eDelfin");
 put("Chest.Pet.panda", "&ePanda");
 put("Chest.Pet.wither", "&eGeladener Wither");
 put("Chest.Pet.zombie", "&eZombie Pet");
 put("Chest.Pet.skeleton", "&eSkelett Pet");
 put("Chest.Pet.spider", "&eSpinnen Haustier");
 put("Chest.Pet.cavespider", "&eHöhlenspinnen Haustier");
 put("Chest.Pet.creeper", "&eCreeper Pet");
 put("Chest.Pet.slime", "&eSlime");
 put("Chest.Pet.ghast", "&eGhast");
 put("Chest.Pet.guardian", "&eWächter");
 put("Chest.Pet.stray", "&eEiswanderer");
 put("Chest.Pet.witch", "&eHexe");
 put("Chest.Pet.blaze", "&eBlaze");
 put("Chest.Pet.hoglin", "&eHoglin");
 put("Chest.Pet.piglin", "&ePiglin");
 put("Chest.Pet.zoglin", "&eZoglin");
 put("Chest.Pet.strider", "&eStrider");
 put("Chest.Pet.phantom", "&ePhantom");
 put("Chest.Pet.villager", "&eDorfbewohner");
 put("Chest.Pet.enderman", "&eEnderman");
 // put("Chest.Pet.enderdragon", "&eEnderdrache");
 put("Chest.Pet.settings.name", "&eName");
 put("Chest.Pet.settings.size", "&eGröße");
 put("Chest.Cosmetics", "&eKleiderschrank");
 put("Chest.cosmetic.netherite", "&eNetherite");
 put("Chest.cosmetic.diamond", "&eDiamant");
 put("Chest.cosmetic.iron", "&eEisen");
 put("Chest.cosmetic.chainmail", "&eKetten");
 put("Chest.cosmetic.gold", "&eGold");
 put("Chest.cosmetic.leather", "&eLeder");
 put("Chest.cosmetic.other", "&eAnderes");
 put("Chest.cosmetic.enchant", "&eVerzaubern");
 put("Chest.cosmetic.dye", "§eFärben");
 put("Chest.cosmetic.helmet", "&ehelm");
 put("Chest.cosmetic.chestplate", "&ebrustplatte");
 put("Chest.cosmetic.leggings", "&ehose");
 put("Chest.cosmetic.boots", "&eschuhe");
 put("Chest.cosmetic.skull", "&eSchädel");
 put("Chest.cosmetic.wither", "&eWither");
 put("Chest.cosmetic.zombie", "&eZombie");
 put("Chest.cosmetic.player", "&eSteve");
 put("Chest.cosmetic.creeper", "&eCreeper");
 put("Chest.cosmetic.dragon", "&eEnderdrache");
 put("Chest.cosmetic.shell", "&eSchildkrötenpanzer");
 put("Chest.cosmetic.elytra", "&eElytra");
 put("Chest.cosmetic.equipped", "&aDu hast nun &e%cosmetic &aangezogen");
 put("Chest.cosmetic.nothingequipped", "&cDu hast keine Rüstung an");
 put("Chest.cosmetic.removed", "&cDu hast &e%cosmetic &causgezogen");
 put("Chest.remove_everything", "&cDu hast alles Entfernt");
 put("Chest.remove", "&cEffekte entfernen");
 put("Chest.walking.angry", "&eSauer");
 put("Chest.walking.bonemeal", "&eKnochenmehl");
 put("Chest.walking.bubble", "&eBlase");
 put("Chest.walking.flame", "&eFlamme");
 put("Chest.walking.explode", "&eExplosionsrauch");
 put("Chest.walking.heart", "&eHerzen");
 put("Chest.walking.redstone", "&eRedstone");
 put("Chest.walking.ink", "&eTinte");
 put("Chest.walking.note", "&eNote");
 put("Chest.walking.ink", "&eTinte");
 put("Chest.effects", "&eEffekte");
 put("Chest.effect.speed", "&eSchnelligkeit");
 put("Chest.effect.jumpboost", "&eJump Boost");
 put("Chest.effect.levitation", "&eSchweben");
 put("Chest.effect.invisibility", "&eUnsichtbarkeit");
 put("Chest.effect.blindness", "&eBlindheit");
 put("Chest.effect.nausea", "&eÜbelkeit");
	put("Chest.effect.nightvision", "&eNachtsicht");
 put("Chat.cleared", "&eDer Chat wurde von &c%player geleert");
 put("Scoreboard.Header", "&c&lLobbyNK von Buddelbubi");
 put("Scoreboard.Line1", "");
 put("Scoreboard.Line2", "&7Willkommen %player auf einem NukkitX Server");
 put("Scoreboard.Line3", "");
 put("Scoreboard.Line4", "&cBitte bewerte LobbyNK");
 put("Scoreboard.Line5", "&cIm besten Fall mit 5 Sternen");
 put("Scoreboard.Line6", "");
 put("Scoreboard.Line7", "");
 put("Scoreboard.Line8", "");
 put("Scoreboard.Line9", "");
 put("Scoreboard.Line10", "");
 put("lobbyselector", "&9Wähle deine Lobby aus");
 put("lobbyselector.prefix", "&b");
 put("lobbyselector.vipprefix", "&e");
 put("lobbyselector.serverprefix", "&a");
 put("Lobbyselector.Playercounter", "&e(%inlobby/%maxlobby)");
put("serveradded", "&aLobbyserver &e%servername (%address) &aerfolgreich hinzugefügt");
 put("everylobbyisfull", "&cEntschuldigung, Aber jede Lobby ist voll..");
 put("fulllobby", "&cEntschuldigung... Aber diese Lobby ist voll..");
 put("lobbyconnected", "&aDu bist nun auf Lobby &e%lobby");
 put("settings", "&cEinstellungen");
 put("settings.fly", "Fliegen");
 put("settings.doublejump", "Doppelsprung");
 put("settings.jumppad", "Jumppad");
 put("settings.forcefield", "Schutzschild");
 put("settings.enabled", "&aDu hast &e%mode &aaktiviert :D");
 put("settings.disabled", "&cDu hast &e%mode &cdeaktiviert...");
 put("sync.success", "&aErfolgreich %copied %overwritten synkronisiert!");
 put("sync.failed", "&cEin Fehler ist beim Synkronisieren aufgetreten");
 
}
});
} catch (Exception e) {
	Server.getInstance().getLogger().critical("§cAn LobbyNK File is corrupted: german.yml");
	System.exit(1);
}
try {
for(File f : new File(Server.getInstance().getPluginManager().getPlugin("LobbyNK").getDataFolder() + "/lang").listFiles()) {
	new Config(f, Config.YAML, new LinkedHashMap<String, Object>() {{
		
		put("languagecode", "en");
		put("Joinprefix", "&8[&a+&8] &7%p");
		put("Quitprefix", "&8[&c-&8] &7%p");
		put("FirstjoinMessage", "&6%p&a is playing first time here");
		put("Jointitle1", "&a&lWelcome");
		put("Jointitle2", "&2%p");
		put("nopermission", "&cYou have no permission to do that...");
	 put("Bossbar", "&eYou can change this in english.yml");
	 put("Compass.name", "&cCompass");
	 put("Compass.subtitle", "&cSelect your game");
	 put("Compass.Slot1", "&eSlot1");
	 put("Compass.Slot2", "&eSlot2");
	 put("Compass.Slot3", "&eSlot3");
	 put("Compass.Slot4", "&eSlot4");
	 put("Compass.Slot5", "&eSlot5");
	 put("Compass.Slot6", "&eSlot6");
	 put("Compass.Slot7", "&eSlot7");
	 put("Compass.Slot8", "&eSlot8");
	 put("Chest.name", "&bEffects");
	 put("Chest.subtitle", "&bSelect your effect");
	 put("Locations.Set", "&aSuccessful set &6%loc");
	 put("Locations.Teleport.Chat", "&aYou was teleported to %game");
	 put("Locations.Teleport.Title", "&eTeleported to &6%game");
	 put("Locations.Teleport.missing", "&cThis location wasn't set yet");
	 put("Build.true.own", "&aYou're now able to build/break");
	 put("Build.false.own", "&aYou're no longer able to build/break");
	 put("Build.true.other", "&6%p &ais now able to build/break");
	 put("Build.false.other", "&6%p &ais no longer able to build/break");
	 put("Build.notallowed", "");
	 put("Playeronly", "&cOnly players can do this");
	 put("Playeroffline", "&cThis player isn't online");
	 put("Help", "&8[&fLobby&cNK&8] &7 >> &fThis command wasn't found. Check out our Page: &chttps://nukkitx.com/resources/lobbynk.380/");
	 put("spawn.tp", "&aYou was teleported to spawn");
	 put("spawn.set", "&aSpawn sucessful set");
	 put("playershider.hideall", "&aHide everyone");
	 put("playershider.hidevip", "&5Hide everyone except VIP's");
	 put("playershider.hidenoone", "&cShow everyone");
	 put("playershider.name", "&ePlayer-Hider");
	 put("playershider.hidenall", "&aYou snapped with your fingers. Everyone is gone now...");
	 put("playershider.hidenvip", "&aEveryone except &5VIP's &ais gone now!");
	 put("playershider.hidennoone", "&aEveryone is visible now :D");
	 put("Effectselected", "&aYou selected &e%effect");
	 put("Effectremoved", "&cYou removed &e%effect");
	 put("Chest.Walkingparticles", "&eWalkingparticles");
	 put("Chest.Pets", "&ePets");
	 put("Pet.nametag", "&e%player's Pet");
	 put("Chest.Petsettings", "&ePet Settings");
	 put("Chest.Pet.chicken", "&eChicken");
	 put("Chest.Pet.cow", "&eCow");
	 put("Chest.Pet.pig", "&ePig");
	 put("Chest.Pet.sheep", "&eSheep");
	 put("Chest.Pet.squid", "&eSquid");
	 put("Chest.Pet.polarbear", "&ePolar Bear");
	 put("Chest.Pet.cat", "&eCat");
	 put("Chest.Pet.dog", "&eDog");
	 put("Chest.Pet.parrot", "&eParrot");
	 put("Chest.Pet.llama", "&eLlama");
	 put("Chest.Pet.donkey", "&eDonkey");
	 put("Chest.Pet.horse", "&eHorse");
	 put("Chest.Pet.zombiehorse", "&eZombie Horse");
	 put("Chest.Pet.skeletonhorse", "&eSkeleton Horse");
	 put("Chest.Pet.fish", "&eFish");
	 put("Chest.Pet.turtle", "&eTurtle");
	 put("Chest.Pet.dolphin", "&eDolphin");
	 put("Chest.Pet.panda", "&ePanda");
	 put("Chest.Pet.wither", "&eCharched Wither");
	 put("Chest.Pet.zombie", "&eZombie Pet");
	 put("Chest.Pet.skeleton", "&eSkeleton Pet");
	 put("Chest.Pet.spider", "&eSpider Pet");
	 put("Chest.Pet.cavespider", "&eCavespider Pet");
	 put("Chest.Pet.creeper", "&eCreeper Pet");
	 put("Chest.Pet.slime", "&eSlime");
	 put("Chest.Pet.ghast", "&eGhast");
	 put("Chest.Pet.guardian", "&eGuardian");
	 put("Chest.Pet.stray", "&eStray");
	 put("Chest.Pet.witch", "&eWitch");
	 put("Chest.Pet.blaze", "&eBlaze");
	 put("Chest.Pet.hoglin", "&eHoglin");
	 put("Chest.Pet.piglin", "&ePiglin");
	 put("Chest.Pet.zoglin", "&eZoglin");
	 put("Chest.Pet.strider", "&eStrider");
	 put("Chest.Pet.phantom", "&ePhantom");
	 put("Chest.Pet.villager", "&eVillager");
	 put("Chest.Pet.enderman", "&eEnderman");
	// put("Chest.Pet.enderdragon", "&eEnderdragon");
	 put("Chest.Pet.settings.name", "&eName");
	 put("Chest.Pet.settings.size", "&eSize");
	 put("Chest.Cosmetics", "&eCosmetics");
	 put("Chest.cosmetic.netherite", "&eNetherite");
	 put("Chest.cosmetic.diamond", "&eDiamond");
	 put("Chest.cosmetic.iron", "&eIron");
	 put("Chest.cosmetic.chainmail", "&eChainmail");
	 put("Chest.cosmetic.gold", "&eGold");
	 put("Chest.cosmetic.leather", "&eLeather");
	 put("Chest.cosmetic.other", "&eOther");
	 put("Chest.cosmetic.enchant", "&eEnchant");
	 put("Chest.cosmetic.dye", "§eDye");
	 put("Chest.cosmetic.helmet", "&ehelmet");
	 put("Chest.cosmetic.chestplate", "&echestplate");
	 put("Chest.cosmetic.leggings", "&eleggings");
	 put("Chest.cosmetic.boots", "&eboots");
	 put("Chest.cosmetic.skull", "&eSkull");
	 put("Chest.cosmetic.wither", "&eWither");
	 put("Chest.cosmetic.zombie", "&eZombie");
	 put("Chest.cosmetic.player", "&eSteve");
	 put("Chest.cosmetic.creeper", "&eCreeper");
	 put("Chest.cosmetic.dragon", "&eEnderdragon");
	 put("Chest.cosmetic.shell", "&eTurtle Shell");
	 put("Chest.cosmetic.elytra", "&eElytra");
	 put("Chest.cosmetic.equipped", "&aYou equipped &e%cosmetic");
	 put("Chest.cosmetic.nothingequipped", "&cYou didn't equip anything");
	 put("Chest.cosmetic.removed", "&cYou removed &e%cosmetic");
	 put("Chest.remove_everything", "&cYou removed every gadget");
	 put("Chest.remove", "&cRemove Effects");
	 put("Chest.walking.angry", "&eAngry");
	 put("Chest.walking.bonemeal", "&eBonemeal");
	 put("Chest.walking.bubble", "&ebubble");
	 put("Chest.walking.flame", "&eFlame");
	 put("Chest.walking.explode", "&eExplode");
	 put("Chest.walking.heart", "&eHeart");
	 put("Chest.walking.redstone", "&eRedstone");
	 put("Chest.walking.ink", "&eInk");
	 put("Chest.walking.note", "&eNote");
	 put("Chest.walking.enchant", "&eEnchant");
	 put("Chest.effects", "&eEffects");
	 put("Chest.effect.speed", "&eSpeed");
	 put("Chest.effect.jumpboost", "&eJump Boost");
	 put("Chest.effect.levitation", "&eLevitation");
	 put("Chest.effect.invisibility", "&eInvisibility");
	 put("Chest.effect.blindness", "&eBlindness");
	 put("Chest.effect.nausea", "&eNausea");
		put("Chest.effect.nightvision", "&eNight Vision");
	 put("Chat.cleared", "&eThe chat has been cleared by &c%player");
	 put("Scoreboard.Header", "&c&lLobbyNK by Buddelbubi");
	 put("Scoreboard.Line1", "");
	 put("Scoreboard.Line2", "&7Welcome on NukkitX");
	 put("Scoreboard.Line3", "&r");
	 put("Scoreboard.Line4", "&cPlease rate LobbyNK");
	 put("Scoreboard.Line5", "&cIn best case with 5 stars");
	 put("Scoreboard.Line6", "");
	 put("Scoreboard.Line7", "");
	 put("Scoreboard.Line8", "");
	 put("Scoreboard.Line9", "");
	 put("Scoreboard.Line10", "");
	 put("lobbyselector", "&9Select your Lobby");
	 put("lobbyselector.prefix", "&b");
	 put("lobbyselector.vipprefix", "&e");
	 put("lobbyselector.serverprefix", "&a");
	 put("Lobbyselector.Playercounter", "&e(%inlobby/%maxlobby)");
	 put("serveradded", "&aLobby &e%servername (%address) &aadded");
	 put("everylobbyisfull", "&cSorry, but every Lobby is full.. We can't connect you");
	 put("fulllobby", "&cSorry, but this Lobby is full");
	 put("lobbyconnected", "&aYou're now in Lobby &e%lobby");
	 put("settings", "&cSettings");
	 put("settings.fly", "Flying");
	 put("settings.doublejump", "Doublejump");
	 put("settings.jumppad", "Jumppad");
	 put("settings.forcefield", "Forcefield");
	 put("settings.enabled", "&aYou enabled &e%mode");
	 put("settings.disabled", "&cYou disabled %mode");
	 put("sync.success", "&aSuccessfully synced %copied %overwritten");
	 put("sync.failed", "&cAn error orrupted while syncing.");


	}
	});
	
}
} catch (Exception e) {
	Server.getInstance().getLogger().critical("§cAn LobbyNK Languagefile is corrupted! Please reset the file");
	System.exit(1);
}
	}
	
}
