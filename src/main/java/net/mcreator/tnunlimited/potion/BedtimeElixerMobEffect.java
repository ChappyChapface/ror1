
package net.mcreator.tnunlimited.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class BedtimeElixerMobEffect extends MobEffect {
	public BedtimeElixerMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -10040065);
	}

	@Override
	public String getDescriptionId() {
		return "effect.tnunlimited.bedtime_elixir";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
