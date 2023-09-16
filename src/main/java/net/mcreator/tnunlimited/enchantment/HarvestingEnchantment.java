
package net.mcreator.tnunlimited.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.tnunlimited.init.TnunlimitedModItems;

import java.util.List;

public class HarvestingEnchantment extends Enchantment {
	public HarvestingEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.BREAKABLE, slots);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		Item item = stack.getItem();
		return List
				.of(TnunlimitedModItems.WOODEN_SICKLE.get(), TnunlimitedModItems.STONE_SICKLE.get(), TnunlimitedModItems.GOLD_SICKLE.get(), TnunlimitedModItems.IRON_SICKLE.get(), TnunlimitedModItems.DIAMOND_SICKLE.get(),
						TnunlimitedModItems.NETHERITE_SICKLE.get(), TnunlimitedModItems.GALVANIZED_SICKLE.get(), TnunlimitedModItems.AARDIUM_SICKLE.get(), TnunlimitedModItems.LEAD_SICKLE.get(), TnunlimitedModItems.BOMAIND_SICKLE.get())
				.contains(item);
	}
}
