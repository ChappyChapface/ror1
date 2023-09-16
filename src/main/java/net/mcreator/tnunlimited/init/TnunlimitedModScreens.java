
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tnunlimited.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.tnunlimited.client.gui.StatSheetScreen;
import net.mcreator.tnunlimited.client.gui.StarterClassScreen;
import net.mcreator.tnunlimited.client.gui.SpawningEyeGUIScreen;
import net.mcreator.tnunlimited.client.gui.OverdriveTableUIScreen;
import net.mcreator.tnunlimited.client.gui.GluttonyCraftScreen;
import net.mcreator.tnunlimited.client.gui.BlenderGUIScreen;
import net.mcreator.tnunlimited.client.gui.AccessoriesScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TnunlimitedModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(TnunlimitedModMenus.STAT_SHEET.get(), StatSheetScreen::new);
			MenuScreens.register(TnunlimitedModMenus.ACCESSORIES.get(), AccessoriesScreen::new);
			MenuScreens.register(TnunlimitedModMenus.OVERDRIVE_TABLE_UI.get(), OverdriveTableUIScreen::new);
			MenuScreens.register(TnunlimitedModMenus.SPAWNING_EYE_GUI.get(), SpawningEyeGUIScreen::new);
			MenuScreens.register(TnunlimitedModMenus.GLUTTONY_CRAFT.get(), GluttonyCraftScreen::new);
			MenuScreens.register(TnunlimitedModMenus.STARTER_CLASS.get(), StarterClassScreen::new);
			MenuScreens.register(TnunlimitedModMenus.BLENDER_GUI.get(), BlenderGUIScreen::new);
		});
	}
}
