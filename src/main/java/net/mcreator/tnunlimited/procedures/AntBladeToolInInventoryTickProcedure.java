package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.item.ItemStack;

public class AntBladeToolInInventoryTickProcedure {
	public static void execute(ItemStack itemstack) {
		if (0 <= itemstack.getOrCreateTag().getDouble("cooldown")) {
			itemstack.getOrCreateTag().putDouble("cooldown", (itemstack.getOrCreateTag().getDouble("cooldown") - 1));
		}
	}
}
