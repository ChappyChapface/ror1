
package net.mcreator.tnunlimited.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.tnunlimited.entity.model.FrostAntQueenPhase2Model;
import net.mcreator.tnunlimited.entity.FrostAntQueenPhase2Entity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class FrostAntQueenPhase2Renderer extends GeoEntityRenderer<FrostAntQueenPhase2Entity> {
	public FrostAntQueenPhase2Renderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new FrostAntQueenPhase2Model());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(FrostAntQueenPhase2Entity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
