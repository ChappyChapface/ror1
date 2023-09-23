package net.mcreator.tnunlimited.entity.model;

public class PlayerFrostSpikeEntityModel extends AnimatedGeoModel<PlayerFrostSpikeEntityEntity> {
	@Override
	public ResourceLocation getAnimationResource(PlayerFrostSpikeEntityEntity entity) {
		return new ResourceLocation("tnunlimited", "animations/ice_spike_growth.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PlayerFrostSpikeEntityEntity entity) {
		return new ResourceLocation("tnunlimited", "geo/ice_spike_growth.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PlayerFrostSpikeEntityEntity entity) {
		return new ResourceLocation("tnunlimited", "textures/entities/" + entity.getTexture() + ".png");
	}

}