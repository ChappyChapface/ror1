
package net.mcreator.tnunlimited.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class FeralHuntingKnifeItem extends SwordItem {
	public FeralHuntingKnifeItem() {
		super(new Tier() {
			public int getUses() {
				return 1211;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 5f;
			}

			public int getLevel() {
				return 4;
			}

			public int getEnchantmentValue() {
				return 2;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.NETHERITE_INGOT));
			}
		}, 3, -2f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant());
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A7aAbility: \u00A77Attacks inflict bleeding. Damage increased for each nearby enemy"));
		list.add(Component.literal("\u00A7cDebuff: \u00A77Deals no damage to bleeding targets"));
		list.add(Component.literal("\u00A79Melee/Slashing"));
	}
}
