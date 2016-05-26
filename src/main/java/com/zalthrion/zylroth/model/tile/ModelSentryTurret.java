package com.zalthrion.zylroth.model.tile;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * SentryTurret - Zalthrion
 * Created using Tabula 4.1.1
 */
public class ModelSentryTurret extends ModelBase {
    public ModelRenderer BaseBottom;
    public ModelRenderer BaseTop;
    public ModelRenderer TurretHead;
    public ModelRenderer LensProtection;
    public ModelRenderer LensBase;
    public ModelRenderer ProtectionTop;
    public ModelRenderer ProtectionBottom;
    public ModelRenderer ProtectionBack;
    public ModelRenderer ProtectionRight;
    public ModelRenderer ProtectionLeft;
    public ModelRenderer Lens;

    public ModelSentryTurret() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.ProtectionRight = new ModelRenderer(this, 64, 8);
        this.ProtectionRight.setRotationPoint(-1.0F, 1.0F, 1.0F);
        this.ProtectionRight.addBox(0.0F, 0.0F, 0.0F, 1, 6, 6, 0.0F);
        this.LensBase = new ModelRenderer(this, 84, 22);
        this.LensBase.setRotationPoint(2.5F, 2.5F, -2.0F);
        this.LensBase.addBox(0.0F, 0.0F, 0.0F, 3, 3, 2, 0.0F);
        this.Lens = new ModelRenderer(this, 97, 24);
        this.Lens.setRotationPoint(3.5F, 3.5F, -2.2F);
        this.Lens.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.LensProtection = new ModelRenderer(this, 82, 12);
        this.LensProtection.setRotationPoint(1.5F, 1.5F, -1.3F);
        this.LensProtection.addBox(0.0F, 0.0F, 0.0F, 5, 5, 2, 0.0F);
        this.BaseBottom = new ModelRenderer(this, 0, 19);
        this.BaseBottom.setRotationPoint(-5.0F, 23.0F, -5.0F);
        this.BaseBottom.addBox(0.0F, 0.0F, 0.0F, 10, 1, 10, 0.0F);
        this.TurretHead = new ModelRenderer(this, 2, 1);
        this.TurretHead.setRotationPoint(-4.0F, 11.0F, -4.0F);
        this.TurretHead.addBox(0.0F, 0.0F, 0.0F, 8, 8, 8, 0.0F);
        this.BaseTop = new ModelRenderer(this, 32, 18);
        this.BaseTop.setRotationPoint(-4.0F, 22.0F, -4.0F);
        this.BaseTop.addBox(0.0F, 0.0F, 0.0F, 8, 1, 8, 0.0F);
        this.ProtectionBottom = new ModelRenderer(this, 75, 3);
        this.ProtectionBottom.setRotationPoint(1.0F, 8.0F, 1.0F);
        this.ProtectionBottom.addBox(0.0F, 0.0F, 0.0F, 6, 1, 6, 0.0F);
        this.ProtectionTop = new ModelRenderer(this, 75, 3);
        this.ProtectionTop.setRotationPoint(1.0F, -1.0F, 1.0F);
        this.ProtectionTop.addBox(0.0F, 0.0F, 0.0F, 6, 1, 6, 0.0F);
        this.ProtectionBack = new ModelRenderer(this, 99, 13);
        this.ProtectionBack.setRotationPoint(1.0F, 1.0F, 8.0F);
        this.ProtectionBack.addBox(0.0F, 0.0F, 0.0F, 6, 6, 1, 0.0F);
        this.ProtectionLeft = new ModelRenderer(this, 64, 8);
        this.ProtectionLeft.setRotationPoint(8.0F, 1.0F, 1.0F);
        this.ProtectionLeft.addBox(0.0F, 0.0F, 0.0F, 1, 6, 6, 0.0F);
        this.TurretHead.addChild(this.ProtectionRight);
        this.TurretHead.addChild(this.LensBase);
        this.TurretHead.addChild(this.Lens);
        this.TurretHead.addChild(this.LensProtection);
        this.TurretHead.addChild(this.ProtectionBottom);
        this.TurretHead.addChild(this.ProtectionTop);
        this.TurretHead.addChild(this.ProtectionBack);
        this.TurretHead.addChild(this.ProtectionLeft);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.BaseBottom.render(f5);
        this.TurretHead.render(f5);
        this.BaseTop.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
