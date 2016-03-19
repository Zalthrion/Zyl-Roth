package com.zalthrion.zylroth.world.dimension;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import com.zalthrion.zylroth.lib.ModArmors;
import com.zalthrion.zylroth.reference.Reference;

public class SkyRenderIridis extends IRenderHandler {
	private static final ResourceLocation textureRainbow = new ResourceLocation(Reference.RESOURCE_PREFIX + "textures/world/rainbow.png");
	private static final ResourceLocation textureMoonPhases = new ResourceLocation("textures/environment/moon_phases.png");
	private static final ResourceLocation textureSun = new ResourceLocation("textures/environment/sun.png");
	private static final String[] GL_SKY_LIST = new String[] {"glSkyList", "field_72771_w", "G"};
	private static final String[] GL_STAR_LIST = new String[] { "starGLCallList", "field_72772_v", "F" };
	
	@Override public void render(float partialTicks, WorldClient world, Minecraft mc) {
		int glSkyList = ReflectionHelper.getPrivateValue(RenderGlobal.class, mc.renderGlobal, GL_SKY_LIST);
		int starGLCallList = ReflectionHelper.getPrivateValue(RenderGlobal.class, mc.renderGlobal, GL_STAR_LIST);
		
		/* VANILLA */
		
		GlStateManager.disableTexture2D();
		Vec3d vec3 = world.getSkyColor(mc.getRenderViewEntity(), partialTicks);
		float f = (float) vec3.xCoord;
		float f1 = (float) vec3.yCoord;
		float f2 = (float) vec3.zCoord;
		float insideVoid = 0F;
		if (mc.thePlayer.posY <= -2) insideVoid = (float) Math.min(1F, - (mc.thePlayer.posY + 2) / 30F);
		f = Math.max(0F, f - insideVoid);
		f1 = Math.max(0F, f1 - insideVoid);
		f2 = Math.max(0F, f2 - insideVoid);
		
		GlStateManager.color(f, f1, f2);
		Tessellator tessellator = Tessellator.getInstance();
		VertexBuffer vertexBuffer = tessellator.getBuffer();
		GlStateManager.depthMask(false);
		GlStateManager.enableFog();
		GlStateManager.color(f, f1, f2);
		
		GlStateManager.callList(glSkyList);
		
		GlStateManager.disableFog();
		GlStateManager.disableAlpha();
		GlStateManager.enableBlend();
		GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
		RenderHelper.disableStandardItemLighting();
		float[] afloat = world.provider.calcSunriseSunsetColors(world.getCelestialAngle(partialTicks), partialTicks);
		
		if (afloat != null) {
			GlStateManager.disableTexture2D();
			GlStateManager.shadeModel(7425);
			GlStateManager.pushMatrix();
			GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
			GlStateManager.rotate(MathHelper.sin(world.getCelestialAngleRadians(partialTicks)) < 0.0F ? 180.0F : 0.0F, 0.0F, 0.0F, 1.0F);
			GlStateManager.rotate(90.0F, 0.0F, 0.0F, 1.0F);
			float f6 = afloat[0];
			float f7 = afloat[1];
			float f8 = afloat[2];
			
			vertexBuffer.begin(6, DefaultVertexFormats.POSITION_COLOR);
			vertexBuffer.pos(0.0D, 100.0D, 0.0D).color(f6, f7, f8, afloat[3] * (1F - insideVoid)).endVertex();
			
			for (int l = 0; l <= 16; ++ l) {
				float f21 = (float) l * (float) Math.PI * 2.0F / 16.0F;
				float f12 = MathHelper.sin(f21);
				float f13 = MathHelper.cos(f21);
				vertexBuffer.pos((double) (f12 * 120.0F), (double) (f13 * 120.0F), (double) (-f13 * 40.0F * afloat[3])).color(afloat[0], afloat[1], afloat[2], 0.0F).endVertex();
			}
			
			tessellator.draw();
			GlStateManager.popMatrix();
			GlStateManager.shadeModel(7424);
		}
		
		/* Rainbow (Originally written by Vazkii. Ported to 1.8.9 by Mitch.) */
		
		boolean renderRainbow = false;
		if (mc.thePlayer.inventory.armorInventory[3] != null) {
			if (mc.thePlayer.inventory.armorInventory[3].getItem() == ModArmors.rainbowGlasses) {
				renderRainbow = true;
			}
		}
		
		if (renderRainbow) {
			GlStateManager.enableTexture2D();
			
			float celAng = world.getCelestialAngle(partialTicks);
			
			float y = 2F;
			float y0 = 0F;
			int angles = 90;
			float uPer = 1F / 360F;
			float anglePer = 360F / angles;
			
			GlStateManager.pushMatrix();
			OpenGlHelper.glBlendFunc(770, 771, 1, 0);
			mc.renderEngine.bindTexture(textureRainbow);
			float f10 = 10F;
			float effCelAng1 = celAng;
			if (effCelAng1 > 0.25F) effCelAng1 = 1F - effCelAng1;
			effCelAng1 = 0.25F - Math.min(0.25F, effCelAng1);
			
			GlStateManager.color(1F, 1F, 1F, effCelAng1);
			GlStateManager.rotate(90F, 0F, 1F, 0F);
			GlStateManager.rotate(135F, 0F, 0F, 1F);
			
			vertexBuffer.begin(7, DefaultVertexFormats.POSITION_TEX);
			for (int b = 0; b < angles; b ++) {
				int j = b;
				if (b % 2 == 0) j --;
				
				float ang = j * anglePer;
				double xp = Math.cos(ang * Math.PI / 180F) * f10;
				double zp = Math.sin(ang * Math.PI / 180F) * f10;
				double yo = 0;
				
				float ut = ang * uPer;
				if (b % 2 == 0) {
					vertexBuffer.pos(xp, yo + y0 + y, zp).tex(ut, 1F).endVertex();
					vertexBuffer.pos(xp, yo + y0, zp).tex(ut, 0F).endVertex();
				} else {
					vertexBuffer.pos(xp, yo + y0, zp).tex(ut, 0F).endVertex();
					vertexBuffer.pos(xp, yo + y0 + y, zp).tex(ut, 1F).endVertex();
				}
				
			}
			tessellator.draw();
			GlStateManager.popMatrix();
		}
		
		/* End Rainbow */
		
		GlStateManager.enableTexture2D();
		GlStateManager.tryBlendFuncSeparate(770, 1, 1, 0);
		GlStateManager.pushMatrix();
		float f16 = 1.0F - world.getRainStrength(partialTicks);
		GlStateManager.color(1.0F, 1.0F, 1.0F, f16);
		GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(world.getCelestialAngle(partialTicks) * 360.0F, 1.0F, 0.0F, 0.0F);
		float f17 = 30.0F;
		mc.renderEngine.bindTexture(textureSun);
		vertexBuffer.begin(7, DefaultVertexFormats.POSITION_TEX);
		vertexBuffer.pos((double) (-f17), 100.0D, (double) (-f17)).tex(0.0D, 0.0D).endVertex();
		vertexBuffer.pos((double) f17, 100.0D, (double) (-f17)).tex(1.0D, 0.0D).endVertex();
		vertexBuffer.pos((double) f17, 100.0D, (double) f17).tex(1.0D, 1.0D).endVertex();
		vertexBuffer.pos((double) (-f17), 100.0D, (double) f17).tex(0.0D, 1.0D).endVertex();
		tessellator.draw();
		f17 = 20.0F;
		mc.renderEngine.bindTexture(textureMoonPhases);
		int i = world.getMoonPhase();
		int k = i % 4;
		int i1 = i / 4 % 2;
		float f22 = (float) (k + 0) / 4.0F;
		float f23 = (float) (i1 + 0) / 2.0F;
		float f24 = (float) (k + 1) / 4.0F;
		float f14 = (float) (i1 + 1) / 2.0F;
		vertexBuffer.begin(7, DefaultVertexFormats.POSITION_TEX);
		vertexBuffer.pos((double) (-f17), -100.0D, (double) f17).tex((double) f24, (double) f14).endVertex();
		vertexBuffer.pos((double) f17, -100.0D, (double) f17).tex((double) f22, (double) f14).endVertex();
		vertexBuffer.pos((double) f17, -100.0D, (double) (-f17)).tex((double) f22, (double) f23).endVertex();
		vertexBuffer.pos((double) (-f17), -100.0D, (double) (-f17)).tex((double) f24, (double) f23).endVertex();
		tessellator.draw();
		GlStateManager.disableTexture2D();
		float f15 = world.getStarBrightness(partialTicks) * f16;
		
		if (f15 > 0.0F) {
			GlStateManager.color(f15, f15, f15, f15);
			
			GlStateManager.callList(starGLCallList);
		}
		
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.disableBlend();
		GlStateManager.enableAlpha();
		GlStateManager.enableFog();
		GlStateManager.popMatrix();
		GlStateManager.disableTexture2D();
		GlStateManager.color(0.0F, 0.0F, 0.0F);
		double d0 = mc.thePlayer.getPositionEyes(partialTicks).yCoord - world.getHorizon();
		
		if (d0 < 0.0D) {
			GlStateManager.pushMatrix();
			GlStateManager.translate(0.0F, 12.0F, 0.0F);
			
			GlStateManager.popMatrix();
			float f19 = -((float) (d0 + 65.0D));
			vertexBuffer.begin(7, DefaultVertexFormats.POSITION_COLOR);
			vertexBuffer.pos(-1.0D, (double) f19, 1.0D).color(0, 0, 0, 255).endVertex();
			vertexBuffer.pos(1.0D, (double) f19, 1.0D).color(0, 0, 0, 255).endVertex();
			vertexBuffer.pos(1.0D, -1.0D, 1.0D).color(0, 0, 0, 255).endVertex();
			vertexBuffer.pos(-1.0D, -1.0D, 1.0D).color(0, 0, 0, 255).endVertex();
			vertexBuffer.pos(-1.0D, -1.0D, -1.0D).color(0, 0, 0, 255).endVertex();
			vertexBuffer.pos(1.0D, -1.0D, -1.0D).color(0, 0, 0, 255).endVertex();
			vertexBuffer.pos(1.0D, (double) f19, -1.0D).color(0, 0, 0, 255).endVertex();
			vertexBuffer.pos(-1.0D, (double) f19, -1.0D).color(0, 0, 0, 255).endVertex();
			vertexBuffer.pos(1.0D, -1.0D, -1.0D).color(0, 0, 0, 255).endVertex();
			vertexBuffer.pos(1.0D, -1.0D, 1.0D).color(0, 0, 0, 255).endVertex();
			vertexBuffer.pos(1.0D, (double) f19, 1.0D).color(0, 0, 0, 255).endVertex();
			vertexBuffer.pos(1.0D, (double) f19, -1.0D).color(0, 0, 0, 255).endVertex();
			vertexBuffer.pos(-1.0D, (double) f19, -1.0D).color(0, 0, 0, 255).endVertex();
			vertexBuffer.pos(-1.0D, (double) f19, 1.0D).color(0, 0, 0, 255).endVertex();
			vertexBuffer.pos(-1.0D, -1.0D, 1.0D).color(0, 0, 0, 255).endVertex();
			vertexBuffer.pos(-1.0D, -1.0D, -1.0D).color(0, 0, 0, 255).endVertex();
			vertexBuffer.pos(-1.0D, -1.0D, -1.0D).color(0, 0, 0, 255).endVertex();
			vertexBuffer.pos(-1.0D, -1.0D, 1.0D).color(0, 0, 0, 255).endVertex();
			vertexBuffer.pos(1.0D, -1.0D, 1.0D).color(0, 0, 0, 255).endVertex();
			vertexBuffer.pos(1.0D, -1.0D, -1.0D).color(0, 0, 0, 255).endVertex();
			tessellator.draw();
		}
		
		GlStateManager.color(f, f1, f2);
		
		GlStateManager.pushMatrix();
		GlStateManager.translate(0.0F, -((float) (d0 - 16.0D)), 0.0F);
		GlStateManager.popMatrix();
		GlStateManager.enableTexture2D();
		GlStateManager.depthMask(true);
	}
}