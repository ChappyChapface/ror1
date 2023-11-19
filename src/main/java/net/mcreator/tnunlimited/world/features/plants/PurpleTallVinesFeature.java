
package net.mcreator.tnunlimited.world.features.plants;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class PurpleTallVinesFeature extends RandomPatchFeature {

	public static PurpleTallVinesFeature FEATURE = null;
	public static Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new PurpleTallVinesFeature();
		CONFIGURED_FEATURE = FeatureUtils.register("tnunlimited:purple_tall_vines", FEATURE,
				FeatureUtils.simpleRandomPatchConfiguration(50, PlacementUtils.filtered(Feature.BLOCK_COLUMN, BlockColumnConfiguration.simple(BiasedToBottomInt.of(2, 4), BlockStateProvider.simple(TnunlimitedModBlocks.PURPLE_TALL_VINES.get())),
						BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, BlockPredicate.wouldSurvive(TnunlimitedModBlocks.PURPLE_TALL_VINES.get().defaultBlockState(), BlockPos.ZERO)))));
		PLACED_FEATURE = PlacementUtils.register("tnunlimited:purple_tall_vines", CONFIGURED_FEATURE, List.of(CountPlacement.of(40), RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome()));
		return FEATURE;
	}

	private final Set<ResourceKey<Level>> generate_dimensions = Set.of(Level.OVERWORLD);

	public PurpleTallVinesFeature() {
		super(RandomPatchConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<RandomPatchConfiguration> context) {
		WorldGenLevel world = context.level();
		if (!generate_dimensions.contains(world.getLevel().dimension()))
			return false;

		return super.place(context);
	}
}
