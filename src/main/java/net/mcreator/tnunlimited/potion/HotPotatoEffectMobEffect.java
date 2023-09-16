
package net.mcreator.tnunlimited.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class HotPotatoEffectMobEffect extends MobEffect {
	public HotPotatoEffectMobEffect() {
		super(MobEffectCategory.HARMFUL, -13434880);
	}

	@Override
	public String getDescriptionId() {
		return "effect.tnunlimited.hot_potato_effect";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
