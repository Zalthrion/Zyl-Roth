package com.zalthrion.zylroth.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import com.zalthrion.zylroth.entity.boss.EntityVoidLordBoss;
import com.zalthrion.zylroth.handler.ConfigurationHandler;
import com.zalthrion.zylroth.lib.ModArmors;
import com.zalthrion.zylroth.lib.ModItems;
import com.zalthrion.zylroth.lib.ModTools;

public class EntityUndeadWarrior extends EntityMob {
	public EntityUndeadWarrior(World world) {
		super(world);
		this.setSize(0.5F, 2.1F);
		this.isImmuneToFire = true;
		((PathNavigateGround)this.getNavigator()).setBreakDoors(true);
		
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIBreakDoor(this));
		this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, false));
		// this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0D, true)); // TODO See if it continues to work for villagers
		this.tasks.addTask(7, new EntityAIWander(this, 0.9D));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, false, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<EntityVillager>(this, EntityVillager.class, true));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
	}
	
	@Override protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(ModArmors.tenebraeChestplate));
		this.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(ModArmors.tenebraeLeggings));
		this.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(ModArmors.tenebraeBoots));
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(ModTools.tenebraeSword));
	}
	
	@Override protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		boolean hardcore = ConfigurationHandler.getHardcoreModeEnabled();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(hardcore ? 45.0D : 25.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(hardcore ? 15.0D : 12.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(hardcore ? 7.5D : 3.0D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(hardcore ? 0.4D : 0.2D);
	}
	
	@Override public boolean attackEntityAsMob(Entity entity) {
		
		boolean KyrulMinions = ((entity instanceof EntityVoidLordBoss) || (entity instanceof EntityUndeadWarrior) || (entity instanceof EntityUndeadMinion) || (entity instanceof EntityVoidDragon));
		
		if (!KyrulMinions) {
			this.worldObj.setEntityState(this, (byte) 4);
			
			boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float) (7 + this.rand.nextInt(15)));
			
			if (flag) {
				entity.motionY += 0.1D;
			}
			
			if (entity instanceof EntityPlayer) {
				
				EntityPlayer player = (EntityPlayer) entity;
				
				boolean hasArmor = true;
				for (int i = 0; i < 4; i ++) {
					if (player.inventory.armorInventory[i] != null) hasArmor = false;
				}
				
				if (!player.worldObj.isRemote && !hasArmor) {
					this.playSound(SoundEvents.entity_blaze_hurt, 0.3F, 1.0F);
				}
			}
		}
		
		return KyrulMinions;
	}
	
	@Override protected SoundEvent getAmbientSound() {
		return SoundEvents.entity_skeleton_ambient;
	}
	
	@Override protected SoundEvent getHurtSound() {
		return SoundEvents.entity_skeleton_hurt;
	}
	
	@Override protected SoundEvent getDeathSound() {
		return SoundEvents.entity_skeleton_death;
	}
	
	@Override protected void collideWithEntity(Entity entity) {
		boolean KyrulMinions = ((entity instanceof EntityVoidLordBoss) || (entity instanceof EntityUndeadWarrior) || (entity instanceof EntityUndeadMinion) || (entity instanceof EntityVoidDragon));
		
		if (entity instanceof IMob && this.getRNG().nextInt(20) == 0 && !(KyrulMinions)) {
			this.setAttackTarget((EntityLivingBase) entity);
		}
		
		super.collideWithEntity(entity);
	}
	
	@Override public void onLivingUpdate() {
		super.onLivingUpdate();
	}
	
	@Override public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEAD;
	}
	
	@Override public void onKillEntity(EntityLivingBase entity) {
		super.onKillEntity(entity);
		
		if ((this.worldObj.getDifficulty() == EnumDifficulty.NORMAL || this.worldObj.getDifficulty() == EnumDifficulty.HARD) && entity instanceof EntityVillager) {
			if (this.worldObj.getDifficulty() != EnumDifficulty.HARD && this.rand.nextBoolean()) { return; }
			
			EntityUndeadMinion entityundeadminion = new EntityUndeadMinion(this.worldObj);
			entityundeadminion.copyLocationAndAnglesFrom(entity);
			this.worldObj.removeEntity(entity);
			entityundeadminion.onInitialSpawn(this.worldObj.getDifficultyForLocation(new BlockPos(this.posX, this.posY, this.posZ)), (IEntityLivingData) null);
			
			this.worldObj.spawnEntityInWorld(entityundeadminion);
			this.worldObj.playAuxSFXAtEntity((EntityPlayer) null, 1016, new BlockPos(this.posX, this.posY, this.posZ), 0);
		}
	}
	
	@Override protected void dropFewItems(boolean par1, int par2) {
		int amount = this.rand.nextInt(3) + 2 + this.rand.nextInt(1 + par2 * 2);
		
		for (int def = 0; def < amount; ++ def) {
			this.entityDropItem(new ItemStack(ModItems.darkShard, 1, 6), 0f);
		}
		
	}
	
	@Override public boolean canAttackClass(Class<? extends EntityLivingBase> par1Class) {
		return EntityVoidLordBoss.class != par1Class && EntityUndeadWarrior.class != par1Class && EntityUndeadMinion.class != par1Class && EntityVoidDragon.class != par1Class;
	}
}