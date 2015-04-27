package com.zalthrion.zylroth.lib;

import com.zalthrion.zylroth.handler.recipe.InfusionRecipeHandler;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public final class ModRecipes {
	
	public static void init() {
		registerSmeltingRecipes();
		registerShapedRecipes();
		registerShapelessRecipes();
		registerArmorRecipes();
		registerInfusionRecipes();
	}
	
	public static void registerSmeltingRecipes() {
		
		GameRegistry.addSmelting(ModBlocks.Tenebrae_Ore, new ItemStack(ModItems.Raw_Tenebrae), 0.5F);
		
		GameRegistry.addSmelting(ModItems.Raw_Tenebrae_Ingot, new ItemStack(ModItems.Tenebrae_Ingot), 0.1F);
		
	}
	
	public static void registerShapedRecipes() {
		
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Tenebrae_Block), "III", "III", "III", 'I', ModItems.Tenebrae_Ingot);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Raw_Tenebrae_Ingot), "RRR", 'R', ModItems.Raw_Tenebrae);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Infuser_Idle), "DTD", "TCT", "DTD", 'D', Items.diamond, 'T', ModBlocks.Tenebrae_Block, 'C', ModBlocks.Tenebrae_Core);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.Tenebrae_Core), "IEI", "ECE", "IEI", 'I', ModItems.Tenebrae_Ingot, 'E', ModItems.Soul_Essence, 'C', ModItems.Tenebrae_Core);
		
	}
	
	public static void registerShapelessRecipes() {
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.Tenebrae_Ingot, 9), new ItemStack(ModBlocks.Tenebrae_Block));
		
	}
	
	public static void registerArmorRecipes() {
		
		GameRegistry.addShapedRecipe(new ItemStack(ModArmors.Tenebrae_Helmet), "III", "IEI", 'I', ModItems.Tenebrae_Ingot);
		GameRegistry.addShapedRecipe(new ItemStack(ModArmors.Tenebrae_Chestplate), "IEI", "III", "III", 'I', ModItems.Tenebrae_Ingot);
		GameRegistry.addShapedRecipe(new ItemStack(ModArmors.Tenebrae_Leggings), "III", "IEI", "IEI", 'I', ModItems.Tenebrae_Ingot);
		GameRegistry.addShapedRecipe(new ItemStack(ModArmors.Tenebrae_Boots), "IEI", "IEI", 'I', ModItems.Tenebrae_Ingot);

	}
	
	public static void registerInfusionRecipes() {
		
//		InfusionRecipeHandler.instance().addInfusion(new ItemStack(Blocks.wool), new ItemStack(Blocks.planks), 0, new ItemStack(Items.nether_star, 2, 0), new ItemStack(Items.arrow, 3, 0));
		InfusionRecipeHandler.instance().addInfusion(new ItemStack(ModBlocks.Tenebrae_Block), new ItemStack(ModBlocks.Infused_Tenebrae), 0, new ItemStack(ModItems.Raw_Tenebrae, 1, 0), new ItemStack(ModItems.Soul_Essence, 1, 0));
		
	}
}
