package com.zalthrion.zylroth.item.tools;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import com.zalthrion.zylroth.lib.ModItems;
import com.zalthrion.zylroth.lib.ModTabs;
import com.zalthrion.zylroth.lib.ModTools;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.utility.TooltipHelper;

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
				player.addChatMessage(new TextComponentTranslation("msg." + Reference.RESOURCE_PREFIX + "broken_tool"));
			}
			return true;
		}
		
		return false;
	}
	
	@Override public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState blockIn, BlockPos pos, EntityLivingBase entityLiving) {
		EntityPlayer player = (EntityPlayer) entityLiving;
		
		if (player.capabilities.isCreativeMode) return false; 
		
		if (this.isBroken(stack) && !(worldIn.isRemote)) {
			player.addChatMessage(new TextComponentTranslation("msg." + Reference.RESOURCE_PREFIX + "broken_tool"));
		} else if (stack.getMetadata() <= 12233 && !(worldIn.isRemote) && (!player.isSneaking())) {
			Material material = worldIn.getBlockState(pos).getMaterial();
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
							
							Material neighbourMaterial = worldIn.getBlockState(pos.add(ix, iy, iz)).getMaterial();
							boolean neighbourValid = (neighbourMaterial == Material.rock || neighbourMaterial == Material.ice || neighbourMaterial == Material.packedIce || neighbourMaterial == Material.clay);
							boolean neighbourValidShovel = (neighbourMaterial == Material.craftedSnow || neighbourMaterial == Material.grass || neighbourMaterial == Material.ground || neighbourMaterial == Material.sand || neighbourMaterial == Material.snow);
							
							if (neighbourValid) {
								worldIn.destroyBlock(pos.add(ix, iy, iz), true);
								stack.damageItem(1, player);
							} else if (hasShovel && neighbourValidShovel && theShovel != null) {
								worldIn.destroyBlock(pos.add(ix, iy, iz), true);
								theShovel.damageItem(1, player);
							}
						}
					}
				}
			}
		}
		
		return super.onBlockDestroyed(stack, worldIn, blockIn, pos, entityLiving);
	}
	
	@Override public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (worldIn.getBlockState(pos).getBlock() != Blocks.snow_layer) {
			if (facing == EnumFacing.DOWN) pos = pos.down();
			if (facing == EnumFacing.UP) pos = pos.up();
			if (facing == EnumFacing.NORTH) pos = pos.north();
			if (facing == EnumFacing.SOUTH) pos = pos.south();
			if (facing == EnumFacing.WEST) pos = pos.west();
			if (facing == EnumFacing.EAST) pos = pos.east();
			if (!worldIn.isAirBlock(pos)) return EnumActionResult.FAIL;
		}
		
		if (this.isBroken(stack) && !(worldIn.isRemote)) {
			playerIn.addChatMessage(new TextComponentTranslation("msg." + Reference.RESOURCE_PREFIX + "broken_tool"));
		} else if (!(this.isBroken(stack))) {
			TorchPlacer.tryPlaceTorch(stack, playerIn, worldIn, pos, hand, facing);
			return EnumActionResult.SUCCESS;
		}
		return EnumActionResult.FAIL;
	}
	
	@Override public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean advanced) {
		if (this.isBroken(stack)) {
			list.add(I18n.translateToLocal("msg." + Reference.RESOURCE_PREFIX + "broken_tool"));
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
			
		if (world.isRemote) player.addChatMessage(new TextComponentTranslation("msg." + Reference.RESOURCE_PREFIX + "broken_tool"));
		
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