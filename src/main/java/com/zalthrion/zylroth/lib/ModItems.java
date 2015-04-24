package com.zalthrion.zylroth.lib;

import net.minecraft.item.Item;

import com.zalthrion.zylroth.item.*;
import com.zalthrion.zylroth.item.mount.*;

public final class ModItems {
	
	//Tenebrae
	
	public static Item Raw_Tenebrae;
	
	public static Item Raw_Tenebrae_Ingot;
	
	public static Item Tenebrae_Ingot;
	
	public static Item Purified_Tenebrae_Essence;
	
	public static Item Unstable_Tenebrae_Essence;
	
	
	//Mounts
	
	public static Item Empty_SummoningCrystal;
	
	public static Item SC_Deathcharger;
	
	public static Item SC_PlaguedHorse;
	
	
	//Portals
	
	public static Item Void_Talisman;
	
	public static Item Rainbow_Talisman;
	
	
	//Others
	
	public static Item Dark_Shard;
	
	public static Item Soul_Essence;
	
	public static Item Cursed_Soul_Essence;
	
	public static Item Void_Gem;
	
	
	public static void init() {
		
		//Tenebrae
		
		Raw_Tenebrae = new RawTenebrae();
		
		Raw_Tenebrae_Ingot = new RawTenebraeIngot();
		
		Tenebrae_Ingot = new TenebraeIngot();
		
		Purified_Tenebrae_Essence = new PurifiedTenebraeEssence();
		
		Unstable_Tenebrae_Essence = new UnstableTenebraeEssence();
		
		
		//Mounts
		
		Empty_SummoningCrystal = new EmptySummoningCrystal();
		
		SC_Deathcharger = new SCDeathcharger();
		
		SC_PlaguedHorse = new SCPlaguedHorse();
		
		
		//Portals
		
		Void_Talisman = new VoidTalisman();
		
		Rainbow_Talisman = new RainbowTalisman();
		
		
		//Others
		
		Dark_Shard = new DarkShard();
		
		Soul_Essence = new SoulEssence();
		
		Cursed_Soul_Essence = new CursedSoulEssence();
		
		Void_Gem = new VoidGem();
		
	}
	
}
