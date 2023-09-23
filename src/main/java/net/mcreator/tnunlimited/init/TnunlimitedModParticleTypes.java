
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tnunlimited.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.tnunlimited.TnunlimitedMod;

public class TnunlimitedModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, TnunlimitedMod.MODID);
	public static final RegistryObject<SimpleParticleType> BULLET_SHELL = REGISTRY.register("bullet_shell", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> AMETHYST_FIRE = REGISTRY.register("amethyst_fire", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> ROSE_GOLD_DISC_BREAK = REGISTRY.register("rose_gold_disc_break", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> ENERGYREVERSE = REGISTRY.register("energyreverse", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> ENERGY = REGISTRY.register("energy", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> BLOODSPLASH = REGISTRY.register("bloodsplash", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> SHOCKWAVE = REGISTRY.register("shockwave", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> BLOOD_DRIP = REGISTRY.register("blood_drip", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> IRON_MAGIC_CIRCLE = REGISTRY.register("iron_magic_circle", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> ANTIMONY_MAGIC_CIRCLE = REGISTRY.register("antimony_magic_circle", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> AARDIUM_MAGIC_CIRCLE = REGISTRY.register("aardium_magic_circle", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> GOLD_MAGIC_CIRCLE = REGISTRY.register("gold_magic_circle", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> NETHERITE_WAND_PROJECTILE = REGISTRY.register("netherite_wand_projectile", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> LEAD_MAGIC_CIRCLE = REGISTRY.register("lead_magic_circle", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> DIAMOND_MAGIC_CIRCLE = REGISTRY.register("diamond_magic_circle", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> NUBRIUM_MAGIC_CIRCLE = REGISTRY.register("nubrium_magic_circle", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> ROCK_PARTICLE = REGISTRY.register("rock_particle", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> PURPLE_SHROOM_PARTICLE = REGISTRY.register("purple_shroom_particle", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> CORONER_FIRE = REGISTRY.register("coroner_fire", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> ICE_SHARDS = REGISTRY.register("ice_shards", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> SLASH = REGISTRY.register("slash", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> PARRY = REGISTRY.register("parry", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> DAYWALKER_SPARKLEZ = REGISTRY.register("daywalker_sparklez", () -> new SimpleParticleType(true));
}
