
package net.mcreator.tnunlimited.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.tnunlimited.entity.model.CoronerModel;
import net.mcreator.tnunlimited.entity.layer.CoronerLayer;
import net.mcreator.tnunlimited.entity.CoronerEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class CoronerRenderer extends GeoEntityRenderer<CoronerEntity> {
	public CoronerRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new CoronerModel());
		this.shadowRadius = 0.5f;
		this.addLayer(new CoronerLayer(this));
	}

	@Override
	public RenderType getRenderType(CoronerEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
