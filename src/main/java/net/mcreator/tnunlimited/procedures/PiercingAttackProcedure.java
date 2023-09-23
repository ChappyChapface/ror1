package net.mcreator.tnunlimited.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.CriticalHitEvent;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.tnunlimited.init.TnunlimitedModMobEffects;
import net.mcreator.tnunlimited.init.TnunlimitedModItems;
import net.mcreator.tnunlimited.init.TnunlimitedModEnchantments;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PiercingAttackProcedure {
	@SubscribeEvent
	public static void onPlayerCriticalHit(CriticalHitEvent event) {
		execute(event, event.getTarget(), event.getEntity());
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (TnunlimitedModItems.GLACIER_GLAIVE.get() == (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
			if (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.TRUE_PIERCING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.SHATTERED.get(), 60,
							(int) Math.round((4 + EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.PUNCTURING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)))
									/ (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.TRUE_PIERCING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) + 1))));
			} else {
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.BROKEN.get(), 60,
							Math.round(4 + EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.PUNCTURING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)))));
			}
		}
		if (TnunlimitedModItems.DIORITE_SPEAR.get() == (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
			if (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.TRUE_PIERCING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.SHATTERED.get(), 60,
							(int) Math.round((3 + EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.PUNCTURING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)))
									/ (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.TRUE_PIERCING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) + 1))));
			} else {
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.BROKEN.get(), 60,
							Math.round(3 + EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.PUNCTURING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)))));
			}
		}
		if (TnunlimitedModItems.NITRO_SPEAR.get() == (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
			if (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.TRUE_PIERCING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.SHATTERED.get(), 60,
							(int) Math.round((6 + EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.PUNCTURING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)))
									/ (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.TRUE_PIERCING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) + 1))));
			} else {
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.BROKEN.get(), 60,
							Math.round(6 + EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.PUNCTURING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)))));
			}
		}
		if (TnunlimitedModItems.BITTER_DESIRE.get() == (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
			if (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.TRUE_PIERCING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.SHATTERED.get(), 60,
							(int) Math.round((5 + EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.PUNCTURING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)))
									/ (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.TRUE_PIERCING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) + 1))));
			} else {
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.BROKEN.get(), 60,
							Math.round(5 + EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.PUNCTURING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)))));
			}
		}
		if (TnunlimitedModItems.GALVANIZED_HARPOON.get() == (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
			if (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.TRUE_PIERCING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.SHATTERED.get(), 60,
							(int) Math.round((3 + EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.PUNCTURING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)))
									/ (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.TRUE_PIERCING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) + 1))));
			} else {
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.BROKEN.get(), 60,
							Math.round(3 + EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.PUNCTURING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)))));
			}
		}
	}
}
