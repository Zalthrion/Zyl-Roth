package com.zalthrion.zylroth.lib;

import net.minecraft.item.Item;

import com.zalthrion.zylroth.item.*;
import com.zalthrion.zylroth.item.mount.EmptySC;
import com.zalthrion.zylroth.item.mount.SCDeathcharger;
import com.zalthrion.zylroth.item.mount.SCPlaguedHorse;
import com.zalthrion.zylroth.item.mount.SCSavageBadger;
import com.zalthrion.zylroth.item.mount.SCSwiftUnicorn;
import com.zalthrion.zylroth.item.mount.SCWarTortoise;
import com.zalthrion.zylroth.item.ore.*;
import com.zalthrion.zylroth.item.talisman.GoldTalisman;
import com.zalthrion.zylroth.item.talisman.IceTalisman;
import com.zalthrion.zylroth.item.talisman.RainbowTalisman;
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
	public static Item rainbowTalisman = new RainbowTalisman();
	public static Item iceTalisman = new IceTalisman();
	/* Others */
	public static Item darkShard = new DarkShard();
	public static Item soulEssence = new SoulEssence();
	public static Item cursedSoulEssence = new CursedSoulEssence();
	public static Item voidGem = new VoidGem();
	public static Item voidEssence = new VoidEssence();
	
	
	public static void init() {
		/* Tenebrae Ore */
		ModRegistry.addRegister(38, tenebraeChunk, "tenebraeChunk");
		ModRegistry.addRegister(39, tenebraeOre, "tenebraeIOre");
		ModRegistry.addRegister(40, tenebraeIngot, "tenebraeIngot");
		/* Infernium Ore */
		ModRegistry.addRegister(41, rawInfernium, "rawInfernium");
		ModRegistry.addRegister(42, inferniumIngot, "inferniumIngot");
		/* Endirite Ore */
		ModRegistry.addRegister(43, endiriteChunk, "endiriteChunk");
		ModRegistry.addRegister(44, endiriteOre, "endiriteIOre");
		ModRegistry.addRegister(45, endiriteIngot, "endiriteIngot");
		/* Tenebrium Ore */
		ModRegistry.addRegister(46, tenebriumIngot, "tenebriumIngot");
		/* Voidium Ore */
		ModRegistry.addRegister(47, voidiumChunk, "voidiumChunk");
		ModRegistry.addRegister(48, voidiumOre, "voidiumIOre");
		ModRegistry.addRegister(49, voidiumIngot, "voidiumIngot");
		/* Tenebrae Items */
		ModRegistry.addRegister(50, unstableTenebraeCore, "unstableTenebraeCore");
		/* Mounts */
		ModRegistry.addRegister(51, Empty_SC, "emptySC");
		ModRegistry.addRegister(52, SC_Deathcharger, "SC_Deathcharger"); //TODO This needs be changed in order to get item model to work.
		ModRegistry.addRegister(53, SC_PlaguedHorse, "SC_PlaguedHorse");
		ModRegistry.addRegister(54, SC_WarTortoise, "SC_WarTortoise");
		ModRegistry.addRegister(55, SC_SavageBadger, "SC_SavageBadger");
		ModRegistry.addRegister(56, SC_SwiftUnicorn, "SC_SwiftUnicorn");
		/* Portals */
		ModRegistry.addRegister(57, goldTalisman, "goldTalisman");
		ModRegistry.addRegister(58, voidTalisman, "voidTalisman");
		ModRegistry.addRegister(59, rainbowTalisman, "rainbowTalisman");
		ModRegistry.addRegister(60, iceTalisman, "iceTalisman");
		/* Others */
		ModRegistry.addRegister(61, darkShard, "darkShard");
		ModRegistry.addRegister(62, soulEssence, "soulEssence");
		ModRegistry.addRegister(63, cursedSoulEssence, "cursedSoulEssence");
		ModRegistry.addRegister(64, voidGem, "voidGem");
		ModRegistry.addRegister(65, voidEssence, "voidEssence");
	}
}