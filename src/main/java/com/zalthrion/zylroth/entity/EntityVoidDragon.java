package com.zalthrion.zylroth.entity;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import com.zalthrion.zylroth.entity.boss.EntityVoidLordBoss;
import com.zalthrion.zylroth.handler.ConfigurationHandler;

//TODO Check all mappings, reorganize methods, etc. LIKELY NEEDS A COMPLETE REWRITE
public class EntityVoidDragon extends EntityMob implements IEntityMultiPart, IMob {
	private Entity entity;
	boolean KyrulMinions = ((entity instanceof EntityVoidLordBoss) || (entity instanceof EntityUndeadWarrior) || (entity instanceof EntityUndeadMinion) || (entity instanceof EntityVoidDragon));
	
	public static final float innerRotation = 0;
	public double targetX;
	public double targetY;
	public double targetZ;
	
	public double[][] ringBuffer = new double[64][3];
	public int ringBufferIndex = -1;
	
	public EntityDragonPart[] dragonPartArray;
	public EntityDragonPart dragonPartHead;
	public EntityDragonPart dragonPartBody;
	public EntityDragonPart dragonPartTail1;
	public EntityDragonPart dragonPartTail2;
	public EntityDragonPart dragonPartTail3;
	public EntityDragonPart dragonPartWing1;
	public EntityDragonPart dragonPartWing2;
	
	public float prevAnimTime;
	public float animTime;
	public boolean forceNewTarget;
	
	@SuppressWarnings("unused")
	private EntityPlayer player;
	
	private Entity target;
	public int deathTicks;
	
	public EntityVoidDragon(World world) {
		super(world);
		this.dragonPartArray = new EntityDragonPart[] {dragonPartHead = new EntityDragonPart(this, "head", 6.0F, 6.0F), dragonPartBody = new EntityDragonPart(this, "body", 8.0F, 8.0F), dragonPartTail1 = new EntityDragonPart(this, "tail", 4.0F, 4.0F), dragonPartTail2 = new EntityDragonPart(this, "tail", 4.0F, 4.0F), dragonPartTail3 = new EntityDragonPart(this, "tail", 4.0F, 4.0F), dragonPartWing1 = new EntityDragonPart(this, "wing", 4.0F, 4.0F), dragonPartWing2 = new EntityDragonPart(this, "wing", 4.0F, 4.0F)};
		this.setHealth(this.getMaxHealth());
		this.setSize(16.0F, 8.0F);
		this.isImmuneToFire = true;
		this.noClip = true;
		this.targetY = 100.0D;
		this.ignoreFrustumCheck = true;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		boolean hardcore = ConfigurationHandler.getHardcoreModeEnabled();
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(hardcore ? 200.0D : 50.0D);
	}
	
	public double[] getMovementOffsets(int par1, float par2) {
		if (getHealth() <= 0.0F) par2 = 0.0F;
		
		par2 = 1.0F - par2;
		int j = this.ringBufferIndex - par1 * 1 & 63;
		int k = this.ringBufferIndex - par1 * 1 - 1 & 63;
		double[] adouble = new double[3];
		double d0 = this.ringBuffer[j][0];
		double d1 = MathHelper.wrapDegrees(this.ringBuffer[k][0] - d0);
		adouble[0] = d0 + d1 * par2;
		d0 = this.ringBuffer[j][1];
		d1 = this.ringBuffer[k][1] - d0;
		adouble[1] = d0 + d1 * par2;
		adouble[2] = this.ringBuffer[j][2] + (this.ringBuffer[k][2] - this.ringBuffer[j][2]) * par2;
		return adouble;
	}
	
	@Override
	public void onLivingUpdate() {
		float f;
		float f1;
		
		if (this.worldObj.isRemote) {
			f = MathHelper.cos(this.animTime * (float) Math.PI * 2.0F);
			f1 = MathHelper.cos(this.prevAnimTime * (float) Math.PI * 2.0F);
			
			if (f1 <= -0.3F && f >= -0.3F) this.worldObj.playSound(this.posX, this.posY, this.posZ, SoundEvents.ENTITY_ENDERDRAGON_FLAP, this.getSoundCategory(), 5.0F, 0.8F + this.rand.nextFloat() * 0.3F, false);
		}
		
		this.prevAnimTime = this.animTime;
		float f2;
		
		if (getHealth() <= 0.0F) {
			f = (rand.nextFloat() - 0.5F) * 8.0F;
			f1 = (rand.nextFloat() - 0.5F) * 4.0F;
			f2 = (rand.nextFloat() - 0.5F) * 8.0F;
			worldObj.spawnParticle(EnumParticleTypes.SMOKE_LARGE, posX + f, posY + 2.0D + f1, posZ + f2, 0.0D, 0.0D, 0.0D);
		} else {
			f = 0.2F / (MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ) * 10.0F + 1.0F);
			f *= (float) Math.pow(2.0D, this.motionY);
			
			this.animTime += f;
			
			this.rotationYaw = MathHelper.wrapDegrees(this.rotationYaw);
			
			if (ringBufferIndex < 0) for (int i = 0; i < ringBuffer.length; ++ i) {
				this.ringBuffer[i][0] = this.rotationYaw;
				this.ringBuffer[i][1] = this.posY;
			}
			
			if (++ this.ringBufferIndex == this.ringBuffer.length) this.ringBufferIndex = 0;
			
			ringBuffer[ringBufferIndex][0] = rotationYaw;
			ringBuffer[ringBufferIndex][1] = posY;
			double d0;
			double d1;
			double d2;
			double d3;
			float f3;
			
			if (worldObj.isRemote) {
				if (newPosRotationIncrements > 0) {
					d3 = posX + (interpTargetX - posX) / newPosRotationIncrements;
					d0 = posY + (interpTargetY - posY) / newPosRotationIncrements;
					d1 = posZ + (interpTargetZ - posZ) / newPosRotationIncrements;
					d2 = MathHelper.wrapDegrees(interpTargetYaw - rotationYaw);
					rotationYaw = (float) (rotationYaw + d2 / newPosRotationIncrements);
					rotationPitch = (float)((double)this.rotationPitch + (this.interpTargetPitch - (double)this.rotationPitch) / (double)this.newPosRotationIncrements);
					-- newPosRotationIncrements;
					setPosition(d3, d0, d1);
					setRotation(rotationYaw, rotationPitch);
				}
			} else {
				d3 = targetX - posX;
				d0 = targetY - posY;
				d1 = targetZ - posZ;
				d2 = d3 * d3 + d0 * d0 + d1 * d1;
				
				if (target != null) {
					targetX = target.posX;
					targetZ = target.posZ;
					double d4 = targetX - posX;
					double d5 = targetZ - posZ;
					double d6 = Math.sqrt(d4 * d4 + d5 * d5);
					double d7 = 0.4000000059604645D + d6 / 80.0D - 1.0D;
					
					if (d7 > 10.0D) d7 = 10.0D;
					
					targetY = target.getEntityBoundingBox().minY + d7;
				} else {
					targetX += rand.nextGaussian() * 2.0D;
					targetZ += rand.nextGaussian() * 2.0D;
				}
				
				if (forceNewTarget || d2 < 100.0D || d2 > 22500.0D || isCollidedHorizontally || isCollidedVertically) setNewTarget();
				
				d0 /= MathHelper.sqrt_double(d3 * d3 + d1 * d1);
				f3 = 0.6F;
				
				if (d0 < -f3) d0 = -f3;
				
				if (d0 > f3) d0 = f3;
				
				motionY += d0 * 0.10000000149011612D;
				rotationYaw = MathHelper.wrapDegrees(rotationYaw);
				double d8 = 180.0D - Math.atan2(d3, d1) * 180.0D / Math.PI;
				double d9 = MathHelper.wrapDegrees(d8 - rotationYaw);
				
				if (d9 > 50.0D) d9 = 50.0D;
				
				if (d9 < -50.0D) d9 = -50.0D;
				
				Vec3d vec3 = new Vec3d(targetX - posX, targetY - posY, targetZ - posZ).normalize();
				Vec3d vec31 = new Vec3d(MathHelper.sin(rotationYaw * (float) Math.PI / 180.0F), motionY, -MathHelper.cos(rotationYaw * (float) Math.PI / 180.0F)).normalize();
				float f4 = (float) (vec31.dotProduct(vec3) + 0.5D) / 1.5F;
				
				if (f4 < 0.0F) f4 = 0.0F;
				
				randomYawVelocity *= 0.8F;
				float f5 = MathHelper.sqrt_double(motionX * motionX + motionZ * motionZ) * 1.0F + 1.0F;
				double d10 = Math.sqrt(motionX * motionX + motionZ * motionZ) * 1.0D + 1.0D;
				
				if (d10 > 40.0D) d10 = 40.0D;
				
				randomYawVelocity = (float) (randomYawVelocity + d9 * (0.699999988079071D / d10 / f5));
				rotationYaw += randomYawVelocity * 0.1F;
				float f6 = (float) (2.0D / (d10 + 1.0D));
				float f7 = 0.06F;
				// moveFlying(0.0F, -1.0F, f7 * (f4 * f6 + (1.0F - f6))); // TODO Find this
				
				moveEntity(motionX, motionY, motionZ);
				
				Vec3d vec32 = new Vec3d(motionX, motionY, motionZ).normalize();
				float f8 = (float) (vec32.dotProduct(vec31) + 1.0D) / 2.0F;
				f8 = 0.8F + 0.15F * f8;
				motionX *= f8;
				motionZ *= f8;
				motionY *= 0.9100000262260437D;
			}
			
			renderYawOffset = rotationYaw;
			dragonPartHead.width = dragonPartHead.height = 3.0F;
			dragonPartTail1.width = dragonPartTail1.height = 2.0F;
			dragonPartTail2.width = dragonPartTail2.height = 2.0F;
			dragonPartTail3.width = dragonPartTail3.height = 2.0F;
			dragonPartBody.height = 3.0F;
			dragonPartBody.width = 5.0F;
			dragonPartWing1.height = 2.0F;
			dragonPartWing1.width = 4.0F;
			dragonPartWing2.height = 3.0F;
			dragonPartWing2.width = 4.0F;
			f1 = (float) (getMovementOffsets(5, 1.0F)[1] - getMovementOffsets(10, 1.0F)[1]) * 10.0F / 180.0F * (float) Math.PI;
			f2 = MathHelper.cos(f1);
			float f9 = -MathHelper.sin(f1);
			float f10 = rotationYaw * (float) Math.PI / 180.0F;
			float f11 = MathHelper.sin(f10);
			float f12 = MathHelper.cos(f10);
			dragonPartBody.onUpdate();
			dragonPartBody.setLocationAndAngles(posX + f11 * 0.5F, posY, posZ - f12 * 0.5F, 0.0F, 0.0F);
			dragonPartWing1.onUpdate();
			dragonPartWing1.setLocationAndAngles(posX + f12 * 4.5F, posY + 2.0D, posZ + f11 * 4.5F, 0.0F, 0.0F);
			dragonPartWing2.onUpdate();
			dragonPartWing2.setLocationAndAngles(posX - f12 * 4.5F, posY + 2.0D, posZ - f11 * 4.5F, 0.0F, 0.0F);
			
			if (!worldObj.isRemote && hurtTime == 0) {
				attackEntitiesInList(worldObj.getEntitiesWithinAABBExcludingEntity(this, dragonPartWing1.getEntityBoundingBox().expand(4.0D, 2.0D, 4.0D).offset(0.0D, -2.0D, 0.0D)));
				attackEntitiesInList(worldObj.getEntitiesWithinAABBExcludingEntity(this, dragonPartWing2.getEntityBoundingBox().expand(4.0D, 2.0D, 4.0D).offset(0.0D, -2.0D, 0.0D)));
				attackEntitiesInList(worldObj.getEntitiesWithinAABBExcludingEntity(this, dragonPartHead.getEntityBoundingBox().expand(1.0D, 1.0D, 1.0D)));
			}
			
			double[] adouble = getMovementOffsets(5, 1.0F);
			double[] adouble1 = getMovementOffsets(0, 1.0F);
			f3 = MathHelper.sin(rotationYaw * (float) Math.PI / 180.0F - randomYawVelocity * 0.01F);
			float f13 = MathHelper.cos(rotationYaw * (float) Math.PI / 180.0F - randomYawVelocity * 0.01F);
			dragonPartHead.onUpdate();
			dragonPartHead.setLocationAndAngles(posX + f3 * 5.5F * f2, posY + (adouble1[1] - adouble[1]) * 1.0D + f9 * 5.5F, posZ - f13 * 5.5F * f2, 0.0F, 0.0F);
			
			for (int j = 0; j < 3; ++ j) {
				EntityDragonPart entitydragonpart = null;
				
				if (j == 0) entitydragonpart = dragonPartTail1;
				
				if (j == 1) entitydragonpart = dragonPartTail2;
				
				if (j == 2) entitydragonpart = dragonPartTail3;
				
				double[] adouble2 = getMovementOffsets(12 + j * 2, 1.0F);
				float f14 = rotationYaw * (float) Math.PI / 180.0F + simplifyAngle(adouble2[0] - adouble[0]) * (float) Math.PI / 180.0F * 1.0F;
				float f15 = MathHelper.sin(f14);
				float f16 = MathHelper.cos(f14);
				float f17 = 1.5F;
				float f18 = (j + 1) * 2.0F;
				entitydragonpart.onUpdate();
				entitydragonpart.setLocationAndAngles(posX - (f11 * f17 + f15 * f18) * f2, posY + (adouble2[1] - adouble[1]) * 1.0D - (f18 + f17) * f9 + 1.5D, posZ + (f12 * f17 + f16 * f18) * f2, 0.0F, 0.0F);
			}
		}
	}
	
	private void attackEntitiesInList(List<?> par1List) {
		for (int i = 0; i < par1List.size(); ++ i) {
			Entity entity = (Entity) par1List.get(i);
			
			if (entity instanceof EntityLivingBase && !(!KyrulMinions)) entity.attackEntityFrom(DamageSource.causeMobDamage(this), 8.0F);
		}
	}
	
	private void setNewTarget() {
		forceNewTarget = false;
		
		if (rand.nextInt(2) == 0 && !worldObj.playerEntities.isEmpty())
			target = (Entity) worldObj.playerEntities.get(rand.nextInt(worldObj.playerEntities.size()));
		
		else {
			boolean flag = false;
			
			do {
				targetX = 0.0D;
				targetY = 70.0F + rand.nextFloat() * 50.0F;
				targetZ = 0.0D;
				targetX += rand.nextFloat() * 120.0F - 60.0F;
				targetZ += rand.nextFloat() * 120.0F - 60.0F;
				double d0 = posX - targetX;
				double d1 = posY - targetY;
				double d2 = posZ - targetZ;
				flag = d0 * d0 + d1 * d1 + d2 * d2 > 100.0D;
			} while (!flag);
			
			target = null;
		}
	}
	
	private float simplifyAngle(double par1) {
		return (float) MathHelper.wrapDegrees(par1);
	}
	
	@Override
	public boolean attackEntityFromPart(EntityDragonPart par1EntityDragonPart, DamageSource par2DamageSource, float par3) {
		if (par1EntityDragonPart != dragonPartHead) par3 = par3 / 4.0F + 1.0F;
		
		float f1 = rotationYaw * (float) Math.PI / 180.0F;
		float f2 = MathHelper.sin(f1);
		float f3 = MathHelper.cos(f1);
		targetX = posX + f2 * 5.0F + (rand.nextFloat() - 0.5F) * 2.0F;
		targetY = posY + rand.nextFloat() * 3.0F + 1.0D;
		targetZ = posZ - f3 * 5.0F + (rand.nextFloat() - 0.5F) * 2.0F;
		target = null;
		
		if (par2DamageSource.getEntity() instanceof EntityPlayer || par2DamageSource.isExplosion()) func_82195_e(par2DamageSource, par3);
		
		return true;
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
		return false;
	}
	
	protected boolean func_82195_e(DamageSource par1DamageSource, float par2) {
		return super.attackEntityFrom(par1DamageSource, par2);
	}
	
	@Override
	public Entity[] getParts() {
		return dragonPartArray;
	}
	
	@Override
	public boolean canBeCollidedWith() {
		return true;
	}
	
	@Override
	public World getWorld() {
		return worldObj;
	}
	
	@Override protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_ENDERDRAGON_GROWL;
	}
	
	@Override protected SoundEvent getHurtSound() {
		return SoundEvents.ENTITY_ENDERDRAGON_HURT;
	}
	
	@Override protected float getSoundVolume() {
		return 5.0F;
	}
	
	@Override
	protected boolean canDespawn() {
		return true;
	}
}