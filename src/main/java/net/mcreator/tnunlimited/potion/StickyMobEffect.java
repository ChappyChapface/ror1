
package net.mcreator.tnunlimited.potion;

public class StickyMobEffect extends MobEffect {

	public StickyMobEffect() {
		super(MobEffectCategory.HARMFUL, -9021562);
	}

	@Override
	public String getDescriptionId() {
		return "effect.tnunlimited.sticky";
	}

	@Override
	public boolean isInstantenous() {
		return true;
	}

	@Override
	public void applyInstantenousEffect(Entity source, Entity indirectSource, LivingEntity entity, int amplifier, double health) {
		StickyEffectProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		StickyEffectProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}

}
