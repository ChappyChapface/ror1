package net.mcreator.tnunlimited.client.renderer;

public class BloodripSpikeRenderer extends EntityRenderer<BloodripSpikeEntity> {

	private static final ResourceLocation texture = new ResourceLocation("tnunlimited:textures/entities/bloodrip_shoot.png");

	private final Modelbloodrip_shoot model;

	public BloodripSpikeRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modelbloodrip_shoot(context.bakeLayer(Modelbloodrip_shoot.LAYER_LOCATION));
	}

	@Override
	public void render(BloodripSpikeEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Vector3f.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
		poseStack.popPose();

		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(BloodripSpikeEntity entity) {
		return texture;
	}

}
