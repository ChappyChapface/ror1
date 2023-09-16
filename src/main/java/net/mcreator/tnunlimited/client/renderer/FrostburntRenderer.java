
package net.mcreator.tnunlimited.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.tnunlimited.entity.model.FrostburntModel;
import net.mcreator.tnunlimited.entity.layer.FrostburntLayer;
import net.mcreator.tnunlimited.entity.FrostburntEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class FrostburntRenderer extends GeoEntityRenderer<FrostburntEntity> {
	public FrostburntRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new FrostburntModel());
		this.shadowRadius = 0.5f;
		this.addLayer(new FrostburntLayer(this));
	}

	@Override
	public RenderType getRenderType(FrostburntEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
