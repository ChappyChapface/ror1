package net.mcreator.tnunlimited.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.client.Minecraft;

import net.mcreator.tnunlimited.init.TnunlimitedModMobEffects;
import net.mcreator.tnunlimited.init.TnunlimitedModEntities;
import net.mcreator.tnunlimited.entity.FrostPupaeEntity;
import net.mcreator.tnunlimited.entity.FrostPupaeAttackEntity;
import net.mcreator.tnunlimited.entity.FrostAntQueenEntity;
import net.mcreator.tnunlimited.entity.FrostAntEntity;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class FrostantqueencontrololdProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double Minions = 0;
		double nearbyminions = 0;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) {
			if (entity.getPersistentData().getDouble("AttackTime") <= 0) {
				if (("Chase").equals(entity.getPersistentData().getString("AttackType"))) {
					if (1 == Mth.nextInt(RandomSource.create(), 1, 3)) {
						entity.getPersistentData().putString("AttackType", "Summon");
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(24 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
									.collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof FrostAntEntity || entityiterator instanceof FrostPupaeEntity) {
									nearbyminions = nearbyminions + 1;
								}
							}
						}
						if (nearbyminions < 7 + (world.isClientSide() ? Minecraft.getInstance().getConnection().getOnlinePlayers().size() : ServerLifecycleHooks.getCurrentServer().getPlayerCount())) {
							entity.getPersistentData().putDouble("AttackTime", (7 + (world.isClientSide() ? Minecraft.getInstance().getConnection().getOnlinePlayers().size() : ServerLifecycleHooks.getCurrentServer().getPlayerCount())));
						}
					} else if (1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
						entity.getPersistentData().putString("AttackType", "Spew");
						entity.getPersistentData().putDouble("AttackTime", (Mth.nextInt(RandomSource.create(), 20, 40)));
					} else {
						entity.getPersistentData().putString("AttackType", "Shreik");
						entity.getPersistentData().putDouble("AttackTime", 48);
						if (entity instanceof FrostAntQueenEntity) {
							((FrostAntQueenEntity) entity).setAnimation("empty");
						}
						if (entity instanceof FrostAntQueenEntity) {
							((FrostAntQueenEntity) entity).setAnimation("animation.frost_ant_queen.scream");
						}
					}
				} else {
					if (1 == Mth.nextInt(RandomSource.create(), 1, 4)) {
						entity.getPersistentData().putString("AttackType", "Summon");
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(24 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
									.collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof FrostAntEntity || entityiterator instanceof FrostPupaeEntity) {
									nearbyminions = nearbyminions + 1;
								}
							}
						}
						if (nearbyminions < 7 + (world.isClientSide() ? Minecraft.getInstance().getConnection().getOnlinePlayers().size() : ServerLifecycleHooks.getCurrentServer().getPlayerCount())) {
							entity.getPersistentData().putDouble("AttackTime", (7 + (world.isClientSide() ? Minecraft.getInstance().getConnection().getOnlinePlayers().size() : ServerLifecycleHooks.getCurrentServer().getPlayerCount())));
						}
					} else if (1 == Mth.nextInt(RandomSource.create(), 1, 3)) {
						entity.getPersistentData().putString("AttackType", "Spew");
						entity.getPersistentData().putDouble("AttackTime", (Mth.nextInt(RandomSource.create(), 20, 40)));
					} else if (1 == Mth.nextInt(RandomSource.create(), 1, 2)) {
						entity.getPersistentData().putString("AttackType", "Chase");
						entity.getPersistentData().putDouble("AttackTime", (Mth.nextInt(RandomSource.create(), 40, 160)));
					} else {
						entity.getPersistentData().putString("AttackType", "Shreik");
						entity.getPersistentData().putDouble("AttackTime", 48);
						if (entity instanceof FrostAntQueenEntity) {
							((FrostAntQueenEntity) entity).setAnimation("empty");
						}
						if (entity instanceof FrostAntQueenEntity) {
							((FrostAntQueenEntity) entity).setAnimation("animation.frost_ant_queen.scream");
						}
					}
				}
			} else if (("Summon").equals(entity.getPersistentData().getString("AttackType"))) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new FrostPupaeEntity(TnunlimitedModEntities.FROST_PUPAE.get(), _level);
					entityToSpawn.moveTo(x, y, z, 0, 0);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			} else if (("Shreik").equals(entity.getPersistentData().getString("AttackType"))) {
				if (entity.getPersistentData().getDouble("AttackTime") <= 27) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.CLOUD, x, (y + 0.2), z, 20, 10, 0.1, 10, 0);
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
								.collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!entityiterator.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("forge:frost_ants")))) {
								entityiterator.hurt(DamageSource.FREEZE, 2);
								if (entityiterator instanceof LivingEntity _entity && !_entity.level.isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1, false, false));
								if (entityiterator instanceof LivingEntity _entity && !_entity.level.isClientSide())
									_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.DEPLETING.get(), 60, 1, false, false));
							}
						}
					}
				}
			} else if (("Spew").equals(entity.getPersistentData().getString("AttackType"))) {
				{
					Entity _ent = entity;
					_ent.setYRot((float) (entity.getYRot() + Mth.nextDouble(RandomSource.create(), -5, 5)));
					_ent.setXRot((float) (entity.getXRot() + Mth.nextDouble(RandomSource.create(), -5, 5)));
					_ent.setYBodyRot(_ent.getYRot());
					_ent.setYHeadRot(_ent.getYRot());
					_ent.yRotO = _ent.getYRot();
					_ent.xRotO = _ent.getXRot();
					if (_ent instanceof LivingEntity _entity) {
						_entity.yBodyRotO = _entity.getYRot();
						_entity.yHeadRotO = _entity.getYRot();
					}
				}
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level;
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new FrostPupaeAttackEntity(TnunlimitedModEntities.FROST_PUPAE_ATTACK.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, (float) (2 + (world.isClientSide() ? Minecraft.getInstance().getConnection().getOnlinePlayers().size() : ServerLifecycleHooks.getCurrentServer().getPlayerCount())), (int) 0.2);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, (float) 0.8, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			}
			entity.getPersistentData().putDouble("AttackTime", (entity.getPersistentData().getDouble("AttackTime") - 1));
		}
	}
}
