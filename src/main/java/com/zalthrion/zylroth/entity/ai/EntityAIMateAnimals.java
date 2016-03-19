package com.zalthrion.zylroth.entity.ai;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class EntityAIMateAnimals extends EntityAIBase {
	private EntityAnimal theAnimal;
	World theWorld;
	private EntityAnimal targetMate;
	int spawnBabyDelay;
	double moveSpeed;
	
	public EntityAIMateAnimals(EntityAnimal p_i1619_1_, double p_i1619_2_) {
		this.theAnimal = p_i1619_1_;
		this.theWorld = p_i1619_1_.worldObj;
		this.moveSpeed = p_i1619_2_;
		this.setMutexBits(3);
	}
	
	@Override public boolean shouldExecute() {
		if (!this.theAnimal.isInLove()) {
			return false;
		} else {
			this.targetMate = this.getNearbyMate();
			return this.targetMate != null;
		}
	}
	
	@Override public boolean continueExecuting() {
		return this.targetMate.isEntityAlive() && this.targetMate.isInLove() && this.spawnBabyDelay < 60;
	}
	
	@Override public void resetTask() {
		this.targetMate = null;
		this.spawnBabyDelay = 0;
	}
	
	@Override public void updateTask() {
		this.theAnimal.getLookHelper().setLookPositionWithEntity(this.targetMate, 10.0F, (float) this.theAnimal.getVerticalFaceSpeed());
		this.theAnimal.getNavigator().tryMoveToEntityLiving(this.targetMate, this.moveSpeed);
		++ this.spawnBabyDelay;
		
		if (this.spawnBabyDelay >= 60 && this.theAnimal.getDistanceSqToEntity(this.targetMate) < 9.0D) {
			this.spawnBaby();
		}
	}
	
	@SuppressWarnings("rawtypes") private EntityAnimal getNearbyMate() {
		float f = 8.0F;
		List list = this.theWorld.getEntitiesWithinAABB(EntityAnimal.class, this.theAnimal.getEntityBoundingBox().expand((double) f, (double) f, (double) f));
		double d0 = Double.MAX_VALUE;
		EntityAnimal entityanimal = null;
		Iterator iterator = list.iterator();
		
		while (iterator.hasNext()) {
			EntityAnimal entityanimal1 = (EntityAnimal) iterator.next();
			
			if (this.theAnimal.canMateWith(entityanimal1) && this.theAnimal.getDistanceSqToEntity(entityanimal1) < d0) {
				entityanimal = entityanimal1;
				d0 = this.theAnimal.getDistanceSqToEntity(entityanimal1);
			}
		}
		
		return entityanimal;
	}
	
	private void spawnBaby() {
		EntityAgeable entityageable = this.theAnimal.createChild(this.targetMate);
		
		if (entityageable != null) {
			EntityPlayer entityplayer = this.theAnimal.getPlayerInLove();
			
			if (entityplayer == null && this.targetMate.getPlayerInLove() != null) {
				entityplayer = this.targetMate.getPlayerInLove();
			}
			
			if (entityplayer != null) {
				entityplayer.addStat(StatList.animalsBred);
				
				if (this.theAnimal instanceof EntityCow) {
					entityplayer.addStat(AchievementList.breedCow);
				}
			}
			
			this.theAnimal.setGrowingAge(6000);
			this.targetMate.setGrowingAge(6000);
			this.theAnimal.resetInLove();
			this.targetMate.resetInLove();
			entityageable.setGrowingAge(-24000);
			entityageable.setLocationAndAngles(this.theAnimal.posX, this.theAnimal.posY, this.theAnimal.posZ, 0.0F, 0.0F);
			this.theWorld.spawnEntityInWorld(entityageable);
			Random random = this.theAnimal.getRNG();
			
			for (int i = 0; i < 7; ++ i) {
				double d0 = random.nextGaussian() * 0.02D;
				double d1 = random.nextGaussian() * 0.02D;
				double d2 = random.nextGaussian() * 0.02D;
				this.theWorld.spawnParticle(EnumParticleTypes.HEART, this.theAnimal.posX + (double) (random.nextFloat() * this.theAnimal.width * 2.0F) - (double) this.theAnimal.width, this.theAnimal.posY + 0.5D + (double) (random.nextFloat() * this.theAnimal.height), this.theAnimal.posZ + (double) (random.nextFloat() * this.theAnimal.width * 2.0F) - (double) this.theAnimal.width, d0, d1, d2);
			}
			
			if (this.theWorld.getGameRules().getBoolean("doMobLoot")) {
				this.theWorld.spawnEntityInWorld(new EntityXPOrb(this.theWorld, this.theAnimal.posX, this.theAnimal.posY, this.theAnimal.posZ, random.nextInt(7) + 1));
			}
		}
	}
}