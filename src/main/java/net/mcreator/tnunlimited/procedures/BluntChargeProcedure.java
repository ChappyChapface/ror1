package net.mcreator.tnunlimited.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.tnunlimited.network.TnunlimitedModVariables;
import net.mcreator.tnunlimited.init.TnunlimitedModMobEffects;
import net.mcreator.tnunlimited.init.TnunlimitedModItems;
import net.mcreator.tnunlimited.init.TnunlimitedModEnchantments;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BluntChargeProcedure {
	@SubscribeEvent
	public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (!(((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).PlayerItem)
				.getItem() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem())) {
			entity.getPersistentData().putDouble("bluntCharge", 0);
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(TnunlimitedModMobEffects.CHARGING.get());
		}
		{
			ItemStack _setval = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
			entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PlayerItem = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TnunlimitedModItems.DARK_WARHAMMER.get()
				&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TnunlimitedModMobEffects.CHARGING.get()) ? _livEnt.getEffect(TnunlimitedModMobEffects.CHARGING.get()).getAmplifier() : 0) < 2
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TnunlimitedModItems.GRANITE_CLUB.get()
						&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TnunlimitedModMobEffects.CHARGING.get()) ? _livEnt.getEffect(TnunlimitedModMobEffects.CHARGING.get()).getAmplifier() : 0) < 0
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TnunlimitedModItems.LEAD_CLUB.get()
						&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TnunlimitedModMobEffects.CHARGING.get()) ? _livEnt.getEffect(TnunlimitedModMobEffects.CHARGING.get()).getAmplifier() : 0) < 2
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TnunlimitedModItems.IRON_CLUB.get()
						&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TnunlimitedModMobEffects.CHARGING.get()) ? _livEnt.getEffect(TnunlimitedModMobEffects.CHARGING.get()).getAmplifier() : 0) < 1) {
			entity.getPersistentData().putDouble("bluntCharge", (entity.getPersistentData().getDouble("bluntCharge") + 1));
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TnunlimitedModItems.DIAMOND_CLUB.get()
				&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TnunlimitedModMobEffects.CHARGING.get()) ? _livEnt.getEffect(TnunlimitedModMobEffects.CHARGING.get()).getAmplifier() : 0) < 1
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TnunlimitedModItems.ANTIMONY_CLUB.get()
						&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TnunlimitedModMobEffects.CHARGING.get()) ? _livEnt.getEffect(TnunlimitedModMobEffects.CHARGING.get()).getAmplifier() : 0) < 2
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TnunlimitedModItems.NETHERITE_CLUB.get()
						&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TnunlimitedModMobEffects.CHARGING.get()) ? _livEnt.getEffect(TnunlimitedModMobEffects.CHARGING.get()).getAmplifier() : 0) < 2
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TnunlimitedModItems.BOMEEN_CLUB.get()
						&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TnunlimitedModMobEffects.CHARGING.get()) ? _livEnt.getEffect(TnunlimitedModMobEffects.CHARGING.get()).getAmplifier() : 0) < 1
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TnunlimitedModItems.GALVANIZED_CLUB.get()
						&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TnunlimitedModMobEffects.CHARGING.get()) ? _livEnt.getEffect(TnunlimitedModMobEffects.CHARGING.get()).getAmplifier() : 0) < 2) {
			entity.getPersistentData().putDouble("bluntCharge", (entity.getPersistentData().getDouble("bluntCharge") + 2));
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TnunlimitedModItems.AARDIUM_CLUB.get()
				&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TnunlimitedModMobEffects.CHARGING.get()) ? _livEnt.getEffect(TnunlimitedModMobEffects.CHARGING.get()).getAmplifier() : 0) < 1) {
			entity.getPersistentData().putDouble("bluntCharge", (entity.getPersistentData().getDouble("bluntCharge") + 3));
		}
		if (entity.getPersistentData().getDouble("bluntCharge") >= 25 - EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.IMPULSIVE.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) * 2
				&& EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.IMPULSIVE.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0
				|| entity.getPersistentData().getDouble("bluntCharge") >= 25
						&& !(EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.IMPULSIVE.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0)) {
			if (!(entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(TnunlimitedModMobEffects.CHARGING.get()) : false)) {
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.CHARGING.get(), 240, 0, false, true));
			} else {
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.CHARGING.get(), 240,
							(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TnunlimitedModMobEffects.CHARGING.get()) ? _livEnt.getEffect(TnunlimitedModMobEffects.CHARGING.get()).getAmplifier() : 0) + 1), false, true));
			}
			entity.getPersistentData().putDouble("bluntCharge", 0);
		}
	}
}
