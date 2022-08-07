package com.example.btokencity;

import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
//import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jline.utils.Log;

import java.util.Iterator;
import net.minecraft.world.level.biome.Biome;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(OirginalBiome.MODID)
public class OirginalBiome
{
    public static final String MODID = "originalbiomes";
    public static final Logger LOGGER = LogManager.getLogger();


    public OirginalBiome()
    {
        System.out.println("========================= DebugLog =========================");

        // Register the setup method for modloading
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
//        MinecraftForge.EVENT_BUS.register(this);
//        BiomeModInit.BIOME_MODIFIER_SERIALIZERS.register(modEventBus);



////
        BrokenCityBiome.BIOMES_REGISTER.register(modEventBus);
//        BiomeManager.addAdditionalOverworldBiomes( BrokenCityBiome.BIOMES_OBJECT.getKey() );
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(BrokenCityBiome.BIOMES_OBJECT.getKey(),0));

        System.out.println(  " DebugLog " + BrokenCityBiome.BIOMES_OBJECT.getKey().location().getNamespace()  ); // DebugLog originambiomes
        System.out.println(  " DebugLog " + BrokenCityBiome.BIOMES_OBJECT.getKey().location().getPath()  ); // DebugLog brokencity
        System.out.println(  " DebugLog " + BrokenCityBiome.BIOMES_OBJECT.getKey().registry().getNamespace()  ); // DebugLog minecraft

        removeBiome();
        System.out.println("========================= DebugLog  Removed");

        for (var biome :BiomeManager.getAdditionalOverworldBiomes() ) {
            System.out.println(  " DebugLog  : " + biome.registry().getPath() );
            System.out.println(  " DebugLog  : " + BrokenCityBiome.BIOMES_OBJECT.getId() );
            System.out.println(  " DebugLog  : " + biome.location().getPath() );
            System.out.println(  " DebugLog  : " + biome.location().getNamespace() );
        }

        for (var biome :BiomeManager.getBiomes(BiomeManager.BiomeType.WARM) ) {
            System.out.println(  " DebugLog  : " + biome.getKey().location().getPath() );
            System.out.println(  " DebugLog  : " + biome.getKey().location().getNamespace() );
        }




    }

//        @SubscribeEvent
//        public void register(RegisterEvent event) {
//        event.register(ForgeRegistries.Keys.BIOMES,
//                helper -> {
//                    helper.register(new ResourceLocation(OirginalBiome.MODID, "brokencity"), BrokenCityBiome.jungle() );
//                }
//                );
//
//        }

    private void removeBiome() {
        for (final BiomeManager.BiomeType type : BiomeManager.BiomeType.values()) {
            for (final BiomeManager.BiomeEntry entry : BiomeManager.getBiomes(type)) {
                System.out.println(  " DebugLog ==== " + entry.getKey().location().getNamespace() +" : "+entry.getKey().location().getPath()  ); // DebugLog originambiomes
                BiomeManager.removeBiome(type, entry);
                if (BiomeManager.getBiomes(type).isEmpty()) {
                    System.out.println("Viable generation biomes for type " + type + " is empty! This will cause Vanilla generation to crash! You've been warned!");
                }
            }
        }
    }

}
