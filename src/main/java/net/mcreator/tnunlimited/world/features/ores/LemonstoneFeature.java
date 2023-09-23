
package net.mcreator.tnunlimited.world.features.ores;

public class LemonstoneFeature extends OreFeature {

	public static LemonstoneFeature FEATURE = null;
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new LemonstoneFeature();
		CONFIGURED_FEATURE = FeatureUtils.register("tnunlimited:lemonstone", FEATURE,
				new OreConfiguration(List.of(OreConfiguration.target(new BlockStateMatchTest(Blocks.SAND.defaultBlockState()), TnunlimitedModBlocks.LEMONSTONE.get().defaultBlockState()),
						OreConfiguration.target(new BlockStateMatchTest(Blocks.SANDSTONE.defaultBlockState()), TnunlimitedModBlocks.LEMONSTONE.get().defaultBlockState())), 16));
		PLACED_FEATURE = PlacementUtils.register("tnunlimited:lemonstone", CONFIGURED_FEATURE,
				List.of(CountPlacement.of(16), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)), BiomeFilter.biome()));
		return FEATURE;
	}

	private final Set<ResourceKey<Level>> generate_dimensions = Set.of(Level.OVERWORLD);

	public LemonstoneFeature() {
		super(OreConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<OreConfiguration> context) {
		WorldGenLevel world = context.level();
		if (!generate_dimensions.contains(world.getLevel().dimension()))
			return false;

		return super.place(context);
	}

}
