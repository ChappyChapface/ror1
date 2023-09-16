package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.tnunlimited.init.TnunlimitedModMobEffects;
import net.mcreator.tnunlimited.init.TnunlimitedModItems;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class InfernoEffectProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("infernoTimer", (entity.getPersistentData().getDouble("infernoTimer") + 1));
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.FLAME, x, y, z, 20, (entity.getBbWidth() / 2), (entity.getBbHeight()), (entity.getBbWidth() / 2), 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SMOKE, x, y, z, 10, (entity.getBbWidth() / 2), (entity.getBbHeight()), (entity.getBbWidth() / 2), 0);
		if (entity.getPersistentData().getDouble("infernoTimer") <= 60
				- (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TnunlimitedModMobEffects.INFERNO.get()) ? _livEnt.getEffect(TnunlimitedModMobEffects.INFERNO.get()).getAmplifier() : 0) * 5) {
			entity.hurt(DamageSource.ON_FIRE, (float) (2 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TnunlimitedModMobEffects.INFERNO.get()) ? _livEnt.getEffect(TnunlimitedModMobEffects.INFERNO.get()).getAmplifier() : 0)));
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world
						.getEntitiesOfClass(Entity.class,
								new AABB(_center, _center).inflate(
										(3 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TnunlimitedModMobEffects.INFERNO.get()) ? _livEnt.getEffect(TnunlimitedModMobEffects.INFERNO.get()).getAmplifier() : 0)) / 2d),
								e -> true)
						.stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (!((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TnunlimitedModItems.HEATWAVE.get())) {
						entityiterator.hurt(DamageSource.ON_FIRE,
								(float) (2 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TnunlimitedModMobEffects.INFERNO.get()) ? _livEnt.getEffect(TnunlimitedModMobEffects.INFERNO.get()).getAmplifier() : 0)));
						entityiterator.setSecondsOnFire((int) (3 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TnunlimitedModMobEffects.INFERNO.get()) ? _livEnt.getEffect(TnunlimitedModMobEffects.INFERNO.get()).getAmplifier() : 0)));
					}
				}
			}
			entity.getPersistentData().putDouble("infernoTimer", 0);
		}
	}
}
