package com.zalthrion.zylroth.item.tools;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import com.zalthrion.zylroth.lib.ModItems;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.utility.TooltipHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TenebraePickaxe extends ItemPickaxe implements ZylrothTool {
	
	private String name = "tenebraePickaxe";
	
	public TenebraePickaxe(ToolMaterial material) {
		super(material);
		this.setNames(name);
	}
	
	@Override public boolean isBroken(ItemStack stack) {
		return stack.getMetadata() >= tenebraeDurability;
	}
	
	@Override
	public boolean onBlockStartBreak(ItemStack stack, int x, int y, int z, EntityPlayer player) {
		if (this.isBroken(stack)) {
			if (player.worldObj.isRemote) {
				player.addChatMessage(new ChatComponentTranslation("msg." + Reference.RESOURCE_PREFIX + "broken_tool"));
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
			player.addChatMessage(new ChatComponentTranslation("msg." + Reference.RESOURCE_PREFIX + "broken_tool"));
		
		return true;
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		
		Item torch = Item.getItemFromBlock(Blocks.torch);
		
		if (world.getBlock(x, y, z) != Blocks.snow_layer) {
			if (side == 0) {
				-- y;
			}
			if (side == 1) {
				++ y;
			}
			if (side == 2) {
				-- z;
			}
			if (side == 3) {
				++ z;
			}
			if (side == 4) {
				-- x;
			}
			if (side == 5) {
				++ x;
			}
			if (!world.isAirBlock(x, y, z))
				return false;
		}
		
		if (this.isBroken(stack) && !(world.isRemote)) {
			player.addChatMessage(new ChatComponentTranslation("msg." + Reference.RESOURCE_PREFIX + "broken_tool"));
		}
		
		else if (player.canPlayerEdit(x, y, z, side, stack) & !(this.isBroken(stack))) {
			if (player.inventory.hasItem(torch)) {
				
				if (player.inventory.consumeInventoryItem(torch) && !(player.capabilities.isCreativeMode)) {
					
					if (!(world.isRemote) && Blocks.torch.canPlaceBlockAt(world, x, y, z)) {
						world.setBlock(x, y, z, Blocks.torch);
					}
					
				}
				
				else if (player.capabilities.isCreativeMode) {
					
					if (!(world.isRemote) && Blocks.torch.canPlaceBlockAt(world, x, y, z)) {
						world.setBlock(x, y, z, Blocks.torch);
					}
				}
			}
			
			return true;
		}
		
		return false;
	}
	
	@SuppressWarnings({"unchecked", "rawtypes"})
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		if (this.isBroken(stack)) {
			list.add(StatCollector.translateToLocal("msg." + Reference.RESOURCE_PREFIX + "broken_tool"));
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
