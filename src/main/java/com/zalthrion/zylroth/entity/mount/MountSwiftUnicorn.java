package com.zalthrion.zylroth.entity.mount;

import net.minecraft.entity.passive.HorseArmorType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

import com.zalthrion.zylroth.lib.ModItems;
import com.zalthrion.zylroth.reference.Reference;

public class MountSwiftUnicorn extends MountBaseHorse {
	
	public MountSwiftUnicorn(World world) {
		super(world);
		this.isEntityUndead();
		this.isImmuneToFire = true;
		
		this.setCustomNameTag("Swift Unicorn");
	}
	
	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand, ItemStack stack) {
		NBTTagCompound persistentData = player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
		
		if (stack != null && stack.getItem() == ModItems.SC_SwiftUnicorn && player.isSneaking() && persistentData.hasKey("ownsMountSwiftUnicorn") && this.getControllingPassenger() == null) {
			this.setDead();
			persistentData.removeTag("ownsMountSwiftUnicorn");
		}
		
		if (!this.worldObj.isRemote && (this.getControllingPassenger() == null || this.getControllingPassenger() == player) && !this.isChild() && !player.isSneaking() && stack == null && this.isOwner(player)) {
			player.startRiding(this);
		}
		
		if (!this.isOwner(player) && !this.worldObj.isRemote) {
			player.addChatMessage(new TextComponentTranslation("msg." + Reference.MOD_ID + ":mount.owned"));
		}
		
		return true;
	}
	
	@Override public HorseArmorType getType() {
		return HorseArmorType.HORSE; // TODO Change to UNICORN if possible
	}
}