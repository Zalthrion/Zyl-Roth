package com.zalthrion.zylroth.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class RepulsorBolt extends EntityThrowable {
	public RepulsorBolt(World world) {
		super(world);
		setThrowableHeading(this.motionX, this.motionY, this.motionZ, 3.0F, 1.0F);
	}
	
	public RepulsorBolt(World world, EntityLivingBase entityLiving) {
		super(world, entityLiving);
	}
	
	public RepulsorBolt(World world, double par2, double par4, double par6) {
		super(world, par2, par4, par6);
	}
	
	@Override protected float getGravityVelocity() {
		return 0.001F;
	}
	
	@Override public void onUpdate() {
		if (this.ticksExisted == 120) {
			this.setDead();
		}
		
		super.onUpdate();
	}
	
	@Override protected void onImpact(RayTraceResult raytraceResultIn) {
		if (!this.worldObj.isRemote) {
			this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 0, false);
			this.setDead();
		}
	}
}