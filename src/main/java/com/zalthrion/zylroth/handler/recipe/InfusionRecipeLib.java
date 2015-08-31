package com.zalthrion.zylroth.handler.recipe;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;

public class InfusionRecipeLib {
	private ItemStack input;
	private ItemStack output;
	private int experience;
	private ArrayList<ItemStack> infusionMaterials;
	
	/** Creates a new InfusionRecipe
	 * @param in - ItemStack being infused
	 * @param out - ItemStack after infusion
	 * @param experience - Experience earned from performing this infusion.
	 * @param infusingMaterials - Materials used to infuse */
	public InfusionRecipeLib(ItemStack in, ItemStack out, int experience, ItemStack... infusionMaterials) {
		this.input = in;
		this.output = out;
		this.experience = experience;
		this.infusionMaterials = new ArrayList<ItemStack>();
		for (ItemStack stack : infusionMaterials) {
			this.infusionMaterials.add(stack);
		}
	}
	
	@Deprecated
	public InfusionRecipeLib(ItemStack in, ItemStack out, ItemStack... infusionMaterials) {
		this(in, out, 0, infusionMaterials);
	}
	
	/** Returns amount of experience earned from performing this infusion **/
	public int getExperience() {
		return this.experience;
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
	public ArrayList<ItemStack> getInfusionMaterials() {
		return infusionMaterials;
	}
	
	public InfusionRecipeLib copy() {
		return new InfusionRecipeLib(this.input, this.output, this.experience, this.infusionMaterials.toArray(new ItemStack[this.infusionMaterials.size()]));
	}
}