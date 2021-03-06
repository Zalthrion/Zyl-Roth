package com.zalthrion.zylroth.lib;

import com.zalthrion.zylroth.item.CelestialCore;
import com.zalthrion.zylroth.item.CursedSoulEssence;
import com.zalthrion.zylroth.item.DarkShard;
import com.zalthrion.zylroth.item.SoulEssence;
import com.zalthrion.zylroth.item.VoidEssence;
import com.zalthrion.zylroth.item.VoidGem;
import com.zalthrion.zylroth.item.mount.EmptySC;
import com.zalthrion.zylroth.item.mount.SCDeathcharger;
import com.zalthrion.zylroth.item.mount.SCPlaguedHorse;
import com.zalthrion.zylroth.item.mount.SCSavageBadger;
import com.zalthrion.zylroth.item.mount.SCSwiftUnicorn;
import com.zalthrion.zylroth.item.mount.SCWarTortoise;
import com.zalthrion.zylroth.item.ore.EndiriteChunk;
import com.zalthrion.zylroth.item.ore.EndiriteIngot;
import com.zalthrion.zylroth.item.ore.EndiriteOre;
import com.zalthrion.zylroth.item.ore.InferniumIngot;
import com.zalthrion.zylroth.item.ore.RawInfernium;
import com.zalthrion.zylroth.item.ore.TenebraeChunk;
import com.zalthrion.zylroth.item.ore.TenebraeIngot;
import com.zalthrion.zylroth.item.ore.TenebraeOre;
import com.zalthrion.zylroth.item.ore.TenebriumIngot;
import com.zalthrion.zylroth.item.ore.VoidiriteIngot;
import com.zalthrion.zylroth.item.ore.VoidiumChunk;
import com.zalthrion.zylroth.item.ore.VoidiumIngot;
import com.zalthrion.zylroth.item.ore.VoidiumOre;
import com.zalthrion.zylroth.item.talisman.AutumnTalisman;
import com.zalthrion.zylroth.item.talisman.GoldTalisman;
import com.zalthrion.zylroth.item.talisman.IceTalisman;
import com.zalthrion.zylroth.item.talisman.VoidTalisman;

import net.minecraft.item.Item;

public final class ModItems {
	
	/* Tenebrae Ore */
	public static Item tenebraeChunk = new TenebraeChunk();
	public static Item tenebraeOre = new TenebraeOre();
	public static Item tenebraeIngot = new TenebraeIngot();
	
	/* Infernium Ore */
	public static Item rawInfernium = new RawInfernium();
	public static Item inferniumIngot = new InferniumIngot();
	
	/* Endirite Ore */
	public static Item endiriteChunk = new EndiriteChunk();
	public static Item endiriteOre = new EndiriteOre();
	public static Item endiriteIngot = new EndiriteIngot();
	
	/* Tenebrium Ore */
	public static Item tenebriumIngot = new TenebriumIngot();
	
	/* Voidium Ore */
	public static Item voidiumChunk = new VoidiumChunk();
	public static Item voidiumOre = new VoidiumOre();
	public static Item voidiumIngot = new VoidiumIngot();
	
	/* Voidirite Ore */
	public static Item voidiriteIngot = new VoidiriteIngot();
	
	/* Tenebrae Items */
	public static Item celestialCore = new CelestialCore();
	
	/* Mounts */
	public static Item Empty_SC = new EmptySC();
	public static Item SC_Deathcharger = new SCDeathcharger();
	public static Item SC_PlaguedHorse = new SCPlaguedHorse();
	public static Item SC_WarTortoise = new SCWarTortoise();
	public static Item SC_SavageBadger = new SCSavageBadger();
	public static Item SC_SwiftUnicorn = new SCSwiftUnicorn();
	
	/* Portals */
	public static Item goldTalisman = new GoldTalisman();
	public static Item voidTalisman = new VoidTalisman();
	public static Item autumnTalisman = new AutumnTalisman();
	public static Item iceTalisman = new IceTalisman();
	
	/* Others */
	public static Item darkShard = new DarkShard();
	public static Item soulEssence = new SoulEssence();
	public static Item cursedSoulEssence = new CursedSoulEssence();
	public static Item voidGem = new VoidGem();
	public static Item voidEssence = new VoidEssence();
	
	public static void init() {
		
		/* Tenebrae Ore */
		ModRegistry.addRegister(40, tenebraeChunk, "tenebraeChunk");
		ModRegistry.addRegister(41, tenebraeOre, "tenebraeIOre");
		ModRegistry.addRegister(42, tenebraeIngot, "tenebraeIngot");
		
		/* Infernium Ore */
		ModRegistry.addRegister(43, rawInfernium, "rawInfernium");
		ModRegistry.addRegister(44, inferniumIngot, "inferniumIngot");
		
		/* Endirite Ore */
		ModRegistry.addRegister(45, endiriteChunk, "endiriteChunk");
		ModRegistry.addRegister(46, endiriteOre, "endiriteIOre");
		ModRegistry.addRegister(47, endiriteIngot, "endiriteIngot");
		
		/* Tenebrium Ore */
		ModRegistry.addRegister(48, tenebriumIngot, "tenebriumIngot");
		
		/* Voidium Ore */
		ModRegistry.addRegister(49, voidiumChunk, "voidiumChunk");
		ModRegistry.addRegister(50, voidiumOre, "voidiumIOre");
		ModRegistry.addRegister(51, voidiumIngot, "voidiumIngot");
		
		/* Voidirite Ore */
		ModRegistry.addRegister(70, voidiriteIngot, "voidiriteIngot");
		
		/* Tenebrae Items */
		ModRegistry.addRegister(52, celestialCore, "celestialCore");
		
		/* Portals */
		ModRegistry.addRegister(53, goldTalisman, "goldTalisman");
		ModRegistry.addRegister(54, voidTalisman, "voidTalisman");
		ModRegistry.addRegister(55, autumnTalisman, "autumnTalisman");
		ModRegistry.addRegister(56, iceTalisman, "iceTalisman");
		
		/* Others */
		ModRegistry.addRegister(57, darkShard, "darkShard");
		ModRegistry.addRegister(58, soulEssence, "soulEssence");
		ModRegistry.addRegister(59, cursedSoulEssence, "cursedSoulEssence");
		ModRegistry.addRegister(60, voidGem, "voidGem");
		ModRegistry.addRegister(61, voidEssence, "voidEssence");
		
		/* Mounts */
		ModRegistry.addRegister(62, Empty_SC, "emptySC");
		ModRegistry.addRegister(63, SC_Deathcharger, "SC_Deathcharger");
		ModRegistry.addRegister(64, SC_PlaguedHorse, "SC_PlaguedHorse");
		ModRegistry.addRegister(65, SC_WarTortoise, "SC_WarTortoise");
		ModRegistry.addRegister(66, SC_SavageBadger, "SC_SavageBadger");
		ModRegistry.addRegister(67, SC_SwiftUnicorn, "SC_SwiftUnicorn");
		
	}
}
