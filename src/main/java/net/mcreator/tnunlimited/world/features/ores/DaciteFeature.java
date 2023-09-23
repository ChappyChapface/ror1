
package net.mcreator.tnunlimited.world.features.ores;

public class DaciteFeature extends OreFeature {

	public static DaciteFeature FEATURE = null;
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new DaciteFeature();
		CONFIGURED_FEATURE = FeatureUtils.register("tnunlimited:dacite", FEATURE,
				new OreConfiguration(List.of(OreConfiguration.target(new BlockStateMatchTest(Blocks.STONE.defaultBlockState()), TnunlimitedModBlocks.DACITE.get().defaultBlockState()),
						OreConfiguration.target(new BlockStateMatchTest(Blocks.GRANITE.defaultBlockState()), TnunlimitedModBlocks.DACITE.get().defaultBlockState()),
						OreConfiguration.target(new BlockStateMatchTest(Blocks.DIORITE.defaultBlockState()), TnunlimitedModBlocks.DACITE.get().defaultBlockState()),
						OreConfiguration.target(new BlockStateMatchTest(Blocks.ANDESITE.defaultBlockState()), TnunlimitedModBlocks.DACITE.get().defaultBlockState()),
						OreConfiguration.target(new BlockStateMatchTest(Blocks.DEEPSLATE.defaultBlockState()), TnunlimitedModBlocks.DACITE.get().defaultBlockState())), 64));
		PLACED_FEATURE = PlacementUtils.register("tnunlimited:dacite", CONFIGURED_FEATURE,
				List.of(CountPlacement.of(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(-60), VerticalAnchor.absolute(60)), BiomeFilter.biome()));
		return FEATURE;
	}

	private final Set<ResourceKey<Level>> generate_dimensions = Set.of(Level.OVERWORLD);

	public DaciteFeature() {
		super(OreConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<OreConfiguration> context) {
		WorldGenLevel world = context.level();
		if (!generate_dimensions.contains(world.getLevel().dimension()))
			return false;

		return super.place(context);
	}

}
