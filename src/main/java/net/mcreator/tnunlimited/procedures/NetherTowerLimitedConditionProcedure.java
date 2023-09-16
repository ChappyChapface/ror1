package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.tnunlimited.network.TnunlimitedModVariables;

public class NetherTowerLimitedConditionProcedure {
	public static boolean execute(LevelAccessor world, double y) {
		return TnunlimitedModVariables.MapVariables.get(world).NetherTowerLimitedCount >= 6 && y == 29;
	}
}
