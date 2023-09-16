package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.tnunlimited.network.TnunlimitedModVariables;
import net.mcreator.tnunlimited.init.TnunlimitedModParticleTypes;
import net.mcreator.tnunlimited.init.TnunlimitedModItems;

public class NitrobladeEntitySwingsItemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		TnunlimitedModVariables.MapVariables.get(world).energybladecharge = TnunlimitedModVariables.MapVariables.get(world).energybladecharge - 8;
		TnunlimitedModVariables.MapVariables.get(world).syncData(world);
		if (TnunlimitedModVariables.MapVariables.get(world).energybladecharge < 0) {
			TnunlimitedModVariables.MapVariables.get(world).energybladecharge = 50;
			TnunlimitedModVariables.MapVariables.get(world).syncData(world);
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(TnunlimitedModItems.NITROBLADE.get(), 134);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TnunlimitedModParticleTypes.ENERGY.get()), x, y, z, 20, 0, 0, 0, 1);
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 134, 255, false, false));
		}
	}
}
