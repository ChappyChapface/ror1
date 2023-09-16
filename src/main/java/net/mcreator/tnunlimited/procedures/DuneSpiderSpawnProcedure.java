package net.mcreator.tnunlimited.procedures;

public class DuneSpiderSpawnProcedure {
	public static boolean execute(double x, double z) {
		return x >= 3000 && x <= 6000 || z >= 3000 && z <= 6000 || x <= -3000 && x >= -6000 || z <= -3000 && z >= -6000;
	}
}
