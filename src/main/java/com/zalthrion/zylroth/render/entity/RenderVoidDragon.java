package com.zalthrion.zylroth.render.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

import com.zalthrion.zylroth.entity.EntityVoidDragon;
import com.zalthrion.zylroth.model.entity.ModelVoidDragon;
import com.zalthrion.zylroth.reference.Reference;

@SideOnly(Side.CLIENT)
public class RenderVoidDragon extends RenderLiving<EntityVoidDragon> {
	private float scale = 0.5F;
	
	private static final ResourceLocation explosionTexture = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/VoidDragon_exploding.png");
	private static final ResourceLocation eyesTexture = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/VoidDragon_eyes.png");
	private static final ResourceLocation dragonTexture = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/VoidDragon.png");
	
	/** An instance of the dragon model in RenderDragon */
	protected ModelVoidDragon modelDragon;
	
	public RenderVoidDragon(RenderManager renderManager) {
		super(renderManager, new ModelVoidDragon(0.0F), 0.3F);
		modelDragon = (ModelVoidDragon) mainModel;
		this.addLayer(new LayerHeldItem(this));
	}
	
	/** Applies the scale to the transform matrix */
	@Override protected void preRenderCallback(EntityVoidDragon dragon, float par2) {
		GlStateManager.scale(scale, scale, scale);
	}
	
	/** Used to rotate the dragon as a whole in RenderDragon. It's called in the
	 * rotateCorpse method. */
	@Override protected void rotateCorpse(EntityVoidDragon dragon, float par2, float par3, float par4) {
		float f3 = (float) dragon.getMovementOffsets(7, par4)[0];
		float f4 = (float) (dragon.getMovementOffsets(5, par4)[1] - dragon.getMovementOffsets(10, par4)[1]);
		GlStateManager.rotate(-f3, 0, 1, 0);
		GlStateManager.rotate(f4 * 10, 1, 0, 0);
		GlStateManager.translate(0, 0, 1);
		
		if (dragon.deathTime > 0) {
			float f5 = (dragon.deathTime + par4 - 1.0F) / 20.0F * 1.6F;
			f5 = MathHelper.sqrt_float(f5);
			
			if (f5 > 1.0F) f5 = 1.0F;
			
			GlStateManager.rotate(f5 * getDeathMaxRotation(dragon), 0, 0, 1);
		}
	}
	
	@Override protected void renderModel(EntityVoidDragon dragon, float par2, float par3, float par4, float par5, float par6, float par7) {
		if (dragon.deathTicks > 0) {
			float f6 = dragon.deathTicks / 200.0F;
			GlStateManager.depthFunc(GL11.GL_LEQUAL);
			GlStateManager.enableAlpha();
			GlStateManager.alphaFunc(GL11.GL_GREATER, f6);
			GlStateManager.color(0.0F, 0.0F, 0.0F, 0.9F);
			bindTexture(explosionTexture);
			mainModel.render(dragon, par2, par3, par4, par5, par6, par7);
			GlStateManager.alphaFunc(GL11.GL_GREATER, 0.1F);
			GlStateManager.depthFunc(GL11.GL_EQUAL);
		}
		
		bindEntityTexture(dragon);
		GlStateManager.enableBlend();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 0.5F);
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		mainModel.render(dragon, par2, par3, par4, par5, par6, par7);
		GlStateManager.disableBlend();
		
		if (dragon.hurtTime > 0) {
			GlStateManager.depthFunc(GL11.GL_EQUAL);
			GlStateManager.disableTexture2D();
			GlStateManager.enableBlend();
			GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GlStateManager.color(1, 0, 0, 0.5F);
			mainModel.render(dragon, par2, par3, par4, par5, par6, par7);
			GlStateManager.enableTexture2D();
			GlStateManager.disableBlend();
			GlStateManager.depthFunc(GL11.GL_LEQUAL);
		}
	}
	
	/** Renders the dragon, along with its dying animation */
	@Override public void doRender(EntityVoidDragon dragon, double par2, double par4, double par6, float par8, float par9) {
		super.doRender(dragon, par2, par4, par6, par8, par9);
	}
	
	@Override protected ResourceLocation getEntityTexture(EntityVoidDragon dragon) {
		return dragonTexture;
	}
	
	/** Renders the animation for when an enderdragon dies */
/*	protected void renderDragonDying(EntityVoidDragon dragon, float par2) {
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer wr = tessellator.getWorldRenderer();
		
		if (dragon.deathTicks > 0) {
			RenderHelper.disableStandardItemLighting();
			float f1 = (dragon.deathTicks + par2) / 200.0F;
			float f2 = 0.0F;
			
			if (f1 > 0.8F) f2 = (f1 - 0.8F) / 0.2F;
			
			Random random = new Random(432L);
			GlStateManager.disableTexture2D();
			GlStateManager.shadeModel(GL11.GL_SMOOTH);
			GlStateManager.enableBlend();
			GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
			GlStateManager.disableAlpha();
			GlStateManager.enableCull();
			GlStateManager.depthMask(false);
			GlStateManager.pushMatrix();
			GlStateManager.translate(0, -1, -2);
			
			for (int i = 0; i < (f1 + f1 * f1) / 2.0F * 60.0F; ++ i) {
				GlStateManager.rotate(random.nextFloat() * 360, 1, 0, 0);
				GlStateManager.rotate(random.nextFloat() * 360, 0, 1, 0);
				GlStateManager.rotate(random.nextFloat() * 360, 0, 0, 1);
				GlStateManager.rotate(random.nextFloat() * 360, 1, 0, 0);
				GlStateManager.rotate(random.nextFloat() * 360, 0, 1, 0);
				GlStateManager.rotate(random.nextFloat() * 360 + f1 * 90, 0, 0, 1);
				wr.startDrawing(6);
				float f3 = random.nextFloat() * 20.0F + 5.0F + f2 * 10.0F;
				float f4 = random.nextFloat() * 2.0F + 1.0F + f2 * 2.0F;
				wr.setColorRGBA_I(16777215, (int) (255.0F * (1.0F - f2)));
				wr.addVertex(0.0D, 0.0D, 0.0D);
				wr.setColorRGBA_I(16711935, 0);
				wr.addVertex(-0.866D * f4, f3, -0.5F * f4);
				wr.addVertex(0.866D * f4, f3, -0.5F * f4);
				wr.addVertex(0.0D, f3, 1.0F * f4);
				wr.addVertex(-0.866D * f4, f3, -0.5F * f4);
				tessellator.draw();
			}
			
			GlStateManager.popMatrix();
			GlStateManager.depthMask(true);
			GlStateManager.disableCull();
			GlStateManager.disableBlend();
			GlStateManager.shadeModel(GL11.GL_FLAT);
			GlStateManager.color(1, 1, 1, 1);
			GlStateManager.enableTexture2D();
			GlStateManager.enableAlpha();
			RenderHelper.enableStandardItemLighting();
		}
	}*/
	
	/** Renders the overlay for glowing eyes and the mouth. Called by
	 * shouldRenderPass. */
	protected int renderGlow(EntityVoidDragon dragon, int par2, float par3) {
		if (par2 == 1) GlStateManager.depthFunc(GL11.GL_LEQUAL);
		
		if (par2 != 0)
			return -1;
		else {
			bindTexture(eyesTexture);
			float f1 = 1.0F;
			GlStateManager.enableBlend();
			GlStateManager.disableAlpha();
			GlStateManager.blendFunc(GL11.GL_ONE, GL11.GL_ONE);
			GlStateManager.disableLighting();
			GlStateManager.depthFunc(GL11.GL_EQUAL);
			char c0 = 61680;
			int j = c0 % 65536;
			int k = c0 / 65536;
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, j / 1.0F, k / 1.0F);
			GlStateManager.color(1, 1, 1, 1);
			GlStateManager.enableLighting();
			GlStateManager.color(1, 1, 1, f1);
			return 1;
		}
	}
}