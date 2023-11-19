package net.mcreator.tnunlimited.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.tnunlimited.entity.FrostSpikeEnityEntity;

public class FrostSpikeEnityModel extends AnimatedGeoModel<FrostSpikeEnityEntity> {
	@Override
	public ResourceLocation getAnimationResource(FrostSpikeEnityEntity entity) {
		return new ResourceLocation("tnunlimited", "animations/ice_spike_growth.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FrostSpikeEnityEntity entity) {
		return new ResourceLocation("tnunlimited", "geo/ice_spike_growth.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FrostSpikeEnityEntity entity) {
		return new ResourceLocation("tnunlimited", "textures/entities/" + entity.getTexture() + ".png");
	}

}
