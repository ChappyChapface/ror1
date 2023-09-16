package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.tnunlimited.init.TnunlimitedModParticleTypes;
import net.mcreator.tnunlimited.init.TnunlimitedModMobEffects;
import net.mcreator.tnunlimited.init.TnunlimitedModEntities;
import net.mcreator.tnunlimited.entity.BloodripSpikeEntity;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class BloodOrbFloatProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		double yaw = 0;
		double pitch = 0;
		immediatesourceentity.getPersistentData().putDouble("age", (1 + immediatesourceentity.getPersistentData().getDouble("age")));
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TnunlimitedModParticleTypes.BLOODSPLASH.get()), x, y, z, 1, 0.2, 0.2, 0.2, 0);
		if (immediatesourceentity.getPersistentData().getDouble("age") >= 400 || (world.getBlockState(new BlockPos(x, y, z))).getBlock() instanceof LiquidBlock) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TnunlimitedModParticleTypes.BLOODSPLASH.get()), x, y, z, 20, 0.2, 0.2, 0.2, 2);
			if (!immediatesourceentity.level.isClientSide())
				immediatesourceentity.discard();
		}
		if (immediatesourceentity.getPersistentData().getDouble("age") % 20 == 1) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TnunlimitedModParticleTypes.BLOODSPLASH.get()), x, y, z, 20, 0.2, 0.2, 0.2, 2);
			for (int index0 = 0; index0 < 6; index0++) {
				{
					Entity _shootFrom = immediatesourceentity;
					Level projectileLevel = _shootFrom.level;
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new BloodripSpikeEntity(TnunlimitedModEntities.BLOODRIP_SPIKE.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								entityToSpawn.setPierceLevel(piercing);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, 10, 0, (byte) 1);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 360);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (!(entity == entityiterator)) {
					if (entityiterator instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.BLEEDING.get(), 60, 1));
				}
			}
		}
	}
}
