
package net.mcreator.tnunlimited.client.renderer;

public class CoronerRenderer extends GeoEntityRenderer<CoronerEntity> {
	public CoronerRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new CoronerModel());
		this.shadowRadius = 0.5f;
		this.addLayer(new CoronerLayer(this));
	}

	@Override
	public RenderType getRenderType(CoronerEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}

}