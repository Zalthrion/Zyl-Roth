package com.zalthrion.zylroth.item.tools;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
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
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import com.zalthrion.zylroth.lib.ModInit.ItemInit;
import com.zalthrion.zylroth.lib.ModInit.ZylrothTab;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.utility.TooltipHelper;

//TODO If Zalthrion changes this file on 1.7.10 DO NOT CHANGE IT HERE. MITCH DON'T FORGET TO READ THIS MULTIPLE TIMES
public class PlaceHolderPickaxe extends ItemPickaxe implements ZylrothTool {
	
	private String name = "placeholderPickaxe";
	
	int creative = 12249;
	
	public PlaceHolderPickaxe(ToolMaterial material) {
		super(material);
		this.setCreativeTab(ZylrothTab.zylRoth);
		this.setUnlocalizedName(name);
	}
	
	@Override public boolean isBroken(ItemStack stack) {
		return stack.getMetadata() >= creative;
	}
	
	@Override
	public boolean onBlockStartBreak(ItemStack stack, BlockPos pos, EntityPlayer player) {
		
		World world = player.worldObj;
		
		if (this.isBroken(stack) && !(world.isRemote)) {
			player.addChatMessage(new TextComponentTranslation("msg." + Reference.RESOURCE_PREFIX + "broken_tool"));
			
			return true;
			
		} else return false;
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState blockIn, BlockPos pos, EntityLivingBase entityLiving) {
		EntityPlayer player = (EntityPlayer) entityLiving;
		
		if (player.capabilities.isCreativeMode) { return false; }
		
		if (this.isBroken(stack) && !(worldIn.isRemote)) {
			player.addChatMessage(new TextComponentTranslation("msg." + Reference.RESOURCE_PREFIX + "broken_tool"));
			
		} else if (stack.getMetadata() <= 12233 && !(worldIn.isRemote) && (!player.isSneaking())) {
			
			Material material = worldIn.getBlockState(pos).getMaterial();
			
			boolean isStone = blockIn == Blocks.STONE;
			boolean isCobblestone = blockIn == Blocks.COBBLESTONE;
			boolean isStoneBrick = blockIn == Blocks.STONEBRICK;
			boolean isSandstone = blockIn == Blocks.SANDSTONE;
			boolean isNetherrack = blockIn == Blocks.NETHERRACK;
			
			if (isCobblestone || isStone || isStoneBrick || isSandstone || isNetherrack) {
				for (int ix = -1; ix < 2; ++ ix) {
					for (int iy = -1; iy < 2; ++ iy) {
						for (int iz = -1; iz < 2; ++ iz) {
							
							Material neighbourMaterial = worldIn.getBlockState(pos.add(ix, 0, iz)).getMaterial();
							Block neighbourBlock = worldIn.getBlockState(pos.add(ix, iy, iz)).getBlock();
							boolean isAStone = neighbourBlock == Blocks.STONE;
							boolean isACobblestone = neighbourBlock == Blocks.COBBLESTONE;
							boolean isAStoneBrick = neighbourBlock == Blocks.STONEBRICK;
							boolean isASandstone = neighbourBlock == Blocks.SANDSTONE;
							boolean isANetherrack = neighbourBlock == Blocks.NETHERRACK;
							
							boolean neighbourValid_Shovel = (neighbourMaterial == Material.CRAFTED_SNOW || neighbourMaterial == Material.GRASS || neighbourMaterial == Material.GROUND || neighbourMaterial == Material.SAND || neighbourMaterial == Material.SNOW);
							
							if (isACobblestone || isAStone || isAStoneBrick || isASandstone || isANetherrack) {
								worldIn.destroyBlock(pos.add(ix, iy, iz), true);
								stack.damageItem(1, player);
							}
							
							else if (isACobblestone || isAStone || isAStoneBrick || isASandstone || isANetherrack || neighbourValid_Shovel) {
								
								ItemStack shovel = new ItemStack(ItemInit.creativeShovel);
								
								worldIn.destroyBlock(pos.add(ix, iy, iz), true);
								stack.damageItem(1, player);
								shovel.damageItem(1, player);
							}
						}
					}
				}
			}
		}
		
		return super.onBlockDestroyed(stack, worldIn, blockIn, pos, entityLiving); //TODO Same shovel check as creative pickaxe
	}
	
	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (worldIn.getBlockState(pos).getBlock() != Blocks.SNOW_LAYER) {
			if (facing == EnumFacing.DOWN) pos = pos.down();
			if (facing == EnumFacing.UP) pos = pos.up();
			if (facing == EnumFacing.SOUTH) pos = pos.south();
			if (facing == EnumFacing.NORTH) pos = pos.north();
			if (facing == EnumFacing.WEST) pos = pos.west();
			if (facing == EnumFacing.EAST) pos = pos.east();
			if (!worldIn.isAirBlock(pos)) return EnumActionResult.FAIL;
		}
		
		if (this.isBroken(stack) && !(worldIn.isRemote)) {
			playerIn.addChatMessage(new TextComponentTranslation("msg." + Reference.RESOURCE_PREFIX + "broken_tool"));
		} else if (!(this.isBroken(stack))) {
			TorchPlacer.tryPlaceTorch(stack, playerIn, worldIn, pos, hand, facing);
			return EnumActionResult.PASS;
		}
		return EnumActionResult.FAIL;
	}
	
	@Override public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean par4) {
		if (this.isBroken(stack)) {
			list.add(I18n.format("msg." + Reference.RESOURCE_PREFIX + "broken_tool"));
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
	
	@Override public boolean getIsRepairable(ItemStack armor, ItemStack stack) {
		return stack.getItem() == ItemInit.tenebraeIngot;
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