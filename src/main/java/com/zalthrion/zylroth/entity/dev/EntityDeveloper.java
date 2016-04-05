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

// TODO Check all mappings
public class EntityDeveloper extends EntityAnimal {
	public EntityDeveloper(World worldIn) {
		super(worldIn);
		this.experienceValue = 5;
	}
	
	@Override protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
	}
	
	@Override public boolean attackEntityAsMob(Entity p_70652_1_) {
		float f = (float) this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();
		int i = 0;
		
		if (p_70652_1_ instanceof EntityLivingBase) {
			f += EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(), ((EntityLivingBase) p_70652_1_).getCreatureAttribute());
			i += EnchantmentHelper.getKnockbackModifier(this);
		}
		
		boolean flag = p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage(this), f);
		
		if (flag) {
			if (i > 0) {
				p_70652_1_.addVelocity((double) (-MathHelper.sin(this.rotationYaw * (float) Math.PI / 180.0F) * (float) i * 0.5F), 0.1D, (double) (MathHelper.cos(this.rotationYaw * (float) Math.PI / 180.0F) * (float) i * 0.5F));
				this.motionX *= 0.6D;
				this.motionZ *= 0.6D;
			}
			
			int j = EnchantmentHelper.getFireAspectModifier(this);
			
			if (j > 0) {
				p_70652_1_.setFire(j * 4);
			}
			
			if (p_70652_1_ instanceof EntityLivingBase) {
				EnchantmentHelper.applyThornEnchantments((EntityLivingBase) p_70652_1_, this);
			}
			
			EnchantmentHelper.applyArthropodEnchantments(this, p_70652_1_);
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
	
	@Override public EntityAgeable createChild(EntityAgeable p_90011_1_) {
		return null;
	}
	
	@Override public float getBlockPathWeight(BlockPos pos) {
		return 0.5F - this.worldObj.getLightBrightness(pos);
	}
	
	@Override protected SoundEvent getDeathSound() {
		return SoundEvents.entity_hostile_death;
	}
	
	@Override protected SoundEvent getFallSound(int heightIn) {
		return heightIn > 4 ? SoundEvents.entity_hostile_big_fall : SoundEvents.entity_hostile_small_fall;
	}
	
	@Override protected SoundEvent getHurtSound() {
		return SoundEvents.entity_hostile_hurt;
	}
	
	@Override protected SoundEvent getSplashSound() {
		return SoundEvents.entity_hostile_splash;
	}

	@Override protected SoundEvent getSwimSound() {
		return SoundEvents.entity_hostile_swim;
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