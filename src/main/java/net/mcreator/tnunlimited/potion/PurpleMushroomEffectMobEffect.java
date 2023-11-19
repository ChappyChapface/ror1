
package net.mcreator.tnunlimited.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class PurpleMushroomEffectMobEffect extends MobEffect {
	public PurpleMushroomEffectMobEffect() {
		super(MobEffectCategory.HARMFUL, -6749953);
	}

	@Override
	public String getDescriptionId() {
		return "effect.tnunlimited.purple_mushroom_effect";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
