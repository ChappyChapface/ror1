
package net.mcreator.tnunlimited.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.tnunlimited.procedures.InfernoEffectProcedure;

public class InfernoMobEffect extends MobEffect {
	public InfernoMobEffect() {
		super(MobEffectCategory.HARMFUL, -13261);
	}

	@Override
	public String getDescriptionId() {
		return "effect.tnunlimited.inferno";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		InfernoEffectProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
