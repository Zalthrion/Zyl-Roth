package com.zalthrion.zylroth.base;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.utility.TooltipHelper;
import com.zalthrion.zylroth.utility.ZylrothTeleporter;

public class ItemTalismanBase extends ItemBase {
	private String dimension = "NULL";
	
	/* Constructors */
	
	public ItemTalismanBase() {
		super();
	}
	
	/* Custom Methods */
	
	public void bindDimension(ItemStack stack, EntityPlayer player) {
		NBTTagCompound tagCompound = stack.hasTagCompound() ? stack.getTagCompound() : new NBTTagCompound();
		tagCompound.setIntArray(this.dimension + "Bound", new int[] {MathHelper.floor_double(player.posX), MathHelper.floor_double(player.posY), MathHelper.floor_double(player.posZ)});
		stack.setTagCompound(tagCompound);
	}
	
	public void bindOverworld(ItemStack stack, EntityPlayer player) {
		NBTTagCompound tagCompound = stack.hasTagCompound() ? stack.getTagCompound() : new NBTTagCompound();
		tagCompound.setIntArray("OverworldBound", new int[] {MathHelper.floor_double(player.posX), MathHelper.floor_double(player.posY), MathHelper.floor_double(player.posZ)});
		stack.setTagCompound(tagCompound);
	}
	
	public int[] getDimensionBind(ItemStack stack) {
		if (!isDimensionBound(stack)) return new int[] {};
		NBTTagCompound tagCompound = stack.hasTagCompound() ? stack.getTagCompound() : new NBTTagCompound();
		return tagCompound.getIntArray(this.dimension + "Bound");
	}
	
	public int[] getOverworldBind(ItemStack stack) {
		if (!isOverworldBound(stack)) return new int[] {};
		NBTTagCompound tagCompound = stack.hasTagCompound() ? stack.getTagCompound() : new NBTTagCompound();
		return tagCompound.getIntArray("OverworldBound");
	}
	
	public void handleDimensionTeleport(boolean condition, int dimensionID, ItemStack stack, World world, EntityPlayer player) {
		if (player.isSneaking() && !player.isInWater() && !player.isOnLadder()) {
			if (player.dimension == 0) {
				if (!world.isRemote) ((ItemTalismanBase) stack.getItem()).bindOverworld(stack, player);
				if (world.isRemote) player.addChatMessage(new TextComponentString(I18n.format("msg.zylroth:spawnpoint.set")));
			} else if (player.dimension == dimensionID) {
				if (!world.isRemote) ((ItemTalismanBase) stack.getItem()).bindDimension(stack, player);
				if (world.isRemote) player.addChatMessage(new TextComponentString(I18n.format("msg.zylroth:spawnpoint.set")));
			}
		} else {
			if (condition) {
				if (player.dimension == 1) {
					if (world.isRemote) player.addChatMessage(new TextComponentString(I18n.format("msg.zylroth:invaliddimension")));
					return;
				} else {
					if (player.dimension == 0) {
						if (!isOverworldBound(stack)) {
							if (world.isRemote) player.addChatMessage(new TextComponentString(I18n.format("msg.zylroth:spawnpoint.warn")));
							return;
						}
					} else if (player.dimension == dimensionID) {
						if (!isDimensionBound(stack)) {
							if (world.isRemote) player.addChatMessage(new TextComponentString(I18n.format("msg.zylroth:spawnpoint.warn")));
							return;
						}
					}
					if (!world.isRemote) {
						if (player instanceof EntityPlayerMP) {
							EntityPlayerMP playerMP = (EntityPlayerMP) player;
							WorldServer ws = playerMP.mcServer.worldServerForDimension(dimensionID);
							
							if (!(player.dimension == dimensionID) && player.getRidingEntity() == null) {
								int[] bindPos = isDimensionBound(stack) ? getDimensionBind(stack) : new int[] {0, -1, 0};
								ZylrothTeleporter teleporter = new ZylrothTeleporter(ws, bindPos[0], bindPos[1], bindPos[2]);
								FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().transferPlayerToDimension(playerMP, dimensionID, teleporter);
								teleporter.adjustPos(player);
							} else if (player.dimension == dimensionID && player.getRidingEntity() == null) {
								int[] bindPos = isOverworldBound(stack) ? getOverworldBind(stack) : new int[] {0, -1, 0};
								ZylrothTeleporter teleporter = new ZylrothTeleporter(ws, bindPos[0], bindPos[1], bindPos[2]);
								FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().transferPlayerToDimension(playerMP, 0, teleporter);
								teleporter.adjustPos(player);
							}
						}
					}
				}
			}
		}
	}
	
	public boolean isDimensionBound(ItemStack stack) {
		if (!stack.hasTagCompound()) return false;
		NBTTagCompound tagCompound = stack.getTagCompound();
		if (!tagCompound.hasKey(this.dimension + "Bound")) return false;
		return true;
	}
	
	public boolean isOverworldBound(ItemStack stack) {
		if (!stack.hasTagCompound()) return false;
		NBTTagCompound tagCompound = stack.getTagCompound();
		if (!tagCompound.hasKey("OverworldBound")) return false;
		return true;
	}
	
	public void setDimensionName(String name) {
		this.dimension = name;
	}
	
	/* Overridden */
	
	@Override @SideOnly(Side.CLIENT) public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		if (!isOverworldBound(stack)) {
			tooltip.addAll(TooltipHelper.addAll("spawnpoint.set"));
		} else {
			int[] overworldBindPoint = getOverworldBind(stack);
			tooltip.add(I18n.format("tooltip.zylroth:spawnpoint.overworld", overworldBindPoint[0] + ", " + overworldBindPoint[1] + ", " + overworldBindPoint[2]));
			if (!isDimensionBound(stack)) {
				tooltip.add(I18n.format("tooltip.zylroth:spawnpoint.dimension", I18n.format("general.zylroth:dimension." + this.dimension.toLowerCase()), I18n.format("general.zylroth:unavailable")));
			} else {
				int[] dimensionBind = getDimensionBind(stack);
				tooltip.add(I18n.format("tooltip.zylroth:spawnpoint.dimension", I18n.format("general.zylroth:dimension." + this.dimension.toLowerCase()), dimensionBind[0] + ", " + dimensionBind[1] + ", " + dimensionBind[2]));
			}
		}
	}
}