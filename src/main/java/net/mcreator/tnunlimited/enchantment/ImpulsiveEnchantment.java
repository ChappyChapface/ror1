
package net.mcreator.tnunlimited.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.tnunlimited.init.TnunlimitedModItems;

import java.util.List;

public class ImpulsiveEnchantment extends Enchantment {
	public ImpulsiveEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.BREAKABLE, slots);
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		Item item = stack.getItem();
		return List.of(TnunlimitedModItems.GRANITE_CLUB.get(), TnunlimitedModItems.LEAD_CLUB.get(), TnunlimitedModItems.IRON_CLUB.get(), TnunlimitedModItems.AARDIUM_CLUB.get(), TnunlimitedModItems.ANTIMONY_CLUB.get(),
				TnunlimitedModItems.NETHERITE_CLUB.get(), TnunlimitedModItems.GALVANIZED_CLUB.get(), TnunlimitedModItems.BOMEEN_CLUB.get(), TnunlimitedModItems.DIAMOND_CLUB.get(), TnunlimitedModItems.DARK_WARHAMMER.get()).contains(item);
	}
}
