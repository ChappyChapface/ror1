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
public class ModelKkoreul<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("tnunlimited", "model_kkoreul"), "main");
	public final ModelPart arm1;
	public final ModelPart arm2;
	public final ModelPart Head;
	public final ModelPart bb_main;

	public ModelKkoreul(ModelPart root) {
		this.arm1 = root.getChild("arm1");
		this.arm2 = root.getChild("arm2");
		this.Head = root.getChild("Head");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition arm1 = partdefinition.addOrReplaceChild("arm1", CubeListBuilder.create().texOffs(74, 26).addBox(-6.6161F, -17.5535F, -2.6029F, 6.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0F, 17.0F, 0.0F, 0.0F, 0.2618F, 0.6545F));
		PartDefinition cube_r1 = arm1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(14, 83).addBox(-9.2951F, -12.5704F, -1.6798F, 5.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.7843F, -7.1812F, -1.3288F, 0.7044F, 0.0327F, 1.0831F));
		PartDefinition cube_r2 = arm1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 26).addBox(-0.3946F, -15.9101F, -0.6136F, 5.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, -6.0F, 0.0F, 0.0F, 0.2618F, -0.6109F));
		PartDefinition arm2 = partdefinition.addOrReplaceChild("arm2", CubeListBuilder.create().texOffs(0, 0).addBox(-3.1524F, -18.3795F, 1.3603F, 5.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, 22.0F, 0.0F, 0.4026F, 0.3627F, -0.0531F));
		PartDefinition cube_r3 = arm2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(84, 45).addBox(0.0491F, -13.0264F, 3.6518F, 5.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, -6.0F, 0.0F, 0.0F, 0.3927F, -0.6109F));
		PartDefinition cube_r4 = arm2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(92, 35).addBox(-7.7636F, -8.4619F, 3.1768F, 4.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.7843F, -7.1812F, -1.3288F, 0.6871F, 0.1728F, 0.9149F));
		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(0, 61).addBox(-3.5F, -10.0F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(39, 26).addBox(-1.5F, -10.0F, -1.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition arm3 = Head.addOrReplaceChild("arm3", CubeListBuilder.create().texOffs(66, 68).addBox(-5.6161F, -23.4441F, -4.0117F, 4.0F, 23.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, -5.0F, 0.0F, -0.1309F, 0.2618F, 0.6545F));
		PartDefinition cube_r5 = arm3.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(80, 67).addBox(-9.1851F, -11.7939F, -0.0219F, 6.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.7843F, -7.1812F, -1.3288F, -0.9536F, 0.0327F, 1.0831F));
		PartDefinition cube_r6 = arm3.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(92, 25).addBox(7.9995F, -17.6279F, -1.5247F, 5.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.9631F, -3.857F, 0.2241F, -0.1706F, 0.1996F, -1.3261F));
		PartDefinition cube_r7 = arm3.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(84, 11).addBox(-1.3494F, -15.8204F, -2.0247F, 5.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, -6.0F, 0.0F, 0.0F, 0.2618F, -0.6109F));
		PartDefinition arm4 = Head.addOrReplaceChild("arm4", CubeListBuilder.create().texOffs(80, 83).addBox(-0.5542F, -16.4565F, -3.8731F, 5.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -5.0F, 2.0F, -0.5149F, -0.0811F, -0.4432F));
		PartDefinition cube_r8 = arm4.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(42, 86).addBox(-9.2658F, -14.0502F, -0.3032F, 6.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.7843F, -7.1812F, -1.3288F, 0.7044F, 0.0327F, 1.0831F));
		PartDefinition cube_r9 = arm4.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(56, 86).addBox(-1.5585F, -11.4494F, -1.4766F, 4.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.7337F, -20.099F, -1.8599F, -0.0338F, 0.1298F, 0.4512F));
		PartDefinition cube_r10 = arm4.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 91).addBox(8.1466F, -14.6374F, -1.4937F, 4.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.9631F, -3.857F, 0.2241F, -0.1706F, 0.1996F, -1.3261F));
		PartDefinition cube_r11 = arm4.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(49, 71).addBox(3.0944F, -15.5008F, -1.9937F, 7.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, -6.0F, 0.0F, 0.0F, 0.2618F, -0.6109F));
		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main",
				CubeListBuilder.create().texOffs(63, 11).addBox(-2.5F, -24.0F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(21, 71).addBox(-3.5F, -19.0F, -3.5F, 7.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(0, 26)
						.addBox(-6.5F, -10.0F, -6.5F, 13.0F, 5.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-10.5F, -5.0F, -10.5F, 21.0F, 5.0F, 21.0F, new CubeDeformation(0.0F)).texOffs(33, 58)
						.addBox(-4.5F, -14.0F, -4.5F, 9.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(42, 45).addBox(-4.5F, -2.0F, -17.5F, 12.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(60, 58)
						.addBox(9.5F, -3.0F, -7.5F, 11.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 44).addBox(-20.5F, -6.0F, -7.5F, 11.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(63, 0)
						.addBox(-5.5F, -3.0F, 7.5F, 11.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(38, 30).addBox(6.5F, -0.5F, -0.5F, 11.0F, 1.0F, 14.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r12 = bb_main.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(28, 83).addBox(1.5F, -9.0F, -1.5F, 4.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, -20.0F, 1.0F, -0.3054F, 0.0F, -0.7854F));
		PartDefinition cube_r13 = bb_main.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 75).addBox(-2.0F, -10.0F, -1.5F, 4.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5F, -34.0F, 0.0F, 0.3491F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		arm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		arm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
	}
}
