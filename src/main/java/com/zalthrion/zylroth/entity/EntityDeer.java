package com.zalthrion.zylroth.entity;

import com.zalthrion.zylroth.entity.ai.EntityAIMateAnimals;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIControlledByPlayer;
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
import net.minecraft.world.World;

public class EntityDeer extends EntityTameable {
	
	/** AI task for player control. */
	private final EntityAIControlledByPlayer aiControlledByPlayer;
	
	public EntityDeer(World world) {
		super(world);
		this.setSize(1.0F, 1.1F);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIPanic(this, 1.75D));
		this.tasks.addTask(2, this.aiControlledByPlayer = new EntityAIControlledByPlayer(this, 0.3F));
		this.tasks.addTask(3, new EntityAIMateAnimals(this, 1.0D));
		this.tasks.addTask(4, new EntityAITempt(this, 0.6D, Items.carrot, true));
		this.tasks.addTask(5, new EntityAIFollowParent(this, 1.1D));
		this.tasks.addTask(6, new EntityAIAvoidEntity(this, EntityPlayer.class, 16.0F, 0.8D, 1.45D));
		this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
	}
	
	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	@Override
	public boolean isAIEnabled() {
		return true;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
	}
	
	@Override
	protected void updateAITasks() {
		super.updateAITasks();
	}
	
	/**
	 * returns true if all the conditions for steering the entity are met. For pigs, this is true if it is being ridden
	 * by a player and the player is holding a carrot-on-a-stick
	 */
	@Override
	public boolean canBeSteered() {
		EntityPlayer riding = ((EntityPlayer) this.riddenByEntity);
		return riding != null && !this.isChild();
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
	}
	
	/**
	 * main AI tick function, replaces updateEntityActionState
	 */
	@Override
	public void updateAITick() {
		if (this.getMoveHelper().isUpdating()) {
			double mv = this.getMoveHelper().getSpeed();
			
			if (mv == 0.6D) {
				this.setSneaking(true);
				this.setSprinting(false);
			} else if (mv == 1.45D) {
				this.setSneaking(false);
				this.setSprinting(true);
			} else {
				this.setSneaking(false);
				this.setSprinting(false);
			}
		} else {
			this.setSneaking(false);
			this.setSprinting(false);
		}
	}
	
	/**
	 * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
	 */
	@Override
	public boolean interact(EntityPlayer player) {
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
				this.func_152115_b(player.getUniqueID().toString());
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
	
	@Override
	protected Item getDropItem() {
		return this.isBurning() ? Items.cooked_beef : Items.beef;
	}
	
	/**
	 * Drop 0-2 items of this living's type
	 */
	@Override
	protected void dropFewItems(boolean check, int p2) {
		int j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + p2);
		
		for (int k = 0; k < j; ++ k) {
			if (this.isBurning()) {
				this.dropItem(Items.cooked_beef, 1);
			} else {
				this.dropItem(Items.beef, 1);
			}
		}
	}
	
	@Override
	public boolean canMateWith(EntityAnimal entity) {
		if (!this.isInLove() || !entity.isInLove()) return false;
		
		if (entity == this) return false;
		else if (entity instanceof EntityStag) return true;
		
		return false;
	}
	
	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		int breed = rand.nextInt((1 - 0) + 1) + 0;
		
		if (breed == 1) {
			return new EntityStag(worldObj);
		} else return new EntityDeer(worldObj);
	}
	
	/**
	 * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
	 * the animal type)
	 */
	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return stack != null && stack.getItem() == Items.wheat;
	}
	
	/**
	 * Return the AI task for player control.
	 */
	public EntityAIControlledByPlayer getAIControlledByPlayer() {
		return this.aiControlledByPlayer;
	}
	
	@Override
	public double getMountedYOffset() {
		return 1.2F;
	}
}