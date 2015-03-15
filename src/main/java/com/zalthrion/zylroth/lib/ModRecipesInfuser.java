package com.zalthrion.zylroth.lib;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

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
    private Map experienceInfusingList = new HashMap();
    
	public static void init() {
		ModRecipesInfuser.init();
	}
    
    /**
     * Used to call methods addInfusing and getInfusingResult.
     */
    public static ModRecipesInfuser infusing()
    {
        return infusingBase;
    }

    private ModRecipesInfuser()
    {
    	  this.addInfusion(new ItemStack(ModItems.Soul_Essence), new ItemStack(ModItems.Cursed_Soul_Essence), 1, 0.0F);
    }

    public void addInfusion(ItemStack p_151394_1_, ItemStack p_151394_2_, int quantity, float p_151394_3_)
    {
        this.infusingList.put(p_151394_1_, p_151394_2_);
        this.experienceInfusingList.put(p_151394_2_, Float.valueOf(p_151394_3_));
    }

    /**
     * Returns the infusing result of an item.
     */
    public ItemStack getInfusingResult(ItemStack slots)
    {
        Iterator iterator = this.infusingList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.func_151397_a(slots, (ItemStack)entry.getKey()));

        return (ItemStack)entry.getValue();
    }

    private boolean func_151397_a(ItemStack p_151397_1_, ItemStack p_151397_2_)
    {
        return p_151397_2_.getItem() == p_151397_1_.getItem() && (p_151397_2_.getCurrentDurability() == 32767 || p_151397_2_.getCurrentDurability() == p_151397_1_.getCurrentDurability());
    }

    public Map getInfusingList()
    {
        return this.infusingList;
    }

    public float getInfusingExperience(ItemStack p_151398_1_)
    {
        float ret = p_151398_1_.getItem().getSmeltingExperience(p_151398_1_);
        if (ret != -1) return ret;

        Iterator iterator = this.experienceInfusingList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 0.0F;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.func_151397_a(p_151398_1_, (ItemStack)entry.getKey()));

        return ((Float)entry.getValue()).floatValue();
    }
    
}