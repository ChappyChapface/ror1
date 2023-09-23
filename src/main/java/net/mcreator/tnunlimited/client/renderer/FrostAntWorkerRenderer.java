
package net.mcreator.tnunlimited.client.renderer;

public class FrostAntWorkerRenderer extends GeoEntityRenderer<FrostAntWorkerEntity> {
	public FrostAntWorkerRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new FrostAntWorkerModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(FrostAntWorkerEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}

}