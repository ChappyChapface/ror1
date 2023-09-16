
package net.mcreator.tnunlimited.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.tnunlimited.entity.model.KkoreulMinionModel;
import net.mcreator.tnunlimited.entity.KkoreulMinionEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class KkoreulMinionRenderer extends GeoEntityRenderer<KkoreulMinionEntity> {
	public KkoreulMinionRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new KkoreulMinionModel());
		this.shadowRadius = 0.3f;
	}

	@Override
	public RenderType getRenderType(KkoreulMinionEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
