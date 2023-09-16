package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.tnunlimited.init.TnunlimitedModItems;

public class OffHandBulletTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		immediatesourceentity.setDeltaMovement(new Vec3((immediatesourceentity.getDeltaMovement().x()), (immediatesourceentity.getDeltaMovement().y() + 1.01 / 20), (immediatesourceentity.getDeltaMovement().z())));
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() instanceof LiquidBlock) {
			if (!immediatesourceentity.level.isClientSide())
				immediatesourceentity.discard();
		}
		immediatesourceentity.getPersistentData().putDouble("distance", (immediatesourceentity.getPersistentData().getDouble("distance") + 1));
		if (0 == immediatesourceentity.getPersistentData().getDouble("maxDistance")) {
			immediatesourceentity.getPersistentData().putDouble("maxDistance", 5);
			if (TnunlimitedModItems.REVOLVER.get() == (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()) {
				immediatesourceentity.getPersistentData().putDouble("maxDistance", 5);
			} else if (TnunlimitedModItems.FLINTLOCK.get() == (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()) {
				immediatesourceentity.getPersistentData().putDouble("maxDistance", 7);
			} else if (TnunlimitedModItems.ANTIMONY_STEN.get() == (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()) {
				immediatesourceentity.getPersistentData().putDouble("maxDistance", 2);
			} else if (TnunlimitedModItems.BLUNDERBUSS.get() == (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()) {
				immediatesourceentity.getPersistentData().putDouble("maxDistance", 2);
			} else if (TnunlimitedModItems.NUBRIUM_PISTOL.get() == (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()) {
				immediatesourceentity.getPersistentData().putDouble("maxDistance", 3);
			}
		}
		if (immediatesourceentity.getPersistentData().getDouble("maxDistance") <= immediatesourceentity.getPersistentData().getDouble("distance")) {
			if (!immediatesourceentity.level.isClientSide())
				immediatesourceentity.discard();
		}
	}
}
