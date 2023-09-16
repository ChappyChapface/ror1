package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.tnunlimited.init.TnunlimitedModParticleTypes;
import net.mcreator.tnunlimited.init.TnunlimitedModMobEffects;

public class BleedingEffectProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("bleedTimer") <= 0) {
			if (entity instanceof LivingEntity _entity)
				_entity.hurt(new DamageSource("bleed").bypassArmor(),
						(float) (4 * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TnunlimitedModMobEffects.BLEEDING.get()) ? _livEnt.getEffect(TnunlimitedModMobEffects.BLEEDING.get()).getAmplifier() : 0) + 1)));
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TnunlimitedModParticleTypes.BLOOD_DRIP.get()), x, y, z, 100, 0, 0.7, 0, 2);
			entity.getPersistentData().putDouble("bleedTimer", 60);
		} else {
			entity.getPersistentData().putDouble("bleedTimer", (entity.getPersistentData().getDouble("bleedTimer") - 1));
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TnunlimitedModParticleTypes.BLOOD_DRIP.get()), x, y, z, 1, 0, 0.7, 0, 0);
		}
	}
}
