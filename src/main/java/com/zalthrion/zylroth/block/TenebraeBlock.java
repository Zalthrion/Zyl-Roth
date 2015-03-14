package com.zalthrion.zylroth.block;

import java.util.List;
import java.util.Random;

import com.zalthrion.zylroth.itemblock.BeaconBaseItemBlock;
import com.zalthrion.zylroth.lib.*;
import com.zalthrion.zylroth.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;

public class TenebraeBlock extends Block{
	
   private String name = "Tenebrae_Block";
	 
   public TenebraeBlock(){
	 
      super(Material.rock);
      this.setUnlocalizedName(Reference.MOD_ID + "_" + name);
      this.setCreativeTab(ModTabs.Project_Exanimus);
      this.setHardness(3.0F);
  	  this.setHarvestLevel("pickaxe", 2);
  	  this.setResistance(5.0F);
  	  this.setStepSound(soundTypeMetal);
      GameRegistry.registerBlock(this, BeaconBaseItemBlock.class, name);
      setTextureName(Reference.MOD_ID + ":" + name);
      
   }
   
   @Override
   public boolean isBeaconBase (IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ)
   {
	  return true;
   }
   
}
