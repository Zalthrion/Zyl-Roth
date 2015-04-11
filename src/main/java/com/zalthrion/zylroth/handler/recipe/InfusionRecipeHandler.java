package com.zalthrion.zylroth.handler.recipe;

import java.util.HashMap;
import java.util.Set;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class InfusionRecipeHandler {
	private static final InfusionRecipeHandler infusingBase = new InfusionRecipeHandler();
	/** The list of infusing results. */
	private HashMap<InfusionRecipeLib, Integer> recipeExperienceMap = new HashMap<InfusionRecipeLib, Integer>();
	
	public static InfusionRecipeHandler infusing() {
		return infusingBase;
	}
	
	public void addInfusion(ItemStack input, ItemStack output, ItemStack... infusionMaterials) {
		addInfusion(input, output, 0, infusionMaterials);
	}
	
	public void addInfusion(ItemStack input, ItemStack output, int experience, ItemStack... infusionMaterials) {
		this.recipeExperienceMap.put(new InfusionRecipeLib(input, output, infusionMaterials), experience);
	}
	
	public ItemStack[] getInfusingIngredients(ItemStack input, ItemStack... infusionMaterials) {
		if (input.getItem() == null) return null;
		recipe_loop: for (InfusionRecipeLib ir : recipeExperienceMap.keySet()) {
			if (ir.getInput().getItem() == input.getItem()) {
				HashMap<Item, Integer> reqInfMat = new HashMap<Item, Integer>();
				for (ItemStack infusionMat : ir.getInfusionMaterials()) {
					reqInfMat.put(infusionMat.getItem(), infusionMat.stackSize);
				}
				matCheck: for (ItemStack enteredMat : infusionMaterials) {
					if (enteredMat == null) continue matCheck;
					if (!reqInfMat.containsKey(enteredMat.getItem())) continue recipe_loop;
					if (reqInfMat.get(enteredMat.getItem()) > enteredMat.stackSize) continue recipe_loop;
				}
				for (Item item : reqInfMat.keySet()) {
					boolean found = false;
					matCheck: for (ItemStack stack : infusionMaterials) {
						if (stack == null) continue matCheck;
						if (stack.getItem() == item) found = true;
					}
					if (!found) continue recipe_loop;
				}
			} else {
				continue recipe_loop;
			}
			return ir.getInfusionMaterials();
		}
		return null;
	}
	
	public int getInfusingIngredientAmount(ItemStack input, ItemStack ing, ItemStack... infusionMaterials) {
		if (input.getItem() == null) return 0;
		recipe_loop: for (InfusionRecipeLib ir : recipeExperienceMap.keySet()) {
			if (ir.getInput().getItem() == input.getItem()) {
				HashMap<Item, Integer> reqInfMat = new HashMap<Item, Integer>();
				for (ItemStack infusionMat : ir.getInfusionMaterials()) {
					reqInfMat.put(infusionMat.getItem(), infusionMat.stackSize);
				}
				matCheck: for (ItemStack enteredMat : infusionMaterials) {
					if (enteredMat == null) continue matCheck;
					if (!reqInfMat.containsKey(enteredMat.getItem())) continue recipe_loop;
					if (reqInfMat.get(enteredMat.getItem()) > enteredMat.stackSize) continue recipe_loop;
				}
				for (Item item : reqInfMat.keySet()) {
					boolean found = false;
					matCheck: for (ItemStack stack : infusionMaterials) {
						if (stack == null) continue matCheck;
						if (stack.getItem() == item) found = true;
					}
					if (!found) continue recipe_loop;
				}
			} else {
				continue recipe_loop;
			}
			for (ItemStack stack : ir.getInfusionMaterials()) {
				if (stack.getItem() == ing.getItem()) { return stack.stackSize; }
			}
		}
		return 0;
	}
	
	/** Returns the infusing result of an item. */
	public ItemStack getInfusingResult(ItemStack input, ItemStack... infusionMaterials) {
		if (input.getItem() == null) return null;
		recipe_loop: for (InfusionRecipeLib ir : recipeExperienceMap.keySet()) {
			if (ir.getInput().getItem() == input.getItem()) {
				HashMap<Item, Integer> reqInfMat = new HashMap<Item, Integer>();
				for (ItemStack infusionMat : ir.getInfusionMaterials()) {
					reqInfMat.put(infusionMat.getItem(), infusionMat.stackSize);
				}
				matCheck: for (ItemStack enteredMat : infusionMaterials) {
					if (enteredMat == null) continue matCheck;
					if (!reqInfMat.containsKey(enteredMat.getItem())) continue recipe_loop;
					if (reqInfMat.get(enteredMat.getItem()) > enteredMat.stackSize) continue recipe_loop;
				}
				for (Item item : reqInfMat.keySet()) {
					boolean found = false;
					matCheck: for (ItemStack stack : infusionMaterials) {
						if (stack == null) continue matCheck;
						if (stack.getItem() == item) found = true;
					}
					if (!found) continue recipe_loop;
				}
			} else {
				continue recipe_loop;
			}
			return ir.getOutput();
		}
		return null;
	}
	
	public Set<InfusionRecipeLib> getInfusingList() {
		return this.recipeExperienceMap.keySet();
	}
	
	public float getInfusionExperience(ItemStack stack, ItemStack... infusionMaterials) {
		/* float ret = stack.getItem().getSmeltingExperience(stack); if (ret !=
		 * -1) return ret; Iterator iterator =
		 * this.experienceList.entrySet().iterator(); Entry entry; do { if
		 * (!iterator.hasNext()) { return 0.0F; } entry =
		 * (Entry)iterator.next(); } while (!this.compareItemStacks(stack,
		 * (ItemStack)entry.getKey())); return
		 * ((Float)entry.getValue()).floatValue(); */
		return 0F; // TODO Rework this
	}
}