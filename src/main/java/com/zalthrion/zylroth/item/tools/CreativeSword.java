package com.zalthrion.zylroth.item.tools;

import java.util.List;
import java.util.Random;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import com.zalthrion.zylroth.lib.ModInit.ItemInit;
import com.zalthrion.zylroth.lib.ModInit.ZylrothTab;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.utility.TooltipHelper;

public class CreativeSword extends ItemSword implements ZylrothTool {
	public CreativeSword(ToolMaterial material) {
		super(material);
		this.setCreativeTab(ZylrothTab.ZYLROTH);
		this.setNames(this, "creativeSword");
	}
	
	@Override public boolean isCreative() {
		return true;
	}
	
	@Override public boolean onBlockStartBreak(ItemStack stack, BlockPos pos, EntityPlayer player) {
		if (this.isBroken(stack)) {
			if (player.worldObj.isRemote) {
				player.addChatMessage(new TextComponentTranslation("msg." + Reference.RESOURCE_PREFIX + "broken_sword"));
			}
			return true;
		}
		return false;
	}
	
	@Override public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		Random rand = new Random();
		
		if (!(playerIn.isSneaking()) && !(playerIn.capabilities.isCreativeMode)) {
			
			for (int countparticles = 0; countparticles <= 100; ++ countparticles) {
				worldIn.spawnParticle(EnumParticleTypes.PORTAL, (double) playerIn.posX - 0.0F, (double) playerIn.posY - 0.5F, (double) playerIn.posZ - 0.0F, (double) ((float) rand.nextFloat() - 0.1F), (double) ((float) rand.nextFloat() - 0.1F), (double) ((float) rand.nextFloat()) - 0.1F);
				worldIn.spawnParticle(EnumParticleTypes.PORTAL, (double) playerIn.posX - 0.0F, (double) playerIn.posY - 0.5F, (double) playerIn.posZ - 0.0F, (double) ((float) rand.nextFloat() - 1.1F), (double) ((float) rand.nextFloat() - 0.1F), (double) ((float) rand.nextFloat()) - 0.1F);
				worldIn.spawnParticle(EnumParticleTypes.PORTAL, (double) playerIn.posX - 0.0F, (double) playerIn.posY - 0.5F, (double) playerIn.posZ - 0.0F, (double) ((float) rand.nextFloat() - 0.5F), (double) ((float) rand.nextFloat() - 0.1F), (double) ((float) rand.nextFloat()) - 1.1F);
			}
		}
		
		if (playerIn.isSneaking()) {
			
			if (playerIn.capabilities.isCreativeMode) { return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemStackIn); }
			
			if (this.isBroken(itemStackIn) && !(worldIn.isRemote)) {
				playerIn.addChatMessage(new TextComponentTranslation("msg." + Reference.RESOURCE_PREFIX + "broken_sword"));
				return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemStackIn);
				
			} else if (itemStackIn.getMetadata() < 2200) {
				
				itemStackIn.damageItem(50, playerIn);
				worldIn.playSound((EntityPlayer) null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.NEUTRAL, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + 1.0F * 0.5F);
				
				if (!worldIn.isRemote) {
					worldIn.spawnEntityInWorld(new EntityEnderPearl(worldIn, playerIn));
				}
				
				worldIn.spawnParticle(EnumParticleTypes.PORTAL, playerIn.posX + (rand.nextDouble() - 0.5D) * (double) playerIn.width, playerIn.posY + rand.nextDouble() * (double) playerIn.height - (double) playerIn.getYOffset(), playerIn.posZ + (rand.nextDouble() - 0.5D) * (double) playerIn.width, 0.0D, 0.0D, 0.0D);
			}
			
		}
		
		return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
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
		} else if (!(this.isBroken(stack))) {
			TorchPlacer.tryPlaceTorch(stack, playerIn, worldIn, pos, hand, facing);
			return EnumActionResult.PASS;
		}
		return EnumActionResult.FAIL;
	}
	
	@Override public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean advanced) {
		if (this.isBroken(stack)) {
			list.add(I18n.format("msg." + Reference.RESOURCE_PREFIX + "broken_sword"));
		} else {
			list.addAll(TooltipHelper.addAll("creative_sword_lore"));
			list.addAll(TooltipHelper.addAll("creative_generic"));
			if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
				list.addAll(TooltipHelper.addAll("creative_sword_info"));
			} else {
				list.addAll(TooltipHelper.addAll("shift"));
			}
		}
	}
	
	@Override public boolean getIsRepairable(ItemStack armor, ItemStack stack) {
		return stack.getItem() == ItemInit.TENEBRAE_INGOT;
	}
	
	@Override public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		if (!(this.isBroken(stack))) stack.damageItem(1, attacker);
		return true;
	}
	
	@Override public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		if (!isBroken(stack)) return false;
		World world = player.worldObj;
			
		if (world.isRemote) player.addChatMessage(new TextComponentTranslation("tooltip." + Reference.RESOURCE_PREFIX + "broken_sword"));
		
		return true;
	}
	
	@Override public String getUnlocalizedName() {
		return String.format("item.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	@Override public String getUnlocalizedName(ItemStack itemStack) {
		return String.format("item.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
}