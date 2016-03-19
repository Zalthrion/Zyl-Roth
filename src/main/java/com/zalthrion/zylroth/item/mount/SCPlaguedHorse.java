package com.zalthrion.zylroth.item.mount;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.zalthrion.zylroth.entity.mount.MountPlaguedHorse;

public class SCPlaguedHorse extends SummoningCrystalBase {
	private String itemName = "SC_PlaguedHorse";
	private String name = (baseName + "_" + itemName);
	
	public SCPlaguedHorse() {
		this.setUnlocalizedName(name);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		if (worldIn.isRemote) return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemStackIn);
		NBTTagCompound persistentData = playerIn.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
		MountPlaguedHorse mount = new MountPlaguedHorse(playerIn.worldObj);
		
		if (playerIn instanceof EntityPlayer) {
			
			if (playerIn.getRidingEntity() == null) {
				
				mount.copyLocationAndAnglesFrom(playerIn);
				mount.onInitialSpawn(worldIn.getDifficultyForLocation(new BlockPos(playerIn.serverPosX, playerIn.serverPosY, playerIn.serverPosZ)), (IEntityLivingData) null);
				
				if (!playerIn.worldObj.isRemote && mount.isAdultHorse()) {
					
					if (!(persistentData.hasKey("ownsMountPlaguedHorse"))) {
						
						mount.setOwnerUniqueId(playerIn.getUniqueID());
						
						mount.isSummoned = true;
						
						if (mount.isSummoned == true) {
							
							mount.isSummoned(true);
							
							playerIn.worldObj.spawnEntityInWorld(mount);
							
							playerIn.getEntityData().setTag(EntityPlayer.PERSISTED_NBT_TAG, persistentData);
							persistentData.setString("ownsMountPlaguedHorse", mount.getUniqueID().toString());
							mount.setTamedBy(playerIn);
						}
						
					}
				}
			}
		}
		return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
	}
}