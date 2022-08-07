package net.fabricmc.example;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class InitConfigRegister {
    public static void init() {
//        register("river_waterfalls", RIVER_WATERFALLS);
//        register("river_sugarcane", RIVER_SUGARCANE);
//        register("river_sugarcane_tropical", RIVER_SUGARCANE_TROPICAL);
    }

    private static void register(String id, ConfiguredFeature<?, ?> feature) {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("example", id), feature);
    }
}
