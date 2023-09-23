
package net.mcreator.tnunlimited.item;

import net.minecraft.world.entity.ai.attributes.Attributes;
import javax.annotation.Nullable;

public class PepperoniFoodItem extends Item {

	public PepperoniFoodItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(3).saturationMod(0.4f)

				.build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 10;
	}

	@Override
	public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
		return 0F;
	}

}
