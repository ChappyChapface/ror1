// Made with Blockbench 4.8.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelcrow<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "crow"), "main");
	private final ModelPart Legs;
	private final ModelPart Tail;
	private final ModelPart WingRight;
	private final ModelPart WingLeft;
	private final ModelPart bb_main;

	public Modelcrow(ModelPart root) {
		this.Legs = root.getChild("Legs");
		this.Tail = root.getChild("Tail");
		this.WingRight = root.getChild("WingRight");
		this.WingLeft = root.getChild("WingLeft");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Legs = partdefinition.addOrReplaceChild("Legs",
				CubeListBuilder.create().texOffs(0, 3)
						.addBox(-2.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(1.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 22.0F, -0.5F, 0.5236F, 0.0F, 0.0F));

		PartDefinition Tail = partdefinition.addOrReplaceChild("Tail",
				CubeListBuilder.create().texOffs(0, 15).addBox(-2.0F, -0.5F, 0.5F, 4.0F, 1.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 20.5F, 1.5F, -0.2182F, 0.0F, 0.0F));

		PartDefinition WingRight = partdefinition.addOrReplaceChild("WingRight", CubeListBuilder.create()
				.texOffs(13, 10).addBox(-7.0F, -4.0F, -3.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition WingLeft = partdefinition.addOrReplaceChild("WingLeft", CubeListBuilder.create().texOffs(0, 9)
				.addBox(0.0F, -0.5F, -2.5F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.0F, 20.5F, -0.5F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-3.0F, -4.0F, -5.0F, 4.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(15, 0)
						.addBox(-2.0F, -3.0F, -7.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Legs.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		WingRight.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		WingLeft.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.WingRight.zRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.WingLeft.zRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
	}
}