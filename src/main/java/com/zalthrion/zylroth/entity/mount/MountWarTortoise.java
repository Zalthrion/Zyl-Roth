package com.zalthrion.zylroth.entity.mount;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.zalthrion.zylroth.lib.ModItems;

public class MountWarTortoise extends MountBase {
	
	public MountWarTortoise(World world) {
		super(world);
		this.isEntityUndead();
		this.isImmuneToFire = true;
		
		this.setCustomNameTag("War Tortoise");
	}
	
	@Override
	public boolean interact(EntityPlayer player) {
		
		NBTTagCompound persistentData = player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
		
		ItemStack stack = player.inventory.getCurrentItem();
		
		if (stack != null && stack.getItem() == ModItems.SC_WarTortoise && player.isSneaking() && persistentData.hasKey("ownsMountWarTortoise")) {
			
			this.setDead();
			persistentData.removeTag("ownsMountWarTortoise");
		}
		
		return super.interact(player);
	}
	
	/** Returns the horse type. 0 = Normal, 1 = Donkey, 2 = Mule, 3 = Undead
	 * Horse, 4 = Skeleton Horse */
	@Override
	public int getHorseType() {
		return 4;
	}
	
	/** Returns true if the horse is an Undead horse */
	@Override
	public boolean isUndead() {
		return false;
	}
	
	/** Returns true if the rider of the entity should be dismounted on water */
	@Override
	public boolean shouldDismountInWater(Entity rider) {
		return true;
	}
	
	/** Returns true if the entity can breath underwater */
	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}
	
	/** Returns the sound this mob makes while it's alive. */
	protected String getLivingSound() {
		return "mob.pig.say";
	}
	
	/** Returns the sound this mob makes when it is hurt. */
	protected String getHurtSound() {
		return "mob.pig.say";
	}
	
	/** Returns the sound this mob makes on death. */
	protected String getDeathSound() {
		return "mob.pig.death";
	}
	
	protected void playStepSound(int x, int y, int z, Block blockIn) {
		this.playSound("mob.pig.step", 0.15F, 1.0F);
	}
	
}
