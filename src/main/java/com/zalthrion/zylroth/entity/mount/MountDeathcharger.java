package com.zalthrion.zylroth.entity.mount;

import net.minecraft.entity.passive.HorseType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

import com.zalthrion.zylroth.lib.ModInit.ItemInit;
import com.zalthrion.zylroth.reference.Reference;

//TODO Check all mappings, Reorganize methods
public class MountDeathcharger extends MountBaseHorse {
	public MountDeathcharger(World world) {
		super(world);
		this.isEntityUndead();
		this.isImmuneToFire = true;
		this.setCustomNameTag("Deathcharger");
	}
	
	@Override public boolean processInteract(EntityPlayer player, EnumHand hand, ItemStack stack) {
		NBTTagCompound persistentData = player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
		
		if (stack != null && stack.getItem() == ItemInit.SC_DEATHCHARGER && player.isSneaking() && persistentData.hasKey("ownsMountDeathcharger") && this.getControllingPassenger() == null && this.isOwner(player)) {
			this.setDead();
			persistentData.removeTag("ownsMountDeathcharger");
		}
		if (!this.worldObj.isRemote && (this.getControllingPassenger() == null || this.getControllingPassenger() == player) && !this.isChild() && !player.isSneaking() && stack == null && this.isOwner(player)) {
			player.startRiding(this);
		}
		if (!this.isOwner(player) && !this.worldObj.isRemote) {
			player.addChatMessage(new TextComponentTranslation("msg." + Reference.MOD_ID + ":mount.owned"));
		}
		
		return true;
	}
	
	@Override public HorseType getType() {
		return HorseType.SKELETON;
	}
}