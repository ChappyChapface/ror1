
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tnunlimited.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.entity.decoration.PaintingVariant;

import net.mcreator.tnunlimited.TnunlimitedMod;

public class TnunlimitedModPaintings {
	public static final DeferredRegister<PaintingVariant> REGISTRY = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, TnunlimitedMod.MODID);
	public static final RegistryObject<PaintingVariant> WA_RP_2 = REGISTRY.register("wa_rp_2", () -> new PaintingVariant(32, 32));
	public static final RegistryObject<PaintingVariant> WITHER_AND_ROT_PAINTING = REGISTRY.register("wither_and_rot_painting", () -> new PaintingVariant(128, 128));
	public static final RegistryObject<PaintingVariant> DRAGONDEEZNUTS = REGISTRY.register("dragondeeznuts", () -> new PaintingVariant(128, 128));
	public static final RegistryObject<PaintingVariant> TREADLINGS = REGISTRY.register("treadlings", () -> new PaintingVariant(32, 16));
	public static final RegistryObject<PaintingVariant> PAINTING_AM_ANDY = REGISTRY.register("painting_am_andy", () -> new PaintingVariant(16, 32));
	public static final RegistryObject<PaintingVariant> PAINTING_FROSTBURNT_HUNT = REGISTRY.register("painting_frostburnt_hunt", () -> new PaintingVariant(64, 48));
	public static final RegistryObject<PaintingVariant> PAINTING_FORTRESS_BRAWL = REGISTRY.register("painting_fortress_brawl", () -> new PaintingVariant(64, 48));
}
