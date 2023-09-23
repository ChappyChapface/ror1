
package net.mcreator.tnunlimited.client.renderer;

public class FrostSpikeEnityRenderer extends GeoEntityRenderer<FrostSpikeEnityEntity> {
	public FrostSpikeEnityRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new FrostSpikeEnityModel());
		this.shadowRadius = 0f;
	}

	@Override
	public RenderType getRenderType(FrostSpikeEnityEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}

}