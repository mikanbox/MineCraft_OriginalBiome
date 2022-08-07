package net.fabricmc.example.biomebuilder;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.OceanPlacedFeatures;

public class BrokenCity {
    public static Biome create() {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder()
                .spawn(SpawnGroup.WATER_CREATURE, new SpawnSettings.SpawnEntry(EntityType.SQUID, 2, 1, 4))
                .spawn(SpawnGroup.WATER_AMBIENT, new SpawnSettings.SpawnEntry(EntityType.SALMON, 5, 1, 5));
        DefaultBiomeFeatures.addBatsAndMonsters(spawnSettings);
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.DROWNED, 100, 1, 1));

        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();//.surfaceBuilder(ConfiguredSurfaceBuilders.DESERT);
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        DefaultBiomeFeatures.addAmethystGeodes(generationSettings);
        DefaultBiomeFeatures.addDungeons(generationSettings);
        DefaultBiomeFeatures.addMineables(generationSettings);
        DefaultBiomeFeatures.addDefaultOres(generationSettings);
        DefaultBiomeFeatures.addDefaultDisks(generationSettings);
        DefaultBiomeFeatures.addWaterBiomeOakTrees(generationSettings);
        DefaultBiomeFeatures.addDefaultFlowers(generationSettings);
        DefaultBiomeFeatures.addDefaultGrass(generationSettings);
        DefaultBiomeFeatures.addDefaultMushrooms(generationSettings);
        DefaultBiomeFeatures.addDefaultVegetation(generationSettings);
        DefaultBiomeFeatures.addSprings(generationSettings);

        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, OceanPlacedFeatures.SEAGRASS_RIVER);

        DefaultBiomeFeatures.addFrozenTopLayer(generationSettings);

        return new Biome.Builder()
                .precipitation(Biome.Precipitation.RAIN)
                .temperature(0.5F)
                .downfall(0.5F)
                .effects(new BiomeEffects.Builder()
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .fogColor(12638463)
                        .skyColor(getSkyColor(0.5F))
                        .moodSound(BiomeMoodSound.CAVE).build())
                .spawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static int getSkyColor(float temperature) {
        float f = temperature / 3.0F;
        f = MathHelper.clamp(f, -1.0F, 1.0F);
        return MathHelper.hsvToRgb(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
    }
}
