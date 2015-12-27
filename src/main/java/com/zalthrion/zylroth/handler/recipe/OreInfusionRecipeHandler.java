package com.zalthrion.zylroth.handler.recipe;

import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.item.ItemStack;

public class OreInfusionRecipeHandler {
	/** Instance of this class **/
	private static final OreInfusionRecipeHandler instance = new OreInfusionRecipeHandler();
	/** List of recipes **/
	private ArrayList<OreInfusionRecipeLib> recipes = new ArrayList<OreInfusionRecipeLib>();
	private HashMap<ItemStack, Float> experienceList = new HashMap<ItemStack, Float>();
	
	/**
	 * Gets the instance of the class, this is where new {@link OreInfusionRecipeLib}'s are registered.
	 * @return Instance of {@link OreInfusionRecipeHandler}
	 */
	public static OreInfusionRecipeHandler instance() {
		return instance;
	}
	
	/**
	 * Registers an infusion recipe.
	 * @param input - Input ItemStack.
	 * @param output - Output ItemStack.
	 * @param experience - Experience for performing infusion.
	 * @param oreInfusionMaterials - Maximum of two, Item Stacks that you infuse the input with to get the output. Supports stack sizes.
	 */
	public void addOreInfusion(ItemStack input, ItemStack output, float experience, ItemStack... oreInfusionMaterials) {
		this.recipes.add(new OreInfusionRecipeLib(input, output, oreInfusionMaterials));
		this.experienceList.put(output, experience);
	}
	
	public static boolean arrayListContainsItemStack(ArrayList<ItemStack> list, ItemStack checkFor) {
		for (ItemStack stack : list) {
			if (stack.getItem() == checkFor.getItem())
				return true;
		}
		return false;
	}
	
	/**
	 * Is a recipe registered for the input and oreInfusionMaterials?
	 * @param input - ItemStack to be infused
	 * @param oreInfusionMaterials - Infusion Materials
	 * @return Whether the ingredients will produce an infusion or not.
	 */
	public boolean isValidRecipe(ItemStack input, ItemStack... oreInfusionMaterials) {
		if (input == null)
			return false;
		recipeLoop: for (OreInfusionRecipeLib recipe : this.recipes) {
			if (!(recipe.getInput().getItem() == input.getItem()))
				continue recipeLoop;
			ArrayList<ItemStack> recipeRequirements = new ArrayList<ItemStack>(recipe.getOreInfusionMaterials());
			providedStacks: for (ItemStack provided : oreInfusionMaterials) {
				if (provided == null)
					continue providedStacks;
				if (!arrayListContainsItemStack(recipeRequirements, provided))
					return false;
				rRLoop: for (ItemStack reqStack : recipeRequirements) {
					if (provided.getItem() != reqStack.getItem())
						continue rRLoop;
					if (provided.stackSize >= reqStack.stackSize) {
						recipeRequirements.remove(reqStack);
						continue providedStacks;
					}
				}
			}
			if (recipeRequirements.isEmpty())
				return true;
		}
		return false;
	}
	
	/**
	 * Gets the a copy of the recipe from an input and infusion materials.
	 * Useful for manipulating stack sizes or giving experience later.
	 * This runs isValidRecipe and returns null if no valid recipe is found.
	 * @param input - Item to be infused
	 * @param oreInfusionMaterials - Infusion Materials
	 * @return A copy of the recipe.
	 */
	public OreInfusionRecipeLib getRecipe(ItemStack input, ItemStack... oreInfusionMaterials) {
		if (input == null)
			return null;
		recipeLoop: for (OreInfusionRecipeLib recipe : this.recipes) {
			if (!(recipe.getInput().getItem() == input.getItem()))
				continue recipeLoop;
			ArrayList<ItemStack> recipeRequirements = new ArrayList<ItemStack>(recipe.getOreInfusionMaterials());
			providedStacks: for (ItemStack provided : oreInfusionMaterials) {
				if (provided == null)
					continue providedStacks;
				if (!arrayListContainsItemStack(recipeRequirements, provided))
					return null;
				rRLoop: for (ItemStack reqStack : recipeRequirements) {
					if (provided.getItem() != reqStack.getItem())
						continue rRLoop;
					if (provided.stackSize >= reqStack.stackSize) {
						recipeRequirements.remove(reqStack);
						continue providedStacks;
					}
				}
			}
			if (recipeRequirements.isEmpty())
				return recipe;
		}
		return null;
	}
	
	/**
	 * Returns how much experience is dropped
	 * @param output - The stack crafted by the OreInfusion
	 * @return Experience dropped
	 */
	public float getInfusionExperience(ItemStack output) {
		if (!this.experienceList.containsKey(output)) return 0F;
		return this.experienceList.get(output);
	}
	
	/**
	 * All registered ore infusion recipes.
	 * @return A copy of registered recipes.
	 */
	public ArrayList<OreInfusionRecipeLib> getOreInfusingList() {
		return new ArrayList<OreInfusionRecipeLib>(this.recipes);
	}
}