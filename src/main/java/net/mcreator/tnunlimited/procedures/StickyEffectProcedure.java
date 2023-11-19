package net.mcreator.tnunlimited.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class StickyEffectProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 3, false, false));
		if (entity.isOnGround()) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 2, 128, false, false));
		}
		if (entity.getPersistentData().getDouble("StickySound308") == 0) {
			entity.getPersistentData().putDouble("StickySound308", 20);
		} else {
			entity.getPersistentData().putDouble("StickySound308", (entity.getPersistentData().getDouble("StickySound308") - 1));
		}
		if (entity.getPersistentData().getDouble("StickySound308") == 0) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.slime_block.step")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.slime_block.step")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TnunlimitedModParticleTypes.DELETED_MOD_ELEMENT.get()), x, y, z, 3, 1, 1, 1, 1);
		}
	}
}
