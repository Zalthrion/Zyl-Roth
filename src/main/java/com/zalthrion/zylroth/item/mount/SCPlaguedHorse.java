package com.zalthrion.zylroth.item.mount;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import com.zalthrion.zylroth.entity.mount.MountPlaguedHorse;

public class SCPlaguedHorse extends SummoningCrystalBase {
	private String itemName = "SC_PlaguedHorse";
	private String name = (baseName + "_" + itemName);
	
	public SCPlaguedHorse() {
		this.setUnlocalizedName(name);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (world.isRemote) return stack;
		NBTTagCompound persistentData = player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
		MountPlaguedHorse mount = new MountPlaguedHorse(player.worldObj);
		
		if (player instanceof EntityPlayer) {
			
			if (player.ridingEntity == null) {
				
				mount.copyLocationAndAnglesFrom(player);
				mount.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(player.serverPosX, player.serverPosY, player.serverPosZ)), (IEntityLivingData) null);
				
				if (!player.worldObj.isRemote && mount.isAdultHorse()) {
					
					if (!(persistentData.hasKey("ownsMountPlaguedHorse"))) {
						
						mount.setOwnerId(player.getUniqueID().toString());
						
						mount.isSummoned = true;
						
						if (mount.isSummoned == true) {
							
							mount.isSummoned(true);
							
							player.worldObj.spawnEntityInWorld(mount);
							
							player.getEntityData().setTag(EntityPlayer.PERSISTED_NBT_TAG, persistentData);
							persistentData.setString("ownsMountPlaguedHorse", mount.getUniqueID().toString());
							mount.setTamedBy(player);
						}
						
					}
				}
			}
		}
		return super.onItemRightClick(stack, world, player);
	}
}