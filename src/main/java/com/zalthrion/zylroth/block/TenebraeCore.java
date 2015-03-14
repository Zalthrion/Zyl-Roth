package com.zalthrion.zylroth.block;

import java.util.Random;

import com.zalthrion.zylroth.itemblock.CoreItemBlock;
import com.zalthrion.zylroth.lib.*;
import com.zalthrion.zylroth.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;

public class TenebraeCore extends Block{
	
   private String name = "Tenebrae_Core";
	 
   public TenebraeCore(){
	 
      super(Material.rock);
      this.setUnlocalizedName(Reference.MOD_ID + "_" + name);
      this.setCreativeTab(ModTabs.Project_Exanimus);
      this.setHardness(3.0F);
  	  this.setHarvestLevel("pickaxe", 2);
  	  this.setResistance(5.0F);
  	  this.setStepSound(soundTypeMetal);
      GameRegistry.registerBlock(this, CoreItemBlock.class, name);
      setTextureName(Reference.MOD_ID + ":" + name);
      
   }
   
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        super.randomDisplayTick(par1World, par2, par3, par4, par5Random);

        for (int l = par2 - 2; l <= par2 + 2; ++l)
        {
            for (int i1 = par4 - 2; i1 <= par4 + 2; ++i1)
            {
                if (l > par2 - 2 && l < par2 + 2 && i1 == par4 - 1)
                {
                    i1 = par4 + 2;
                }

                if (par5Random.nextInt(16) == 0)
                {
                    for (int j1 = par3; j1 <= par3 + 1; ++j1)
                    {
                        {
                            if (!par1World.isAirBlock((l - par2) / 2 + par2, j1, (i1 - par4) / 2 + par4))
                            {
                                break;
                            }
                            
                            par1World.spawnParticle("portal", (double)par2 - -0.5F, (double)par3 - -0.5F, (double)par4 - -0.5F, (double)((float)(l - par2) + par5Random.nextFloat() - 0.1F), (double)((float)(j1 - par3) - par5Random.nextFloat() - 0.1F), (double)((float)(i1 - par4) + par5Random.nextFloat()) - 0.1F);
                        }
                    }
                }
            }
        }
    }
}
