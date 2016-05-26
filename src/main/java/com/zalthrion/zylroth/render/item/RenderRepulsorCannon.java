package com.zalthrion.zylroth.render.item;

import org.lwjgl.opengl.GL11;

import com.zalthrion.zylroth.model.item.ModelRepulsorCannon;
import com.zalthrion.zylroth.reference.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class RenderRepulsorCannon implements IItemRenderer {
	
	private ModelRepulsorCannon model;
	
	private ModelBiped modelBipedMain = new ModelBiped(0.0F);
	private Minecraft mc = Minecraft.getMinecraft();
	
	public RenderRepulsorCannon() {
		model = new ModelRepulsorCannon();
	}
	
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch (type) {
			case EQUIPPED: // render in third person
				GL11.glPushMatrix();
				GL11.glScalef(1.55F, 1.55F, 1.55F);
				mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID.toLowerCase() + ":" + "textures/items/" + "repulsorCannon.png"));
				GL11.glRotatef(110F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(12F, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(-15F, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(0.34F, -0.4F, 0.11F);
				model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
				break;
			
			case EQUIPPED_FIRST_PERSON:
				GL11.glPushMatrix();
				GL11.glScalef(0.9F, 0.9F, 0.9F);
				mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID.toLowerCase() + ":" + "textures/items/" + "repulsorCannon.png"));
				if (mc.thePlayer.isUsingItem()) {
					GL11.glRotatef(90F, 1.0F, 0.0F, -0.0F);
					GL11.glRotatef(52F, 0.0F, 1.0F, 0.0F);
					GL11.glRotatef(-102F, 0.0F, 0.0F, 1.0F);
					GL11.glTranslatef(-0.3F, 0.25F, 0.46F);
					model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				} else if (!mc.thePlayer.isUsingItem()){
					GL11.glRotatef(86F, 1.0F, 0.0F, -0.0F);	   //rotate 0 ° on X axis
					GL11.glRotatef(40F, 0.0F, 1.0F, 0.0F);	  // rotate -5 ° on Y axis
					GL11.glRotatef(-78F, 0.0F, 0.0F, 1.0F);  // rotate -150 ° on Z axis
					GL11.glTranslatef(0.5F, 0.15F, -0.17F);    //translate model to fit in the hand of the player
					model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				}
				GL11.glPopMatrix();
				renderFirstPersonArm(mc.thePlayer);
				break;
			
			case ENTITY:
				GL11.glPushMatrix();
				GL11.glScalef(1.5F, 1.5F, 1.5F);
				mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID.toLowerCase() + ":" + "textures/items/" + "repulsorCannon.png"));
				GL11.glRotatef(0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(2F, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(0F, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(0.25F, -0.2F, -0.4F);
				model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
				break;
			
			case INVENTORY:
				GL11.glPushMatrix();
				GL11.glScalef(1.5F, 1.5F, 1.5F);
				mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID.toLowerCase() + ":" + "textures/items/" + "repulsorCannon.png"));
				GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(0F, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(0F, -0.4F, -0.05F);
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
	
	private void renderFirstPersonArm(EntityPlayer player) {
		mc.renderEngine.bindTexture(mc.thePlayer.getLocationSkin());
		
		float f = 1.0F;
		GL11.glColor3f(f, f, f);
		
		if (player.isUsingItem()) {
			this.modelBipedMain.setRotationAngles(0, 0, 0, 0, 0, 0, null);
			this.modelBipedMain.bipedRightArm.rotateAngleX = 0F;
			this.modelBipedMain.bipedRightArm.rotateAngleY = 0F;
			this.modelBipedMain.bipedRightArm.rotateAngleZ = -0.8F;
			this.modelBipedMain.bipedRightArm.offsetX = 0.8F;
			this.modelBipedMain.bipedRightArm.offsetY = -0.2F;
			this.modelBipedMain.bipedRightArm.offsetZ = 0.2F;
			this.modelBipedMain.bipedRightArm.render(0.0625F);
		} else {
			this.modelBipedMain.setRotationAngles(0, 0, 0, 0, 0, 0, null);
			this.modelBipedMain.bipedRightArm.rotateAngleX = 0.2F;
			this.modelBipedMain.bipedRightArm.rotateAngleY = 0F;
			this.modelBipedMain.bipedRightArm.rotateAngleZ = -0.8F;
			this.modelBipedMain.bipedRightArm.offsetX = 0.4F;
			this.modelBipedMain.bipedRightArm.offsetY = 0F;
			this.modelBipedMain.bipedRightArm.offsetZ = -0.4F;
			this.modelBipedMain.bipedRightArm.render(0.0625F);
		}
	}
}