package com.zalthrion.zylroth.entity;

import com.zalthrion.zylroth.entity.ai.EntityCustomAIControlledByPlayer;

import net.minecraft.block.Block;
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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.AchievementList;
import net.minecraft.world.World;

public class EntityFancyBadger extends EntityAnimal {
	
	/** AI task for player control. */
	private final EntityCustomAIControlledByPlayer aiControlledByPlayer;
	
	public EntityFancyBadger(World world) {
		super(world);
		this.setSize(0.9F, 0.9F);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIPanic(this, 1.25D));
		this.tasks.addTask(2, this.aiControlledByPlayer = new EntityCustomAIControlledByPlayer(this, 0.3F));
		this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(4, new EntityAITempt(this, 1.2D, Items.carrot_on_a_stick, false));
		this.tasks.addTask(4, new EntityAITempt(this, 1.2D, Items.carrot, false));
		this.tasks.addTask(5, new EntityAIFollowParent(this, 1.1D));
		this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
		this.setCustomNameTag("FancyBadger");
	}
	
	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	public boolean isAIEnabled() {
		return true;
	}
	
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
	}
	
	protected void updateAITasks() {
		super.updateAITasks();
	}
	
	/**
	 * returns true if all the conditions for steering the entity are met. For pigs, this is true if it is being ridden
	 * by a player and the player is holding a carrot-on-a-stick
	 */
	public boolean canBeSteered() {
		EntityPlayer riding = ((EntityPlayer) this.riddenByEntity);
		return riding != null && !this.isChild();
	}
	
	protected void entityInit() {
		super.entityInit();
	}
	
	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound() {
		return "mob.pig.say";
	}
	
	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound() {
		return "mob.pig.say";
	}
	
	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound() {
		return "mob.pig.death";
	}
	
	protected void playStepSound(int x, int y, int z, Block blockIn) {
		this.playSound("mob.pig.step", 0.15F, 1.0F);
	}
	
	/**
	 * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
	 */
	public boolean interact(EntityPlayer player) {
		
		ItemStack stack = player.inventory.getCurrentItem();
		
		if (stack != null && stack.getItem() == Items.carrot && player.isSneaking()) {
			if (!this.worldObj.isRemote) {
				EntityBadger entitybadger = new EntityBadger(this.worldObj);
				entitybadger.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
				this.setDead();
				this.worldObj.spawnEntityInWorld(entitybadger);
			}
			
			for (int i = 0; i < 7; ++ i) {
				double d0 = this.rand.nextGaussian() * 0.02D;
				double d1 = this.rand.nextGaussian() * 0.02D;
				double d2 = this.rand.nextGaussian() * 0.02D;
				this.worldObj.spawnParticle("happyVillager", this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, this.posY + 0.5D + (double) (this.rand.nextFloat() * this.height), this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, d0, d1, d2);
			}
			
			stack.stackSize --;
		}
		
		if (super.interact(player)) {
			return true;
		}
		
		else if (!this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == player) && !this.isChild() && !player.isSneaking() && stack == null) {
			player.mountEntity(this);
			
			return true;
		}
		
		else {
			return false;
		}
	}
	
	protected Item getDropItem() {
		return this.isBurning() ? Items.cooked_porkchop : Items.porkchop;
	}
	
	/**
	 * Drop 0-2 items of this living's type
	 */
	protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
		int j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + p_70628_2_);
		
		for (int k = 0; k < j; ++ k) {
			if (this.isBurning()) {
				this.dropItem(Items.cooked_porkchop, 1);
			}
			else {
				this.dropItem(Items.porkchop, 1);
			}
		}
	}
	
	/**
	 * Called when the mob is falling. Calculates and applies fall damage.
	 */
	protected void fall(float distance) {
		super.fall(distance);
		
		if (distance > 5.0F && this.riddenByEntity instanceof EntityPlayer) {
			((EntityPlayer) this.riddenByEntity).triggerAchievement(AchievementList.flyPig);
		}
	}
	
	public EntityFancyBadger createChild(EntityAgeable ageable) {
		return new EntityFancyBadger(this.worldObj);
	}
	
	/**
	 * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
	 * the animal type)
	 */
	public boolean isBreedingItem(ItemStack stack) {
		return stack != null && stack.getItem() == Items.wheat;
	}
	
	/**
	 * Return the AI task for player control.
	 */
	public EntityCustomAIControlledByPlayer getAIControlledByPlayer() {
		return this.aiControlledByPlayer;
	}
}