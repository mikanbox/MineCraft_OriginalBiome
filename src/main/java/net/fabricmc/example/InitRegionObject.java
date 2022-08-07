package net.fabricmc.example;

import com.mojang.datafixers.util.Pair;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.List;
import java.util.function.Consumer;

public class InitRegionObject extends Region {
    public InitRegionObject(Identifier name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
        });

        List<MultiNoiseUtil.NoiseHypercube> riverTargetC2F = new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.WARM)
                .humidity(ParameterUtils.Humidity.ARID)
                .continentalness(ParameterUtils.Continentalness.INLAND)
                .erosion(ParameterUtils.Erosion.span(ParameterUtils.Erosion.EROSION_2, ParameterUtils.Erosion.EROSION_5))
                .depth(ParameterUtils.Depth.SURFACE, ParameterUtils.Depth.FLOOR)
                .weirdness(ParameterUtils.Weirdness.VALLEY)
                .build();

        riverTargetC2F.forEach(point -> addBiome(mapper, point, InitBiomeObject.BrokenCityKey));


    }
}
