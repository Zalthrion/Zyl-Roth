package com.zalthrion.zylroth.entity.mount;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

import com.zalthrion.zylroth.lib.ModInit.ItemInit;
import com.zalthrion.zylroth.reference.Reference;

//TODO Check all mappings, Reorganize methods
public class MountWarTortoise extends MountBase {
	public MountWarTortoise(World world) {
		super(world);
		this.isImmuneToFire = true;
		this.setCustomNameTag("War Tortoise");
	}
	
	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand, ItemStack stack) {
		NBTTagCompound persistentData = player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
		
		if (stack != null && stack.getItem() == ItemInit.SC_WarTortoise && player.isSneaking() && persistentData.hasKey("ownsMountWarTortoise") && this.getControllingPassenger() == null) {
			this.setDead();
			persistentData.removeTag("ownsMountWarTortoise");
		}
		if (!this.worldObj.isRemote && (this.getControllingPassenger() == null || this.getControllingPassenger() == player) && !this.isChild() && !player.isSneaking() && stack == null && this.isOwner(player)) {
			player.startRiding(this);
		}
		if (!this.isOwner(player) && !this.worldObj.isRemote) {
			player.addChatMessage(new TextComponentTranslation("msg." + Reference.MOD_ID + ":mount.owned"));
		}
		
		return true;
	}
	
	@Override protected SoundEvent getAmbientSound() {
		return SoundEvents.entity_pig_ambient;
	}
	
	@Override protected SoundEvent getHurtSound() {
		return SoundEvents.entity_pig_hurt;
	}
	
	@Override protected SoundEvent getDeathSound() {
		return SoundEvents.entity_pig_death;
	}
	
	@Override protected void playStepSound(BlockPos pos, Block blockIn) {
		this.playSound(SoundEvents.entity_pig_step, 0.15F, 1.0F);
	}
}