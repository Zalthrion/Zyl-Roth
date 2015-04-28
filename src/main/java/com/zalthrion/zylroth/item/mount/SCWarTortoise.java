package com.zalthrion.zylroth.item.mount;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.zalthrion.zylroth.entity.mount.MountWarTortoise;

public class SCWarTortoise extends SummoningCrystalBase {
	
	private String itemName = "SC_WarTortoise";
	
	private String name = (baseName + "_" + itemName);
	
	public SCWarTortoise() {
		this.setNames(name);
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		
		NBTTagCompound persistentData = player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);

		MountWarTortoise mount = new MountWarTortoise(player.worldObj);
		
		if (player instanceof EntityPlayer) {
			
			if (player.ridingEntity == null) {
				
				mount.copyLocationAndAnglesFrom(player);
				mount.onSpawnWithEgg((IEntityLivingData) null);
				
				if (!player.worldObj.isRemote && mount.isAdultHorse()) {
					
					if (!(persistentData.hasKey("ownsMountWarTortoise"))) {
						
						mount.isSummoned = true;
						
						if(mount.isSummoned == true) {
							
							mount.isSummoned(true);
							
							player.worldObj.spawnEntityInWorld(mount);
							
							player.getEntityData().setTag(EntityPlayer.PERSISTED_NBT_TAG, persistentData);
							persistentData.setString("ownsMountWarTortoise", mount.getUniqueID().toString());
							
						}			
					} 
				}
			}
		}
		
		return super.onItemRightClick(stack, world, player);
	}
	
}
