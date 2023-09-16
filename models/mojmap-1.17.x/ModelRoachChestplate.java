// Made with Blockbench 4.1.1
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelRoachChestplate<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "roachchestplate"), "main");
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart Body;

	public ModelRoachChestplate(ModelPart root) {
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
		this.Body = root.getChild("Body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm",
				CubeListBuilder.create().texOffs(24, 0).mirror()
						.addBox(-3.5F, -2.0F, -3.0F, 5.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(19, 0).addBox(-4.5F, -3.0F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-7.0F, 13.5F, -0.5F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm",
				CubeListBuilder.create().texOffs(24, 0)
						.addBox(-1.5F, -2.0F, -3.0F, 5.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(19, 0)
						.mirror().addBox(1.5F, -3.0F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(7.0F, 13.5F, -0.5F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body",
				CubeListBuilder.create().texOffs(1, 27)
						.addBox(-4.5F, 6.8F, -2.0F, 9.0F, 3.0F, 4.0F, new CubeDeformation(0.6F)).texOffs(1, 27)
						.addBox(-4.5F, 6.8F, -2.0F, 9.0F, 3.0F, 4.0F, new CubeDeformation(0.6F)).texOffs(0, 0)
						.addBox(-3.0F, 6.5F, 3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.5F)).texOffs(0, 13)
						.addBox(-5.5F, -0.5F, -3.0F, 11.0F, 7.0F, 6.0F, new CubeDeformation(0.3F)),
				PartPose.offset(0.0F, 12.0F, -0.5F));

		return LayerDefinition.create(meshdefinition, 46, 34);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		RightArm.render(poseStack, buffer, packedLight, packedOverlay);
		LeftArm.render(poseStack, buffer, packedLight, packedOverlay);
		Body.render(poseStack, buffer, packedLight, packedOverlay);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
	}
}