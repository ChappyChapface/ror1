package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.tnunlimited.init.TnunlimitedModBlocks;

public class MedBlueShroomAdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (((world.getBlockState(new BlockPos(x, y, z))).getBlock() == TnunlimitedModBlocks.SHROOM_GRASS.get() || (world.getBlockState(new BlockPos(x, y, z))).getBlock() == TnunlimitedModBlocks.BLUE_SHROOMSLATE.get())
				^ ((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == TnunlimitedModBlocks.SHROOM_GRASS.get() || (world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == TnunlimitedModBlocks.BLUE_SHROOMSLATE.get())
				^ ((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == TnunlimitedModBlocks.SHROOM_GRASS.get() || (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == TnunlimitedModBlocks.BLUE_SHROOMSLATE.get())
				^ ((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == TnunlimitedModBlocks.SHROOM_GRASS.get() || (world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == TnunlimitedModBlocks.BLUE_SHROOMSLATE.get())
				^ ((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == TnunlimitedModBlocks.SHROOM_GRASS.get() || (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == TnunlimitedModBlocks.BLUE_SHROOMSLATE.get())) {
			return true;
		}
		return false;
	}
}
