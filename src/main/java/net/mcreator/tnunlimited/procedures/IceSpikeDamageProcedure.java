package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.entity.Entity;

public class IceSpikeDamageProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return 0.5 <= entity.getPersistentData().getDouble("hitbox_scale");
	}
}
