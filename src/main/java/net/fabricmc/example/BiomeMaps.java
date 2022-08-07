package net.fabricmc.example;

import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

public final class BiomeMaps {
    // Mixin cannot handle aastore in initializers so it's been moved here
    public static final RegistryKey<Biome>[][] RR_RIVER_BIOMES = new RegistryKey[][]{
            // Handled by vanilla already
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {InitBiomeObject.BrokenCityKey, InitBiomeObject.BrokenCityKey, InitBiomeObject.BrokenCityKey, InitBiomeObject.BrokenCityKey, InitBiomeObject.BrokenCityKey}
    }; // TODO: carved rivers
}