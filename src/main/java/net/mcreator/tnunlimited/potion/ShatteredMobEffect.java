
package net.mcreator.tnunlimited.potion;

public class ShatteredMobEffect extends MobEffect {

	public ShatteredMobEffect() {
		super(MobEffectCategory.HARMFUL, -6710887);
	}

	@Override
	public String getDescriptionId() {
		return "effect.tnunlimited.shattered";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}

}
