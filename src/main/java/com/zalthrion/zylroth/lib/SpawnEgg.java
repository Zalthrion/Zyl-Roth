package com.zalthrion.zylroth.lib;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.utility.DecimalBlockPos;

public class SpawnEgg extends ItemMonsterPlacer {
	protected int colorBase = 0x000000;
	protected int colorSpots = 0xFFFFFF;
	protected String entityToSpawnName = "";
	protected String entityToSpawnNameFull = "";
	protected EntityLiving entityToSpawn = null;
	
	public SpawnEgg() {
		super();
	}
	
	public SpawnEgg(String parEntityToSpawnName, int parPrimaryColor, int parSecondaryColor) {
		this.setHasSubtypes(false);
		this.setCreativeTab(ModTabs.ZylRoth);
		this.setEntityToSpawnName(parEntityToSpawnName);
		this.colorBase = parPrimaryColor;
		this.colorSpots = parSecondaryColor;
	}
	
	@Override public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (world.isRemote) return true;
		Block block = world.getBlockState(pos).getBlock();
		pos.offset(side);
		double d0 = (side == EnumFacing.UP && block.getRenderType() == 11) ? 0.5F : 0.0D;
		
		Entity entity = spawnEntity(world, new DecimalBlockPos(pos, 0.5, d0, 0.5));
		
		if (entity != null) {
			if (entity instanceof EntityLivingBase && stack.hasDisplayName()) {
				((EntityLiving) entity).setCustomNameTag(stack.getDisplayName());
			}
			
			if (!player.capabilities.isCreativeMode) {
				-- stack.stackSize;
			}
		}
		
		return true;
	}
	
	@Override public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (world.isRemote) return stack;
		MovingObjectPosition movingobjectposition = getMovingObjectPositionFromPlayer(world, player, true);
		
		if (movingobjectposition == null) return stack;
		if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
			BlockPos pos = movingobjectposition.getBlockPos();
			
			if (!world.canMineBlockBody(player, pos)) return stack;
			if (!player.canPlayerEdit(pos, movingobjectposition.sideHit, stack)) return stack;
			
			if (world.getBlockState(pos).getBlock() instanceof BlockLiquid) {
				Entity entity = spawnEntity(world, DecimalBlockPos.fromBlockPos(pos));
				
				if (entity != null) {
					if (entity instanceof EntityLivingBase && stack.hasDisplayName()) {
						((EntityLiving) entity).setCustomNameTag(stack.getDisplayName());
					}
					
					if (!player.capabilities.isCreativeMode) {
						stack.stackSize --;
					}
				}
			}
		}
		
		return stack;
	}
	
	/** Spawns the creature specified by the egg's type in the location specified
	 * by the last three parameters. Parameters: world, entityID, x, y, z. */
	public Entity spawnEntity(World world, DecimalBlockPos pos) {
		if (!world.isRemote) // never spawn entity on client side
		{
			entityToSpawnNameFull = Reference.MOD_ID + "." + entityToSpawnName;
			if (EntityList.stringToClassMapping.containsKey(entityToSpawnNameFull)) {
				entityToSpawn = (EntityLiving) EntityList.createEntityByName(entityToSpawnNameFull, world);
				entityToSpawn.setLocationAndAngles(pos.getX(), pos.getY(), pos.getZ(), MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
				world.spawnEntityInWorld(entityToSpawn);
				entityToSpawn.onInitialSpawn(world.getDifficultyForLocation(pos.getOriginal()), (IEntityLivingData) null);
				entityToSpawn.playLivingSound();
			} else {
				// DEBUG
				System.out.println("Entity not found " + entityToSpawnName);
			}
		}
		
		return entityToSpawn;
	}
	
	@Override @SideOnly(Side.CLIENT) public int getColorFromItemStack(ItemStack par1ItemStack, int parColorType) {
		return (parColorType == 0) ? colorBase : colorSpots;
	}
	
	public void setColors(int parColorBase, int parColorSpots) {
		colorBase = parColorBase;
		colorSpots = parColorSpots;
	}
	
	public int getColorBase() {
		return colorBase;
	}
	
	public int getColorSpots() {
		return colorSpots;
	}
	
	public void setEntityToSpawnName(String parEntityToSpawnName) {
		entityToSpawnName = parEntityToSpawnName;
		entityToSpawnNameFull = Reference.MOD_ID.toLowerCase() + "." + entityToSpawnName;
	}
}