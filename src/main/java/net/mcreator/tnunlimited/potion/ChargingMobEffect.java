
package net.mcreator.tnunlimited.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class ChargingMobEffect extends MobEffect {
	public ChargingMobEffect() {
		super(MobEffectCategory.NEUTRAL, -39424);
	}

	@Override
	public String getDescriptionId() {
		return "effect.tnunlimited.charging";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
