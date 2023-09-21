package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.tnunlimited.init.TnunlimitedModParticleTypes;

public class DivineCodexFlyProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		immediatesourceentity.getPersistentData().putDouble("age", (1 + immediatesourceentity.getPersistentData().getDouble("age")));
		{
			Entity _ent = immediatesourceentity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "/data merge entity @s {NoGravity:1b}");
			}
		}
		if (immediatesourceentity.getPersistentData().getDouble("age") >= 100 || (world.getBlockState(new BlockPos(x, y, z))).getBlock() instanceof LiquidBlock) {
			if (!immediatesourceentity.level.isClientSide())
				immediatesourceentity.discard();
		}
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() instanceof LiquidBlock) {
			if (!immediatesourceentity.level.isClientSide())
				immediatesourceentity.discard();
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TnunlimitedModParticleTypes.DAYWALKER_SPARKLEZ.get()), x, y, z, 8, 0.1, 0.1, 0.1, 0);
	}
}
