
package net.mcreator.tnunlimited.client.renderer;

public class KkoreulRenderer extends GeoEntityRenderer<KkoreulEntity> {
	public KkoreulRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new KkoreulModel());
		this.shadowRadius = 0f;
	}

	@Override
	public RenderType getRenderType(KkoreulEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}

	@Override
	protected float getDeathMaxRotation(KkoreulEntity entityLivingBaseIn) {
		return 0.0F;
	}
}