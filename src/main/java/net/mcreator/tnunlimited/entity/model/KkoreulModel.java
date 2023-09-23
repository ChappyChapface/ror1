package net.mcreator.tnunlimited.entity.model;

public class KkoreulModel extends AnimatedGeoModel<KkoreulEntity> {
	@Override
	public ResourceLocation getAnimationResource(KkoreulEntity entity) {
		return new ResourceLocation("tnunlimited", "animations/kkoreul.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(KkoreulEntity entity) {
		return new ResourceLocation("tnunlimited", "geo/kkoreul.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(KkoreulEntity entity) {
		return new ResourceLocation("tnunlimited", "textures/entities/" + entity.getTexture() + ".png");
	}

}