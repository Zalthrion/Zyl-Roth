package com.zalthrion.zylroth.item;

public class SoulEssence extends ItemBase {
	
	private String name = "soulEssence";
	
	public SoulEssence() {
		this.setNames(name);
	}

	//Dev Stuff
/*	@Override
	public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {

		PackedIcePillar nest = new PackedIcePillar();
		
		Random rand = new Random();
		nest.generate(world, rand, x, y, z);
		
		return super.onItemUse(p_77648_1_, player, world, x, y, z, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_);
	}*/
}