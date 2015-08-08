package com.zalthrion.zylroth.item.tools;

import java.util.List;

import org.lwjgl.input.Keyboard;

import com.zalthrion.zylroth.lib.ModItems;
import com.zalthrion.zylroth.reference.Reference;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class TenebraePickaxe extends ItemBasePickaxe {
	
	private String name = "tenebraePickaxe";
	
	public TenebraePickaxe(ToolMaterial material) {
		super(material);
		this.setNames(name);
	}
	
	public boolean isBroken(ItemStack stack) {
		return stack.getMetadata() >= Tenebrae;
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase entity) {
		
		EntityPlayer player = (EntityPlayer) entity;
		
		if (player.capabilities.isCreativeMode) { return false; }
		
		if (this.isBroken(stack) && !(world.isRemote)) {
			player.addChatMessage(new ChatComponentText("You must repair this tool to continue using it!"));
			
		} else if (stack.getMetadata() <= 2233 && !(world.isRemote) && (!player.isSneaking())) {
			
			boolean isStone = world.getBlock(x, y, z) == Blocks.stone;
			boolean isCobblestone = world.getBlock(x, y, z) == Blocks.cobblestone;
			boolean isStoneBrick = world.getBlock(x, y, z) == Blocks.stonebrick;
			boolean isSandstone = world.getBlock(x, y, z) == Blocks.sandstone;
			boolean isNetherrack = world.getBlock(x, y, z) == Blocks.netherrack;
			
			if (isCobblestone || isStone || isStoneBrick || isSandstone || isNetherrack) {
				for (int ix = -1; ix < 2; ++ ix) {
					for (int iy = -1; iy < 2; ++ iy) {
						for (int iz = -1; iz < 2; ++ iz) {
							
							boolean isAStone = world.getBlock(x + ix, y + iy, z + iz) == Blocks.stone;
							boolean isACobblestone = world.getBlock(x + ix, y + iy, z + iz) == Blocks.cobblestone;
							boolean isAStoneBrick = world.getBlock(x + ix, y + iy, z + iz) == Blocks.stonebrick;
							boolean isASandstone = world.getBlock(x + ix, y + iy, z + iz) == Blocks.sandstone;
							boolean isANetherrack = world.getBlock(x + ix, y + iy, z + iz) == Blocks.netherrack;
							
							if (isACobblestone || isAStone || isAStoneBrick || isASandstone || isANetherrack) {
								world.breakBlock(x + ix, y + iy, z + iz, true);
								stack.damageItem(1, player);
							}
						}
					}
				}
			}
		}
		
		return super.onBlockDestroyed(stack, world, block, x, y, z, entity);
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
	
	@Override
	public boolean onBlockStartBreak(ItemStack stack, int x, int y, int z, EntityPlayer player) {
		if (this.isBroken(stack)) {
			player.addChatMessage(new ChatComponentText("You must repair this tool to continue using it!"));
			
			return true;
			
		} else return false;
	}
}
