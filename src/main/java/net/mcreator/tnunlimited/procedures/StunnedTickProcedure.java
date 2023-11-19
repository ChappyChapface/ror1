package net.mcreator.tnunlimited.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class StunnedTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (0 >= entity.getDeltaMovement().y()) {
			entity.setDeltaMovement(new Vec3(0, (entity.getDeltaMovement().y()), 0));
		} else {
			entity.setDeltaMovement(new Vec3(0, 0, 0));
		}
		if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 255, true, false));
		{
			Entity _ent = entity;
			_ent.setYRot((float) (entity.getYRot() + Mth.nextInt(RandomSource.create(), -5, 5)));
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
	}
}
