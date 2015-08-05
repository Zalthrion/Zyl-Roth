package com.zalthrion.zylroth.block;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.zalthrion.zylroth.entity.EntityEmpoweredTenebraeGolem;
import com.zalthrion.zylroth.entity.EntityTenebraeGolem;
import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.lib.ModTabs;
import com.zalthrion.zylroth.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ChiseledTenebrae extends BlockBase {
	private String name = "chiseledTenebrae";
	
	public ChiseledTenebrae() {
		super(Material.rock);
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeMetal);
		this.setNames(name);
		this.setCreativeTab(ModTabs.ZylRoth);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		IIcon tbIcon = ModBlocks.tenebrae_Block.getIcon(0, 0);
		IIcon ret = side == 1 ? tbIcon : (side == 0 ? tbIcon : (meta == 2 && side == 2 ? this.blockIcon : (meta == 3 && side == 5 ? this.blockIcon : (meta == 0 && side == 3 ? this.blockIcon : (meta == 1 && side == 4 ? this.blockIcon : tbIcon)))));
		return ret;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {
		this.blockIcon = register.registerIcon(Reference.MOD_ID + ":" + name);
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		
		if (world.getBlock(x, y - 1, z) == ModBlocks.empowered_Tenebrae_Core && world.getBlock(x, y - 2, z) == ModBlocks.infused_Tenebrae) {
			boolean flag = world.getBlock(x - 1, y - 1, z) == ModBlocks.infused_Tenebrae && world.getBlock(x + 1, y - 1, z) == ModBlocks.infused_Tenebrae;
			boolean flag1 = world.getBlock(x, y - 1, z - 1) == ModBlocks.infused_Tenebrae && world.getBlock(x, y - 1, z + 1) == ModBlocks.infused_Tenebrae;
			
			if (flag || flag1) {
				world.setBlock(x, y, z, getBlockById(0), 0, 2);
				world.setBlock(x, y - 1, z, getBlockById(0), 0, 2);
				world.setBlock(x, y - 2, z, getBlockById(0), 0, 2);
				
				if (flag) {
					world.setBlock(x - 1, y - 1, z, getBlockById(0), 0, 2);
					world.setBlock(x + 1, y - 1, z, getBlockById(0), 0, 2);
				} else {
					world.setBlock(x, y - 1, z - 1, getBlockById(0), 0, 2);
					world.setBlock(x, y - 1, z + 1, getBlockById(0), 0, 2);
				}
				
				EntityEmpoweredTenebraeGolem golem = new EntityEmpoweredTenebraeGolem(world);
				golem.setPlayerCreated(true);
				golem.setLocationAndAngles((double) x + 0.5D, (double) y - 1.95D, (double) z + 0.5D, 0.0F, 0.0F);
				world.spawnEntityInWorld(golem);
				
				for (int i1 = 0; i1 < 120; ++ i1) {
					world.spawnParticle("snowballpoof", (double) x + world.rand.nextDouble(), (double) (y - 2) + world.rand.nextDouble() * 3.9D, (double) z + world.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
				}
			}
		}
		
		else if (world.getBlock(x, y - 1, z) == ModBlocks.tenebrae_Core && world.getBlock(x, y - 2, z) == ModBlocks.tenebrae_Block) {
			boolean flag = world.getBlock(x - 1, y - 1, z) == ModBlocks.tenebrae_Block && world.getBlock(x + 1, y - 1, z) == ModBlocks.tenebrae_Block;
			boolean flag1 = world.getBlock(x, y - 1, z - 1) == ModBlocks.tenebrae_Block && world.getBlock(x, y - 1, z + 1) == ModBlocks.tenebrae_Block;
			
			if (flag || flag1) {
				world.setBlock(x, y, z, getBlockById(0), 0, 2);
				world.setBlock(x, y - 1, z, getBlockById(0), 0, 2);
				world.setBlock(x, y - 2, z, getBlockById(0), 0, 2);
				
				if (flag) {
					world.setBlock(x - 1, y - 1, z, getBlockById(0), 0, 2);
					world.setBlock(x + 1, y - 1, z, getBlockById(0), 0, 2);
				} else {
					world.setBlock(x, y - 1, z - 1, getBlockById(0), 0, 2);
					world.setBlock(x, y - 1, z + 1, getBlockById(0), 0, 2);
				}
				
				EntityTenebraeGolem golem = new EntityTenebraeGolem(world);
				golem.setPlayerCreated(true);
				golem.setLocationAndAngles((double) x + 0.5D, (double) y - 1.95D, (double) z + 0.5D, 0.0F, 0.0F);
				world.spawnEntityInWorld(golem);
				
				for (int i1 = 0; i1 < 120; ++ i1) {
					world.spawnParticle("snowballpoof", (double) x + world.rand.nextDouble(), (double) (y - 2) + world.rand.nextDouble() * 3.9D, (double) z + world.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
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
