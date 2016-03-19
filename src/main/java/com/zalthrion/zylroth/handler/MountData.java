package com.zalthrion.zylroth.handler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

// TODO Look into capabilities because this seems to be dead
public class MountData implements IExtendedEntityProperties {
	public static final String EXT_PROP_NAME = "ZylrothMountData";
	private final EntityPlayer player;
	private String ownedMount;
	private int ownedMountID;
	
	public MountData(EntityPlayer player) {
		this.player = player;
	}
	
	public static final void register(EntityPlayer player) {
		// player.registerExtendedProperties(EXT_PROP_NAME, new MountData(player));
	}
	
	public static final MountData get(EntityPlayer player) {
		return new MountData(player);
		// return (MountData) player.getExtendedProperties(EXT_PROP_NAME);
	}
	
	@Override public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();
		properties.setString("ownedMount", this.ownedMount);
		properties.setInteger("ownedMountID", this.ownedMountID);
		compound.setTag(EXT_PROP_NAME, properties);
	}

	@Override public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		this.ownedMount = properties.getString("ownedMount");
		this.ownedMountID = properties.getInteger("ownedMountID");
	}

	@Override public void init(Entity entity, World world) {
		this.ownedMount = "";
		this.ownedMountID = -1;
	}
	
	public boolean ownsMount() {
		return this.ownedMount.length() > 0;
	}
	
	public String ownedMount() {
		return this.ownedMount;
	}
	
	public int ownedMountID() {
		return this.ownedMountID;
	}

	public void disownMount() {
		this.ownedMount = "";
		this.ownedMountID = -1;
	}
	
	public void setOwnedMount(String ownedMount, int ownedMountID) {
		this.ownedMount = ownedMount;
		this.ownedMountID = ownedMountID;
	}
}