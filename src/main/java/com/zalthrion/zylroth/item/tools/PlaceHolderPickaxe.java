package com.zalthrion.zylroth.item.tools;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import com.zalthrion.zylroth.lib.ModItems;
import com.zalthrion.zylroth.lib.ModTools;
import com.zalthrion.zylroth.reference.Reference;

public class PlaceHolderPickaxe extends ItemBasePickaxe {
	
	private String name = "placeholderPickaxe";
	
	int creative = 12249;
	
	public PlaceHolderPickaxe(ToolMaterial material) {
		super(material);
		this.setNames(name);
	}
	
	public boolean isBroken(ItemStack stack) {
		return stack.getMetadata() >= creative;
	}
	
	@Override
	public boolean onBlockStartBreak(ItemStack stack, int x, int y, int z, EntityPlayer player) {
		
		World world = player.worldObj;
		
		if (this.isBroken(stack) && !(world.isRemote)) {
			player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "broken_tool")));
			
			return true;
			
		} else return false;
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase entity) {
		
		EntityPlayer player = (EntityPlayer) entity;
		
		if (player.capabilities.isCreativeMode) { return false; }
		
		if (this.isBroken(stack) && !(world.isRemote)) {
			player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "broken_tool")));
			
		} else if (stack.getMetadata() <= 12233 && !(world.isRemote) && (!player.isSneaking())) {
			
			Material material = world.getBlock(x, y, z).getMaterial();

			boolean isStone = world.getBlock(x, y, z) == Blocks.stone;
			boolean isCobblestone = world.getBlock(x, y, z) == Blocks.cobblestone;
			boolean isStoneBrick = world.getBlock(x, y, z) == Blocks.stonebrick;
			boolean isSandstone = world.getBlock(x, y, z) == Blocks.sandstone;
			boolean isNetherrack = world.getBlock(x, y, z) == Blocks.netherrack;
			
			if (isCobblestone || isStone || isStoneBrick || isSandstone || isNetherrack) {
				for (int ix = -1; ix < 2; ++ ix) {
					for (int iy = -1; iy < 2; ++ iy) {
						for (int iz = -1; iz < 2; ++ iz) {
							
							Material neighbourMaterial = world.getBlock(x + ix, y, z + iz).getMaterial();
							
							boolean isAStone = world.getBlock(x + ix, y + iy, z + iz) == Blocks.stone;
							boolean isACobblestone = world.getBlock(x + ix, y + iy, z + iz) == Blocks.cobblestone;
							boolean isAStoneBrick = world.getBlock(x + ix, y + iy, z + iz) == Blocks.stonebrick;
							boolean isASandstone = world.getBlock(x + ix, y + iy, z + iz) == Blocks.sandstone;
							boolean isANetherrack = world.getBlock(x + ix, y + iy, z + iz) == Blocks.netherrack;
							
							boolean neighbourValid_Shovel = (neighbourMaterial == Material.craftedSnow || material == Material.grass || material == Material.ground ||material == Material.sand || material == Material.snow);
							
							if (isACobblestone || isAStone || isAStoneBrick || isASandstone || isANetherrack) {
								world.breakBlock(x + ix, y + iy, z + iz, true);
								stack.damageItem(1, player);
							}
							
							else if (isACobblestone || isAStone || isAStoneBrick || isASandstone || isANetherrack || neighbourValid_Shovel) {
								
								ItemStack shovel = new ItemStack(ModTools.creativeShovel);
								
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
			if (!world.isAirBlock(x, y, z)) return false;
		}
		
		if (this.isBroken(stack) && !(world.isRemote)) {
			player.addChatMessage(new
			
			ChatComponentText(StatCollector.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "broken_tool")));
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
		
		return stack.getItem() == ModItems.tenebrae_Ingot;
	}
}
