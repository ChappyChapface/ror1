package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.tnunlimited.world.inventory.StatSheetMenu;
import net.mcreator.tnunlimited.world.inventory.StarterClassMenu;
import net.mcreator.tnunlimited.network.TnunlimitedModVariables;

public class ClassText2Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity instanceof Player _plr ? _plr.containerMenu instanceof StarterClassMenu : false) {
			if ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).page == 1) {
				return "+25% Melee Damage";
			} else if ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).page == 2) {
				return "+25% Ranged Damage";
			} else if ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).page == 3) {
				return "+25% Magic Damage";
			} else if ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).page == 4) {
				return "+25% Familiar Damage";
			} else if ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).page == 5) {
				return "+25% Armor";
			}
		} else if (entity instanceof Player _plr ? _plr.containerMenu instanceof StatSheetMenu : false) {
			if ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).page == 1) {
				return "";
			} else if ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).page == 2) {
				return "PiercingSTR: " + new java.text.DecimalFormat("#.##").format((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).piercingSTR);
			}
		}
		return "";
	}
}
