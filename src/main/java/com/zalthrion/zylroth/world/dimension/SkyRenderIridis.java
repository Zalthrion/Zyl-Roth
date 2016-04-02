package com.zalthrion.zylroth.world.dimension;

import org.lwjgl.opengl.GL11;

import com.zalthrion.zylroth.lib.ModArmors;
import com.zalthrion.zylroth.reference.Reference;

import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.IRenderHandler;

public class SkyRenderIridis extends IRenderHandler {
	private static final ResourceLocation textureRainbow = new ResourceLocation(Reference.RESOURCE_PREFIX + "textures/world/rainbow.png");
	private static final ResourceLocation textureMoonPhases = new ResourceLocation("textures/environment/moon_phases.png");
	private static final ResourceLocation textureSun = new ResourceLocation("textures/environment/sun.png");
	private static final String[] GL_SKY_LIST = new String[] {"glSkyList", "field_72771_w", "G"};
	private static final String[] GL_STAR_LIST = new String[] {"starGLCallList", "field_72772_v", "F"};
	
	@Override public void render(float partialTicks, WorldClient world, Minecraft mc) {
		int glSkyList = ReflectionHelper.getPrivateValue(RenderGlobal.class, mc.renderGlobal, GL_SKY_LIST);
		int starGLCallList = ReflectionHelper.getPrivateValue(RenderGlobal.class, mc.renderGlobal, GL_STAR_LIST);
		
		/* Vanilla */
		
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		Vec3 vec3 = world.getSkyColor(mc.renderViewEntity, partialTicks);
		float f1 = (float) vec3.xCoord;
		float f2 = (float) vec3.yCoord;
		float f3 = (float) vec3.zCoord;
		float f6;
		
		if (mc.gameSettings.anaglyph) {
			float f4 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
			float f5 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
			f6 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
			f1 = f4;
			f2 = f5;
			f3 = f6;
		}
		
		GL11.glColor3f(f1, f2, f3);
		Tessellator tessellator1 = Tessellator.instance;
		GL11.glDepthMask(false);
		GL11.glEnable(GL11.GL_FOG);
		GL11.glColor3f(f1, f2, f3);
		GL11.glDisable(GL11.GL_FOG);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glEnable(GL11.GL_BLEND);
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		RenderHelper.disableStandardItemLighting();
		float[] afloat = world.provider.calcSunriseSunsetColors(world.getCelestialAngle(partialTicks), partialTicks);
		float f7;
		float f8;
		float f9;
		float f10;
		
		if (afloat != null) {
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glShadeModel(GL11.GL_SMOOTH);
			GL11.glPushMatrix();
			GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(MathHelper.sin(world.getCelestialAngleRadians(partialTicks)) < 0.0F ? 180.0F : 0.0F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
			f6 = afloat[0];
			f7 = afloat[1];
			f8 = afloat[2];
			float f11;
			
			if (mc.gameSettings.anaglyph) {
				f9 = (f6 * 30.0F + f7 * 59.0F + f8 * 11.0F) / 100.0F;
				f10 = (f6 * 30.0F + f7 * 70.0F) / 100.0F;
				f11 = (f6 * 30.0F + f8 * 70.0F) / 100.0F;
				f6 = f9;
				f7 = f10;
				f8 = f11;
			}
			
			tessellator1.startDrawing(6);
			tessellator1.setColorRGBA_F(f6, f7, f8, afloat[3]);
			tessellator1.addVertex(0.0D, 100.0D, 0.0D);
			byte b0 = 16;
			tessellator1.setColorRGBA_F(afloat[0], afloat[1], afloat[2], 0.0F);
			
			for (int j = 0; j <= b0; ++ j) {
				f11 = j * (float) Math.PI * 2.0F / b0;
				float f12 = MathHelper.sin(f11);
				float f13 = MathHelper.cos(f11);
				tessellator1.addVertex(f12 * 120.0F, f13 * 120.0F, -f13 * 40.0F * afloat[3]);
			}
			
			tessellator1.draw();
			GL11.glPopMatrix();
			GL11.glShadeModel(GL11.GL_FLAT);
		}
		
		/* The Anti-Render Ontop of Rainbows Initiative */
		
		GL11.glPushMatrix();
		
		GL11.glEnable(GL11.GL_FOG);
		GL11.glCallList(glSkyList);
		GL11.glDisable(GL11.GL_FOG);
		GL11.glPopMatrix();
		
		/* End of the Anti-Render Ontop of Rainbows Initiative */
		
		/* Rainbow (Originally written by Vazkii) */
		
		boolean renderRainbow = false;
		if (mc.thePlayer.inventory.armorInventory[3] != null) {
			if (mc.thePlayer.inventory.armorInventory[3].getItem() == ModArmors.rainbowGlasses) {
				renderRainbow = true;
			}
		}
		
		if (renderRainbow) {
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			
			float celAng = world.getCelestialAngle(partialTicks);
			
			float y = 2F;
			float y0 = 0F;
			int angles = 90;
			float uPer = 1F / 360F;
			float anglePer = 360F / angles;
			
			GL11.glPushMatrix();
			OpenGlHelper.glBlendFunc(770, 771, 1, 0);
			mc.renderEngine.bindTexture(textureRainbow);
			float f11 = 10F;
			float effCelAng1 = celAng;
			if (effCelAng1 > 0.25F) effCelAng1 = 1F - effCelAng1;
			effCelAng1 = 0.25F - Math.min(0.25F, effCelAng1);
			
			GL11.glColor4f(1F, 1F, 1F, effCelAng1);
			GL11.glRotatef(90F, 0F, 1F, 0F);
			GL11.glRotatef(135F, 0F, 0F, 1F);
			
			tessellator1.startDrawingQuads();
			for (int b = 0; b < angles; b ++) {
				int j = b;
				if (b % 2 == 0) j --;
				
				float ang = j * anglePer;
				double xp = Math.cos(ang * Math.PI / 180F) * f11;
				double zp = Math.sin(ang * Math.PI / 180F) * f11;
				double yo = 0;
				
				float ut = ang * uPer;
				if (b % 2 == 0) {
					tessellator1.addVertexWithUV(xp, yo + yo + y, zp, ut, 1F);
					tessellator1.addVertexWithUV(xp, yo + y0, zp, ut, 0F);
				} else {
					tessellator1.addVertexWithUV(xp, yo + y0, zp, ut, 0F);
					tessellator1.addVertexWithUV(xp, yo + y0 + y, zp, ut, 1F);
				}
				
			}
			tessellator1.draw();
			GL11.glPopMatrix();
		}
		
		/* End Rainbow */
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);

		OpenGlHelper.glBlendFunc(770, 1, 1, 0);
		GL11.glPushMatrix();
		f6 = 1.0F - world.getRainStrength(partialTicks);
		f7 = 0.0F;
		f8 = 0.0F;
		f9 = 0.0F;
		GL11.glColor4f(1.0F, 1.0F, 1.0F, f6);
		GL11.glTranslatef(f7, f8, f9);
		GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(world.getCelestialAngle(partialTicks) * 360.0F, 1.0F, 0.0F, 0.0F);
		f10 = 30.0F;
		mc.renderEngine.bindTexture(textureSun);
		tessellator1.startDrawingQuads();
		tessellator1.addVertexWithUV((-f10), 100.0D, (-f10), 0.0D, 0.0D);
		tessellator1.addVertexWithUV(f10, 100.0D, (-f10), 1.0D, 0.0D);
		tessellator1.addVertexWithUV(f10, 100.0D, f10, 1.0D, 1.0D);
		tessellator1.addVertexWithUV((-f10), 100.0D, f10, 0.0D, 1.0D);
		tessellator1.draw();
		f10 = 20.0F;
		mc.renderEngine.bindTexture(textureMoonPhases);
		int k = world.getMoonPhase();
		int l = k % 4;
		int i1 = k / 4 % 2;
		float f14 = (l + 0) / 4.0F;
		float f15 = (i1 + 0) / 2.0F;
		float f16 = (l + 1) / 4.0F;
		float f17 = (i1 + 1) / 2.0F;
		tessellator1.startDrawingQuads();
		tessellator1.addVertexWithUV((-f10), -100.0D, f10, f16, f17);
		tessellator1.addVertexWithUV(f10, -100.0D, f10, f14, f17);
		tessellator1.addVertexWithUV(f10, -100.0D, (-f10), f14, f15);
		tessellator1.addVertexWithUV((-f10), -100.0D, (-f10), f16, f15);
		tessellator1.draw();
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		float f18 = world.getStarBrightness(partialTicks) * f6;
		
		if (f18 > 0.0F) {
			GL11.glColor4f(f18, f18, f18, f18);
			GL11.glCallList(starGLCallList);
		}
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glEnable(GL11.GL_FOG);
		GL11.glPopMatrix();
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glColor3f(0.0F, 0.0F, 0.0F);
		double d0 = mc.thePlayer.getPosition(partialTicks).yCoord - world.getHorizon();
		
		if (d0 < 0.0D) {
			GL11.glPushMatrix();
			GL11.glTranslatef(0.0F, 12.0F, 0.0F);
			GL11.glPopMatrix();
			f8 = 1.0F;
			f9 = -((float) (d0 + 65.0D));
			f10 = -f8;
			tessellator1.startDrawingQuads();
			tessellator1.setColorRGBA_I(0, 255);
			tessellator1.addVertex((-f8), f9, f8);
			tessellator1.addVertex(f8, f9, f8);
			tessellator1.addVertex(f8, f10, f8);
			tessellator1.addVertex((-f8), f10, f8);
			tessellator1.addVertex((-f8), f10, (-f8));
			tessellator1.addVertex(f8, f10, (-f8));
			tessellator1.addVertex(f8, f9, (-f8));
			tessellator1.addVertex((-f8), f9, (-f8));
			tessellator1.addVertex(f8, f10, (-f8));
			tessellator1.addVertex(f8, f10, f8);
			tessellator1.addVertex(f8, f9, f8);
			tessellator1.addVertex(f8, f9, (-f8));
			tessellator1.addVertex((-f8), f9, (-f8));
			tessellator1.addVertex((-f8), f9, f8);
			tessellator1.addVertex((-f8), f10, f8);
			tessellator1.addVertex((-f8), f10, (-f8));
			tessellator1.addVertex((-f8), f10, (-f8));
			tessellator1.addVertex((-f8), f10, f8);
			tessellator1.addVertex(f8, f10, f8);
			tessellator1.addVertex(f8, f10, (-f8));
			tessellator1.draw();
		}
		
		GL11.glColor3f(f1, f2, f3);
		
		GL11.glPushMatrix();
		GL11.glTranslatef(0.0F, -((float) (d0 - 16.0D)), 0.0F);
		GL11.glPopMatrix();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDepthMask(true);
	}
}