package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.tnunlimited.init.TnunlimitedModParticleTypes;

public class DivineCodexPProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TnunlimitedModParticleTypes.DAYWALKER_SPARKLEZ.get()), (immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()), 7, 0.3, 0.3, 0.3, 0.1);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.LARGE_SMOKE, (immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()), 16, 0.3, 0.3, 0.3, 0.1);
		if (!immediatesourceentity.level.isClientSide())
			immediatesourceentity.discard();
	}
}
