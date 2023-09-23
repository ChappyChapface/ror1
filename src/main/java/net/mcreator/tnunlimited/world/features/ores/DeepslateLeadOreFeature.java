
package net.mcreator.tnunlimited.world.features.ores;

public class DeepslateLeadOreFeature extends OreFeature {

	public static DeepslateLeadOreFeature FEATURE = null;
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new DeepslateLeadOreFeature();
		CONFIGURED_FEATURE = FeatureUtils.register("tnunlimited:deepslate_lead_ore", FEATURE,
				new OreConfiguration(List.of(OreConfiguration.target(new BlockStateMatchTest(Blocks.DEEPSLATE.defaultBlockState()), TnunlimitedModBlocks.DEEPSLATE_LEAD_ORE.get().defaultBlockState())), 5));
		PLACED_FEATURE = PlacementUtils.register("tnunlimited:deepslate_lead_ore", CONFIGURED_FEATURE,
				List.of(CountPlacement.of(10), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(10), VerticalAnchor.absolute(30)), BiomeFilter.biome()));
		return FEATURE;
	}

	private final Set<ResourceKey<Level>> generate_dimensions = Set.of(Level.OVERWORLD);

	public DeepslateLeadOreFeature() {
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
