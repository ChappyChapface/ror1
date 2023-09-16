package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class UndergroundStoneConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return y <= 50 && ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.STONE || (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.GRANITE
				|| (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.ANDESITE || (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.DIORITE);
	}
}
