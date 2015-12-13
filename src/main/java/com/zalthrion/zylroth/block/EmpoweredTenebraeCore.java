package com.zalthrion.zylroth.block;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.lib.ModTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EmpoweredTenebraeCore extends BlockBase {
	
	private String name = "empoweredTenebraeCore";
	
	public EmpoweredTenebraeCore() {
		super(Material.rock);
		this.setNames(name);
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeMetal);
		this.setCreativeTab(ModTabs.ZylRoth);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		IIcon tbIcon = ModBlocks.tenebraeCore.getIcon(0, 0);
		IIcon ret = side == 1 ? tbIcon : (side == 0 ? tbIcon : (meta == 2 && side == 2 ? this.blockIcon : (meta == 3 && side == 5 ? this.blockIcon : (meta == 0 && side == 3 ? this.blockIcon : (meta == 1 && side == 4 ? this.blockIcon : tbIcon)))));
		return ret;
	}
	
	@Override
	public void randomDisplayTick(World par1World, int x, int y, int z, Random par5Random) {
		super.randomDisplayTick(par1World, x, y, z, par5Random);
		
		for (int l = x - 2; l <= x + 2; ++ l) {
			for (int i1 = z - 2; i1 <= z + 2; ++ i1) {
				if (l > x - 2 && l < x + 2 && i1 == z - 1) {
					i1 = z + 2;
				}
				
				if (par5Random.nextInt(16) == 0) {
					for (int j1 = y; j1 <= y + 1; ++ j1) {
						{
							if (!par1World.isAirBlock((l - x) / 2 + x, j1, (i1 - z) / 2 + z)) {
								break;
							}
							
							par1World.spawnParticle("portal", (double) x - -0.5F, (double) y - -0.5F, (double) z - -0.5F, (double) ((float) (l - x) + par5Random.nextFloat() - 0.1F), (double) ((float) (j1 - y) - par5Random.nextFloat() - 0.1F), (double) ((float) (i1 - z) + par5Random.nextFloat()) - 0.1F);
						}
					}
				}
			}
		}
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase placer, ItemStack stack) {
		int l = MathHelper.floor_double((double) (placer.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
		world.setBlockMetadataWithNotify(x, y, z, l, 2);
	}
}
