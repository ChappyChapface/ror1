package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.entity.Entity;

public class OverchargedCleaverChargeControlProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("charges") < 5) {
			entity.getPersistentData().putDouble("timeUntilCharge", (entity.getPersistentData().getDouble("timeUntilCharge") - 1));
			if (entity.getPersistentData().getDouble("timeUntilCharge") <= 0) {
				entity.getPersistentData().putDouble("charges", (entity.getPersistentData().getDouble("charges") + 1));
				entity.getPersistentData().putDouble("timeUntilCharge", 200);
			}
		}
	}
}
