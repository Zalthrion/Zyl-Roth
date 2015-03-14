package com.zalthrion.zylroth.lib;

import java.util.HashMap;
import java.util.Set;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.zalthrion.zylroth.handler.InfusionRecipe;

public class ModRecipesInfuser {
	private static final ModRecipesInfuser infusingBase = new ModRecipesInfuser();
	/** The list of infusing results. */
	private HashMap<InfusionRecipe, Integer> recipeExperienceMap = new HashMap<InfusionRecipe, Integer>();
	
	public static ModRecipesInfuser infusing() {
		return infusingBase;
	}
	
	public void addInfusion(ItemStack input, ItemStack output, ItemStack... infusionMaterials) {
		addInfusion(input, output, 0, infusionMaterials);
	}
	
	public void addInfusion(ItemStack input, ItemStack output, int experience, ItemStack... infusionMaterials) {
		this.recipeExperienceMap.put(new InfusionRecipe(input, output, infusionMaterials), experience);
	}
	
	/** Returns the infusing result of an item. */
	public ItemStack getInfusingResult(ItemStack input, ItemStack... infusionMaterials) {
		recipe_loop: for (InfusionRecipe ir : recipeExperienceMap.keySet()) {
			if (ir.getInput().getItem() == input.getItem()) {
				HashMap<Item, Integer> reqInfMat = new HashMap<Item, Integer>();
				for (ItemStack infusionMat : ir.getInfusionMaterials()) {
					reqInfMat.put(infusionMat.getItem(), infusionMat.stackSize);
				}
				for (ItemStack enteredMat : infusionMaterials) {
					if (!reqInfMat.containsKey(enteredMat.getItem())) continue recipe_loop;
					if (reqInfMat.get(enteredMat.getItem()) > enteredMat.stackSize) continue recipe_loop;
				}
				return ir.getOutput();
			}
		}
		return null;
	}
	
	public Set<InfusionRecipe> getInfusingList() {
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