package com.zalthrion.zylroth.block.statemap;

import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT) public class StateMapLeaves extends StateMap.Builder {
	public StateMapLeaves(IProperty<?> name, IProperty<?>... ignoreList) {
		super();
		this.withName(name);
		this.withSuffix("_leaves");
		this.ignore(ignoreList);
	}
}