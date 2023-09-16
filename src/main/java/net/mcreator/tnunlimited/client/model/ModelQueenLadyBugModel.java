package net.mcreator.tnunlimited.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelQueenLadyBugModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("tnunlimited", "model_queen_lady_bug_model"), "main");
	public final ModelPart Body;
	public final ModelPart RightFrontLeg;
	public final ModelPart LeftFrontLeg;
	public final ModelPart RightBackLeg;
	public final ModelPart LeftBackLeg;
	public final ModelPart Crown;

	public ModelQueenLadyBugModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.RightFrontLeg = root.getChild("RightFrontLeg");
		this.LeftFrontLeg = root.getChild("LeftFrontLeg");
		this.RightBackLeg = root.getChild("RightBackLeg");
		this.LeftBackLeg = root.getChild("LeftBackLeg");
		this.Crown = root.getChild("Crown");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-12.5F, -8.5F, -18.5F, 25.0F, 17.0F, 37.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 11.5F, 0.5F));
		PartDefinition RightFrontLeg = partdefinition.addOrReplaceChild("RightFrontLeg", CubeListBuilder.create().texOffs(14, 54).addBox(-1.5F, -3.5F, -2.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-10.5F, 20.5F, -4.0F));
		PartDefinition LeftFrontLeg = partdefinition.addOrReplaceChild("LeftFrontLeg", CubeListBuilder.create().texOffs(0, 54).addBox(-1.5F, -3.5F, -2.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(9.5F, 20.5F, -4.0F));
		PartDefinition RightBackLeg = partdefinition.addOrReplaceChild("RightBackLeg",
				CubeListBuilder.create().texOffs(0, 26).addBox(-1.5F, -3.5F, 2.5F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(22, 24).addBox(-1.5F, -3.5F, -6.5F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-10.5F, 20.5F, 10.5F));
		PartDefinition LeftBackLeg = partdefinition.addOrReplaceChild("LeftBackLeg",
				CubeListBuilder.create().texOffs(15, 13).addBox(-1.5F, -3.5F, 2.5F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(15, 0).addBox(-1.5F, -3.5F, -6.5F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(9.5F, 20.5F, 10.5F));
		PartDefinition Crown = partdefinition.addOrReplaceChild("Crown",
				CubeListBuilder.create().texOffs(0, 13).addBox(-6.0F, -23.0F, -17.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(3.0F, -23.0F, -17.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(42, 54)
						.addBox(-4.0F, -23.0F, -17.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(24, 54).addBox(-4.0F, -23.0F, -8.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 13)
						.addBox(-6.0F, -25.0F, -17.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-2.0F, -25.0F, -17.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(3.0F, -25.0F, -17.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightFrontLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftFrontLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightBackLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftBackLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Crown.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
