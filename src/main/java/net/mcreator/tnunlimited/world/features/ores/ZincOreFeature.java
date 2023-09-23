
package net.mcreator.tnunlimited.world.features.ores;

public class ZincOreFeature extends OreFeature {

	public static ZincOreFeature FEATURE = null;
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new ZincOreFeature();
		CONFIGURED_FEATURE = FeatureUtils.register("tnunlimited:zinc_ore", FEATURE,
				new OreConfiguration(List.of(OreConfiguration.target(new BlockStateMatchTest(Blocks.STONE.defaultBlockState()), TnunlimitedModBlocks.ZINC_ORE.get().defaultBlockState()),
						OreConfiguration.target(new BlockStateMatchTest(Blocks.GRANITE.defaultBlockState()), TnunlimitedModBlocks.ZINC_ORE.get().defaultBlockState()),
						OreConfiguration.target(new BlockStateMatchTest(Blocks.DIORITE.defaultBlockState()), TnunlimitedModBlocks.ZINC_ORE.get().defaultBlockState()),
						OreConfiguration.target(new BlockStateMatchTest(Blocks.ANDESITE.defaultBlockState()), TnunlimitedModBlocks.ZINC_ORE.get().defaultBlockState())), 6));
		PLACED_FEATURE = PlacementUtils.register("tnunlimited:zinc_ore", CONFIGURED_FEATURE,
				List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(50)), BiomeFilter.biome()));
		return FEATURE;
	}

	private final Set<ResourceKey<Level>> generate_dimensions = Set.of(Level.OVERWORLD);

	public ZincOreFeature() {
		super(OreConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<OreConfiguration> context) {
		WorldGenLevel world = context.level();
		if (!generate_dimensions.contains(world.getLevel().dimension()))
			return false;

		return super.place(context);
	}

}
