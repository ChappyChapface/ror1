
package net.mcreator.tnunlimited.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.tnunlimited.procedures.DecardialEffectExpiresProcedure;

public class DecardialMobEffect extends MobEffect {
	public DecardialMobEffect() {
		super(MobEffectCategory.NEUTRAL, -15919347);
	}

	@Override
	public String getDescriptionId() {
		return "effect.tnunlimited.decardial";
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		DecardialEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
