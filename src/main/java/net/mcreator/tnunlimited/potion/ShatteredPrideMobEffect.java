
package net.mcreator.tnunlimited.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class ShatteredPrideMobEffect extends MobEffect {
	public ShatteredPrideMobEffect() {
		super(MobEffectCategory.HARMFUL, -26317);
	}

	@Override
	public String getDescriptionId() {
		return "effect.tnunlimited.shattered_pride";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
