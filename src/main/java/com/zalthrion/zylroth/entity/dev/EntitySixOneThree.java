package com.zalthrion.zylroth.entity.dev;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.world.World;

public class EntitySixOneThree extends EntityDeveloper {
	public EntitySixOneThree(World world) {
		super(world);
		this.setSize(1F, 2F);
		((PathNavigateGround) this.getNavigator()).setCanSwim(false);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIWander(this, 1.0D));
		
		this.setCustomNameTag("Six-One-Three");
	}
	
	@Override protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
	}
}