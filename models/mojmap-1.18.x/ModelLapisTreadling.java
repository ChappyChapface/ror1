// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelLapisTreadling<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "lapistreadling"), "main");
	private final ModelPart frontLeft;
	private final ModelPart frontRight;
	private final ModelPart backRight;
	private final ModelPart backLeft;
	private final ModelPart Bod;

	public ModelLapisTreadling(ModelPart root) {
		this.frontLeft = root.getChild("frontLeft");
		this.frontRight = root.getChild("frontRight");
		this.backRight = root.getChild("backRight");
		this.backLeft = root.getChild("backLeft");
		this.Bod = root.getChild("Bod");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition frontLeft = partdefinition.addOrReplaceChild("frontLeft", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-2.0F, -2.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(5.0F, 21.0F, -4.0F));

		PartDefinition frontRight = partdefinition.addOrReplaceChild("frontRight",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-2.0F, -2.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-5.0F, 21.0F, -4.0F));

		PartDefinition backRight = partdefinition.addOrReplaceChild("backRight",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-2.0F, -2.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-5.0F, 21.0F, 4.0F));

		PartDefinition backLeft = partdefinition.addOrReplaceChild("backLeft", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-2.0F, -2.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(5.0F, 21.0F, 4.0F));

		PartDefinition Bod = partdefinition.addOrReplaceChild("Bod",
				CubeListBuilder.create().texOffs(3, 35)
						.addBox(-3.0F, 2.0F, -1.0F, 6.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-8.0F, -3.0F, 0.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 8.0F, -8.0F));

		PartDefinition cube_r1 = Bod.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(35, 32).addBox(-1.0F, -1.0F, -11.0F, 2.0F, 2.0F, 12.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 11.0F, 16.0F, 2.8362F, 0.0F, 0.0F));

		PartDefinition cube_r2 = Bod
				.addOrReplaceChild("cube_r2",
						CubeListBuilder.create().texOffs(35, 32).addBox(-2.0F, -1.0F, -11.0F, 2.0F, 2.0F, 12.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(8.0F, 8.0F, 3.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition cube_r3 = Bod
				.addOrReplaceChild("cube_r3",
						CubeListBuilder.create().texOffs(35, 32).addBox(0.0F, 0.0F, -11.0F, 2.0F, 2.0F, 12.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(-8.0F, 8.0F, 3.0F, 0.0F, 0.2618F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 46);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		frontLeft.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		frontRight.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		backRight.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		backLeft.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Bod.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.frontRight.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.frontLeft.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.backLeft.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.backRight.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}