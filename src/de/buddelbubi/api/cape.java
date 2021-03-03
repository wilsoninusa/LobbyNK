package de.buddelbubi.api;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.entity.data.Skin;
import cn.nukkit.network.protocol.PlayerSkinPacket;
import cn.nukkit.utils.SerializedImage;

public class cape {

	public static void setCape(Player p) {
		
		
		// DOESN'T WORK YET
		Skin s = p.getSkin();
		try {
			BufferedImage si = ImageIO.read(new File(Server.getInstance().getPluginPath() + "/LobbyNK", "example.png"));
			BufferedImage sk = ImageIO.read(new File(Server.getInstance().getPluginPath() + "/LobbyNK", "skin.png"));
		
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(si, "png", baos);
			baos.flush();
			byte[] bts = baos.toByteArray();
			baos.close();;
			SerializedImage img = new SerializedImage(200, 150, bts);
			s.setSkinData(sk);
			s.setCapeOnClassic(true);
			s.setCapeId("example");
			s.setCapeData(img);
			s.setPremium(true);
			Skin os = p.getSkin();
			p.setSkin(s);
			
			PlayerSkinPacket psp = new PlayerSkinPacket();
			psp.skin = s;
			psp.oldSkinName = os.getSkinId();
			psp.newSkinName = s.getSkinId();
			psp.uuid = p.getUniqueId();
			System.out.print(psp);
			
			
			Server.broadcastPacket(Server.getInstance().getOnlinePlayers().values(), psp);
			p.hidePlayer(p);
			
			Server.getInstance().getScheduler().scheduleDelayedTask(new Runnable() {
				
				@Override
				public void run() {
p.showPlayer(p);
					
				}
			}, 15);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
