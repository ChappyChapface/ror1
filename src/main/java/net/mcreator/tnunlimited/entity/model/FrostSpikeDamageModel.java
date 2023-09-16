package net.mcreator.tnunlimited.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.tnunlimited.entity.FrostSpikeDamageEntity;

public class FrostSpikeDamageModel extends AnimatedGeoModel<FrostSpikeDamageEntity> {
	@Override
	public ResourceLocation getAnimationResource(FrostSpikeDamageEntity entity) {
		return new ResourceLocation("tnunlimited", "animations/ice_spike_growth.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FrostSpikeDamageEntity entity) {
		return new ResourceLocation("tnunlimited", "geo/ice_spike_growth.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FrostSpikeDamageEntity entity) {
		return new ResourceLocation("tnunlimited", "textures/entities/" + entity.getTexture() + ".png");
	}

}
