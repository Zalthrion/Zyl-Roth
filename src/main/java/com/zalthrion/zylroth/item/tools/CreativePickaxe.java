package com.zalthrion.zylroth.item.tools;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
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
import com.zalthrion.zylroth.lib.ModTools;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.utility.TooltipHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativePickaxe extends ItemPickaxe implements ZylrothTool {
	
	private String name = "creativePickaxe";
	
	public CreativePickaxe(ToolMaterial material) {
		super(material);
		this.setNames(name);
	}
	
	@Override public boolean isBroken(ItemStack stack) {
		return stack.getMetadata() >= creativeDurability;
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
	public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase entity) {
		
		EntityPlayer player = (EntityPlayer) entity;
		
		if (player.capabilities.isCreativeMode) { return false; }
		
		if (this.isBroken(stack) && !(world.isRemote)) {
			player.addChatMessage(new ChatComponentTranslation("msg." + Reference.RESOURCE_PREFIX + "broken_tool"));
			
		}
		else if (stack.getMetadata() <= 12233 && !(world.isRemote) && (!player.isSneaking())) {
			
			Material material = world.getBlock(x, y, z).getMaterial();
			
			boolean valid = (material == Material.rock || material == Material.ice || material == Material.packedIce || material == Material.clay);
			
			if (valid) {
				for (int ix = -1; ix < 2; ++ ix) {
					for (int iy = -1; iy < 2; ++ iy) {
						for (int iz = -1; iz < 2; ++ iz) {
							
							Material neighbourMaterial = world.getBlock(x + ix, y + iy, z + iz).getMaterial();
							
							boolean neighbourValid = (neighbourMaterial == Material.rock || neighbourMaterial == Material.ice || neighbourMaterial == Material.packedIce || neighbourMaterial == Material.clay);
							
							boolean neighbourValid_Shovel = (neighbourMaterial == Material.craftedSnow || neighbourMaterial == Material.grass || neighbourMaterial == Material.ground || neighbourMaterial == Material.sand || neighbourMaterial == Material.snow);
							
							ItemStack shovel = new ItemStack(ModTools.creativeShovel, creativeDurability);
							
							if (neighbourValid) {
								world.breakBlock(x + ix, y + iy, z + iz, true);
								stack.damageItem(1, player);
							}
							
							else if (neighbourValid || neighbourValid_Shovel && player.inventory.hasItemStack(shovel)) {
								
								world.breakBlock(x + ix, y + iy, z + iz, true);
								stack.damageItem(1, player);
								shovel.damageItem(1, player);
							}
						}
					}
				}
			}
		}
		
		return super.onBlockDestroyed(stack, world, block, x, y, z, entity);
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
			list.addAll(TooltipHelper.addAll("creative_tool_lore"));
			list.addAll(TooltipHelper.addAll("creative_generic"));
			if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
				list.addAll(TooltipHelper.addAll("generic_tool_info"));
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
