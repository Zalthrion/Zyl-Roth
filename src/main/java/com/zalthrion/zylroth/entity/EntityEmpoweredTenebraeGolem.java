package com.zalthrion.zylroth.entity;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.zalthrion.zylroth.lib.ModItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityEmpoweredTenebraeGolem extends EntityMob implements IBossDisplayData {
	private int attackTimer;
	
	private int deathTicks;
	
	public EntityEmpoweredTenebraeGolem(World world) {
		super(world);
		this.setSize(2.1F, 4.2F);
		this.getNavigator().setAvoidsWater(true);
		this.isImmuneToFire = true;
		this.experienceValue = 75;
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(2, new EntityAIMoveTowardsTarget(this, 2.0D, 32.0F));
		this.tasks.addTask(3, new EntityAISwimming(this));
		this.tasks.addTask(6, new EntityAIWander(this, 0.9D));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, false, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityLiving.class, 0, false, true));
		
	}
	
	/** Returns true if the newer Entity AI code should be run */
	@Override
	public boolean isAIEnabled() {
		return true;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		// this.applyAttribute(SharedMonsterAttributes.attackDamage, 0.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1250.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.27D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(15.0D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(60.0D);
		
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
			int j = MathHelper.floor_double(this.posY - 0.20000000298023224D - (double) this.yOffset);
			int k = MathHelper.floor_double(this.posZ);
			Block block = this.worldObj.getBlock(i, j, k);
			
			if (block.getMaterial() != Material.air) {
				this.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(block) + "_" + this.worldObj.getBlockMetadata(i, j, k), this.posX + ((double) this.rand.nextFloat() - 0.5D) * (double) this.width, this.boundingBox.minY + 0.1D, this.posZ + ((double) this.rand.nextFloat() - 0.5D) * (double) this.width, 4.0D * ((double) this.rand.nextFloat() - 0.5D), 0.5D, ((double) this.rand.nextFloat() - 0.5D) * 4.0D);
			}
		}
		
		if (worldObj.isRemote) {
			BossStatus.setBossStatus(this, true);
		}
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entity) {
		this.attackTimer = 40;
		this.worldObj.setEntityState(this, (byte) 4);
		
		boolean strike = super.attackEntityAsMob(entity);
		boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float) (7 + this.rand.nextInt(15)));
		
		if (flag && this.attackTimer > 10) {
			if (this.getRNG().nextBoolean()) {
				this.attackTimer = 0;
				entity.motionY += 1.0D;
				return flag;
			}
		}
		
		if (strike && this.attackTimer > 25) {
			if (this.getRNG().nextBoolean()) {
				this.attackTimer = 400;
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.wither.id, 200));
				return strike;
			}
		}
		
		this.playSound("mob.irongolem.throw", 1.0F, 1.0F);
		return flag;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void handleHealthUpdate(byte par1) {
		if (par1 == 4) {
			this.attackTimer = 10;
			this.playSound("mob.irongolem.throw", 1.0F, 1.0F);
		} else {
			super.handleHealthUpdate(par1);
		}
	}
	
	/** Controls the delay between the attacks of the entity */
	@SideOnly(Side.CLIENT)
	public int getAttackTimer() {
		return this.attackTimer;
	}
	
	/** Returns the sound this mob makes while it's alive. */
	@Override
	protected String getLivingSound() {
		return "mob.wither.idle";
	}
	
	/** Returns the sound this mob makes when it is hurt. */
	@Override
	protected String getHurtSound() {
		return "mob.zombie.metal";
	}
	
	/** Returns the sound this mob makes on death. */
	@Override
	protected String getDeathSound() {
		return "mob.irongolem.death";
	}
	
	/** Plays step sound at given x, y, z for the entity */
	@Override
	protected void playStepSound(int x, int y, int z, Block block) {
		this.playSound("mob.irongolem.walk", 1.0F, 1.0F);
	}
	
	/** Drop 0-2 items of this living's type. @param par1 - Whether this entity
	 * has recently been hit by a player. @param par2 - Level of Looting used to
	 * kill this mob. */
	@Override
	protected void dropFewItems(boolean par1, int par2) {
		this.dropItem(ModItems.void_Gem, 1);
		this.dropItem(ModItems.void_Essence, 4);
		
		int amount = this.rand.nextInt(4) + 2 + this.rand.nextInt(1 + par2 * 2);
		
		for (int def = 0; def < amount; ++ def) {
			this.entityDropItem(new ItemStack(ModItems.raw_Tenebrae, 1, 6), 0f);
		}
	}
	
    protected void onDeathUpdate()
    {
        ++this.deathTicks;

        if (this.deathTicks >= 180 && this.deathTicks <= 200)
        {
            float f = (this.rand.nextFloat() - 0.5F) * 8.0F;
            float f1 = (this.rand.nextFloat() - 0.5F) * 4.0F;
            float f2 = (this.rand.nextFloat() - 0.5F) * 8.0F;
            this.worldObj.spawnParticle("hugeexplosion", this.posX + (double)f, this.posY + 2.0D + (double)f1, this.posZ + (double)f2, 0.0D, 0.0D, 0.0D);
        }

        int i;
        int j;

        if (!this.worldObj.isRemote)
        {
            if (this.deathTicks == 1)
            {
                this.worldObj.playBroadcastSound(1018, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
            }
        }

        this.moveEntity(0.D, 0.1D, 0.0D);
		for (int countparticles = 900; countparticles <= 1000; ++ countparticles) {
			this.worldObj.spawnParticle("portal", (double) this.posX - 0.0F, (double) this.posY - -1.5F, (double) this.posZ - 0.0F, (double) ((float) rand.nextFloat() - 0.1F), (double) ((float) rand.nextFloat() - 0.1F), (double) ((float) rand.nextFloat()) - 0.1F);
			this.worldObj.spawnParticle("portal", (double) this.posX - 0.0F, (double) this.posY - -1.5F, (double) this.posZ - 0.0F, (double) ((float) rand.nextFloat() - 1.1F), (double) ((float) rand.nextFloat() - 0.1F), (double) ((float) rand.nextFloat()) - 0.1F);
			this.worldObj.spawnParticle("portal", (double) this.posX - 0.0F, (double) this.posY - -1.5F, (double) this.posZ - 0.0F, (double) ((float) rand.nextFloat() - 0.5F), (double) ((float) rand.nextFloat() - 0.1F), (double) ((float) rand.nextFloat()) - 1.1F);
		}
        this.renderYawOffset = this.rotationYaw += 1000.0F;

        if (this.deathTicks == 200 && !this.worldObj.isRemote)
        {
            i = 2000;

            while (i > 0)
            {
                j = EntityXPOrb.getXPSplit(i);
                i -= j;
                this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, j));
            }

            this.setDead();
        }
    }
    
    @Override
    public boolean canBeCollidedWith() {
    	if(this.deathTicks >= 1){
    		return false;
    	} 
    	else return true;
    }
	
	/** Called when the mob is falling. Calculates and applies fall damage. */
	protected void fall(float distance) {}
	
	protected boolean canDespawn() {
		return false;
	}
	
	/* private void applyAttribute(IAttribute attribute, double baseValue) {
	 * IAttributeInstance attr = this.getEntityAttribute(attribute); if (attr ==
	 * null) { this.getAttributeMap().registerAttribute(attribute);
	 * this.getEntityAttribute(attribute).setBaseValue(baseValue); } else {
	 * attr.setBaseValue(baseValue); } } */
	
	/** Returns true if this entity can attack entities of the specified class. */
	@SuppressWarnings("rawtypes")
	public boolean canAttackClass(Class par1Class) {
		return EntityEmpoweredTenebraeGolem.class != par1Class && EntityTenebraeGolem.class != par1Class;
	}
}