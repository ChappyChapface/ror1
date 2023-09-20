
package net.mcreator.tnunlimited.world.features.ores;

public class TitaniumoreFeature extends OreFeature {

	public static TitaniumoreFeature FEATURE = null;
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new TitaniumoreFeature();
		CONFIGURED_FEATURE = FeatureUtils.register("tnunlimited:titaniumore", FEATURE,
				new OreConfiguration(List.of(OreConfiguration.target(new BlockStateMatchTest(Blocks.STONE.defaultBlockState()), TnunlimitedModBlocks.TITANIUMORE.get().defaultBlockState()),
						OreConfiguration.target(new BlockStateMatchTest(Blocks.GRANITE.defaultBlockState()), TnunlimitedModBlocks.TITANIUMORE.get().defaultBlockState()),
						OreConfiguration.target(new BlockStateMatchTest(Blocks.DIORITE.defaultBlockState()), TnunlimitedModBlocks.TITANIUMORE.get().defaultBlockState()),
						OreConfiguration.target(new BlockStateMatchTest(Blocks.ANDESITE.defaultBlockState()), TnunlimitedModBlocks.TITANIUMORE.get().defaultBlockState())), 8));
		PLACED_FEATURE = PlacementUtils.register("tnunlimited:titaniumore", CONFIGURED_FEATURE,
				List.of(CountPlacement.of(1), InSquarePlacement.spread(), HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(32)), BiomeFilter.biome()));
		return FEATURE;
	}

	private final Set<ResourceKey<Level>> generate_dimensions = Set.of(Level.OVERWORLD);

	public TitaniumoreFeature() {
		super(OreConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<OreConfiguration> context) {
		WorldGenLevel world = context.level();
		if (!generate_dimensions.contains(world.getLevel().dimension()))
			return false;

		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!

		PostDragSpawnConditionProcedure.execute(x, z)

		)
			return false;

		return super.place(context);
	}

}
