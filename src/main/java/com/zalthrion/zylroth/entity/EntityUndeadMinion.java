package com.zalthrion.zylroth.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import com.zalthrion.zylroth.handler.ConfigurationHandler;
import com.zalthrion.zylroth.lib.ModItems;

public class EntityUndeadMinion extends EntityMob {
	
	public EntityUndeadMinion(World world) {
		super(world);
		this.setSize(0.5F, 2.1F);
		this.isImmuneToFire = true;
		this.getNavigator().setBreakDoors(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIBreakDoor(this));;
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(2, new EntityAIMoveTowardsTarget(this, 0.9D, 32.0F));
		this.tasks.addTask(6, new EntityAIWander(this, 0.6D));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityMob.class, 0, true));
	}
	
	@Override
	public boolean isAIEnabled() {
		return true;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		
		if(ConfigurationHandler.getHardcoreModeEnabled() == true){

		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(45.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(15.0D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.3D);
		}
		
		else {
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(12.0D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.2D);
		}
		
		this.getCustomNameTag();
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entity) {
		
		boolean KyrulMinions = ((entity instanceof EntityPyroKnight) || (entity instanceof EntityUndeadWarrior) || (entity instanceof EntityUndeadMinion) || (entity instanceof EntityVoidDragon));
		
		if (!KyrulMinions) {
			this.worldObj.setEntityState(this, (byte) 4);
			
			 boolean flag = entity.attackEntityFrom(
			 DamageSource.causeMobDamage(this), (float) (7 +
			 this.rand.nextInt(15))); if (flag) { entity.motionY += 0.1D; }
			
			if (entity instanceof EntityPlayer) {
				
				EntityPlayer player = (EntityPlayer) entity;

				boolean hasArmor = true;
				for (int i = 0; i < 4; i ++) {
					if (player.inventory.armorInventory[i] != null) hasArmor = false;
				}
				
				if (!player.worldObj.isRemote && !hasArmor) {
					this.playSound("mob.blaze.hit", 0.3F, 1.0F);
				}
			}
		}
		
		return KyrulMinions;
	}
	
	/** Returns the sound this mob makes while it's alive. */
	@Override
	protected String getLivingSound() {
		return "mob.skeleton.say";
	}
	
	/** Returns the sound this mob makes when it is hurt. */
	@Override
	protected String getHurtSound() {
		return "mob.skeleton.hurt";
	}
	
	/** Returns the sound this mob makes on death. */
	@Override
	protected String getDeathSound() {
		return "mob.skeleton.death";
	}
	
	@Override
	protected void collideWithEntity(Entity entity) {
		boolean KyrulMinions = ((entity instanceof EntityPyroKnight) || (entity instanceof EntityUndeadWarrior) || (entity instanceof EntityUndeadMinion) || (entity instanceof EntityVoidDragon));
		
		if (entity instanceof IMob && this.getRNG().nextInt(20) == 0 && !(KyrulMinions)) {
			this.setAttackTarget((EntityLivingBase) entity);
		}
		
		super.collideWithEntity(entity);
	}
	
	@Override
	public void onLivingUpdate() {
		
		super.onLivingUpdate();
	}
	
	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEAD;
	}
	
	@Override
	public void onKillEntity(EntityLivingBase entity) {
		super.onKillEntity(entity);
		
		if ((this.worldObj.difficultySetting == EnumDifficulty.NORMAL || this.worldObj.difficultySetting == EnumDifficulty.HARD) && entity instanceof EntityVillager) {
			if (this.worldObj.difficultySetting != EnumDifficulty.HARD && this.rand.nextBoolean()) { return; }
			
			EntityUndeadMinion entityundeadminion = new EntityUndeadMinion(this.worldObj);
			entityundeadminion.copyLocationAndAnglesFrom(entity);
			this.worldObj.removeEntity(entity);
			entityundeadminion.onSpawnWithEgg((IEntityLivingData) null);
			
			this.worldObj.spawnEntityInWorld(entityundeadminion);
			this.worldObj.playAuxSFXAtEntity((EntityPlayer) null, 1016, (int) this.posX, (int) this.posY, (int) this.posZ, 0);
		}
	}
	
	@Override
	protected void dropFewItems(boolean par1, int par2) {
		int amount = this.rand.nextInt(3) + 2 + this.rand.nextInt(1 + par2 * 2);
		
		for (int def = 0; def < amount; ++ def) {
			this.entityDropItem(new ItemStack(ModItems.dark_Shard, 1, 6), 0f);
		}
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public boolean canAttackClass(Class par1Class) {
		return EntityPyroKnight.class != par1Class && EntityUndeadWarrior.class != par1Class && EntityUndeadMinion.class != par1Class && EntityVoidDragon.class != par1Class;
	}
	
}
