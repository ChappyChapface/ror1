package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class StrawberryGenProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.GRASS_BLOCK || (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.DIRT
				|| (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.PODZOL || (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.ROOTED_DIRT;
	}
}
