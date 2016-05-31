package com.zalthrion.zylroth.item.tools;

import java.util.List;
import java.util.Random;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import com.zalthrion.zylroth.lib.ModInit.ItemInit;
import com.zalthrion.zylroth.lib.ModInit.ZylrothTab;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.utility.TooltipHelper;

public class TenebraeSword extends ItemSword implements ZylrothTool {
	
	private String name = "tenebraeSword";
	
	public TenebraeSword(ToolMaterial material) {
		super(material);
		this.setCreativeTab(ZylrothTab.ZYLROTH);
		this.setUnlocalizedName(name);
	}
	
	@Override public boolean isBroken(ItemStack stack) {
		return stack.getMetadata() >= tenebraeDurability;
	}
	
	@Override public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
		Random rand = new Random();
		
		if (!(player.isSneaking()) && !(player.capabilities.isCreativeMode)) {
			
			/** Test-Item Start */
			 /*			Vec3 vec3 = player.getPosition(1.0F);
			 			vec3.yCoord ++;
			 			Vec3 lookVec = player.getLook(1.0F);
			 			Vec3 aVector = vec3.addVector(lookVec.xCoord * 50.0D, lookVec.yCoord * 50.0D, lookVec.zCoord * 50.0D);
			 			MovingObjectPosition movingObjPos = world.rayTraceBlocks(vec3, aVector, true);
			 			
			 			if (movingObjPos == null) {
			 				return stack;
			 			}
			 			
			 			else {				
			 				if (movingObjPos.entityHit instanceof EntityLivingBase) {
			 					return stack;
			 				} else {
			 					player.setPositionAndUpdate((double) movingObjPos.blockX, ((double) (float) movingObjPos.blockY + 1F), (double) movingObjPos.blockZ);
			 				}
			 				
			 				for (int countparticles = 0; countparticles <= 100; ++ countparticles) {
			 					world.spawnParticle("portal", (double) player.posX - 0.0F, (double) player.posY - 0.5F, (double) player.posZ - 0.0F, (double) ((float) rand.nextFloat() - 0.1F), (double) ((float) rand.nextFloat() - 0.1F), (double) ((float) rand.nextFloat()) - 0.1F);
			 					world.spawnParticle("portal", (double) player.posX - 0.0F, (double) player.posY - 0.5F, (double) player.posZ - 0.0F, (double) ((float) rand.nextFloat() - 1.1F), (double) ((float) rand.nextFloat() - 0.1F), (double) ((float) rand.nextFloat()) - 0.1F);
			 					world.spawnParticle("portal", (double) player.posX - 0.0F, (double) player.posY - 0.5F, (double) player.posZ - 0.0F, (double) ((float) rand.nextFloat() - 0.5F), (double) ((float) rand.nextFloat() - 0.1F), (double) ((float) rand.nextFloat()) - 1.1F);
			 				}
			 			}*/
			
			for (int countparticles = 0; countparticles <= 100; ++ countparticles) {
				world.spawnParticle(EnumParticleTypes.PORTAL, player.posX, player.posY - 0.5F, player.posZ, rand.nextFloat() - 0.1F, rand.nextFloat() - 0.1F, rand.nextFloat() - 0.1F);
				world.spawnParticle(EnumParticleTypes.PORTAL, player.posX, player.posY - 0.5F, player.posZ, rand.nextFloat() - 1.1F, rand.nextFloat() - 0.1F, rand.nextFloat() - 0.1F);
				world.spawnParticle(EnumParticleTypes.PORTAL, player.posX, player.posY - 0.5F, player.posZ, rand.nextFloat() - 0.5F, rand.nextFloat() - 0.1F, rand.nextFloat() - 1.1F);
			}
		}
		
		return super.onItemRightClick(stack, world, player, hand);
	}
	
	@Override public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (worldIn.getBlockState(pos).getBlock() != Blocks.SNOW_LAYER) {
			if (facing == EnumFacing.DOWN) pos = pos.down();
			if (facing == EnumFacing.UP) pos = pos.up();
			if (facing == EnumFacing.SOUTH) pos = pos.south();
			if (facing == EnumFacing.NORTH) pos = pos.north();
			if (facing == EnumFacing.WEST) pos = pos.west();
			if (facing == EnumFacing.EAST) pos = pos.east();
			if (!worldIn.isAirBlock(pos)) return EnumActionResult.FAIL;
		}
		
		if (this.isBroken(stack) && !(worldIn.isRemote)) {
			playerIn.addChatMessage(new TextComponentTranslation("msg." + Reference.RESOURCE_PREFIX + "broken_sword"));
		} else if (playerIn.canPlayerEdit(pos, facing, stack) & !(this.isBroken(stack))) {
			TorchPlacer.tryPlaceTorch(stack, playerIn, worldIn, pos, hand, facing);
			return EnumActionResult.PASS;
		}
		return EnumActionResult.FAIL;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean advanced) {
		if (this.isBroken(stack)) {
			list.add(I18n.format("msg." + Reference.RESOURCE_PREFIX + "broken_sword"));
		} else {
			list.addAll(TooltipHelper.addAll("tenebrae_sword_lore"));
			list.addAll(TooltipHelper.addAll("tenebrae_generic"));
			if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
				list.addAll(TooltipHelper.addAll("tenebrae_sword_stats"));
			} else {
				list.addAll(TooltipHelper.addAll("shift"));
			}
		}
	}
	
	@Override public boolean getIsRepairable(ItemStack armor, ItemStack stack) {
		return stack.getItem() == ItemInit.TENEBRAE_INGOT;
	}
	
	@Override public boolean onBlockStartBreak(ItemStack stack, BlockPos pos, EntityPlayer player) {
		if (!this.isBroken(stack)) return false;
		
		if (player.worldObj.isRemote) {
			player.addChatMessage(new TextComponentTranslation("msg." + Reference.RESOURCE_PREFIX + "broken_sword"));
		}
		return true;
	}
	
	@Override public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		if (!(this.isBroken(stack))) stack.damageItem(1, attacker);
		return true;
	}
	
	@Override public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		if (!isBroken(stack)) return false;
		World world = player.worldObj;
			
		if (world.isRemote) player.addChatMessage(new TextComponentTranslation("msg." + Reference.RESOURCE_PREFIX + "broken_sword"));
		
		return true;
	}
	
	@Override public String getUnlocalizedName() {
		return String.format("item.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	@Override public String getUnlocalizedName(ItemStack itemStack) {
		return String.format("item.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
}