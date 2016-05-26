package com.zalthrion.zylroth.render.tile.item;

import org.lwjgl.opengl.GL11;

import com.zalthrion.zylroth.model.tile.ModelGoldBag;
import com.zalthrion.zylroth.reference.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class RenderGoldBag implements IItemRenderer {
	
	private ModelGoldBag model;
	private Minecraft mc = Minecraft.getMinecraft();
	
	public RenderGoldBag() {
		model = new ModelGoldBag();
	}
	
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch (type) {
			case EQUIPPED: // render in third person
				GL11.glPushMatrix();
				GL11.glScalef(1.0F, 1.0F, 1.0F);
				mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID.toLowerCase() + ":" + "textures/blocks/" + "goldBag.png"));
				GL11.glRotatef(160F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(250F, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(50F, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(-0.4F, -0.8F, -0.25F);
				model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
				break;
			
			case EQUIPPED_FIRST_PERSON:
				GL11.glPushMatrix();
				GL11.glScalef(1.0F, 1.0F, 1.0F);
				mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID.toLowerCase() + ":" + "textures/blocks/" + "goldBag.png"));
				GL11.glRotatef(-60F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(-140F, 0.0F, 1.0F, -0F);
				GL11.glRotatef(120F, 0.0F, 0.2F, 1.0F);
				GL11.glRotatef(-150, 0.0F, 1.0F, 0F);
				GL11.glTranslatef(-1.05F, -1.0F, 0.8F);
				model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
				break;
			
			case ENTITY:
				GL11.glPushMatrix();
				GL11.glScalef(1.5F, 1.5F, 1.5F);
				mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID.toLowerCase() + ":" + "textures/blocks/" + "goldBag.png"));
				GL11.glRotatef(0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(0F, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(0.25F, -1.0F, -0.4F);
				model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
				break;
			
			case INVENTORY:
				GL11.glPushMatrix();
				GL11.glScalef(1.5F, 1.5F, 1.5F);
				mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID.toLowerCase() + ":" + "textures/blocks/" + "goldBag.png"));
				GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(0F, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(0F, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(0.0F, -1.15F, 0.0F);
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