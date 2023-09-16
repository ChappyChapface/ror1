package net.mcreator.tnunlimited.procedures;

public class FrostAntNaturalEntitySpawningConditionProcedure {
	public static boolean execute(double x, double y, double z) {
		return DuneSpiderSpawnProcedure.execute(x, z) && y <= 60;
	}
}
