package com.zalthrion.zylroth.handler.recipe;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.item.ItemStack;

import com.zalthrion.zylroth.block.tile.InfuserType;

//TODO Check
public class InfusionRecipeHandler {
	/** Instance of this class **/
	private static final InfusionRecipeHandler instance = new InfusionRecipeHandler();
	/** List of recipes **/
	private ArrayList<InfusionRecipeLib> recipes = new ArrayList<InfusionRecipeLib>();
	
	/**
	 * Gets the instance of the class, this is where new {@link InfusionRecipeLib}'s are registered.
	 * @return Instance of {@link InfusionRecipeHandler}
	 */
	public static InfusionRecipeHandler instance() {
		return instance;
	}
	
	/**
	 * Registers an infusion recipe.
	 * @param type - Type of infuser required
	 * @param experience - Experience earned for performing infusion
	 * @param infusionTime - Ticks it takes to perform this infusion
	 * @param output - Output ItemStack.
	 * @param input - Input ItemStack.
	 * @param infusionMaterials - Maximum of two, Item Stacks that you infuse the input with to get the output. Supports stack sizes.
	 */
	public void addInfusion(InfuserType type, float experience, int infusionTime, ItemStack output, ItemStack input, ItemStack... infusionMaterials) {
		this.recipes.add(new InfusionRecipeLib(type, experience, infusionTime, output, input, infusionMaterials));
	}
	
	public float getExperience(InfuserType infuserType, ItemStack input, ItemStack... infusionMaterials) {
		if (getRecipe(infuserType, input, infusionMaterials) == null) return 0;
		return getRecipe(infuserType, input, infusionMaterials).getExperience();
	}
	
	/**
	 * All registered infusion recipes.
	 * @return A copy of registered recipes.
	 */
	public ArrayList<InfusionRecipeLib> getInfusingList() { return new ArrayList<InfusionRecipeLib>(this.recipes); }
	
	/**
	 * How long it takes to perform this infusion recipe
	 * @param input - The main infusion material
	 * @param infusionMaterialOne - The first infusion material
	 * @param infusionMaterialTwo - The second infusion material
	 * @return
	 */
	public int getInfusionTime(InfuserType infuserType, ItemStack input, ItemStack... infusionMaterials) {
		if (getRecipe(infuserType, input, infusionMaterials) == null) return 0;
		return getRecipe(infuserType, input, infusionMaterials).getInfuseTime();
	}
	
	public ArrayList<Integer> getMaterialCosts(InfuserType type, ItemStack input, ItemStack... infusionMaterials) {
		InfusionRecipeLib recipe = getRecipe(type, input, infusionMaterials);
		if (recipe == null) return null;
		ArrayList<ItemStack> requiredList = recipe.getInfusionMaterials();
		ArrayList<Integer> ret = new ArrayList<Integer>();
		ret.add(recipe.getInput().copy().stackSize);
		
		for (ItemStack passed : infusionMaterials) {
			Iterator<ItemStack> requiredIterator = requiredList.iterator();
			requiredLoop: while (requiredIterator.hasNext()) {
				ItemStack required = requiredIterator.next();
				if (passed.getItem() != required.getItem()) continue requiredLoop;
				if (passed.stackSize < required.stackSize) continue requiredLoop;
				ret.add(required.stackSize);
				requiredIterator.remove();
			}
		}
		return ret;
	}
	
	/**
	 * Gets a copy of the recipe from an input and infusion materials.
	 * Useful for manipulating stack sizes or giving experience later.
	 * @param infuserType - The type of infuser being used
	 * @param input - Item to be infused
	 * @param infusionMaterials - Infusion Materials
	 * @return A copy of the recipe.
	 */
	public InfusionRecipeLib getRecipe(InfuserType infuserType, ItemStack input, ItemStack... infusionMaterials) {
		if (input == null || infusionMaterials.length <= 0 || infusionMaterials == null) return null;
		recipeLoop: for (InfusionRecipeLib recipe : this.getInfusingList()) {
			if (recipe.getRequiredType() != infuserType) continue recipeLoop; // If the infuserType isn't the required type for the recipe, continue the loop.
			if (recipe.getInput().getItem() == input.getItem()) {
				if (recipe.getInput().stackSize > input.stackSize) continue recipeLoop; // If the required input stack size is more than the input stack size, continue the loop.
				if (!arrayListContainsAll(recipe.getInfusionMaterials(), infusionMaterials)) continue recipeLoop;
				return recipe.copy();
			}
		}
		return null;
	}
	
	/**
	 * Is a recipe registered for the input and infusionMaterials?
	 * @param infuserType - The type of infuser being used
	 * @param input - ItemStack to be infused
	 * @param infusionMaterials - Infusion Materials
	 * @return Whether the ingredients will produce an infusion or not.
	 */
	public boolean isValidRecipe(InfuserType infuserType, ItemStack input, ItemStack... infusionMaterials) {
		return getRecipe(infuserType, input, infusionMaterials) != null;
	}
	
	public static boolean arrayListContainsAll(ArrayList<ItemStack> list, ItemStack[] members) {
		ArrayList<ItemStack> copyList = new ArrayList<ItemStack>(list);
		Iterator<ItemStack> requiredIterator = copyList.iterator();
		while (requiredIterator.hasNext()) {
			ItemStack required = requiredIterator.next();
			boolean found = false;
			memberLoop: for (ItemStack member : members) {
				if (member == null || required == null) continue memberLoop; // I don't know why I need to do a null check here but yea.
				if (!(member.getItem() == required.getItem())) continue memberLoop;
				if (required.stackSize > member.stackSize) continue memberLoop;
				found = true;
			}
			if (!found) return false;
		}
		return true;
	}
}