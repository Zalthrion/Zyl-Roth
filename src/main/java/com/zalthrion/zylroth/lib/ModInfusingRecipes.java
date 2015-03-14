package com.zalthrion.zylroth.lib;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public final class ModInfusingRecipes {
	
    private static final ModInfusingRecipes infusingBase = new ModInfusingRecipes();
    
    /** The list of infusing results. */
    private HashMap<List<Integer>, Float> metaExperience = new HashMap<List<Integer>, Float>();
    private Map infusingList = new HashMap();
    private Map experienceList = new HashMap();
	
    public static ModInfusingRecipes infusing()
    {
        return infusingBase;
    }
	
    public static void init() {
        registerSpecialRecipes();
    }

	private static void registerSpecialRecipes(){
		
		GameRegistry.addSmelting(ModItems.Soul_Essence, new ItemStack(ModItems.Cursed_Soul_Essence), 0.0F);
	}
	
    /**
     * Returns the infusing result of an item.
     * @param slots 
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
        return p_151397_2_.getItem() == p_151397_1_.getItem() && (p_151397_2_.getItemDamage() == 32767 || p_151397_2_.getItemDamage() == p_151397_1_.getItemDamage());
    }
    
    /**
     * Grabs the amount of base experience for this item to give when pulled from the furnace slot.
     */
    public float getExperience(ItemStack item)
    {
        if (item == null || item.getItem() == null)
        {
            return 0;
        }
        float ret = -1; // value returned by "item.getItem().getSmeltingExperience(item);" when item doesn't specify experience to give
        if (ret < 0 && metaExperience.containsKey(Arrays.asList(item.getItem(), item.getItemDamage())))
        {
            ret = metaExperience.get(Arrays.asList(item.getItem(), item.getItemDamage()));
        }
        if (ret < 0 && experienceList.containsKey(item.getItem()))
        {
            ret = ((Float)experienceList.get(item.getItem())).floatValue();
        }
        return (ret < 0 ? 0 : ret);
    }
    
}
