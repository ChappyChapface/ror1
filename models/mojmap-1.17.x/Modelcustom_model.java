// Made with Blockbench 4.1.3
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelcustom_model<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "custom_model"), "main");
	private final ModelPart bone;
	private final ModelPart Chestboi;
	private final ModelPart wing1;
	private final ModelPart wing2;
	private final ModelPart Head;
	private final ModelPart bb_main;

	public Modelcustom_model(ModelPart root) {
		this.bone = root.getChild("bone");
		this.Chestboi = root.getChild("Chestboi");
		this.wing1 = root.getChild("wing1");
		this.wing2 = root.getChild("wing2");
		this.Head = root.getChild("Head");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, -5.0F));

		PartDefinition Chestboi = partdefinition.addOrReplaceChild("Chestboi",
				CubeListBuilder.create().texOffs(32, 70)
						.addBox(-4.0F, -1.5F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-2.0F, 10.5F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -7.5F, -5.0F, 0.9599F, 0.0F, 0.0F));

		PartDefinition wing1 = partdefinition.addOrReplaceChild("wing1",
				CubeListBuilder.create().texOffs(23, 3)
						.addBox(-1.0F, -1.5F, 0.2409F, 2.0F, 3.0F, 19.0F, new CubeDeformation(0.0F)).texOffs(0, 17)
						.addBox(0.0F, 0.5F, -0.7591F, 0.0F, 17.0F, 36.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0F, -7.5F, -3.2409F, 0.5228F, 0.8968F, 0.1179F));

		PartDefinition cube_r1 = wing1.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(72, 34).addBox(-1.1F, 0.5F, -1.5F, 2.0F, 21.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 17.7409F, 1.0036F, 0.0F, 0.0F));

		PartDefinition wing2 = partdefinition.addOrReplaceChild("wing2",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-1.0F, -1.5F, 0.2409F, 2.0F, 3.0F, 19.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(0.0F, 0.5F, -0.7591F, 0.0F, 17.0F, 36.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, -7.5F, -3.2409F, 0.3482F, -0.8968F, 0.1179F));

		PartDefinition cube_r2 = wing2.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(56, 70).addBox(-0.9F, 0.5F, -1.5F, 2.0F, 21.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 17.7409F, 1.0036F, 0.0F, 0.0F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(0, 70)
						.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 86)
						.addBox(-8.0F, -10.0F, -4.3F, 15.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -9.0F, -5.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main",
				CubeListBuilder.create().texOffs(68, 66)
						.addBox(-7.0F, -33.0F, -7.0F, 3.0F, 30.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(65, 0)
						.addBox(4.0F, -33.0F, -7.0F, 3.0F, 30.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		bone.render(poseStack, buffer, packedLight, packedOverlay);
		Chestboi.render(poseStack, buffer, packedLight, packedOverlay);
		wing1.render(poseStack, buffer, packedLight, packedOverlay);
		wing2.render(poseStack, buffer, packedLight, packedOverlay);
		Head.render(poseStack, buffer, packedLight, packedOverlay);
		bb_main.render(poseStack, buffer, packedLight, packedOverlay);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
	}
}