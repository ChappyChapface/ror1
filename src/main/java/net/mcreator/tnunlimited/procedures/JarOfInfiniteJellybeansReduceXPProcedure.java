package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

public class JarOfInfiniteJellybeansReduceXPProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) == 0 && (entity instanceof Player _plr ? _plr.getXpNeededForNextLevel() : 0) == 7) {
			entity.hurt(DamageSource.STARVE, 5);
		}
		if (entity instanceof Player _player)
			_player.giveExperiencePoints(-(1));
	}
}
