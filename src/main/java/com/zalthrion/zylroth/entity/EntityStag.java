package com.zalthrion.zylroth.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.world.World;

import com.zalthrion.zylroth.entity.ai.EntityAIMateAnimals;

public class EntityStag extends EntityTameable {
	public EntityStag(World world) {
		super(world);
		this.setSize(1.0F, 1.1F);
		((PathNavigateGround) this.getNavigator()).setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIPanic(this, 1.75D));
		this.tasks.addTask(3, new EntityAIMateAnimals(this, 1.0D));
		this.tasks.addTask(4, new EntityAITempt(this, 0.6D, Items.carrot, true));
		this.tasks.addTask(5, new EntityAIFollowParent(this, 1.1D));
		this.tasks.addTask(6, new EntityAIAvoidEntity<EntityPlayer>(this, EntityPlayer.class, 16.0F, 0.8D, 1.45D));
		this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
	}
	
	@Override protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
	}
	
	@Override protected void updateAITasks() {
		super.updateAITasks();
	}
	
	@Override public boolean canBeSteered() {
		EntityPlayer riding = ((EntityPlayer) this.riddenByEntity);
		return riding != null && !this.isChild();
	}
	
	@Override protected void entityInit() {
		super.entityInit();
	}
	
	@Override public boolean interact(EntityPlayer player) {
		ItemStack stack = player.inventory.getCurrentItem();
		
		if (super.interact(player)) {
			return true;
		} else if (!this.isChild() && stack != null && stack.getItem() == Items.carrot && player.getDistanceSqToEntity(this) < 9.0D && !this.isTamed() && player.isSneaking()) {
			if (!this.worldObj.isRemote) {
				if (!player.capabilities.isCreativeMode) {
					-- stack.stackSize;
				}
				
				if (stack.stackSize <= 0) {
					player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack) null);
				}
				
				this.setTamed(true);
				this.setOwnerId(player.getUniqueID().toString());
			}
			
			this.playTameEffect(true);
			return true;
		} else if (!this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == player) && !this.isChild() && this.isTamed() && !player.isSneaking()) {
			player.mountEntity(this);
			return true;
		} else {
			return false;
		}
	}
	
	@Override protected Item getDropItem() {
		return this.isBurning() ? Items.cooked_beef : Items.beef;
	}
	
	@Override protected void dropFewItems(boolean check, int p2) {
		int j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + p2);
		
		for (int k = 0; k < j; ++ k) {
			if (this.isBurning()) {
				this.dropItem(Items.cooked_beef, 1);
			} else {
				this.dropItem(Items.beef, 1);
			}
		}
	}
	
	@Override public boolean canMateWith(EntityAnimal entity) {
		if (!this.isInLove() || !entity.isInLove()) return false;
		
		if (entity == this)
			return false;
		else if (entity instanceof EntityDeer) return true;
		
		return false;
	}
	
	@Override public EntityAgeable createChild(EntityAgeable ageable) {
		int breed = rand.nextInt((1 - 0) + 1) + 0;
		
		if (breed == 1) {
			return new EntityStag(worldObj);
		} else return new EntityDeer(worldObj);
	}
	
	@Override public boolean isBreedingItem(ItemStack stack) {
		return stack != null && stack.getItem() == Items.wheat;
	}
	
	@Override public double getMountedYOffset() {
		return 1.5F;
	}
}