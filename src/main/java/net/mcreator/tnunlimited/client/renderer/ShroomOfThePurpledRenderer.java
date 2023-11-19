
package net.mcreator.tnunlimited.client.renderer;

public class ShroomOfThePurpledRenderer extends GeoEntityRenderer<ShroomOfThePurpledEntity> {
	public ShroomOfThePurpledRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new ShroomOfThePurpledModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(ShroomOfThePurpledEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}

}