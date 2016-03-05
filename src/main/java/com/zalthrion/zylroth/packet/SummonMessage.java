package com.zalthrion.zylroth.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;

import com.zalthrion.zylroth.entity.mount.MountDeathcharger;
import com.zalthrion.zylroth.entity.mount.MountPlaguedHorse;
import com.zalthrion.zylroth.entity.mount.MountSavageBadger;
import com.zalthrion.zylroth.entity.mount.MountSwiftUnicorn;
import com.zalthrion.zylroth.entity.mount.MountWarTortoise;
import com.zalthrion.zylroth.handler.MountData;
import com.zalthrion.zylroth.reference.MountIDs;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class SummonMessage implements IMessage {
	private int summon;
	
	public SummonMessage() {}
	
	public SummonMessage(int summon) {
		this.summon = summon;
	}
	
	@Override
	public void fromBytes(ByteBuf buffer) {
		this.summon = buffer.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buffer) {
		buffer.writeInt(this.summon);
	}
	
	public static class Handler implements IMessageHandler<SummonMessage, IMessage> {
		@Override
		public IMessage onMessage(SummonMessage message, MessageContext context) {
			EntityPlayer player = context.getServerHandler().playerEntity;
			if (player != null) {
				MountData data = MountData.get(player);
				if (message.summon == MountIDs.deathcharger) {
					MountDeathcharger deathcharger = new MountDeathcharger(player.worldObj);
					deathcharger.copyLocationAndAnglesFrom(player);
					deathcharger.onSpawnWithEgg((IEntityLivingData) null);
					if (!data.ownsMount()) {
						deathcharger.func_152115_b(player.getUniqueID().toString());
						deathcharger.isSummoned(true);
						deathcharger.setTamedBy(player);
						player.worldObj.spawnEntityInWorld(deathcharger);
						data.setOwnedMount(deathcharger.getUniqueID().toString(), 0);
						player.mountEntity(deathcharger);
					}
				} else if (message.summon == MountIDs.plaguedHorse) {
					MountPlaguedHorse plaguedHorse = new MountPlaguedHorse(player.worldObj);
					plaguedHorse.copyLocationAndAnglesFrom(player);
					plaguedHorse.onSpawnWithEgg((IEntityLivingData) null);
					if (!data.ownsMount()) {
						plaguedHorse.func_152115_b(player.getUniqueID().toString());
						plaguedHorse.isSummoned(true);
						plaguedHorse.setTamedBy(player);
						player.worldObj.spawnEntityInWorld(plaguedHorse);
						data.setOwnedMount(plaguedHorse.getUniqueID().toString(), 1);
						player.mountEntity(plaguedHorse);
					}
				} else if (message.summon == MountIDs.savageBadger) {
					MountSavageBadger badger = new MountSavageBadger(player.worldObj);
					badger.copyLocationAndAnglesFrom(player);
					badger.onSpawnWithEgg((IEntityLivingData) null);
					if (!data.ownsMount()) {
						badger.func_152115_b(player.getUniqueID().toString());
						badger.isSummoned(true);
						badger.setTamedBy(player);
						player.worldObj.spawnEntityInWorld(badger);
						data.setOwnedMount(badger.getUniqueID().toString(), 2);
						player.mountEntity(badger);
					}
				} else if (message.summon == MountIDs.swiftUnicorn) {
					MountSwiftUnicorn swiftUnicorn = new MountSwiftUnicorn(player.worldObj);
					swiftUnicorn.copyLocationAndAnglesFrom(player);
					swiftUnicorn.onSpawnWithEgg((IEntityLivingData) null);
					if (!data.ownsMount()) {
						swiftUnicorn.func_152115_b(player.getUniqueID().toString());
						swiftUnicorn.isSummoned(true);
						swiftUnicorn.setTamedBy(player);
						player.worldObj.spawnEntityInWorld(swiftUnicorn);
						data.setOwnedMount(swiftUnicorn.getUniqueID().toString(), 3);
						player.mountEntity(swiftUnicorn);
					}
				} else if (message.summon == MountIDs.warTortoise) {
					MountWarTortoise warTortoise = new MountWarTortoise(player.worldObj);
					warTortoise.copyLocationAndAnglesFrom(player);
					warTortoise.onSpawnWithEgg((IEntityLivingData) null);
					if (!data.ownsMount()) {
						warTortoise.func_152115_b(player.getUniqueID().toString());
						warTortoise.isSummoned(true);
						warTortoise.setTamedBy(player);
						player.worldObj.spawnEntityInWorld(warTortoise);
						data.setOwnedMount(warTortoise.getUniqueID().toString(), 4);
						player.mountEntity(warTortoise);
					}
				}
			}
			return new SummonedMountMessage(message.summon);
		}
	}
}