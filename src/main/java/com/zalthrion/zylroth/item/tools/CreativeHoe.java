package com.zalthrion.zylroth.item.tools;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.StatCollector;
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
				player.addChatMessage(new ChatComponentTranslation("msg." + Reference.RESOURCE_PREFIX + "broken_tool"));
			}
			return true;
		}
		
		return false;
	}
	
	@Override public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!player.canPlayerEdit(pos, side, stack)) return false;
		
		UseHoeEvent event = new UseHoeEvent(player, stack, world, pos);
		if (MinecraftForge.EVENT_BUS.post(event)) { return false; }
		
		if (event.getResult() == Result.ALLOW) {
			stack.damageItem(1, player);
			return true;
		}
		
		Block block = world.getBlockState(pos).getBlock();
		
		if (side != EnumFacing.DOWN && world.isAirBlock(pos.up()) && (block == Blocks.grass || block == Blocks.dirt) && !(this.isBroken(stack))) {
			Block block1 = Blocks.farmland;
			world.playSoundEffect(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, block1.stepSound.getStepSound(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getFrequency() * 0.8F);
			
			if (world.isRemote) return true;
			for (int ix = -1; ix < 2; ++ ix) {
				for (int iz = -1; iz < 2; ++ iz) {
					
					boolean isAGrass = world.getBlockState(pos.add(ix, 0, iz)) == Blocks.grass;
					boolean isADirt = world.getBlockState(pos.add(ix, 0, iz)) == Blocks.dirt;
					
					if (isADirt || isAGrass && !(player.isSneaking())) {
						world.setBlockState(pos.add(ix, 0, iz), block1.getDefaultState());
						stack.damageItem(1, player);
					}
				}
			}
			
			boolean isGrass = world.getBlockState(pos).getBlock() == Blocks.grass;
			boolean isDirt = world.getBlockState(pos).getBlock() == Blocks.dirt;
			
			if (isDirt || isGrass && player.isSneaking()) {
				world.setBlockState(pos, block1.getDefaultState());
				stack.damageItem(1, player);
			}
			
			return true;
			
		} else {
			return false;
		}
	}
	
	@Override public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean advanced) {
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
			
		if (world.isRemote) player.addChatMessage(new ChatComponentTranslation("msg." + Reference.RESOURCE_PREFIX + "broken_tool"));
		
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