package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.entity.Entity;

public class FrostSpikeEnityBoundingBoxScaleProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		return entity.getPersistentData().getDouble("hitbox_scale");
	}
}
