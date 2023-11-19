
package net.mcreator.tnunlimited.potion;

public class BrokenMobEffect extends MobEffect {

	public BrokenMobEffect() {
		super(MobEffectCategory.HARMFUL, -10066330);
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
