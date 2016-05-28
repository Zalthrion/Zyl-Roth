package com.zalthrion.zylroth.entity.dev;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityDeveloper extends EntityAnimal {
	public EntityDeveloper(World worldIn) {
		super(worldIn);
		this.experienceValue = 5;
	}
	
	@Override protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
	}
	
	@Override public boolean attackEntityAsMob(Entity entityIn) {
		float f = (float) this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();
		int i = 0;
		
		if (entityIn instanceof EntityLivingBase) {
			f += EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(), ((EntityLivingBase) entityIn).getCreatureAttribute());
			i += EnchantmentHelper.getKnockbackModifier(this);
		}
		
		boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f);
		
		if (flag) {
			if (i > 0) {
				entityIn.addVelocity(-MathHelper.sin(this.rotationYaw * (float) Math.PI / 180.0F) * i * 0.5F, 0.1D, MathHelper.cos(this.rotationYaw * (float) Math.PI / 180.0F) * i * 0.5F);
				this.motionX *= 0.6D;
				this.motionZ *= 0.6D;
			}
			
			int j = EnchantmentHelper.getFireAspectModifier(this);
			
			if (j > 0) {
				entityIn.setFire(j * 4);
			}
			
			if (entityIn instanceof EntityLivingBase) {
				EnchantmentHelper.applyThornEnchantments((EntityLivingBase) entityIn, this);
			}
			
			EnchantmentHelper.applyArthropodEnchantments(this, entityIn);
		}
		
		return flag;
	}
	
	@Override public boolean attackEntityFrom(DamageSource source, float amount) {
		if (this.isEntityInvulnerable(source)) {
			return false;
		} else if (super.attackEntityFrom(source, amount)) {
			Entity entity = source.getEntity();
			
			if (this.getControllingPassenger() != entity && this.getRidingEntity() != entity) {
				if (entity != this) {
					this.setAttackTarget((EntityLiving) entity);
				}
				return true;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
	
	@Override protected boolean canDropLoot() {
		return true;
	}
	
	@Override public EntityAgeable createChild(EntityAgeable ageable) {
		return null;
	}
	
	@Override public float getBlockPathWeight(BlockPos pos) {
		return 0.5F - this.worldObj.getLightBrightness(pos);
	}
	
	@Override protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_HOSTILE_DEATH;
	}
	
	@Override protected SoundEvent getFallSound(int heightIn) {
		return heightIn > 4 ? SoundEvents.ENTITY_HOSTILE_BIG_FALL : SoundEvents.ENTITY_HOSTILE_BIG_FALL;
	}
	
	@Override protected SoundEvent getHurtSound() {
		return SoundEvents.ENTITY_HOSTILE_HURT;
	}
	
	@Override protected SoundEvent getSplashSound() {
		return SoundEvents.ENTITY_HOSTILE_SPLASH;
	}

	@Override protected SoundEvent getSwimSound() {
		return SoundEvents.ENTITY_HOSTILE_SWIM;
	}
	
	@Override public void onLivingUpdate() {
		this.updateArmSwingProgress();
		if (this.getBrightness(1.0F) > 0.5F) this.entityAge += 2;
		super.onLivingUpdate();
	}
	
	@Override public void onUpdate() {
		super.onUpdate();
		
		if (!this.worldObj.isRemote && this.worldObj.getDifficulty() == EnumDifficulty.PEACEFUL) {
			if (this.worldObj.getDifficulty() == EnumDifficulty.PEACEFUL) {
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.0D);
			} else {
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
			}
		}
	}
}