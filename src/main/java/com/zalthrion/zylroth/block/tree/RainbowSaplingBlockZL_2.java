package com.zalthrion.zylroth.block.tree;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.lib.ModTabs;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.world.gen.structures.TreeGenerator;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RainbowSaplingBlockZL_2 extends BlockBush implements IGrowable {
	
	public static final String[] sapling_names = new String[] {"rainbowBlueSapling", "rainbowPurpleSapling"};
	private static final IIcon[] icon = new IIcon[sapling_names.length];
	
	public RainbowSaplingBlockZL_2() {
		float f = 0.4F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
		this.setCreativeTab(ModTabs.ZylRoth);
		this.setStepSound(soundTypeGrass);
	}
	
	/**
	 * Ticks the block if it's been scheduled
	 */
	@Override
	public void updateTick(World worldIn, int x, int y, int z, Random random) {
		if (!worldIn.isRemote) {
			super.updateTick(worldIn, x, y, z, random);
			
			if (worldIn.getBlockLightValue(x, y + 1, z) >= 9 && random.nextInt(7) == 0) {
				this.markOrGrowMarked(worldIn, x, y, z, random);
			}
		}
	}
	
	/**
	 * Gets the block's texture. Args: side, meta
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		meta &= 7;
		return icon[MathHelper.clamp_int(meta, 0, 1)];
	}
	
	public void markOrGrowMarked(World p_149879_1_, int p_149879_2_, int p_149879_3_, int p_149879_4_, Random p_149879_5_) {
		int l = p_149879_1_.getBlockMetadata(p_149879_2_, p_149879_3_, p_149879_4_);
		
		if ((l & 8) == 0) {
			p_149879_1_.setBlockMetadataWithNotify(p_149879_2_, p_149879_3_, p_149879_4_, l | 8, 4);
		}
		else {
			this.growTree(p_149879_1_, p_149879_2_, p_149879_3_, p_149879_4_, p_149879_5_);
		}
	}
	
	public void growTree(World world, int x, int y, int z, Random rand) {
		if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(world, rand, x, y, z))
			return;
		int l = world.getBlockMetadata(x, y, z) & 7;
		Object object = rand.nextInt(10) == 0 ? new WorldGenBigTree(true) : new WorldGenTrees(true);
		int i1 = 0;
		int j1 = 0;
		boolean flag = false;
		
		switch (l) {
			case 0:
				object = new TreeGenerator(true, 4, Blocks.log, ModBlocks.rainbowLeafBlockZL_2, 0, 0, false);
				break;
			case 1:
				object = new TreeGenerator(true, 4, Blocks.log, ModBlocks.rainbowLeafBlockZL_2, 0, 1, false);
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			default:
				break;
		}
		
		Block block = Blocks.air;
		
		if (flag) {
			world.setBlock(x + i1, y, z + j1, block, 0, 4);
			world.setBlock(x + i1 + 1, y, z + j1, block, 0, 4);
			world.setBlock(x + i1, y, z + j1 + 1, block, 0, 4);
			world.setBlock(x + i1 + 1, y, z + j1 + 1, block, 0, 4);
		}
		else {
			world.setBlock(x, y, z, block, 0, 4);
		}
		
		if (!((WorldGenerator) object).generate(world, rand, x + i1, y, z + j1)) {
			if (flag) {
				world.setBlock(x + i1, y, z + j1, this, l, 4);
				world.setBlock(x + i1 + 1, y, z + j1, this, l, 4);
				world.setBlock(x + i1, y, z + j1 + 1, this, l, 4);
				world.setBlock(x + i1 + 1, y, z + j1 + 1, this, l, 4);
			}
			else {
				world.setBlock(x, y, z, this, l, 4);
			}
		}
	}
	
	public boolean func_149880_a(World p_149880_1_, int p_149880_2_, int p_149880_3_, int p_149880_4_, int p_149880_5_) {
		return p_149880_1_.getBlock(p_149880_2_, p_149880_3_, p_149880_4_) == this && (p_149880_1_.getBlockMetadata(p_149880_2_, p_149880_3_, p_149880_4_) & 7) == p_149880_5_;
	}
	
	/**
	 * Determines the damage on the item the block drops. Used in cloth and wood.
	 */
	@Override
	public int damageDropped(int meta) {
		return MathHelper.clamp_int(meta & 7, 0, 5);
	}
	
	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	 */
	@Override
	@SuppressWarnings({"unchecked", "rawtypes"})
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, 1));
	}
	
	@Override @SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg) {
		for (int i = 0; i < icon.length; ++ i) {
			icon[i] = reg.registerIcon(Reference.MOD_ID + ":trees/" + sapling_names[i]);
		}
	}
	
	@Override
	public boolean canFertilize(World worldIn, int x, int y, int z, boolean isClient) {
		return true;
	}
	
	@Override
	public boolean shouldFertilize(World worldIn, Random random, int x, int y, int z) {
		return (double) worldIn.rand.nextFloat() < 0.45D;
	}
	
	@Override
	public void fertilize(World worldIn, Random random, int x, int y, int z) {
		this.markOrGrowMarked(worldIn, x, y, z, random);
	}
}