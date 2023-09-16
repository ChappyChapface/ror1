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
public class ModelGildedBug<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("tnunlimited", "model_gilded_bug"), "main");
	public final ModelPart Head;
	public final ModelPart FrontLeftLeg;
	public final ModelPart MidLeftLeg;
	public final ModelPart backleftLeg;
	public final ModelPart FrontRightLeg;
	public final ModelPart MidrightLeg;
	public final ModelPart BackRightLeg;
	public final ModelPart bb_main;

	public ModelGildedBug(ModelPart root) {
		this.Head = root.getChild("Head");
		this.FrontLeftLeg = root.getChild("FrontLeftLeg");
		this.MidLeftLeg = root.getChild("MidLeftLeg");
		this.backleftLeg = root.getChild("backleftLeg");
		this.FrontRightLeg = root.getChild("FrontRightLeg");
		this.MidrightLeg = root.getChild("MidrightLeg");
		this.BackRightLeg = root.getChild("BackRightLeg");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(14, 5).mirror().addBox(1.5F, -3.5F, -5.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(14, 5)
				.addBox(-1.5F, -3.5F, -5.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 10).addBox(-1.5F, -1.5F, -3.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 21.5F, -3.0F));
		PartDefinition FrontLeftLeg = partdefinition.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(1.5F, 22.0F, -2.5F));
		PartDefinition MidLeftLeg = partdefinition.addOrReplaceChild("MidLeftLeg", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(1.5F, 22.0F, -0.5F));
		PartDefinition backleftLeg = partdefinition.addOrReplaceChild("backleftLeg", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(1.5F, 22.0F, 1.5F));
		PartDefinition FrontRightLeg = partdefinition.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 22.0F, -2.5F));
		PartDefinition MidrightLeg = partdefinition.addOrReplaceChild("MidrightLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 22.0F, -0.5F));
		PartDefinition BackRightLeg = partdefinition.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 22.0F, 1.5F));
		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main",
				CubeListBuilder.create().texOffs(0, 16).addBox(-3.0F, -5.0F, -3.0F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-3.0F, -6.0F, 2.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 24, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, buffer, packedLight, packedOverlay);
		FrontLeftLeg.render(poseStack, buffer, packedLight, packedOverlay);
		MidLeftLeg.render(poseStack, buffer, packedLight, packedOverlay);
		backleftLeg.render(poseStack, buffer, packedLight, packedOverlay);
		FrontRightLeg.render(poseStack, buffer, packedLight, packedOverlay);
		MidrightLeg.render(poseStack, buffer, packedLight, packedOverlay);
		BackRightLeg.render(poseStack, buffer, packedLight, packedOverlay);
		bb_main.render(poseStack, buffer, packedLight, packedOverlay);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.FrontRightLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.MidrightLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
		this.backleftLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.FrontLeftLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.MidLeftLeg.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.BackRightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
	}
}
