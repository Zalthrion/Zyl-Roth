package com.zalthrion.zylroth.base;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import com.zalthrion.zylroth.lib.ModInit.ZylrothTab;
import com.zalthrion.zylroth.lib.ModRegistry;
import com.zalthrion.zylroth.reference.Reference;

public class ShieldBase extends Item {
	
	/* Constructors */
	
	public ShieldBase() {
		super();
		this.setMaxStackSize(64);
		this.setNoRepair();
	}
	
	/* Custom Methods */
	
	protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
	
	protected ShieldBase setCreativeTab() {
		this.setCreativeTab(ZylrothTab.ZYLROTH);
		return this;
	}
	
	protected ShieldBase setNames(String name) {
		this.setUnlocalizedName(name);
		this.setRegistryName(ModRegistry.createRegistryNameFor(name));
		return this;
	}
	
	/* Overridden */
	
	@Override public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.BLOCK;
	}
	
	@Override public int getMaxItemUseDuration(ItemStack p_77626_1_) {
		return 72000;
	}
	
	@Override public String getUnlocalizedName() {
		return String.format("item.%s%s", Reference.RESOURCE_PREFIX, this.getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	@Override public String getUnlocalizedName(ItemStack itemStack) {
		return String.format("item.%s%s", Reference.RESOURCE_PREFIX, this.getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	@Override public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		playerIn.setActiveHand(hand);
		return new ActionResult<ItemStack>(EnumActionResult.PASS, itemStackIn);
	}
}