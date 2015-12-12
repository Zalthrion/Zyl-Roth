package com.zalthrion.zylroth.entity.mount;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

import com.zalthrion.zylroth.lib.ModItems;
import com.zalthrion.zylroth.reference.Reference;

public class MountDeathcharger extends MountBaseHorse {
	
	public MountDeathcharger(World world) {
		super(world);
		this.isEntityUndead();
		this.isImmuneToFire = true;
		
		this.setCustomNameTag("Deathcharger");
	}
	
	@Override
	public boolean interact(EntityPlayer player) {
		
		NBTTagCompound persistentData = player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
		
		this.setOwnerId(player.getUniqueID().toString());
		
		ItemStack stack = player.inventory.getCurrentItem();
		
		if (stack != null && stack.getItem() == ModItems.SC_Deathcharger && player.isSneaking() && persistentData.hasKey("ownsMountDeathcharger")) {
			
			this.setDead();
			persistentData.removeTag("ownsMountDeathcharger");
		}
		
		if (!isOwner(player) && !worldObj.isRemote){ //Checks if the player is the Owner of the mount
            player.addChatMessage(new ChatComponentTranslation(Reference.MOD_ID + ":" + "mount.owned"));
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
	
}
