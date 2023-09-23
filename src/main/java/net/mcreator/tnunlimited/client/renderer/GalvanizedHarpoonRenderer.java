package net.mcreator.tnunlimited.client.renderer;

public class GalvanizedHarpoonRenderer extends EntityRenderer<GalvanizedHarpoonEntity> {

	private static final ResourceLocation texture = new ResourceLocation("tnunlimited:textures/entities/galvanizedharpoon.png");

	private final ModelGalvanizedHarpoon model;

	public GalvanizedHarpoonRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new ModelGalvanizedHarpoon(context.bakeLayer(ModelGalvanizedHarpoon.LAYER_LOCATION));
	}

	@Override
	public void render(GalvanizedHarpoonEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Vector3f.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
		poseStack.popPose();

		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(GalvanizedHarpoonEntity entity) {
		return texture;
	}

}
