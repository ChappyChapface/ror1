package net.mcreator.tnunlimited.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.tnunlimited.init.TnunlimitedModBlocks;
import net.mcreator.tnunlimited.entity.FrostAntQueenPhase2Entity;
import net.mcreator.tnunlimited.entity.FrostAntQueenEntity;

public class QueensAltarActiveUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!(!world.getEntitiesOfClass(FrostAntQueenEntity.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).isEmpty()
				|| !world.getEntitiesOfClass(FrostAntQueenPhase2Entity.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).isEmpty())) {
			world.setBlock(new BlockPos(x, y, z), TnunlimitedModBlocks.QUEENS_ALTAR.get().defaultBlockState(), 3);
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
