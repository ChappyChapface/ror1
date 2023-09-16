
package net.mcreator.tnunlimited.enchantment;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.tnunlimited.init.TnunlimitedModEnchantments;

import java.util.List;

public class ButcheringEnchantment extends Enchantment {
	public ButcheringEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return this != ench && !List.of(Enchantments.SMITE, Enchantments.BANE_OF_ARTHROPODS, Enchantments.SHARPNESS, TnunlimitedModEnchantments.COMBO.get(), TnunlimitedModEnchantments.CURSE_OF_DULLNESS.get()).contains(ench);
	}
}
