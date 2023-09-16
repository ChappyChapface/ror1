// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelPiranha<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "piranha"), "main");
	private final ModelPart Head;
	private final ModelPart Body;
	private final ModelPart Tail;

	public ModelPiranha(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Body = root.getChild("Body");
		this.Tail = root.getChild("Tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(0, 21)
						.addBox(-2.0F, -5.5F, -7.0F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 13)
						.addBox(-2.0F, -3.0F, -8.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(0.0F, -3.0F, -8.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-2.0F, -6.0F, -5.0F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(12, 20)
						.addBox(-2.0F, -5.5F, 2.0F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(14, 13)
						.addBox(-3.0F, -3.0F, -4.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(13, 0)
						.addBox(0.0F, -3.0F, -4.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 13)
						.addBox(-1.0F, -7.0F, -3.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Tail = partdefinition.addOrReplaceChild("Tail",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-0.5F, -4.5F, 4.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(4, 12)
						.addBox(-0.5F, -5.0F, 4.0F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(8, 11)
						.addBox(-0.5F, -5.5F, 6.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(-0.5F, -1.5F, 6.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}