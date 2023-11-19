package net.mcreator.tnunlimited.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import net.mcreator.tnunlimited.network.TnunlimitedModVariables;
import net.mcreator.tnunlimited.init.TnunlimitedModItems;
import net.mcreator.tnunlimited.init.TnunlimitedModEnchantments;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class MaxManaChangeProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		double numb = 0;
		numb = 10;
		if (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.ARCANE.get(), ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).Acc01)) != 0) {
			numb = numb
					+ EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.ARCANE.get(), ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).Acc01));
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.ARCANE.get(), ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).Acc02)) != 0) {
			numb = numb
					+ EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.ARCANE.get(), ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).Acc02));
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.ARCANE.get(), ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).Acc00)) != 0) {
			numb = numb
					+ EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.ARCANE.get(), ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).Acc00));
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TnunlimitedModItems.WITCH_HELMET.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TnunlimitedModItems.WITCH_CHESTPLATE.get()
				&& ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TnunlimitedModItems.WITCH_LEGGINGS.get()
						|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TnunlimitedModItems.FANCY_PANTS_LEGGINGS.get())
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TnunlimitedModItems.WITCH_BOOTS.get()) {
			numb = numb + 5;
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TnunlimitedModItems.WARCASTER_HELMET.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TnunlimitedModItems.WARCASTER_CHESTPLATE.get()
				&& ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TnunlimitedModItems.WARCASTER_LEGGINGS.get()
						|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TnunlimitedModItems.FANCY_PANTS_LEGGINGS.get())
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TnunlimitedModItems.WARCASTER_BOOTS.get()) {
			numb = numb + 5;
		}
		{
			double _setval = numb;
			entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.maxMana = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
