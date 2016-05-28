package com.zalthrion.zylroth.entity.boss;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.entity.EntityTenebraeProtector;
import com.zalthrion.zylroth.handler.ConfigurationHandler;
import com.zalthrion.zylroth.lib.ModInit.ItemInit;

// TODO Check all mappings, reorganize methods, etc.
public class EntityTenebraeGuardian extends EntityMob {
	protected static final DataParameter<Byte> PLAYER_CREATED = EntityDataManager.<Byte>createKey(EntityTenebraeGuardian.class, DataSerializers.BYTE);
	private int attackTimer;
	public int deathTicks;
	private final BossInfoServer bossInfo = (BossInfoServer) (new BossInfoServer(this.getDisplayName(), BossInfo.Color.PURPLE, BossInfo.Overlay.PROGRESS)).setDarkenSky(true);
	
	public EntityTenebraeGuardian(World world) {
		super(world);
		this.setSize(2.1F, 4.2F);
		((PathNavigateGround) this.getNavigator()).setCanSwim(false);
		this.isImmuneToFire = true;
		this.experienceValue = 75;
		this.ignoreFrustumCheck = true;
	}
	
	@Override protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, false));
		this.tasks.addTask(7, new EntityAIWander(this, 0.9D));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, false, true));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
	}
	
	@Override protected void entityInit() {
		super.entityInit();
		this.dataManager.register(PLAYER_CREATED, Byte.valueOf((byte) 0));
	}
	
	@Override public void addTrackingPlayer(EntityPlayerMP player) {
		super.addTrackingPlayer(player);
		this.bossInfo.addPlayer(player);
	}
	
	@Override public void removeTrackingPlayer(EntityPlayerMP player) {
		super.removeTrackingPlayer(player);
		this.bossInfo.removePlayer(player);
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		boolean hardcore = ConfigurationHandler.getHardcoreModeEnabled();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(hardcore ? 1250.0D : 750.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(hardcore ? 0.28D : 0.27D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(hardcore ? 25.0D : 15.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(hardcore ? 15.0D : 5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(60.0D);
	}
	
	/** Decrements the entity's air supply when underwater */
	@Override
	protected int decreaseAirSupply(int par1) {
		return par1;
	}
	
	@Override
	protected void collideWithEntity(Entity entity) {
		if (entity instanceof IMob && this.getRNG().nextInt(20) == 0) {
			this.setAttackTarget((EntityLivingBase) entity);
		}
		
		super.collideWithEntity(entity);
	}
	
	/** Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn. */
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		
		if (this.attackTimer > 0) {
			-- this.attackTimer;
		}
		
		if (this.motionX * this.motionX + this.motionZ * this.motionZ > 2.500000277905201E-7D && this.rand.nextInt(5) == 0) {
			int i = MathHelper.floor_double(this.posX);
			int j = MathHelper.floor_double(this.posY - 0.20000000298023224D - (double) this.getYOffset());
			int k = MathHelper.floor_double(this.posZ);
			
			if (this.worldObj.getBlockState(new BlockPos(i, j, k)).getRenderType() != EnumBlockRenderType.INVISIBLE) {
				this.worldObj.spawnParticle(EnumParticleTypes.BLOCK_CRACK, this.posX + ((double) this.rand.nextFloat() - 0.5D) * (double) this.width, this.getEntityBoundingBox().minY + 0.1D, this.posZ + ((double) this.rand.nextFloat() - 0.5D) * (double) this.width, 4.0D * ((double) this.rand.nextFloat() - 0.5D), 0.5D, ((double) this.rand.nextFloat() - 0.5D) * 4.0D, Block.getStateId(this.worldObj.getBlockState(new BlockPos(i, j, k))));
			}
		}
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entity) {
		this.attackTimer = 40;
		this.worldObj.setEntityState(this, (byte) 4);
		
		boolean strike = super.attackEntityAsMob(entity);
		boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float) (7 + this.rand.nextInt(15)));
		
		if (strike && this.attackTimer > 10) {
			if (this.getRNG().nextBoolean()) {
				this.attackTimer = 0;
				entity.motionY += 1.0D;
				return flag;
			}
		}
		
		if (strike && this.attackTimer > 25) {
			if (this.getRNG().nextBoolean()) {
				this.attackTimer = 400;
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("wither"), 200));
				return strike;
			}
		}
		
		this.playSound(SoundEvents.ENTITY_IRONGOLEM_ATTACK, 1.0F, 1.0F);
		return flag;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void handleStatusUpdate(byte par1) {
		if (par1 == 4) {
			this.attackTimer = 10;
			this.playSound(SoundEvents.ENTITY_IRONGOLEM_ATTACK, 1.0F, 1.0F);
		} else {
			super.handleStatusUpdate(par1);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public int getAttackTimer() {
		return this.attackTimer;
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_WITCH_AMBIENT;
	}
	
	@Override
	protected SoundEvent getHurtSound() {
		return SoundEvents.ENTITY_ZOMBIE_ATTACK_IRON_DOOR;
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_IRONGOLEM_DEATH;
	}
	
	@Override
	protected void playStepSound(BlockPos pos, Block block) {
		this.playSound(SoundEvents.ENTITY_IRONGOLEM_STEP, 1.0F, 1.0F);
	}
	
	@Override
	protected void dropFewItems(boolean hit, int loot) {
		this.dropItem(ItemInit.voidGem, 1);
		this.dropItem(ItemInit.voidEssence, 4);
		
		int amount = this.rand.nextInt(4) + 2 + this.rand.nextInt(1 + loot * 2);
		
		for (int def = 0; def < amount; ++ def) {
			this.entityDropItem(new ItemStack(ItemInit.tenebraeIOre, 1, 6), 0f);
		}
	}
	
	@Override protected void onDeathUpdate() {
		this.deathTicks ++;
		
		if (this.deathTicks > 0) {
			this.motionY = 0.0F;
			this.motionX = 0.0F;
			this.motionZ = 0.0F;
			this.noClip = true;
		}
		
		if (this.deathTicks >= 180 && this.deathTicks <= 200) {
			float f = (this.rand.nextFloat() - 0.5F) * 8.0F;
			float f1 = (this.rand.nextFloat() - 0.5F) * 4.0F;
			float f2 = (this.rand.nextFloat() - 0.5F) * 8.0F;
			this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, this.posX + (double) f, this.posY + 2.0D + (double) f1, this.posZ + (double) f2, 0.0D, 0.0D, 0.0D);
		}
		
		int i;
		int j;
		
		if (!this.worldObj.isRemote) {
			if (this.deathTicks == 1) {
				this.worldObj.playBroadcastSound(1018, new BlockPos(this.posX, this.posY, this.posZ), 0);
			}
		}
		
		this.moveEntity(0.D, 0.01D, 0.0D);
		for (int countparticles = 900; countparticles <= 1000; ++ countparticles) {
			this.worldObj.spawnParticle(EnumParticleTypes.PORTAL, (double) this.posX - 0.0F, (double) this.posY - -1.5F, (double) this.posZ - 0.0F, (double) ((float) rand.nextFloat() - 0.1F), (double) ((float) rand.nextFloat() - 0.1F), (double) ((float) rand.nextFloat()) - 0.1F);
			this.worldObj.spawnParticle(EnumParticleTypes.PORTAL, (double) this.posX - 0.0F, (double) this.posY - -1.5F, (double) this.posZ - 0.0F, (double) ((float) rand.nextFloat() - 1.1F), (double) ((float) rand.nextFloat() - 0.1F), (double) ((float) rand.nextFloat()) - 0.1F);
			this.worldObj.spawnParticle(EnumParticleTypes.PORTAL, (double) this.posX - 0.0F, (double) this.posY - -1.5F, (double) this.posZ - 0.0F, (double) ((float) rand.nextFloat() - 0.5F), (double) ((float) rand.nextFloat() - 0.1F), (double) ((float) rand.nextFloat()) - 1.1F);
		}
		this.renderYawOffset = this.rotationYaw += 1000.0F;
		
		if (this.deathTicks == 200 && !this.worldObj.isRemote) {
			i = 2000;
			
			while (i > 0) {
				j = EntityXPOrb.getXPSplit(i);
				i -= j;
				this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, j));
			}
			
			this.setDead();
		}
	}
	
	public boolean isPlayerCreated() {
		return (((Byte) this.dataManager.get(PLAYER_CREATED)).byteValue() & 1) != 0;
	}
	
	public void setPlayerCreated(boolean par1) {
		byte b0 = ((Byte) this.dataManager.get(PLAYER_CREATED)).byteValue();
		
		if (par1) {
			this.dataManager.set(PLAYER_CREATED, Byte.valueOf((byte) (b0 | 1)));
		} else {
			this.dataManager.set(PLAYER_CREATED, Byte.valueOf((byte) (b0 & -2)));
		}
	}
	
	@Override
	public boolean canBeCollidedWith() {
		if (this.deathTicks >= 1) {
			return false;
		} else return true;
	}
	
	@Override public void fall(float distance, float damageMultiplier) {}
	
	@Override protected boolean canDespawn() {
		return false;
	}
	
	/** Returns true if this entity can attack entities of the specified class. */
	@Override
	public boolean canAttackClass(Class<? extends EntityLivingBase> par1Class) {
		return EntityTenebraeGuardian.class != par1Class && EntityTenebraeProtector.class != par1Class;
	}
}