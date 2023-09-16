
package net.mcreator.tnunlimited.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class DepletingMobEffect extends MobEffect {
	public DepletingMobEffect() {
		super(MobEffectCategory.HARMFUL, -3315161);
	}

	@Override
	public String getDescriptionId() {
		return "effect.tnunlimited.depleting";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
