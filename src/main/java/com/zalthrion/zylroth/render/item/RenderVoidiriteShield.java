package com.zalthrion.zylroth.render.item;

import org.lwjgl.opengl.GL11;

import com.zalthrion.zylroth.model.item.ModelRegularShield;
import com.zalthrion.zylroth.reference.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class RenderVoidiriteShield implements IItemRenderer {
	
	private ModelRegularShield model;
	
	private Minecraft mc = Minecraft.getMinecraft();
	
	public RenderVoidiriteShield() {
		model = new ModelRegularShield();
	}
	
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch (type) {
			case EQUIPPED:
				GL11.glPushMatrix();
				GL11.glScalef(1.55F, 1.55F, 1.55F);
				mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID.toLowerCase() + ":" + "textures/items/" + "voidiriteShieldModel.png"));
				if (mc.thePlayer.isUsingItem()) {
					GL11.glRotatef(145F, 1.0F, 0.0F, 0.0F);
					GL11.glRotatef(2F, 0.0F, 1.0F, 0.0F);
					GL11.glRotatef(-20F, 0.0F, 0.0F, 1.0F);
					GL11.glTranslatef(0.28F, -0.8F, -0.2F);
					model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				} else if (!mc.thePlayer.isUsingItem()){
					GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
					GL11.glRotatef(55F, 0.0F, 1.0F, 0.0F);
					GL11.glRotatef(-92F, 0.0F, 0.0F, 1.0F);
					GL11.glTranslatef(-0.05F, -0.8F, 0.02F);
					model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				}
				GL11.glPopMatrix();
				break;
			
			case EQUIPPED_FIRST_PERSON:
				GL11.glPushMatrix();
				GL11.glScalef(1F, 1F, 1F);
				mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID.toLowerCase() + ":" + "textures/items/" + "voidiriteShieldModel.png"));
				GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(30F, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(-105F, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(-0.2F, -0.42F, -0F);
				model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
				break;
			
			case ENTITY:
				GL11.glPushMatrix();
				GL11.glScalef(1.5F, 1.5F, 1.5F);
				mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID.toLowerCase() + ":" + "textures/items/" + "voidiriteShieldModel.png"));
				GL11.glRotatef(150F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(2F, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(0F, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(0.25F, -0.2F, -0.4F);
				model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
				break;
			
			case INVENTORY:
				GL11.glPushMatrix();
				GL11.glScalef(1.25F, 1.25F, 1.25F);
				mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID.toLowerCase() + ":" + "textures/items/" + "voidiriteShieldModel.png"));
				GL11.glRotatef(-10F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(0.4F, -1.15F, -0.4F);
				model.render(0.0625F);
				GL11.glPopMatrix();
				break;
			
			default:
				break;
		}
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}
	
	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		switch (type) {
			case INVENTORY:
				return true;
			default:
				break;
		}
		
		return false;
	}
}