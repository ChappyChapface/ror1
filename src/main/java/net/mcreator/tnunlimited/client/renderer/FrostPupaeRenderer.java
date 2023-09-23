
package net.mcreator.tnunlimited.client.renderer;

public class FrostPupaeRenderer extends GeoEntityRenderer<FrostPupaeEntity> {
	public FrostPupaeRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new FrostPupaeModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(FrostPupaeEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}

}