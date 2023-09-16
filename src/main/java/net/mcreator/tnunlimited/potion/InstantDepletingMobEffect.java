
package net.mcreator.tnunlimited.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.tnunlimited.procedures.InstantDepletingEffectProcedure;

public class InstantDepletingMobEffect extends MobEffect {
	public InstantDepletingMobEffect() {
		super(MobEffectCategory.HARMFUL, -15592874);
	}

	@Override
	public String getDescriptionId() {
		return "effect.tnunlimited.instant_depleting";
	}

	@Override
	public boolean isInstantenous() {
		return true;
	}

	@Override
	public void applyInstantenousEffect(Entity source, Entity indirectSource, LivingEntity entity, int amplifier, double health) {
		InstantDepletingEffectProcedure.execute(entity, amplifier);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
