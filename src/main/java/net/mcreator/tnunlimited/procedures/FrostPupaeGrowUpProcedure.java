package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.tnunlimited.init.TnunlimitedModEntities;
import net.mcreator.tnunlimited.entity.FrostPupaeEntity;
import net.mcreator.tnunlimited.entity.FrostAntWorkerEntity;
import net.mcreator.tnunlimited.entity.FrostAntEntity;
import net.mcreator.tnunlimited.entity.FrostAntAlateEntity;
import net.mcreator.tnunlimited.TnunlimitedMod;

import java.util.Comparator;

public class FrostPupaeGrowUpProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getDisplayName().getString()).equals((world instanceof Level _level ? new FrostPupaeEntity(TnunlimitedModEntities.FROST_PUPAE.get(), _level) : null).getDisplayName().getString())) {
			entity.getPersistentData().putDouble("age_up", (entity.getPersistentData().getDouble("age_up") + 1));
			if (entity.getPersistentData().getDouble("age_up") == 900) {
				if (entity instanceof FrostPupaeEntity) {
					((FrostPupaeEntity) entity).setAnimation("animation.frost_ant_larva.age_up");
				}
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 50, false, false));
				TnunlimitedMod.queueServerWork(34, () -> {
					if (1 == Mth.nextInt(RandomSource.create(), 0, 2)) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = new FrostAntEntity(TnunlimitedModEntities.FROST_ANT.get(), _level);
							entityToSpawn.moveTo((entity.getX()), (entity.getY()), (entity.getZ()), entity.getYRot(), entity.getXRot());
							entityToSpawn.setYBodyRot(entity.getYRot());
							entityToSpawn.setYHeadRot(entity.getYRot());
							if (entityToSpawn instanceof Mob _mobToSpawn)
								_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
							world.addFreshEntity(entityToSpawn);
						}
						TnunlimitedMod.queueServerWork(1, () -> {
							if (((Entity) world.getEntitiesOfClass(FrostAntEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof Mob _entity && (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _ent)
								_entity.setTarget(_ent);
							if (!entity.level.isClientSide())
								entity.discard();
						});
					} else if (1 == Mth.nextInt(RandomSource.create(), 0, 1)) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = new FrostAntAlateEntity(TnunlimitedModEntities.FROST_ANT_ALATE.get(), _level);
							entityToSpawn.moveTo((entity.getX()), (entity.getY()), (entity.getZ()), entity.getYRot(), entity.getXRot());
							entityToSpawn.setYBodyRot(entity.getYRot());
							entityToSpawn.setYHeadRot(entity.getYRot());
							if (entityToSpawn instanceof Mob _mobToSpawn)
								_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
							world.addFreshEntity(entityToSpawn);
						}
						TnunlimitedMod.queueServerWork(1, () -> {
							if (((Entity) world.getEntitiesOfClass(FrostAntAlateEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof Mob _entity && (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _ent)
								_entity.setTarget(_ent);
							if (!entity.level.isClientSide())
								entity.discard();
						});
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = new FrostAntWorkerEntity(TnunlimitedModEntities.FROST_ANT_WORKER.get(), _level);
							entityToSpawn.moveTo((entity.getX()), (entity.getY()), (entity.getZ()), entity.getYRot(), entity.getXRot());
							entityToSpawn.setYBodyRot(entity.getYRot());
							entityToSpawn.setYHeadRot(entity.getYRot());
							if (entityToSpawn instanceof Mob _mobToSpawn)
								_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
							world.addFreshEntity(entityToSpawn);
						}
						TnunlimitedMod.queueServerWork(1, () -> {
							if (((Entity) world.getEntitiesOfClass(FrostAntWorkerEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof Mob _entity && (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _ent)
								_entity.setTarget(_ent);
							if (!entity.level.isClientSide())
								entity.discard();
						});
					}
				});
			}
		}
	}
}
