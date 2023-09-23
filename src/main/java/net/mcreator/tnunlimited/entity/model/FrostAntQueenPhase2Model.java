package net.mcreator.tnunlimited.entity.model;

import software.bernie.geckolib3.model.provider.data.EntityModelData;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.tnunlimited.entity.FrostAntQueenPhase2Entity;

public class FrostAntQueenPhase2Model extends AnimatedGeoModel<FrostAntQueenPhase2Entity> {
	@Override
	public ResourceLocation getAnimationResource(FrostAntQueenPhase2Entity entity) {
		return new ResourceLocation("tnunlimited", "animations/frost_ant_queen_phase2.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FrostAntQueenPhase2Entity entity) {
		return new ResourceLocation("tnunlimited", "geo/frost_ant_queen_phase2.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FrostAntQueenPhase2Entity entity) {
		return new ResourceLocation("tnunlimited", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(FrostAntQueenPhase2Entity animatable, int instanceId, AnimationEvent animationEvent) {
		super.setCustomAnimations(animatable, instanceId, animationEvent);
		IBone head = this.getAnimationProcessor().getBone("head");
		EntityModelData extraData = (EntityModelData) animationEvent.getExtraDataOfType(EntityModelData.class).get(0);
		AnimationData manager = animatable.getFactory().getOrCreateAnimationData(instanceId);
		int unpausedMultiplier = !Minecraft.getInstance().isPaused() || manager.shouldPlayWhilePaused ? 1 : 0;
		head.setRotationX(head.getRotationX() + extraData.headPitch * ((float) Math.PI / 180F) * unpausedMultiplier);
		head.setRotationY(head.getRotationY() + extraData.netHeadYaw * ((float) Math.PI / 180F) * unpausedMultiplier);
	}
}
