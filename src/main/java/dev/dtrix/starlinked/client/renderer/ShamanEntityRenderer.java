package dev.dtrix.starlinked.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import dev.dtrix.starlinked.entity.ShamanEntity;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CrossedArmsItemLayer;
import net.minecraft.client.renderer.entity.layers.HeadLayer;
import net.minecraft.client.renderer.entity.layers.VillagerLevelPendantLayer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.entity.model.VillagerModel;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.util.ResourceLocation;

public class ShamanEntityRenderer extends MobRenderer<ShamanEntity, VillagerModel<ShamanEntity>> {

    private static final ResourceLocation VILLAGER_TEXTURE = new ResourceLocation("textures/entity/villager/villager.png");

    public ShamanEntityRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new VillagerModel<>(0.0F), 0.5F);
        this.addLayer(new HeadLayer<>(this));
       // this.addLayer(new VillagerLevelPendantLayer<>(this, resourceManagerIn, "villager"));
        this.addLayer(new CrossedArmsItemLayer<>(this));
    }

    @Override
    public ResourceLocation getEntityTexture(ShamanEntity entity) {
        return VILLAGER_TEXTURE;
    }

    @Override
    protected void preRenderCallback(ShamanEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        float f = 0.9375F;
        if (entitylivingbaseIn.isChild()) {
            f = (float)((double)f * 0.5D);
            this.shadowSize = 0.25F;
        } else {
            this.shadowSize = 0.5F;
        }

        matrixStackIn.scale(f, f, f);
    }
}
