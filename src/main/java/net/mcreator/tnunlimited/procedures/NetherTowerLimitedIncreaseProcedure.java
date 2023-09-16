package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.tnunlimited.network.TnunlimitedModVariables;

public class NetherTowerLimitedIncreaseProcedure {
	public static void execute(LevelAccessor world) {
		TnunlimitedModVariables.MapVariables.get(world).NetherTowerLimitedCount = TnunlimitedModVariables.MapVariables.get(world).NetherTowerLimitedCount + 1;
		TnunlimitedModVariables.MapVariables.get(world).syncData(world);
	}
}
