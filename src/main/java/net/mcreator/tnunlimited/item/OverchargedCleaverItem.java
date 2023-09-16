
package net.mcreator.tnunlimited.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.tnunlimited.procedures.OverchargedCleaverDashProcedure;
import net.mcreator.tnunlimited.procedures.OverchargedCleaverChargeControlProcedure;
import net.mcreator.tnunlimited.init.TnunlimitedModItems;

import java.util.List;

public class OverchargedCleaverItem extends SwordItem {
	public OverchargedCleaverItem() {
		super(new Tier() {
			public int getUses() {
				return 524;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 8f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 2;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(TnunlimitedModItems.LEAD_INGOT.get()));
			}
		}, 3, -3.5f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		OverchargedCleaverDashProcedure.execute(world, entity, ar.getObject());
		return ar;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A7aAbility: \u00A77Right click to preform a dash. Sneak during dash to slash and cancel dash"));
		list.add(Component.literal("\u00A7cDebuff: \u00A77Has limited charges, running out causes heavy cooldown"));
		list.add(Component.literal("\u00A79Melee/Slashing"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		OverchargedCleaverChargeControlProcedure.execute(entity);
	}
}
