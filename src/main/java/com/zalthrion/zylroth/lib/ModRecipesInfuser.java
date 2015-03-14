package com.zalthrion.zylroth.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.zalthrion.zylroth.handler.CustomRecipeHandler;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemStack;

public class ModRecipesInfuser
{
    private static final ModRecipesInfuser infusingBase = new ModRecipesInfuser();
    /** The list of infusing results. */
    private Map infusingList = new HashMap();
    private Map experienceList = new HashMap();
    
    /**
     * Used to call methods addInfusing and getInfusingResult.
     */
    public static ModRecipesInfuser infusing()
    {
        return infusingBase;
    }
    
    public static void init() {
    	ArrayList<CustomRecipeHandler> recipes;
    }

	private ArrayList<CustomRecipeHandler> recipes = new ArrayList<CustomRecipeHandler>() {
		{
			add(new CustomRecipeHandler(new ItemStack[] {
					new ItemStack(net.minecraft.init.Items.apple),
					new ItemStack(net.minecraft.init.Items.potato)
			}, new ItemStack(net.minecraft.init.Blocks.wool), new int[] {3, 2}));
		}
	};
	

    public void addInfusion(ItemStack p_151394_1_, ItemStack p_151394_2_, int quantity, float p_151394_3_)
    {
        this.infusingList.put(p_151394_1_, p_151394_2_);
        this.experienceList.put(p_151394_2_, Float.valueOf(p_151394_3_));
    }

    /**
     * Returns the infusing result of an item.
     */
	public ItemStack getInfusingResult(ItemStack[] input) {
		ItemStack res = null;
		recipe_loop: for (CustomRecipeHandler cr : recipes) {
			int stackNum = 0;
			for (ItemStack stack : cr.getIngrediants()) {
				if (stack != input[stackNum]) continue recipe_loop;
				if (input[stackNum].stackSize >= cr.getAmountForIngrediant(stackNum)) {}
				else continue recipe_loop;
				stackNum ++;
			}
			res = cr.getOutput();
		}
		return res;
	}

    private boolean func_151397_a(ItemStack p_151397_1_, ItemStack p_151397_2_)
    {
        return p_151397_2_.getItem() == p_151397_1_.getItem() && (p_151397_2_.getCurrentDurability() == 32767 || p_151397_2_.getCurrentDurability() == p_151397_1_.getCurrentDurability());
    }

    public Map getInfusingList()
    {
        return this.infusingList;
    }

    public float getInfusionExperience(ItemStack stack)
    {
        float ret = stack.getItem().getSmeltingExperience(stack);
        if (ret != -1) return ret;

        Iterator iterator = this.experienceList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 0.0F;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.func_151397_a(stack, (ItemStack)entry.getKey()));

        return ((Float)entry.getValue()).floatValue();
    }
    
}