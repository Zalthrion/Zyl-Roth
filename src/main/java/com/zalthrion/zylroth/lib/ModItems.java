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
	
	public static Item SC_Deathcharger;
	
	public static Item SC_PlaguedHorse;
	
	
	//Others
	
	public static Item Dark_Shard;
	
	public static Item Soul_Essence;
	
	public static Item Cursed_Soul_Essence;
	
	public static Item Test_Item;
	
	public static Item Test_Item_2;
	
	public static Item Void_Gem;
	
	public static void init() {
		
		//Tenebrae
		
		Raw_Tenebrae = new RawTenebrae();
		
		Raw_Tenebrae_Ingot = new RawTenebraeIngot();
		
		Tenebrae_Ingot = new TenebraeIngot();
		
		Purified_Tenebrae_Essence = new PurifiedTenebraeEssence();
		
		Unstable_Tenebrae_Essence = new UnstableTenebraeEssence();
		
		
		//Mounts
		
		SC_Deathcharger = new SCDeathcharger();
		
		SC_PlaguedHorse = new SCPlaguedHorse();
		
		
		//Others
		
		Dark_Shard = new DarkShard();
		
		Soul_Essence = new SoulEssence();
		
		Cursed_Soul_Essence = new CursedSoulEssence();
		
		Test_Item = new TestItem();
		
		Test_Item_2 = new TestItem2();
		
		Void_Gem = new VoidGem();
		
	}
	
}
