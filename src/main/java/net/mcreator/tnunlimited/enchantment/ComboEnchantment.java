
package net.mcreator.tnunlimited.enchantment;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.tnunlimited.init.TnunlimitedModEnchantments;

import java.util.List;

public class ComboEnchantment extends Enchantment {
	public ComboEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return this != ench && !List.of(Enchantments.SHARPNESS, Enchantments.BANE_OF_ARTHROPODS, Enchantments.KNOCKBACK, Enchantments.SMITE, TnunlimitedModEnchantments.CURSE_OF_DULLNESS.get(), TnunlimitedModEnchantments.PUNCTURING.get(),
				TnunlimitedModEnchantments.TRUE_PIERCING.get(), TnunlimitedModEnchantments.IMPULSIVE.get()).contains(ench);
	}
}
