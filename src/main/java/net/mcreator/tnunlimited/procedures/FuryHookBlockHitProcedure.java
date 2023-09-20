package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.tnunlimited.network.TnunlimitedModVariables;
import net.mcreator.tnunlimited.init.TnunlimitedModMobEffects;
import net.mcreator.tnunlimited.init.TnunlimitedModItems;

public class FuryHookBlockHitProcedure {
	public static void execute(Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		Entity playe = null;
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(TnunlimitedModItems.FURY_HOOK.get(), (int) (10 + 1 * Math.sqrt(Math.pow(Math.abs(Math.abs(immediatesourceentity.getZ()) - Math.abs(entity.getZ())), 2)
					+ Math.pow(Math.abs(Math.abs(immediatesourceentity.getX()) - Math.abs(entity.getX())), 2) + Math.pow(Math.abs(Math.abs(immediatesourceentity.getY()) - Math.abs(entity.getY())), 2))));
		{
			double _setval = immediatesourceentity.getX();
			entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.tarX = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = immediatesourceentity.getY();
			entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.tarY = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = immediatesourceentity.getZ();
			entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.tarZ = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
			_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.OVERCHARGED_CLEAVER_DASH_EFFECT.get(),
					(int) (1 * Math.sqrt(Math.pow(immediatesourceentity.getZ() - entity.getZ(), 2) + Math.pow(immediatesourceentity.getX() - entity.getX(), 2) + Math.pow(immediatesourceentity.getY() - entity.getY(), 2))), 3, true, false));
	}
}
