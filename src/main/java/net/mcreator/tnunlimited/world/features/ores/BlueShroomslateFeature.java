
package net.mcreator.tnunlimited.world.features.ores;

public class BlueShroomslateFeature extends OreFeature {

	public static BlueShroomslateFeature FEATURE = null;
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new BlueShroomslateFeature();
		CONFIGURED_FEATURE = FeatureUtils.register("tnunlimited:blue_shroomslate", FEATURE,
				new OreConfiguration(List.of(OreConfiguration.target(new BlockStateMatchTest(TnunlimitedModBlocks.SHROOM_GRASS.get().defaultBlockState()), TnunlimitedModBlocks.BLUE_SHROOMSLATE.get().defaultBlockState())), 50));
		PLACED_FEATURE = PlacementUtils.register("tnunlimited:blue_shroomslate", CONFIGURED_FEATURE,
				List.of(CountPlacement.of(50), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome()));
		return FEATURE;
	}

	private final Set<ResourceKey<Level>> generate_dimensions = Set.of(Level.OVERWORLD);

	public BlueShroomslateFeature() {
		super(OreConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<OreConfiguration> context) {
		WorldGenLevel world = context.level();
		if (!generate_dimensions.contains(world.getLevel().dimension()))
			return false;

		return super.place(context);
	}

}
