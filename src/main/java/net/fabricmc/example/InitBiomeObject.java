package net.fabricmc.example;

import net.fabricmc.example.biomebuilder.BrokenCity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

public class InitBiomeObject {
    public static final RegistryKey<Biome> BrokenCityKey = RegistryKey.of(Registry.BIOME_KEY, new Identifier("example", "brokencity"));
    public static void init() {
        Biome brokencity = Registry.register(BuiltinRegistries.BIOME, BrokenCityKey, BrokenCity.create());
    }
}
