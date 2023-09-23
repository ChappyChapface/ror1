
package net.mcreator.tnunlimited.item;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class GalvanizedHarpoonItem extends Item {
	public GalvanizedHarpoonItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).durability(250));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		entity.startUsingItem(hand);
		return new InteractionResultHolder(InteractionResult.SUCCESS, entity.getItemInHand(hand));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A72 +3 Piercing Damage\u00A77When Thrown:"));
		list.add(Component.literal("\u00A72 9 Damage"));
		list.add(Component.literal("\u00A72 0.33 Attack Speed"));
		list.add(Component.literal("\u00A79Ranged/Throwing"));
		list.add(Component.literal("\u00A79Melee/Piercing"));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.SPEAR;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 72000;
	}

	@Override
	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
		if (slot == EquipmentSlot.MAINHAND) {
			ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
			builder.putAll(super.getDefaultAttributeModifiers(slot));
			builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Ranged item modifier", (double) 3, AttributeModifier.Operation.ADDITION));
			builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Ranged item modifier", -2.4, AttributeModifier.Operation.ADDITION));
			return builder.build();
		}
		return super.getDefaultAttributeModifiers(slot);
	}

	@Override
	public void releaseUsing(ItemStack itemstack, Level world, LivingEntity entityLiving, int timeLeft) {
		if (!world.isClientSide() && entityLiving instanceof ServerPlayer entity) {
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			if (true) {
				GalvanizedHarpoonEntity entityarrow = GalvanizedHarpoonEntity.shoot(world, entity, world.getRandom(), 1f, 4, 0);
				itemstack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(entity.getUsedItemHand()));
				entityarrow.pickup = AbstractArrow.Pickup.DISALLOWED;
				GalvanizedHarpoonCooldownProcedure.execute(entity, itemstack);
			}
		}
	}
}
