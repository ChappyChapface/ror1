package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.entity.Entity;

public class NotRidingProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return !entity.isPassenger();
	}
}
