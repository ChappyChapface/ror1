
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tnunlimited.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.tnunlimited.TnunlimitedMod;

public class TnunlimitedModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, TnunlimitedMod.MODID);
	public static final RegistryObject<Potion> REPLENISHMENT_PLUS = REGISTRY.register("replenishment_plus", () -> new Potion(new MobEffectInstance(TnunlimitedModMobEffects.MANA_REGENERATION.get(), 1800, 0, false, true)));
	public static final RegistryObject<Potion> INSTANT_DEPLETION = REGISTRY.register("instant_depletion", () -> new Potion(new MobEffectInstance(TnunlimitedModMobEffects.INSTANT_DEPLETING.get(), 10, 0, false, true)));
	public static final RegistryObject<Potion> REPLENISHMENT = REGISTRY.register("replenishment", () -> new Potion(new MobEffectInstance(TnunlimitedModMobEffects.MANA_REGENERATION.get(), 900, 0, false, true)));
	public static final RegistryObject<Potion> DEPLETING_II = REGISTRY.register("depleting_ii", () -> new Potion(new MobEffectInstance(TnunlimitedModMobEffects.DEPLETING.get(), 440, 1, false, true)));
	public static final RegistryObject<Potion> REPLENISHMENT_II = REGISTRY.register("replenishment_ii", () -> new Potion(new MobEffectInstance(TnunlimitedModMobEffects.MANA_REGENERATION.get(), 440, 1, false, true)));
	public static final RegistryObject<Potion> DEPLETING_POT = REGISTRY.register("depleting_pot", () -> new Potion(new MobEffectInstance(TnunlimitedModMobEffects.DEPLETING.get(), 900, 0, false, true)));
	public static final RegistryObject<Potion> INSTANT_MANA = REGISTRY.register("instant_mana", () -> new Potion(new MobEffectInstance(TnunlimitedModMobEffects.INSTANT_MANA_EFFECT.get(), 10, 0, false, true)));
	public static final RegistryObject<Potion> INSTANT_MANA_II = REGISTRY.register("instant_mana_ii", () -> new Potion(new MobEffectInstance(TnunlimitedModMobEffects.INSTANT_MANA_EFFECT.get(), 10, 1, false, true)));
	public static final RegistryObject<Potion> INSTANT_DEPLETION_II = REGISTRY.register("instant_depletion_ii", () -> new Potion(new MobEffectInstance(TnunlimitedModMobEffects.INSTANT_DEPLETING.get(), 10, 1, false, true)));
	public static final RegistryObject<Potion> DEPLETING_PLUS = REGISTRY.register("depleting_plus", () -> new Potion(new MobEffectInstance(TnunlimitedModMobEffects.DEPLETING.get(), 1800, 0, false, true)));
	public static final RegistryObject<Potion> BLUDGEONING = REGISTRY.register("bludgeoning", () -> new Potion(new MobEffectInstance(TnunlimitedModMobEffects.BLUNT_INCREASE.get(), 9600, 0, false, true)));
	public static final RegistryObject<Potion> BLUDGEONING_PLUS = REGISTRY.register("bludgeoning_plus", () -> new Potion(new MobEffectInstance(TnunlimitedModMobEffects.BLUNT_INCREASE.get(), 3600, 1, false, true)));
	public static final RegistryObject<Potion> BLUDGEONING_II = REGISTRY.register("bludgeoning_ii", () -> new Potion(new MobEffectInstance(TnunlimitedModMobEffects.BLUNT_INCREASE.get(), 3600, 1, false, true)));
	public static final RegistryObject<Potion> FROSTBURN_POTION = REGISTRY.register("frostburn_potion", () -> new Potion(new MobEffectInstance(TnunlimitedModMobEffects.FROSTBURN.get(), 450, 0, false, true)));
	public static final RegistryObject<Potion> FROSTBURN_PLUS = REGISTRY.register("frostburn_plus", () -> new Potion(new MobEffectInstance(TnunlimitedModMobEffects.FROSTBURN.get(), 900, 0, false, true)));
	public static final RegistryObject<Potion> POTION_OF_FLURRY = REGISTRY.register("potion_of_flurry", () -> new Potion(new MobEffectInstance(TnunlimitedModMobEffects.FLURRY.get(), 3600, 0, false, true)));
	public static final RegistryObject<Potion> POTION_OF_FLURRY_II = REGISTRY.register("potion_of_flurry_ii", () -> new Potion(new MobEffectInstance(TnunlimitedModMobEffects.FLURRY.get(), 3600, 1, false, true)));
	public static final RegistryObject<Potion> POTION_OF_FLURRY_PLUS = REGISTRY.register("potion_of_flurry_plus", () -> new Potion(new MobEffectInstance(TnunlimitedModMobEffects.FLURRY.get(), 9600, 0, false, true)));
	public static final RegistryObject<Potion> POTION_OF_STURDY = REGISTRY.register("potion_of_sturdy", () -> new Potion(new MobEffectInstance(TnunlimitedModMobEffects.STURDY.get(), 3600, 0, false, true)));
	public static final RegistryObject<Potion> POTION_OF_STURDY_II = REGISTRY.register("potion_of_sturdy_ii", () -> new Potion(new MobEffectInstance(TnunlimitedModMobEffects.STURDY.get(), 3600, 1, false, true)));
	public static final RegistryObject<Potion> POTION_OF_STURDY_PLUS = REGISTRY.register("potion_of_sturdy_plus", () -> new Potion(new MobEffectInstance(TnunlimitedModMobEffects.STURDY.get(), 3600, 0, false, true)));
}
