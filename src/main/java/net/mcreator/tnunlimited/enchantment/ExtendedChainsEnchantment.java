
package net.mcreator.tnunlimited.enchantment;

public class ExtendedChainsEnchantment extends Enchantment {

	public ExtendedChainsEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.RARE, EnchantmentCategory.BREAKABLE, slots);
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		Item item = stack.getItem();
		return List.of(TnunlimitedModItems.FURY_HOOK.get()).contains(item);
	}

}
