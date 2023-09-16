package net.mcreator.tnunlimited.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.CriticalHitEvent;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.tnunlimited.network.TnunlimitedModVariables;
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
				entity.hurt(DamageSource.OUT_OF_WORLD,
						(float) (((4 + EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.PUNCTURING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) / 2)
								/ (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.TRUE_PIERCING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) + 1))
								* ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).piercingSTR + 5) * 1.5));
			} else {
				entity.hurt(DamageSource.GENERIC, (float) ((4 + EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.PUNCTURING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) / 2)
						* ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).piercingSTR + 5) * 1.5));
			}
		}
		if (TnunlimitedModItems.DIORITE_SPEAR.get() == (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
			if (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.TRUE_PIERCING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
				entity.hurt(DamageSource.OUT_OF_WORLD,
						(float) (((3 + EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.PUNCTURING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) / 2)
								/ (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.TRUE_PIERCING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) + 1))
								* ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).piercingSTR + 5) * 1.5));
			} else {
				entity.hurt(DamageSource.GENERIC, (float) ((3 + EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.PUNCTURING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) / 2)
						* ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).piercingSTR + 5) * 1.5));
			}
		}
		if (TnunlimitedModItems.NITRO_SPEAR.get() == (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
			if (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.TRUE_PIERCING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
				entity.hurt(DamageSource.OUT_OF_WORLD,
						(float) (((6 + EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.PUNCTURING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) / 2)
								/ (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.TRUE_PIERCING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) + 1))
								* ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).piercingSTR + 5) * 1.5));
			} else {
				entity.hurt(DamageSource.GENERIC, (float) ((6 + EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.PUNCTURING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) / 2)
						* ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).piercingSTR + 5) * 1.5));
			}
		}
		if (TnunlimitedModItems.BITTER_DESIRE.get() == (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
			if (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.TRUE_PIERCING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
				entity.hurt(DamageSource.OUT_OF_WORLD,
						(float) (((5 + EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.PUNCTURING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) / 2)
								/ (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.TRUE_PIERCING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) + 1))
								* ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).piercingSTR + 5) * 1.5));
			} else {
				entity.hurt(DamageSource.GENERIC, (float) ((5 + EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.PUNCTURING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) / 2)
						* ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).piercingSTR + 5) * 1.5));
			}
		}
		if (TnunlimitedModItems.GALVANIZED_HARPOON.get() == (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
			if (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.TRUE_PIERCING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
				entity.hurt(DamageSource.OUT_OF_WORLD,
						(float) (((3 + EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.PUNCTURING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) / 2)
								/ (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.TRUE_PIERCING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) + 1))
								* ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).piercingSTR + 5) * 1.5));
			} else {
				entity.hurt(DamageSource.GENERIC, (float) ((3 + EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.PUNCTURING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) / 2)
						* ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).piercingSTR + 5) * 1.5));
			}
		}
	}
}
