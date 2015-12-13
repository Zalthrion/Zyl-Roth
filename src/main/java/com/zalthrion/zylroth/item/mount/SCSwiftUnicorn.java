package com.zalthrion.zylroth.item.mount;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.zalthrion.zylroth.entity.mount.MountSwiftUnicorn;

public class SCSwiftUnicorn extends SummoningCrystalBase {
	
	private String itemName = "SC_SwiftUnicorn";
	
	private String name = (baseName + "_" + itemName);
	
	public SCSwiftUnicorn() {
		this.setNames(name);
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		
		NBTTagCompound persistentData = player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
		
		MountSwiftUnicorn mount = new MountSwiftUnicorn(player.worldObj);
		
		if (player instanceof EntityPlayer) {
			
			if (player.ridingEntity == null) {
				
				mount.copyLocationAndAnglesFrom(player);
				mount.onSpawnWithEgg((IEntityLivingData) null);
				
				if (!player.worldObj.isRemote && mount.isAdultHorse()) {
					
					if (!(persistentData.hasKey("ownsMountUnicorn"))) {
						
						mount.func_152115_b(player.getUniqueID().toString());
						
						mount.isSummoned = true;
						
						if (mount.isSummoned == true) {
							
							mount.isSummoned(true);
							
							player.worldObj.spawnEntityInWorld(mount);
							
							player.getEntityData().setTag(EntityPlayer.PERSISTED_NBT_TAG, persistentData);
							persistentData.setString("ownsMountUnicorn", mount.getUniqueID().toString());
							
							mount.setTamedBy(player);
						}
						
					}
				}
			}
		}
		
		return super.onItemRightClick(stack, world, player);
	}
	
}
