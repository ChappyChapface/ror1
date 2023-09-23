
package net.mcreator.tnunlimited.world.features.ores;

public class PurpleStickySlimeFeature extends OreFeature {

	public static PurpleStickySlimeFeature FEATURE = null;
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new PurpleStickySlimeFeature();
		CONFIGURED_FEATURE = FeatureUtils.register("tnunlimited:purple_sticky_slime", FEATURE,
				new OreConfiguration(List.of(OreConfiguration.target(new BlockStateMatchTest(TnunlimitedModBlocks.BLUE_SHROOMSLATE.get().defaultBlockState()), TnunlimitedModBlocks.PURPLE_STICKY_SLIME.get().defaultBlockState()),
						OreConfiguration.target(new BlockStateMatchTest(TnunlimitedModBlocks.PURPLE_COBBLE_SHROOMSLATE.get().defaultBlockState()), TnunlimitedModBlocks.PURPLE_STICKY_SLIME.get().defaultBlockState()),
						OreConfiguration.target(new BlockStateMatchTest(TnunlimitedModBlocks.SHROOM_GRASS.get().defaultBlockState()), TnunlimitedModBlocks.PURPLE_STICKY_SLIME.get().defaultBlockState())), 64));
		PLACED_FEATURE = PlacementUtils.register("tnunlimited:purple_sticky_slime", CONFIGURED_FEATURE,
				List.of(CountPlacement.of(20), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(256)), BiomeFilter.biome()));
		return FEATURE;
	}

	private final Set<ResourceKey<Level>> generate_dimensions = Set.of(Level.OVERWORLD);

	public PurpleStickySlimeFeature() {
		super(OreConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<OreConfiguration> context) {
		WorldGenLevel world = context.level();
		if (!generate_dimensions.contains(world.getLevel().dimension()))
			return false;

		return super.place(context);
	}

}
