
package net.mcreator.tnunlimited.item;

import net.minecraft.world.entity.ai.attributes.Attributes;
import javax.annotation.Nullable;

public class CoffeeBeansItem extends Item {

	public CoffeeBeansItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_BREWING).stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

}
