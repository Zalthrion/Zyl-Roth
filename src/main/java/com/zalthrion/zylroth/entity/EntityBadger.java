package com.zalthrion.zylroth.entity;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityBadger extends EntityAnimal {
	public EntityBadger(World world) {
		super(world);
		this.setSize(0.9F, 0.9F);
		((PathNavigateGround) this.getNavigator()).setCanSwim(false);
	}
	
	@Override public void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIPanic(this, 1.25D));
		this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(4, new EntityAITempt(this, 1.2D, Items.carrot_on_a_stick, false));
		this.tasks.addTask(4, new EntityAITempt(this, 1.2D, Items.carrot, false));
		this.tasks.addTask(5, new EntityAIFollowParent(this, 1.1D));
		this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
	}
	
	@Override public Entity getControllingPassenger() {
		List<Entity> list = this.getPassengers();
		return list.isEmpty() ? null : (Entity) list.get(0);
	}
	
	@Override protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
	}
	
	@Override protected void updateAITasks() {
		super.updateAITasks();
	}
	
	@Override public boolean canBeSteered() {
		EntityPlayer riding = ((EntityPlayer) this.getControllingPassenger());
		return riding != null && !this.isChild();
	}
	
	@Override protected void entityInit() {
		super.entityInit();
	}
	
	@Override protected SoundEvent getAmbientSound() {
		return SoundEvents.entity_pig_ambient;
	}
	
	@Override protected SoundEvent getHurtSound() {
		return SoundEvents.entity_pig_hurt;
	}
	
	@Override protected SoundEvent getDeathSound() {
		return SoundEvents.entity_pig_death;
	}
	
	@Override protected void playStepSound(BlockPos pos, Block blockIn) {
		this.playSound(SoundEvents.entity_pig_step, 0.15F, 1.0F);
	}
	
	@Override public boolean processInteract(EntityPlayer player, EnumHand hand, ItemStack stack) {
		if (stack != null && stack.getItem() == Items.golden_apple && player.isSneaking()) {
			if (!this.worldObj.isRemote) {
				EntityFancyBadger entityfancybadger = new EntityFancyBadger(this.worldObj);
				entityfancybadger.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
				this.setDead();
				this.worldObj.spawnEntityInWorld(entityfancybadger);
			}
			
			for (int i = 0; i < 7; ++ i) {
				double d0 = this.rand.nextGaussian() * 0.02D;
				double d1 = this.rand.nextGaussian() * 0.02D;
				double d2 = this.rand.nextGaussian() * 0.02D;
				this.worldObj.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, this.posY + 0.5D + (double) (this.rand.nextFloat() * this.height), this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, d0, d1, d2);
			}
			
			stack.stackSize --;
		}
		
		if (super.processInteract(player, hand, stack)) {
			return true;
		}
		
		else if (!this.worldObj.isRemote && (this.getPassengers().isEmpty() || this.getControllingPassenger() == player) && !this.isChild() && !player.isSneaking()) {
			player.startRiding(this);
			
			return true;
		}
		
		else {
			return false;
		}
	}
	
	@Override protected Item getDropItem() {
		return this.isBurning() ? Items.cooked_porkchop : Items.porkchop;
	}
	
	@Override protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
		int j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + p_70628_2_);
		
		for (int k = 0; k < j; ++ k) {
			if (this.isBurning()) {
				this.dropItem(Items.cooked_porkchop, 1);
			} else {
				this.dropItem(Items.porkchop, 1);
			}
		}
	}
	
	@Override public void fall(float distance, float damageMultiplier) {
		super.fall(distance, damageMultiplier);
		
		if (distance > 5.0F && this.getControllingPassenger() instanceof EntityPlayer) {
			((EntityPlayer) this.getControllingPassenger()).addStat(AchievementList.flyPig);
		}
	}
	
	@Override public EntityBadger createChild(EntityAgeable ageable) {
		return new EntityBadger(this.worldObj);
	}
	
	@Override public boolean isBreedingItem(ItemStack stack) {
		return stack != null && stack.getItem() == Items.wheat;
	}
}