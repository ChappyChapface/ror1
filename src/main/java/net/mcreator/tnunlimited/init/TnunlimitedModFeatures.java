
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tnunlimited.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

import net.mcreator.tnunlimited.world.features.plants.TangeloBlossomFeature;
import net.mcreator.tnunlimited.world.features.plants.PurpleLightglowFeature;
import net.mcreator.tnunlimited.world.features.plants.IceRoseFeature;
import net.mcreator.tnunlimited.world.features.plants.CoffeePlantFeature;
import net.mcreator.tnunlimited.world.features.plants.CattailFeature;
import net.mcreator.tnunlimited.world.features.plants.BlueShroomThronsFeature;
import net.mcreator.tnunlimited.world.features.plants.BlueShroomRootsFeature;
import net.mcreator.tnunlimited.world.features.plants.BlueShroomFungiFeature;
import net.mcreator.tnunlimited.world.features.plants.BlueLavanderFeature;
import net.mcreator.tnunlimited.world.features.ores.ZincOreFeature;
import net.mcreator.tnunlimited.world.features.ores.ZincDeepslateOreFeature;
import net.mcreator.tnunlimited.world.features.ores.SupergraniteFeature;
import net.mcreator.tnunlimited.world.features.ores.StrawberryBushstage4Feature;
import net.mcreator.tnunlimited.world.features.ores.StrawberryBushstage0Feature;
import net.mcreator.tnunlimited.world.features.ores.PurpleCobbleShroomslateFeature;
import net.mcreator.tnunlimited.world.features.ores.NubriumOreFeature;
import net.mcreator.tnunlimited.world.features.ores.NetherRithiumOreFeature;
import net.mcreator.tnunlimited.world.features.ores.LemonstoneFeature;
import net.mcreator.tnunlimited.world.features.ores.LeadOreFeature;
import net.mcreator.tnunlimited.world.features.ores.DeepslateLeadOreFeature;
import net.mcreator.tnunlimited.world.features.ores.DeepslateAntinomyOreFeature;
import net.mcreator.tnunlimited.world.features.ores.DeepaardiumFeature;
import net.mcreator.tnunlimited.world.features.ores.DaciteFeature;
import net.mcreator.tnunlimited.world.features.ores.BlueShroomslateFeature;
import net.mcreator.tnunlimited.world.features.ores.AntimonyOreFeature;
import net.mcreator.tnunlimited.world.features.ores.AardiumoreFeature;
import net.mcreator.tnunlimited.world.features.StrayStructureFeature;
import net.mcreator.tnunlimited.world.features.StoneThingFeature;
import net.mcreator.tnunlimited.world.features.SmallPillagerCastleFeature;
import net.mcreator.tnunlimited.world.features.SmallBlueShroomFeature;
import net.mcreator.tnunlimited.world.features.SinChestStructureFeature;
import net.mcreator.tnunlimited.world.features.PitFeature;
import net.mcreator.tnunlimited.world.features.PirateShipFeature;
import net.mcreator.tnunlimited.world.features.PalmTree2Feature;
import net.mcreator.tnunlimited.world.features.PalmTree1Feature;
import net.mcreator.tnunlimited.world.features.NetherTowerLimitedFeature;
import net.mcreator.tnunlimited.world.features.NetherTowerFeature;
import net.mcreator.tnunlimited.world.features.MedBlueShroomFeature;
import net.mcreator.tnunlimited.world.features.LargeBlueShroomFeature;
import net.mcreator.tnunlimited.world.features.EcoTreeFeature;
import net.mcreator.tnunlimited.world.features.DeepslateShrineFeature;
import net.mcreator.tnunlimited.world.features.AntlionStatueFeature;
import net.mcreator.tnunlimited.world.features.AncientRuinsFeature;
import net.mcreator.tnunlimited.TnunlimitedMod;

@Mod.EventBusSubscriber
public class TnunlimitedModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, TnunlimitedMod.MODID);
	public static final RegistryObject<Feature<?>> AARDIUMORE = REGISTRY.register("aardiumore", AardiumoreFeature::feature);
	public static final RegistryObject<Feature<?>> DEEPAARDIUM = REGISTRY.register("deepaardium", DeepaardiumFeature::feature);
	public static final RegistryObject<Feature<?>> ZINC_ORE = REGISTRY.register("zinc_ore", ZincOreFeature::feature);
	public static final RegistryObject<Feature<?>> ZINC_DEEPSLATE_ORE = REGISTRY.register("zinc_deepslate_ore", ZincDeepslateOreFeature::feature);
	public static final RegistryObject<Feature<?>> NETHER_RITHIUM_ORE = REGISTRY.register("nether_rithium_ore", NetherRithiumOreFeature::feature);
	public static final RegistryObject<Feature<?>> LEAD_ORE = REGISTRY.register("lead_ore", LeadOreFeature::feature);
	public static final RegistryObject<Feature<?>> DEEPSLATE_LEAD_ORE = REGISTRY.register("deepslate_lead_ore", DeepslateLeadOreFeature::feature);
	public static final RegistryObject<Feature<?>> ANTIMONY_ORE = REGISTRY.register("antimony_ore", AntimonyOreFeature::feature);
	public static final RegistryObject<Feature<?>> DEEPSLATE_ANTINOMY_ORE = REGISTRY.register("deepslate_antinomy_ore", DeepslateAntinomyOreFeature::feature);
	public static final RegistryObject<Feature<?>> NUBRIUM_ORE = REGISTRY.register("nubrium_ore", NubriumOreFeature::feature);
	public static final RegistryObject<Feature<?>> SUPERGRANITE = REGISTRY.register("supergranite", SupergraniteFeature::feature);
	public static final RegistryObject<Feature<?>> LEMONSTONE = REGISTRY.register("lemonstone", LemonstoneFeature::feature);
	public static final RegistryObject<Feature<?>> DACITE = REGISTRY.register("dacite", DaciteFeature::feature);
	public static final RegistryObject<Feature<?>> COFFEE_PLANT = REGISTRY.register("coffee_plant", CoffeePlantFeature::feature);
	public static final RegistryObject<Feature<?>> SIN_CHEST_STRUCTURE = REGISTRY.register("sin_chest_structure", SinChestStructureFeature::feature);
	public static final RegistryObject<Feature<?>> ANTLION_STATUE = REGISTRY.register("antlion_statue", AntlionStatueFeature::feature);
	public static final RegistryObject<Feature<?>> ANCIENT_RUINS = REGISTRY.register("ancient_ruins", AncientRuinsFeature::feature);
	public static final RegistryObject<Feature<?>> PIRATE_SHIP = REGISTRY.register("pirate_ship", PirateShipFeature::feature);
	public static final RegistryObject<Feature<?>> NETHER_TOWER = REGISTRY.register("nether_tower", NetherTowerFeature::feature);
	public static final RegistryObject<Feature<?>> STRAY_STRUCTURE = REGISTRY.register("stray_structure", StrayStructureFeature::feature);
	public static final RegistryObject<Feature<?>> STONE_THING = REGISTRY.register("stone_thing", StoneThingFeature::feature);
	public static final RegistryObject<Feature<?>> NETHER_TOWER_LIMITED = REGISTRY.register("nether_tower_limited", NetherTowerLimitedFeature::feature);
	public static final RegistryObject<Feature<?>> PIT = REGISTRY.register("pit", PitFeature::feature);
	public static final RegistryObject<Feature<?>> STRAWBERRY_BUSHSTAGE_4 = REGISTRY.register("strawberry_bushstage_4", StrawberryBushstage4Feature::feature);
	public static final RegistryObject<Feature<?>> STRAWBERRY_BUSHSTAGE_0 = REGISTRY.register("strawberry_bushstage_0", StrawberryBushstage0Feature::feature);
	public static final RegistryObject<Feature<?>> PALM_TREE_2 = REGISTRY.register("palm_tree_2", PalmTree2Feature::feature);
	public static final RegistryObject<Feature<?>> PALM_TREE_1 = REGISTRY.register("palm_tree_1", PalmTree1Feature::feature);
	public static final RegistryObject<Feature<?>> MED_BLUE_SHROOM = REGISTRY.register("med_blue_shroom", MedBlueShroomFeature::feature);
	public static final RegistryObject<Feature<?>> SMALL_BLUE_SHROOM = REGISTRY.register("small_blue_shroom", SmallBlueShroomFeature::feature);
	public static final RegistryObject<Feature<?>> LARGE_BLUE_SHROOM = REGISTRY.register("large_blue_shroom", LargeBlueShroomFeature::feature);
	public static final RegistryObject<Feature<?>> SMALL_PILLAGER_CASTLE = REGISTRY.register("small_pillager_castle", SmallPillagerCastleFeature::feature);
	public static final RegistryObject<Feature<?>> ECO_TREE = REGISTRY.register("eco_tree", EcoTreeFeature::feature);
	public static final RegistryObject<Feature<?>> DEEPSLATE_SHRINE = REGISTRY.register("deepslate_shrine", DeepslateShrineFeature::feature);
	public static final RegistryObject<Feature<?>> TANGELO_BLOSSOM = REGISTRY.register("tangelo_blossom", TangeloBlossomFeature::feature);
	public static final RegistryObject<Feature<?>> ICE_ROSE = REGISTRY.register("ice_rose", IceRoseFeature::feature);
	public static final RegistryObject<Feature<?>> BLUE_SHROOMSLATE = REGISTRY.register("blue_shroomslate", BlueShroomslateFeature::feature);
	public static final RegistryObject<Feature<?>> BLUE_SHROOM_FUNGI = REGISTRY.register("blue_shroom_fungi", BlueShroomFungiFeature::feature);
	public static final RegistryObject<Feature<?>> BLUE_SHROOM_ROOTS = REGISTRY.register("blue_shroom_roots", BlueShroomRootsFeature::feature);
	public static final RegistryObject<Feature<?>> BLUE_SHROOM_THRONS = REGISTRY.register("blue_shroom_throns", BlueShroomThronsFeature::feature);
	public static final RegistryObject<Feature<?>> PURPLE_LIGHTGLOW = REGISTRY.register("purple_lightglow", PurpleLightglowFeature::feature);
	public static final RegistryObject<Feature<?>> CATTAIL = REGISTRY.register("cattail", CattailFeature::feature);
	public static final RegistryObject<Feature<?>> BLUE_LAVANDER = REGISTRY.register("blue_lavander", BlueLavanderFeature::feature);
	public static final RegistryObject<Feature<?>> PURPLE_COBBLE_SHROOMSLATE = REGISTRY.register("purple_cobble_shroomslate", PurpleCobbleShroomslateFeature::feature);
}
