// Made with Blockbench 4.1.1
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelWastelandish_Hopper<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "wastelandish_hopper"), "main");
	private final ModelPart head;
	private final ModelPart FrontLegs;
	private final ModelPart MidRight;
	private final ModelPart BackLegs;
	private final ModelPart MidLeft;
	private final ModelPart Body;

	public ModelWastelandish_Hopper(ModelPart root) {
		this.head = root.getChild("head");
		this.FrontLegs = root.getChild("FrontLegs");
		this.MidRight = root.getChild("MidRight");
		this.BackLegs = root.getChild("BackLegs");
		this.MidLeft = root.getChild("MidLeft");
		this.Body = root.getChild("Body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 8)
						.addBox(-2.0F, -1.0F, -2.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(12, 8)
						.addBox(1.0F, -3.0F, -1.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(12, 8).mirror()
						.addBox(-2.0F, -3.0F, -1.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(0.0F, 21.0F, -2.0F));

		PartDefinition FrontLegs = partdefinition.addOrReplaceChild("FrontLegs",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-2.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0).mirror()
						.addBox(1.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(0.0F, 22.0F, -1.5F));

		PartDefinition MidRight = partdefinition.addOrReplaceChild("MidRight", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.5F, 22.0F, 0.5F));

		PartDefinition BackLegs = partdefinition.addOrReplaceChild("BackLegs",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-2.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0).mirror()
						.addBox(1.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(0.0F, 22.0F, 2.5F));

		PartDefinition MidLeft = partdefinition.addOrReplaceChild("MidLeft",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(1.5F, 22.0F, 0.5F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(
				-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.0F, -2.0F));

		return LayerDefinition.create(meshdefinition, 20, 16);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, buffer, packedLight, packedOverlay);
		FrontLegs.render(poseStack, buffer, packedLight, packedOverlay);
		MidRight.render(poseStack, buffer, packedLight, packedOverlay);
		BackLegs.render(poseStack, buffer, packedLight, packedOverlay);
		MidLeft.render(poseStack, buffer, packedLight, packedOverlay);
		Body.render(poseStack, buffer, packedLight, packedOverlay);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.FrontLegs.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.MidRight.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.BackLegs.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.MidLeft.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}