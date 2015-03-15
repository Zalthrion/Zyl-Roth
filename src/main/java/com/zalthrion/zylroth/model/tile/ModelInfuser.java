package com.zalthrion.zylroth.model.tile;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/** ModelConverter - Zalthrion Created using Tabula 4.1.0 */
public class ModelInfuser extends ModelBase {
	public ModelRenderer Base;
	
	public ModelInfuser() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.Base = new ModelRenderer(this, 0, 0);
		this.Base.setRotationPoint(-8.0F, 8.0F, -8.0F);
		this.Base.addBox(0.0F, 0.0F, 0.0F, 16, 16, 16, 0.0F);
	}
	
	@Override public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.Base.render(f5);
	}
	
	/** This is a helper function from Tabula to set the rotation of model parts */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
