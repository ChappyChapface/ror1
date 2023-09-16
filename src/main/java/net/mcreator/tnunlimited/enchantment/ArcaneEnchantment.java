
package net.mcreator.tnunlimited.enchantment;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.tnunlimited.init.TnunlimitedModItems;

import java.util.List;

public class ArcaneEnchantment extends Enchantment {
	public ArcaneEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.RARE, EnchantmentCategory.WEARABLE, slots);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return List.of(Enchantments.VANISHING_CURSE).contains(ench);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		Item item = stack.getItem();
		return List.of(TnunlimitedModItems.SLOTHS_PILLOW.get(), TnunlimitedModItems.CONTRACT.get(), TnunlimitedModItems.MIRACLE_RUNE.get(), TnunlimitedModItems.PET_CACTUS.get(), TnunlimitedModItems.GOLDEN_CACTUS_PET.get(),
				TnunlimitedModItems.ENCHANTED_GOLDEN_CACTUS_PET.get(), TnunlimitedModItems.FLEUR_BAND.get(), TnunlimitedModItems.HONEYBEE_IDOL.get(), TnunlimitedModItems.REPULSIVE_FLOWER_REPLICA.get(), TnunlimitedModItems.HEARTCORE.get(),
				TnunlimitedModItems.CARDIAL_CHARM.get(), TnunlimitedModItems.DECARDIAL_NECKLACE.get(), TnunlimitedModItems.IRON_BAND.get(), TnunlimitedModItems.BAND_OF_BEATDOWN.get(), TnunlimitedModItems.HEMATITE_INFUSED_ANCHOR.get(),
				TnunlimitedModItems.NEEDLE_GAUNTLET.get(), TnunlimitedModItems.CLOUD_BOOTS.get()).contains(item);
	}

	@Override
	public boolean isTreasureOnly() {
		return true;
	}
}
