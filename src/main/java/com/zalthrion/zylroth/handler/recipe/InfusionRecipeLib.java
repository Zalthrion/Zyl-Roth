package com.zalthrion.zylroth.handler.recipe;

import net.minecraft.item.ItemStack;

public class InfusionRecipeLib {
	private ItemStack input;
	private ItemStack output;
	private ItemStack[] infusionMaterials;
	
	/** Creates a new InfusionRecipe
	 * @param in - ItemStack being infused
	 * @param out - ItemStack after infusion
	 * @param infusingMaterials - Materials used to infuse */
	public InfusionRecipeLib(ItemStack in, ItemStack out, ItemStack... infusionMaterials) {
		this.input = in;
		this.output = out;
		this.infusionMaterials = infusionMaterials;
	}
	
	/** Returns ItemStack after infusion **/
	public ItemStack getOutput() {
		return this.output;
	}
	
	/** Returns ItemStack being infused **/
	public ItemStack getInput() {
		return this.input;
	}
	
	/** Returns ItemStack's required to infuse this item **/
	public ItemStack[] getInfusionMaterials() {
		return infusionMaterials;
	}
}
