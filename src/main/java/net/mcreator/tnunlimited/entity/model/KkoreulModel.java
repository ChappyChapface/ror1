package net.mcreator.tnunlimited.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.tnunlimited.entity.KkoreulEntity;

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
