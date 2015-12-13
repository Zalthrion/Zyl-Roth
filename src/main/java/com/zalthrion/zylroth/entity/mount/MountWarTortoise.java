package com.zalthrion.zylroth.entity.mount;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import com.zalthrion.zylroth.lib.ModItems;
import com.zalthrion.zylroth.reference.Reference;

public class MountWarTortoise extends MountBase {
	
	public MountWarTortoise(World world) {
		super(world);
		this.isImmuneToFire = true;
		
		this.setCustomNameTag("War Tortoise");
	}
	
	@Override
	public boolean interact(EntityPlayer player) {
		
		NBTTagCompound persistentData = player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
		
		ItemStack stack = player.inventory.getCurrentItem();
		
		if (stack != null && stack.getItem() == ModItems.SC_WarTortoise && player.isSneaking() && persistentData.hasKey("ownsMountWarTortoise") && this.riddenByEntity == null) {
			this.setDead();
			persistentData.removeTag("ownsMountWarTortoise");
		}
		
		if (!this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == player) && !this.isChild() && !player.isSneaking() && stack == null && this.func_152114_e(player)) {
			player.mountEntity(this);
		}
		
		if (!this.func_152114_e(player) && !this.worldObj.isRemote) {
			player.addChatMessage(new ChatComponentTranslation(StatCollector.translateToLocal("msg" + "." + Reference.MOD_ID + ":" + "mount.owned")));
		}
		
		return true;
	}
	
	/** Returns the sound this mob makes while it's alive. */
	@Override
	protected String getLivingSound() {
		return "mob.pig.say";
	}
	
	/** Returns the sound this mob makes when it is hurt. */
	@Override
	protected String getHurtSound() {
		return "mob.pig.say";
	}
	
	/** Returns the sound this mob makes on death. */
	@Override
	protected String getDeathSound() {
		return "mob.pig.death";
	}
	
	/** The sound this mob makes when it moves */
	@Override
	protected void playStepSound(int x, int y, int z, Block blockIn) {
		this.playSound("mob.pig.step", 0.15F, 1.0F);
	}
}
