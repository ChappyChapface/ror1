package net.mcreator.tnunlimited.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
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

// Made with Blockbench 4.1.1
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelDuneSpider<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("tnunlimited", "model_dune_spider"), "main");
	public final ModelPart RightLeg4;
	public final ModelPart RightLeg3;
	public final ModelPart RightLeg2;
	public final ModelPart RightLeg1;
	public final ModelPart LeftLeg4;
	public final ModelPart LeftLeg3;
	public final ModelPart LeftLeg2;
	public final ModelPart LeftLeg1;
	public final ModelPart Head;
	public final ModelPart Abdomen;

	public ModelDuneSpider(ModelPart root) {
		this.RightLeg4 = root.getChild("RightLeg4");
		this.RightLeg3 = root.getChild("RightLeg3");
		this.RightLeg2 = root.getChild("RightLeg2");
		this.RightLeg1 = root.getChild("RightLeg1");
		this.LeftLeg4 = root.getChild("LeftLeg4");
		this.LeftLeg3 = root.getChild("LeftLeg3");
		this.LeftLeg2 = root.getChild("LeftLeg2");
		this.LeftLeg1 = root.getChild("LeftLeg1");
		this.Head = root.getChild("Head");
		this.Abdomen = root.getChild("Abdomen");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition RightLeg4 = partdefinition.addOrReplaceChild("RightLeg4", CubeListBuilder.create(), PartPose.offset(-3.0F, 15.0F, -1.0F));
		PartDefinition cube_r1 = RightLeg4.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(25, 0).mirror().addBox(-18.5F, -1.0F, -1.0F, 19.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, 0.5236F, -0.4887F));
		PartDefinition RightLeg3 = partdefinition.addOrReplaceChild("RightLeg3", CubeListBuilder.create(), PartPose.offset(-3.0F, 16.0F, -3.0F));
		PartDefinition cube_r2 = RightLeg3.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(25, 0).mirror().addBox(-18.5F, -1.0F, -1.0F, 19.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.2182F, -0.4363F));
		PartDefinition RightLeg2 = partdefinition.addOrReplaceChild("RightLeg2", CubeListBuilder.create(), PartPose.offset(-3.0F, 16.0F, -5.0F));
		PartDefinition cube_r3 = RightLeg2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(25, 0).mirror().addBox(-18.5F, -1.0F, -1.0F, 19.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.2182F, -0.4363F));
		PartDefinition RightLeg1 = partdefinition.addOrReplaceChild("RightLeg1", CubeListBuilder.create(), PartPose.offset(-3.0F, 15.0F, -7.0F));
		PartDefinition cube_r4 = RightLeg1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(25, 0).mirror().addBox(-18.5F, -1.0F, -1.0F, 19.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, -0.5236F, -0.4887F));
		PartDefinition LeftLeg4 = partdefinition.addOrReplaceChild("LeftLeg4", CubeListBuilder.create(), PartPose.offset(3.0F, 16.0F, -1.0F));
		PartDefinition cube_r5 = LeftLeg4.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(25, 0).addBox(-0.5F, -1.0F, -1.0F, 19.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.4887F));
		PartDefinition LeftLeg3 = partdefinition.addOrReplaceChild("LeftLeg3", CubeListBuilder.create(), PartPose.offset(3.0F, 16.0F, -3.0F));
		PartDefinition cube_r6 = LeftLeg3.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(25, 0).addBox(-0.5F, -1.0F, -1.0F, 19.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.2182F, 0.4363F));
		PartDefinition LeftLeg2 = partdefinition.addOrReplaceChild("LeftLeg2", CubeListBuilder.create(), PartPose.offset(3.0F, 16.0F, -5.0F));
		PartDefinition cube_r7 = LeftLeg2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(25, 0).addBox(-0.5F, -1.0F, -1.0F, 19.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.2182F, 0.4363F));
		PartDefinition LeftLeg1 = partdefinition.addOrReplaceChild("LeftLeg1", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 15.6592F, -7.5F, 0.0F, 0.0F, 0.0F));
		PartDefinition cube_r8 = LeftLeg1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(25, 0).addBox(-0.5F, -1.0F, -1.0F, 19.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0603F, 0.3408F, 0.158F, 0.0F, 0.5236F, 0.4887F));
		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -5.1667F, -11.0F, 7.0F, 7.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(0, 0).mirror()
				.addBox(0.5F, -2.1667F, -13.0F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 0).addBox(-3.5F, -2.1667F, -13.0F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.1667F, 0.0F));
		PartDefinition Abdomen = partdefinition.addOrReplaceChild("Abdomen", CubeListBuilder.create().texOffs(0, 18).addBox(-7.0F, -7.5F, 0.0F, 14.0F, 11.0F, 20.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.1745F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 69, 49);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		RightLeg4.render(poseStack, buffer, packedLight, packedOverlay);
		RightLeg3.render(poseStack, buffer, packedLight, packedOverlay);
		RightLeg2.render(poseStack, buffer, packedLight, packedOverlay);
		RightLeg1.render(poseStack, buffer, packedLight, packedOverlay);
		LeftLeg4.render(poseStack, buffer, packedLight, packedOverlay);
		LeftLeg3.render(poseStack, buffer, packedLight, packedOverlay);
		LeftLeg2.render(poseStack, buffer, packedLight, packedOverlay);
		LeftLeg1.render(poseStack, buffer, packedLight, packedOverlay);
		Head.render(poseStack, buffer, packedLight, packedOverlay);
		Abdomen.render(poseStack, buffer, packedLight, packedOverlay);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.RightLeg4.yRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.RightLeg3.yRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.RightLeg2.yRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.RightLeg1.yRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.LeftLeg2.yRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.LeftLeg1.yRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.LeftLeg4.yRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.LeftLeg3.yRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
	}
}
