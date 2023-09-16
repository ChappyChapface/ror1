package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.tnunlimited.network.TnunlimitedModVariables;
import net.mcreator.tnunlimited.init.TnunlimitedModItems;
import net.mcreator.tnunlimited.init.TnunlimitedModEnchantments;

public class ReturnChargeProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("forge:blunt_weapon")))) {
			if (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.IMPULSIVE.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
				return "Charge Time: " + entity.getPersistentData().getDouble("bluntCharge") + "/"
						+ (25 - 2 * EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.IMPULSIVE.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)));
			} else {
				return "Charge Time: " + entity.getPersistentData().getDouble("bluntCharge") + "/25";
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TnunlimitedModItems.NITROKNIFE.get()) {
			return "Energy: " + (entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).nitroknifecharge + "/30";
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TnunlimitedModItems.NITROBLADE.get()) {
			return "Energy: " + TnunlimitedModVariables.MapVariables.get(world).energybladecharge + "/50";
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TnunlimitedModItems.NITROCLAYMORE.get()) {
			return "Energy: " + (entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).nitroclaymorecharge + "/80";
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TnunlimitedModItems.OVERCHARGED_CLEAVER.get()) {
			return "Charges: " + entity.getPersistentData().getDouble("charges") + "/5";
		}
		return "This shouldn't be showing";
	}
}
