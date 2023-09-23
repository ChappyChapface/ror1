package net.mcreator.tnunlimited.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EntitySetsTargetProcedure {
	@SubscribeEvent
	public static void onEntitySetsAttackTarget(LivingChangeTargetEvent event) {
		execute(event, event.getEntity().level, event.getOriginalTarget(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((entity instanceof Player || entity instanceof ServerPlayer) && sourceentity instanceof IronGolem && world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE)) {
			if (sourceentity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 2));
			if (sourceentity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 1));
			if (sourceentity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.STURDY.get(), 60, 5));
			sourceentity.getPersistentData().putDouble("projCooldown", (sourceentity.getPersistentData().getDouble("projCooldown") - 1));
			if (sourceentity.getPersistentData().getDouble("projCooldown") <= 0) {
				for (int index0 = 0; index0 < 3; index0++) {
					{
						Entity _shootFrom = sourceentity;
						Level projectileLevel = _shootFrom.level;
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new IronSpikeEntity(TnunlimitedModEntities.IRON_SPIKE.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, sourceentity, 12, 1);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 5);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
					sourceentity.getPersistentData().putDouble("projCooldown", 40);
				}
			}
		}
	}
}
