package com.ttocskcaj.elementalcraft.proxy;

import com.ttocskcaj.elementalcraft.dimension.WorldTypeEP;
import com.ttocskcaj.elementalcraft.init.ModBiomes;
import com.ttocskcaj.elementalcraft.init.ModBlocks;
import com.ttocskcaj.elementalcraft.init.ModDimensions;
import com.ttocskcaj.elementalcraft.init.ModItems;
import com.ttocskcaj.elementalcraft.util.Config;
import com.ttocskcaj.elementalcraft.util.ModWorldGeneration;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.awt.*;
import java.io.File;

@Mod.EventBusSubscriber
public class CommonProxy {
    // Config instance
    public static Configuration config;

    public static WorldType elementalPlane = new WorldTypeEP();

    public void preInit(FMLPreInitializationEvent event) {
        File directory = event.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "elementalcraft.cfg"));
        Config.readConfig();

        GameRegistry.registerWorldGenerator(new ModWorldGeneration(), 3);

        ModDimensions.init();
        ModBiomes.init();

    }

    public void init() {

    }

    public void postInit(FMLPostInitializationEvent event) {
        if (config.hasChanged()) {
            config.save();
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        /*
            Items
         */
        event.getRegistry().register(ModItems.ITEM_ELEMENTAL_FRAGMENT);
        event.getRegistry().register(ModItems.ITEM_CRESCENT_WAND);
        event.getRegistry().register(ModItems.ITEM_RING_OF_THE_ELEMENTS);
        /*
           ItemBlocks
         */
        event.getRegistry().register(new ItemBlock(ModBlocks.BLOCK_ELEMENTAL_ORE).setRegistryName(ModBlocks.BLOCK_ELEMENTAL_ORE.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.BLOCK_ELEMENTAL_BLOCK).setRegistryName(ModBlocks.BLOCK_ELEMENTAL_BLOCK.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.BLOCK_ELEMENTAL_AIR_BLOCK).setRegistryName(ModBlocks.BLOCK_ELEMENTAL_AIR_BLOCK.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.BLOCK_ELEMENTAL_EARTH_BLOCK).setRegistryName(ModBlocks.BLOCK_ELEMENTAL_EARTH_BLOCK.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.BLOCK_ELEMENTAL_FIRE_BLOCK).setRegistryName(ModBlocks.BLOCK_ELEMENTAL_FIRE_BLOCK.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.BLOCK_ELEMENTAL_WATER_BLOCK).setRegistryName(ModBlocks.BLOCK_ELEMENTAL_WATER_BLOCK.getRegistryName()));

    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(ModBlocks.BLOCK_ELEMENTAL_ORE);
        event.getRegistry().register(ModBlocks.BLOCK_ELEMENTAL_BLOCK);
        event.getRegistry().register(ModBlocks.BLOCK_ELEMENTAL_AIR_BLOCK);
        event.getRegistry().register(ModBlocks.BLOCK_ELEMENTAL_EARTH_BLOCK);
        event.getRegistry().register(ModBlocks.BLOCK_ELEMENTAL_FIRE_BLOCK);
        event.getRegistry().register(ModBlocks.BLOCK_ELEMENTAL_WATER_BLOCK);
    }

    @SubscribeEvent
    public void registerBiomes(RegistryEvent.Register<Biome> event) {
        event.getRegistry().register(ModBiomes.BIOME_FIRE);
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(ModBiomes.BIOME_FIRE, 1));
        BiomeManager.addSpawnBiome(ModBiomes.BIOME_FIRE);
    }

}
