package com.zalthrion.zylroth.item.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.zalthrion.zylroth.lib.ModRegistry;

public interface ZylrothTool {
	public static final int CREATIVE_DURABILITY = 12249;
	public static final int TENEBRAE_DURABILITY = 2249;
	public static final int VOIDIRITE_DURABILITY = 5249;
	public static final int VOIDIUM_DURABILITY = 4249;
	
	default boolean isBroken(ItemStack stack) {
		if (this.isCreative()) return stack.getMetadata() >= CREATIVE_DURABILITY;
		if (this.isTenebrae()) return stack.getMetadata() >= TENEBRAE_DURABILITY;
		if (this.isVoidirite()) return stack.getMetadata() >= VOIDIRITE_DURABILITY;
		if (this.isVoidium()) return stack.getMetadata() >= VOIDIUM_DURABILITY;
		return false;
	}
	
	default boolean isCreative() { return false; }
	default boolean isTenebrae() { return false; }
	default boolean isVoidirite() { return false; }
	default boolean isVoidium() { return false; }
	
	default void setNames(Item item, String name) {
		item.setRegistryName(ModRegistry.createRegistryNameFor(name));
		item.setUnlocalizedName(name);
	}
	
	default String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
	
	/*
	 * THIS GOES IN EVERY TOOL *
	
	@Override public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		if (!(this.isBroken(stack))) stack.damageItem(1, attacker);
		return true;
	}
	
	@Override public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		if (!isBroken(stack)) return false;
		World world = player.worldObj;
			
		if (world.isRemote) player.addChatMessage(new ChatComponentTranslation("msg." + Reference.RESOURCE_PREFIX + "broken_tool"));
		
		return true;
	}
	
	@Override public String getUnlocalizedName() {
		return String.format("item.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	@Override public String getUnlocalizedName(ItemStack itemStack) {
		return String.format("item.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	*/
}