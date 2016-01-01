package com.zalthrion.zylroth.item.tools;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import com.zalthrion.zylroth.lib.ModItems;
import com.zalthrion.zylroth.lib.ModTabs;
import com.zalthrion.zylroth.lib.ModTools;
import com.zalthrion.zylroth.reference.Reference;

public class CreativePickaxe extends ItemPickaxe implements ZylrothTool {
	private String name = "creativePickaxe";
	
	public CreativePickaxe(ToolMaterial material) {
		super(material);
		this.setCreativeTab(ModTabs.zylRoth);
		this.setUnlocalizedName(name);
	}
	
	@Override public boolean isBroken(ItemStack stack) {
		return stack.getMetadata() >= creativeDurability;
	}
	
	@Override public boolean onBlockStartBreak(ItemStack stack, BlockPos pos, EntityPlayer player) {
		if (this.isBroken(stack)) {
			if (player.worldObj.isRemote) {
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("msg." + Reference.MOD_ID.toLowerCase() + ":broken_tool")));
			}
			return true;
		}
		
		return false;
	}
	
	@Override public boolean onBlockDestroyed(ItemStack stack, World world, Block block, BlockPos pos, EntityLivingBase entity) {
		EntityPlayer player = (EntityPlayer) entity;
		
		if (player.capabilities.isCreativeMode) return false; 
		
		if (this.isBroken(stack) && !(world.isRemote)) {
			player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("msg." + Reference.MOD_ID.toLowerCase() + ":broken_tool")));
		} else if (stack.getMetadata() <= 12233 && !(world.isRemote) && (!player.isSneaking())) {
			Material material = world.getBlockState(pos).getBlock().getMaterial();
			boolean valid = (material == Material.rock || material == Material.ice || material == Material.packedIce || material == Material.clay);
			
			if (valid) {
				boolean hasShovel = false;
				ItemStack theShovel = null;
				for (int slot = 0; slot < player.inventory.getSizeInventory(); slot ++) {
					ItemStack aStack = player.inventory.getStackInSlot(slot);
					if (aStack != null) {
						if (aStack.getItem() == ModTools.creativeShovel) {
							ZylrothTool shovel = (ZylrothTool) aStack.getItem();
							if (!shovel.isBroken(aStack)) {
								hasShovel = true;
								theShovel = aStack;
							}
						}
					}
				}
				
				
				for (int ix = -1; ix < 2; ++ ix) {
					for (int iy = -1; iy < 2; ++ iy) {
						for (int iz = -1; iz < 2; ++ iz) {
							
							Material neighbourMaterial = world.getBlockState(pos.add(ix, iy, iz)).getBlock().getMaterial();
							boolean neighbourValid = (neighbourMaterial == Material.rock || neighbourMaterial == Material.ice || neighbourMaterial == Material.packedIce || neighbourMaterial == Material.clay);
							boolean neighbourValidShovel = (neighbourMaterial == Material.craftedSnow || neighbourMaterial == Material.grass || neighbourMaterial == Material.ground || neighbourMaterial == Material.sand || neighbourMaterial == Material.snow);
							
							if (neighbourValid) {
								world.destroyBlock(pos.add(ix, iy, iz), true);
								stack.damageItem(1, player);
							} else if (hasShovel && neighbourValidShovel && theShovel != null) {
								world.destroyBlock(pos.add(ix, iy, iz), true);
								theShovel.damageItem(1, player);
							}
						}
					}
				}
			}
		}
		
		return super.onBlockDestroyed(stack, world, block, pos, entity);
	}
	
	@Override public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
		Item torch = Item.getItemFromBlock(Blocks.torch);
		
		if (world.getBlockState(pos).getBlock() != Blocks.snow_layer) {
			if (side == EnumFacing.DOWN) pos = pos.down();
			if (side == EnumFacing.UP) pos = pos.up();
			if (side == EnumFacing.NORTH) pos = pos.north();
			if (side == EnumFacing.SOUTH) pos = pos.south();
			if (side == EnumFacing.WEST) pos = pos.west();
			if (side == EnumFacing.EAST) pos = pos.east();
			if (!world.isAirBlock(pos)) return false;
		}
		
		if (this.isBroken(stack) && !(world.isRemote)) {
			player.addChatMessage(new ChatComponentText("You must repair this tool to continue using it!")); // Localize
		} else if (player.canPlayerEdit(pos, side, stack) & !(this.isBroken(stack))) {
			if (player.inventory.hasItem(torch)) {
				if (player.inventory.consumeInventoryItem(torch) && !(player.capabilities.isCreativeMode)) {
					if (!(world.isRemote) && Blocks.torch.canPlaceBlockAt(world, pos)) {
						world.setBlockState(pos, Blocks.torch.getDefaultState());
					}
				} else if (player.capabilities.isCreativeMode) {
					if (!(world.isRemote) && Blocks.torch.canPlaceBlockAt(world, pos)) {
						world.setBlockState(pos, Blocks.torch.getDefaultState());
					}
				}
			}
			return true;
		}
		return false;
	}
	
	@Override public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean advanced) {
		
		if (this.isBroken(stack)) {
			list.add(StatCollector.translateToLocal("msg." + Reference.MOD_ID.toLowerCase() + ":broken_tool"));
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
	
	@Override public boolean getIsRepairable(ItemStack armor, ItemStack stack) {
		return stack.getItem() == ModItems.tenebraeIngot;
	}
	
	@Override public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		if (!(this.isBroken(stack))) stack.damageItem(1, attacker);
		return true;
	}
	
	@Override public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		if (!isBroken(stack)) return false;
		World world = player.worldObj;
			
		if (world.isRemote) player.addChatMessage(new ChatComponentText("msg." + Reference.MOD_ID.toLowerCase() + ":broken_tool"));
		
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