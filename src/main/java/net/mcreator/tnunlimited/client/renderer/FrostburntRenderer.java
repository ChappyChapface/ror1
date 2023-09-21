
package net.mcreator.tnunlimited.client.renderer;

public class FrostburntRenderer extends GeoEntityRenderer<FrostburntEntity> {
	public FrostburntRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new FrostburntModel());
		this.shadowRadius = 0.5f;
		this.addLayer(new FrostburntLayer(this));
	}

	@Override
	public RenderType getRenderType(FrostburntEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}

}