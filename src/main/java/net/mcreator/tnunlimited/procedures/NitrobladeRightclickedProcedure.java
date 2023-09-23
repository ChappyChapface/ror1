package net.mcreator.tnunlimited.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class NitrobladeRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		TnunlimitedModVariables.MapVariables.get(world).energybladecharge = TnunlimitedModVariables.MapVariables.get(world).energybladecharge + 3;
		TnunlimitedModVariables.MapVariables.get(world).syncData(world);
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(TnunlimitedModItems.NITROBLADE.get(), 20);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (TnunlimitedModParticleTypes.ENERGYREVERSE.get()), x, y, z, 20, 0, 0, 0, 1);
		if (TnunlimitedModVariables.MapVariables.get(world).energybladecharge > 50) {
			TnunlimitedModVariables.MapVariables.get(world).energybladecharge = 50;
			TnunlimitedModVariables.MapVariables.get(world).syncData(world);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.amethyst_block.chime")), SoundSource.NEUTRAL, 5, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.amethyst_block.chime")), SoundSource.NEUTRAL, 5, 1, false);
				}
			}
		}
	}
}
