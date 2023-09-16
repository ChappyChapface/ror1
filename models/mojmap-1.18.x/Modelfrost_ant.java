// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelfrost_ant<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "frost_ant"), "main");
	private final ModelPart Head;
	private final ModelPart LeftLeg1;
	private final ModelPart LeftLeg2;
	private final ModelPart LeftLeg3;
	private final ModelPart RightLeg1;
	private final ModelPart RightLeg2;
	private final ModelPart RightLeg3;
	private final ModelPart bb_main;

	public Modelfrost_ant(ModelPart root) {
		this.Head = root.getChild("Head");
		this.LeftLeg1 = root.getChild("LeftLeg1");
		this.LeftLeg2 = root.getChild("LeftLeg2");
		this.LeftLeg3 = root.getChild("LeftLeg3");
		this.RightLeg1 = root.getChild("RightLeg1");
		this.RightLeg2 = root.getChild("RightLeg2");
		this.RightLeg3 = root.getChild("RightLeg3");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(46, 0)
						.addBox(-4.0F, -4.0F, -8.1172F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(38, 33)
						.addBox(-4.0F, -4.0F, -8.1172F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)),
				PartPose.offset(0.0F, 12.0F, -5.8828F));

		PartDefinition cube_r1 = Head.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, -11.0F, -16.0F, 0.0F, 12.0F, 19.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.8F, -5.0F, -6.1172F, 0.0F, -0.48F, 0.0F));

		PartDefinition cube_r2 = Head.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, -11.0F, -16.0F, 0.0F, 12.0F, 19.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.2F, -5.0F, -6.1172F, 0.0F, 0.48F, 0.0F));

		PartDefinition LeftLeg1 = partdefinition.addOrReplaceChild("LeftLeg1", CubeListBuilder.create(),
				PartPose.offset(4.7961F, 10.9392F, -5.9736F));

		PartDefinition cube_r3 = LeftLeg1.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -6.0F, -1.5F, 3.0F, 14.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.7039F, 5.0608F, -0.8264F, -0.1745F, 0.0F, -0.3054F));

		PartDefinition LeftLeg2 = partdefinition.addOrReplaceChild("LeftLeg2", CubeListBuilder.create(),
				PartPose.offset(4.7961F, 10.9392F, -1.4F));

		PartDefinition cube_r4 = LeftLeg2.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -6.0F, -1.5F, 3.0F, 14.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.7039F, 5.0608F, 0.0F, 0.0F, 0.0F, -0.3054F));

		PartDefinition LeftLeg3 = partdefinition.addOrReplaceChild("LeftLeg3", CubeListBuilder.create(),
				PartPose.offset(4.7961F, 10.9392F, 3.2F));

		PartDefinition cube_r5 = LeftLeg3.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -6.0F, -1.5F, 3.0F, 14.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.7039F, 5.0608F, 0.9F, 0.1745F, 0.0F, -0.3054F));

		PartDefinition RightLeg1 = partdefinition.addOrReplaceChild("RightLeg1", CubeListBuilder.create(),
				PartPose.offset(-4.7961F, 10.9392F, -5.9736F));

		PartDefinition cube_r6 = RightLeg1.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-1.5F, -6.0F, -1.5F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-2.7039F, 5.0608F, -0.8264F, -0.1745F, 0.0F, 0.3054F));

		PartDefinition RightLeg2 = partdefinition.addOrReplaceChild("RightLeg2", CubeListBuilder.create(),
				PartPose.offset(-4.7961F, 10.9392F, -1.4F));

		PartDefinition cube_r7 = RightLeg2.addOrReplaceChild("cube_r7",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-1.5F, -6.0F, -1.5F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-2.7039F, 5.0608F, 0.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition RightLeg3 = partdefinition.addOrReplaceChild("RightLeg3", CubeListBuilder.create(),
				PartPose.offset(-4.7961F, 10.9392F, 3.2F));

		PartDefinition cube_r8 = RightLeg3.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-1.5F, -6.0F, -1.5F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-2.7039F, 5.0608F, 0.9F, 0.1745F, 0.0F, 0.3054F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main",
				CubeListBuilder.create().texOffs(0, 33)
						.addBox(-5.0F, -17.0F, -6.0F, 10.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-7.0F, -23.0F, 3.0F, 14.0F, 15.0F, 18.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
		this.RightLeg3.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.RightLeg2.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.LeftLeg2.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.RightLeg1.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.LeftLeg1.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.LeftLeg3.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}