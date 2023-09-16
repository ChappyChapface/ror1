package net.mcreator.tnunlimited.procedures;

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
import net.minecraft.world.Difficulty;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Registry;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.tnunlimited.init.TnunlimitedModEntities;
import net.mcreator.tnunlimited.entity.SlashProjectileEntity;
import net.mcreator.tnunlimited.entity.SlashProjectile2Entity;
import net.mcreator.tnunlimited.entity.FrostSpikeEnityEntity;
import net.mcreator.tnunlimited.entity.FrostPupaeAttackEntity;
import net.mcreator.tnunlimited.entity.FrostAntQueenPhase2Entity;
import net.mcreator.tnunlimited.entity.FrostAntQueenEntity;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class FrostAntQueenPhase2ControlProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double Minions = 0;
		double nearbyminions = 0;
		double d = 0;
		double n = 0;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
			if (!(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) + " entity").equals("null entity"))) {
				entity.getPersistentData().putDouble("DespawnTimer", 0);
				if (entity.getPersistentData().getDouble("AttackTime") <= 0) {
					if ((entity.getPersistentData().getString("AttackType")).equals("Chase")) {
						if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
							if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 50) {
								entity.getPersistentData().putString("AttackType", "Slash");
								entity.getPersistentData().putDouble("AttackTime", 46);
								if (entity instanceof FrostAntQueenPhase2Entity) {
									((FrostAntQueenPhase2Entity) entity).setAnimation("empty");
								}
								if (entity instanceof FrostAntQueenPhase2Entity) {
									((FrostAntQueenPhase2Entity) entity).setAnimation("animation.frost_ant_queen_phase2.slash");
								}
								if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 46, 50, false, false));
							} else {
								entity.getPersistentData().putString("AttackType", "Chase");
								if (world.getDifficulty() == Difficulty.EASY) {
									entity.getPersistentData().putDouble("AttackTime", (Mth.nextInt(RandomSource.create(), 40, 210)));
								} else if (world.getDifficulty() == Difficulty.NORMAL) {
									entity.getPersistentData().putDouble("AttackTime", (Mth.nextInt(RandomSource.create(), 40, 180)));
								} else if (world.getDifficulty() == Difficulty.HARD) {
									entity.getPersistentData().putDouble("AttackTime", (Mth.nextInt(RandomSource.create(), 40, 120)));
								}
							}
						} else if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
							entity.getPersistentData().putString("AttackType", "Meditate");
							entity.getPersistentData().putDouble("AttackTime", 73);
							if (entity instanceof FrostAntQueenPhase2Entity) {
								((FrostAntQueenPhase2Entity) entity).setAnimation("empty");
							}
							if (entity instanceof FrostAntQueenPhase2Entity) {
								((FrostAntQueenPhase2Entity) entity).setAnimation("animation.frost_ant_queen_phase2.meditate");
							}
							if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 73, 50, false, false));
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
					} else if ((entity.getPersistentData().getString("AttackType")).equals("Spawn")) {
						{
							Entity _ent = entity;
							if (!_ent.level.isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "/data merge entity @s {Invulnerable:0b}");
							}
						}
						entity.getPersistentData().putString("AttackType", "Chase");
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
				if ((entity.getPersistentData().getString("AttackType")).equals("Parry")) {
					if (entity.getPersistentData().getDouble("AttackTime") == 9) {
						if (entity instanceof FrostAntQueenPhase2Entity) {
							((FrostAntQueenPhase2Entity) entity).setAnimation("empty");
						}
						if (entity instanceof FrostAntQueenPhase2Entity) {
							((FrostAntQueenPhase2Entity) entity).setAnimation("animation.frost_ant_queen_phase2.parry");
						}
					}
				} else if ((entity.getPersistentData().getString("AttackType")).equals("Spew")) {
					if (!(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) + " entity").equals("null entity"))) {
						if (entity.getPersistentData().getDouble("AttackTime") <= 80) {
							if (entity instanceof Mob _entity)
								_entity.getNavigation().stop();
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
									}.getArrow(projectileLevel, entity, 4, 0);
									_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
									_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 2, 10);
									projectileLevel.addFreshEntity(_entityToSpawn);
								}
							}
							{
								Entity _ent = entity;
								if (!_ent.level.isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(),
													_ent.getDisplayName(), _ent.level.getServer(), _ent),
											("tp @s ~ ~ ~ facing entity @e[limit=1,sort=nearest,name=\"" + "" + (((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getDisplayName().getString()) + "" + "\"]")));
								}
							}
						}
					} else {
						entity.getPersistentData().putDouble("AttackTime", 0);
						if (entity instanceof FrostAntQueenEntity) {
							((FrostAntQueenEntity) entity).setAnimation("empty");
						}
					}
				} else if ((entity.getPersistentData().getString("AttackType")).equals("Slash")) {
					if (!(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) + " entity").equals("null entity"))) {
						if (entity.getPersistentData().getDouble("AttackTime") <= 28 && entity.getPersistentData().getDouble("AttackTime") % 16 == 12) {
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
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
										AbstractArrow entityToSpawn = new SlashProjectileEntity(TnunlimitedModEntities.SLASH_PROJECTILE.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										entityToSpawn.setPierceLevel(piercing);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 7, (int) 0.5, (byte) 1);
								_entityToSpawn.setPos(x, (y + 1.5), z);
								_entityToSpawn.shoot(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - x), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() - y),
										((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - z), 1, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
						}
						if (entity.getPersistentData().getDouble("AttackTime") <= 28 && entity.getPersistentData().getDouble("AttackTime") % 16 == 4) {
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
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
										AbstractArrow entityToSpawn = new SlashProjectile2Entity(TnunlimitedModEntities.SLASH_PROJECTILE_2.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										entityToSpawn.setPierceLevel(piercing);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 7, (int) 0.5, (byte) 1);
								_entityToSpawn.setPos(x, (y + 1.5), z);
								_entityToSpawn.shoot(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - x), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() - y),
										((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - z), 1, 0);
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
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 50 && entity.getPersistentData().getDouble("AttackTime") % 10 == 2) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
								.collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!entityiterator.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("forge:frost_ants"))) && entityiterator.isOnGround()
									&& !entityiterator.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("forge:inanimate")))) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = new FrostSpikeEnityEntity(TnunlimitedModEntities.FROST_SPIKE_ENITY.get(), _level);
									entityToSpawn.moveTo((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), world.getRandom().nextFloat() * 360F, 0);
									if (entityToSpawn instanceof Mob _mobToSpawn)
										_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
									world.addFreshEntity(entityToSpawn);
								}
							}
						}
					}
					if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, 1, false, false));
				}
			}
			entity.getPersistentData().putDouble("AttackTime", (entity.getPersistentData().getDouble("AttackTime") - 1));
		}
	}
}
