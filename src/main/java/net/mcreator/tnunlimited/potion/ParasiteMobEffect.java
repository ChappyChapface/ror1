
package net.mcreator.tnunlimited.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class ParasiteMobEffect extends MobEffect {
	public ParasiteMobEffect() {
		super(MobEffectCategory.HARMFUL, -14876672);
	}

	@Override
	public String getDescriptionId() {
		return "effect.tnunlimited.parasite";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
