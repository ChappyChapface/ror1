
package net.mcreator.tnunlimited.world.features;

public class StoneThingFeature extends Feature<NoneFeatureConfiguration> {
	public static StoneThingFeature FEATURE = null;
	public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new StoneThingFeature();
		CONFIGURED_FEATURE = FeatureUtils.register("tnunlimited:stone_thing", FEATURE, FeatureConfiguration.NONE);
		PLACED_FEATURE = PlacementUtils.register("tnunlimited:stone_thing", CONFIGURED_FEATURE, List.of());
		return FEATURE;
	}

	private final Set<ResourceKey<Level>> generate_dimensions = Set.of(Level.OVERWORLD);
	private final List<Block> base_blocks;
	private StructureTemplate template = null;

	public StoneThingFeature() {
		super(NoneFeatureConfiguration.CODEC);
		base_blocks = List.of(Blocks.STONE, Blocks.IRON_ORE, Blocks.GOLD_ORE, Blocks.LAPIS_ORE, Blocks.DIAMOND_ORE, Blocks.EMERALD_ORE, Blocks.REDSTONE_ORE);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		if (!generate_dimensions.contains(context.level().getLevel().dimension()))
			return false;
		if (template == null)
			template = context.level().getLevel().getStructureManager().getOrCreate(new ResourceLocation("tnunlimited", "undergroundhomevillage"));
		if (template == null)
			return false;
		boolean anyPlaced = false;
		if ((context.random().nextInt(1000000) + 1) <= 5000) {
			int count = context.random().nextInt(1) + 1;
			for (int a = 0; a < count; a++) {
				int i = context.origin().getX() + context.random().nextInt(16);
				int k = context.origin().getZ() + context.random().nextInt(16);
				int j = context.level().getHeight(Heightmap.Types.OCEAN_FLOOR_WG, i, k);
				j = Mth.nextInt(context.random(), 8 + context.level().getMinBuildHeight(), Math.max(j, 9 + context.level().getMinBuildHeight()));
				if (!base_blocks.contains(context.level().getBlockState(new BlockPos(i, j, k)).getBlock()))
					continue;
				BlockPos spawnTo = new BlockPos(i + 0, j + -20, k + 0);
				if (template.placeInWorld(context.level(), spawnTo, spawnTo, new StructurePlaceSettings().setMirror(Mirror.values()[context.random().nextInt(2)]).setRotation(Rotation.values()[context.random().nextInt(3)]).setRandom(context.random())
						.addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK).setIgnoreEntities(false), context.random(), 2)) {
					anyPlaced = true;
				}
			}
		}
		return anyPlaced;
	}
}