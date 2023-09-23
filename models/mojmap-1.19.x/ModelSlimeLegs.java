// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelSlimeLegs<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "slimelegs"), "main");
	private final ModelPart e;
	private final ModelPart r;
	private final ModelPart L;

	public ModelSlimeLegs(ModelPart root) {
		this.e = root.getChild("e");
		this.r = root.getChild("r");
		this.L = root.getChild("L");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition e = partdefinition.addOrReplaceChild("e", CubeListBuilder.create().texOffs(4, 0).addBox(-4.0F,
				0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, 12.0F, 0.0F));

		PartDefinition r = partdefinition.addOrReplaceChild("r", CubeListBuilder.create().texOffs(8, 16).addBox(-2.0F,
				0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.4F)), PartPose.offset(-6.0F, 12.0F, 0.0F));

		PartDefinition L = partdefinition.addOrReplaceChild("L", CubeListBuilder.create().texOffs(8, 16).addBox(-2.0F,
				0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.4F)), PartPose.offset(6.0F, 12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		e.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		r.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		L.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}