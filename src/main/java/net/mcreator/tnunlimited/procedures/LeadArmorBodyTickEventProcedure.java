package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class LeadArmorBodyTickEventProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) > 5) {
			if (entity instanceof Player _player)
				_player.getFoodData().setSaturation(5);
		}
	}
}
