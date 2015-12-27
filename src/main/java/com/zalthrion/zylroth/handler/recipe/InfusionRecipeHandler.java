package com.zalthrion.zylroth.handler.recipe;

import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.item.ItemStack;

public class InfusionRecipeHandler {
	/** Instance of this class **/
	private static final InfusionRecipeHandler instance = new InfusionRecipeHandler();
	/** List of recipes **/
	private ArrayList<InfusionRecipeLib> recipes = new ArrayList<InfusionRecipeLib>();
	private HashMap<ItemStack, Float> experienceList = new HashMap<ItemStack, Float>();
	
	/**
	 * Gets the instance of the class, this is where new {@link InfusionRecipeLib}'s are registered.
	 * @return Instance of {@link InfusionRecipeHandler}
	 */
	public static InfusionRecipeHandler instance() { return instance; }
	/**
	 * Registers an infusion recipe.
	 * @param input - Input ItemStack.
	 * @param output - Output ItemStack.
	 * @param experience - Experience for performing infusion.
	 * @param infusionMaterials - Maximum of two, Item Stacks that you infuse the input with to get the output. Supports stack sizes.
	 */
	public void addInfusion(ItemStack input, ItemStack output, float experience, ItemStack... infusionMaterials) {
		this.recipes.add(new InfusionRecipeLib(input, output, infusionMaterials));
		this.experienceList.put(output, experience);
	}
	
	public static boolean arrayListContainsItemStack(ArrayList<ItemStack> list, ItemStack checkFor) {
		for (ItemStack stack : list) {
			if (stack.getItem() == checkFor.getItem()) return true;
		}
		return false;
	}
	
	/**
	 * Is a recipe registered for the input and infusionMaterials?
	 * @param input - ItemStack to be infused
	 * @param infusionMaterials - Infusion Materials
	 * @return Whether the ingredients will produce an infusion or not.
	 */
	public boolean isValidRecipe(ItemStack input, ItemStack... infusionMaterials) {
		if (input == null) return false;
		recipeLoop: for (InfusionRecipeLib recipe : this.recipes) {
			if (!(recipe.getInput().getItem() == input.getItem())) continue recipeLoop;
			ArrayList<ItemStack> recipeRequirements = new ArrayList<ItemStack>(recipe.getInfusionMaterials());
			providedStacks: for (ItemStack provided : infusionMaterials) {
				if (provided == null) continue providedStacks;
				if (!arrayListContainsItemStack(recipeRequirements, provided)) return false;
				rRLoop: for (ItemStack reqStack : recipeRequirements) {
					if (provided.getItem() != reqStack.getItem()) continue rRLoop;
					if (provided.stackSize >= reqStack.stackSize) {
						recipeRequirements.remove(reqStack);
						continue providedStacks;
					}
				}
			}
			if (recipeRequirements.isEmpty()) return true;
		}
		return false;
	}
	
	/**
	 * Gets the a copy of the recipe from an input and infusion materials.
	 * Useful for manipulating stack sizes or giving experience later.
	 * This runs isValidRecipe and returns null if no valid recipe is found.
	 * @param input - Item to be infused
	 * @param infusionMaterials - Infusion Materials
	 * @return A copy of the recipe.
	 */
	public InfusionRecipeLib getRecipe(ItemStack input, ItemStack... infusionMaterials) {
		if (input == null) return null;
		recipeLoop: for (InfusionRecipeLib recipe : this.recipes) {
			if (!(recipe.getInput().getItem() == input.getItem())) continue recipeLoop;
			ArrayList<ItemStack> recipeRequirements = new ArrayList<ItemStack>(recipe.getInfusionMaterials());
			providedStacks: for (ItemStack provided : infusionMaterials) {
				if (provided == null) continue providedStacks;
				if (!arrayListContainsItemStack(recipeRequirements, provided)) return null;
				rRLoop: for (ItemStack reqStack : recipeRequirements) {
					if (provided.getItem() != reqStack.getItem()) continue rRLoop;
					if (provided.stackSize >= reqStack.stackSize) {
						recipeRequirements.remove(reqStack);
						continue providedStacks;
					}
				}
			}
			if (recipeRequirements.isEmpty()) return recipe;
		}
		return null;
	}
	
	/**
	 * Returns how much experience is dropped
	 * @param output - The stack crafted by the Infusion
	 * @return Experience dropped
	 */
	public float getInfusionExperience(ItemStack output) {
		if (!this.experienceList.containsKey(output)) return 0F;
		return this.experienceList.get(output);
	}
	
	/**
	 * All registered infusion recipes.
	 * @return A copy of registered recipes.
	 */
	public ArrayList<InfusionRecipeLib> getInfusingList() { return new ArrayList<InfusionRecipeLib>(this.recipes); }
}