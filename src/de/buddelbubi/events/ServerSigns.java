package de.buddelbubi.events;


import java.util.HashMap;
import java.util.Map;

import cn.nukkit.Server;
import cn.nukkit.block.Block;
import cn.nukkit.blockentity.BlockEntitySign;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.math.BlockVector3;
import cn.nukkit.utils.Config;
import de.buddelbubi.Lobbynk;
import de.buddelbubi.api.MultiLobbyManager;

public class ServerSigns implements Listener{

	public static Map<String, String[]> signs = new HashMap<String, String[]>();
	
	@EventHandler
	public void onSignPlaced(BlockPlaceEvent e) {
		
		if(e.getBlock().getId() == Block.SIGN_POST || e.getBlock().getId() == Block.WALL_SIGN) {
			
			if(e.getPlayer().getLevel().getBlockEntity(e.getBlock().getLocation()) instanceof BlockEntitySign) {
				
				BlockEntitySign sign = (BlockEntitySign) e.getPlayer().getLevel().getBlockEntity(e.getBlock().getLocation());
				if(sign.getText()[0].equalsIgnoreCase("[lobbysign]") && e.getPlayer().hasPermission("lobbynk.createsign")) {
					if(sign.getText().length == 3) {
						String[] args = sign.getText();
						
						if(args[1].equalsIgnoreCase("lobby")) {
							
							if(MultiLobbyManager.lobbyworlds.contains(args[2])) {
								
								sign.setText(new String[] {Lobbynk.lang.getString("Sign.Prefix"), 
										Lobbynk.lang.getString("Sign.Type").replace("%type", args[1]),
										Lobbynk.lang.getString("Sign.Name").replace("%name", args[2]),
										Lobbynk.lang.getString("Sign.Online").replace("%playercounter", Server.getInstance().getLevelByName(args[2]).getPlayers().size() + "/" + Lobbynk.config.getInt("maxplayersperlobby"))
										});
								Lobbynk.loc.set("Sign.lobby" + sign.x + "=" + sign.y + "=" + sign.z, args[2]);
								Lobbynk.loc.save();
								signs.put(sign.x + "=" + sign.y + "=" + sign.z, args);
								
							}else e.getPlayer().sendMessage("§cLobby " + args[2] + " not found");
							
						} else if(args[1].equalsIgnoreCase("server")) {
							
						}
						
						
					} else e.getPlayer().sendMessage("§cMissing arguments");
					
					
				} else {
					e.setCancelled(true);
					e.getPlayer().sendMessage(Lobbynk.lang.getString("nopermission"));
				}
				
			}
			
		}
		
	}
	public static void rollbackSigns() {
		
		for(String s : signs.keySet()) {
			
			String[] xyz = s.split("=");
		
			
		}
		
	}
}
