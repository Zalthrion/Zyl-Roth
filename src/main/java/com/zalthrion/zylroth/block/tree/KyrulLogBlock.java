package com.zalthrion.zylroth.block.tree;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class KyrulLogBlock extends BlockLog {
	
	public static final String[] logs = new String[] {"voidWood"};	
	
	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
		list.add(new ItemStack(itemIn, 1, 0));
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg) {
		//Side Texture
		this.field_150167_a = new IIcon[logs.length];
		
		//Top Texture
		this.field_150166_b = new IIcon[logs.length];
		
		for (int i = 0; i < this.field_150167_a.length; ++ i) {
			this.field_150167_a[i] = reg.registerIcon(this.getTextureName() + "_" + logs[i]);
			this.field_150166_b[i] = reg.registerIcon(this.getTextureName() + "_" + logs[i] + "_top");
		}
	}
}
