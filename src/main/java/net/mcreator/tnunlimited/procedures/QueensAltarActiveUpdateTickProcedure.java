package net.mcreator.tnunlimited.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class QueensAltarActiveUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!(!world.getEntitiesOfClass(FrostAntQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).isEmpty()
				|| !world.getEntitiesOfClass(FrostAntQueenPhase2Entity.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).isEmpty())) {
			world.setBlock(new BlockPos(x, y, z), TnunlimitedModItems.DELETED_MOD_ELEMENT.get().defaultBlockState(), 3);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.deactivate")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.deactivate")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
		}
	}
}
