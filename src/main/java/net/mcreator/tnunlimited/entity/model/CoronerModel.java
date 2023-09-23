package net.mcreator.tnunlimited.entity.model;

public class CoronerModel extends AnimatedGeoModel<CoronerEntity> {
	@Override
	public ResourceLocation getAnimationResource(CoronerEntity entity) {
		return new ResourceLocation("tnunlimited", "animations/the_coroner.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CoronerEntity entity) {
		return new ResourceLocation("tnunlimited", "geo/the_coroner.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CoronerEntity entity) {
		return new ResourceLocation("tnunlimited", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(CoronerEntity animatable, int instanceId, AnimationEvent animationEvent) {
		super.setCustomAnimations(animatable, instanceId, animationEvent);
		IBone head = this.getAnimationProcessor().getBone("head");
		EntityModelData extraData = (EntityModelData) animationEvent.getExtraDataOfType(EntityModelData.class).get(0);
		AnimationData manager = animatable.getFactory().getOrCreateAnimationData(instanceId);
		int unpausedMultiplier = !Minecraft.getInstance().isPaused() || manager.shouldPlayWhilePaused ? 1 : 0;
		head.setRotationX(head.getRotationX() + extraData.headPitch * ((float) Math.PI / 180F) * unpausedMultiplier);
		head.setRotationY(head.getRotationY() + extraData.netHeadYaw * ((float) Math.PI / 180F) * unpausedMultiplier);
	}
}