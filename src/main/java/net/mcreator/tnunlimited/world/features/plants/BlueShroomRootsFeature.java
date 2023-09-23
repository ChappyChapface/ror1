
package net.mcreator.tnunlimited.world.features.plants;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class BlueShroomRootsFeature extends RandomPatchFeature {

	public static BlueShroomRootsFeature FEATURE = null;
	public static Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new BlueShroomRootsFeature();
		CONFIGURED_FEATURE = FeatureUtils.register("tnunlimited:blue_shroom_roots", FEATURE,
				FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(TnunlimitedModBlocks.BLUE_SHROOM_ROOTS.get())), List.of(), 200));
		PLACED_FEATURE = PlacementUtils.register("tnunlimited:blue_shroom_roots", CONFIGURED_FEATURE, List.of(CountPlacement.of(40), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome()));
		return FEATURE;
	}

	private final Set<ResourceKey<Level>> generate_dimensions = Set.of(Level.OVERWORLD);

	public BlueShroomRootsFeature() {
		super(RandomPatchConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<RandomPatchConfiguration> context) {
		WorldGenLevel world = context.level();
		if (!generate_dimensions.contains(world.getLevel().dimension()))
			return false;

		return super.place(context);
	}
}
