package com.zalthrion.zylroth.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class EntityRainbowPig extends EntityPig {
	private EntityPlayer player;
	
	public EntityRainbowPig(World world) {
		super(world);
	}
	
	@Override public void onEntityUpdate() {
		double d0 = (double) ((float) this.posX + (-5.5F + worldObj.rand.nextFloat() + 5) / 16.0F);
		double d2 = (double) ((float) this.posZ + (-5.5F + worldObj.rand.nextFloat() + 5) / 16.0F);
		
		if (!(this.isChild()) && !(this.getControllingPassenger() == player)) {
			worldObj.spawnParticle(EnumParticleTypes.REDSTONE, d0, this.posY + 0.7F, d2, 2.39F, 2.55F, 0.0F);
			worldObj.spawnParticle(EnumParticleTypes.REDSTONE, d0, this.posY + 0.5F, d2, 0.176F, 1.11F, 1.246F);
			worldObj.spawnParticle(EnumParticleTypes.REDSTONE, d0, this.posY + 0.4F, d2, 2.46F, 0.83F, 0.10F);
		}
		
		super.onEntityUpdate();
	}
	
	@Override public EntityRainbowPig createChild(EntityAgeable entity) {
		return new EntityRainbowPig(this.worldObj);
	}
}
