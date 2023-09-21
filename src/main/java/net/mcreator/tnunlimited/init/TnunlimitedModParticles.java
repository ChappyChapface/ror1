
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tnunlimited.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.tnunlimited.client.particle.SlashParticle;
import net.mcreator.tnunlimited.client.particle.ShockwaveParticle;
import net.mcreator.tnunlimited.client.particle.RoseGoldDiscBreakParticle;
import net.mcreator.tnunlimited.client.particle.RockParticleParticle;
import net.mcreator.tnunlimited.client.particle.PurpleShroomParticleParticle;
import net.mcreator.tnunlimited.client.particle.ParryParticle;
import net.mcreator.tnunlimited.client.particle.NubriumMagicCircleParticle;
import net.mcreator.tnunlimited.client.particle.NetheriteWandProjectileParticle;
import net.mcreator.tnunlimited.client.particle.LeadMagicCircleParticle;
import net.mcreator.tnunlimited.client.particle.IronMagicCircleParticle;
import net.mcreator.tnunlimited.client.particle.IceShardsParticle;
import net.mcreator.tnunlimited.client.particle.GoldMagicCircleParticle;
import net.mcreator.tnunlimited.client.particle.EnergyreverseParticle;
import net.mcreator.tnunlimited.client.particle.EnergyParticle;
import net.mcreator.tnunlimited.client.particle.DiamondMagicCircleParticle;
import net.mcreator.tnunlimited.client.particle.DaywalkerSparklezParticle;
import net.mcreator.tnunlimited.client.particle.CoronerFireParticle;
import net.mcreator.tnunlimited.client.particle.BulletShellParticle;
import net.mcreator.tnunlimited.client.particle.BloodsplashParticle;
import net.mcreator.tnunlimited.client.particle.BloodDripParticle;
import net.mcreator.tnunlimited.client.particle.AntimonyMagicCircleParticle;
import net.mcreator.tnunlimited.client.particle.AmethystFireParticle;
import net.mcreator.tnunlimited.client.particle.AardiumMagicCircleParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TnunlimitedModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.register(TnunlimitedModParticleTypes.BULLET_SHELL.get(), BulletShellParticle::provider);
		event.register(TnunlimitedModParticleTypes.AMETHYST_FIRE.get(), AmethystFireParticle::provider);
		event.register(TnunlimitedModParticleTypes.ROSE_GOLD_DISC_BREAK.get(), RoseGoldDiscBreakParticle::provider);
		event.register(TnunlimitedModParticleTypes.ENERGYREVERSE.get(), EnergyreverseParticle::provider);
		event.register(TnunlimitedModParticleTypes.ENERGY.get(), EnergyParticle::provider);
		event.register(TnunlimitedModParticleTypes.BLOODSPLASH.get(), BloodsplashParticle::provider);
		event.register(TnunlimitedModParticleTypes.SHOCKWAVE.get(), ShockwaveParticle::provider);
		event.register(TnunlimitedModParticleTypes.BLOOD_DRIP.get(), BloodDripParticle::provider);
		event.register(TnunlimitedModParticleTypes.IRON_MAGIC_CIRCLE.get(), IronMagicCircleParticle::provider);
		event.register(TnunlimitedModParticleTypes.ANTIMONY_MAGIC_CIRCLE.get(), AntimonyMagicCircleParticle::provider);
		event.register(TnunlimitedModParticleTypes.AARDIUM_MAGIC_CIRCLE.get(), AardiumMagicCircleParticle::provider);
		event.register(TnunlimitedModParticleTypes.GOLD_MAGIC_CIRCLE.get(), GoldMagicCircleParticle::provider);
		event.register(TnunlimitedModParticleTypes.NETHERITE_WAND_PROJECTILE.get(), NetheriteWandProjectileParticle::provider);
		event.register(TnunlimitedModParticleTypes.LEAD_MAGIC_CIRCLE.get(), LeadMagicCircleParticle::provider);
		event.register(TnunlimitedModParticleTypes.DIAMOND_MAGIC_CIRCLE.get(), DiamondMagicCircleParticle::provider);
		event.register(TnunlimitedModParticleTypes.NUBRIUM_MAGIC_CIRCLE.get(), NubriumMagicCircleParticle::provider);
		event.register(TnunlimitedModParticleTypes.ROCK_PARTICLE.get(), RockParticleParticle::provider);
		event.register(TnunlimitedModParticleTypes.PURPLE_SHROOM_PARTICLE.get(), PurpleShroomParticleParticle::provider);
		event.register(TnunlimitedModParticleTypes.CORONER_FIRE.get(), CoronerFireParticle::provider);
		event.register(TnunlimitedModParticleTypes.ICE_SHARDS.get(), IceShardsParticle::provider);
		event.register(TnunlimitedModParticleTypes.SLASH.get(), SlashParticle::provider);
		event.register(TnunlimitedModParticleTypes.PARRY.get(), ParryParticle::provider);
		event.register(TnunlimitedModParticleTypes.DAYWALKER_SPARKLEZ.get(), DaywalkerSparklezParticle::provider);
	}
}
