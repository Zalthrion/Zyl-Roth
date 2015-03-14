package com.zalthrion.zylroth.block;

import java.util.Random;

import com.zalthrion.zylroth.lib.*;
import com.zalthrion.zylroth.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;

public class TenebraeOre extends Block{
	
   private String name = "Tenebrae_Ore";
	 
   public TenebraeOre(){
	 
      super(Material.rock);
      this.setBlockName(Reference.MOD_ID + "_" + name);
      this.setCreativeTab(ModTabs.Project_Exanimus);
      this.setHardness(3.0F);
  	  this.setHarvestLevel("pickaxe", 2);
  	  this.setResistance(5.0F);
  	  this.setStepSound(soundTypePiston);
      GameRegistry.registerBlock(this, name);
      setBlockTextureName(Reference.MOD_ID + ":" + name);

   }
  
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        super.randomDisplayTick(par1World, par2, par3, par4, par5Random);

        double d0 = (double)((float)par2 + (1.5F + par5Random.nextFloat() * 12.0F) / 16.0F);
        double d1 = (double)((float)par3 + 0.4F);
        double d2 = (double)((float)par4 + (1.5F + par5Random.nextFloat() * 12.0F) / 16.0F);
        double d3 = 0.0D;
        double d4 = 0.0D;
        double d5 = 0.0D;
        par1World.spawnParticle("portal", d0, d1, d2, d3, d4, d5);
    }
	    
}
