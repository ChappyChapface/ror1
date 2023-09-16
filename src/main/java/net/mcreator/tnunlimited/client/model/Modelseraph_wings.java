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

// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelseraph_wings<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("tnunlimited", "modelseraph_wings"), "main");
	public final ModelPart Body;
	public final ModelPart LeftArm;
	public final ModelPart RightArm;

	public Modelseraph_wings(ModelPart root) {
		this.Body = root.getChild("Body");
		this.LeftArm = root.getChild("LeftArm");
		this.RightArm = root.getChild("RightArm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition bone = Body.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
		PartDefinition Body_r1 = bone.addOrReplaceChild("Body_r1",
				CubeListBuilder.create().texOffs(70, 39).addBox(8.3565F, 0.7159F, -1.1886F, 11.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(52, 0).addBox(6.3565F, 2.7159F, -0.1886F, 13.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(18.6915F, -7.537F, -5.165F, 3.0884F, -0.1459F, 2.9182F));
		PartDefinition Body_r2 = bone.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(78, 0).addBox(-2.5041F, -8.2439F, -0.9203F, 8.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(26.7491F, -12.9151F, -4.0097F, 2.909F, -0.024F, 1.841F));
		PartDefinition Body_r3 = bone.addOrReplaceChild("Body_r3",
				CubeListBuilder.create().texOffs(0, 0).addBox(-2.273F, -7.3091F, 0.0797F, 13.0F, 28.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 49).addBox(-5.273F, -7.3091F, -0.9203F, 3.0F, 21.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(26.7491F, -12.9151F, -4.0097F, 2.9265F, -0.0923F, 1.5427F));
		PartDefinition Body_r4 = bone.addOrReplaceChild("Body_r4",
				CubeListBuilder.create().texOffs(70, 34).addBox(-1.7879F, -2.7346F, -1.1886F, 11.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(44, 72).addBox(-1.7879F, 0.2654F, -0.1886F, 11.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(18.6915F, -7.537F, -5.165F, -3.1413F, -0.1553F, 2.5652F));
		PartDefinition Body_r5 = bone.addOrReplaceChild("Body_r5", CubeListBuilder.create().texOffs(78, 5).addBox(-2.6435F, -8.4894F, -1.0927F, 8.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-26.0803F, -12.1503F, -5.0769F, 0.2435F, -0.0759F, 1.3173F));
		PartDefinition Body_r6 = bone.addOrReplaceChild("Body_r6",
				CubeListBuilder.create().texOffs(0, 0).addBox(-2.1328F, -7.2468F, -0.0927F, 13.0F, 28.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(10, 49).addBox(-5.1328F, -7.2468F, -1.0927F, 3.0F, 21.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-26.0803F, -12.1503F, -5.0769F, 0.2103F, -0.1452F, 1.6166F));
		PartDefinition Body_r7 = bone.addOrReplaceChild("Body_r7",
				CubeListBuilder.create().texOffs(44, 72).addBox(-10.5F, 1.4F, -1.3F, 11.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(70, 58).addBox(-10.5F, -1.6F, -2.3F, 11.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-10.5F, -4.0F, -3.0F, 0.0097F, -0.218F, 0.6098F));
		PartDefinition Body_r8 = bone.addOrReplaceChild("Body_r8",
				CubeListBuilder.create().texOffs(52, 0).addBox(-2.5F, 0.4F, -1.3F, 13.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(70, 70).addBox(-0.5F, -1.6F, -2.3F, 11.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-10.5F, -4.0F, -3.0F, 0.0846F, -0.2013F, 0.2532F));
		PartDefinition Body_r9 = bone.addOrReplaceChild("Body_r9",
				CubeListBuilder.create().texOffs(0, 44).addBox(-12.8274F, 5.4798F, -5.3107F, 15.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 28).addBox(-16.8274F, 8.4798F, -4.3107F, 19.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.096F, -24.1151F, -9.0335F, -2.7311F, 0.0135F, 2.1424F));
		PartDefinition Body_r10 = bone.addOrReplaceChild("Body_r10",
				CubeListBuilder.create().texOffs(52, 14).addBox(-5.958F, -1.8257F, 0.1124F, 11.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(68, 53).addBox(-5.958F, -4.8257F, -0.8876F, 11.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(9.8638F, -14.0061F, -7.9104F, -2.7554F, -0.204F, 1.3596F));
		PartDefinition Body_r11 = bone.addOrReplaceChild("Body_r11",
				CubeListBuilder.create().texOffs(46, 67).addBox(4.199F, -0.8204F, -0.8876F, 11.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(38, 28).addBox(-0.801F, -0.8204F, 0.1124F, 16.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(9.8638F, -14.0061F, -7.9104F, -3.0127F, -0.4159F, 2.1578F));
		PartDefinition Body_r12 = bone.addOrReplaceChild("Body_r12",
				CubeListBuilder.create().texOffs(0, 28).addBox(-17.1389F, 7.7472F, 2.9598F, 19.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(32, 47).addBox(-12.1389F, 4.7472F, 1.9598F, 14.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.096F, -24.1151F, -9.0335F, -0.3532F, 0.0063F, 1.0F));
		PartDefinition Body_r13 = bone.addOrReplaceChild("Body_r13",
				CubeListBuilder.create().texOffs(52, 14).addBox(-5.5F, 2.5F, 0.0F, 11.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(70, 24).addBox(-5.5F, -0.5F, -1.0F, 11.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.9034F, -13.8754F, -7.3682F, -0.3561F, -0.2484F, 1.7976F));
		PartDefinition Body_r14 = bone.addOrReplaceChild("Body_r14",
				CubeListBuilder.create().texOffs(38, 28).addBox(-10.5F, -6.6F, -2.3F, 16.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(70, 29).addBox(-5.5F, -6.6F, -3.3F, 11.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-10.5F, -4.0F, -3.0F, -0.0715F, -0.4256F, 0.9827F));
		PartDefinition Body_r15 = bone.addOrReplaceChild("Body_r15",
				CubeListBuilder.create().texOffs(20, 62).addBox(-8.0521F, -5.0303F, -1.1554F, 11.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(74, 14).addBox(-11.0521F, -2.0303F, -0.1554F, 14.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(15.0689F, 9.723F, 1.0873F, -2.449F, 1.2826F, -1.6123F));
		PartDefinition Body_r16 = bone.addOrReplaceChild("Body_r16",
				CubeListBuilder.create().texOffs(70, 44).addBox(-8.2297F, -2.0675F, -0.3881F, 11.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(42, 57).addBox(-8.2297F, -5.0675F, -1.3881F, 11.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(15.0689F, 9.723F, 1.0873F, 0.8583F, -0.4392F, -0.3605F));
		PartDefinition Body_r17 = bone.addOrReplaceChild("Body_r17",
				CubeListBuilder.create().texOffs(42, 52).addBox(-8.5F, -1.5F, -3.0F, 11.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 72).addBox(-8.5F, -1.5F, -2.0F, 11.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(8.3107F, 8.1072F, -2.8323F, 0.4892F, 0.3533F, 0.7322F));
		PartDefinition Body_r18 = bone.addOrReplaceChild("Body_r18",
				CubeListBuilder.create().texOffs(74, 14).addBox(-9.15F, -0.75F, 1.5F, 14.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(20, 62).addBox(-6.15F, -3.75F, 0.5F, 11.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-15.3082F, 9.448F, 4.4735F, -0.6732F, 1.4315F, -1.4244F));
		PartDefinition Body_r19 = bone.addOrReplaceChild("Body_r19",
				CubeListBuilder.create().texOffs(70, 44).mirror().addBox(-10.5F, 1.5F, -5.0F, 11.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(42, 57).addBox(-10.5F, -1.5F, -6.0F, 11.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.5544F, 6.3754F, -3.3398F, 0.9603F, 0.6895F, 0.4491F));
		PartDefinition Body_r20 = bone.addOrReplaceChild("Body_r20", CubeListBuilder.create().texOffs(42, 52).mirror().addBox(-8.5F, 0.2F, -1.6F, 11.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 72).mirror()
				.addBox(-8.5F, 0.2F, -0.6F, 11.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.4599F, 3.2194F, -2.2949F, 0.3751F, -0.3772F, -0.6673F));
		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
