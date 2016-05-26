package com.zalthrion.zylroth.lib;

import com.zalthrion.zylroth.Zylroth;
import com.zalthrion.zylroth.entity.EntityBadger;
import com.zalthrion.zylroth.entity.EntityBird;
import com.zalthrion.zylroth.entity.EntityBoar;
import com.zalthrion.zylroth.entity.EntityDeer;
import com.zalthrion.zylroth.entity.EntityFancyBadger;
import com.zalthrion.zylroth.entity.EntityRainbowPig;
import com.zalthrion.zylroth.entity.EntitySkeletalHorse;
import com.zalthrion.zylroth.entity.EntityStag;
import com.zalthrion.zylroth.entity.EntityTenebraeProtector;
import com.zalthrion.zylroth.entity.EntityTuskarr;
import com.zalthrion.zylroth.entity.EntityUndeadMinion;
import com.zalthrion.zylroth.entity.EntityUndeadWarrior;
import com.zalthrion.zylroth.entity.EntityUnicorn;
import com.zalthrion.zylroth.entity.EntityVoidDragon;
import com.zalthrion.zylroth.entity.boss.EntityTenebraeGuardian;
import com.zalthrion.zylroth.entity.boss.EntityVoidLordBoss;
import com.zalthrion.zylroth.entity.dev.EntitySixOneThree;
import com.zalthrion.zylroth.entity.dev.EntityZalthrion;
import com.zalthrion.zylroth.entity.mount.MountDeathcharger;
import com.zalthrion.zylroth.entity.mount.MountPlaguedHorse;
import com.zalthrion.zylroth.entity.mount.MountSavageBadger;
import com.zalthrion.zylroth.entity.mount.MountSwiftUnicorn;
import com.zalthrion.zylroth.entity.mount.MountWarTortoise;
import com.zalthrion.zylroth.entity.projectile.RepulsorBolt;
import com.zalthrion.zylroth.entity.projectile.RepulsorCannonBolt;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;

public class ModEntity {
	
	private static int nextEntityID = 0;
	
	private static int getNextEntityID() {
		nextEntityID ++;
		return nextEntityID;
	}
	
	public static void registerEntity(Class<? extends Entity> entityClass, String entityName, boolean hasEgg, int bkEggColor, int fgEggColor) {
		EntityRegistry.registerModEntity(entityClass, entityName, getNextEntityID(), Zylroth.instance, 80, 4, true);
		if (hasEgg) {
			Item spawnEgg = new SpawnEgg(entityName, bkEggColor, fgEggColor).setTextureName("zylroth:spawnEgg");
			GameRegistry.registerItem(spawnEgg, "spawnEgg" + "." + entityName);
		}
	}
	
	public void addSpawn(Class<? extends EntityLiving> entityClass, int spawnProb, int min, int max, BiomeGenBase[] biomes) {
		if (spawnProb > 0) {
			EntityRegistry.addSpawn(entityClass, spawnProb, min, max, EnumCreatureType.creature, biomes);
		}
	}
	
	public static void init() {
		registerEntities();
	}
	
	private static void registerEntities() {
		
		/** Animals */
		
		registerEntity(EntityBird.class, "bird", true, 0xeaeae9, 0xc99a03);
		
		registerEntity(EntityRainbowPig.class, "rainbowPig", true, 0xFF9999, 0x9933FF);
		
		registerEntity(EntityBadger.class, "badger", true, 0x202020, 0xE0E0E0);
		
		registerEntity(EntityFancyBadger.class, "fancyBadger", false, 0, 0);
		
		registerEntity(EntityBoar.class, "boar", true, 0x663300, 0xFFFFFF);
		
		registerEntity(EntityUnicorn.class, "unicorn", true, 0xE0E0E0, 0xC0C0C0);
		
		registerEntity(EntityDeer.class, "deer", true, 0xFF9933, 0xE0E0E0);
		
		registerEntity(EntityStag.class, "stag", true, 0xFF8000, 0xE0E0E0);
		
		/** Mobs */
		
		registerEntity(EntityTenebraeGuardian.class, "tenebraeGuardian", true, 0x190033, 0x660000);
		
		registerEntity(EntityVoidLordBoss.class, "voidLord", true, 0x404040, 0xC0C0C0);
		
		registerEntity(EntitySkeletalHorse.class, "skeletalHorse", true, 0xE0E0E0, 0xC0C0C0);
		
		registerEntity(EntityTenebraeProtector.class, "tenebraeProtector", true, 0x190033, 0x000033);
		
		registerEntity(EntityUndeadMinion.class, "undeadMinion", true, 0xA0A0A0, 0x808080);
		
		registerEntity(EntityUndeadWarrior.class, "undeadWarrior", true, 0x808080, 0xFFFFFF);
				
		registerEntity(EntityVoidDragon.class, "voidDragon", true, 0x00000, 0xCCCCFF);
		
		/** Others */
		
		registerEntity(EntityTuskarr.class, "tuskarr", true, 0x0000, 0xCCCCFF);
		
		/** Mounts */
		
		registerEntity(MountDeathcharger.class, "Deathcharger", false, 0, 0);
		
		registerEntity(MountPlaguedHorse.class, "Plagued Horse", false, 0, 0);
		
		registerEntity(MountWarTortoise.class, "War Tortoise", false, 0, 0);
		
		registerEntity(MountSavageBadger.class, "Savage Badger", false, 0, 0);
		
		registerEntity(MountSwiftUnicorn.class, "Swift Unicorn", false, 0, 0);
		
		/** Developers */
		
		registerEntity(EntityZalthrion.class, "Zalthrion", true, 0x202020, 0x663300);
		
		registerEntity(EntitySixOneThree.class, "Six-One-Three", true, 0x000000, 0x00CCCC);
		
		/** Projectiles */
		
		registerEntity(RepulsorBolt.class, "repulsorBolt", false, 0, 0);
		registerEntity(RepulsorCannonBolt.class, "repulsorCannonBolt", false, 0, 0);
		
	}
}