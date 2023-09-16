
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tnunlimited.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.tnunlimited.world.inventory.StatSheetMenu;
import net.mcreator.tnunlimited.world.inventory.StarterClassMenu;
import net.mcreator.tnunlimited.world.inventory.SpawningEyeGUIMenu;
import net.mcreator.tnunlimited.world.inventory.OverdriveTableUIMenu;
import net.mcreator.tnunlimited.world.inventory.GluttonyCraftMenu;
import net.mcreator.tnunlimited.world.inventory.BlenderGUIMenu;
import net.mcreator.tnunlimited.world.inventory.AccessoriesMenu;
import net.mcreator.tnunlimited.TnunlimitedMod;

public class TnunlimitedModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, TnunlimitedMod.MODID);
	public static final RegistryObject<MenuType<StatSheetMenu>> STAT_SHEET = REGISTRY.register("stat_sheet", () -> IForgeMenuType.create(StatSheetMenu::new));
	public static final RegistryObject<MenuType<AccessoriesMenu>> ACCESSORIES = REGISTRY.register("accessories", () -> IForgeMenuType.create(AccessoriesMenu::new));
	public static final RegistryObject<MenuType<OverdriveTableUIMenu>> OVERDRIVE_TABLE_UI = REGISTRY.register("overdrive_table_ui", () -> IForgeMenuType.create(OverdriveTableUIMenu::new));
	public static final RegistryObject<MenuType<SpawningEyeGUIMenu>> SPAWNING_EYE_GUI = REGISTRY.register("spawning_eye_gui", () -> IForgeMenuType.create(SpawningEyeGUIMenu::new));
	public static final RegistryObject<MenuType<GluttonyCraftMenu>> GLUTTONY_CRAFT = REGISTRY.register("gluttony_craft", () -> IForgeMenuType.create(GluttonyCraftMenu::new));
	public static final RegistryObject<MenuType<StarterClassMenu>> STARTER_CLASS = REGISTRY.register("starter_class", () -> IForgeMenuType.create(StarterClassMenu::new));
	public static final RegistryObject<MenuType<BlenderGUIMenu>> BLENDER_GUI = REGISTRY.register("blender_gui", () -> IForgeMenuType.create(BlenderGUIMenu::new));
}
