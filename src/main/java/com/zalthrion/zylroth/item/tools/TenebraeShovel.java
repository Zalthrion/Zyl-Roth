package com.zalthrion.zylroth.item.tools;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.lib.ModItems;
import com.zalthrion.zylroth.reference.Reference;

public class TenebraeShovel extends ItemBaseShovel {
	
	private String name = "tenebraeShovel";
	
	int tenebrae = 2249;
	
	public TenebraeShovel(ToolMaterial material) {
		super(material);
		this.setNames(name);
	}
	
	public boolean isBroken(ItemStack stack) {
		return stack.getMetadata() >= tenebrae;
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase entity) {
		
		EntityPlayer player = (EntityPlayer) entity;
		
		if (player.capabilities.isCreativeMode) { return false; }
		
		if (this.isBroken(stack) && !(world.isRemote)) {
			player.addChatMessage(new ChatComponentText("You must repair this tool to continue using it!"));
			
		} else if (stack.getMetadata() <= 2233 && !(world.isRemote) && !(player.isSneaking())) {
			
			boolean isGrass = world.getBlock(x, y, z) == Blocks.grass;
			boolean isDirt = world.getBlock(x, y, z) == Blocks.dirt;
			boolean isGravel = world.getBlock(x, y, z) == Blocks.gravel;
			boolean isAsh = world.getBlock(x, y, z) == ModBlocks.ash_Block;
			boolean isSand = world.getBlock(x, y, z) == Blocks.sand;
			boolean isSnow = world.getBlock(x, y, z) == Blocks.snow;
			boolean isSnowLayer = world.getBlock(x, y, z) == Blocks.snow_layer;
			
			if (isGravel || isDirt || isAsh || isSand || isGrass || isSnow || isSnowLayer) {
				for (int ix = -1; ix < 2; ++ ix) {
					for (int iy = -1; iy < 2; ++ iy) {
						for (int iz = -1; iz < 2; ++ iz) {
							
							boolean isAGrass = world.getBlock(x + ix, y + iy, z + iz) == Blocks.grass;
							boolean isADirt = world.getBlock(x + ix, y + iy, z + iz) == Blocks.dirt;
							boolean isAGravel = world.getBlock(x + ix, y + iy, z + iz) == Blocks.gravel;
							boolean isAAsh = world.getBlock(x + ix, y + iy, z + iz) == ModBlocks.ash_Block;
							boolean isASand = world.getBlock(x + ix, y + iy, z + iz) == Blocks.sand;
							boolean isASnow = world.getBlock(x + ix, y + iy, z + iz) == Blocks.snow;
							boolean isASnowLayer = world.getBlock(x + ix, y + iy, z + iz) == Blocks.snow_layer;
							
							if (isAGravel || isADirt || isAAsh || isASand || isAGrass || isASnow || isASnowLayer) {
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
