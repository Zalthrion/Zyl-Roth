package com.zalthrion.zylroth.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class RepulsorCannonBolt extends EntityArrow {
	private float explosionRadius = 1.0F;
	
	public RepulsorCannonBolt(World par1World) {
		super(par1World);
		setThrowableHeading(this.motionX, this.motionY, this.motionZ, 3.0F, 1.0F);
	}
	
	public RepulsorCannonBolt(World par1World, EntityLivingBase par2EntityLivingBase) {
		super(par1World, par2EntityLivingBase);
	}
	
	public RepulsorCannonBolt(World par1World, double par2, double par4, double par6) {
		super(par1World, par2, par4, par6);
	}
	
/*	@Override protected float getGravityVelocity() {
		return 0.02F;
	}*/
	
	@Override protected void onHit(RayTraceResult raytraceResultIn) {
		if (!this.worldObj.isRemote) {
			boolean flag = this.worldObj.getGameRules().getBoolean("mobGriefing");
			this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, this.explosionRadius, flag);
			
			this.setDead();
		}
	}
	
	@Override protected ItemStack getArrowStack() {
		return new ItemStack(Items.ARROW);
	}
}