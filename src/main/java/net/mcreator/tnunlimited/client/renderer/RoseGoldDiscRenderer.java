package net.mcreator.tnunlimited.client.renderer;

public class RoseGoldDiscRenderer extends EntityRenderer<RoseGoldDiscEntity> {

	private static final ResourceLocation texture = new ResourceLocation("tnunlimited:textures/entities/rose_gold_disc.png");

	private final Modelrose_gold_disk model;

	public RoseGoldDiscRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modelrose_gold_disk(context.bakeLayer(Modelrose_gold_disk.LAYER_LOCATION));
	}

	@Override
	public void render(RoseGoldDiscEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Vector3f.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
		poseStack.popPose();

		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(RoseGoldDiscEntity entity) {
		return texture;
	}

}
