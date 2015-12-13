package com.zalthrion.zylroth.item.tools;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;

import org.lwjgl.input.Keyboard;

import com.zalthrion.zylroth.lib.ModItems;
import com.zalthrion.zylroth.reference.Reference;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeHoe extends ItemHoe implements ZylrothTool {
	
	private String name = "creativeHoe";
	
	public CreativeHoe(ToolMaterial material) {
		super(material);
		this.setNames(name);
	}
	
	public boolean isBroken(ItemStack stack) {
		return stack.getMetadata() >= creativeDurability;
	}
	
	@Override
	public boolean onBlockStartBreak(ItemStack stack, int x, int y, int z, EntityPlayer player) {
		if (this.isBroken(stack)) {
			if (player.worldObj.isRemote) {
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "broken_tool")));	
			}		
			
			return true;
		}
		
		else return false;
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		if (!(this.isBroken(stack)))
			stack.damageItem(1, attacker);
		return true;
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		if (!isBroken(stack))
			return false;
		World world = player.worldObj;
		
		if (world.isRemote)
			player.addChatMessage(new ChatComponentText("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "broken_tool"));
		
		return true;
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
		
		if (!player.canPlayerEdit(x, y, z, p_77648_7_, stack)) {
			return false;
		}
		else {
			
			UseHoeEvent event = new UseHoeEvent(player, stack, world, x, y, z);
			if (MinecraftForge.EVENT_BUS.post(event)) { return false; }
			
			if (event.getResult() == Result.ALLOW) {
				stack.damageItem(1, player);
				return true;
			}
			
			Block block = world.getBlock(x, y, z);
			
			if (p_77648_7_ != 0 && world.getBlock(x, y + 1, z).isAir(world, x, y + 1, z) && (block == Blocks.grass || block == Blocks.dirt) && !(this.isBroken(stack))) {
				Block block1 = Blocks.farmland;
				world.playSoundEffect((double) ((float) x + 0.5F), (double) ((float) y + 0.5F), (double) ((float) z + 0.5F), block1.stepSound.getStepSound(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getFrequency() * 0.8F);
				
				if (world.isRemote) {
					return true;
				}
				else {
					for (int ix = -1; ix < 2; ++ ix) {
						for (int iz = -1; iz < 2; ++ iz) {
							
							boolean isAGrass = world.getBlock(x + ix, y, z + iz) == Blocks.grass;
							boolean isADirt = world.getBlock(x + ix, y, z + iz) == Blocks.dirt;
							
							if (isADirt || isAGrass && !(player.isSneaking())) {
								world.setBlock(x + ix, y, z + iz, block1);
								stack.damageItem(1, player);
							}
						}
					}
					
					boolean isGrass = world.getBlock(x, y, z) == Blocks.grass;
					boolean isDirt = world.getBlock(x, y, z) == Blocks.dirt;
					
					if (isDirt || isGrass && player.isSneaking()) {
						world.setBlock(x, y, z, block1);
						stack.damageItem(1, player);
					}
					
					return true;
				}
			}
			else {
				return false;
			}
		}
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
		
		return stack.getItem() == ModItems.tenebraeIngot;
	}
	
	@Override
	public String getUnlocalizedName() {
		return String.format("item.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return String.format("item.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		String BaseName = getUnwrappedUnlocalizedName(getUnlocalizedName());
		itemIcon = iconRegister.registerIcon(BaseName);
	}
	
	protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
	
	protected void setNames(String name) {
		this.setUnlocalizedName(name);
		this.setTextureName(Reference.MOD_ID + ":" + name);
	}
}
