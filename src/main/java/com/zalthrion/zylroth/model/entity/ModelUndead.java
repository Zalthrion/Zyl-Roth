package com.zalthrion.zylroth.model.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelSkeleton - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class ModelUndead extends ModelBiped {

    public ModelUndead() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.bipedRightLeg = new ModelRenderer(this, 0, 16);
        this.bipedRightLeg.setRotationPoint(-2.0F, 12.0F, 0.10000000149011612F);
        this.bipedRightLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F);
        this.bipedHead = new ModelRenderer(this, 0, 0);
        this.bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.bipedLeftArm = new ModelRenderer(this, 40, 16);
        this.bipedLeftArm.mirror = true;
        this.bipedLeftArm.setRotationPoint(5.0F, 2.0F, -0.0F);
        this.bipedLeftArm.addBox(-1.0F, -2.0F, -1.0F, 2, 12, 2, 0.0F);
        this.setRotateAngle(bipedLeftArm, -1.5707963705062866F, 0.10000000149011613F, -0.10000000149011613F);
        this.bipedRightArm = new ModelRenderer(this, 40, 16);
        this.bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.bipedRightArm.addBox(-1.0F, -2.0F, -1.0F, 2, 12, 2, 0.0F);
        this.setRotateAngle(bipedRightArm, -1.5707963705062866F, -0.10000000149011613F, 0.10000000149011613F);
        this.bipedBody = new ModelRenderer(this, 16, 16);
        this.bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
        this.bipedLeftLeg.mirror = true;
        this.bipedLeftLeg.setRotationPoint(2.0F, 12.0F, 0.10000000149011612F);
        this.bipedLeftLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.bipedRightLeg.render(f5);
        this.bipedHead.render(f5);
        this.bipedLeftArm.render(f5);
        this.bipedRightArm.render(f5);
        this.bipedBody.render(f5);
        this.bipedLeftLeg.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
	@Override
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
        super.setRotationAngles(par1, par2, par3, par4, par5, par5, par7Entity);
        
        this.bipedRightArm.rotateAngleZ = 0.05F;
        this.bipedLeftArm.rotateAngleZ = -0.05F;
	}
}
