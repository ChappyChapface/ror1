package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.tnunlimited.world.inventory.StatSheetMenu;
import net.mcreator.tnunlimited.network.TnunlimitedModVariables;

public class GUIText6Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity instanceof Player _plr ? _plr.containerMenu instanceof StatSheetMenu : false) {
			if ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).page == 1) {
				return "Speed: " + new java.text.DecimalFormat("#.##").format((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).movementSPD);
			} else if ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).page == 2) {
				return "GunSTR: " + new java.text.DecimalFormat("#.##").format((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).gunSTR);
			}
		}
		return "";
	}
}
