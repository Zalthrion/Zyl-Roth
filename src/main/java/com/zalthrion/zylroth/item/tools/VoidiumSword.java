package com.zalthrion.zylroth.item.tools;

import java.util.List;
import java.util.Random;

import org.lwjgl.input.Keyboard;

import com.zalthrion.zylroth.lib.ModItems;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.utility.TooltipHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class VoidiumSword extends ItemSword implements ZylrothTool {
	
	private String name = "voidiumSword";
		
	public VoidiumSword(ToolMaterial material) {
		super(material);
		this.setNames(name);
	}
	
	@Override
	public boolean isBroken(ItemStack stack) {
		return stack.getMetadata() >= voidiumDurability;
	}
	
	@Override
	public boolean onBlockStartBreak(ItemStack stack, int x, int y, int z, EntityPlayer player) {
		if (this.isBroken(stack)) {
			if (player.worldObj.isRemote) {
				player.addChatMessage(new ChatComponentTranslation("msg." + Reference.RESOURCE_PREFIX + "broken_sword"));
			}
			
			return true;
		}
		
		else return false;
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		if (!(this.isBroken(stack))) stack.damageItem(1, attacker);
		return true;
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		if (!isBroken(stack)) return false;
		World world = player.worldObj;
		
		if (world.isRemote) player.addChatMessage(new ChatComponentTranslation("msg." + Reference.RESOURCE_PREFIX + "broken_sword"));
		
		return true;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		
		Random rand = new Random();
		
		if (!(this.isBroken(stack)) && !(player.isSneaking()) && !(player.capabilities.isCreativeMode)) {
			
			/** Test-Item Start */
/*			Vec3 vec3 = player.getPosition(1.0F);
			vec3.yCoord ++;
			Vec3 lookVec = player.getLook(1.0F);
			Vec3 aVector = vec3.addVector(lookVec.xCoord * 50.0D, lookVec.yCoord * 50.0D, lookVec.zCoord * 50.0D);
			MovingObjectPosition movingObjPos = world.rayTraceBlocks(vec3, aVector, true);
			
			if (movingObjPos == null) {
				return stack;
			}
			
			else {				
				if (movingObjPos.entityHit instanceof EntityLivingBase) {
					return stack;
				} else {
					player.setPositionAndUpdate((double) movingObjPos.blockX, ((double) (float) movingObjPos.blockY + 1F), (double) movingObjPos.blockZ);
				}
				
				for (int countparticles = 0; countparticles <= 100; ++ countparticles) {
					world.spawnParticle("portal", (double) player.posX - 0.0F, (double) player.posY - 0.5F, (double) player.posZ - 0.0F, (double) ((float) rand.nextFloat() - 0.1F), (double) ((float) rand.nextFloat() - 0.1F), (double) ((float) rand.nextFloat()) - 0.1F);
					world.spawnParticle("portal", (double) player.posX - 0.0F, (double) player.posY - 0.5F, (double) player.posZ - 0.0F, (double) ((float) rand.nextFloat() - 1.1F), (double) ((float) rand.nextFloat() - 0.1F), (double) ((float) rand.nextFloat()) - 0.1F);
					world.spawnParticle("portal", (double) player.posX - 0.0F, (double) player.posY - 0.5F, (double) player.posZ - 0.0F, (double) ((float) rand.nextFloat() - 0.5F), (double) ((float) rand.nextFloat() - 0.1F), (double) ((float) rand.nextFloat()) - 1.1F);
				}
			}*/
			
			for (int countparticles = 0; countparticles <= 100; ++ countparticles) {
				world.spawnParticle("portal", player.posX - 0.0F, player.posY - 0.5F, player.posZ - 0.0F, rand.nextFloat() - 0.1F, rand.nextFloat() - 0.1F, (double) (rand.nextFloat()) - 0.1F);
				world.spawnParticle("portal", player.posX - 0.0F, player.posY - 0.5F, player.posZ - 0.0F, rand.nextFloat() - 1.1F, rand.nextFloat() - 0.1F, (double) (rand.nextFloat()) - 0.1F);
				world.spawnParticle("portal", player.posX - 0.0F, player.posY - 0.5F, player.posZ - 0.0F, rand.nextFloat() - 0.5F, rand.nextFloat() - 0.1F, (double) (rand.nextFloat()) - 1.1F);
			}
		}
		
		return super.onItemRightClick(stack, world, player);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		
		Item torch = Item.getItemFromBlock(Blocks.torch);
		
		if (world.getBlock(x, y, z) != Blocks.snow_layer) {
			if (side == 0) {
				-- y;
			}
			if (side == 1) {
				++ y;
			}
			if (side == 2) {
				-- z;
			}
			if (side == 3) {
				++ z;
			}
			if (side == 4) {
				-- x;
			}
			if (side == 5) {
				++ x;
			}
			if (!world.isAirBlock(x, y, z)) return false;
		}
		
		if (this.isBroken(stack) && !(world.isRemote)) {
			player.addChatMessage(new ChatComponentTranslation("msg." + Reference.RESOURCE_PREFIX + "broken_sword"));
		}
		
		else if (player.canPlayerEdit(x, y, z, side, stack) & !(this.isBroken(stack))) {
			if (player.inventory.hasItem(torch)) {
				
				if (player.inventory.consumeInventoryItem(torch) && !(player.capabilities.isCreativeMode)) {
					
					if (!(world.isRemote) && Blocks.torch.canPlaceBlockAt(world, x, y, z)) {
						world.setBlock(x, y, z, Blocks.torch);
					}
					
				}
				
				else if (player.capabilities.isCreativeMode) {
					
					if (!(world.isRemote) && Blocks.torch.canPlaceBlockAt(world, x, y, z)) {
						world.setBlock(x, y, z, Blocks.torch);
					}
				}
			}
			
			return true;
		}
		
		return false;
	}
	
	@SuppressWarnings({"unchecked", "rawtypes"})
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		if (this.isBroken(stack)) {
			list.add(StatCollector.translateToLocal("msg." + Reference.RESOURCE_PREFIX + "broken_sword"));
		} else {
			list.addAll(TooltipHelper.addAll("voidium_sword_lore"));
			list.addAll(TooltipHelper.addAll("voidium_generic"));
			if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
				list.addAll(TooltipHelper.addAll("voidium_sword_stats"));
			} else {
				list.addAll(TooltipHelper.addAll("shift"));
			}
		}
	}
	
	@Override
	public boolean getIsRepairable(ItemStack armor, ItemStack stack) {
		
		return stack.getItem() == ModItems.voidiumIngot;
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
