package com.zalthrion.zylroth.handler;

import java.util.concurrent.Callable;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class MountCapabilityHolder {
	public interface MountData {
		String getOwnedMount();
		int getOwnedMountId();
		void updateMountData(String ownedMount, int ownedMountId);
	}
	
	public static class MountCapabilityStorage implements Capability.IStorage<MountData> {
		@Override public void readNBT(Capability<MountData> capability, MountData instance, EnumFacing side, NBTBase nbt) {
			instance.updateMountData(((NBTTagCompound) nbt).getString("ownedMount"), ((NBTTagCompound) nbt).getInteger("ownedMountId"));
		}

		@Override public NBTBase writeNBT(Capability<MountData> capability, MountData instance, EnumFacing side) {
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("ownedMount", instance.getOwnedMount());
			compound.setInteger("ownedMountId", instance.getOwnedMountId());
			return compound;
		}
	}
	
	public static class MountCapabilityWrapper implements MountData {
		private String ownedMount;
		private int ownedMountId;
		
		@Override public String getOwnedMount() {
			return this.ownedMount;
		}
		
		@Override public int getOwnedMountId() {
			return this.ownedMountId;
		}
		
		@Override public void updateMountData(String ownedMount, int ownedMountId) {
			this.ownedMount = ownedMount;
			this.ownedMountId = ownedMountId;
		}
	}
	
	public static class Factory implements Callable<MountData> {
		@Override public MountData call() throws Exception {
			return new MountCapabilityWrapper();
		}
	}
}