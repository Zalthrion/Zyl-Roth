package com.zalthrion.zylroth.item.tools;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import com.zalthrion.zylroth.lib.ModItems;
import com.zalthrion.zylroth.lib.ModTabs;
import com.zalthrion.zylroth.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WoodenCrossbow extends Item implements ZylrothTool {
	
	private String name = "woodenCrossbow";
	
	public WoodenCrossbow(int i) {
		super();
		this.setCreativeTab(ModTabs.ZylRoth);
		this.setMaxDurability(i);
		this.setMaxStackSize(1);
		this.setNames(name);
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		
		if (!this.isBroken(stack)) {        
			if (player.capabilities.isCreativeMode || player.inventory.hasItem(Items.arrow)) {
				
				EntityArrow entityarrow = new EntityArrow(world, player, 0.7F);
				
				entityarrow.setDamage(entityarrow.getDamage() + 3.5D);
				world.playSoundAtEntity(player, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + 0.5F);
				
	            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, stack);

	            if (k > 0)
	            {
	                entityarrow.setDamage(entityarrow.getDamage() + (double)k * 0.5D + 0.5D);
	            }

	            int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, stack);

	            if (l > 0)
	            {
	                entityarrow.setKnockbackStrength(l);
	            }

	            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, stack) > 0)
	            {
	                entityarrow.setFire(100);
	            }
	            	            	            
				if (!world.isRemote) {
					world.spawnEntityInWorld(entityarrow);
				}
				
				player.inventory.consumeInventoryItem(Items.arrow);
				
				stack.damageItem(1, player);
			}	
		}
		
		if (this.isBroken(stack) && world.isRemote) {
			
			player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "broken_tool")));
		}
		
		return stack;
		
	}
	
	public boolean isBroken(ItemStack stack) {
		return stack.getMetadata() >= 2499;
	}
	
	@Override
	public boolean onBlockStartBreak(ItemStack stack, int x, int y, int z, EntityPlayer player) {
		if (this.isBroken(stack)) {
			
			if (player.worldObj.isRemote) {
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "broken_tool")));
			}
			
			return true;
		}
		
		else return false;
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
			player.addChatMessage(new ChatComponentText("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "broken_tool"));
		return true;
	}
	
	@SuppressWarnings({"unchecked", "rawtypes"})
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		
		if (this.isBroken(stack)) {
			list.add(StatCollector.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "broken_tool"));
		}
		
		else if (!(this.isBroken(stack))) {
			list.add(StatCollector.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "tenebrae_tool_lore"));
			list.add(StatCollector.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "tenebrae_generic"));
			
			list.add(StatCollector.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "shift"));
			
			if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
				list.remove(StatCollector.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "shift"));
				
				list.add(StatCollector.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "tenebrae_tool_info"));
			}
		}
	}
	
	@Override
	public boolean getIsRepairable(ItemStack armor, ItemStack stack) {
		return stack.getItem() == ModItems.tenebraeIngot;
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
}