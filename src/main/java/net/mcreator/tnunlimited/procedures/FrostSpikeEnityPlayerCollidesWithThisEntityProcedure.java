package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

public class FrostSpikeEnityPlayerCollidesWithThisEntityProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (0.5 <= entity.getPersistentData().getDouble("hitbox_scale")) {
			sourceentity.hurt(DamageSource.GENERIC, 5);
		}
	}
}
