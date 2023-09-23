
package net.mcreator.tnunlimited.client.renderer;

public class FrostAntRenderer extends GeoEntityRenderer<FrostAntEntity> {
	public FrostAntRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new FrostAntModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(FrostAntEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}

}