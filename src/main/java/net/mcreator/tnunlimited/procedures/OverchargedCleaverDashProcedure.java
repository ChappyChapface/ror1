package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;

import net.mcreator.tnunlimited.network.TnunlimitedModVariables;
import net.mcreator.tnunlimited.init.TnunlimitedModMobEffects;
import net.mcreator.tnunlimited.TnunlimitedMod;

public class OverchargedCleaverDashProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double d = 0;
		double n = 0;
		double pitch = 0;
		double yaw = 0;
		if (entity.isOnGround() && entity.getPersistentData().getDouble("charges") > 0) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 60);
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			entity.getPersistentData().putDouble("charges", (entity.getPersistentData().getDouble("charges") - 1));
			entity.getPersistentData().putDouble("startX", (entity.getX()));
			entity.getPersistentData().putDouble("startZ", (entity.getZ()));
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 4));
			TnunlimitedMod.queueServerWork(20, () -> {
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.OVERCHARGED_CLEAVER_DASH_EFFECT.get(), 15, 1));
				{
					double _setval = entity.getXRot();
					entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.playerPitch = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = entity.getYRot();
					entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.playerYaw = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			});
			if (entity.getPersistentData().getDouble("charges") <= 0) {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 600);
				entity.getPersistentData().putDouble("timeUntilCharge", 800);
			}
		}
	}
}
