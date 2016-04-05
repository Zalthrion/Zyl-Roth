package com.zalthrion.zylroth.event;

import net.minecraft.nbt.NBTBase.NBTPrimitive;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.zalthrion.zylroth.Zylroth;
import com.zalthrion.zylroth.handler.MountCapability.MountData;
import com.zalthrion.zylroth.reference.Reference;

public class PlayerEventListener {
	@SubscribeEvent public void onAttachCapabilities(AttachCapabilitiesEvent event) {
		event.addCapability(new ResourceLocation(Reference.MOD_ID.toLowerCase(), "MountData"), new ICapabilitySerializable<NBTPrimitive>() {
			MountData instance = Zylroth.MOUNT_CAP.getDefaultInstance();
			@Override public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
				return capability == Zylroth.MOUNT_CAP;
			}

			@Override public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
				return capability == Zylroth.MOUNT_CAP ? Zylroth.MOUNT_CAP.<T>cast(instance) : null;
			}

			@Override public NBTPrimitive serializeNBT() {
				return (NBTPrimitive) Zylroth.MOUNT_CAP.getStorage().writeNBT(Zylroth.MOUNT_CAP, instance, null);
			}

			@Override public void deserializeNBT(NBTPrimitive nbt) {
				Zylroth.MOUNT_CAP.getStorage().readNBT(Zylroth.MOUNT_CAP, instance, null, nbt);
			}
		});
	}
}