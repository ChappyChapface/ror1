package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class PurplePlantsAdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(new BlockPos(x, y, z))).getMaterial() == net.minecraft.world.level.material.Material.AIR && !world.canSeeSkyFromBelowWater(new BlockPos(x, y, z))
				&& (world.getBlockState(new BlockPos(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("tnunlimited:purple_cobble_shroomslate")))
				&& (world.getBlockState(new BlockPos(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("tnunlimited:blue_shroomslate")))
				&& (world.getBlockState(new BlockPos(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("tnunlimited:shroom_grass")))) {
			return true;
		}
		return false;
	}
}
