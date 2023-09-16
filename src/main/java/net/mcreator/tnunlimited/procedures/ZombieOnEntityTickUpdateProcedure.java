package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.tnunlimited.TnunlimitedMod;

public class ZombieOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		TnunlimitedMod.queueServerWork(1200, () -> {
			if (!entity.level.isClientSide())
				entity.discard();
		});
	}
}
