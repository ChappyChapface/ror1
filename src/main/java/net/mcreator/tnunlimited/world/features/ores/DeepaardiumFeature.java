
package net.mcreator.tnunlimited.world.features.ores;

public class DeepaardiumFeature extends OreFeature {

	public static DeepaardiumFeature FEATURE = null;
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new DeepaardiumFeature();
		CONFIGURED_FEATURE = FeatureUtils.register("tnunlimited:deepaardium", FEATURE,
				new OreConfiguration(List.of(OreConfiguration.target(new BlockStateMatchTest(Blocks.DEEPSLATE.defaultBlockState()), TnunlimitedModBlocks.DEEPAARDIUM.get().defaultBlockState())), 8));
		PLACED_FEATURE = PlacementUtils.register("tnunlimited:deepaardium", CONFIGURED_FEATURE,
				List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(56)), BiomeFilter.biome()));
		return FEATURE;
	}

	private final Set<ResourceKey<Level>> generate_dimensions = Set.of(Level.OVERWORLD);

	public DeepaardiumFeature() {
		super(OreConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<OreConfiguration> context) {
		WorldGenLevel world = context.level();
		if (!generate_dimensions.contains(world.getLevel().dimension()))
			return false;

		return super.place(context);
	}

}
