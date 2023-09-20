package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.tnunlimited.init.TnunlimitedModEnchantments;

public class FuryHookNoGravProcedure {
	public static void execute(Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		if (immediatesourceentity.getPersistentData().getDouble("xVel") == 0 && immediatesourceentity.getPersistentData().getDouble("yVel") == 0 && immediatesourceentity.getPersistentData().getDouble("zVel") == 0) {
			if (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.EXTENDED_CHAINS.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
				immediatesourceentity.getPersistentData().putDouble("life",
						(10 + EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.EXTENDED_CHAINS.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) * 3));
			} else {
				immediatesourceentity.getPersistentData().putDouble("life", 10);
			}
			immediatesourceentity.getPersistentData().putDouble("xVel", (immediatesourceentity.getDeltaMovement().x()));
			immediatesourceentity.getPersistentData().putDouble("yVel", (immediatesourceentity.getDeltaMovement().y()));
			immediatesourceentity.getPersistentData().putDouble("zVel", (immediatesourceentity.getDeltaMovement().z()));
		}
		immediatesourceentity.setDeltaMovement(new Vec3((immediatesourceentity.getPersistentData().getDouble("xVel")), (immediatesourceentity.getPersistentData().getDouble("yVel")), (immediatesourceentity.getPersistentData().getDouble("zVel"))));
		if (immediatesourceentity.getPersistentData().getDouble("life") <= 0) {
			if (!immediatesourceentity.level.isClientSide())
				immediatesourceentity.discard();
		} else {
			immediatesourceentity.getPersistentData().putDouble("life", (immediatesourceentity.getPersistentData().getDouble("life") - 1));
		}
	}
}
