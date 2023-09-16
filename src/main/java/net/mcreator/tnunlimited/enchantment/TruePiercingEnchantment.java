
package net.mcreator.tnunlimited.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.tnunlimited.init.TnunlimitedModItems;

import java.util.List;

public class TruePiercingEnchantment extends Enchantment {
	public TruePiercingEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		Item item = stack.getItem();
		return List.of(TnunlimitedModItems.DIORITE_SPEAR.get(), TnunlimitedModItems.NITRO_SPEAR.get(), TnunlimitedModItems.BITTER_DESIRE.get(), TnunlimitedModItems.GLACIER_GLAIVE.get()).contains(item);
	}
}
