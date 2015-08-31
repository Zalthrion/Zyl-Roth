package com.zalthrion.zylroth.entity;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import com.zalthrion.zylroth.lib.ModItems;
import com.zalthrion.zylroth.lib.ModTools;

public class EntityPyroKnight extends EntityMob implements IBossDisplayData {
	
	public EntityPyroKnight(World world) {
		super(world);
		this.setSize(0.5F, 2.1F);
		this.isImmuneToFire = true;
		this.getNavigator().setBreakDoors(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIBreakDoor(this));;
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(2, new EntityAIMoveTowardsTarget(this, 0.9D, 32.0F));
		this.tasks.addTask(6, new EntityAIWander(this, 0.6D));
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
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(450.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(25.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(40.0D);
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entity) {
		
		boolean KyrulMinions = ((entity instanceof EntityPyroKnight) || (entity instanceof EntityUndeadWarrior) || (entity instanceof EntityUndeadMinion) || (entity instanceof EntityVoidDragon) || (entity instanceof EntitySkeletalHorse));
		
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
					if (player.inventory.armorInventory[i] != null)
						hasArmor = false;
				}
				
				if (!player.worldObj.isRemote && !hasArmor) {
					this.playSound("mob.blaze.hit", 0.5F, 1.0F);
				}
			}
			
			int i = this.worldObj.difficultySetting.getDifficultyId();
			
			entity.setFire(10 * i);
			
		}
		
		return KyrulMinions;
	}
	
	/** Returns the sound this mob makes while it's alive. */
	@Override
	protected String getLivingSound() {
		return "mob.blaze.breathe";
	}
	
	/** Returns the sound this mob makes when it is hurt. */
	@Override
	protected String getHurtSound() {
		return "mob.wither.hurt";
	}
	
	/** Returns the sound this mob makes on death. */
	@Override
	protected String getDeathSound() {
		return "mob.wither.death";
	}
	
	@Override
	protected void collideWithEntity(Entity entity) {
		boolean KyrulMinions = ((entity instanceof EntityPyroKnight) || (entity instanceof EntityUndeadWarrior) || (entity instanceof EntityUndeadMinion) || (entity instanceof EntityVoidDragon) || (entity instanceof EntitySkeletalHorse));
		
		if (entity instanceof IMob && this.getRNG().nextInt(20) == 0 && !(KyrulMinions)) {
			this.setAttackTarget((EntityLivingBase) entity);
		}
		
		super.collideWithEntity(entity);
	}
	
	@Override
	public void onLivingUpdate() {
		
		for (int i = 0; i < 2; ++ i) {
			this.worldObj.spawnParticle("largesmoke", this.posX + (this.rand.nextDouble() - 0.5D) * (double) this.width, this.posY + this.rand.nextDouble() * (double) this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width, 0.0D, 0.0D, 0.0D);
		}
		
		if (worldObj.isRemote) {
			BossStatus.setBossStatus(this, true);
		}
		
		for (int l = 0; l < 4; ++ l) {
			
			int x = MathHelper.floor_double(this.posX);
			int y = MathHelper.floor_double(this.posY);
			int z = MathHelper.floor_double(this.posZ);
			
			x = MathHelper.floor_double(this.posX + (double) ((float) (l % 2 * 2 - 1) * 0.25F));
			y = MathHelper.floor_double(this.posY);
			z = MathHelper.floor_double(this.posZ + (double) ((float) (l / 2 % 2 * 2 - 1) * 0.25F));
			
			if (this.worldObj.getBlock(x, y, z).getMaterial() == Material.air && Blocks.fire.canPlaceBlockAt(this.worldObj, x, y, z)) {
				this.worldObj.setBlock(x, y, z, Blocks.fire);
			}
		}
		
		super.onLivingUpdate();
	}
	
	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEAD;
	}
	
	@Override
	public void onKillEntity(EntityLivingBase p_70074_1_) {
		super.onKillEntity(p_70074_1_);
		
		if ((this.worldObj.difficultySetting == EnumDifficulty.NORMAL || this.worldObj.difficultySetting == EnumDifficulty.HARD) && p_70074_1_ instanceof EntityVillager) {
			if (this.worldObj.difficultySetting != EnumDifficulty.HARD && this.rand.nextBoolean()) { return; }
			
			EntityUndeadMinion entityundeadminion = new EntityUndeadMinion(this.worldObj);
			entityundeadminion.copyLocationAndAnglesFrom(p_70074_1_);
			this.worldObj.removeEntity(p_70074_1_);
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
	public ItemStack getHeldItem() {
		return defaultHeldItem;
	}
	
	private static final ItemStack defaultHeldItem;
	
	static {
		defaultHeldItem = new ItemStack(ModTools.tenebraeSword, 1);
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public boolean canAttackClass(Class par1Class) {
		return EntityPyroKnight.class != par1Class && EntityUndeadWarrior.class != par1Class && EntityUndeadMinion.class != par1Class && EntityVoidDragon.class != par1Class && EntitySkeletalHorse.class != par1Class;
	}
	
	@Override
	protected boolean canDespawn() {
		return false;
	}
}