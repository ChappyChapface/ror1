// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelCoffeePotBug1<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "coffeepotbug1"), "main");
	private final ModelPart left0;
	private final ModelPart left1;
	private final ModelPart left2;
	private final ModelPart left3;
	private final ModelPart right0;
	private final ModelPart right1;
	private final ModelPart right2;
	private final ModelPart right3;
	private final ModelPart bb_main;

	public ModelCoffeePotBug1(ModelPart root) {
		this.left0 = root.getChild("left0");
		this.left1 = root.getChild("left1");
		this.left2 = root.getChild("left2");
		this.left3 = root.getChild("left3");
		this.right0 = root.getChild("right0");
		this.right1 = root.getChild("right1");
		this.right2 = root.getChild("right2");
		this.right3 = root.getChild("right3");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition left0 = partdefinition.addOrReplaceChild("left0",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(2.5F, 20.0F, -3.0F));

		PartDefinition left1 = partdefinition.addOrReplaceChild("left1",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(2.5F, 20.0F, -1.0F));

		PartDefinition left2 = partdefinition.addOrReplaceChild("left2",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(2.5F, 20.0F, 1.0F));

		PartDefinition left3 = partdefinition.addOrReplaceChild("left3",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(2.5F, 20.0F, 3.0F));

		PartDefinition right0 = partdefinition.addOrReplaceChild("right0", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-0.5F, 0.0F, -2.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-2.5F, 20.0F, -1.0F));

		PartDefinition right1 = partdefinition.addOrReplaceChild("right1", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-0.5F, 0.0F, -2.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-2.5F, 20.0F, 1.0F));

		PartDefinition right2 = partdefinition.addOrReplaceChild("right2", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-2.5F, 20.0F, 1.0F));

		PartDefinition right3 = partdefinition.addOrReplaceChild("right3", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-2.5F, 20.0F, 3.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-3.0F, -7.0F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(19, 0)
						.addBox(-3.0F, -7.0F, -4.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).texOffs(19, 0)
						.addBox(1.0F, -7.0F, -4.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).texOffs(4, 0)
						.addBox(0.0F, -5.0F, -4.5F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 27, 16);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		left0.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right0.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.right0.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.right1.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.right2.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.right3.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.left0.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.left2.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.left1.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.left3.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}