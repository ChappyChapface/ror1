package net.mcreator.tnunlimited.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.tnunlimited.entity.PurpleBeetleEntity;

public class PurpleBeetleModel extends AnimatedGeoModel<PurpleBeetleEntity> {
	@Override
	public ResourceLocation getAnimationResource(PurpleBeetleEntity entity) {
		return new ResourceLocation("tnunlimited", "animations/purplebeetlemodel.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PurpleBeetleEntity entity) {
		return new ResourceLocation("tnunlimited", "geo/purplebeetlemodel.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PurpleBeetleEntity entity) {
		return new ResourceLocation("tnunlimited", "textures/entities/" + entity.getTexture() + ".png");
	}

}
