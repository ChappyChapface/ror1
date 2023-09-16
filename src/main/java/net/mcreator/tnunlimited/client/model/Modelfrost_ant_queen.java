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

// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelfrost_ant_queen<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("tnunlimited", "modelfrost_ant_queen"), "main");
	public final ModelPart Head;
	public final ModelPart Body;
	public final ModelPart LeftArm;
	public final ModelPart RightArm;
	public final ModelPart RightLeg1;
	public final ModelPart RightLeg2;
	public final ModelPart LeftLeg1;
	public final ModelPart LeftLeg2;

	public Modelfrost_ant_queen(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Body = root.getChild("Body");
		this.LeftArm = root.getChild("LeftArm");
		this.RightArm = root.getChild("RightArm");
		this.RightLeg1 = root.getChild("RightLeg1");
		this.RightLeg2 = root.getChild("RightLeg2");
		this.LeftLeg1 = root.getChild("LeftLeg1");
		this.LeftLeg2 = root.getChild("LeftLeg2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(112, 38).addBox(-8.0F, -7.5F, -15.5F, 16.0F, 15.0F, 15.0F, new CubeDeformation(0.0F)).texOffs(102, 95).addBox(-12.0F, -17.5F, -5.5F, 24.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-0.4F, -12.7972F, -18.2133F));
		PartDefinition cube_r1 = Head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(56, 21).addBox(0.0F, -14.0F, -25.0F, 0.0F, 15.0F, 28.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.5F, -8.2028F, -10.7867F, 0.0F, 0.48F, 0.0F));
		PartDefinition cube_r2 = Head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 21).addBox(0.0F, -14.0F, -25.0F, 0.0F, 15.0F, 28.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.5F, -8.2028F, -10.7867F, 0.0F, -0.48F, 0.0F));
		PartDefinition cube_r3 = Head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(84, 38).mirror().addBox(-4.0F, -2.5F, -1.5F, 8.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-6.0F, 4.0F, -17.0F, 0.0F, 0.5672F, 0.0F));
		PartDefinition cube_r4 = Head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(84, 38).addBox(-4.0F, -2.5F, -1.5F, 8.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(6.0F, 4.0F, -17.0F, 0.0F, -0.5672F, 0.0F));
		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.1F, -8.7412F, 41.0874F));
		PartDefinition cube_r5 = Body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(38, 76).addBox(0.0F, -9.5F, -9.5F, 0.0F, 19.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));
		PartDefinition cube_r6 = Body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-11.5F, -15.0F, -9.5F, 23.0F, 30.0F, 19.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 3.1979F, -24.2904F, -1.4399F, 0.0F, 0.0F));
		PartDefinition cube_r7 = Body.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(84, 0).addBox(-8.0F, -11.0F, -7.5F, 16.0F, 22.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, 2.7412F, -49.5874F, 1.2217F, 0.0F, 0.0F));
		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm",
				CubeListBuilder.create().texOffs(0, 95).addBox(13.6708F, 4.4337F, -20.1488F, 6.0F, 8.0F, 26.0F, new CubeDeformation(0.0F)).texOffs(68, 106).addBox(13.6708F, 4.4337F, 5.8512F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(15.6708F, 4.4337F, -49.1488F, 0.0F, 13.0F, 69.0F, new CubeDeformation(0.0F)).texOffs(0, 129).addBox(13.6708F, 7.4337F, -35.1488F, 4.0F, 5.0F, 15.0F, new CubeDeformation(0.0F)),
				PartPose.offset(7.9292F, -4.4337F, -17.1512F));
		PartDefinition cube_r8 = LeftArm.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 95).addBox(-4.5F, -20.0F, -3.5F, 6.0F, 20.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(16.1708F, 7.4337F, -1.6488F, -0.1745F, 0.0F, -1.0472F));
		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm",
				CubeListBuilder.create().texOffs(0, 129).mirror().addBox(-19.0708F, 7.4337F, -35.1488F, 4.0F, 5.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(68, 106).mirror()
						.addBox(-18.0708F, 4.4337F, 5.8512F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 95).mirror().addBox(-21.0708F, 4.4337F, -20.1488F, 6.0F, 8.0F, 26.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(0, 0).addBox(-17.0708F, 4.4337F, -49.1488F, 0.0F, 13.0F, 69.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-7.9292F, -4.4337F, -17.1512F));
		PartDefinition cube_r9 = RightArm.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 95).mirror().addBox(-4.5F, -20.0F, -3.5F, 6.0F, 20.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-15.9708F, 10.4337F, -1.6488F, -0.1745F, 0.0F, 1.0472F));
		PartDefinition RightLeg1 = partdefinition.addOrReplaceChild("RightLeg1", CubeListBuilder.create(), PartPose.offset(-8.5276F, -1.1692F, -6.2505F));
		PartDefinition cube_r10 = RightLeg1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(38, 129).mirror().addBox(-4.5F, -20.0F, -3.5F, 6.0F, 28.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-4.3724F, 17.1692F, -2.5495F, -0.1745F, 0.0F, 0.3054F));
		PartDefinition RightLeg2 = partdefinition.addOrReplaceChild("RightLeg2", CubeListBuilder.create(), PartPose.offset(-8.5276F, -1.1692F, 1.7495F));
		PartDefinition cube_r11 = RightLeg2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(38, 129).mirror().addBox(-4.5F, -20.0F, -4.5F, 6.0F, 28.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-4.3724F, 17.1692F, 4.3505F, 0.1745F, 0.0F, 0.3054F));
		PartDefinition LeftLeg1 = partdefinition.addOrReplaceChild("LeftLeg1", CubeListBuilder.create(), PartPose.offset(8.5276F, -1.1692F, -6.2505F));
		PartDefinition cube_r12 = LeftLeg1.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(38, 129).addBox(-4.5F, -20.0F, -3.5F, 6.0F, 28.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(6.5724F, 17.1692F, -2.5495F, -0.1745F, 0.0F, -0.3054F));
		PartDefinition LeftLeg2 = partdefinition.addOrReplaceChild("LeftLeg2", CubeListBuilder.create(), PartPose.offset(8.5276F, -1.1692F, 1.7495F));
		PartDefinition cube_r13 = LeftLeg2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(38, 129).addBox(-4.5F, -20.0F, -4.5F, 6.0F, 28.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(6.5724F, 17.1692F, 4.3505F, 0.1745F, 0.0F, -0.3054F));
		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
		this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.RightLeg2.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.RightLeg1.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.LeftLeg2.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.LeftLeg1.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}
