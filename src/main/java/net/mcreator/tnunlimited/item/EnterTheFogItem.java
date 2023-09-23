
package net.mcreator.tnunlimited.item;

import net.minecraft.network.chat.Component;

public class EnterTheFogItem extends RecordItem {

	public EnterTheFogItem() {
		super(0, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tnunlimited:enter_the_fog")), new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(1).rarity(Rarity.RARE), 100);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}

}
