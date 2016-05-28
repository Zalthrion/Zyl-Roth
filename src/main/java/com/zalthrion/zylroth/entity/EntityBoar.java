package com.zalthrion.zylroth.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import com.google.common.base.Predicate;

//TODO Check all mappings, reorganize methods, etc.
public class EntityBoar extends EntityHostileAnimal {
	public EntityBoar(final World world) {
		super(world);
		this.setSize(1F, 1F);
	}
	
	@Override public void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.2D, false));
		this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(3, new EntityAITempt(this, 1.2D, Items.POTATO, false));
		this.tasks.addTask(3, new EntityAITempt(this, 1.2D, Items.BAKED_POTATO, false));
		this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1D));
		this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, 10, true, false, new Predicate<EntityPlayer>() {
			@Override public boolean apply(EntityPlayer p_apply_1) {
				return p_apply_1.worldObj.getDifficulty() != EnumDifficulty.PEACEFUL;
			}
		}));
	}
	
	@Override protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		if (!(this.worldObj.getDifficulty() == EnumDifficulty.PEACEFUL)) this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(15.0D);
	}
	
	@Override public EntityAgeable createChild(EntityAgeable ageable) {
		return new EntityBoar(this.worldObj);
	}
	
	@Override protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_PIG_AMBIENT;
	}
	
	@Override protected SoundEvent getHurtSound() {
		return SoundEvents.ENTITY_PIG_HURT;
	}
	
	@Override protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_PIG_DEATH;
	}
	
	protected void playStepSound(int x, int y, int z, Block blockIn) {
		this.playSound(SoundEvents.ENTITY_PIG_STEP, 0.15F, 1.0F);
	}
	
	@Override public boolean isBreedingItem(ItemStack p_70877_1_) {
		return p_70877_1_ != null && p_70877_1_.getItem() == Items.POTATO;
	}
}