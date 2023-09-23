
package net.mcreator.tnunlimited.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class NubriumClaymoreItem extends SwordItem {
	public NubriumClaymoreItem() {
		super(new Tier() {
			public int getUses() {
				return 2531;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 20f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 2;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(TnunlimitedModItems.NUBRIUM.get()));
			}
		}, 3, -3.2f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		NubriumSwordLivingEntityIsHitWithToolProcedure.execute(entity);
		return retval;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A7aAbility: \u00A77Attacks inflict Slowness"));
		list.add(Component.literal("\u00A79Melee/Slashing"));
	}
}
