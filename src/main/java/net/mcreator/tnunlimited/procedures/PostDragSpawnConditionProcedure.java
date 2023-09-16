package net.mcreator.tnunlimited.procedures;

public class PostDragSpawnConditionProcedure {
	public static boolean execute(double x, double z) {
		return z >= 3000 && z <= 6000 || x >= 3000 && x <= 6000 || z <= -3000 && z >= -6000 || x <= -3000 && x >= -6000;
	}
}
