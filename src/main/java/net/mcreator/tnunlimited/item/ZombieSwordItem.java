
package net.mcreator.tnunlimited.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class ZombieSwordItem extends SwordItem {
	public ZombieSwordItem() {
		super(new Tier() {
			public int getUses() {
				return 131;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 1f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 5;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.ROTTEN_FLESH));
			}
		}, 3, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ZombieSwordLivingEntityIsHitWithToolProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A7aAbility: Right click to summon a Zombie familiar for 60 seconds"));
		list.add(Component.literal("\u00A7cCooldown: \u00A7715 Seconds"));
		list.add(Component.literal("\u00A79Melee/Slashing"));
		list.add(Component.literal("\u00A79Familiar/Necrotic"));
	}
}
