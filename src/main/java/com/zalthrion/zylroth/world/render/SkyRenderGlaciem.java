package com.zalthrion.zylroth.world.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

// TODO Check all mappings, reorganize method order, etc.
public class SkyRenderGlaciem extends IRenderHandler {
	private int starGLCallList;
	private int glSkyList;
	private int glSkyList2;
	
	public SkyRenderGlaciem() {
		RenderGlobal renderGlobal = Minecraft.getMinecraft().renderGlobal;
		this.glSkyList2 = (this.glSkyList = (this.starGLCallList = ObfuscationReflectionHelper.getPrivateValue(RenderGlobal.class, renderGlobal, "starGLCallList", "field_72772_v")) + 1) + 1;
	}
	
	@Override public void render(float partialTicks, WorldClient world, Minecraft mc) {
		GlStateManager.disableTexture2D();
		Vec3d vec3 = world.getSkyColor(mc.getRenderViewEntity(), partialTicks);
		float f1 = (float) vec3.xCoord;
		float f2 = (float) vec3.yCoord;
		float f3 = (float) vec3.zCoord;
		float f6;
		
		GlStateManager.color(f1, f2, f3);
		Tessellator tessellator1 = Tessellator.getInstance();
		VertexBuffer vertexBuffer = tessellator1.getBuffer();
		GlStateManager.depthMask(false);
		GlStateManager.enableFog();
		GlStateManager.callList(this.glSkyList);
		GlStateManager.disableFog();
		GlStateManager.disableAlpha();
		GlStateManager.enableBlend();
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		RenderHelper.disableStandardItemLighting();
		float f7;
		float f8;
		float f9;
		float f10;
		
		GlStateManager.enableTexture2D();
		GlStateManager.pushMatrix();
		f6 = 1.0F - world.getRainStrength(partialTicks);
		f7 = 0.0F;
		f8 = 0.0F;
		f9 = 0.0F;
		GlStateManager.color(1, 1, 1, f6);
		GlStateManager.translate(f7, f8, f9);
		GlStateManager.rotate(-90F, 0, 1, 0);
		GlStateManager.rotate(world.getCelestialAngle(partialTicks) * 360, 1, 0, 0);
		f10 = 30.0F;
		
		GlStateManager.disableTexture2D();
		float f18 = world.getStarBrightness(partialTicks) * f6;
		
		if (f18 > 0.0F) {
			GlStateManager.color(f18, f18, f18, f18);
			GlStateManager.callList(this.starGLCallList);
		}
		
		GlStateManager.color(1, 1, 1, 1);
		GlStateManager.disableBlend();
		GlStateManager.enableAlpha();
		GlStateManager.enableFog();
		GlStateManager.popMatrix();
		
		GlStateManager.disableTexture2D();
		GlStateManager.color(0, 0, 0);
		
		double d0 = mc.thePlayer.posY - world.getHorizon();
		
		if (d0 < 0.0D) {
			GlStateManager.pushMatrix();
			GlStateManager.translate(0, 12, 0);
			GlStateManager.callList(this.glSkyList2);
			GlStateManager.popMatrix();
			f8 = 1.0F;
			f9 = -((float) (d0 + 65.0D));
			f10 = -f8;
			vertexBuffer.begin(7, DefaultVertexFormats.POSITION);
			vertexBuffer.color(0, 0, 0, 255);
			vertexBuffer.pos((double) (-f8), (double) f9, (double) f8);
			vertexBuffer.pos((double) f8, (double) f9, (double) f8);
			vertexBuffer.pos((double) f8, (double) f10, (double) f8);
			vertexBuffer.pos((double) (-f8), (double) f10, (double) f8);
			vertexBuffer.pos((double) (-f8), (double) f10, (double) (-f8));
			vertexBuffer.pos((double) f8, (double) f10, (double) (-f8));
			vertexBuffer.pos((double) f8, (double) f9, (double) (-f8));
			vertexBuffer.pos((double) (-f8), (double) f9, (double) (-f8));
			vertexBuffer.pos((double) f8, (double) f10, (double) (-f8));
			vertexBuffer.pos((double) f8, (double) f10, (double) f8);
			vertexBuffer.pos((double) f8, (double) f9, (double) f8);
			vertexBuffer.pos((double) f8, (double) f9, (double) (-f8));
			vertexBuffer.pos((double) (-f8), (double) f9, (double) (-f8));
			vertexBuffer.pos((double) (-f8), (double) f9, (double) f8);
			vertexBuffer.pos((double) (-f8), (double) f10, (double) f8);
			vertexBuffer.pos((double) (-f8), (double) f10, (double) (-f8));
			vertexBuffer.pos((double) (-f8), (double) f10, (double) (-f8));
			vertexBuffer.pos((double) (-f8), (double) f10, (double) f8);
			vertexBuffer.pos((double) f8, (double) f10, (double) f8);
			vertexBuffer.pos((double) f8, (double) f10, (double) (-f8));
			tessellator1.draw();
		}
		
		GlStateManager.pushMatrix();
		GlStateManager.translate(0, -((float) (d0 - 16)), 0);
		GlStateManager.callList(this.glSkyList2);
		GlStateManager.popMatrix();
		GlStateManager.enableTexture2D();
		GlStateManager.depthMask(true);
	}
}