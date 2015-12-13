package com.zalthrion.zylroth.lib;

import net.minecraft.item.Item;

import com.zalthrion.zylroth.item.CursedSoulEssence;
import com.zalthrion.zylroth.item.DarkShard;
import com.zalthrion.zylroth.item.GoldTalisman;
import com.zalthrion.zylroth.item.IceTalisman;
import com.zalthrion.zylroth.item.RainbowTalisman;
import com.zalthrion.zylroth.item.RawTenebrae;
import com.zalthrion.zylroth.item.RawTenebraeIngot;
import com.zalthrion.zylroth.item.SoulEssence;
import com.zalthrion.zylroth.item.TenebraeIngot;
import com.zalthrion.zylroth.item.UnstableTenebraeCore;
import com.zalthrion.zylroth.item.VoidEssence;
import com.zalthrion.zylroth.item.VoidGem;
import com.zalthrion.zylroth.item.VoidTalisman;
import com.zalthrion.zylroth.item.mount.EmptySC;
import com.zalthrion.zylroth.item.mount.SCDeathcharger;
import com.zalthrion.zylroth.item.mount.SCPlaguedHorse;
import com.zalthrion.zylroth.item.mount.SCWarTortoise;

public final class ModItems {
	/* Tenebrae */
	public static Item raw_Tenebrae = new RawTenebrae();
	public static Item raw_Tenebrae_Ingot = new RawTenebraeIngot();
	public static Item tenebrae_Ingot = new TenebraeIngot();
	public static Item unstable_Tenebrae_Core = new UnstableTenebraeCore();
	/* Mounts */
	public static Item Empty_SC = new EmptySC();
	public static Item SC_Deathcharger = new SCDeathcharger();
	public static Item SC_PlaguedHorse = new SCPlaguedHorse();
	public static Item SC_WarTortoise = new SCWarTortoise();
	/* Portals */
	public static Item gold_Talisman = new GoldTalisman();
	public static Item void_Talisman = new VoidTalisman();
	public static Item rainbow_Talisman = new RainbowTalisman();
	public static Item ice_Talisman = new IceTalisman();
	/* Others */
	public static Item dark_Shard = new DarkShard();
	public static Item soul_Essence = new SoulEssence();
	public static Item cursed_Soul_Essence = new CursedSoulEssence();
	public static Item void_Gem = new VoidGem();
	public static Item void_Essence = new VoidEssence();
	
	
	public static void init() {
		/* Tenebrae */
		ModRegistry.addRegister(26, raw_Tenebrae, "rawTenebrae");
		ModRegistry.addRegister(27, raw_Tenebrae_Ingot, "rawTenebraeIngot");
		ModRegistry.addRegister(28, tenebrae_Ingot, "tenebraeIngot");
		ModRegistry.addRegister(29, unstable_Tenebrae_Core, "unstableTenebraeCore");
		/* Mounts */
		ModRegistry.addRegister(30, Empty_SC, "emptySC");
		ModRegistry.addRegister(31, SC_Deathcharger, "SC_Deathcharger");
		ModRegistry.addRegister(32, SC_PlaguedHorse, "SC_PlaguedHorse");
		ModRegistry.addRegister(33, SC_WarTortoise, "SC_WarTortoise");
		/* Portals */
		ModRegistry.addRegister(34, gold_Talisman, "goldTalisman");
		ModRegistry.addRegister(35, void_Talisman, "voidTalisman");
		ModRegistry.addRegister(36, rainbow_Talisman, "rainbowTalisman");
		ModRegistry.addRegister(37, ice_Talisman, "iceTalisman");
		/* Others */
		ModRegistry.addRegister(38, dark_Shard, "darkShard");
		ModRegistry.addRegister(39, soul_Essence, "soulEssence");
		ModRegistry.addRegister(40, cursed_Soul_Essence, "cursedSoulEssence");
		ModRegistry.addRegister(41, void_Gem, "voidGem");
		ModRegistry.addRegister(42, void_Essence, "voidEssence");
	}
}