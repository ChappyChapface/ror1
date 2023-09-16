
package net.mcreator.tnunlimited.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.tnunlimited.init.TnunlimitedModItems;

import java.util.List;

public class KickbackEnchantment extends Enchantment {
	public KickbackEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.BREAKABLE, slots);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		Item item = stack.getItem();
		return List.of(TnunlimitedModItems.REVOLVER.get(), TnunlimitedModItems.BLUNDERBUSS.get(), TnunlimitedModItems.FLINTLOCK.get(), TnunlimitedModItems.ANTIMONY_STEN.get(), TnunlimitedModItems.NUBRIUM_PISTOL.get()).contains(item);
	}
}
