package com.zalthrion.zylroth.lib;

import net.minecraft.item.Item;

import com.zalthrion.zylroth.handler.ConfigurationHandler;
import com.zalthrion.zylroth.item.*;
import com.zalthrion.zylroth.item.mount.*;

import cpw.mods.fml.common.registry.GameRegistry;

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
		GameRegistry.registerItem(raw_Tenebrae, "rawTenebrae");
		GameRegistry.registerItem(raw_Tenebrae_Ingot, "rawTenebraeIngot");
		GameRegistry.registerItem(tenebrae_Ingot, "tenebraeIngot");
		GameRegistry.registerItem(unstable_Tenebrae_Core, "unstableTenebraeCore");
		
		/* Mounts */
		GameRegistry.registerItem(Empty_SC, "emptySC");
		GameRegistry.registerItem(SC_Deathcharger, "SC_Deathcharger");
		GameRegistry.registerItem(SC_PlaguedHorse, "SC_PlaguedHorse");
		GameRegistry.registerItem(SC_WarTortoise, "SC_WarTortoise");
		
		/* Portals */
		GameRegistry.registerItem(gold_Talisman, "goldTalisman");
		
		if (ConfigurationHandler.getKyrulEnabled() == true)
			GameRegistry.registerItem(void_Talisman, "voidTalisman");
		
		if (ConfigurationHandler.getIridisEnabled() == true)
			GameRegistry.registerItem(rainbow_Talisman, "rainbowTalisman");
		
		if (ConfigurationHandler.getGlaciemEnabled() == true)
			GameRegistry.registerItem(ice_Talisman, "iceTalisman");
		
		/* Others */
		GameRegistry.registerItem(dark_Shard, "darkShard");
		GameRegistry.registerItem(soul_Essence, "soulEssence");
		GameRegistry.registerItem(cursed_Soul_Essence, "cursedSoulEssence");
		GameRegistry.registerItem(void_Gem, "voidGem");
		GameRegistry.registerItem(void_Essence, "voidEssence");
	}
}
