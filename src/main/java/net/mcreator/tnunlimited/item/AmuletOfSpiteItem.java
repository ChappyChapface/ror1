
package net.mcreator.tnunlimited.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import net.mcreator.tnunlimited.init.TnunlimitedModTabs;

import java.util.List;

public class AmuletOfSpiteItem extends Item {
	public AmuletOfSpiteItem() {
		super(new Item.Properties().tab(TnunlimitedModTabs.TAB_ACCESSORIES_TAB).stacksTo(1).fireResistant().rarity(Rarity.EPIC));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A7aWhen Equipped:"));
		list.add(Component.literal("\u00A77+25% Damage in all categories"));
		list.add(Component.literal("\u00A77+10% Movement Speed"));
		list.add(Component.literal("\u00A77You can only take up to 4 damage at a time"));
		list.add(Component.literal("\u00A7cDebuff: \u00A77This item only works if none of your held or worn items are enchanted"));
	}
}
