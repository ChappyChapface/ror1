
package net.mcreator.tnunlimited.world.features.ores;

import net.minecraft.world.level.levelgen.structure.templatesystem.BlockStateMatchTest;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceKey;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.core.Holder;

import net.mcreator.tnunlimited.init.TnunlimitedModBlocks;

import java.util.Set;
import java.util.List;

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
