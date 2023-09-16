
package net.mcreator.tnunlimited.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class FlurryMobEffect extends MobEffect {
	public FlurryMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -7536706);
	}

	@Override
	public String getDescriptionId() {
		return "effect.tnunlimited.flurry";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
