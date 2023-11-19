package net.mcreator.tnunlimited.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class ShroomOTPtickupdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double chain = 0;
		double Chainwait = 0;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			entity.getPersistentData().putDouble("shroomOFT639", (entity.getPersistentData().getDouble("shroomOFT639") + 1));
		}
		if (entity.getPersistentData().getDouble("shroomOFT639") == 20) {
			chain = 1;
			for (int index0 = 0; index0 < (int) chain; index0++) {
				TnunlimitedMod.queueServerWork((int) Chainwait, () -> {
					if (entity instanceof ShroomOfThePurpledEntity) {
						((ShroomOfThePurpledEntity) entity).setAnimation("attack");
					}
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level;
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, float damage, int knockback) {
									AbstractArrow entityToSpawn = new StickySlimeProjectileEntity(TnunlimitedModEntities.STICKY_SLIME_PROJECTILE.get(), level);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									entityToSpawn.setCritArrow(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, 3, 0);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
				});
				Chainwait = Chainwait + 3;
			}
		}
		if (entity.getPersistentData().getDouble("shroomOFT639") == 60) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2, 99999, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2, 99999, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 99999, false, false));
			if (entity instanceof ShroomOfThePurpledEntity) {
				((ShroomOfThePurpledEntity) entity).setAnimation("sneak");
			}
		}
		if (entity.getPersistentData().getDouble("shroomOFT639") == 180) {
			if (entity instanceof ShroomOfThePurpledEntity) {
				((ShroomOfThePurpledEntity) entity).setAnimation("idle");
			}
		}
		if (entity.getPersistentData().getDouble("shroomOFT639") == 280) {
			entity.getPersistentData().putDouble("shroomOFT639", 0);
		}
	}
}
