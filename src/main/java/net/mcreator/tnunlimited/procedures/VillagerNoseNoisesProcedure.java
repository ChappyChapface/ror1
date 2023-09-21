package net.mcreator.tnunlimited.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class VillagerNoseNoisesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("VillageTime453") == 0) {
			entity.getPersistentData().putDouble("VillageTime453", 600);
		} else {
			entity.getPersistentData().putDouble("VillageTime453", (entity.getPersistentData().getDouble("VillageTime453") - 1));
		}
		if (entity.getPersistentData().getDouble("VillageTime453") == 0) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.villager.ambient")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.villager.ambient")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
	}
}
