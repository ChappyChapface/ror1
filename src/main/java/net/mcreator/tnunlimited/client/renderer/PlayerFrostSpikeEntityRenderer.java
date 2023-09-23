
package net.mcreator.tnunlimited.client.renderer;

public class PlayerFrostSpikeEntityRenderer extends GeoEntityRenderer<PlayerFrostSpikeEntityEntity> {
	public PlayerFrostSpikeEntityRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new PlayerFrostSpikeEntityModel());
		this.shadowRadius = 0f;
	}

	@Override
	public RenderType getRenderType(PlayerFrostSpikeEntityEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}

}