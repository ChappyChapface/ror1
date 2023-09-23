
package net.mcreator.tnunlimited.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class GluttonysCleaverItem extends SwordItem {
	public GluttonysCleaverItem() {
		super(new Tier() {
			public int getUses() {
				return 666;
			}

			public float getSpeed() {
				return 8f;
			}

			public float getAttackDamageBonus() {
				return 5f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 15;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(TnunlimitedModItems.RITHIUM.get()));
			}
		}, 3, -3.1f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		GluttonysCleaverOpenProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
		return ar;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A7aAbility: \u00A77Killing entities adds ingredients to a list"));
		list.add(Component.literal("\u00A77Right click to view and use the list to generate food"));
		list.add(Component.literal("\u00A79Melee/Slashing"));
	}
}
