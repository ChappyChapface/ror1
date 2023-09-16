package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.tnunlimited.world.inventory.StatSheetMenu;
import net.mcreator.tnunlimited.world.inventory.StarterClassMenu;
import net.mcreator.tnunlimited.network.TnunlimitedModVariables;

public class ClassTextProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity instanceof Player _plr ? _plr.containerMenu instanceof StarterClassMenu : false) {
			if ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).page == 1) {
				return "BATTLER";
			} else if ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).page == 2) {
				return "RANGER";
			} else if ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).page == 3) {
				return "MAGE";
			} else if ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).page == 4) {
				return "TAMER";
			} else if ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).page == 5) {
				return "TANK";
			}
		} else if (entity instanceof Player _plr ? _plr.containerMenu instanceof StatSheetMenu : false) {
			if ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).page == 1) {
				if ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).rpgClass == 1) {
					return "CLASS: Battler";
				} else if ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).rpgClass == 2) {
					return "CLASS: Ranger";
				} else if ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).rpgClass == 3) {
					return "CLASS: Mage";
				} else if ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).rpgClass == 4) {
					return "CLASS: Tamer";
				} else if ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).rpgClass == 5) {
					return "CLASS: Tank";
				} else if ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).rpgClass == 0) {
					return "CLASS: Null";
				}
			} else if ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).page == 2) {
				return "SlashSTR: " + new java.text.DecimalFormat("#.##").format((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).slashSTR);
			}
		}
		return "NULL";
	}
}
