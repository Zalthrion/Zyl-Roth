package com.zalthrion.zylroth.sound;

import com.zalthrion.zylroth.entity.projectile.RepulsorBolt;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.utility.LogHelper;

import net.minecraft.client.audio.MovingSound;
import net.minecraft.util.ResourceLocation;

public class CelestiumBoltSound extends MovingSound {
	private RepulsorBolt bolt;
	
	protected boolean repeat = true;
	protected int repeatDelay = 0;
	
	protected float pitch;
	
	public CelestiumBoltSound() {
		super(new ResourceLocation(Reference.MOD_ID.toLowerCase() + "sounds.weapon.repulsorCannon.mine"));
		this.repeat = true;
		this.volume = 0.8F;
		this.pitch = 1.0F;
	}
	
	public CelestiumBoltSound(RepulsorBolt boltEntity) {
		super(new ResourceLocation(Reference.MOD_ID.toLowerCase() + "sounds.weapon.repulsorCannon.mine"));
		volume = 0.8F;
		pitch = 1.0F;
		bolt = boltEntity;
		LogHelper.info("Sound Created");
	}
	
	public void setDonePlaying() {
		this.repeat = false;
		this.donePlaying = true;
		this.repeatDelay = 0;
	}
	
	@Override
	public boolean isDonePlaying() {
		return this.donePlaying;
	}
	
	@Override
	public boolean canRepeat() {
		return this.repeat;
	}
	
	@Override
	public float getVolume() {
		return this.volume;
	}
	
	@Override
	public float getPitch() {
		return this.pitch;
	}
	
	@Override
	public int getRepeatDelay() {
		return this.repeatDelay;
	}
	
	@Override
	public void update() {
		if (bolt == null || bolt.worldObj == null) {
			setDonePlaying();
		}
		
		if (bolt.isEntityAlive()) {
			this.repeat = true;
		}
	}
}
