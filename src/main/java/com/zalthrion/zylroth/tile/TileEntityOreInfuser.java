package com.zalthrion.zylroth.tile;

import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.block.machine.OreInfuserMachine;
import com.zalthrion.zylroth.container.ContainerOreInfuser;
import com.zalthrion.zylroth.handler.recipe.OreInfusionRecipeHandler;
import com.zalthrion.zylroth.handler.recipe.OreInfusionRecipeLib;
import com.zalthrion.zylroth.lib.ModItems;

public class TileEntityOreInfuser extends TileEntityBase implements ITickable, ISidedInventory {
	
	private String localizedName;
	
	private ItemStack[] slots = new ItemStack[4];
	
	public static final int[] slots_top = new int[] {0};
	public static final int[] slots_bottom = new int[] {2, 1};
	public static final int[] slots_sides = new int[] {1};
	
	public int burnTime; // Time left for this furnace to burn for
	public int furnaceSpeed; // Cooking speed
	public int currentItemBurnTime; // Start time for this fuel
	public int cookTime; // How much time left until cooked
	
	private int facing;
	
	public void setFacing(int newFacing) {
		this.facing = newFacing;
	}
	
	public int getFacing() {
		return this.facing;
	}
	
	public boolean canUpdate() {
		return true;
	};
	
	// TODO: this.burnTime isn't working, replaced to this.cookTime.
	public boolean isBurning() {
		return this.cookTime > 0;
	};
	
	@Override public String getName() {
		return this.isInventoryNameLocalized() ? this.localizedName : "container.oreInfuser";
	}
	
	public boolean isInventoryNameLocalized() {
		return this.localizedName != null && this.localizedName.length() > 0;
	}
	
	public void setGuiDisplayName(String displayName) {
		this.localizedName = displayName;
	}
	
	@Override public void update() {
		boolean flag = isBurning();
		boolean flag1 = false;
		
		if (this.burnTime > 0) {
			-- burnTime;
		}
		
		if (!worldObj.isRemote) {// && GuiOreInfuser.craftEnable == true) {
		
			if (burnTime == 0 && canInfuse()) {
				currentItemBurnTime = burnTime = getItemBurnTime(slots[ContainerOreInfuser.FIRST_FUEL]);
				
				if (isBurning()) {
					flag1 = true;
					
					/* if (slots[ContainerOreInfuser.FIRST_FUEL] != null) { --
					 * slots[ContainerOreInfuser.FIRST_FUEL].stackSize; if
					 * (slots[ContainerOreInfuser.FIRST_FUEL].stackSize == 0) {
					 * slots[ContainerOreInfuser.FIRST_FUEL] =
					 * slots[ContainerOreInfuser
					 * .FIRST_FUEL].getItem().getContainerItem
					 * (slots[ContainerOreInfuser.FIRST_FUEL]); } } */
				}
			}
			
			if (/* isBurning() && */canInfuse()) {
				++ cookTime;
				if (cookTime == 400) {
					cookTime = 0;
					infuseItem();
					flag1 = true;
				}
			} else {
				cookTime = 0;
			}
			
			if (flag != isBurning()) {
				OreInfuserMachine.updateBlockState(this.isBurning(), worldObj, pos);
				flag1 = true;
			}
		}
		
		if (flag1) {
			this.markDirty();
		}
	}
	
	private boolean canInfuse() {
		if (slots[0] == null) return false;
		if (slots[2] == null && slots[3] == null) return false;
		OreInfusionRecipeHandler infusionRecipes = OreInfusionRecipeHandler.instance();
		OreInfusionRecipeLib recipe = infusionRecipes.getRecipe(slots[0], slots[2], slots[3]);
		if (recipe == null) return false;
		ItemStack stack = recipe.getOutput();
		if (slots[ContainerOreInfuser.OUTPUT] == null) return true;
		if (!slots[ContainerOreInfuser.OUTPUT].isItemEqual(stack)) return false;
		int result = slots[ContainerOreInfuser.OUTPUT].stackSize + stack.stackSize;
		return (result <= getInventoryStackLimit() && result <= stack.getMaxStackSize());
	}
	
	public void infuseItem() {
		if (canInfuse()) {
			OreInfusionRecipeHandler infusionRecipes = OreInfusionRecipeHandler.instance();
			
			OreInfusionRecipeLib recipe = infusionRecipes.getRecipe(slots[0], slots[2], slots[3]);
			if (recipe == null) return;
			ItemStack stack = recipe.getOutput();
			if (slots[ContainerOreInfuser.OUTPUT] == null) {
				slots[ContainerOreInfuser.OUTPUT] = stack.copy();
			} else if (slots[ContainerOreInfuser.OUTPUT].isItemEqual(stack)) {
				slots[ContainerOreInfuser.OUTPUT].stackSize += stack.stackSize;
			}
			
			-- slots[ContainerOreInfuser.INPUT].stackSize;
			
			OreInfusionRecipeLib recipeCopy = recipe.copy();
			ArrayList<ItemStack> recipeRequirements = new ArrayList<ItemStack>(recipeCopy.getOreInfusionMaterials());
			HashMap<Integer, ItemStack> providedStacks = new HashMap<Integer, ItemStack>() {
				private static final long serialVersionUID = 1L;
				{
					if (slots[2] != null) put(2, slots[2].copy());
					if (slots[3] != null) put(3, slots[3].copy());
				}
			};
			providedStacks: for (ItemStack provided : providedStacks.values()) {
				if (provided == null) continue providedStacks;
				if (!OreInfusionRecipeHandler.arrayListContainsItemStack(recipeRequirements, provided)) break providedStacks; // Something
																																// went
																																// wrong
				rRLoop: for (ItemStack reqStack : recipeRequirements) {
					if (provided.getItem() != reqStack.getItem()) continue rRLoop;
					if (provided.stackSize >= reqStack.stackSize) {
						provided.stackSize -= reqStack.stackSize;
						recipeRequirements.remove(reqStack);
						continue providedStacks;
					}
				}
			}
			
			if (slots[2] != null) slots[2] = providedStacks.get(2);
			if (slots[3] != null) slots[3] = providedStacks.get(3);
			
			if (slots[0].stackSize <= 0) slots[0] = null;
			if (slots[2] != null) {
				if (slots[2].stackSize <= 0) slots[2] = null;
			}
			if (slots[3] != null) {
				if (slots[3].stackSize <= 0) slots[3] = null;
			}
		}
	}
	
	@Override public ItemStack getStackInSlot(int i) {
		return this.slots[i];
	}
	
	@Override public ItemStack decrStackSize(int i, int j) {
		if (this.slots[i] != null) {
			ItemStack stack;
			
			if (this.slots[i].stackSize <= j) {
				stack = this.slots[i];
				this.slots[i] = null;
				return stack;
				
			} else {
				stack = this.slots[i].splitStack(j);
				
				if (this.slots[i].stackSize == 0) {
					this.slots[i] = null;
				}
				
				return stack;
			}
		}
		
		return null;
		
	}
	
	public ItemStack getStackInSlotOnClosing(int i) {
		if (this.slots[i] != null) {
			ItemStack stack = this.slots[i];
			this.slots[i] = null;
			
			return stack;
		}
		
		return null;
	}
	
	@Override public void setInventorySlotContents(int i, ItemStack stack) {
		this.slots[i] = stack;
		
		if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
			stack.stackSize = this.getInventoryStackLimit();
		}
	}
	
	@Override public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double) this.getPos().getX() + 0.5D, (double) this.getPos().getY() + 0.5D, (double) this.getPos().getZ() + 0.5D) <= 64.0D;
	}
	
	@Override public int getSizeInventory() {
		return this.slots.length;
	};
	
	public static int getItemBurnTime(ItemStack stack) {
		if (stack == null) {
			return 0;
		} else {
			Item i = stack.getItem();
			if (i == ModItems.tenebraeChunk) return 400;
			GameRegistry.getFuelValue(stack);
		}
		return 0;
	}
	
	private boolean isOreInfusionItem(ItemStack stack) {
		return getItemBurnTime(stack) > 0;
	}
	
	@Override public int getInventoryStackLimit() {
		return 64;
	};
	
	@Override public boolean isItemValidForSlot(int i, ItemStack stack) {
		return i == 1 ? isOreInfusionItem(stack) : i == 2 ? false : i == 3 ? false : true;
	};
	
	@Override public int[] getSlotsForFace(EnumFacing side) {
		return side.getIndex() == 0 ? slots_bottom : (side.getIndex() == 1 ? slots_top : slots_sides);
	}
	
	@Override public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		
		NBTTagList list = nbt.getTagList("Stacks", nbt.getId());
		this.slots = new ItemStack[this.getSizeInventory()];
		
		for (int i = 0; i < list.tagCount(); i ++) {
			NBTTagCompound compound = list.getCompoundTagAt(i);
			byte b = compound.getByte("Slot");
			
			if (b >= 0 && b < this.slots.length) {
				this.slots[b] = ItemStack.loadItemStackFromNBT(compound);
				
			}
		}
		
		facing = nbt.getInteger("Facing");
		burnTime = nbt.getShort("BurnTime");
		cookTime = nbt.getShort("CookTime");
		currentItemBurnTime = getItemBurnTime(slots[1]);
		
		/* if (nbt.hasKey("CustomName")) { this.localizedName =
		 * nbt.getString("CustomName"); } */
	}
	
	@Override public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		
		NBTTagList list = new NBTTagList();
		
		nbt.setInteger("Facing", facing);
		nbt.setShort("BurnTime", (short) burnTime);
		nbt.setShort("CookTime", (short) cookTime);
		
		for (int i = 0; i < this.slots.length; i ++) {
			NBTTagCompound compound = new NBTTagCompound();
			
			if (this.slots[i] != null) {
				compound.setByte("Slot", (byte) i);
				this.slots[i].writeToNBT(compound);
				list.appendTag(compound);
			}
		}
		
		nbt.setTag("Stacks", list);
		
		/* if (this.isInventoryNameLocalized()) { nbt.setString("CustomName",
		 * this.localizedName); } */
	}
	
	@SideOnly(Side.CLIENT) public int getCookProgressScaled(int i) {
		return cookTime * i / 400;
	}

	@Override public boolean canInsertItem(int i, ItemStack itemStackIn, EnumFacing side) {
		return this.isItemValidForSlot(i, itemStackIn);
	}

	@Override public boolean canExtractItem(int i, ItemStack stack, EnumFacing side) {
		return side.getIndex() == 0 || i != 0 || i != 1 || i != 2;
	}
}