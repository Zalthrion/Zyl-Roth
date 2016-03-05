package com.zalthrion.zylroth.entity.dev;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityDeveloper extends EntityAnimal {
	
	public EntityDeveloper(World p_i1738_1_) {
		super(p_i1738_1_);
		this.experienceValue = 5;
	}
	
	/**
	 * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
	 * use this to react to sunlight and start to burn.
	 */
	public void onLivingUpdate() {
		this.updateArmSwingProgress();
		float f = this.getBrightness(1.0F);
		
		if (f > 0.5F) {
			this.entityAge += 2;
		}
		
		super.onLivingUpdate();
	}
	
	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate() {
		super.onUpdate();
		
		if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
			this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.0D);
		}
	}
	
	protected String getSwimSound() {
		return "game.hostile.swim";
	}
	
	protected String getSplashSound() {
		return "game.hostile.swim.splash";
	}
	
	/**
	 * Finds the closest player within 16 blocks to attack, or null if this Entity isn't interested in attacking
	 * (Animals, Spiders at day, peaceful PigZombies).
	 */
	protected Entity findPlayerToAttack() {
		EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
		return entityplayer != null && this.canEntityBeSeen(entityplayer) ? entityplayer : null;
	}
	
	/**
	 * Called when the entity is attacked.
	 */
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (this.isEntityInvulnerable()) {
			return false;
		} else if (super.attackEntityFrom(source, amount)) {
			Entity entity = source.getEntity();
			
			if (this.riddenByEntity != entity && this.ridingEntity != entity) {
				if (entity != this) {
					this.entityToAttack = entity;
				}
				
				return true;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound() {
		return "game.hostile.hurt";
	}
	
	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound() {
		return "game.hostile.die";
	}
	
	protected String func_146067_o(int p_146067_1_) {
		return p_146067_1_ > 4 ? "game.hostile.hurt.fall.big" : "game.hostile.hurt.fall.small";
	}
	
	public boolean attackEntityAsMob(Entity p_70652_1_) {
		float f = (float) this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
		int i = 0;
		
		if (p_70652_1_ instanceof EntityLivingBase) {
			f += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLivingBase) p_70652_1_);
			i += EnchantmentHelper.getKnockbackModifier(this, (EntityLivingBase) p_70652_1_);
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
				EnchantmentHelper.func_151384_a((EntityLivingBase) p_70652_1_, this);
			}
			
			EnchantmentHelper.func_151385_b(this, p_70652_1_);
		}
		
		return flag;
	}
	
	/**
	 * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
	 */
	protected void attackEntity(Entity p_70785_1_, float p_70785_2_) {
		if (this.attackTime <= 0 && p_70785_2_ < 2.0F && p_70785_1_.boundingBox.maxY > this.boundingBox.minY && p_70785_1_.boundingBox.minY < this.boundingBox.maxY) {
			this.attackTime = 20;
			this.attackEntityAsMob(p_70785_1_);
		}
	}
	
	/**
	 * Takes a coordinate in and returns a weight to determine how likely this creature will try to path to the block.
	 * Args: x, y, z
	 */
	public float getBlockPathWeight(int p_70783_1_, int p_70783_2_, int p_70783_3_) {
		return 0.5F - this.worldObj.getLightBrightness(p_70783_1_, p_70783_2_, p_70783_3_);
	}
	
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
	}
	
	protected boolean func_146066_aG() {
		return true;
	}
	
	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_) {
		return null;
	}
}
