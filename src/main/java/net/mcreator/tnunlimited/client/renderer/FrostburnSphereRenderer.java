package net.mcreator.tnunlimited.client.renderer;

public class FrostburnSphereRenderer extends EntityRenderer<FrostburnSphereEntity> {

	private static final ResourceLocation texture = new ResourceLocation("tnunlimited:textures/entities/frostburn_sphere.png");

	private final Modelblood_spheres model;

	public FrostburnSphereRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modelblood_spheres(context.bakeLayer(Modelblood_spheres.LAYER_LOCATION));
	}

	@Override
	public void render(FrostburnSphereEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Vector3f.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
		poseStack.popPose();

		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(FrostburnSphereEntity entity) {
		return texture;
	}

}
