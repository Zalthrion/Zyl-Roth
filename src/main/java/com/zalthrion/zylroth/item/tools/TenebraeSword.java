package com.zalthrion.zylroth.item.tools;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import com.zalthrion.zylroth.lib.ModItems;
import com.zalthrion.zylroth.reference.Reference;

public class TenebraeSword extends ItemBaseSword {
	
	private String name = "tenebraeSword";
	
	public TenebraeSword(ToolMaterial material) {
		super(material);
		this.setNames(name);
	}
	
	public boolean isBroken(ItemStack stack) {
		return stack.getMetadata() >= Tenebrae;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		
		Random rand = new Random();
		
		if (!(player.isSneaking()) && !(player.capabilities.isCreativeMode)) {
			
			for (int countparticles = 0; countparticles <= 100; ++ countparticles) {
				world.spawnParticle("portal", (double) player.posX - 0.0F, (double) player.posY - 0.5F, (double) player.posZ - 0.0F, (double) ((float) rand.nextFloat() - 0.1F), (double) ((float) rand.nextFloat() - 0.1F), (double) ((float) rand.nextFloat()) - 0.1F);
				world.spawnParticle("portal", (double) player.posX - 0.0F, (double) player.posY - 0.5F, (double) player.posZ - 0.0F, (double) ((float) rand.nextFloat() - 1.1F), (double) ((float) rand.nextFloat() - 0.1F), (double) ((float) rand.nextFloat()) - 0.1F);
				world.spawnParticle("portal", (double) player.posX - 0.0F, (double) player.posY - 0.5F, (double) player.posZ - 0.0F, (double) ((float) rand.nextFloat() - 0.5F), (double) ((float) rand.nextFloat() - 0.1F), (double) ((float) rand.nextFloat()) - 1.1F);
			}
		}
		
		if (player.isSneaking()) {
			
			if (player.capabilities.isCreativeMode) { return stack; }
			
			if (this.isBroken(stack) && !(world.isRemote)) {
				player.addChatMessage(new ChatComponentText("You must repair this sword to continue using it!"));
				return stack;
				
			} else if (stack.getMetadata() < 2200) {
				
				stack.damageItem(50, player);
				world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
				
				if (!world.isRemote) {
					world.spawnEntityInWorld(new EntityEnderPearl(world, player));
				}
				
				world.spawnParticle("portal", player.posX + (rand.nextDouble() - 0.5D) * (double) player.width, player.posY + rand.nextDouble() * (double) player.height - (double) player.yOffset, player.posZ + (rand.nextDouble() - 0.5D) * (double) player.width, 0.0D, 0.0D, 0.0D);
			}
			
		}
		
		return super.onItemRightClick(stack, world, player);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes"})
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		
		if (this.isBroken(stack)) {
			list.add(StatCollector.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "broken_sword"));
		}
		
		else if (!(this.isBroken(stack))) {
			list.add(StatCollector.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "tenebrae_sword_lore"));
			list.add(StatCollector.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "tenebrae_generic"));
			
			list.add(StatCollector.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "shift"));
			
			if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
				list.remove(StatCollector.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "shift"));
				
				list.add(StatCollector.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "tenebrae_sword_info"));
			}
		}
		
	}
	
	@Override
	public boolean getIsRepairable(ItemStack armor, ItemStack stack) {
		
		return stack.getItem() == ModItems.tenebrae_Ingot;
	}
	
	@Override
	public boolean onBlockStartBreak(ItemStack stack, int x, int y, int z, EntityPlayer player) {
		if (this.isBroken(stack)) {
			player.addChatMessage(new ChatComponentText("You must repair this sword to continue using it!"));
			
			return true;
			
		} else return false;
	}
}
