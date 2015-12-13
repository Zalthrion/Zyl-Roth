package com.zalthrion.zylroth.entity.mount;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.StatCollector;
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
		
		ItemStack stack = player.inventory.getCurrentItem();
		
		if (stack != null && stack.getItem() == ModItems.SC_Deathcharger && player.isSneaking() && persistentData.hasKey("ownsMountDeathcharger") && this.riddenByEntity == null && this.func_152114_e(player)) {
			this.setDead();
			persistentData.removeTag("ownsMountDeathcharger");
		}
		
		if (!this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == player) && !this.isChild() && !player.isSneaking() && stack == null && this.func_152114_e(player)) {
			player.mountEntity(this);
		}
		
		if (!this.func_152114_e(player) && !this.worldObj.isRemote) {
			player.addChatMessage(new ChatComponentTranslation(StatCollector.translateToLocal("msg" + "." + Reference.MOD_ID + ":" + "mount.owned")));
		}
		
		return true;
	}
	
	/** Returns the horse type. 0 = Normal, 1 = Donkey, 2 = Mule, 3 = Undead
	 * Horse, 4 = Skeleton Horse */
	@Override
	public int getHorseType() {
		return 4;
	}
}
