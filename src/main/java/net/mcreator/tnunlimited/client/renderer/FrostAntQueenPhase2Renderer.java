
package net.mcreator.tnunlimited.client.renderer;

public class FrostAntQueenPhase2Renderer extends GeoEntityRenderer<FrostAntQueenPhase2Entity> {
	public FrostAntQueenPhase2Renderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new FrostAntQueenPhase2Model());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(FrostAntQueenPhase2Entity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}

}