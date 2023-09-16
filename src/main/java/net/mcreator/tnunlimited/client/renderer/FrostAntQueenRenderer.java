
package net.mcreator.tnunlimited.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.tnunlimited.procedures.FrostAntQueenEntityVisualScaleProcedure;
import net.mcreator.tnunlimited.entity.model.FrostAntQueenModel;
import net.mcreator.tnunlimited.entity.FrostAntQueenEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class FrostAntQueenRenderer extends GeoEntityRenderer<FrostAntQueenEntity> {
	public FrostAntQueenRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new FrostAntQueenModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(FrostAntQueenEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		float scale = (float) FrostAntQueenEntityVisualScaleProcedure.execute(entity);
		stack.scale(scale, scale, scale);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}

	@Override
	protected float getDeathMaxRotation(FrostAntQueenEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
