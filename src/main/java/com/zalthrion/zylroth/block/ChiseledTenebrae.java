package com.zalthrion.zylroth.block;

import java.util.Random;

import com.zalthrion.zylroth.entity.EntityMutantTenebraeGolem;
import com.zalthrion.zylroth.itemblock.HeadItemBlock;
import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.lib.ModTabs;
import com.zalthrion.zylroth.reference.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ChiseledTenebrae extends Block
{
	
    @SideOnly(Side.CLIENT)
    private IIcon field_149984_b;
    @SideOnly(Side.CLIENT)
    private IIcon field_149986_M;
    
    private String name = "Chiseled_Tenebrae";
	
	public ChiseledTenebrae()
    {
        super(Material.rock);
        this.setBlockName(Reference.MOD_ID + "_" + name);
        this.setCreativeTab(ModTabs.Project_Exanimus);
        this.setHardness(3.0F);
    	this.setHarvestLevel("pickaxe", 2);
    	this.setResistance(5.0F);
    	this.setStepSound(soundTypeMetal);
        GameRegistry.registerBlock(this, HeadItemBlock.class, name);
        setBlockTextureName(Reference.MOD_ID + ":" + name);
    }	
	
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_1_ == 1 ? this.field_149984_b : (p_149691_1_ == 0 ? this.field_149984_b : (p_149691_2_ == 2 && p_149691_1_ == 2 ? this.field_149986_M : (p_149691_2_ == 3 && p_149691_1_ == 5 ? this.field_149986_M : (p_149691_2_ == 0 && p_149691_1_ == 3 ? this.field_149986_M : (p_149691_2_ == 1 && p_149691_1_ == 4 ? this.field_149986_M : this.blockIcon)))));
    }
	 
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.field_149986_M = p_149651_1_.registerIcon(Reference.MOD_ID + ":" + name); //Face
        this.field_149984_b = p_149651_1_.registerIcon(Reference.MOD_ID + ":" + "Tenebrae_Block"); //Top
        this.blockIcon = p_149651_1_.registerIcon(Reference.MOD_ID + ":" + "Tenebrae_Block"); //Side
    }
	 
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	    {
	        super.onBlockAdded(par1World, par2, par3, par4);
	        
	        if (par1World.getBlock(par2, par3 - 1, par4) == ModBlocks.Tenebrae_Core && par1World.getBlock(par2, par3 - 2, par4) == ModBlocks.Infused_Tenebrae)
	        {
	            boolean flag = par1World.getBlock(par2 - 1, par3 - 1, par4) == ModBlocks.Infused_Tenebrae && par1World.getBlock(par2 + 1, par3 - 1, par4) == ModBlocks.Infused_Tenebrae;
	            boolean flag1 = par1World.getBlock(par2, par3 - 1, par4 - 1) == ModBlocks.Infused_Tenebrae && par1World.getBlock(par2, par3 - 1, par4 + 1) == ModBlocks.Infused_Tenebrae;

	            if (flag || flag1)
	            {
	                par1World.setBlock(par2, par3, par4, getBlockById(0), 0, 2);
	                par1World.setBlock(par2, par3 - 1, par4, getBlockById(0), 0, 2);
	                par1World.setBlock(par2, par3 - 2, par4, getBlockById(0), 0, 2);

	                if (flag)
	                {
	                    par1World.setBlock(par2 - 1, par3 - 1, par4, getBlockById(0), 0, 2);
	                    par1World.setBlock(par2 + 1, par3 - 1, par4, getBlockById(0), 0, 2);
	                }
	                else
	                {
	                    par1World.setBlock(par2, par3 - 1, par4 - 1, getBlockById(0), 0, 2);
	                    par1World.setBlock(par2, par3 - 1, par4 + 1, getBlockById(0), 0, 2);
	                }

	                EntityMutantTenebraeGolem entitymutanttenebraegolem = new EntityMutantTenebraeGolem(par1World);
	                entitymutanttenebraegolem.setPlayerCreated(true);
	                entitymutanttenebraegolem.setLocationAndAngles((double)par2 + 0.5D, (double)par3 - 1.95D, (double)par4 + 0.5D, 0.0F, 0.0F);
	                par1World.spawnEntityInWorld(entitymutanttenebraegolem);

	                for (int i1 = 0; i1 < 120; ++i1)
	                {
	                    par1World.spawnParticle("snowballpoof", (double)par2 + par1World.rand.nextDouble(), (double)(par3 - 2) + par1World.rand.nextDouble() * 3.9D, (double)par4 + par1World.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
	                }

	                par1World.notifyBlockChange(par2, par3, par4, getBlockById(0));
	                par1World.notifyBlockChange(par2, par3 - 1, par4, getBlockById(0));
	                par1World.notifyBlockChange(par2, par3 - 2, par4, getBlockById(0));

	                if (flag)
	                {
	                    par1World.notifyBlockChange(par2 - 1, par3 - 1, par4, getBlockById(0));
	                    par1World.notifyBlockChange(par2 + 1, par3 - 1, par4, getBlockById(0));
	                }
	                else
	                {
	                    par1World.notifyBlockChange(par2, par3 - 1, par4 - 1, getBlockById(0));
	                    par1World.notifyBlockChange(par2, par3 - 1, par4 + 1, getBlockById(0));
	                }
	            }
	        }
	    }
	    
	 
	 public void onBlockPlacedBy(World world, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
	    {
	        int l = MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
	        world.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
	    }
}
