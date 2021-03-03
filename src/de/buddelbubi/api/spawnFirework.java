package de.buddelbubi.api;

import java.util.Random;

import cn.nukkit.Player;
import cn.nukkit.entity.item.EntityFirework;
import cn.nukkit.item.ItemFirework;
import cn.nukkit.item.ItemFirework.FireworkExplosion;
import cn.nukkit.level.Level;
import cn.nukkit.nbt.NBTIO;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.nbt.tag.DoubleTag;
import cn.nukkit.nbt.tag.FloatTag;
import cn.nukkit.nbt.tag.ListTag;
import cn.nukkit.utils.DyeColor;

public class spawnFirework {
	
	public static void spawnFirework(Player p) {
		ConfigNK c = de.buddelbubi.Lobbynk.config;
		if(c.getBoolean("fireworkonspawn")) {
			double x = p.getX();
			double y = p.getY();
			double z = p.getZ();
			
			ItemFirework item = new ItemFirework();
			  CompoundTag tag = new CompoundTag();
		        Random random = new Random();
		        CompoundTag ex = new CompoundTag()
		                .putByteArray("FireworkColor", new byte[]{(byte) DyeColor.values()[random.nextInt(FireworkExplosion.ExplosionType.values().length)].getDyeData()})
		                .putByteArray("FireworkFade", new byte[]{})
		                .putBoolean("FireworkFlicker", random.nextBoolean())
		                .putBoolean("FireworkTrail", random.nextBoolean())
		                .putByte("FireworkType", FireworkExplosion.ExplosionType.values()[random.nextInt(FireworkExplosion.ExplosionType.values().length)].ordinal());
		        tag.putCompound("Fireworks", new CompoundTag("Fireworks")
		                .putList(new ListTag<CompoundTag>("Explosions").add(ex))
		                .putByte("Flight", 1));
		        item.setNamedTag(tag);
		        CompoundTag nbt = new CompoundTag()
		                .putList(new ListTag<DoubleTag>("Pos")
		                        .add(new DoubleTag("", x + 0.5))
		                        .add(new DoubleTag("", y + 0.5))
		                        .add(new DoubleTag("", z + 0.5)))
		                .putList(new ListTag<DoubleTag>("Motion")
		                        .add(new DoubleTag("", 0))
		                        .add(new DoubleTag("", 0))
		                        .add(new DoubleTag("", 0)))
		                .putList(new ListTag<FloatTag>("Rotation")
		                        .add(new FloatTag("", 0))
		                        .add(new FloatTag("", 0)))
		.putCompound("FireworkItem", NBTIO.putItemHelper(item));
			
		        Level l = p.getLevel();
			EntityFirework entity = new EntityFirework(l.getChunk((int) x >> 4, (int) z >> 4), nbt);
			entity.spawnToAll();
		}
		
		
	}

}
