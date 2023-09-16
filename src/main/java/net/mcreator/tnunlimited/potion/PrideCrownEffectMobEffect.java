
package net.mcreator.tnunlimited.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class PrideCrownEffectMobEffect extends MobEffect {
	public PrideCrownEffectMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -26317);
	}

	@Override
	public String getDescriptionId() {
		return "effect.tnunlimited.pride_crown_effect";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
