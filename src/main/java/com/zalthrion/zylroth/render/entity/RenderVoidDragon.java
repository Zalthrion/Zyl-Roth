package com.zalthrion.zylroth.render.entity;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.zalthrion.zylroth.entity.EntityVoidDragon;
import com.zalthrion.zylroth.model.entity.ModelVoidDragon;
import com.zalthrion.zylroth.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderVoidDragon extends RenderLiving {
	
	private float scale = 0.5F;
	
	private static final ResourceLocation Explosion = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/VoidDragon_exploding.png");
	private static final ResourceLocation Eyes = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/VoidDragon_eyes.png");
	private static final ResourceLocation Dragon = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/VoidDragon.png");
	
	/** An instance of the dragon model in RenderDragon */
	protected ModelVoidDragon modelDragon;
	
	public RenderVoidDragon() {
		super(new ModelVoidDragon(0.0F), 0.3F);
		modelDragon = (ModelVoidDragon) mainModel;
		setRenderPassModel(mainModel);
	}
	
	/** Applies the scale to the transform matrix */
	protected void preRenderScale(EntityVoidDragon dragon, float par2) {
		GL11.glScalef(scale, scale, scale);
	}
	
	/** Used to rotate the dragon as a whole in RenderDragon. It's called in the
	 * rotateCorpse method. */
	protected void rotateDragonBody(EntityVoidDragon dragon, float par2, float par3, float par4) {
		float f3 = (float) dragon.getMovementOffsets(7, par4)[0];
		float f4 = (float) (dragon.getMovementOffsets(5, par4)[1] - dragon.getMovementOffsets(10, par4)[1]);
		GL11.glRotatef(-f3, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(f4 * 10.0F, 1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(0.0F, 0.0F, 1.0F);
		
		if (dragon.deathTime > 0) {
			float f5 = (dragon.deathTime + par4 - 1.0F) / 20.0F * 1.6F;
			f5 = MathHelper.sqrt_float(f5);
			
			if (f5 > 1.0F)
				f5 = 1.0F;
			
			GL11.glRotatef(f5 * getDeathMaxRotation(dragon), 0.0F, 0.0F, 1.0F);
		}
	}
	
	/** Renders the dragon model. Called by renderModel. */
	protected void renderDragonModel(EntityVoidDragon dragon, float par2, float par3, float par4, float par5, float par6, float par7) {
		if (dragon.deathTicks > 0) {
			float f6 = dragon.deathTicks / 200.0F;
			GL11.glDepthFunc(GL11.GL_LEQUAL);
			GL11.glEnable(GL11.GL_ALPHA_TEST);
			GL11.glAlphaFunc(GL11.GL_GREATER, f6);
			GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.9F);
			bindTexture(Explosion);
			mainModel.render(dragon, par2, par3, par4, par5, par6, par7);
			GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
			GL11.glDepthFunc(GL11.GL_EQUAL);
		}
		
		bindEntityTexture(dragon);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		mainModel.render(dragon, par2, par3, par4, par5, par6, par7);
		GL11.glDisable(GL11.GL_BLEND);
		
		if (dragon.hurtTime > 0) {
			GL11.glDepthFunc(GL11.GL_EQUAL);
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glColor4f(1.0F, 0.0F, 0.0F, 0.5F);
			mainModel.render(dragon, par2, par3, par4, par5, par6, par7);
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glDepthFunc(GL11.GL_LEQUAL);
		}
	}
	
	/** Renders the dragon, along with its dying animation */
	public void renderDragon(EntityVoidDragon dragon, double par2, double par4, double par6, float par8, float par9) {
		
		super.doRender(dragon, par2, par4, par6, par8, par9);
		
	}
	
	protected ResourceLocation func_110841_a(EntityVoidDragon dragon) {
		return Dragon;
	}
	
	/** Renders the animation for when an enderdragon dies */
	/* protected void renderDragonDying(EntityVoidDragon dragon, float par2) {
	 * super.renderEquippedItems(dragon, par2); Tessellator tessellator =
	 * Tessellator.instance; if (dragon.deathTicks > 0) {
	 * RenderHelper.disableStandardItemLighting(); float f1 = (dragon.deathTicks
	 * + par2) / 200.0F; float f2 = 0.0F; if (f1 > 0.8F) f2 = (f1 - 0.8F) /
	 * 0.2F; Random random = new Random(432L);
	 * GL11.glDisable(GL11.GL_TEXTURE_2D); GL11.glShadeModel(GL11.GL_SMOOTH);
	 * GL11.glEnable(GL11.GL_BLEND); GL11.glBlendFunc(GL11.GL_SRC_ALPHA,
	 * GL11.GL_ONE); GL11.glDisable(GL11.GL_ALPHA_TEST);
	 * GL11.glEnable(GL11.GL_CULL_FACE); GL11.glDepthMask(false);
	 * GL11.glPushMatrix(); GL11.glTranslatef(0.0F, -1.0F, -2.0F); for (int i =
	 * 0; i < (f1 + f1 * f1) / 2.0F * 60.0F; ++ i) {
	 * GL11.glRotatef(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
	 * GL11.glRotatef(random.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
	 * GL11.glRotatef(random.nextFloat() * 360.0F, 0.0F, 0.0F, 1.0F);
	 * GL11.glRotatef(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
	 * GL11.glRotatef(random.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
	 * GL11.glRotatef(random.nextFloat() * 360.0F + f1 * 90.0F, 0.0F, 0.0F,
	 * 1.0F); tessellator.startDrawing(6); float f3 = random.nextFloat() * 20.0F
	 * + 5.0F + f2 * 10.0F; float f4 = random.nextFloat() * 2.0F + 1.0F + f2 *
	 * 2.0F; tessellator.setColorRGBA_I(16777215, (int) (255.0F * (1.0F - f2)));
	 * tessellator.addVertex(0.0D, 0.0D, 0.0D);
	 * tessellator.setColorRGBA_I(16711935, 0); tessellator.addVertex(-0.866D *
	 * f4, f3, -0.5F * f4); tessellator.addVertex(0.866D * f4, f3, -0.5F * f4);
	 * tessellator.addVertex(0.0D, f3, 1.0F * f4); tessellator.addVertex(-0.866D
	 * * f4, f3, -0.5F * f4); tessellator.draw(); } GL11.glPopMatrix();
	 * GL11.glDepthMask(true); GL11.glDisable(GL11.GL_CULL_FACE);
	 * GL11.glDisable(GL11.GL_BLEND); GL11.glShadeModel(GL11.GL_FLAT);
	 * GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	 * GL11.glEnable(GL11.GL_TEXTURE_2D); GL11.glEnable(GL11.GL_ALPHA_TEST);
	 * RenderHelper.enableStandardItemLighting(); } } */
	
	/** Renders the overlay for glowing eyes and the mouth. Called by
	 * shouldRenderPass. */
	protected int renderGlow(EntityVoidDragon dragon, int par2, float par3) {
		if (par2 == 1)
			GL11.glDepthFunc(GL11.GL_LEQUAL);
		
		if (par2 != 0)
			return -1;
		else {
			bindTexture(Eyes);
			float f1 = 1.0F;
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDisable(GL11.GL_ALPHA_TEST);
			GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glDepthFunc(GL11.GL_EQUAL);
			char c0 = 61680;
			int j = c0 % 65536;
			int k = c0 / 65536;
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, j / 1.0F, k / 1.0F);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, f1);
			return 1;
		}
	}
	
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
		renderDragon((EntityVoidDragon) par1EntityLiving, par2, par4, par6, par8, par9);
	}
	
	/** Queries whether should render the specified pass or not. */
	@Override
	protected int shouldRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3) {
		return renderGlow((EntityVoidDragon) par1EntityLivingBase, par2, par3);
	}
	
	/* @Override protected void renderEquippedItems(EntityLivingBase
	 * par1EntityLivingBase, float par2) { renderDragonDying((EntityVoidDragon)
	 * par1EntityLivingBase, par2); } */
	
	@Override
	protected void rotateCorpse(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4) {
		rotateDragonBody((EntityVoidDragon) par1EntityLivingBase, par2, par3, par4);
	}
	
	/** Renders the model in RenderLiving */
	@Override
	protected void renderModel(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4, float par5, float par6, float par7) {
		renderDragonModel((EntityVoidDragon) par1EntityLivingBase, par2, par3, par4, par5, par6, par7);
	}
	
	public void renderPlayer(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9) {
		renderDragon((EntityVoidDragon) par1EntityLivingBase, par2, par4, par6, par8, par9);
	}
	
	/** Allows the render to do any OpenGL state modifications necessary before
	 * the model is rendered. Args: entityLiving, partialTickTime */
	@Override
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
		preRenderScale((EntityVoidDragon) par1EntityLivingBase, par2);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity) {
		return func_110841_a((EntityVoidDragon) par1Entity);
	}
	
	/** Actually renders the given argument. This is a synthetic bridge method,
	 * always casting down its argument and then handing it off to a worker
	 * function which does the actual work. In all probabilty, the class Render
	 * is generic (Render<T extends Entity) and this method has signature public
	 * void doRender(T entity, double d, double d1, double d2, float f, float
	 * f1). But JAD is pre 1.5 so doesn't do that. */
	@Override
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
		renderDragon((EntityVoidDragon) par1Entity, par2, par4, par6, par8, par9);
	}
	
}