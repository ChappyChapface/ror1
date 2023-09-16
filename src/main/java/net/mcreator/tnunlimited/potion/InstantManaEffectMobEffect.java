
package net.mcreator.tnunlimited.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.tnunlimited.procedures.InstantManaEffectEffectStartedappliedProcedure;

public class InstantManaEffectMobEffect extends MobEffect {
	public InstantManaEffectMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -15198012);
	}

	@Override
	public String getDescriptionId() {
		return "effect.tnunlimited.instant_mana_effect";
	}

	@Override
	public boolean isInstantenous() {
		return true;
	}

	@Override
	public void applyInstantenousEffect(Entity source, Entity indirectSource, LivingEntity entity, int amplifier, double health) {
		InstantManaEffectEffectStartedappliedProcedure.execute(entity, amplifier);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
