package com.zalthrion.zylroth.item.mount;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import com.zalthrion.zylroth.entity.mount.MountSavageBadger;

public class SCSavageBadger extends SummoningCrystalBase {
	private String itemName = "SC_SavageBadger";
	private String name = (baseName + "_" + itemName);
	
	public SCSavageBadger() {
		super();
		this.setUnlocalizedName(name);
	}
	
	@Override public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (world.isRemote) return stack;
		NBTTagCompound persistentData = player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
		MountSavageBadger mount = new MountSavageBadger(player.worldObj);
		if (player instanceof EntityPlayer) {
			if (player.ridingEntity == null) {
				mount.copyLocationAndAnglesFrom(player);
				mount.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(player.serverPosX, player.serverPosY, player.serverPosZ)), (IEntityLivingData) null);
				if (!player.worldObj.isRemote && !mount.isChild()) {
					if (!(persistentData.hasKey("ownsMountSavageBadger"))) {
						mount.setOwnerId(player.getUniqueID().toString());
						mount.isSummoned = true;
						if (mount.isSummoned == true) {
							mount.isSummoned(true);
							player.worldObj.spawnEntityInWorld(mount);
							player.getEntityData().setTag(EntityPlayer.PERSISTED_NBT_TAG, persistentData);
							persistentData.setString("ownsMountSavageBadger", mount.getUniqueID().toString());
							mount.setTamedBy(player);
						}
					}
				}
			}
		}
		
		return super.onItemRightClick(stack, world, player);
	}
}