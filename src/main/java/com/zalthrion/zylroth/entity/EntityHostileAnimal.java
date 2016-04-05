package com.zalthrion.zylroth.entity;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

//TODO Check all mappings, reorganize methods, etc.
public class EntityHostileAnimal extends EntityAnimal implements IMob {
    private int inLove;
    private EntityPlayer playerInLove;
    
	public EntityHostileAnimal(World worldIn) {
		super(worldIn);
		this.experienceValue = 5;
	}
	
	@Override protected void updateAITasks() {
		if (this.getGrowingAge() != 0) {
			this.inLove = 0;
		}
		
		super.updateAITasks();
	}
	
	@Override public boolean attackEntityFrom(DamageSource source, float amount) {
		if (this.isEntityInvulnerable(source)) {
			return false;
		} else {
			this.inLove = 0;
			return super.attackEntityFrom(source, amount);
		}
	}
	
	@Override public float getBlockPathWeight(BlockPos pos) {
		return this.worldObj.getBlockState(pos.down()).getBlock() == Blocks.grass ? 10.0F : this.worldObj.getLightBrightness(pos) - 0.5F;
	}
	
	@Override public void writeEntityToNBT(NBTTagCompound tagCompound) {
		super.writeEntityToNBT(tagCompound);
		tagCompound.setInteger("InLove", this.inLove);
	}
	
	@Override public void readEntityFromNBT(NBTTagCompound tagCompund) {
		super.readEntityFromNBT(tagCompund);
		this.inLove = tagCompund.getInteger("InLove");
	}
	
	@Override public boolean getCanSpawnHere() {
		int i = MathHelper.floor_double(this.posX);
		int j = MathHelper.floor_double(this.getEntityBoundingBox().minY);
		int k = MathHelper.floor_double(this.posZ);
		BlockPos blockpos = new BlockPos(i, j, k);
		return this.worldObj.getBlockState(blockpos.down()).getBlock() == this.spawnableBlock && this.worldObj.getLight(blockpos) > 8 && super.getCanSpawnHere();
	}
	
	@Override public int getTalkInterval() {
		return 120;
	}
	
	@Override protected boolean canDespawn() {
		return false;
	}
	
	@Override protected int getExperiencePoints(EntityPlayer player) {
		return 1 + this.worldObj.rand.nextInt(3);
	}
	
	@Override public boolean isBreedingItem(ItemStack stack) {
		return stack == null ? false : stack.getItem() == Items.wheat;
	}
	
	@Override public boolean processInteract(EntityPlayer player, EnumHand hand, ItemStack stack) {
		if (stack != null) {
			if (this.isBreedingItem(stack) && this.getGrowingAge() == 0 && this.inLove <= 0) {
				this.consumeItemFromStack(player, stack);
				this.setInLove(player);
				return true;
			}
			
			if (this.isChild() && this.isBreedingItem(stack)) {
				this.consumeItemFromStack(player, stack);
				this.func_175501_a((int) ((float) (-this.getGrowingAge() / 20) * 0.1F), true);
				return true;
			}
		}
		
		return super.processInteract(player, hand, stack);
	}
	
	@Override protected void consumeItemFromStack(EntityPlayer player, ItemStack stack) {
		if (!player.capabilities.isCreativeMode) {
			-- stack.stackSize;
			
			if (stack.stackSize <= 0) {
				player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack) null);
			}
		}
	}
	
	@Override public void setInLove(EntityPlayer player) {
		this.inLove = 600;
		this.playerInLove = player;
		this.worldObj.setEntityState(this, (byte) 18);
	}
	
	@Override public EntityPlayer getPlayerInLove() {
		return this.playerInLove;
	}
	
	@Override public boolean isInLove() {
		return this.inLove > 0;
	}
	
	@Override public void resetInLove() {
		this.inLove = 0;
	}
	
	@Override public boolean canMateWith(EntityAnimal otherAnimal) {
		return otherAnimal == this ? false : (otherAnimal.getClass() != this.getClass() ? false : this.isInLove() && otherAnimal.isInLove());
	}
	
	@Override @SideOnly(Side.CLIENT) public void handleStatusUpdate(byte id) {
		if (id == 18) {
			for (int i = 0; i < 7; ++ i) {
				double d0 = this.rand.nextGaussian() * 0.02D;
				double d1 = this.rand.nextGaussian() * 0.02D;
				double d2 = this.rand.nextGaussian() * 0.02D;
				this.worldObj.spawnParticle(EnumParticleTypes.HEART, this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, this.posY + 0.5D + (double) (this.rand.nextFloat() * this.height), this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, d0, d1, d2, new int[0]);
			}
		} else {
			super.handleStatusUpdate(id);
		}
	}
	
	@Override protected SoundEvent getSwimSound() {
		return SoundEvents.entity_hostile_swim;
	}
	
	@Override protected SoundEvent getSplashSound() {
		return SoundEvents.entity_hostile_splash;
	}
	
	@Override protected SoundEvent getHurtSound() {
		return SoundEvents.entity_hostile_hurt;
	}
	
	@Override protected SoundEvent getDeathSound() {
		return SoundEvents.entity_hostile_death;
	}
	
	@Override protected SoundEvent getFallSound(int heightIn) {
		return heightIn > 4 ? SoundEvents.entity_hostile_big_fall : SoundEvents.entity_hostile_small_fall;
	}
	
	@Override public boolean attackEntityAsMob(Entity entityIn) {
		float f = (float) this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();
		int i = 0;
		
		if (entityIn instanceof EntityLivingBase) {
			f += EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(), ((EntityLivingBase) entityIn).getCreatureAttribute());
			i += EnchantmentHelper.getKnockbackModifier(this);
		}
		
		boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f);
		
		if (flag) {
			if (i > 0) {
				entityIn.addVelocity((double) (-MathHelper.sin(this.rotationYaw * (float) Math.PI / 180.0F) * (float) i * 0.5F), 0.1D, (double) (MathHelper.cos(this.rotationYaw * (float) Math.PI / 180.0F) * (float) i * 0.5F));
				this.motionX *= 0.6D;
				this.motionZ *= 0.6D;
			}
			
			int j = EnchantmentHelper.getFireAspectModifier(this);
			
			if (j > 0) {
				entityIn.setFire(j * 4);
			}
			
			this.applyEnchantments(this, entityIn);
		}
		
		return flag;
	}
	
	protected boolean isValidLightLevel() {
		BlockPos blockpos = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);
		
		if (this.worldObj.getLightFor(EnumSkyBlock.SKY, blockpos) > this.rand.nextInt(32)) {
			return false;
		} else {
			int i = this.worldObj.getLightFromNeighbors(blockpos);
			
			if (this.worldObj.isThundering()) {
				int j = this.worldObj.getSkylightSubtracted();
				this.worldObj.setSkylightSubtracted(10);
				i = this.worldObj.getLightFromNeighbors(blockpos);
				this.worldObj.setSkylightSubtracted(j);
			}
			
			return i <= this.rand.nextInt(8);
		}
	}
	
	@Override protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
	}
	
	@Override protected boolean canDropLoot() {
		return true;
	}

	@Override public EntityAgeable createChild(EntityAgeable ageable) {
		return null;
	}
}