package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.tnunlimited.network.TnunlimitedModVariables;

public class ManaBarValueProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return Math.floor((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).mana) + "";
	}
}
