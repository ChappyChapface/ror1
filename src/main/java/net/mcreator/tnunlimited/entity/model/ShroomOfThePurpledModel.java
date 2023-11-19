package net.mcreator.tnunlimited.entity.model;

public class ShroomOfThePurpledModel extends AnimatedGeoModel<ShroomOfThePurpledEntity> {
	@Override
	public ResourceLocation getAnimationResource(ShroomOfThePurpledEntity entity) {
		return new ResourceLocation("tnunlimited", "animations/shroomofthepurpledmodel.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ShroomOfThePurpledEntity entity) {
		return new ResourceLocation("tnunlimited", "geo/shroomofthepurpledmodel.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ShroomOfThePurpledEntity entity) {
		return new ResourceLocation("tnunlimited", "textures/entities/" + entity.getTexture() + ".png");
	}

}