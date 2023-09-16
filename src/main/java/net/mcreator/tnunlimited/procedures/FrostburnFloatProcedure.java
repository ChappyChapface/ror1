package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class FrostburnFloatProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		double yaw = 0;
		double pitch = 0;
		immediatesourceentity.getPersistentData().putDouble("age", (1 + immediatesourceentity.getPersistentData().getDouble("age")));
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.DRIPPING_WATER, x, y, z, 1, 0.2, 0.2, 0.2, 0);
		if (immediatesourceentity.getPersistentData().getDouble("age") >= 400 || (world.getBlockState(new BlockPos(x, y, z))).getBlock() instanceof LiquidBlock) {
			if (!immediatesourceentity.level.isClientSide())
				immediatesourceentity.discard();
		}
	}
}
