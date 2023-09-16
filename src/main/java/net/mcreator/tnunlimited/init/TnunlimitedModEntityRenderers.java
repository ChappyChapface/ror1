
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tnunlimited.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.tnunlimited.client.renderer.ZombieRenderer;
import net.mcreator.tnunlimited.client.renderer.WastelandishHopperRenderer;
import net.mcreator.tnunlimited.client.renderer.TwoLayerHelmetLayer2Renderer;
import net.mcreator.tnunlimited.client.renderer.TwoLayerHelmetLayer1Renderer;
import net.mcreator.tnunlimited.client.renderer.TheDeceasedRenderer;
import net.mcreator.tnunlimited.client.renderer.SpawnStructureERenderer;
import net.mcreator.tnunlimited.client.renderer.SoulfireSpikeRenderer;
import net.mcreator.tnunlimited.client.renderer.SlashProjectileRenderer;
import net.mcreator.tnunlimited.client.renderer.SlashProjectile2Renderer;
import net.mcreator.tnunlimited.client.renderer.RoseGoldDiscRenderer;
import net.mcreator.tnunlimited.client.renderer.RedstoneTreadlingRenderer;
import net.mcreator.tnunlimited.client.renderer.QueenLadyBugRenderer;
import net.mcreator.tnunlimited.client.renderer.PurpleBeetleRenderer;
import net.mcreator.tnunlimited.client.renderer.PlayerFrostSpikeEntityRenderer;
import net.mcreator.tnunlimited.client.renderer.PirateDeadeyeRenderer;
import net.mcreator.tnunlimited.client.renderer.PirateCrewmanRenderer;
import net.mcreator.tnunlimited.client.renderer.PirateCaptainRenderer;
import net.mcreator.tnunlimited.client.renderer.PiranhaRenderer;
import net.mcreator.tnunlimited.client.renderer.PinacateBeetleRenderer;
import net.mcreator.tnunlimited.client.renderer.NubriumSpikeRenderer;
import net.mcreator.tnunlimited.client.renderer.LeadSpikeRenderer;
import net.mcreator.tnunlimited.client.renderer.LapisTreadlingRenderer;
import net.mcreator.tnunlimited.client.renderer.LadyBugEntityRenderer;
import net.mcreator.tnunlimited.client.renderer.KkoreulRenderer;
import net.mcreator.tnunlimited.client.renderer.KkoreulMinionRenderer;
import net.mcreator.tnunlimited.client.renderer.IronSpikeRenderer;
import net.mcreator.tnunlimited.client.renderer.GoldSpikeRenderer;
import net.mcreator.tnunlimited.client.renderer.GildedBugRenderer;
import net.mcreator.tnunlimited.client.renderer.GalvanizedHarpoonRenderer;
import net.mcreator.tnunlimited.client.renderer.FrostburntRenderer;
import net.mcreator.tnunlimited.client.renderer.FrostburnSphereRenderer;
import net.mcreator.tnunlimited.client.renderer.FrostSpikeRenderer;
import net.mcreator.tnunlimited.client.renderer.FrostSpikeEnityRenderer;
import net.mcreator.tnunlimited.client.renderer.FrostSpikeDamageRenderer;
import net.mcreator.tnunlimited.client.renderer.FrostPupaeRenderer;
import net.mcreator.tnunlimited.client.renderer.FrostAntWorkerRenderer;
import net.mcreator.tnunlimited.client.renderer.FrostAntRenderer;
import net.mcreator.tnunlimited.client.renderer.FrostAntQueenRenderer;
import net.mcreator.tnunlimited.client.renderer.FrostAntQueenPhase2Renderer;
import net.mcreator.tnunlimited.client.renderer.FrostAntAlateRenderer;
import net.mcreator.tnunlimited.client.renderer.EnderProtectorRenderer;
import net.mcreator.tnunlimited.client.renderer.DuneSpiderRenderer;
import net.mcreator.tnunlimited.client.renderer.DiamondSpikeRenderer;
import net.mcreator.tnunlimited.client.renderer.CoronerRenderer;
import net.mcreator.tnunlimited.client.renderer.CoffeePotBug1Renderer;
import net.mcreator.tnunlimited.client.renderer.CoalTreadlingRenderer;
import net.mcreator.tnunlimited.client.renderer.CakemonsterRenderer;
import net.mcreator.tnunlimited.client.renderer.BloodripSpikeRenderer;
import net.mcreator.tnunlimited.client.renderer.BloodgodOrbRenderer;
import net.mcreator.tnunlimited.client.renderer.BedrockAndyRenderer;
import net.mcreator.tnunlimited.client.renderer.AntimonyBallRenderer;
import net.mcreator.tnunlimited.client.renderer.AardiumNeedleRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TnunlimitedModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(TnunlimitedModEntities.ROCK.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.SNOWGLOVE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.ROSE_GOLD_DISC.get(), RoseGoldDiscRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.GALVANIZED_HARPOON.get(), GalvanizedHarpoonRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.WASTELANDISH_HOPPER.get(), WastelandishHopperRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.LADY_BUG_ENTITY.get(), LadyBugEntityRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.QUEEN_LADY_BUG.get(), QueenLadyBugRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.COAL_TREADLING.get(), CoalTreadlingRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.LAPIS_TREADLING.get(), LapisTreadlingRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.REDSTONE_TREADLING.get(), RedstoneTreadlingRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.PIRANHA.get(), PiranhaRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.CAKEMONSTER.get(), CakemonsterRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.CAKEMONSTER_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.PINACATE_BEETLE.get(), PinacateBeetleRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.DUNE_SPIDER.get(), DuneSpiderRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.GILDED_BUG.get(), GildedBugRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.PIRATE_CREWMAN.get(), PirateCrewmanRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.PIRATE_DEADEYE.get(), PirateDeadeyeRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.PIRATE_CAPTAIN.get(), PirateCaptainRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.COFFEE_POT_BUG_1.get(), CoffeePotBug1Renderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.SPAWN_STRUCTURE_E.get(), SpawnStructureERenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.ZOMBIE.get(), ZombieRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.TWO_LAYER_HELMET_LAYER_1.get(), TwoLayerHelmetLayer1Renderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.TWO_LAYER_HELMET_LAYER_2.get(), TwoLayerHelmetLayer2Renderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.ENDER_PROTECTOR.get(), EnderProtectorRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.BULLET_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.BUCKSHOT_PELLET_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.AMETHYST_FIREBALL.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.HELLFIRE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.FROST_PUPAE_ATTACK.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.HELMET_FIREBALL.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.BLOODRIP_SPIKE.get(), BloodripSpikeRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.BLOODGOD_ORB.get(), BloodgodOrbRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.ICEBALL.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.AARDIUM_NEEDLE.get(), AardiumNeedleRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.LEAD_SPIKE.get(), LeadSpikeRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.NUBRIUM_SPIKE.get(), NubriumSpikeRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.FROSTBURN_SPHERE.get(), FrostburnSphereRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.GOLD_SPIKE.get(), GoldSpikeRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.DIAMOND_SPIKE.get(), DiamondSpikeRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.ANTIMONY_BALL.get(), AntimonyBallRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.IRON_SPIKE.get(), IronSpikeRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.SOULFIRE_SPIKE.get(), SoulfireSpikeRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.CAKEBLOB.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.RED_MAUL.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.BEDROCK_ANDY.get(), BedrockAndyRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.PURPLE_BEETLE.get(), PurpleBeetleRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.CORONER.get(), CoronerRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.THE_DECEASED.get(), TheDeceasedRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.OFFHAND_BULLET_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.FROST_ANT_QUEEN.get(), FrostAntQueenRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.FROST_SPIKE.get(), FrostSpikeRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.FROST_ANT_QUEEN_PHASE_2.get(), FrostAntQueenPhase2Renderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.FROST_SPIKE_ENITY.get(), FrostSpikeEnityRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.FROST_SPIKE_DAMAGE.get(), FrostSpikeDamageRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.SLASH_PROJECTILE.get(), SlashProjectileRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.SLASH_PROJECTILE_2.get(), SlashProjectile2Renderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.FROST_ANT.get(), FrostAntRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.FROSTBURNT.get(), FrostburntRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.FROST_PUPAE.get(), FrostPupaeRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.FROST_ANT_ALATE.get(), FrostAntAlateRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.FROST_ANT_WORKER.get(), FrostAntWorkerRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.PLAYER_FROST_SPIKE_ENTITY.get(), PlayerFrostSpikeEntityRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.FROST_BULLET_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.OFFHAND_FROST_BULLET.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.ENEMY_SIGNAL.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.KKOREUL_BULLET.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.KKOREUL_MINION.get(), KkoreulMinionRenderer::new);
		event.registerEntityRenderer(TnunlimitedModEntities.KKOREUL.get(), KkoreulRenderer::new);
	}
}
