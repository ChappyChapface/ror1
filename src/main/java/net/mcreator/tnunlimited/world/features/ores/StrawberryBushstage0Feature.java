
package net.mcreator.tnunlimited.world.features.ores;

public class StrawberryBushstage0Feature extends OreFeature {

	public static StrawberryBushstage0Feature FEATURE = null;
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new StrawberryBushstage0Feature();
		CONFIGURED_FEATURE = FeatureUtils.register("tnunlimited:strawberry_bushstage_0", FEATURE, new OreConfiguration(List.of(), 1));
		PLACED_FEATURE = PlacementUtils.register("tnunlimited:strawberry_bushstage_0", CONFIGURED_FEATURE,
				List.of(CountPlacement.of(49), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(50), VerticalAnchor.absolute(100)), BiomeFilter.biome()));
		return FEATURE;
	}

	private final Set<ResourceKey<Level>> generate_dimensions = Set.of(Level.OVERWORLD);

	public StrawberryBushstage0Feature() {
		super(OreConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<OreConfiguration> context) {
		WorldGenLevel world = context.level();
		if (!generate_dimensions.contains(world.getLevel().dimension()))
			return false;

		return super.place(context);
	}

}
