
package net.mcreator.tnunlimited.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.tnunlimited.procedures.DrowsyEffectProcedure;

public class DrowsyMobEffect extends MobEffect {
	public DrowsyMobEffect() {
		super(MobEffectCategory.HARMFUL, -3276806);
	}

	@Override
	public String getDescriptionId() {
		return "effect.tnunlimited.drowsy";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		DrowsyEffectProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
