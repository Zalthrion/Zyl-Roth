package com.zalthrion.zylroth.entity.mount;

import java.util.UUID;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityOwnable;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.scoreboard.Team;
import net.minecraft.server.management.PreYggdrasilConverter;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class EntityTameableHorse extends EntityHorse implements IEntityOwnable {
	public EntityTameableHorse(World p_i1604_1_) {
		super(p_i1604_1_);
	}
	
	@Override protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(26, Byte.valueOf((byte) 0));
		this.dataWatcher.addObject(27, "");
	}
	
	/** (abstract) Protected helper method to write subclass entity data to NBT. */
	@Override public void writeEntityToNBT(NBTTagCompound tagCompound) {
		super.writeEntityToNBT(tagCompound);
		
		if (this.func_152113_b() == null) {
			tagCompound.setString("OwnerUUID", "");
		} else {
			tagCompound.setString("OwnerUUID", this.func_152113_b());
		}
	}
	
	/** (abstract) Protected helper method to read subclass entity data from NBT. */
	@Override public void readEntityFromNBT(NBTTagCompound tagCompund) {
		super.readEntityFromNBT(tagCompund);
		String s = "";
		
		if (tagCompund.hasKey("OwnerUUID", 8)) {
			s = tagCompund.getString("OwnerUUID");
		} else {
			String s1 = tagCompund.getString("Owner");
			s = PreYggdrasilConverter.getStringUUIDFromName(s1);
		}
		
		if (s.length() > 0) {
			this.func_152115_b(s);
			this.setHorseTamed(true);
		}
	}
	
	/** Play the taming effect, will either be hearts or smoke depending on
	 * status */
	@Override protected void spawnHorseParticles(boolean happy) {
		for (int i = 0; i < 7; ++ i) {
			double d0 = this.rand.nextGaussian() * 0.02D;
			double d1 = this.rand.nextGaussian() * 0.02D;
			double d2 = this.rand.nextGaussian() * 0.02D;
			this.worldObj.spawnParticle(happy ? EnumParticleTypes.HEART : EnumParticleTypes.SMOKE_NORMAL, this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, this.posY + 0.5D + (double) (this.rand.nextFloat() * this.height), this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, d0, d1, d2);
		}
	}
	
	@Override @SideOnly(Side.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 7) {
			this.spawnHorseParticles(true);
		} else if (id == 6) {
			this.spawnHorseParticles(false);
		} else {
			super.handleStatusUpdate(id);
		}
	}
	
	@Override public boolean isTame() {
		return (this.dataWatcher.getWatchableObjectByte(26) & 4) != 0;
	}
	
	@Override public void setHorseTamed(boolean tamed) {
		byte b0 = this.dataWatcher.getWatchableObjectByte(26);
		
		if (tamed) {
			this.dataWatcher.updateObject(26, Byte.valueOf((byte) (b0 | 4)));
		} else {
			this.dataWatcher.updateObject(26, Byte.valueOf((byte) (b0 & -5)));
		}
	}
	
	public String func_152113_b() {
		return this.dataWatcher.getWatchableObjectString(27);
	}
	
	public void func_152115_b(String p_152115_1_) {
		this.dataWatcher.updateObject(27, p_152115_1_);
	}
	
	@Override public EntityLivingBase getOwner() {
		try {
			UUID uuid = UUID.fromString(this.func_152113_b());
			return uuid == null ? null : this.worldObj.getPlayerEntityByUUID(uuid);
		} catch (IllegalArgumentException illegalargumentexception) {
			return null;
		}
	}
	
	public boolean func_152114_e(EntityLivingBase p_152114_1_) {
		return p_152114_1_ == this.getOwner();
	}
	
	public boolean func_142018_a(EntityLivingBase p_142018_1_, EntityLivingBase p_142018_2_) {
		return true;
	}
	
	public Team getTeam() {
		if (this.isTame()) {
			EntityLivingBase entitylivingbase = this.getOwner();
			
			if (entitylivingbase != null) { return entitylivingbase.getTeam(); }
		}
		
		return super.getTeam();
	}
	
	public boolean isOnSameTeam(EntityLivingBase p_142014_1_) {
		if (this.isTame()) {
			EntityLivingBase entitylivingbase1 = this.getOwner();
			
			if (p_142014_1_ == entitylivingbase1) { return true; }
			
			if (entitylivingbase1 != null) { return entitylivingbase1.isOnSameTeam(p_142014_1_); }
		}
		
		return super.isOnSameTeam(p_142014_1_);
	}
}