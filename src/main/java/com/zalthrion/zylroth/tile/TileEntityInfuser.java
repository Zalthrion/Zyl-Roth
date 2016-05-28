package com.zalthrion.zylroth.tile;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.block.tile.InfuserMachine;
import com.zalthrion.zylroth.block.tile.InfuserType;
import com.zalthrion.zylroth.handler.recipe.InfusionFuels;
import com.zalthrion.zylroth.handler.recipe.InfusionRecipeHandler;
import com.zalthrion.zylroth.handler.recipe.InfusionRecipeLib;

// TODO Check
public class TileEntityInfuser extends TileEntity implements IInventory, ITickable, ISidedInventory {
	/** The type of infuser */
	private InfuserType type;
	/** The slot used to input the base material. */
	private static final int[] slotsTop = new int[] {0};
	/** The slot used to input fuel */
	private static final int[] slotsBottom = new int[] {3};
	/** The slots used to input infusion materials */
	private static final int[] slotsSidesIn = new int[] {1, 2};
	/** The slots used to extract the output */
	private static final int[] slotsSidesOut = new int[] {4};
	/** The inventory */
	private ItemStack[] inventory = new ItemStack[5];
	/** The number of ticks the fuel used burns for */
	private int itemBurnTime;
	/** The number of ticks fuel in the furnace will burn for */
	private int burnTime;
	/** The number of ticks this infusion has been processing **/
	private int infusionTime;
	/** The number of ticks it takes this infusion to process **/
	private int totalInfusionTime;
	/** The direction this infuser is facing */
	private EnumFacing facing;
	/** The amount of experience stored in this infuser */
	private float experienceStored;
	/** A custom name given to the infuser */
	private String infuserCustomName;
	
	public TileEntityInfuser() {
		this.type = InfuserType.NORMAL;
	}
	
	public TileEntityInfuser(InfuserType type) {
		this.type = type;
	}
	
	/* TileEntity */
	
	@Override public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		NBTTagList nbttaglist = compound.getTagList("Items", 10);
		this.inventory = new ItemStack[this.getSizeInventory()];
		
		for (int i = 0; i < nbttaglist.tagCount(); i ++) {
			NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
			int j = nbttagcompound.getByte("Slot");
			if (j >= 0 && j < this.inventory.length) {
				this.inventory[j] = ItemStack.loadItemStackFromNBT(nbttagcompound);
			}
		}
		
		this.facing = EnumFacing.byName(compound.getString("Facing"));
		this.type = compound.getBoolean("Normal") ? InfuserType.NORMAL : InfuserType.ORE;
		this.experienceStored = compound.getFloat("Experience");
		this.burnTime = compound.getShort("BurnTime");
		this.itemBurnTime = InfusionFuels.getItemBurnTime(this.inventory[3]);
		this.infusionTime = compound.getShort("InfusionTime");
		this.totalInfusionTime = compound.getShort("InfusionTimeTotal");
		if (compound.hasKey("CustomName")) {
			this.infuserCustomName = compound.getString("CustomName");
		}
	}
	
	@Override public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setString("Facing", this.facing.getName2());
		compound.setBoolean("Normal", this.type.isNormal());
		compound.setFloat("Experience", this.experienceStored);
		compound.setShort("BurnTime", (short) this.burnTime);
		compound.setShort("InfusionTime", (short) this.infusionTime);
		compound.setShort("InfusionTimeTotal", (short) this.totalInfusionTime);
		NBTTagList nbttaglist = new NBTTagList();
		
		for (int i = 0; i < this.inventory.length; i ++) {
			if (this.inventory[i] != null) {
				NBTTagCompound nbttagcompound = new NBTTagCompound();
				nbttagcompound.setByte("Slot", (byte) i);
				this.inventory[i].writeToNBT(nbttagcompound);
				nbttaglist.appendTag(nbttagcompound);
			}
		}
		
		compound.setTag("Items", nbttaglist);
		if (this.hasCustomName()) {
			compound.setString("CustomName", this.infuserCustomName);
		}
		
		return compound;
	}
	
	/* IWorldNameable */
	
	@Override public ITextComponent getDisplayName() {
		return (ITextComponent) (this.hasCustomName() ? new TextComponentString(this.infuserCustomName) : new TextComponentTranslation(this.getName(), new Object[0]));
	}
	
	@Override public String getName() {
		return this.hasCustomName() ? this.infuserCustomName : (this.getType().isNormal() ? "container.zylroth:infuser" : "container.zylroth:oreInfuser");
	}
	
	@Override public boolean hasCustomName() {
		return this.infuserCustomName != null && this.infuserCustomName.length() > 0;
	}
	
	/* IInventory */
	
	@Override public int getSizeInventory() {
		return this.inventory.length;
	}
	
	@Override public ItemStack getStackInSlot(int index) {
		return (index >= 0 && index < this.inventory.length) ? this.inventory[index] : null;
	}
	
	@Override public ItemStack decrStackSize(int index, int count) {
		if (index < 0 || index >= this.inventory.length) return null;
		if (this.inventory[index] != null) {
			if (this.inventory[index].stackSize <= count) {
				ItemStack stack = this.inventory[index];
				this.inventory[index] = null;
				return stack;
			} else {
				ItemStack stack = this.inventory[index].splitStack(count);
				if (this.inventory[index].stackSize == 0) {
					this.inventory[index] = null;
				}
				return stack;
			}
		} else {
			return null;
		}
	}
	
	@Override public ItemStack removeStackFromSlot(int index) {
		if (index < 0 || index >= this.inventory.length) return null;
		if (this.inventory[index] != null) {
			ItemStack stack = this.inventory[index];
			this.inventory[index] = null;
			return stack;
		} else {
			return null;
		}
	}
	
	@Override public void setInventorySlotContents(int index, ItemStack stack) {
		boolean flag = stack != null && stack.isItemEqual(this.inventory[index]) && ItemStack.areItemStackTagsEqual(stack, this.inventory[index]);
		this.inventory[index] = stack;
		if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
			stack.stackSize = this.getInventoryStackLimit();
		}
		if ((index == 0 || index == 1 || index == 2 || index == 3) && !flag) {
			this.totalInfusionTime = InfusionRecipeHandler.instance().getInfusionTime(this.type, this.inventory[0], this.inventory[1], this.inventory[2]);
			this.infusionTime = 0;
			this.markDirty();
		}
	}
	
	@Override public int getInventoryStackLimit() {
		return 64;
	}
	
	@Override public boolean isItemValidForSlot(int index, ItemStack stack) {
		return (index == 4) ? false : ((index == 3) ? InfusionFuels.isFuel(stack) : true);
	}
	
	@Override public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
	}
	
	@Override public void openInventory(EntityPlayer player) {}
	@Override public void closeInventory(EntityPlayer player) {}
	
	@Override public int getField(int id) {
		switch (id) {
			case 0:
				return this.burnTime;
			case 1:
				return this.itemBurnTime;
			case 2:
				return this.infusionTime;
			case 3:
				return this.totalInfusionTime;
			default:
				return 0;
		}
	}
	
	@Override public void setField(int id, int value) {
		switch (id) {
			case 0:
				this.burnTime = value;
				break;
			case 1:
				this.itemBurnTime = value;
				break;
			case 2:
				this.infusionTime = value;
				break;
			case 3:
				this.totalInfusionTime = value;
		}
	}
	
	@Override public int getFieldCount() {
		return 4;
	}
	
	@Override public void clear() {
		this.inventory = new ItemStack[this.inventory.length];
	}
	
	/* ISidedInventory*/
	
	@Override public int[] getSlotsForFace(EnumFacing side) {
		return (side == EnumFacing.DOWN) ? slotsBottom : ((side == EnumFacing.UP) ? slotsTop : ((side == this.facing.rotateAround(Axis.X)) ? slotsSidesOut : slotsSidesIn));
	}

	@Override public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
		return this.isItemValidForSlot(index, itemStackIn);
	}

	@Override public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		return true;
	}
	
	/* ITickable */
	
	@Override public void update() {
		boolean burning = this.isBurning();
		boolean dirty = false;
		
		if (this.isBurning()) {
			this.burnTime --;
		}
		
		if (!this.worldObj.isRemote) {
			if (this.isBurning() || this.inventory[3] != null && this.isValidInfusingRecipe()) {
				if (!this.isBurning() && this.isValidInfusingRecipe()) {
					this.itemBurnTime = this.burnTime = InfusionFuels.getItemBurnTime(this.inventory[3]);
					if (this.isBurning()) {
						dirty = true;
						if (this.inventory[3] != null) {
							this.inventory[3].stackSize --;
							if (this.inventory[3].stackSize == 0) {
								this.inventory[3] = this.inventory[3].getItem().getContainerItem(this.inventory[3]);
							}
						}
					}
				}
				
				if (this.isBurning() && this.isValidInfusingRecipe()) {
					this.infusionTime ++;
					if (this.infusionTime >= this.totalInfusionTime) {
						this.infusionTime = 0;
						this.completeInfusion();
						dirty = true;
					}
				} else {
					this.infusionTime = 0;
				}
			} else if (!this.isBurning() && this.infusionTime > 0) {
				this.infusionTime = MathHelper.clamp_int(this.infusionTime - 2, 0, this.totalInfusionTime);
			}
			
			if (burning != this.isBurning()) {
				dirty = true;
				InfuserMachine.setState(this.getType(), this.isBurning(), this.worldObj, this.pos);
			}
		}
		
		if (dirty) {
			this.markDirty();
		}
	}
	
	/* TileEntityInfuser */
	
	public void setFacing(EnumFacing facing) {
		this.facing = facing;
	}
	
	public EnumFacing getFacing() {
		return this.facing;
	}
	
	public void setCustomInventoryName(String customName) {
		this.infuserCustomName = customName;
	}
	
	public boolean isBurning() {
		return this.burnTime > 0;
	}
	
	@SideOnly(Side.CLIENT) public static boolean isBurning(IInventory infuserInventory) {
		if (!(infuserInventory instanceof TileEntityInfuser)) return false;
		return infuserInventory.getField(0) > 0;
	}
	
	private boolean isValidInfusingRecipe() {
		InfusionRecipeLib recipe = InfusionRecipeHandler.instance().getRecipe(this.type, this.inventory[0], this.inventory[1], this.inventory[2]);
		if (recipe == null) return false;
		if (this.inventory[4] == null) return true;
		if (!this.inventory[4].isItemEqual(recipe.getOutput().copy())) return false;
		int result = this.inventory[4].stackSize + recipe.getOutput().copy().stackSize;
		return result <= getInventoryStackLimit() && result <= this.inventory[4].getMaxStackSize();
	}
	
	private void completeInfusion() {
		if (this.isValidInfusingRecipe()) {
			InfusionRecipeLib infusionRecipe = InfusionRecipeHandler.instance().getRecipe(this.type, this.inventory[0], this.inventory[1], this.inventory[2]);
			ItemStack itemstack = infusionRecipe.getOutput().copy();
			if (this.inventory[4] == null) {
				this.inventory[4] = itemstack;
			} else if (this.inventory[4].getItem() == itemstack.getItem()) {
				this.inventory[4].stackSize += itemstack.stackSize;
			}
			
			ArrayList<Integer> materialCosts = InfusionRecipeHandler.instance().getMaterialCosts(this.type, this.inventory[0], this.inventory[1], this.inventory[2]);
			for (int i = 0; i <= 2; i ++) {
				this.inventory[i].stackSize -= materialCosts.get(i);
				if (this.inventory[i].stackSize <= 0) this.inventory[i] = null;
			}
			
			this.experienceStored += infusionRecipe.getExperience();
		}
	}
	
	public InfuserType getType() {
		return type;
	}

	public float getExperienceStored() {
		return this.experienceStored;
	}

	public void setExperienceStored(int experienceStored) {
		this.experienceStored = experienceStored;
	}
}