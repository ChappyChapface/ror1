package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.tnunlimited.init.TnunlimitedModParticleTypes;

public class FrostAntQueenShardsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TnunlimitedModParticleTypes.ICE_SHARDS.get()), x, (y + 1.85), z, 10, 1.72, 1.85, 1.72, 0.1);
	}
}
