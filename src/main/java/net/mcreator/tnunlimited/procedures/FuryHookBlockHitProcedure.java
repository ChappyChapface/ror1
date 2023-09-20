package net.mcreator.tnunlimited.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class FuryHookBlockHitProcedure {
	public static void execute(Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		Entity playe = null;
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(TnunlimitedModItems.DELETED_MOD_ELEMENT.get(), (int) (10 + 1 * Math.sqrt(Math.pow(Math.abs(Math.abs(immediatesourceentity.getZ()) - Math.abs(entity.getZ())), 2)
					+ Math.pow(Math.abs(Math.abs(immediatesourceentity.getX()) - Math.abs(entity.getX())), 2) + Math.pow(Math.abs(Math.abs(immediatesourceentity.getY()) - Math.abs(entity.getY())), 2))));
		if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
			_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.OVERCHARGED_CLEAVER_DASH_EFFECT.get(),
					(int) (1 * Math.sqrt(Math.pow(immediatesourceentity.getZ() - entity.getZ(), 2) + Math.pow(immediatesourceentity.getX() - entity.getX(), 2) + Math.pow(immediatesourceentity.getY() - entity.getY(), 2))), 3, true, false));
	}
}
