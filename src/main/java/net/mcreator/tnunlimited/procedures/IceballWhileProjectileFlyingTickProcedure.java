package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.entity.Entity;

public class IceballWhileProjectileFlyingTickProcedure {
	public static void execute(Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		immediatesourceentity.setNoGravity(true);
	}
}
