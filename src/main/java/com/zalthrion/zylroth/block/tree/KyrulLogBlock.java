package com.zalthrion.zylroth.block.tree;

import net.minecraft.block.BlockLog;

import com.zalthrion.zylroth.lib.ModInit.ZylrothTab;
import com.zalthrion.zylroth.lib.ModRegistry;

public class KyrulLogBlock extends BlockLog {
	public KyrulLogBlock() {
		super();
		this.setCreativeTab(ZylrothTab.ZYLROTH);
		this.setRegistryName(ModRegistry.createRegistryNameFor("kyrulLogBlock"));
		this.setUnlocalizedName("kyrulLogBlock");
	}
}