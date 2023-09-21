
package net.mcreator.tnunlimited.world.features.ores;

public class NetherRithiumOreFeature extends OreFeature {

	public static NetherRithiumOreFeature FEATURE = null;
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new NetherRithiumOreFeature();
		CONFIGURED_FEATURE = FeatureUtils.register("tnunlimited:nether_rithium_ore", FEATURE,
				new OreConfiguration(List.of(OreConfiguration.target(new BlockStateMatchTest(Blocks.NETHERRACK.defaultBlockState()), TnunlimitedModBlocks.NETHER_RITHIUM_ORE.get().defaultBlockState())), 8));
		PLACED_FEATURE = PlacementUtils.register("tnunlimited:nether_rithium_ore", CONFIGURED_FEATURE,
				List.of(CountPlacement.of(15), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(320)), BiomeFilter.biome()));
		return FEATURE;
	}

	private final Set<ResourceKey<Level>> generate_dimensions = Set.of(Level.NETHER);

	public NetherRithiumOreFeature() {
		super(OreConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<OreConfiguration> context) {
		WorldGenLevel world = context.level();
		if (!generate_dimensions.contains(world.getLevel().dimension()))
			return false;

		return super.place(context);
	}

}
