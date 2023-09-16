package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.entity.Entity;

public class GluttonyCraftNBTDisplayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Ingredient Value: " + entity.getPersistentData().getDouble("foodQuality");
	}
}
