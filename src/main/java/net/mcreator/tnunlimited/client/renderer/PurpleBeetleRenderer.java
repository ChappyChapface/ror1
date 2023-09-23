
package net.mcreator.tnunlimited.client.renderer;

public class PurpleBeetleRenderer extends GeoEntityRenderer<PurpleBeetleEntity> {
	public PurpleBeetleRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new PurpleBeetleModel());
		this.shadowRadius = 0.6f;
	}

	@Override
	public RenderType getRenderType(PurpleBeetleEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}

}