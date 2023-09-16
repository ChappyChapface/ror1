
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tnunlimited.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

import net.mcreator.tnunlimited.enchantment.WindowPainEnchantment;
import net.mcreator.tnunlimited.enchantment.TruePiercingEnchantment;
import net.mcreator.tnunlimited.enchantment.TriggerHappyEnchantment;
import net.mcreator.tnunlimited.enchantment.SpanningEnchantment;
import net.mcreator.tnunlimited.enchantment.SharpShooterEnchantment;
import net.mcreator.tnunlimited.enchantment.ResistingEnchantment;
import net.mcreator.tnunlimited.enchantment.RecoilEnchantment;
import net.mcreator.tnunlimited.enchantment.PuncturingEnchantment;
import net.mcreator.tnunlimited.enchantment.LungingEnchantment;
import net.mcreator.tnunlimited.enchantment.LeechingEnchantment;
import net.mcreator.tnunlimited.enchantment.KickbackEnchantment;
import net.mcreator.tnunlimited.enchantment.ImpulsiveEnchantment;
import net.mcreator.tnunlimited.enchantment.HarvestingEnchantment;
import net.mcreator.tnunlimited.enchantment.FullMagicJacketEnchantment;
import net.mcreator.tnunlimited.enchantment.FloatingEnchantment;
import net.mcreator.tnunlimited.enchantment.DashingEnchantment;
import net.mcreator.tnunlimited.enchantment.CurseOfHesitationEnchantment;
import net.mcreator.tnunlimited.enchantment.CurseOfDullnessEnchantment;
import net.mcreator.tnunlimited.enchantment.ComboEnchantment;
import net.mcreator.tnunlimited.enchantment.CaliberEnchantment;
import net.mcreator.tnunlimited.enchantment.ButcheringEnchantment;
import net.mcreator.tnunlimited.enchantment.BuffingEnchantment;
import net.mcreator.tnunlimited.enchantment.BeatdownEnchantment;
import net.mcreator.tnunlimited.enchantment.ArcaneEnchantment;
import net.mcreator.tnunlimited.enchantment.AerialMovementEnchantment;
import net.mcreator.tnunlimited.TnunlimitedMod;

public class TnunlimitedModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, TnunlimitedMod.MODID);
	public static final RegistryObject<Enchantment> HARVESTING = REGISTRY.register("harvesting", () -> new HarvestingEnchantment());
	public static final RegistryObject<Enchantment> AERIAL_MOVEMENT = REGISTRY.register("aerial_movement", () -> new AerialMovementEnchantment());
	public static final RegistryObject<Enchantment> LUNGING = REGISTRY.register("lunging", () -> new LungingEnchantment());
	public static final RegistryObject<Enchantment> FULL_MAGIC_JACKET = REGISTRY.register("full_magic_jacket", () -> new FullMagicJacketEnchantment());
	public static final RegistryObject<Enchantment> TRIGGER_HAPPY = REGISTRY.register("trigger_happy", () -> new TriggerHappyEnchantment());
	public static final RegistryObject<Enchantment> SHARP_SHOOTER = REGISTRY.register("sharp_shooter", () -> new SharpShooterEnchantment());
	public static final RegistryObject<Enchantment> CALIBER = REGISTRY.register("caliber", () -> new CaliberEnchantment());
	public static final RegistryObject<Enchantment> KICKBACK = REGISTRY.register("kickback", () -> new KickbackEnchantment());
	public static final RegistryObject<Enchantment> LEECHING = REGISTRY.register("leeching", () -> new LeechingEnchantment());
	public static final RegistryObject<Enchantment> BUFFING = REGISTRY.register("buffing", () -> new BuffingEnchantment());
	public static final RegistryObject<Enchantment> RESISTING = REGISTRY.register("resisting", () -> new ResistingEnchantment());
	public static final RegistryObject<Enchantment> DASHING = REGISTRY.register("dashing", () -> new DashingEnchantment());
	public static final RegistryObject<Enchantment> FLOATING = REGISTRY.register("floating", () -> new FloatingEnchantment());
	public static final RegistryObject<Enchantment> ARCANE = REGISTRY.register("arcane", () -> new ArcaneEnchantment());
	public static final RegistryObject<Enchantment> SPANNING = REGISTRY.register("spanning", () -> new SpanningEnchantment());
	public static final RegistryObject<Enchantment> BUTCHERING = REGISTRY.register("butchering", () -> new ButcheringEnchantment());
	public static final RegistryObject<Enchantment> WINDOW_PAIN = REGISTRY.register("window_pain", () -> new WindowPainEnchantment());
	public static final RegistryObject<Enchantment> RECOIL = REGISTRY.register("recoil", () -> new RecoilEnchantment());
	public static final RegistryObject<Enchantment> IMPULSIVE = REGISTRY.register("impulsive", () -> new ImpulsiveEnchantment());
	public static final RegistryObject<Enchantment> CURSE_OF_HESITATION = REGISTRY.register("curse_of_hesitation", () -> new CurseOfHesitationEnchantment());
	public static final RegistryObject<Enchantment> CURSE_OF_DULLNESS = REGISTRY.register("curse_of_dullness", () -> new CurseOfDullnessEnchantment());
	public static final RegistryObject<Enchantment> COMBO = REGISTRY.register("combo", () -> new ComboEnchantment());
	public static final RegistryObject<Enchantment> PUNCTURING = REGISTRY.register("puncturing", () -> new PuncturingEnchantment());
	public static final RegistryObject<Enchantment> TRUE_PIERCING = REGISTRY.register("true_piercing", () -> new TruePiercingEnchantment());
	public static final RegistryObject<Enchantment> BEATDOWN = REGISTRY.register("beatdown", () -> new BeatdownEnchantment());
}
