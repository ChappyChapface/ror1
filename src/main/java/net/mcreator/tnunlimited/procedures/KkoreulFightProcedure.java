package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.Difficulty;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.tnunlimited.init.TnunlimitedModMobEffects;
import net.mcreator.tnunlimited.init.TnunlimitedModGameRules;
import net.mcreator.tnunlimited.init.TnunlimitedModEntities;
import net.mcreator.tnunlimited.entity.KkoreulMinionEntity;
import net.mcreator.tnunlimited.entity.KkoreulEntity;
import net.mcreator.tnunlimited.entity.KkoreulBulletEntity;
import net.mcreator.tnunlimited.entity.EnemySignalEntity;
import net.mcreator.tnunlimited.TnunlimitedMod;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Iterator;
import java.util.Comparator;

public class KkoreulFightProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double tarX = 0;
		double tarY = 0;
		double tarZ = 0;
		double difficultyMod = 0;
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 32, 32, 32), e -> true).isEmpty() && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) {
			entity.getPersistentData().putDouble("daMod", 6);
			if (world.getDifficulty() == Difficulty.EASY) {
				difficultyMod = difficultyMod - 0.25;
				entity.getPersistentData().putDouble("daMod", 3);
			} else if (world.getDifficulty() == Difficulty.HARD) {
				difficultyMod = difficultyMod + 0.25;
				entity.getPersistentData().putDouble("daMod", 9);
			}
			if (world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE)) {
				difficultyMod = 0.5;
				entity.getPersistentData().putDouble("daMod", 12);
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2) {
				if (world.getDifficulty() == Difficulty.EASY && !world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE)) {
					difficultyMod = difficultyMod + 0.085;
				} else {
					difficultyMod = difficultyMod + 0.25;
				}
			}
			difficultyMod = 1 - difficultyMod;
			world.getLevelData().setRaining(((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2));
			if (entity.getPersistentData().getDouble("KkAtk") == 1) {
				entity.getPersistentData().putDouble("KkAtk", (-1));
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2
						&& (world.getDifficulty() == Difficulty.HARD || world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE))) {
					if (entity instanceof KkoreulEntity) {
						((KkoreulEntity) entity).setAnimation("empty");
					}
					if (entity instanceof KkoreulEntity) {
						((KkoreulEntity) entity).setAnimation("animation.Kkoreul.shriek");
					}
					TnunlimitedMod.queueServerWork((int) (40 * difficultyMod + 40 * difficultyMod + 40 * difficultyMod), () -> {
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 1);
							_entityToSpawn.setPos(x, (y + 1.5), z);
							_entityToSpawn.shoot(1, 0, (-0.5), 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 1);
							_entityToSpawn.setPos(x, (y + 1.5), z);
							_entityToSpawn.shoot(1, 0, 0.5, 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 1);
							_entityToSpawn.setPos(x, (y + 1.5), z);
							_entityToSpawn.shoot(0.5, 0, 1, 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 1);
							_entityToSpawn.setPos(x, (y + 1.5), z);
							_entityToSpawn.shoot(0.5, 0, (-1), 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 1);
							_entityToSpawn.setPos(x, (y + 1.5), z);
							_entityToSpawn.shoot((-0.5), 0, 1, 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 1);
							_entityToSpawn.setPos(x, (y + 1.5), z);
							_entityToSpawn.shoot((-0.5), 0, (-1), 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 1);
							_entityToSpawn.setPos(x, (y + 1.5), z);
							_entityToSpawn.shoot((-1), 0, 0.5, 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 1);
							_entityToSpawn.setPos(x, (y + 1.5), z);
							_entityToSpawn.shoot((-1), 0, (-0.5), 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 1);
							_entityToSpawn.setPos(x, (y + 1.5), z);
							_entityToSpawn.shoot(1, 0, 0, 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 1);
							_entityToSpawn.setPos(x, (y + 1.5), z);
							_entityToSpawn.shoot(1, 0, 1, 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 1);
							_entityToSpawn.setPos(x, (y + 1.5), z);
							_entityToSpawn.shoot(0, 0, 1, 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 1);
							_entityToSpawn.setPos(x, (y + 1.5), z);
							_entityToSpawn.shoot((-1), 0, 1, 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 1);
							_entityToSpawn.setPos(x, (y + 1.5), z);
							_entityToSpawn.shoot((-1), 0, 0, 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 1);
							_entityToSpawn.setPos(x, (y + 1.5), z);
							_entityToSpawn.shoot((-1), 0, (-1), 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 1);
							_entityToSpawn.setPos(x, (y + 1.5), z);
							_entityToSpawn.shoot(0, 0, (-1), 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 1);
							_entityToSpawn.setPos(x, (y + 1.5), z);
							_entityToSpawn.shoot(1, 0, (-1), 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					});
				}
				TnunlimitedMod.queueServerWork((int) (40 * difficultyMod), () -> {
					if (entity instanceof KkoreulEntity) {
						((KkoreulEntity) entity).setAnimation("empty");
					}
					if (entity instanceof KkoreulEntity) {
						((KkoreulEntity) entity).setAnimation("animation.Kkoreul.shriek");
					}
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 1);
						_entityToSpawn.setPos(x, (y + 1.5), z);
						_entityToSpawn.shoot(1, 0.15, (-0.5), (float) 1.5, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 1);
						_entityToSpawn.setPos(x, (y + 1.5), z);
						_entityToSpawn.shoot(1, 0.15, 0.5, (float) 1.5, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 1);
						_entityToSpawn.setPos(x, (y + 1.5), z);
						_entityToSpawn.shoot(0.5, 0.15, 1, (float) 1.5, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 1);
						_entityToSpawn.setPos(x, (y + 1.5), z);
						_entityToSpawn.shoot(0.5, 0.15, (-1), (float) 1.5, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 1);
						_entityToSpawn.setPos(x, (y + 1.5), z);
						_entityToSpawn.shoot((-0.5), 0.15, 1, (float) 1.5, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 1);
						_entityToSpawn.setPos(x, (y + 1.5), z);
						_entityToSpawn.shoot((-0.5), 0.15, (-1), (float) 1.5, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 1);
						_entityToSpawn.setPos(x, (y + 1.5), z);
						_entityToSpawn.shoot((-1), 0.15, 0.5, (float) 1.5, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 1);
						_entityToSpawn.setPos(x, (y + 1.5), z);
						_entityToSpawn.shoot((-1), 0.15, (-0.5), (float) 1.5, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				});
				TnunlimitedMod.queueServerWork((int) (40 * difficultyMod + 40 * difficultyMod), () -> {
					if (entity instanceof KkoreulEntity) {
						((KkoreulEntity) entity).setAnimation("empty");
					}
					if (entity instanceof KkoreulEntity) {
						((KkoreulEntity) entity).setAnimation("animation.Kkoreul.shriek");
					}
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 2);
						_entityToSpawn.setPos(x, (y + 1.5), z);
						_entityToSpawn.shoot(1, 0.15, 0, (float) 1.5, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 2);
						_entityToSpawn.setPos(x, (y + 1.5), z);
						_entityToSpawn.shoot(1, 0.15, 1, (float) 1.5, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 2);
						_entityToSpawn.setPos(x, (y + 1.5), z);
						_entityToSpawn.shoot(0, 0.15, 1, (float) 1.5, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 2);
						_entityToSpawn.setPos(x, (y + 1.5), z);
						_entityToSpawn.shoot((-1), 0.15, 1, (float) 1.5, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 2);
						_entityToSpawn.setPos(x, (y + 1.5), z);
						_entityToSpawn.shoot((-1), 0.15, 0, (float) 1.5, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 2);
						_entityToSpawn.setPos(x, (y + 1.5), z);
						_entityToSpawn.shoot((-1), 0.15, (-1), (float) 1.5, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 2);
						_entityToSpawn.setPos(x, (y + 1.5), z);
						_entityToSpawn.shoot(0, 0.15, (-1), (float) 1.5, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 2);
						_entityToSpawn.setPos(x, (y + 1.5), z);
						_entityToSpawn.shoot(1, 0.15, (-1), (float) 1.5, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				});
				TnunlimitedMod.queueServerWork((int) (75 * difficultyMod + 40 * difficultyMod * 3), () -> {
					entity.getPersistentData().putDouble("KkAtk", (Mth.nextInt(RandomSource.create(), 1, 3)));
				});
			}
			if (entity.getPersistentData().getDouble("KkAtk") == 2) {
				entity.getPersistentData().putDouble("KkAtk", (-1));
				if (entity instanceof KkoreulEntity) {
					((KkoreulEntity) entity).setAnimation("empty");
				}
				if (entity instanceof KkoreulEntity) {
					((KkoreulEntity) entity).setAnimation("animation.Kkoreul.shriek");
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"kill @e[type=tnunlimited:kkoreul_minion]");
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
							.collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Player) {
							if (entityiterator instanceof LivingEntity _livEnt ? _livEnt.hasEffect(TnunlimitedModMobEffects.DRYOUT.get()) : false) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level.isClientSide())
									_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.DRYOUT.get(),
											(int) ((entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(TnunlimitedModMobEffects.DRYOUT.get()) ? _livEnt.getEffect(TnunlimitedModMobEffects.DRYOUT.get()).getDuration() : 0) + 100),
											(int) ((entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(TnunlimitedModMobEffects.DRYOUT.get()) ? _livEnt.getEffect(TnunlimitedModMobEffects.DRYOUT.get()).getAmplifier() : 0) + 1)));
							} else {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level.isClientSide())
									_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.DRYOUT.get(), 600, 0));
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.DRIPPING_WATER, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 50, 1, 1, 1, 1);
							if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = new KkoreulMinionEntity(TnunlimitedModEntities.KKOREUL_MINION.get(), _level);
									entityToSpawn.moveTo((entityiterator.getX() + Mth.nextInt(RandomSource.create(), -8, 8)), y, (entityiterator.getZ() + Mth.nextInt(RandomSource.create(), -8, 8)), 0, 0);
									entityToSpawn.setYBodyRot(0);
									entityToSpawn.setYHeadRot(0);
									if (entityToSpawn instanceof Mob _mobToSpawn)
										_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE)) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = new KkoreulMinionEntity(TnunlimitedModEntities.KKOREUL_MINION.get(), _level);
										entityToSpawn.moveTo((entityiterator.getX() + Mth.nextInt(RandomSource.create(), -8, 8)), y, (entityiterator.getZ() + Mth.nextInt(RandomSource.create(), -8, 8)), 0, 0);
										entityToSpawn.setYBodyRot(0);
										entityToSpawn.setYHeadRot(0);
										if (entityToSpawn instanceof Mob _mobToSpawn)
											_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
										world.addFreshEntity(entityToSpawn);
									}
								}
							}
						}
					}
				}
				TnunlimitedMod.queueServerWork((int) (150 * difficultyMod), () -> {
					if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
						entity.getPersistentData().putDouble("KkAtk", 1);
					} else {
						entity.getPersistentData().putDouble("KkAtk", 3);
					}
				});
			}
			if (entity.getPersistentData().getDouble("KkAtk") == 3) {
				if (!(("" + (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)).equals("null"))) {
					entity.getPersistentData().putDouble("KkAtk", (-1));
					entity.getPersistentData().putDouble("tarX", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()));
					entity.getPersistentData().putDouble("tarY", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()));
					entity.getPersistentData().putDouble("tarZ", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()));
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new EnemySignalEntity(TnunlimitedModEntities.ENEMY_SIGNAL.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								entityToSpawn.setCritArrow(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, 0, 0);
						_entityToSpawn.setPos(x, (y + 1.5), z);
						_entityToSpawn.shoot((entity.getPersistentData().getDouble("tarX") - x), (entity.getPersistentData().getDouble("tarY") - y), (entity.getPersistentData().getDouble("tarZ") - z), 2, 3);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
					if (entity instanceof KkoreulEntity) {
						((KkoreulEntity) entity).setAnimation("empty");
					}
					if (entity instanceof KkoreulEntity) {
						((KkoreulEntity) entity).setAnimation("animation.Kkoreul.attack");
					}
					TnunlimitedMod.queueServerWork(30, () -> {
						for (int index0 = 0; index0 < 15; index0++) {
							if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2) {
								if (world instanceof ServerLevel projectileLevel) {
									Projectile _entityToSpawn = new Object() {
										public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
											AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
											entityToSpawn.setOwner(shooter);
											entityToSpawn.setBaseDamage(damage);
											entityToSpawn.setKnockback(knockback);
											entityToSpawn.setSilent(true);
											return entityToSpawn;
										}
									}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 1);
									_entityToSpawn.setPos(x, (y + 1.5), z);
									_entityToSpawn.shoot((entity.getPersistentData().getDouble("tarX") - x), (entity.getPersistentData().getDouble("tarY") - y + 2), (entity.getPersistentData().getDouble("tarZ") - z), 1, 40);
									projectileLevel.addFreshEntity(_entityToSpawn);
								}
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
										AbstractArrow entityToSpawn = new KkoreulBulletEntity(TnunlimitedModEntities.KKOREUL_BULLET.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("daMod"), 1);
								_entityToSpawn.setPos(x, (y + 1.5), z);
								_entityToSpawn.shoot((entity.getPersistentData().getDouble("tarX") - x), (entity.getPersistentData().getDouble("tarY") - y + 1), (entity.getPersistentData().getDouble("tarZ") - z), (float) 1.5, 25);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
						}
					});
					TnunlimitedMod.queueServerWork((int) (50 * difficultyMod + 30), () -> {
						entity.getPersistentData().putDouble("KkAtk", (Mth.nextInt(RandomSource.create(), 1, 3)));
					});
				}
			}
			if (entity.getPersistentData().getDouble("KkAtk") == 4) {
				entity.getPersistentData().putDouble("KkAtk", 0);
			}
			difficultyMod = 0;
		} else if (0 > (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) {
			if (entity instanceof KkoreulEntity) {
				((KkoreulEntity) entity).setAnimation("empty");
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
						.collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entity instanceof Player == !(entity instanceof ServerPlayer _plr207 && _plr207.level instanceof ServerLevel
							&& _plr207.getAdvancements().getOrStartProgress(_plr207.server.getAdvancements().getAdvancement(new ResourceLocation("tnunlimited:kkoreul_advancement"))).isDone())) {
						if (entity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("tnunlimited:kkoreul_advancement"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								Iterator _iterator = _ap.getRemainingCriteria().iterator();
								while (_iterator.hasNext())
									_player.getAdvancements().award(_adv, (String) _iterator.next());
							}
						}
					}
				}
			}
		} else {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) > (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) && 0 < (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) {
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1));
			}
		}
	}
}
