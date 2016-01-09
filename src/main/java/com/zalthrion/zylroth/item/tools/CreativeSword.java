package com.zalthrion.zylroth.item.tools;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import com.zalthrion.zylroth.lib.ModItems;
import com.zalthrion.zylroth.lib.ModTabs;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.utility.TooltipHelper;

public class CreativeSword extends ItemSword implements ZylrothTool {
		private String name = "creativeSword";
	
	public CreativeSword(ToolMaterial material) {
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
				player.addChatMessage(new ChatComponentTranslation("msg." + Reference.RESOURCE_PREFIX + "broken_sword"));
			}
			return true;
		}
		return false;
	}
	
	@Override public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		Random rand = new Random();
		
		if (!(player.isSneaking()) && !(player.capabilities.isCreativeMode)) {
			
			for (int countparticles = 0; countparticles <= 100; ++ countparticles) {
				world.spawnParticle(EnumParticleTypes.PORTAL, (double) player.posX - 0.0F, (double) player.posY - 0.5F, (double) player.posZ - 0.0F, (double) ((float) rand.nextFloat() - 0.1F), (double) ((float) rand.nextFloat() - 0.1F), (double) ((float) rand.nextFloat()) - 0.1F);
				world.spawnParticle(EnumParticleTypes.PORTAL, (double) player.posX - 0.0F, (double) player.posY - 0.5F, (double) player.posZ - 0.0F, (double) ((float) rand.nextFloat() - 1.1F), (double) ((float) rand.nextFloat() - 0.1F), (double) ((float) rand.nextFloat()) - 0.1F);
				world.spawnParticle(EnumParticleTypes.PORTAL, (double) player.posX - 0.0F, (double) player.posY - 0.5F, (double) player.posZ - 0.0F, (double) ((float) rand.nextFloat() - 0.5F), (double) ((float) rand.nextFloat() - 0.1F), (double) ((float) rand.nextFloat()) - 1.1F);
			}
		}
		
		if (player.isSneaking()) {
			
			if (player.capabilities.isCreativeMode) { return stack; }
			
			if (this.isBroken(stack) && !(world.isRemote)) {
				player.addChatMessage(new ChatComponentTranslation("msg." + Reference.RESOURCE_PREFIX + "broken_sword"));
				return stack;
				
			} else if (stack.getMetadata() < 2200) {
				
				stack.damageItem(50, player);
				world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
				
				if (!world.isRemote) {
					world.spawnEntityInWorld(new EntityEnderPearl(world, player));
				}
				
				world.spawnParticle(EnumParticleTypes.PORTAL, player.posX + (rand.nextDouble() - 0.5D) * (double) player.width, player.posY + rand.nextDouble() * (double) player.height - (double) player.getYOffset(), player.posZ + (rand.nextDouble() - 0.5D) * (double) player.width, 0.0D, 0.0D, 0.0D);
			}
			
		}
		
		return super.onItemRightClick(stack, world, player);
	}
	
	@Override public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
		Item torch = Item.getItemFromBlock(Blocks.torch);
		
		if (world.getBlockState(pos).getBlock() != Blocks.snow_layer) {
			if (side == EnumFacing.DOWN) pos = pos.down();
			if (side == EnumFacing.UP) pos = pos.up();
			if (side == EnumFacing.SOUTH) pos = pos.south();
			if (side == EnumFacing.NORTH) pos = pos.north();
			if (side == EnumFacing.WEST) pos = pos.west();
			if (side == EnumFacing.EAST) pos = pos.east();
			if (!world.isAirBlock(pos)) return false;
		}
		
		if (this.isBroken(stack) && !(world.isRemote)) {
			player.addChatMessage(new ChatComponentTranslation(StatCollector.translateToLocal("msg." + Reference.RESOURCE_PREFIX + "broken_sword")));
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
			list.add(StatCollector.translateToLocal("msg." + Reference.RESOURCE_PREFIX + "broken_sword"));
		} else {
			list.addAll(TooltipHelper.addAll("tenebrae_sword_lore"));
			list.addAll(TooltipHelper.addAll("tenebrae_generic"));
			if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
				list.addAll(TooltipHelper.addAll("tenebrae_sword_info"));
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
			
		if (world.isRemote) player.addChatMessage(new ChatComponentTranslation("tooltip." + Reference.RESOURCE_PREFIX + "broken_sword"));
		
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