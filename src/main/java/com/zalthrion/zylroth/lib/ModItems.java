package com.zalthrion.zylroth.lib;

import net.minecraft.item.Item;

import com.zalthrion.zylroth.item.*;

public final class ModItems {
	
	public static Item Raw_Tenebrae;
	
	public static Item Raw_Tenebrae_Ingot;
	
	public static Item Tenebrae_Ingot;
	
	public static Item Purified_Tenebrae_Essence;
	
	public static Item Unstable_Tenebrae_Essence;
	
	public static Item Soul_Essence;
	
	public static Item Cursed_Soul_Essence;
	
	public static Item Dark_Shard;
	
	public static Item Test_Item;
	
	public static void init() {
		
		Raw_Tenebrae = new RawTenebrae();
		
		Raw_Tenebrae_Ingot = new RawTenebraeIngot();
		
		Tenebrae_Ingot = new TenebraeIngot();
		
		Purified_Tenebrae_Essence = new PurifiedTenebraeEssence();
		
		Unstable_Tenebrae_Essence = new UnstableTenebraeEssence();
		
		Soul_Essence = new SoulEssence();
		
		Cursed_Soul_Essence = new CursedSoulEssence();
		
		Dark_Shard = new DarkShard();
		
		Test_Item = new TestItem();
	}
	
}
