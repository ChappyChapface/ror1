
package net.mcreator.tnunlimited.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class BrokenMobEffect extends MobEffect {
	public BrokenMobEffect() {
		super(MobEffectCategory.HARMFUL, -6710887);
	}

	@Override
	public String getDescriptionId() {
		return "effect.tnunlimited.broken";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
