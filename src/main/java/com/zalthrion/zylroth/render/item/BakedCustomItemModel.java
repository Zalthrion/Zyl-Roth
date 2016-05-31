package com.zalthrion.zylroth.render.item;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.vecmath.Matrix4f;
import javax.vecmath.Vector3f;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IPerspectiveAwareModel;
import net.minecraftforge.common.model.TRSRTransformation;

import org.apache.commons.lang3.tuple.Pair;

import com.google.common.collect.ImmutableMap;
import com.zalthrion.zylroth.item.tools.others.WoodenCrossbow;
import com.zalthrion.zylroth.model.item.ModelCrossbow;
import com.zalthrion.zylroth.reference.Reference;

public class BakedCustomItemModel implements IBakedModel, IPerspectiveAwareModel {
	private IBakedModel baseModel;
	private ItemStack stack;
	private TransformType prevTransform;
	private Minecraft mc = Minecraft.getMinecraft();
	
	public static Map<TransformType, TRSRTransformation> transforms = ImmutableMap.<TransformType, TRSRTransformation>builder()
            .put(TransformType.GUI,                         get(0, 0, 0, 30, 45, 0, 0.625f))
            .put(TransformType.THIRD_PERSON_RIGHT_HAND,     get(0, 2.5f, 0, 75, 45, 0, 0.375f))
            .put(TransformType.THIRD_PERSON_LEFT_HAND,      get(0, 2.5f, 0, 75, 45, 0, 0.375f))
            .put(TransformType.FIRST_PERSON_RIGHT_HAND,     get(0, 0, 0, 0, 45, 0, 0.4f))
            .put(TransformType.FIRST_PERSON_LEFT_HAND,      get(0, 0, 0, 0, 225, 0, 0.4f))
            .put(TransformType.GROUND,                      get(0, 2, 0, 0, 0, 0, 0.25f))
            .put(TransformType.HEAD,                        get(0, 0, 0, 0, 0, 0, 1))
            .put(TransformType.FIXED,                       get(0, 0, 0, 0, 0, 0, 1))
            .build();
	
	public static ModelCrossbow crossbow = new ModelCrossbow();
	public static ResourceLocation crossbowTexture = new ResourceLocation(Reference.RESOURCE_PREFIX + "textures/items/woodenCrossbow.png");
	
	public BakedCustomItemModel(IBakedModel model, ItemStack s) {
		this.baseModel = model;
		this.stack = s;
	}
	
	private static TRSRTransformation get(float tx, float ty, float tz, float ax, float ay, float az, float s) {
		return new TRSRTransformation(new Vector3f(tx / 16, ty / 16, tz / 16), TRSRTransformation.quatFromXYZDegrees(new Vector3f(ax, ay, az)), new Vector3f(s, s, s), null);
	}
	
	private void doRender(TransformType type) {
		if (type == TransformType.GUI) GlStateManager.rotate(90, 0, 1, 0);
		
		if (stack.getItem() instanceof WoodenCrossbow) {
			GlStateManager.pushMatrix();
			GlStateManager.rotate(180, 0, 0, 1);
			GlStateManager.rotate(90, 0, -1, 0);
			GlStateManager.translate(0.2F, -0.35F, 0);
			mc.renderEngine.bindTexture(crossbowTexture);
			crossbow.render(0.0625F);
			GlStateManager.popMatrix();
		}
	}
	
	@Override public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {
		if (side != null) {
			List<BakedQuad> faceQuads = new LinkedList<BakedQuad>();
			if (Block.getBlockFromItem(stack.getItem()) != null) {
				faceQuads.addAll(baseModel.getQuads(state, side, rand));
			}
			
			return faceQuads;
		}
		return new LinkedList<BakedQuad>();
	}
	
	@Override public boolean isAmbientOcclusion() {
		return baseModel.isAmbientOcclusion();
	}
	
	@Override public boolean isGui3d() {
		return baseModel.isGui3d();
	}
	
	@Override public boolean isBuiltInRenderer() {
		return baseModel.isBuiltInRenderer();
	}
	
	@Override public TextureAtlasSprite getParticleTexture() {
		return baseModel.getParticleTexture();
	}
	
	@Override public ItemCameraTransforms getItemCameraTransforms() {
		return baseModel.getItemCameraTransforms();
	}
	
	@Override public Pair<? extends IPerspectiveAwareModel, Matrix4f> handlePerspective(ItemCameraTransforms.TransformType cameraTransformType) {
		prevTransform = cameraTransformType;
		
		return Pair.of(this, transforms.get(cameraTransformType).getMatrix());
	}
	
	@Override public ItemOverrideList getOverrides() {
		return ItemOverrideList.NONE;
	}
}