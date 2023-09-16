
package net.mcreator.tnunlimited.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.tnunlimited.entity.model.FrostSpikeEnityModel;
import net.mcreator.tnunlimited.entity.FrostSpikeEnityEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class FrostSpikeEnityRenderer extends GeoEntityRenderer<FrostSpikeEnityEntity> {
	public FrostSpikeEnityRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new FrostSpikeEnityModel());
		this.shadowRadius = 0f;
	}

	@Override
	public RenderType getRenderType(FrostSpikeEnityEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
