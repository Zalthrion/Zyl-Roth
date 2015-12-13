package com.zalthrion.zylroth.item.tools;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import com.zalthrion.zylroth.lib.ModItems;
import com.zalthrion.zylroth.lib.ModTabs;
import com.zalthrion.zylroth.reference.Reference;

public class CreativeShovel extends ItemSpade implements ZylrothTool {
	private String name = "creativeShovel";
	
	public CreativeShovel(ToolMaterial material) {
		super(material);
		this.setCreativeTab(ModTabs.zylRoth);
		this.setUnlocalizedName(name);
	}
	
	@Override public boolean isBroken(ItemStack stack) {
		return stack.getMetadata() >= creativeDurability;
	}
	
	@Override public boolean onBlockStartBreak(ItemStack stack, BlockPos pos, EntityPlayer player) {
		if (this.isBroken(stack)) {
			player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "broken_tool")));
			
			return true;
			
		} else return false;
	}
	
	@Override public boolean onBlockDestroyed(ItemStack stack, World world, Block block, BlockPos pos, EntityLivingBase entity) {
		EntityPlayer player = (EntityPlayer) entity;
		
		if (player.capabilities.isCreativeMode) return false; 
		
		if (this.isBroken(stack) && !(world.isRemote)) {
			player.addChatMessage(new ChatComponentText("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "broken_tool"));
		} else if (stack.getMetadata() <= 2233 && !(world.isRemote) && !(player.isSneaking())) {
			
			Material material = world.getBlockState(pos).getBlock().getMaterial();
			boolean valid = (material == Material.craftedSnow || material == Material.grass || material == Material.ground || material == Material.sand || material == Material.snow);
			
			if (valid) {
				for (int ix = -1; ix < 2; ++ ix) {
					for (int iy = -1; iy < 2; ++ iy) {
						for (int iz = -1; iz < 2; ++ iz) {
							
							Material neighbourMaterial = world.getBlockState(pos.add(ix, iy, iz)).getBlock().getMaterial();
							boolean neighbourValid = (neighbourMaterial == Material.craftedSnow || neighbourMaterial == Material.grass || neighbourMaterial == Material.ground || neighbourMaterial == Material.sand || neighbourMaterial == Material.snow);
							
							if (neighbourValid) {
								world.destroyBlock(pos.add(ix, iy, iz), true);
								stack.damageItem(1, player);
							}
						}
					}
				}
			}
		}
		
		return super.onBlockDestroyed(stack, world, block, pos, entity);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes"}) @Override public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		
		if (this.isBroken(stack)) {
			list.add(StatCollector.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "broken_tool"));
		}
		
		else if (!(this.isBroken(stack))) {
			list.add(StatCollector.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "tenebrae_tool_lore"));
			list.add(StatCollector.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "tenebrae_tool_lore2"));
			list.add(StatCollector.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "tenebrae_generic"));
			
			list.add(StatCollector.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "shift"));
			
			if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
				list.remove(StatCollector.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "shift"));
				
				list.add(StatCollector.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "tenebrae_tool_info"));
			}
		}
	}
	
	@Override public boolean getIsRepairable(ItemStack armor, ItemStack stack) {
		return stack.getItem() == ModItems.tenebrae_Ingot;
	}
	
	@Override public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		if (!(this.isBroken(stack))) stack.damageItem(1, attacker);
		return true;
	}
	
	@Override public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		if (!isBroken(stack)) return false;
		World world = player.worldObj;
			
		if (world.isRemote) player.addChatMessage(new ChatComponentText("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "broken_tool"));
		
		return true;
	}
	
	@Override public String getUnlocalizedName() {
		return String.format("item.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	@Override public String getUnlocalizedName(ItemStack itemStack) {
		return String.format("item.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
}