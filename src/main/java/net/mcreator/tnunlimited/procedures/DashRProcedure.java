package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.tnunlimited.network.TnunlimitedModVariables;
import net.mcreator.tnunlimited.init.TnunlimitedModMobEffects;
import net.mcreator.tnunlimited.init.TnunlimitedModItems;

public class DashRProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).Acc00).getItem() == TnunlimitedModItems.SHIFT_PLATE.get()
				|| ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).Acc01).getItem() == TnunlimitedModItems.SHIFT_PLATE.get()
				|| ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).Acc02).getItem() == TnunlimitedModItems.SHIFT_PLATE.get()) {
			{
				Entity _ent = entity;
				_ent.setYRot((float) (entity.getYRot() + 270));
				_ent.setXRot(entity.getXRot());
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
			{
				double _setval = entity.getYRot();
				entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.playerYaw = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = entity.getXRot();
				entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.playerPitch = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.OVERCHARGED_CLEAVER_DASH_EFFECT.get(), 2, 0));
		} else if (entity.isOnGround()) {
			entity.setDeltaMovement(new Vec3((0.5 * Math.sin((90 - (180 + entity.getYRot())) * (3.14159 / 180))), 0.3, (0.5 * Math.sin((180 + entity.getYRot()) * (3.14159 / 180)))));
		}
	}
}
