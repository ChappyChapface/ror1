package net.mcreator.tnunlimited.procedures;

public class LeadOreAdditionalGenerationConditionProcedure {
	public static boolean execute(double x, double z) {
		return 3000 <= Math.hypot(x, z);
	}
}
