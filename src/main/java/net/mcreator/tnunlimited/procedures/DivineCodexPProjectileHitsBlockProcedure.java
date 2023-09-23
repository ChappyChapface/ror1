package net.mcreator.tnunlimited.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class DivineCodexPProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TnunlimitedModParticleTypes.DELETED_MOD_ELEMENT.get()), (immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()), 7, 0.3, 0.3, 0.3, 0.1);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.LARGE_SMOKE, (immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()), 16, 0.3, 0.3, 0.3, 0.1);
		if (!immediatesourceentity.level.isClientSide())
			immediatesourceentity.discard();
	}
}
