
package net.mcreator.tnunlimited.enchantment;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.tnunlimited.init.TnunlimitedModItems;
import net.mcreator.tnunlimited.init.TnunlimitedModEnchantments;

import java.util.List;

public class SpanningEnchantment extends Enchantment {
	public SpanningEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.BREAKABLE, slots);
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return List.of(Enchantments.MENDING, Enchantments.UNBREAKING, TnunlimitedModEnchantments.FULL_MAGIC_JACKET.get(), TnunlimitedModEnchantments.TRIGGER_HAPPY.get(), TnunlimitedModEnchantments.KICKBACK.get()).contains(ench);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		Item item = stack.getItem();
		return List.of(TnunlimitedModItems.FLINTLOCK.get(), TnunlimitedModItems.REVOLVER.get(), TnunlimitedModItems.BLUNDERBUSS.get(), TnunlimitedModItems.ANTIMONY_STEN.get(), TnunlimitedModItems.NUBRIUM_PISTOL.get()).contains(item);
	}
}
