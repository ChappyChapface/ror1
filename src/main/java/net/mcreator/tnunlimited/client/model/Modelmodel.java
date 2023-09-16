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

// Made with Blockbench 4.3.0
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelmodel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("tnunlimited", "modelmodel"), "main");
	public final ModelPart group;

	public Modelmodel(ModelPart root) {
		this.group = root.getChild("group");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition group = partdefinition.addOrReplaceChild("group",
				CubeListBuilder.create().texOffs(0, 5).addBox(4.0F, -1.0F, -12.0F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(12.0F, -1.0F, -12.0F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(16, 14)
						.addBox(4.0F, -1.0F, -12.0F, 8.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(16, 8).addBox(4.0F, -1.0F, -4.0F, 8.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(4, 4)
						.addBox(7.0F, 3.0F, -12.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 3).addBox(12.0F, 4.0F, -12.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(4.0F, 4.0F, -12.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(4, 1).addBox(3.9F, -1.0F, -5.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(4.0F, -1.0F, -12.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(4, 0).addBox(12.1F, -1.0F, -5.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-8.0F, 16.0F, 8.0F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		group.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
