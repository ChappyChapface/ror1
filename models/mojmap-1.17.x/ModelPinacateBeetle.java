// Made with Blockbench 4.1.1
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelPinacateBeetle<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "pinacatebeetle"), "main");
	private final ModelPart Head;
	private final ModelPart FrontRightLeg;
	private final ModelPart MidRightLeg;
	private final ModelPart BackRightLeg;
	private final ModelPart FrontLeftLeg;
	private final ModelPart MidLeftLeg;
	private final ModelPart BackLeftLeg;
	private final ModelPart bb_main;

	public ModelPinacateBeetle(ModelPart root) {
		this.Head = root.getChild("Head");
		this.FrontRightLeg = root.getChild("FrontRightLeg");
		this.MidRightLeg = root.getChild("MidRightLeg");
		this.BackRightLeg = root.getChild("BackRightLeg");
		this.FrontLeftLeg = root.getChild("FrontLeftLeg");
		this.MidLeftLeg = root.getChild("MidLeftLeg");
		this.BackLeftLeg = root.getChild("BackLeftLeg");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(26, 23).addBox(
				-2.5F, -2.5F, -5.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.5F, -7.0F));

		PartDefinition cube_r1 = Head.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(24, 22).mirror()
						.addBox(-0.5F, -5.0F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(2.0F, -1.5F, -4.5F, 0.9724F, -0.4515F, 0.0894F));

		PartDefinition cube_r2 = Head.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(24, 22).addBox(-0.5F, -5.0F, -0.5F, 1.0F, 5.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, -1.5F, -4.5F, 0.9724F, 0.4515F, -0.0894F));

		PartDefinition FrontRightLeg = partdefinition.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create(),
				PartPose.offset(-2.5F, 19.0F, -4.0F));

		PartDefinition cube_r3 = FrontRightLeg.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0873F, -0.6109F, -0.6109F));

		PartDefinition MidRightLeg = partdefinition.addOrReplaceChild("MidRightLeg", CubeListBuilder.create(),
				PartPose.offset(-2.5F, 19.0F, 2.0F));

		PartDefinition cube_r4 = MidRightLeg
				.addOrReplaceChild("cube_r4",
						CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition BackRightLeg = partdefinition.addOrReplaceChild("BackRightLeg", CubeListBuilder.create(),
				PartPose.offset(-2.5F, 19.0F, 5.0F));

		PartDefinition cube_r5 = BackRightLeg.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0873F, 0.6109F, -0.6109F));

		PartDefinition FrontLeftLeg = partdefinition.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create(),
				PartPose.offset(2.5F, 19.0F, -4.0F));

		PartDefinition cube_r6 = FrontLeftLeg.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-1.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0873F, 0.6109F, 0.6109F));

		PartDefinition MidLeftLeg = partdefinition.addOrReplaceChild("MidLeftLeg", CubeListBuilder.create(),
				PartPose.offset(2.5F, 19.0F, 1.0F));

		PartDefinition cube_r7 = MidLeftLeg.addOrReplaceChild("cube_r7",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-1.0F, -1.0F, 0.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition BackLeftLeg = partdefinition.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create(),
				PartPose.offset(2.5F, 19.0F, 6.0F));

		PartDefinition cube_r8 = BackLeftLeg.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-1.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.0873F, -0.6109F, 0.6109F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main",
				CubeListBuilder.create().texOffs(0, 22)
						.addBox(-3.5F, -10.0F, -7.0F, 7.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(-4.5F, -11.0F, -1.0F, 9.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 46, 33);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Head.render(poseStack, buffer, packedLight, packedOverlay);
		FrontRightLeg.render(poseStack, buffer, packedLight, packedOverlay);
		MidRightLeg.render(poseStack, buffer, packedLight, packedOverlay);
		BackRightLeg.render(poseStack, buffer, packedLight, packedOverlay);
		FrontLeftLeg.render(poseStack, buffer, packedLight, packedOverlay);
		MidLeftLeg.render(poseStack, buffer, packedLight, packedOverlay);
		BackLeftLeg.render(poseStack, buffer, packedLight, packedOverlay);
		bb_main.render(poseStack, buffer, packedLight, packedOverlay);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.FrontRightLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
		this.BackLeftLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.FrontLeftLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.MidLeftLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.MidRightLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.BackRightLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}