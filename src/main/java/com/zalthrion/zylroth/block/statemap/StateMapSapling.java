package com.zalthrion.zylroth.block.statemap;

import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT) public class StateMapSapling extends StateMap.Builder {
	public StateMapSapling(IProperty<?> name, IProperty<?>... ignoreList) {
		super();
		this.withName(name);
		this.withSuffix("_sapling");
		this.ignore(ignoreList);
	}
}