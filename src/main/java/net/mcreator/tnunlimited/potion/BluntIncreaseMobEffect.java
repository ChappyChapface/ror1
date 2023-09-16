
package net.mcreator.tnunlimited.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class BluntIncreaseMobEffect extends MobEffect {
	public BluntIncreaseMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -3381760);
	}

	@Override
	public String getDescriptionId() {
		return "effect.tnunlimited.blunt_increase";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
