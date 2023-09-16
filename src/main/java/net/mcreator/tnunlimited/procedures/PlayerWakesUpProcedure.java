package net.mcreator.tnunlimited.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.tnunlimited.network.TnunlimitedModVariables;
import net.mcreator.tnunlimited.init.TnunlimitedModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerWakesUpProcedure {
	@SubscribeEvent
	public static void onEntityEndSleep(PlayerWakeUpEvent event) {
		execute(event, event.getEntity().level, event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double message = 0;
		if (world instanceof Level _lvl0 && _lvl0.isDay()) {
			TnunlimitedModVariables.MapVariables.get(world).worldAge = TnunlimitedModVariables.MapVariables.get(world).worldAge + 24000 - world.dayTime();
			TnunlimitedModVariables.MapVariables.get(world).syncData(world);
			entity.getPersistentData().putDouble("timeWithoutRest", 0);
			if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(TnunlimitedModMobEffects.DROWSY.get()) : false) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(TnunlimitedModMobEffects.DROWSY.get());
			}
			if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(TnunlimitedModMobEffects.BEDTIME_ELIXIR.get()) : false) {
				entity.getPersistentData().putDouble("timeWithoutRest",
						((-12000) * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TnunlimitedModMobEffects.BEDTIME_ELIXIR.get()) ? _livEnt.getEffect(TnunlimitedModMobEffects.BEDTIME_ELIXIR.get()).getAmplifier() : 0) + 1)));
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 1200,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TnunlimitedModMobEffects.BEDTIME_ELIXIR.get()) ? _livEnt.getEffect(TnunlimitedModMobEffects.BEDTIME_ELIXIR.get()).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 24000,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TnunlimitedModMobEffects.BEDTIME_ELIXIR.get()) ? _livEnt.getEffect(TnunlimitedModMobEffects.BEDTIME_ELIXIR.get()).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.MANA_REGENERATION.get(), 1200,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TnunlimitedModMobEffects.BEDTIME_ELIXIR.get()) ? _livEnt.getEffect(TnunlimitedModMobEffects.BEDTIME_ELIXIR.get()).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 10,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TnunlimitedModMobEffects.BEDTIME_ELIXIR.get()) ? _livEnt.getEffect(TnunlimitedModMobEffects.BEDTIME_ELIXIR.get()).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.INSTANT_MANA_EFFECT.get(), 10,
							entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TnunlimitedModMobEffects.BEDTIME_ELIXIR.get()) ? _livEnt.getEffect(TnunlimitedModMobEffects.BEDTIME_ELIXIR.get()).getAmplifier() : 0));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(TnunlimitedModMobEffects.BEDTIME_ELIXIR.get());
			}
		}
	}
}
