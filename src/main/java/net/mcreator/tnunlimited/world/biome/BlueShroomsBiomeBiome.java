
package net.mcreator.tnunlimited.world.biome;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.AmbientParticleSettings;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.AmbientAdditionsSettings;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.sounds.Music;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.tnunlimited.init.TnunlimitedModParticleTypes;
import net.mcreator.tnunlimited.init.TnunlimitedModEntities;

import java.util.List;

public class BlueShroomsBiomeBiome {
	public static final List<Climate.ParameterPoint> UNDERGROUND_PARAMETER_POINTS = List.of(new Climate.ParameterPoint(Climate.Parameter.span(-1f, 1f), Climate.Parameter.span(-1f, 1f), Climate.Parameter.span(-0.1f, 1.52f),
			Climate.Parameter.span(0.01f, 0.5f), Climate.Parameter.span(0.2f, 0.9f), Climate.Parameter.span(-1.6499832423f, 0.3500167577f), 0));

	public static Biome createBiome() {
		BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-13696933).waterColor(-13696933).waterFogColor(-13696933).skyColor(-13696933).foliageColorOverride(-13696933).grassColorOverride(-13696933)
				.ambientLoopSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.warped_forest.loop")))
				.ambientMoodSound(new AmbientMoodSettings(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.warped_forest.loop")), 6000, 8, 2))
				.ambientAdditionsSound(new AmbientAdditionsSettings(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.warped_forest.additions")), 0.0111D))
				.backgroundMusic(new Music(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("music.nether.warped_forest")), 12000, 24000, true))
				.ambientParticle(new AmbientParticleSettings((SimpleParticleType) (TnunlimitedModParticleTypes.PURPLE_SHROOM_PARTICLE.get()), 0.035f)).build();
		BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
		BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeGenerationSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
		BiomeDefaultFeatures.addSurfaceFreezing(biomeGenerationSettings);
		MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
		mobSpawnInfo.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(TnunlimitedModEntities.PURPLE_BEETLE.get(), 40, 1, 5));
		return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).temperature(0.5f).downfall(0.5f).specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build()).generationSettings(biomeGenerationSettings.build()).build();
	}
}
