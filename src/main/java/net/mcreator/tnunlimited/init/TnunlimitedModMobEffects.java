
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tnunlimited.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.tnunlimited.potion.SturdyMobEffect;
import net.mcreator.tnunlimited.potion.ShatteredPrideMobEffect;
import net.mcreator.tnunlimited.potion.PrideCrownEffectMobEffect;
import net.mcreator.tnunlimited.potion.ParasiteMobEffect;
import net.mcreator.tnunlimited.potion.ParanoiaMobEffect;
import net.mcreator.tnunlimited.potion.OverchargedCleaverDashEffectMobEffect;
import net.mcreator.tnunlimited.potion.NoMilkMobEffect;
import net.mcreator.tnunlimited.potion.ManaRegenerationMobEffect;
import net.mcreator.tnunlimited.potion.InstantManaEffectMobEffect;
import net.mcreator.tnunlimited.potion.InstantDepletingMobEffect;
import net.mcreator.tnunlimited.potion.InfernoMobEffect;
import net.mcreator.tnunlimited.potion.HotPotatoEffectMobEffect;
import net.mcreator.tnunlimited.potion.HelmetLayer2MobEffect;
import net.mcreator.tnunlimited.potion.HelmetLayer1MobEffect;
import net.mcreator.tnunlimited.potion.GildedBugBuffMobEffect;
import net.mcreator.tnunlimited.potion.FrostburnMobEffect;
import net.mcreator.tnunlimited.potion.FlurryMobEffect;
import net.mcreator.tnunlimited.potion.DryoutMobEffect;
import net.mcreator.tnunlimited.potion.DrowsyMobEffect;
import net.mcreator.tnunlimited.potion.DepletingMobEffect;
import net.mcreator.tnunlimited.potion.DecardialMobEffect;
import net.mcreator.tnunlimited.potion.ChargingMobEffect;
import net.mcreator.tnunlimited.potion.BluntIncreaseMobEffect;
import net.mcreator.tnunlimited.potion.BleedingMobEffect;
import net.mcreator.tnunlimited.potion.BedtimeElixerMobEffect;
import net.mcreator.tnunlimited.TnunlimitedMod;

public class TnunlimitedModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, TnunlimitedMod.MODID);
	public static final RegistryObject<MobEffect> BLEEDING = REGISTRY.register("bleeding", () -> new BleedingMobEffect());
	public static final RegistryObject<MobEffect> DROWSY = REGISTRY.register("drowsy", () -> new DrowsyMobEffect());
	public static final RegistryObject<MobEffect> GILDED_BUG_BUFF = REGISTRY.register("gilded_bug_buff", () -> new GildedBugBuffMobEffect());
	public static final RegistryObject<MobEffect> DECARDIAL = REGISTRY.register("decardial", () -> new DecardialMobEffect());
	public static final RegistryObject<MobEffect> INSTANT_MANA_EFFECT = REGISTRY.register("instant_mana_effect", () -> new InstantManaEffectMobEffect());
	public static final RegistryObject<MobEffect> DEPLETING = REGISTRY.register("depleting", () -> new DepletingMobEffect());
	public static final RegistryObject<MobEffect> MANA_REGENERATION = REGISTRY.register("mana_regeneration", () -> new ManaRegenerationMobEffect());
	public static final RegistryObject<MobEffect> INSTANT_DEPLETING = REGISTRY.register("instant_depleting", () -> new InstantDepletingMobEffect());
	public static final RegistryObject<MobEffect> BLUNT_INCREASE = REGISTRY.register("blunt_increase", () -> new BluntIncreaseMobEffect());
	public static final RegistryObject<MobEffect> FROSTBURN = REGISTRY.register("frostburn", () -> new FrostburnMobEffect());
	public static final RegistryObject<MobEffect> NO_MILK = REGISTRY.register("no_milk", () -> new NoMilkMobEffect());
	public static final RegistryObject<MobEffect> HELMET_LAYER_1 = REGISTRY.register("helmet_layer_1", () -> new HelmetLayer1MobEffect());
	public static final RegistryObject<MobEffect> FLURRY = REGISTRY.register("flurry", () -> new FlurryMobEffect());
	public static final RegistryObject<MobEffect> HELMET_LAYER_2 = REGISTRY.register("helmet_layer_2", () -> new HelmetLayer2MobEffect());
	public static final RegistryObject<MobEffect> PARASITE = REGISTRY.register("parasite", () -> new ParasiteMobEffect());
	public static final RegistryObject<MobEffect> PARANOIA = REGISTRY.register("paranoia", () -> new ParanoiaMobEffect());
	public static final RegistryObject<MobEffect> HOT_POTATO_EFFECT = REGISTRY.register("hot_potato_effect", () -> new HotPotatoEffectMobEffect());
	public static final RegistryObject<MobEffect> STURDY = REGISTRY.register("sturdy", () -> new SturdyMobEffect());
	public static final RegistryObject<MobEffect> PRIDE_CROWN_EFFECT = REGISTRY.register("pride_crown_effect", () -> new PrideCrownEffectMobEffect());
	public static final RegistryObject<MobEffect> SHATTERED_PRIDE = REGISTRY.register("shattered_pride", () -> new ShatteredPrideMobEffect());
	public static final RegistryObject<MobEffect> BEDTIME_ELIXIR = REGISTRY.register("bedtime_elixir", () -> new BedtimeElixerMobEffect());
	public static final RegistryObject<MobEffect> CHARGING = REGISTRY.register("charging", () -> new ChargingMobEffect());
	public static final RegistryObject<MobEffect> DRYOUT = REGISTRY.register("dryout", () -> new DryoutMobEffect());
	public static final RegistryObject<MobEffect> OVERCHARGED_CLEAVER_DASH_EFFECT = REGISTRY.register("overcharged_cleaver_dash_effect", () -> new OverchargedCleaverDashEffectMobEffect());
	public static final RegistryObject<MobEffect> INFERNO = REGISTRY.register("inferno", () -> new InfernoMobEffect());
}
