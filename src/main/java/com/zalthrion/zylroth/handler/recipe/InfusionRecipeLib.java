package com.zalthrion.zylroth.handler.recipe;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;

import com.zalthrion.zylroth.block.machine.InfuserType;

public class InfusionRecipeLib {
	private InfuserType type;
	private float experience;
	private int infuseTime;
	private ItemStack output;
	private ItemStack input;
	private ArrayList<ItemStack> infusionMaterials;
	
	/** Creates a new InfusionRecipe
	 * @param type - Type of infuser required to perform this recipe
	 * @param experience - Experience earned from performing this infusion.
	 * @param cookTime - Ticks taken to infuse
	 * @param out - ItemStack after infusion
	 * @param in - ItemStack being infused
	 * @param infusingMaterials - Materials used to infuse */
	public InfusionRecipeLib(InfuserType type, float experience, int infuseTime, ItemStack out, ItemStack in, ItemStack... infusionMaterials) {
		this.type = type;
		this.experience = experience;
		this.infuseTime = infuseTime;
		this.input = in;
		this.output = out;
		this.infusionMaterials = new ArrayList<ItemStack>();
		for (ItemStack stack : infusionMaterials) {
			this.infusionMaterials.add(stack);
		}
	}
	
	/** Returns the type of infuser required to perform this recipe */
	public InfuserType getRequiredType() {
		return this.type;
	}
	
	/** Returns the amount of experience earned from performing this infusion */
	public float getExperience() {
		return this.experience;
	}
	
	/** Returns the amoutn of ticks taken to perform this infusion */
	public int getInfuseTime() {
		return this.infuseTime;
	}
	
	/** Returns ItemStack after infusion */
	public ItemStack getOutput() {
		return this.output;
	}
	
	/** Returns ItemStack being infused */
	public ItemStack getInput() {
		return this.input;
	}
	
	/** Returns ItemStack's required to infuse this item */
	public ArrayList<ItemStack> getInfusionMaterials() {
		return infusionMaterials;
	}
	
	public InfusionRecipeLib copy() {
		return new InfusionRecipeLib(this.type, this.experience, this.infuseTime, this.output, this.input, this.infusionMaterials.toArray(new ItemStack[this.infusionMaterials.size()]));
	}
}