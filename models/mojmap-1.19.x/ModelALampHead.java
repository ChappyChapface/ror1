// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelALampHead<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "alamphead"), "main");
	private final ModelPart bone;

	public ModelALampHead(ModelPart root) {
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(21, 27)
						.addBox(-5.0F, -34.0F, -5.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(25, 23)
						.addBox(-5.0F, -34.0F, 4.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(28, 6)
						.addBox(-4.5F, -33.0F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(28, 4)
						.addBox(0.5F, -33.0F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-4.5F, -33.0F, -5.0F, 0.0F, 18.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(28, 8)
						.addBox(-5.0F, -15.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 48.0F, 0.0F));

		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(0, 22)
						.addBox(-6.0F, -6.0F, 4.0F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 24)
						.addBox(-6.0F, 5.0F, 4.0F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -25.0F, 0.0F, -1.5708F, 0.0F, 3.1416F));

		PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(25, 25)
						.addBox(-5.0F, 5.0F, 4.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 26)
						.addBox(-5.0F, -6.0F, 4.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 16)
						.addBox(-5.0F, -5.0F, 5.0F, 10.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 19)
						.addBox(-5.0F, 5.0F, 5.0F, 10.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -25.0F, 0.0F, 0.0F, 1.5708F, -1.5708F));

		PartDefinition cube_r3 = bone.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(20, 16)
						.addBox(-5.0F, 5.0F, 5.0F, 10.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 8)
						.addBox(-6.0F, 6.0F, 0.0F, 12.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 12)
						.addBox(-6.0F, -6.0F, 0.0F, 12.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(20, 19)
						.addBox(-5.0F, -5.0F, 5.0F, 10.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -25.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r4 = bone.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-6.0F, -6.0F, 0.0F, 12.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(-6.0F, 6.0F, 0.0F, 12.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -25.0F, 0.0F, 1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r5 = bone.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(0, 28)
						.addBox(-4.5F, -8.0F, -0.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(28, 0)
						.addBox(-4.0F, -9.0F, 4.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(28, 2)
						.addBox(-4.0F, -9.0F, -5.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -25.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}