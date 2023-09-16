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
public class ModeldioriteChestplate<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("tnunlimited", "modeldiorite_chestplate"), "main");
	public final ModelPart bod;
	public final ModelPart r;
	public final ModelPart l;

	public ModeldioriteChestplate(ModelPart root) {
		this.bod = root.getChild("bod");
		this.r = root.getChild("r");
		this.l = root.getChild("l");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bod = partdefinition.addOrReplaceChild("bod",
				CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 0.0F, -2.5F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.8F)).texOffs(22, 7).addBox(-4.0F, 6.4F, -2.0F, 8.0F, 3.0F, 4.0F, new CubeDeformation(0.6F)),
				PartPose.offset(0.0F, 12.0F, 0.5F));
		PartDefinition r = partdefinition.addOrReplaceChild("r", CubeListBuilder.create().texOffs(16, 16).addBox(-3.5F, -3.5F, -3.0F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.2F)), PartPose.offset(-5.5F, 15.5F, 1.0F));
		PartDefinition l = partdefinition.addOrReplaceChild("l", CubeListBuilder.create().texOffs(16, 16).addBox(-1.5F, -3.5F, -3.0F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.2F)), PartPose.offset(5.5F, 15.5F, 1.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bod.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		r.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		l.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.r.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.l.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
	}
}
