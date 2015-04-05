package com.zalthrion.zylroth.lib;

import com.zalthrion.zylroth.handler.recipe.InfusionRecipeHandler;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public final class ModRecipes {
	
	public static void init() {
		registerSmeltingRecipes();
		registerShapedRecipes();
		registerShapelessRecipes();
		registerInfusionRecipes();
	}
	
	public static void registerSmeltingRecipes() {
		
		GameRegistry.addSmelting(ModBlocks.Tenebrae_Ore, new ItemStack(ModItems.Raw_Tenebrae), 0.5F);
		
		GameRegistry.addSmelting(ModItems.Raw_Tenebrae_Ingot, new ItemStack(ModItems.Tenebrae_Ingot), 0.1F);
		
	}
	
	public static void registerShapedRecipes() {
		
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Tenebrae_Block), "III", "III", "III", 'I', ModItems.Tenebrae_Ingot);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Raw_Tenebrae_Ingot), "RRR", 'R', ModItems.Raw_Tenebrae);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Infuser_Idle), "TGT", "GCG", "GPG", 'T', ModBlocks.Tenebrae_Block, 'G', ModItems.Void_Gem);
		
	}
	
	public static void registerShapelessRecipes() {
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Tenebrae_Ingot, 9), new ItemStack(ModBlocks.Tenebrae_Block));
		
	}
	
	public static void registerInfusionRecipes() {
		
//		InfusionRecipeHandler.infusing().addInfusion(new ItemStack(Items.iron_axe), new ItemStack(Items.iron_horse_armor), new ItemStack(Items.apple, 2, 0), new ItemStack(Items.carrot, 3, 0));
		
		InfusionRecipeHandler.infusing().addInfusion(new ItemStack(ModItems.Soul_Essence), new ItemStack(ModItems.Cursed_Soul_Essence), new ItemStack(ModItems.Raw_Tenebrae, 1, 0), new ItemStack(ModItems.Raw_Tenebrae, 1, 0));
		
	}
}
