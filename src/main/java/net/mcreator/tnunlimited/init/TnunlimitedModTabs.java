
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tnunlimited.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class TnunlimitedModTabs {
	public static CreativeModeTab TAB_ACCESSORIES_TAB;
	public static CreativeModeTab TAB_VANITY;

	public static void load() {
		TAB_ACCESSORIES_TAB = new CreativeModeTab("tabaccessories_tab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(TnunlimitedModItems.PET_CACTUS.get());
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_VANITY = new CreativeModeTab("tabvanity") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(TnunlimitedModItems.FANCY_PANTS_LEGGINGS.get());
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
