package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.entity.Entity;

public class GluttonyCraftKillsProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return ("Ingredient Count: " + entity.getPersistentData().getDouble("ingCount")) + "/6";
	}
}
