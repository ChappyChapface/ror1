// Made with Blockbench 4.8.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelwarcaster<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "warcaster"), "main");
	private final ModelPart Head;
	private final ModelPart Body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;
	private final ModelPart waist;
	private final ModelPart right_leggings;
	private final ModelPart left_leggings;

	public Modelwarcaster(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Body = root.getChild("Body");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
		this.RightLeg = root.getChild("RightLeg");
		this.LeftLeg = root.getChild("LeftLeg");
		this.waist = root.getChild("waist");
		this.right_leggings = root.getChild("right_leggings");
		this.left_leggings = root.getChild("left_leggings");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 11)
				.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.75F)).texOffs(32, 34)
				.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(1.0F)).texOffs(0, 0)
				.addBox(-8.0F, -8.6F, -4.5F, 16.0F, 2.0F, 9.0F, new CubeDeformation(0.25F)).texOffs(40, 9)
				.addBox(-8.0F, -10.1F, -4.5F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.25F)).texOffs(0, 0)
				.addBox(-8.0F, -11.6F, 2.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.25F)).texOffs(0, 3)
				.addBox(-8.0F, -11.6F, -4.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.25F)).texOffs(0, 3).mirror()
				.addBox(7.0F, -11.6F, -4.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.25F)).mirror(false).texOffs(0, 0)
				.mirror().addBox(7.0F, -11.6F, 2.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.25F)).mirror(false)
				.texOffs(40, 9).mirror().addBox(7.0F, -10.1F, -4.5F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.25F))
				.mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(
				-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.75F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm",
				CubeListBuilder.create().texOffs(34, 0)
						.addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.75F)).texOffs(20, 10)
						.addBox(-4.0F, -7.0F, -3.0F, 4.0F, 8.0F, 6.0F, new CubeDeformation(0.75F)).texOffs(0, 32)
						.addBox(-2.6F, -7.0F, -3.0F, 3.0F, 8.0F, 6.0F, new CubeDeformation(0.75F)),
				PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(32, 24)
				.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.75F)).texOffs(20, 10).mirror()
				.addBox(0.0F, -7.0F, -3.0F, 4.0F, 8.0F, 6.0F, new CubeDeformation(0.75F)).mirror(false).texOffs(0, 32)
				.mirror().addBox(0.0F, -7.0F, -3.0F, 3.0F, 8.0F, 6.0F, new CubeDeformation(0.75F)).mirror(false),
				PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 16)
				.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.75F)),
				PartPose.offset(-1.9F, 12.0F, 0.0F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg",
				CubeListBuilder.create().texOffs(0, 16).mirror()
						.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.75F)).mirror(false),
				PartPose.offset(1.9F, 12.0F, 0.0F));

		PartDefinition waist = partdefinition.addOrReplaceChild("waist", CubeListBuilder.create().texOffs(16, 16)
				.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right_leggings = partdefinition.addOrReplaceChild("right_leggings", CubeListBuilder.create()
				.texOffs(0, 16).addBox(-1.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)),
				PartPose.offset(-2.0F, 12.0F, 0.0F));

		PartDefinition left_leggings = partdefinition.addOrReplaceChild("left_leggings",
				CubeListBuilder.create().texOffs(0, 16).mirror()
						.addBox(-2.1F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)).mirror(false),
				PartPose.offset(2.0F, 12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		waist.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leggings.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leggings.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}