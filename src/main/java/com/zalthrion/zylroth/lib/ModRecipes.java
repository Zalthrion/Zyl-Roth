package com.zalthrion.zylroth.lib;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public final class ModRecipes {
	
    public static void init() {
        registerSmeltingRecipes();
        registerShapedRecipes();
        registerShapelessRecipes();
    }
	
	public static void registerSmeltingRecipes() {
		
		GameRegistry.addSmelting(ModBlocks.Tenebrae_Ore, new ItemStack(ModItems.Raw_Tenebrae), 0.5F);
		
		GameRegistry.addSmelting(ModItems.Raw_Tenebrae_Ingot, new ItemStack(ModItems.Tenebrae_Ingot), 0.1F);
		
	}
	
	public static void registerShapedRecipes() {
	    
	    GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Tenebrae_Block), "III", "III","III", 'I', ModItems.Tenebrae_Ingot);
	    
	    GameRegistry.addShapedRecipe(new ItemStack(ModItems.Raw_Tenebrae_Ingot), "RRR", 'R', ModItems.Raw_Tenebrae);
		
	}
	
	public static void registerShapelessRecipes() {
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Tenebrae_Ingot, 9), new ItemStack(ModBlocks.Tenebrae_Block));
		
	}

}
