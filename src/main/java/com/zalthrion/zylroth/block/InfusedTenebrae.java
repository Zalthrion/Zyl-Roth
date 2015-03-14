package com.zalthrion.zylroth.block;

import java.util.Random;

import com.zalthrion.zylroth.itemblock.TenebraeItemBlock;
import com.zalthrion.zylroth.lib.*;
import com.zalthrion.zylroth.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;

public class InfusedTenebrae extends Block{
	
   private String name = "Infused_Tenebrae";
	 
   public InfusedTenebrae(){
	 
      super(Material.rock);
      this.setUnlocalizedName(Reference.MOD_ID + "_" + name);
      this.setCreativeTab(ModTabs.Project_Exanimus);
      this.setHardness(3.0F);
  	  this.setHarvestLevel("pickaxe", 2);
  	  this.setResistance(5.0F);
  	  this.setStepSound(soundTypeMetal);
      GameRegistry.registerBlock(this, TenebraeItemBlock.class, name);
      setTextureName(Reference.MOD_ID + ":" + name);
      
   }
   
}
