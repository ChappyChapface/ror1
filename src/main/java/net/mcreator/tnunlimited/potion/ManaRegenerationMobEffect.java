
package net.mcreator.tnunlimited.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class ManaRegenerationMobEffect extends MobEffect {
	public ManaRegenerationMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13395457);
	}

	@Override
	public String getDescriptionId() {
		return "effect.tnunlimited.mana_regeneration";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
