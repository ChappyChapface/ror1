package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.tnunlimited.network.TnunlimitedModVariables;

public class GUIPageDisplayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Page: " + new java.text.DecimalFormat("##").format((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).page);
	}
}
