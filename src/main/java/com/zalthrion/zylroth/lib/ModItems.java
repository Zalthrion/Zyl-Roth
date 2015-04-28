package com.zalthrion.zylroth.lib;

import net.minecraft.item.Item;

import com.zalthrion.zylroth.item.*;
import com.zalthrion.zylroth.item.mount.*;

public final class ModItems {
	
	//Tenebrae
	
	public static Item Raw_Tenebrae;
	
	public static Item Raw_Tenebrae_Ingot;
	
	public static Item Tenebrae_Ingot;
	
	
	public static Item Unstable_Tenebrae_Core;
	
	public static Item Stable_Tenebrae_Core;
	
	
	//Mounts
	
	public static Item Empty_SC;
	
	public static Item SC_Deathcharger;
	
	public static Item SC_PlaguedHorse;
	
	public static Item SC_WarTortoise;
	
	
	//Portals
	
	public static Item Void_Talisman;
	
	public static Item Rainbow_Talisman;
	
	
	//Others
	
	public static Item Dark_Shard;
	
	public static Item Soul_Essence;
	
	public static Item Cursed_Soul_Essence;
	
	
	public static Item Void_Gem;
	
	public static Item Void_Essence;
	
	
	public static void init() {
		
		//Tenebrae
		
		Raw_Tenebrae = new RawTenebrae();
		
		Raw_Tenebrae_Ingot = new RawTenebraeIngot();
		
		Tenebrae_Ingot = new TenebraeIngot();
		
		
		Unstable_Tenebrae_Core = new UnstableTenebraeCore();
		
		Stable_Tenebrae_Core = new StableTenebraeCore();
		
		
		//Mounts
		
		Empty_SC = new EmptySC();
		
		SC_Deathcharger = new SCDeathcharger();
		
		SC_PlaguedHorse = new SCPlaguedHorse();
		
		SC_WarTortoise = new SCWarTortoise();
		
		
		//Portals
		
		Void_Talisman = new VoidTalisman();
		
		Rainbow_Talisman = new RainbowTalisman();
		
		
		//Others
		
		Dark_Shard = new DarkShard();
		
		
		Soul_Essence = new SoulEssence();
		
		Cursed_Soul_Essence = new CursedSoulEssence();
		
		
		Void_Gem = new VoidGem();
		
		Void_Essence = new VoidEssence();
		
	}
	
}
