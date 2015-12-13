package com.zalthrion.zylroth.entity.mount;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import com.zalthrion.zylroth.lib.ModItems;
import com.zalthrion.zylroth.reference.Reference;

public class MountSavageBadger extends MountBase {
	public MountSavageBadger(World world) {
		super(world);
		this.setSize(0.9F, 0.9F);
		this.setCustomNameTag("Savage Badger");
	}
	
	@Override public boolean interact(EntityPlayer player) {
		NBTTagCompound persistentData = player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
		ItemStack stack = player.inventory.getCurrentItem();
		
		if (stack != null && stack.getItem() == ModItems.SC_SavageBadger && player.isSneaking() && persistentData.hasKey("ownsMountSavageBadger") && this.riddenByEntity == null && this.isOwner(player)) {
			this.setDead();
			persistentData.removeTag("ownsMountSavageBadger");
		}
		
		if (!this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == player) && !this.isChild() && !player.isSneaking() && stack == null && this.isOwner(player)) {
			player.mountEntity(this);
		}
		
		if (!this.isOwner(player) && !this.worldObj.isRemote) {
			player.addChatMessage(new ChatComponentTranslation(StatCollector.translateToLocal("msg." + Reference.MOD_ID + ":mount.owned")));
		}
		
		return true;
	}
}