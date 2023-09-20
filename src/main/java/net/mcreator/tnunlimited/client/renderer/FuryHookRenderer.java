package net.mcreator.tnunlimited.client.renderer;

public class FuryHookRenderer extends EntityRenderer<FuryHookEntity> {

	private static final ResourceLocation texture = new ResourceLocation("tnunlimited:textures/entities/furyhook.png");

	private final ModelFuryHook_Converted model;

	public FuryHookRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new ModelFuryHook_Converted(context.bakeLayer(ModelFuryHook_Converted.LAYER_LOCATION));
	}

	@Override
	public void render(FuryHookEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Vector3f.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
		poseStack.popPose();

		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(FuryHookEntity entity) {
		return texture;
	}

}
