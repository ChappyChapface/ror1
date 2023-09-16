
package net.mcreator.tnunlimited.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.tnunlimited.init.TnunlimitedModItems;
import net.mcreator.tnunlimited.init.TnunlimitedModEnchantments;

import java.util.List;

public class BeatdownEnchantment extends Enchantment {
	public BeatdownEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return this != ench && !List.of(TnunlimitedModEnchantments.IMPULSIVE.get(), TnunlimitedModEnchantments.COMBO.get()).contains(ench);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		Item item = stack.getItem();
		return List.of(TnunlimitedModItems.GRANITE_CLUB.get(), TnunlimitedModItems.LEAD_CLUB.get(), TnunlimitedModItems.IRON_CLUB.get(), TnunlimitedModItems.AARDIUM_CLUB.get(), TnunlimitedModItems.ANTIMONY_CLUB.get(),
				TnunlimitedModItems.NETHERITE_CLUB.get(), TnunlimitedModItems.GALVANIZED_CLUB.get(), TnunlimitedModItems.BOMEEN_CLUB.get(), TnunlimitedModItems.DIAMOND_CLUB.get(), TnunlimitedModItems.DARK_WARHAMMER.get()).contains(item);
	}
}
