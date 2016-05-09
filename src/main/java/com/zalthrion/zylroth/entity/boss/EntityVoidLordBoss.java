package com.zalthrion.zylroth.entity.boss;

import net.minecraft.block.material.Material;
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
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import com.zalthrion.zylroth.entity.EntitySkeletalHorse;
import com.zalthrion.zylroth.entity.EntityUndeadMinion;
import com.zalthrion.zylroth.entity.EntityUndeadWarrior;
import com.zalthrion.zylroth.entity.EntityVoidDragon;
import com.zalthrion.zylroth.lib.ModInit.ItemInit;

public class EntityVoidLordBoss extends EntityMob {
	
	/* Constructors */
	
	public EntityVoidLordBoss(World world) {
		super(world);
		this.setSize(0.5F, 2.1F);
		this.isImmuneToFire = true;
		((PathNavigateGround) this.getNavigator()).setBreakDoors(true);
		
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIBreakDoor(this));
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, false));
         // this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0D, true)); //TODO See if it continues to work for villagers
		this.tasks.addTask(7, new EntityAIWander(this, 0.9D));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, false, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<EntityVillager>(this, EntityVillager.class, true));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
	}
	
	/* Overridden */
	
	@Override protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(450.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(25.0D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(40.0D);
	}
	
	@Override public boolean attackEntityAsMob(Entity entityIn) {
		boolean kyrulMinions = ((entityIn instanceof EntityVoidLordBoss) || (entityIn instanceof EntityUndeadWarrior) || (entityIn instanceof EntityUndeadMinion) || (entityIn instanceof EntityVoidDragon) || (entityIn instanceof EntitySkeletalHorse));
		
		if (!kyrulMinions) {
			this.worldObj.setEntityState(this, (byte) 4);
			
			boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float) (7 + this.rand.nextInt(15)));
			
			if (flag) entityIn.motionY += 0.1D;
			
			if (entityIn instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) entityIn;
				
				boolean hasArmor = true;
				for (int i = 0; i < 4; i ++) {
					if (player.inventory.armorInventory[i] != null) hasArmor = false;
				}
				
				if (!player.worldObj.isRemote && !hasArmor) this.playSound(SoundEvents.entity_blaze_hurt, 0.5F, 1.0F);
			}
			
			int i = this.worldObj.getDifficulty().getDifficultyId();
			entityIn.setFire(10 * i);
		}
		
		return kyrulMinions;
	}
	
	@Override public boolean canAttackClass(Class<? extends EntityLivingBase> cls) {
		return EntityVoidLordBoss.class != cls && EntityUndeadWarrior.class != cls && EntityUndeadMinion.class != cls && EntityVoidDragon.class != cls && EntitySkeletalHorse.class != cls;
	}
	
	@Override protected boolean canDespawn() {
		return false;
	}
	
	@Override protected void collideWithEntity(Entity entityIn) {
		boolean kyrulMinions = ((entityIn instanceof EntityVoidLordBoss) || (entityIn instanceof EntityUndeadWarrior) || (entityIn instanceof EntityUndeadMinion) || (entityIn instanceof EntityVoidDragon) || (entityIn instanceof EntitySkeletalHorse));
		if (entityIn instanceof IMob && this.getRNG().nextInt(20) == 0 && !(kyrulMinions)) this.setAttackTarget((EntityLivingBase) entityIn);
		super.collideWithEntity(entityIn);
	}
	
	@Override protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		int amount = this.rand.nextInt(3) + 2 + this.rand.nextInt(1 + lootingModifier * 2);
		for (int def = 0; def < amount; ++ def) this.entityDropItem(new ItemStack(ItemInit.darkShard, 1, 6), 0F);
	}
	
	@Override protected SoundEvent getAmbientSound() {
		return SoundEvents.entity_blaze_ambient;
	}
	
	@Override public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEAD;
	}
	
	@Override protected SoundEvent getDeathSound() {
		return SoundEvents.entity_wither_death;
	}
	
	@Override protected SoundEvent getHurtSound() {
		return SoundEvents.entity_wither_hurt;
	}
	
	@Override public void onKillEntity(EntityLivingBase entityLivingIn) {
		super.onKillEntity(entityLivingIn);
		
		if ((this.worldObj.getDifficulty() == EnumDifficulty.NORMAL || this.worldObj.getDifficulty() == EnumDifficulty.HARD) && entityLivingIn instanceof EntityVillager) {
			if (this.worldObj.getDifficulty() != EnumDifficulty.HARD && this.rand.nextBoolean()) return; 
			
			EntityUndeadMinion entityundeadminion = new EntityUndeadMinion(this.worldObj);
			entityundeadminion.copyLocationAndAnglesFrom(entityLivingIn);
			this.worldObj.removeEntity(entityLivingIn);
			entityundeadminion.onInitialSpawn(this.worldObj.getDifficultyForLocation(new BlockPos(this.posX, this.posY, this.posZ)), (IEntityLivingData) null);
			
			this.worldObj.spawnEntityInWorld(entityundeadminion);
			this.worldObj.playAuxSFXAtEntity((EntityPlayer) null, 1016, new BlockPos(this.posX, this.posY, this.posZ), 0);
		}
	}
	
	@Override public void onLivingUpdate() {
		for (int i = 0; i < 2; ++ i) this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX + (this.rand.nextDouble() - 0.5D) * (double) this.width, this.posY + this.rand.nextDouble() * (double) this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width, 0.0D, 0.0D, 0.0D);
		for (int l = 0; l < 4; ++ l) {
			int x = MathHelper.floor_double(this.posX);
			int y = MathHelper.floor_double(this.posY);
			int z = MathHelper.floor_double(this.posZ);
			
			x = MathHelper.floor_double(this.posX + (double) ((float) (l % 2 * 2 - 1) * 0.25F));
			y = MathHelper.floor_double(this.posY);
			z = MathHelper.floor_double(this.posZ + (double) ((float) (l / 2 % 2 * 2 - 1) * 0.25F));
			BlockPos pos = new BlockPos(x, y, z);
			
			if (this.worldObj.getBlockState(pos).getMaterial() == Material.air && Blocks.fire.canPlaceBlockAt(this.worldObj, pos)) this.worldObj.setBlockState(pos, Blocks.fire.getDefaultState());
		}
		
		super.onLivingUpdate();
	}
	
	@Override protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(ItemInit.voidLordHelmet));
		this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(ItemInit.voidLordChestplate));
		this.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(ItemInit.voidLordLeggings));
		this.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(ItemInit.voidLordBoots));
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(ItemInit.tenebraeSword));
	}
}