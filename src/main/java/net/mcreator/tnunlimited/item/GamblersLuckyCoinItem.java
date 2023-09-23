
package net.mcreator.tnunlimited.item;

import net.minecraft.world.entity.ai.attributes.Attributes;
import javax.annotation.Nullable;

public class GamblersLuckyCoinItem extends Item {

	public GamblersLuckyCoinItem() {
		super(new Item.Properties().tab(TnunlimitedModTabs.TAB_ACCESSORIES_TAB).stacksTo(1).rarity(Rarity.UNCOMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A7aWhen Equipped:"));
		list.add(Component.literal("\u00A77There's a chance any damage taken is nullified"));
		list.add(Component.literal("\u00A77This chance is increased as your HP depletes"));
		list.add(Component.literal("\u00A77Affected by Luck"));
	}

}
