package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.entity.Entity;

public class FrostantQueenMeleeConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity.getPersistentData().getString("AttackType")).equals("Chase");
	}
}
