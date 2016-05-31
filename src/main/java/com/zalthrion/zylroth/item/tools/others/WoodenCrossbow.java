package com.zalthrion.zylroth.item.tools.others;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import com.zalthrion.zylroth.item.tools.ZylrothTool;
import com.zalthrion.zylroth.lib.ModInit.ItemInit;
import com.zalthrion.zylroth.lib.ModInit.ZylrothTab;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.utility.TooltipHelper;

public class WoodenCrossbow extends Item implements ZylrothTool {
	public WoodenCrossbow(int i) {
		super();
		this.setCreativeTab(ZylrothTab.ZYLROTH);
		this.setMaxDamage(i);
		this.setMaxStackSize(1);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID.toLowerCase(), "woodenCrossbow"));
		this.setUnlocalizedName("woodenCrossbow");
	}
	
	@Override public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
		if (!this.isBroken(stack)) {        
			boolean flag = player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
			ItemStack itemstack = this.getArrowStack(player);
			
			if (itemstack != null || flag) {
				if (itemstack == null) itemstack = new ItemStack(Items.ARROW);
				float f = 1.0F;
				boolean flag1 = flag && itemstack.getItem() instanceof ItemArrow;
				if (!world.isRemote) {
					ItemArrow itemarrow = (ItemArrow)((ItemArrow)(itemstack.getItem() instanceof ItemArrow ? itemstack.getItem() : Items.ARROW));
					EntityArrow entityarrow = itemarrow.createArrow(world, itemstack, player);
					entityarrow.setAim(player, player.rotationPitch, player.rotationYaw, 0.0F, f * 3.0F, 1.0F);
					entityarrow.setDamage(entityarrow.getDamage() + 3.5D);
					entityarrow.setIsCritical(true);
					int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
					if (j > 0) {
						entityarrow.setDamage(entityarrow.getDamage() + (double) j * 0.5D + 0.5D);
					}
					int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
					if (k > 0) {
						entityarrow.setKnockbackStrength(k);
					}
					if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0) {
						entityarrow.setFire(100);
					}
					stack.damageItem(1, player);
					if (flag1) entityarrow.pickupStatus = EntityArrow.PickupStatus.CREATIVE_ONLY;
					world.spawnEntityInWorld(entityarrow);
				}
				
				world.playSound((EntityPlayer) null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.NEUTRAL, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
				if (!flag1) {
					itemstack.stackSize --;
					if (itemstack.stackSize == 0) {
						player.inventory.deleteStack(itemstack);
					}
				}
				player.addStat(StatList.getObjectUseStats(this));
			}
		}
		
		if (this.isBroken(stack) && world.isRemote) {
			
			player.addChatMessage(new TextComponentTranslation("msg." + Reference.RESOURCE_PREFIX + "broken_tool"));
		}
		
		return new ActionResult<ItemStack>(EnumActionResult.PASS, stack);
	}
	
	private ItemStack getArrowStack(EntityPlayer player) {
		if (this.isArrows(player.getHeldItem(EnumHand.OFF_HAND))) {
			return player.getHeldItem(EnumHand.OFF_HAND);
		} else if (this.isArrows(player.getHeldItem(EnumHand.MAIN_HAND))) {
			return player.getHeldItem(EnumHand.MAIN_HAND);
		} else {
			for (int i = 0; i < player.inventory.getSizeInventory(); ++ i) {
				ItemStack itemstack = player.inventory.getStackInSlot(i);
				
				if (this.isArrows(itemstack)) { return itemstack; }
			}
			
			return null;
		}
	}
	
	protected boolean isArrows(ItemStack stack) {
		return stack != null && stack.getItem() instanceof ItemArrow;
	}
	
	@Override public boolean isBroken(ItemStack stack) {
		return stack.getMetadata() >= 2499;
	}
	
	@Override
	public boolean onBlockStartBreak(ItemStack stack, BlockPos pos, EntityPlayer player) {
		if (this.isBroken(stack)) {
			if (player.worldObj.isRemote) {
				player.addChatMessage(new TextComponentTranslation("msg." + Reference.RESOURCE_PREFIX + "broken_tool"));
			}
			return true;
		}
		return false;
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		if (!(this.isBroken(stack)))
			stack.damageItem(1, attacker);
		return true;
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		if (!isBroken(stack))
			return false;
		
		World world = player.worldObj;
		if (world.isRemote)
			player.addChatMessage(new TextComponentTranslation("msg." + Reference.RESOURCE_PREFIX + "broken_tool"));
		return true;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean advanced) {
		if (this.isBroken(stack)) {
			list.add(I18n.format("msg." + Reference.RESOURCE_PREFIX + "broken_tool"));
		} else {
			list.addAll(TooltipHelper.addAll("tenebrae_tool_lore"));
			list.addAll(TooltipHelper.addAll("tenebrae_generic"));
			if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
				list.addAll(TooltipHelper.addAll("tenebrae_tool_info"));
			} else {
				list.addAll(TooltipHelper.addAll("shift"));
			}
		}
	}
	
	@Override
	public boolean getIsRepairable(ItemStack armor, ItemStack stack) {
		return stack.getItem() == ItemInit.TENEBRAE_INGOT;
	}
	
	@Override
	public String getUnlocalizedName() {
		return String.format("item.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return String.format("item.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
}