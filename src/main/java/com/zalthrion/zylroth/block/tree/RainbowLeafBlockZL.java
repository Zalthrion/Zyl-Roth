package com.zalthrion.zylroth.block.tree;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockLeaves;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.lib.ModTabs;
import com.zalthrion.zylroth.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RainbowLeafBlockZL extends BlockLeaves {
	
	public static final String[][] leaf_names = new String[][] { {"rainbowBlueLeaves", "rainbowRedLeaves", "rainbowPurpleLeaves", "rainbowYellowLeaves"}, {"rainbowBlueLeaves_opaque", "rainbowRedLeaves_opaque", "rainbowPurpleLeaves_opaque", "rainbowYellowLeaves_opaque"}};
	public static final String[] leaf_types = new String[] {"rainbowBlue", "rainbowRed", "rainbowPurple", "rainbowYellow"};
	protected IIcon[][] icon = new IIcon[2][];
	
	public RainbowLeafBlockZL() {
		this.setTickRandomly(true);
		this.setCreativeTab(ModTabs.ZylRoth);
		this.setHardness(0.2F);
		this.setLightOpacity(1);
		this.setStepSound(soundTypeGrass);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		setGraphicsLevel(Minecraft.getMinecraft().gameSettings.fancyGraphics);
		return (meta & 3) == 1 ? this.icon[this.field_150127_b][1] : ((meta & 3) == 3 ? this.icon[this.field_150127_b][3] : ((meta & 3) == 2 ? this.icon[this.field_150127_b][2] : this.icon[this.field_150127_b][0]));
	}
	
	@Override
	protected ItemStack createStackedBlock(int par1) {
		return new ItemStack(this, 1, par1 & 3);
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	@Override
	public void getSubBlocks(Item item, CreativeTabs tabs, List list) {
		for (int i = 0; i < leaf_types.length; i ++) {
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister par1) {
		for (int i = 0; i < leaf_names.length; ++ i) {
			this.icon[i] = new IIcon[leaf_names[i].length];
			
			for (int j = 0; j < leaf_names[i].length; ++ j) {
				this.icon[i][j] = par1.registerIcon(Reference.MOD_ID + ":trees/" + leaf_names[i][j]);
			}
		}
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public String[] func_150125_e() {
		return leaf_types;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderColor(int color) {
		return 16777215;
	}
	
	@Override
	public Item getItemDropped(int meta, Random random, int fortune) {
		return Item.getItemFromBlock(ModBlocks.rainbowSaplingBlockZL);
	}
	
	@Override
	public int colorMultiplier(IBlockAccess worldIn, int x, int y, int z) {
		return 16777215;
	}
	
	// Apple drops
	@Override
	protected void func_150124_c(World world, int x, int y, int z, int p_150124_5_, int p_150124_6_) {
		if ((p_150124_5_ & 3) == 0 && world.rand.nextInt(p_150124_6_) == 0) {
			this.dropBlockAsItem(world, x, y, z, new ItemStack(Items.golden_apple, 1, 0));
		}
	}
}
