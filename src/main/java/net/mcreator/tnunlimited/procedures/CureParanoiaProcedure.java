package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.network.chat.Component;

import net.mcreator.tnunlimited.init.TnunlimitedModMobEffects;
import net.mcreator.tnunlimited.init.TnunlimitedModItems;

public class CureParanoiaProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getItem() == TnunlimitedModItems.SLOTHS_BEDTIME_ELIXIR.get()) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.BEDTIME_ELIXIR.get(), 2400, 0));
		} else if (itemstack.getItem() == TnunlimitedModItems.SLOTHS_BEDTIME_ELIXIR_2.get()) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.BEDTIME_ELIXIR.get(), 2400, 2));
		} else if (itemstack.getItem() == TnunlimitedModItems.SLOTHS_BEDTIME_ELIXIR_3.get()) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.BEDTIME_ELIXIR.get(), 2400, 2));
		}
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(TnunlimitedModMobEffects.PARANOIA.get());
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal("You feel like you'd sleep real well"), true);
	}
}
