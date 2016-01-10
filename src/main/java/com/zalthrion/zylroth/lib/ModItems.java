package com.zalthrion.zylroth.lib;

import net.minecraft.item.Item;

import com.zalthrion.zylroth.item.CursedSoulEssence;
import com.zalthrion.zylroth.item.DarkShard;
import com.zalthrion.zylroth.item.SoulEssence;
import com.zalthrion.zylroth.item.UnstableTenebraeCore;
import com.zalthrion.zylroth.item.VoidEssence;
import com.zalthrion.zylroth.item.VoidGem;
import com.zalthrion.zylroth.item.mount.EmptySC;
import com.zalthrion.zylroth.item.mount.SCDeathcharger;
import com.zalthrion.zylroth.item.mount.SCPlaguedHorse;
import com.zalthrion.zylroth.item.mount.SCSavageBadger;
import com.zalthrion.zylroth.item.mount.SCSwiftUnicorn;
import com.zalthrion.zylroth.item.mount.SCWarTortoise;
import com.zalthrion.zylroth.item.ore.*;
import com.zalthrion.zylroth.item.talisman.AutumnTalisman;
import com.zalthrion.zylroth.item.talisman.GoldTalisman;
import com.zalthrion.zylroth.item.talisman.IceTalisman;
import com.zalthrion.zylroth.item.talisman.VoidTalisman;

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
	/* Tenebrae Items */
	public static Item unstableTenebraeCore = new UnstableTenebraeCore();
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
		ModRegistry.addRegister(39, tenebraeChunk, "tenebraeChunk");
		ModRegistry.addRegister(40, tenebraeOre, "tenebraeIOre");
		ModRegistry.addRegister(41, tenebraeIngot, "tenebraeIngot");
		/* Infernium Ore */
		ModRegistry.addRegister(42, rawInfernium, "rawInfernium");
		ModRegistry.addRegister(43, inferniumIngot, "inferniumIngot");
		/* Endirite Ore */
		ModRegistry.addRegister(44, endiriteChunk, "endiriteChunk");
		ModRegistry.addRegister(45, endiriteOre, "endiriteIOre");
		ModRegistry.addRegister(46, endiriteIngot, "endiriteIngot");
		/* Tenebrium Ore */
		ModRegistry.addRegister(47, tenebriumIngot, "tenebriumIngot");
		/* Voidium Ore */
		ModRegistry.addRegister(48, voidiumChunk, "voidiumChunk");
		ModRegistry.addRegister(49, voidiumOre, "voidiumIOre");
		ModRegistry.addRegister(50, voidiumIngot, "voidiumIngot");
		/* Tenebrae Items */
		ModRegistry.addRegister(51, unstableTenebraeCore, "unstableTenebraeCore");
		/* Mounts */
		ModRegistry.addRegister(52, Empty_SC, "emptySC");
		ModRegistry.addRegister(53, SC_Deathcharger, "SC_Deathcharger");
		ModRegistry.addRegister(54, SC_PlaguedHorse, "SC_PlaguedHorse");
		ModRegistry.addRegister(55, SC_WarTortoise, "SC_WarTortoise");
		ModRegistry.addRegister(56, SC_SavageBadger, "SC_SavageBadger");
		ModRegistry.addRegister(57, SC_SwiftUnicorn, "SC_SwiftUnicorn");
		/* Portals */
		ModRegistry.addRegister(58, goldTalisman, "goldTalisman");
		ModRegistry.addRegister(59, voidTalisman, "voidTalisman");
		ModRegistry.addRegister(60, autumnTalisman, "autumnTalisman");
		ModRegistry.addRegister(61, iceTalisman, "iceTalisman");
		/* Others */
		ModRegistry.addRegister(62, darkShard, "darkShard");
		ModRegistry.addRegister(63, soulEssence, "soulEssence");
		ModRegistry.addRegister(64, cursedSoulEssence, "cursedSoulEssence");
		ModRegistry.addRegister(65, voidGem, "voidGem");
		ModRegistry.addRegister(66, voidEssence, "voidEssence");
	}
}