
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tnunlimited.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.tnunlimited.entity.ZombieEntity;
import net.mcreator.tnunlimited.entity.WastelandishHopperEntity;
import net.mcreator.tnunlimited.entity.TwoLayerHelmetLayer2Entity;
import net.mcreator.tnunlimited.entity.TwoLayerHelmetLayer1Entity;
import net.mcreator.tnunlimited.entity.TheDeceasedEntity;
import net.mcreator.tnunlimited.entity.SpawnStructureEEntity;
import net.mcreator.tnunlimited.entity.SoulfireSpikeEntity;
import net.mcreator.tnunlimited.entity.SnowgloveEntity;
import net.mcreator.tnunlimited.entity.SlashProjectileEntity;
import net.mcreator.tnunlimited.entity.SlashProjectile2Entity;
import net.mcreator.tnunlimited.entity.RoseGoldDiscEntity;
import net.mcreator.tnunlimited.entity.RockEntity;
import net.mcreator.tnunlimited.entity.RedstoneTreadlingEntity;
import net.mcreator.tnunlimited.entity.RedMaulEntity;
import net.mcreator.tnunlimited.entity.QueenLadyBugEntity;
import net.mcreator.tnunlimited.entity.PurpleBeetleEntity;
import net.mcreator.tnunlimited.entity.PlayerFrostSpikeEntityEntity;
import net.mcreator.tnunlimited.entity.PirateDeadeyeEntity;
import net.mcreator.tnunlimited.entity.PirateCrewmanEntity;
import net.mcreator.tnunlimited.entity.PirateCaptainEntity;
import net.mcreator.tnunlimited.entity.PiranhaEntity;
import net.mcreator.tnunlimited.entity.PinacateBeetleEntity;
import net.mcreator.tnunlimited.entity.OffhandFrostBulletEntity;
import net.mcreator.tnunlimited.entity.OffhandBulletProjectileEntity;
import net.mcreator.tnunlimited.entity.NubriumSpikeEntity;
import net.mcreator.tnunlimited.entity.LeadSpikeEntity;
import net.mcreator.tnunlimited.entity.LapisTreadlingEntity;
import net.mcreator.tnunlimited.entity.LadyBugEntityEntity;
import net.mcreator.tnunlimited.entity.KkoreulMinionEntity;
import net.mcreator.tnunlimited.entity.KkoreulEntity;
import net.mcreator.tnunlimited.entity.KkoreulBulletEntity;
import net.mcreator.tnunlimited.entity.IronSpikeEntity;
import net.mcreator.tnunlimited.entity.IceballEntity;
import net.mcreator.tnunlimited.entity.HelmetFireballEntity;
import net.mcreator.tnunlimited.entity.HellfireEntity;
import net.mcreator.tnunlimited.entity.GoldSpikeEntity;
import net.mcreator.tnunlimited.entity.GildedBugEntity;
import net.mcreator.tnunlimited.entity.GalvanizedHarpoonEntity;
import net.mcreator.tnunlimited.entity.FrostburntEntity;
import net.mcreator.tnunlimited.entity.FrostburnSphereEntity;
import net.mcreator.tnunlimited.entity.FrostSpikeEntity;
import net.mcreator.tnunlimited.entity.FrostSpikeEnityEntity;
import net.mcreator.tnunlimited.entity.FrostSpikeDamageEntity;
import net.mcreator.tnunlimited.entity.FrostPupaeEntity;
import net.mcreator.tnunlimited.entity.FrostPupaeAttackEntity;
import net.mcreator.tnunlimited.entity.FrostBulletProjectileEntity;
import net.mcreator.tnunlimited.entity.FrostAntWorkerEntity;
import net.mcreator.tnunlimited.entity.FrostAntQueenPhase2Entity;
import net.mcreator.tnunlimited.entity.FrostAntQueenEntity;
import net.mcreator.tnunlimited.entity.FrostAntEntity;
import net.mcreator.tnunlimited.entity.FrostAntAlateEntity;
import net.mcreator.tnunlimited.entity.EnemySignalEntity;
import net.mcreator.tnunlimited.entity.EnderProtectorEntity;
import net.mcreator.tnunlimited.entity.DuneSpiderEntity;
import net.mcreator.tnunlimited.entity.DiamondSpikeEntity;
import net.mcreator.tnunlimited.entity.CoronerEntity;
import net.mcreator.tnunlimited.entity.CoffeePotBug1Entity;
import net.mcreator.tnunlimited.entity.CoalTreadlingEntity;
import net.mcreator.tnunlimited.entity.CakemonsterEntityProjectile;
import net.mcreator.tnunlimited.entity.CakemonsterEntity;
import net.mcreator.tnunlimited.entity.CakeblobEntity;
import net.mcreator.tnunlimited.entity.BulletProjectileEntity;
import net.mcreator.tnunlimited.entity.BuckshotPelletProjectileEntity;
import net.mcreator.tnunlimited.entity.BloodripSpikeEntity;
import net.mcreator.tnunlimited.entity.BloodgodOrbEntity;
import net.mcreator.tnunlimited.entity.BedrockAndyEntity;
import net.mcreator.tnunlimited.entity.AntimonyBallEntity;
import net.mcreator.tnunlimited.entity.AmethystFireballEntity;
import net.mcreator.tnunlimited.entity.AardiumNeedleEntity;
import net.mcreator.tnunlimited.TnunlimitedMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TnunlimitedModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TnunlimitedMod.MODID);
	public static final RegistryObject<EntityType<RockEntity>> ROCK = register("projectile_rock",
			EntityType.Builder.<RockEntity>of(RockEntity::new, MobCategory.MISC).setCustomClientFactory(RockEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SnowgloveEntity>> SNOWGLOVE = register("projectile_snowglove",
			EntityType.Builder.<SnowgloveEntity>of(SnowgloveEntity::new, MobCategory.MISC).setCustomClientFactory(SnowgloveEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<RoseGoldDiscEntity>> ROSE_GOLD_DISC = register("projectile_rose_gold_disc",
			EntityType.Builder.<RoseGoldDiscEntity>of(RoseGoldDiscEntity::new, MobCategory.MISC).setCustomClientFactory(RoseGoldDiscEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<GalvanizedHarpoonEntity>> GALVANIZED_HARPOON = register("projectile_galvanized_harpoon", EntityType.Builder.<GalvanizedHarpoonEntity>of(GalvanizedHarpoonEntity::new, MobCategory.MISC)
			.setCustomClientFactory(GalvanizedHarpoonEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<WastelandishHopperEntity>> WASTELANDISH_HOPPER = register("wastelandish_hopper",
			EntityType.Builder.<WastelandishHopperEntity>of(WastelandishHopperEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(24).setUpdateInterval(3).setCustomClientFactory(WastelandishHopperEntity::new)

					.sized(0.35f, 0.3f));
	public static final RegistryObject<EntityType<LadyBugEntityEntity>> LADY_BUG_ENTITY = register("lady_bug_entity",
			EntityType.Builder.<LadyBugEntityEntity>of(LadyBugEntityEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LadyBugEntityEntity::new)

					.sized(0.6f, 0.4f));
	public static final RegistryObject<EntityType<QueenLadyBugEntity>> QUEEN_LADY_BUG = register("queen_lady_bug", EntityType.Builder.<QueenLadyBugEntity>of(QueenLadyBugEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(QueenLadyBugEntity::new).fireImmune().sized(1.5f, 1f));
	public static final RegistryObject<EntityType<CoalTreadlingEntity>> COAL_TREADLING = register("coal_treadling", EntityType.Builder.<CoalTreadlingEntity>of(CoalTreadlingEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CoalTreadlingEntity::new).fireImmune().sized(1f, 1.25f));
	public static final RegistryObject<EntityType<LapisTreadlingEntity>> LAPIS_TREADLING = register("lapis_treadling", EntityType.Builder.<LapisTreadlingEntity>of(LapisTreadlingEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LapisTreadlingEntity::new).fireImmune().sized(1f, 1.25f));
	public static final RegistryObject<EntityType<RedstoneTreadlingEntity>> REDSTONE_TREADLING = register("redstone_treadling", EntityType.Builder.<RedstoneTreadlingEntity>of(RedstoneTreadlingEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RedstoneTreadlingEntity::new).fireImmune().sized(1f, 1.25f));
	public static final RegistryObject<EntityType<PiranhaEntity>> PIRANHA = register("piranha",
			EntityType.Builder.<PiranhaEntity>of(PiranhaEntity::new, MobCategory.WATER_AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(PiranhaEntity::new)

					.sized(0.6f, 0.5f));
	public static final RegistryObject<EntityType<CakemonsterEntity>> CAKEMONSTER = register("cakemonster",
			EntityType.Builder.<CakemonsterEntity>of(CakemonsterEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CakemonsterEntity::new)

					.sized(2.5f, 2.5f));
	public static final RegistryObject<EntityType<CakemonsterEntityProjectile>> CAKEMONSTER_PROJECTILE = register("projectile_cakemonster", EntityType.Builder.<CakemonsterEntityProjectile>of(CakemonsterEntityProjectile::new, MobCategory.MISC)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(CakemonsterEntityProjectile::new).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<PinacateBeetleEntity>> PINACATE_BEETLE = register("pinacate_beetle",
			EntityType.Builder.<PinacateBeetleEntity>of(PinacateBeetleEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PinacateBeetleEntity::new)

					.sized(1f, 0.69f));
	public static final RegistryObject<EntityType<DuneSpiderEntity>> DUNE_SPIDER = register("dune_spider",
			EntityType.Builder.<DuneSpiderEntity>of(DuneSpiderEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DuneSpiderEntity::new)

					.sized(1.6f, 1.05f));
	public static final RegistryObject<EntityType<GildedBugEntity>> GILDED_BUG = register("gilded_bug", EntityType.Builder.<GildedBugEntity>of(GildedBugEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(GildedBugEntity::new).fireImmune().sized(0.55f, 0.4f));
	public static final RegistryObject<EntityType<PirateCrewmanEntity>> PIRATE_CREWMAN = register("pirate_crewman",
			EntityType.Builder.<PirateCrewmanEntity>of(PirateCrewmanEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PirateCrewmanEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<PirateDeadeyeEntity>> PIRATE_DEADEYE = register("pirate_deadeye",
			EntityType.Builder.<PirateDeadeyeEntity>of(PirateDeadeyeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PirateDeadeyeEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<PirateCaptainEntity>> PIRATE_CAPTAIN = register("pirate_captain",
			EntityType.Builder.<PirateCaptainEntity>of(PirateCaptainEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PirateCaptainEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<CoffeePotBug1Entity>> COFFEE_POT_BUG_1 = register("coffee_pot_bug_1",
			EntityType.Builder.<CoffeePotBug1Entity>of(CoffeePotBug1Entity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(32).setUpdateInterval(3).setCustomClientFactory(CoffeePotBug1Entity::new)

					.sized(0.4f, 0.4f));
	public static final RegistryObject<EntityType<SpawnStructureEEntity>> SPAWN_STRUCTURE_E = register("spawn_structure_e", EntityType.Builder.<SpawnStructureEEntity>of(SpawnStructureEEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SpawnStructureEEntity::new).fireImmune().sized(0.6f, 0.6f));
	public static final RegistryObject<EntityType<ZombieEntity>> ZOMBIE = register("zombie",
			EntityType.Builder.<ZombieEntity>of(ZombieEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ZombieEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TwoLayerHelmetLayer1Entity>> TWO_LAYER_HELMET_LAYER_1 = register("two_layer_helmet_layer_1", EntityType.Builder.<TwoLayerHelmetLayer1Entity>of(TwoLayerHelmetLayer1Entity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TwoLayerHelmetLayer1Entity::new).fireImmune().sized(0.575f, 0.575f));
	public static final RegistryObject<EntityType<TwoLayerHelmetLayer2Entity>> TWO_LAYER_HELMET_LAYER_2 = register("two_layer_helmet_layer_2", EntityType.Builder.<TwoLayerHelmetLayer2Entity>of(TwoLayerHelmetLayer2Entity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TwoLayerHelmetLayer2Entity::new).fireImmune().sized(0.625f, 0.625f));
	public static final RegistryObject<EntityType<EnderProtectorEntity>> ENDER_PROTECTOR = register("ender_protector", EntityType.Builder.<EnderProtectorEntity>of(EnderProtectorEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(EnderProtectorEntity::new).fireImmune().sized(0.6f, 2.5f));
	public static final RegistryObject<EntityType<BulletProjectileEntity>> BULLET_PROJECTILE = register("projectile_bullet_projectile", EntityType.Builder.<BulletProjectileEntity>of(BulletProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(BulletProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<BuckshotPelletProjectileEntity>> BUCKSHOT_PELLET_PROJECTILE = register("projectile_buckshot_pellet_projectile",
			EntityType.Builder.<BuckshotPelletProjectileEntity>of(BuckshotPelletProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(BuckshotPelletProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<AmethystFireballEntity>> AMETHYST_FIREBALL = register("projectile_amethyst_fireball", EntityType.Builder.<AmethystFireballEntity>of(AmethystFireballEntity::new, MobCategory.MISC)
			.setCustomClientFactory(AmethystFireballEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<HellfireEntity>> HELLFIRE = register("projectile_hellfire",
			EntityType.Builder.<HellfireEntity>of(HellfireEntity::new, MobCategory.MISC).setCustomClientFactory(HellfireEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FrostPupaeAttackEntity>> FROST_PUPAE_ATTACK = register("projectile_frost_pupae_attack", EntityType.Builder.<FrostPupaeAttackEntity>of(FrostPupaeAttackEntity::new, MobCategory.MISC)
			.setCustomClientFactory(FrostPupaeAttackEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<HelmetFireballEntity>> HELMET_FIREBALL = register("projectile_helmet_fireball",
			EntityType.Builder.<HelmetFireballEntity>of(HelmetFireballEntity::new, MobCategory.MISC).setCustomClientFactory(HelmetFireballEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<BloodripSpikeEntity>> BLOODRIP_SPIKE = register("projectile_bloodrip_spike",
			EntityType.Builder.<BloodripSpikeEntity>of(BloodripSpikeEntity::new, MobCategory.MISC).setCustomClientFactory(BloodripSpikeEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<BloodgodOrbEntity>> BLOODGOD_ORB = register("projectile_bloodgod_orb",
			EntityType.Builder.<BloodgodOrbEntity>of(BloodgodOrbEntity::new, MobCategory.MISC).setCustomClientFactory(BloodgodOrbEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<IceballEntity>> ICEBALL = register("projectile_iceball",
			EntityType.Builder.<IceballEntity>of(IceballEntity::new, MobCategory.MISC).setCustomClientFactory(IceballEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<AardiumNeedleEntity>> AARDIUM_NEEDLE = register("projectile_aardium_needle",
			EntityType.Builder.<AardiumNeedleEntity>of(AardiumNeedleEntity::new, MobCategory.MISC).setCustomClientFactory(AardiumNeedleEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<LeadSpikeEntity>> LEAD_SPIKE = register("projectile_lead_spike",
			EntityType.Builder.<LeadSpikeEntity>of(LeadSpikeEntity::new, MobCategory.MISC).setCustomClientFactory(LeadSpikeEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<NubriumSpikeEntity>> NUBRIUM_SPIKE = register("projectile_nubrium_spike",
			EntityType.Builder.<NubriumSpikeEntity>of(NubriumSpikeEntity::new, MobCategory.MISC).setCustomClientFactory(NubriumSpikeEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FrostburnSphereEntity>> FROSTBURN_SPHERE = register("projectile_frostburn_sphere", EntityType.Builder.<FrostburnSphereEntity>of(FrostburnSphereEntity::new, MobCategory.MISC)
			.setCustomClientFactory(FrostburnSphereEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<GoldSpikeEntity>> GOLD_SPIKE = register("projectile_gold_spike",
			EntityType.Builder.<GoldSpikeEntity>of(GoldSpikeEntity::new, MobCategory.MISC).setCustomClientFactory(GoldSpikeEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<DiamondSpikeEntity>> DIAMOND_SPIKE = register("projectile_diamond_spike",
			EntityType.Builder.<DiamondSpikeEntity>of(DiamondSpikeEntity::new, MobCategory.MISC).setCustomClientFactory(DiamondSpikeEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<AntimonyBallEntity>> ANTIMONY_BALL = register("projectile_antimony_ball",
			EntityType.Builder.<AntimonyBallEntity>of(AntimonyBallEntity::new, MobCategory.MISC).setCustomClientFactory(AntimonyBallEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<IronSpikeEntity>> IRON_SPIKE = register("projectile_iron_spike",
			EntityType.Builder.<IronSpikeEntity>of(IronSpikeEntity::new, MobCategory.MISC).setCustomClientFactory(IronSpikeEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SoulfireSpikeEntity>> SOULFIRE_SPIKE = register("projectile_soulfire_spike",
			EntityType.Builder.<SoulfireSpikeEntity>of(SoulfireSpikeEntity::new, MobCategory.MISC).setCustomClientFactory(SoulfireSpikeEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<CakeblobEntity>> CAKEBLOB = register("projectile_cakeblob",
			EntityType.Builder.<CakeblobEntity>of(CakeblobEntity::new, MobCategory.MISC).setCustomClientFactory(CakeblobEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<RedMaulEntity>> RED_MAUL = register("projectile_red_maul",
			EntityType.Builder.<RedMaulEntity>of(RedMaulEntity::new, MobCategory.MISC).setCustomClientFactory(RedMaulEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<BedrockAndyEntity>> BEDROCK_ANDY = register("bedrock_andy", EntityType.Builder.<BedrockAndyEntity>of(BedrockAndyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(BedrockAndyEntity::new).fireImmune().sized(1f, 2f));
	public static final RegistryObject<EntityType<PurpleBeetleEntity>> PURPLE_BEETLE = register("purple_beetle",
			EntityType.Builder.<PurpleBeetleEntity>of(PurpleBeetleEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PurpleBeetleEntity::new)

					.sized(0.6f, 0.6f));
	public static final RegistryObject<EntityType<CoronerEntity>> CORONER = register("coroner",
			EntityType.Builder.<CoronerEntity>of(CoronerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CoronerEntity::new).fireImmune().sized(0.6f, 2.25f));
	public static final RegistryObject<EntityType<TheDeceasedEntity>> THE_DECEASED = register("the_deceased", EntityType.Builder.<TheDeceasedEntity>of(TheDeceasedEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TheDeceasedEntity::new).fireImmune().sized(0.2f, 0.2f));
	public static final RegistryObject<EntityType<OffhandBulletProjectileEntity>> OFFHAND_BULLET_PROJECTILE = register("projectile_offhand_bullet_projectile",
			EntityType.Builder.<OffhandBulletProjectileEntity>of(OffhandBulletProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(OffhandBulletProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FrostAntQueenEntity>> FROST_ANT_QUEEN = register("frost_ant_queen", EntityType.Builder.<FrostAntQueenEntity>of(FrostAntQueenEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(FrostAntQueenEntity::new).fireImmune().sized(3.7f, 3.44f));
	public static final RegistryObject<EntityType<FrostSpikeEntity>> FROST_SPIKE = register("projectile_frost_spike",
			EntityType.Builder.<FrostSpikeEntity>of(FrostSpikeEntity::new, MobCategory.MISC).setCustomClientFactory(FrostSpikeEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FrostAntQueenPhase2Entity>> FROST_ANT_QUEEN_PHASE_2 = register("frost_ant_queen_phase_2", EntityType.Builder.<FrostAntQueenPhase2Entity>of(FrostAntQueenPhase2Entity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(FrostAntQueenPhase2Entity::new).fireImmune().sized(1.5f, 2.25f));
	public static final RegistryObject<EntityType<FrostSpikeEnityEntity>> FROST_SPIKE_ENITY = register("frost_spike_enity", EntityType.Builder.<FrostSpikeEnityEntity>of(FrostSpikeEnityEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FrostSpikeEnityEntity::new).fireImmune().sized(0.75f, 0.1f));
	public static final RegistryObject<EntityType<FrostSpikeDamageEntity>> FROST_SPIKE_DAMAGE = register("frost_spike_damage", EntityType.Builder.<FrostSpikeDamageEntity>of(FrostSpikeDamageEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FrostSpikeDamageEntity::new).fireImmune().sized(0.75f, 2.5f));
	public static final RegistryObject<EntityType<SlashProjectileEntity>> SLASH_PROJECTILE = register("projectile_slash_projectile", EntityType.Builder.<SlashProjectileEntity>of(SlashProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(SlashProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SlashProjectile2Entity>> SLASH_PROJECTILE_2 = register("projectile_slash_projectile_2", EntityType.Builder.<SlashProjectile2Entity>of(SlashProjectile2Entity::new, MobCategory.MISC)
			.setCustomClientFactory(SlashProjectile2Entity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FrostAntEntity>> FROST_ANT = register("frost_ant",
			EntityType.Builder.<FrostAntEntity>of(FrostAntEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FrostAntEntity::new)

					.sized(1.5f, 1.44f));
	public static final RegistryObject<EntityType<FrostburntEntity>> FROSTBURNT = register("frostburnt",
			EntityType.Builder.<FrostburntEntity>of(FrostburntEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FrostburntEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<FrostPupaeEntity>> FROST_PUPAE = register("frost_pupae",
			EntityType.Builder.<FrostPupaeEntity>of(FrostPupaeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FrostPupaeEntity::new)

					.sized(1.5f, 0.75f));
	public static final RegistryObject<EntityType<FrostAntAlateEntity>> FROST_ANT_ALATE = register("frost_ant_alate",
			EntityType.Builder.<FrostAntAlateEntity>of(FrostAntAlateEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FrostAntAlateEntity::new)

					.sized(1.5f, 0.75f));
	public static final RegistryObject<EntityType<FrostAntWorkerEntity>> FROST_ANT_WORKER = register("frost_ant_worker",
			EntityType.Builder.<FrostAntWorkerEntity>of(FrostAntWorkerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FrostAntWorkerEntity::new)

					.sized(1.5f, 0.75f));
	public static final RegistryObject<EntityType<PlayerFrostSpikeEntityEntity>> PLAYER_FROST_SPIKE_ENTITY = register("player_frost_spike_entity",
			EntityType.Builder.<PlayerFrostSpikeEntityEntity>of(PlayerFrostSpikeEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(PlayerFrostSpikeEntityEntity::new).fireImmune().sized(0.75f, 0.1f));
	public static final RegistryObject<EntityType<FrostBulletProjectileEntity>> FROST_BULLET_PROJECTILE = register("projectile_frost_bullet_projectile",
			EntityType.Builder.<FrostBulletProjectileEntity>of(FrostBulletProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(FrostBulletProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<OffhandFrostBulletEntity>> OFFHAND_FROST_BULLET = register("projectile_offhand_frost_bullet", EntityType.Builder.<OffhandFrostBulletEntity>of(OffhandFrostBulletEntity::new, MobCategory.MISC)
			.setCustomClientFactory(OffhandFrostBulletEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<EnemySignalEntity>> ENEMY_SIGNAL = register("projectile_enemy_signal",
			EntityType.Builder.<EnemySignalEntity>of(EnemySignalEntity::new, MobCategory.MISC).setCustomClientFactory(EnemySignalEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<KkoreulBulletEntity>> KKOREUL_BULLET = register("projectile_kkoreul_bullet",
			EntityType.Builder.<KkoreulBulletEntity>of(KkoreulBulletEntity::new, MobCategory.MISC).setCustomClientFactory(KkoreulBulletEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<KkoreulMinionEntity>> KKOREUL_MINION = register("kkoreul_minion",
			EntityType.Builder.<KkoreulMinionEntity>of(KkoreulMinionEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(KkoreulMinionEntity::new)

					.sized(0.68f, 1.1f));
	public static final RegistryObject<EntityType<KkoreulEntity>> KKOREUL = register("kkoreul",
			EntityType.Builder.<KkoreulEntity>of(KkoreulEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(KkoreulEntity::new).fireImmune().sized(0.6f, 2.2f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			WastelandishHopperEntity.init();
			LadyBugEntityEntity.init();
			QueenLadyBugEntity.init();
			CoalTreadlingEntity.init();
			LapisTreadlingEntity.init();
			RedstoneTreadlingEntity.init();
			PiranhaEntity.init();
			CakemonsterEntity.init();
			PinacateBeetleEntity.init();
			DuneSpiderEntity.init();
			GildedBugEntity.init();
			PirateCrewmanEntity.init();
			PirateDeadeyeEntity.init();
			PirateCaptainEntity.init();
			CoffeePotBug1Entity.init();
			SpawnStructureEEntity.init();
			ZombieEntity.init();
			TwoLayerHelmetLayer1Entity.init();
			TwoLayerHelmetLayer2Entity.init();
			EnderProtectorEntity.init();
			BedrockAndyEntity.init();
			PurpleBeetleEntity.init();
			CoronerEntity.init();
			TheDeceasedEntity.init();
			FrostAntQueenEntity.init();
			FrostAntQueenPhase2Entity.init();
			FrostSpikeEnityEntity.init();
			FrostSpikeDamageEntity.init();
			FrostAntEntity.init();
			FrostburntEntity.init();
			FrostPupaeEntity.init();
			FrostAntAlateEntity.init();
			FrostAntWorkerEntity.init();
			PlayerFrostSpikeEntityEntity.init();
			KkoreulMinionEntity.init();
			KkoreulEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(WASTELANDISH_HOPPER.get(), WastelandishHopperEntity.createAttributes().build());
		event.put(LADY_BUG_ENTITY.get(), LadyBugEntityEntity.createAttributes().build());
		event.put(QUEEN_LADY_BUG.get(), QueenLadyBugEntity.createAttributes().build());
		event.put(COAL_TREADLING.get(), CoalTreadlingEntity.createAttributes().build());
		event.put(LAPIS_TREADLING.get(), LapisTreadlingEntity.createAttributes().build());
		event.put(REDSTONE_TREADLING.get(), RedstoneTreadlingEntity.createAttributes().build());
		event.put(PIRANHA.get(), PiranhaEntity.createAttributes().build());
		event.put(CAKEMONSTER.get(), CakemonsterEntity.createAttributes().build());
		event.put(PINACATE_BEETLE.get(), PinacateBeetleEntity.createAttributes().build());
		event.put(DUNE_SPIDER.get(), DuneSpiderEntity.createAttributes().build());
		event.put(GILDED_BUG.get(), GildedBugEntity.createAttributes().build());
		event.put(PIRATE_CREWMAN.get(), PirateCrewmanEntity.createAttributes().build());
		event.put(PIRATE_DEADEYE.get(), PirateDeadeyeEntity.createAttributes().build());
		event.put(PIRATE_CAPTAIN.get(), PirateCaptainEntity.createAttributes().build());
		event.put(COFFEE_POT_BUG_1.get(), CoffeePotBug1Entity.createAttributes().build());
		event.put(SPAWN_STRUCTURE_E.get(), SpawnStructureEEntity.createAttributes().build());
		event.put(ZOMBIE.get(), ZombieEntity.createAttributes().build());
		event.put(TWO_LAYER_HELMET_LAYER_1.get(), TwoLayerHelmetLayer1Entity.createAttributes().build());
		event.put(TWO_LAYER_HELMET_LAYER_2.get(), TwoLayerHelmetLayer2Entity.createAttributes().build());
		event.put(ENDER_PROTECTOR.get(), EnderProtectorEntity.createAttributes().build());
		event.put(BEDROCK_ANDY.get(), BedrockAndyEntity.createAttributes().build());
		event.put(PURPLE_BEETLE.get(), PurpleBeetleEntity.createAttributes().build());
		event.put(CORONER.get(), CoronerEntity.createAttributes().build());
		event.put(THE_DECEASED.get(), TheDeceasedEntity.createAttributes().build());
		event.put(FROST_ANT_QUEEN.get(), FrostAntQueenEntity.createAttributes().build());
		event.put(FROST_ANT_QUEEN_PHASE_2.get(), FrostAntQueenPhase2Entity.createAttributes().build());
		event.put(FROST_SPIKE_ENITY.get(), FrostSpikeEnityEntity.createAttributes().build());
		event.put(FROST_SPIKE_DAMAGE.get(), FrostSpikeDamageEntity.createAttributes().build());
		event.put(FROST_ANT.get(), FrostAntEntity.createAttributes().build());
		event.put(FROSTBURNT.get(), FrostburntEntity.createAttributes().build());
		event.put(FROST_PUPAE.get(), FrostPupaeEntity.createAttributes().build());
		event.put(FROST_ANT_ALATE.get(), FrostAntAlateEntity.createAttributes().build());
		event.put(FROST_ANT_WORKER.get(), FrostAntWorkerEntity.createAttributes().build());
		event.put(PLAYER_FROST_SPIKE_ENTITY.get(), PlayerFrostSpikeEntityEntity.createAttributes().build());
		event.put(KKOREUL_MINION.get(), KkoreulMinionEntity.createAttributes().build());
		event.put(KKOREUL.get(), KkoreulEntity.createAttributes().build());
	}
}
