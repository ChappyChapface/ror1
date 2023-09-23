
package net.mcreator.tnunlimited.world.features.ores;

public class NubriumOreFeature extends OreFeature {

	public static NubriumOreFeature FEATURE = null;
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new NubriumOreFeature();
		CONFIGURED_FEATURE = FeatureUtils.register("tnunlimited:nubrium_ore", FEATURE,
				new OreConfiguration(List.of(OreConfiguration.target(new BlockStateMatchTest(Blocks.STONE.defaultBlockState()), TnunlimitedModBlocks.NUBRIUM_ORE.get().defaultBlockState()),
						OreConfiguration.target(new BlockStateMatchTest(Blocks.GRANITE.defaultBlockState()), TnunlimitedModBlocks.NUBRIUM_ORE.get().defaultBlockState()),
						OreConfiguration.target(new BlockStateMatchTest(Blocks.DIORITE.defaultBlockState()), TnunlimitedModBlocks.NUBRIUM_ORE.get().defaultBlockState()),
						OreConfiguration.target(new BlockStateMatchTest(Blocks.ANDESITE.defaultBlockState()), TnunlimitedModBlocks.NUBRIUM_ORE.get().defaultBlockState())), 5));
		PLACED_FEATURE = PlacementUtils.register("tnunlimited:nubrium_ore", CONFIGURED_FEATURE,
				List.of(CountPlacement.of(1), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(1), VerticalAnchor.absolute(16)), BiomeFilter.biome()));
		return FEATURE;
	}

	private final Set<ResourceKey<Level>> generate_dimensions = Set.of(Level.OVERWORLD);

	public NubriumOreFeature() {
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
