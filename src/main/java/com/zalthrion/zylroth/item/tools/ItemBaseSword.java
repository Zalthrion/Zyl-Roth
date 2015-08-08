package com.zalthrion.zylroth.item.tools;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import com.zalthrion.zylroth.lib.ModTabs;
import com.zalthrion.zylroth.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBaseSword extends ItemSword {
	
	protected boolean leftClick;
		
	public ItemBaseSword(ToolMaterial toolMaterial) {
		super(toolMaterial);
		setCreativeTab(ModTabs.ZylRoth);
		setMaxStackSize(1);
	}
	
	@Override
	public String getUnlocalizedName() {
		return String.format("item.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return String.format("item.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		String BaseName = getUnwrappedUnlocalizedName(getUnlocalizedName());
		itemIcon = iconRegister.registerIcon(BaseName);
	}
	
	protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
	
	protected void setNames(String name) {
		this.setUnlocalizedName(name);
		this.setTextureName(Reference.MOD_ID + ":" + name);
	}
	
	public boolean isBroken(ItemStack stack) {
		return false;
	}
	
	/** Current implementations of this method in child classes do not use the
	 * entry argument beside ev. They just raise the damage on the stack. */
	public boolean hitEntity(ItemStack stack, EntityLivingBase p_77644_2_, EntityLivingBase p_77644_3_) {
		if (!(this.isBroken(stack))) stack.damageItem(1, p_77644_3_);
		return true;
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		if (this.isBroken(stack)) {
			this.leftClick = true;
			
			World world = player.worldObj;
			
			if (world.isRemote) {
				player.addChatMessage(new ChatComponentText("You must repair this sword to continue using it!"));
			}
		}
		
		if (!(this.isBroken(stack))) {
			this.leftClick = false;
		}
		
		return leftClick;
	}
}