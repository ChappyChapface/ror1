package net.mcreator.tnunlimited.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

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
			_level.sendParticles((SimpleParticleType) (TnunlimitedModParticleTypes.DELETED_MOD_ELEMENT.get()), x, y, z, 8, 0.1, 0.1, 0.1, 0);
	}
}
