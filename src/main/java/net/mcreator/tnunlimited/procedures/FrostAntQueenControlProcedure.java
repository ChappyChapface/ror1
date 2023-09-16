package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.tnunlimited.init.TnunlimitedModEntities;
import net.mcreator.tnunlimited.entity.FrostSpikeEntity;
import net.mcreator.tnunlimited.entity.FrostPupaeAttackEntity;
import net.mcreator.tnunlimited.entity.FrostAntQueenEntity;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class FrostAntQueenControlProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double Minions = 0;
		double nearbyminions = 0;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
			if (!(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) + " entity").equals("null entity"))) {
				entity.getPersistentData().putDouble("DespawnTimer", 0);
				if (entity.getPersistentData().getDouble("AttackTime") <= 0) {
					if ((entity.getPersistentData().getString("AttackType")).equals("Chase")) {
						if (Mth.nextInt(RandomSource.create(), 1, 4) == 2) {
							if (Math.abs(entity.getX() - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()) <= 10
									&& Math.abs(entity.getY() - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()) <= 3
									&& Math.abs(entity.getZ() - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()) <= 10) {
								entity.getPersistentData().putString("AttackType", "Shreik");
								entity.getPersistentData().putDouble("AttackTime", 66);
								if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 66, 50, true, false));
								if (entity instanceof FrostAntQueenEntity) {
									((FrostAntQueenEntity) entity).setAnimation("empty");
								}
								if (entity instanceof FrostAntQueenEntity) {
									((FrostAntQueenEntity) entity).setAnimation("animation.frost_ant_queen.scream");
								}
							} else {
								entity.getPersistentData().putString("AttackType", "Chase");
							}
						} else if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
							entity.getPersistentData().putString("AttackType", "Spew");
							entity.getPersistentData().putDouble("AttackTime", 94);
							if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 94, 50, true, false));
							if (entity instanceof FrostAntQueenEntity) {
								((FrostAntQueenEntity) entity).setAnimation("empty");
							}
							if (entity instanceof FrostAntQueenEntity) {
								((FrostAntQueenEntity) entity).setAnimation("animation.frost_ant_queen.spew");
							}
						} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
							entity.getPersistentData().putString("AttackType", "Spike");
							entity.getPersistentData().putDouble("AttackTime", 94);
							if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 94, 50, true, false));
							if (entity instanceof FrostAntQueenEntity) {
								((FrostAntQueenEntity) entity).setAnimation("empty");
							}
							if (entity instanceof FrostAntQueenEntity) {
								((FrostAntQueenEntity) entity).setAnimation("animation.frost_ant_queen.spew");
							}
						} else {
							entity.getPersistentData().putString("AttackType", "Chase");
							if (world.getDifficulty() == Difficulty.EASY) {
								entity.getPersistentData().putDouble("AttackTime", (Mth.nextInt(RandomSource.create(), 40, 200)));
							} else if (world.getDifficulty() == Difficulty.NORMAL) {
								entity.getPersistentData().putDouble("AttackTime", (Mth.nextInt(RandomSource.create(), 40, 120)));
							} else if (world.getDifficulty() == Difficulty.HARD) {
								entity.getPersistentData().putDouble("AttackTime", (Mth.nextInt(RandomSource.create(), 40, 60)));
							}
						}
					} else {
						entity.getPersistentData().putString("AttackType", "Chase");
						if (world.getDifficulty() == Difficulty.EASY) {
							entity.getPersistentData().putDouble("AttackTime", (Mth.nextInt(RandomSource.create(), 40, 200)));
						} else if (world.getDifficulty() == Difficulty.NORMAL) {
							entity.getPersistentData().putDouble("AttackTime", (Mth.nextInt(RandomSource.create(), 40, 120)));
						} else if (world.getDifficulty() == Difficulty.HARD) {
							entity.getPersistentData().putDouble("AttackTime", (Mth.nextInt(RandomSource.create(), 40, 60)));
						}
					}
				}
			} else {
				entity.getPersistentData().putDouble("DespawnTimer", (1 + entity.getPersistentData().getDouble("DespawnTimer")));
				if (entity.getPersistentData().getDouble("DespawnTimer") > 1200
						&& (entity.getDisplayName().getString()).equals((world instanceof Level _level ? new FrostAntQueenEntity(TnunlimitedModEntities.FROST_ANT_QUEEN.get(), _level) : null).getDisplayName().getString())) {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Frost Ant Queen has despawned"), false);
					if (!entity.level.isClientSide())
						entity.discard();
				}
			}
			if (entity.getPersistentData().getDouble("AttackTime") > 0) {
				if ((entity.getPersistentData().getString("AttackType")).equals("Shreik")) {
					if (entity.getPersistentData().getDouble("AttackTime") <= 30) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.CLOUD, x, y, z, 20, 10, 0.1, 10, 0);
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
									.collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (Math.abs(entityiterator.getY() - y) < 2 && !entityiterator.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("forge:frost_ants")))) {
									entityiterator.hurt(DamageSource.FREEZE, 2);
									if (entityiterator instanceof LivingEntity _entity && !_entity.level.isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 2));
									{
										Entity _ent = entityiterator;
										_ent.setYRot((float) (entityiterator.getYRot() + Mth.nextDouble(RandomSource.create(), -5, 5)));
										_ent.setXRot((float) (entityiterator.getXRot() + Mth.nextDouble(RandomSource.create(), -5, 5)));
										_ent.setYBodyRot(_ent.getYRot());
										_ent.setYHeadRot(_ent.getYRot());
										_ent.yRotO = _ent.getYRot();
										_ent.xRotO = _ent.getXRot();
										if (_ent instanceof LivingEntity _entity) {
											_entity.yBodyRotO = _entity.getYRot();
											_entity.yHeadRotO = _entity.getYRot();
										}
									}
								}
							}
						}
					}
				} else if ((entity.getPersistentData().getString("AttackType")).equals("Spew")) {
					if (!(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) + " entity").equals("null entity"))) {
						if (entity.getPersistentData().getDouble("AttackTime") <= 80) {
							if (entity instanceof Mob _entity)
								_entity.getNavigation().stop();
							{
								Entity _ent = entity;
								if (!_ent.level.isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
													_ent.getDisplayName(), _ent.level.getServer(), _ent),
											("tp @s ~ ~ ~ facing entity @e[limit=1,sort=nearest,name=\"" + "" + (((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getDisplayName().getString()) + "" + "\"]")));
								}
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
										AbstractArrow entityToSpawn = new FrostPupaeAttackEntity(TnunlimitedModEntities.FROST_PUPAE_ATTACK.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 4, 0);
								_entityToSpawn.setPos(x, (y + 1.5), z);
								_entityToSpawn.shoot(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - x), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() - y),
										((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - z), 2, 10);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
						}
					} else {
						entity.getPersistentData().putDouble("AttackTime", 0);
						if (entity instanceof FrostAntQueenEntity) {
							((FrostAntQueenEntity) entity).setAnimation("empty");
						}
					}
				} else if ((entity.getPersistentData().getString("AttackType")).equals("Spike")) {
					if (!(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) + " entity").equals("null entity"))) {
						if (entity.getPersistentData().getDouble("AttackTime") <= 80 && entity.getPersistentData().getDouble("AttackTime") % 10 == 2) {
							if (entity instanceof Mob _entity)
								_entity.getNavigation().stop();
							{
								Entity _ent = entity;
								if (!_ent.level.isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
													_ent.getDisplayName(), _ent.level.getServer(), _ent),
											("tp @s ~ ~ ~ facing block "
													+ (((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()) + " ") + "" + (((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()) + " ")) + ""
															+ ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()))));
								}
							}
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
										AbstractArrow entityToSpawn = new FrostSpikeEntity(TnunlimitedModEntities.FROST_SPIKE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 7, (int) 0.5);
								_entityToSpawn.setPos(x, (y + 1.5), z);
								_entityToSpawn.shoot(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - x), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() - y),
										((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - z), 2, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
						}
					} else {
						entity.getPersistentData().putDouble("AttackTime", 0);
						if (entity instanceof FrostAntQueenEntity) {
							((FrostAntQueenEntity) entity).setAnimation("empty");
						}
					}
				}
			}
			entity.getPersistentData().putDouble("AttackTime", (entity.getPersistentData().getDouble("AttackTime") - 1));
		}
	}
}
