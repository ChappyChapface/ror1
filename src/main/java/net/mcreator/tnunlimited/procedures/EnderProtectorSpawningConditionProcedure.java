package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.tnunlimited.network.TnunlimitedModVariables;

public class EnderProtectorSpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double z) {
		return !TnunlimitedModVariables.MapVariables.get(world).dragon_killed && PostDragSpawnConditionProcedure.execute(x, z);
	}
}
