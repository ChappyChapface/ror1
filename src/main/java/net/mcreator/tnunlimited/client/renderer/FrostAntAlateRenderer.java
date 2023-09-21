
package net.mcreator.tnunlimited.client.renderer;

public class FrostAntAlateRenderer extends GeoEntityRenderer<FrostAntAlateEntity> {
	public FrostAntAlateRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new FrostAntAlateModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(FrostAntAlateEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}

}