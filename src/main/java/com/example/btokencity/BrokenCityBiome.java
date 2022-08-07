package com.example.btokencity;


import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.Objects;

public class BrokenCityBiome {
    public static final DeferredRegister<Biome> BIOMES_REGISTER = DeferredRegister.create(ForgeRegistries.BIOMES, OirginalBiome.MODID);
//    public static final RegistryObject<Biome> BIOMES_OBJECT = BIOMES_REGISTER.register("brokencity", OverworldBiomes::darkForest);


//    public static final RegistryObject<Biome> BIOMES_OBJECT = BIOMES_REGISTER.register("brokencity", () ->
//        new Biome.BiomeBuilder()
//                .generationSettings(OverworldBiomes.desert().getGenerationSettings())
//                .mobSpawnSettings( OverworldBiomes.desert().getMobSettings() )
//                .specialEffects(OverworldBiomes.desert().getSpecialEffects())
//                .temperature(OverworldBiomes.desert().getBaseTemperature())
//                .precipitation(OverworldBiomes.desert().getPrecipitation())
//                .build()
//    );

    public static final RegistryObject<Biome> BIOMES_OBJECT = BIOMES_REGISTER.register("brokencity", () -> jungle()
    );

    public static Biome jungle() {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.baseJungleSpawns(mobspawnsettings$builder);
        mobspawnsettings$builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PARROT, 40, 1, 2)).addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.OCELOT, 2, 1, 3)).addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PANDA, 1, 1, 2));
        return baseJungle(0.9F, false, false, true, mobspawnsettings$builder);
    }

    private static void globalOverworldGeneration(BiomeGenerationSettings.Builder p_194870_) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(p_194870_);
        BiomeDefaultFeatures.addDefaultCrystalFormations(p_194870_);
        BiomeDefaultFeatures.addDefaultMonsterRoom(p_194870_);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(p_194870_);
        BiomeDefaultFeatures.addDefaultSprings(p_194870_);
        BiomeDefaultFeatures.addSurfaceFreezing(p_194870_);
    }

    private static Biome baseJungle(float p_194846_, boolean p_194847_, boolean p_194848_, boolean p_194849_, MobSpawnSettings.Builder p_194850_) {
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = new BiomeGenerationSettings.Builder();
        globalOverworldGeneration(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultOres(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);
        if (p_194847_) {
            BiomeDefaultFeatures.addBambooVegetation(biomegenerationsettings$builder);
        } else {
            if (p_194849_) {
                BiomeDefaultFeatures.addLightBambooVegetation(biomegenerationsettings$builder);
            }

            if (p_194848_) {
                BiomeDefaultFeatures.addSparseJungleTrees(biomegenerationsettings$builder);
            } else {
                BiomeDefaultFeatures.addJungleTrees(biomegenerationsettings$builder);
            }
        }

        BiomeDefaultFeatures.addWarmFlowers(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addJungleGrass(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addJungleVines(biomegenerationsettings$builder);
        if (p_194848_) {
            BiomeDefaultFeatures.addSparseJungleMelons(biomegenerationsettings$builder);
        } else {
            BiomeDefaultFeatures.addJungleMelons(biomegenerationsettings$builder);
        }

        Music music = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE_AND_FOREST);
        return biome(Biome.Precipitation.RAIN, 0.95F, p_194846_, p_194850_, biomegenerationsettings$builder, music);
    }

    private static Biome biome(Biome.Precipitation p_236664_, float p_236665_, float p_236666_, MobSpawnSettings.Builder p_236667_, BiomeGenerationSettings.Builder p_236668_, @Nullable Music p_236669_) {
        return biome(p_236664_, p_236665_, p_236666_, 4159204, 329011, p_236667_, p_236668_, p_236669_);
    }

    private static Biome biome(Biome.Precipitation p_236655_, float p_236656_, float p_236657_, int p_236658_, int p_236659_, MobSpawnSettings.Builder p_236660_, BiomeGenerationSettings.Builder p_236661_, @Nullable Music p_236662_) {
        return (new Biome.BiomeBuilder()).precipitation(p_236655_).temperature(p_236656_).downfall(p_236657_).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(p_236658_).waterFogColor(p_236659_).fogColor(12638463).skyColor(calculateSkyColor(p_236656_)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(p_236662_).build()).mobSpawnSettings(p_236660_.build()).generationSettings(p_236661_.build()).build();
    }

    protected static int calculateSkyColor(float p_194844_) {
        float $$1 = p_194844_ / 3.0F;
        $$1 = Mth.clamp($$1, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
    }
}
