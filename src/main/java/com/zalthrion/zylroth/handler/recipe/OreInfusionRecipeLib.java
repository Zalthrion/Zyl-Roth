package com.zalthrion.zylroth.handler.recipe;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;

public class OreInfusionRecipeLib {
	private ItemStack input;
	private ItemStack output;
	private ArrayList<ItemStack> oreInfusionMaterials;
	
	/** Creates a new InfusionRecipe
	 * @param in - ItemStack being infused
	 * @param out - ItemStack after oreInfusion
	 * @param experience - Experience earned from performing this oreInfusion.
	 * @param infusingMaterials - Materials used to infuse */
	public OreInfusionRecipeLib(ItemStack in, ItemStack out, ItemStack... oreInfusionMaterials) {
		this.input = in;
		this.output = out;
		this.oreInfusionMaterials = new ArrayList<ItemStack>();
		for (ItemStack stack : oreInfusionMaterials) {
			this.oreInfusionMaterials.add(stack);
		}
	}
	
	/** Returns ItemStack after oreInfusion **/
	public ItemStack getOutput() {
		return this.output;
	}
	
	/** Returns ItemStack being infused **/
	public ItemStack getInput() {
		return this.input;
	}
	
	/** Returns ItemStack's required to infuse this item **/
	public ArrayList<ItemStack> getOreInfusionMaterials() {
		return oreInfusionMaterials;
	}
	
	public OreInfusionRecipeLib copy() {
		return new OreInfusionRecipeLib(this.input, this.output, this.oreInfusionMaterials.toArray(new ItemStack[this.oreInfusionMaterials.size()]));
	}
}