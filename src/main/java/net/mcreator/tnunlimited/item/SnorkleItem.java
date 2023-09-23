
package net.mcreator.tnunlimited.item;

import net.minecraft.world.entity.ai.attributes.Attributes;
import javax.annotation.Nullable;

public class SnorkleItem extends Item {

	public SnorkleItem() {
		super(new Item.Properties().tab(TnunlimitedModTabs.TAB_ACCESSORIES_TAB).stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A7aWhen Equipped:"));
		list.add(Component.literal("\u00A77+5 seconds of underwater air time"));
		list.add(Component.literal("\u00A77+20% underwater air time from other sources"));
	}

}
