package com.zalthrion.zylroth.item.tools;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;

import org.lwjgl.input.Keyboard;

import com.zalthrion.zylroth.lib.ModItems;
import com.zalthrion.zylroth.lib.ModTabs;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.utility.TooltipHelper;

public class CreativeHoe extends ItemHoe implements ZylrothTool {
	private String name = "creativeHoe";
	
	public CreativeHoe(ToolMaterial material) {
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
	
	@Override public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!playerIn.canPlayerEdit(pos, facing, stack)) return EnumActionResult.FAIL;
		
		UseHoeEvent event = new UseHoeEvent(playerIn, stack, worldIn, pos);
		if (MinecraftForge.EVENT_BUS.post(event)) { return EnumActionResult.FAIL; }
		
		if (event.getResult() == Result.ALLOW) {
			stack.damageItem(1, playerIn);
			return EnumActionResult.SUCCESS;
		}
		
		Block block = worldIn.getBlockState(pos).getBlock();
		
		if (facing != EnumFacing.DOWN && worldIn.isAirBlock(pos.up()) && (block == Blocks.grass || block == Blocks.dirt) && !(this.isBroken(stack))) {
			Block block1 = Blocks.farmland;
			worldIn.playSound(playerIn, pos, SoundEvents.item_hoe_till, SoundCategory.BLOCKS, 1.0F, 1.0F);
			
			if (worldIn.isRemote) return EnumActionResult.SUCCESS;
			for (int ix = -1; ix < 2; ++ ix) {
				for (int iz = -1; iz < 2; ++ iz) {
					
					boolean isAGrass = worldIn.getBlockState(pos.add(ix, 0, iz)) == Blocks.grass;
					boolean isADirt = worldIn.getBlockState(pos.add(ix, 0, iz)) == Blocks.dirt;
					
					if (isADirt || isAGrass && !(playerIn.isSneaking())) {
						worldIn.setBlockState(pos.add(ix, 0, iz), block1.getDefaultState());
						stack.damageItem(1, playerIn);
					}
				}
			}
			
			boolean isGrass = worldIn.getBlockState(pos).getBlock() == Blocks.grass;
			boolean isDirt = worldIn.getBlockState(pos).getBlock() == Blocks.dirt;
			
			if (isDirt || isGrass && playerIn.isSneaking()) {
				worldIn.setBlockState(pos, block1.getDefaultState());
				stack.damageItem(1, playerIn);
			}
			
			return EnumActionResult.SUCCESS;
			
		} else {
			return EnumActionResult.FAIL;
		}
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