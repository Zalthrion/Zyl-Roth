package com.zalthrion.zylroth.item.tools.others;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import com.zalthrion.zylroth.entity.projectile.RepulsorCannonBolt;
import com.zalthrion.zylroth.item.tools.ZylrothTool;
import com.zalthrion.zylroth.lib.ModInit.ItemInit;
import com.zalthrion.zylroth.lib.ModInit.SoundInit;
import com.zalthrion.zylroth.lib.ModInit.ZylrothTab;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.utility.TooltipHelper;

public class RepulsorCannon extends Item implements ZylrothTool {
	public boolean isOnCannonMode = false;
	
	public RepulsorCannon(int i) {
		super();
		this.setCreativeTab(ZylrothTab.ZYLROTH);
		this.setMaxDamage(i);
		this.setMaxStackSize(1);
		this.setNames("repulsorCannon");
	}
	
	/* @Override public void onPlayerStoppedUsing(ItemStack stack, World world,
	 * EntityPlayer player, int i) { if (!this.isBroken(stack)) { if
	 * (player.capabilities.isCreativeMode ||
	 * player.inventory.consumeInventoryItem(Items.redstone)) {
	 * world.playSoundAtEntity(player, "zylroth:weapon.repulsorCannon.shoot",
	 * 0.5F, 0F / (itemRand.nextFloat() * 0.4F + 0.8F)); stack.damageItem(1,
	 * player); if (!world.isRemote) { world.spawnEntityInWorld(new
	 * RepulsorCannonBolt(world, player)); } } } } */
	
	@Override public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
		if (!(entityLiving instanceof EntityPlayer)) return stack;
		EntityPlayer player = (EntityPlayer) entityLiving;
		if (!this.isBroken(stack)) {
			if (player.capabilities.isCreativeMode || player.inventory.clearMatchingItems(Items.REDSTONE, 0, 1, null) > 0) {
				worldIn.playSound(null, player.getPosition(), SoundInit.REPULSOR_CANNON_SHOOT, SoundCategory.PLAYERS, 0.5F, 0F);
				stack.damageItem(1, player);
				if (!worldIn.isRemote) {
					worldIn.spawnEntityInWorld(new RepulsorCannonBolt(worldIn, player));
				}
			}
		}
		return stack;
	}
	
	@Override public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
		EnumActionResult res = EnumActionResult.FAIL;
		if (player.capabilities.isCreativeMode || player.inventory.hasItemStack(new ItemStack(Items.REDSTONE))) {
			player.setActiveHand(hand);
			res = EnumActionResult.PASS;
		}
		
		return new ActionResult<ItemStack>(res, stack);
	}
	
	@Override public int getMaxItemUseDuration(ItemStack stack) {
		return 25;
	}
	
	@Override public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.BOW;
	}
	
	@Override public boolean isBroken(ItemStack stack) {
		return stack.getMetadata() >= 5499;
	}
	
	@Override public boolean onBlockStartBreak(ItemStack stack, BlockPos pos, EntityPlayer player) {
		if (this.isBroken(stack)) {
			if (player.worldObj.isRemote) {
				player.addChatMessage(new TextComponentTranslation("msg." + Reference.RESOURCE_PREFIX + "broken_sword"));
			}
			
			return true;
		}
		
		else return false;
	}
	
	@Override public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		if (!(this.isBroken(stack))) stack.damageItem(1, attacker);
		return true;
	}
	
	@Override public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		if (!isBroken(stack)) {
			player.worldObj.playSound(null, player.getPosition(), SoundInit.REPULSOR_CANNON_MINE, SoundCategory.PLAYERS, 1.0F, 1.0F);
			return false;
		}
		
		World world = player.worldObj;
		if (world.isRemote) player.addChatMessage(new TextComponentTranslation("msg." + Reference.RESOURCE_PREFIX + "broken_tool"));
		return true;
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
		return stack.getItem() == ItemInit.TENEBRAE_INGOT;
	}
	
	@Override public String getUnlocalizedName() {
		return String.format("item.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	@Override public String getUnlocalizedName(ItemStack stack) {
		return String.format("item.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
	
	protected void setNames(String name) {
		this.setUnlocalizedName(name);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
	}
	
	@Override public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
		return false;
	}
	
	@Override public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int p_77663_4_, boolean p_77663_5_) {
		super.onUpdate(stack, worldIn, entityIn, p_77663_4_, p_77663_5_);
	}
}