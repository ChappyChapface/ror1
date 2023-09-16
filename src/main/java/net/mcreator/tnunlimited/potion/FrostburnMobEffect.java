
package net.mcreator.tnunlimited.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class FrostburnMobEffect extends MobEffect {
	public FrostburnMobEffect() {
		super(MobEffectCategory.HARMFUL, -14996939);
	}

	@Override
	public String getDescriptionId() {
		return "effect.tnunlimited.frostburn";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
