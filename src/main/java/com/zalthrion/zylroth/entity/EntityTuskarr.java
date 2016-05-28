package com.zalthrion.zylroth.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityTuskarr extends EntityAgeable {
	public EntityTuskarr(World world) {
		super(world);
		this.setSize(0.9F, 0.9F);
		((PathNavigateGround) this.getNavigator()).setCanSwim(false);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIWander(this, 1.0D));
	}
	
	@Override protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(25.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
	}
	
	@Override protected void updateAITasks() {
		super.updateAITasks();
	}
	
	@Override protected void entityInit() {
		super.entityInit();
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
	
	@Override protected void playStepSound(BlockPos pos, Block blockIn) {
		this.playSound(SoundEvents.ENTITY_PIG_STEP, 0.15F, 1.0F);
	}
	
	@Override protected Item getDropItem() {
		return this.isBurning() ? Items.COOKED_PORKCHOP : Items.PORKCHOP;
	}
	
	@Override protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
		int j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + p_70628_2_);
		
		for (int k = 0; k < j; ++ k) {
			if (this.isBurning()) {
				this.dropItem(Items.COOKED_PORKCHOP, 1);
			} else {
				this.dropItem(Items.PORKCHOP, 1);
			}
		}
	}
	
	@Override public EntityTuskarr createChild(EntityAgeable ageable) {
		return new EntityTuskarr(this.worldObj);
	}
}