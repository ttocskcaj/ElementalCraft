package com.ttocskcaj.elementalcraft.proxy;

import com.ttocskcaj.elementalcraft.ElementalCraft;
import com.ttocskcaj.elementalcraft.world.fire.WorldTypeFire;
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

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.io.File;

@Mod.EventBusSubscriber
public class CommonProxy {
    // Config instance
    public static Configuration config;

    public static WorldType elementalPlane = new WorldTypeFire();

    public void preInit(FMLPreInitializationEvent event) {
        ElementalCraft.logger.info("Common preInit");

        File directory = event.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "elementalcraft.cfg"));
        Config.readConfig();

        GameRegistry.registerWorldGenerator(new ModWorldGeneration(), 3);
//        MinecraftForge.TERRAIN_GEN_BUS.register(new TerrainEventHandler());


    }

    public void init() {
        ElementalCraft.logger.info("Common init");
        ModDimensions.init();

    }

    public void postInit(FMLPostInitializationEvent event) {
        ElementalCraft.logger.info("Common postInit");
        if (config.hasChanged()) {
            config.save();
        }
    }


    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        ElementalCraft.logger.info("Registering Items");

        // Magic
        event.getRegistry().register(ModItems.ITEM_RING_OF_THE_ELEMENTS);
        event.getRegistry().register(ModItems.ITEM_PENTACLE);
        event.getRegistry().register(ModItems.ITEM_GOLD_ATHAME);
        event.getRegistry().register(ModItems.ITEM_WAND_CITRINE);

        // Materials
        event.getRegistry().register(ModItems.ITEM_AETHER_FRAGMENT);
        event.getRegistry().register(ModItems.ITEM_AETHER_DUST);
        event.getRegistry().register(ModItems.ITEM_CITRINE_GEM);
        event.getRegistry().register(ModItems.ITEM_FLUORITE_GEM);
        event.getRegistry().register(ModItems.ITEM_SOLIDIFIED_ENERGY_SHARD_AIR);
        event.getRegistry().register(ModItems.ITEM_SOLIDIFIED_ENERGY_SHARD_EARTH);
        event.getRegistry().register(ModItems.ITEM_SOLIDIFIED_ENERGY_SHARD_FIRE);
        event.getRegistry().register(ModItems.ITEM_SOLIDIFIED_ENERGY_SHARD_WATER);

        // Tools
        event.getRegistry().register(ModItems.ITEM_CRESCENT_WAND);


        /*
         *  Create ItemBlocks
         */
        event.getRegistry().register(new ItemBlock(ModBlocks.AETHER_ORE).setRegistryName(ModBlocks.AETHER_ORE.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.BERYL_ORE).setRegistryName(ModBlocks.BERYL_ORE.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.CITRINE_ORE).setRegistryName(ModBlocks.CITRINE_ORE.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.GARNET_ORE).setRegistryName(ModBlocks.GARNET_ORE.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.FLUORITE_ORE).setRegistryName(ModBlocks.FLUORITE_ORE.getRegistryName()));

        event.getRegistry().register(new ItemBlock(ModBlocks.AETHER_BLOCK).setRegistryName(ModBlocks.AETHER_BLOCK.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.SOLIDIFIED_ENERGY_AIR).setRegistryName(ModBlocks.SOLIDIFIED_ENERGY_AIR.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.SOLIDIFIED_ENERGY_EARTH).setRegistryName(ModBlocks.SOLIDIFIED_ENERGY_EARTH.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.SOLIDIFIED_ENERGY_FIRE).setRegistryName(ModBlocks.SOLIDIFIED_ENERGY_FIRE.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.SOLIDIFIED_ENERGY_WATER).setRegistryName(ModBlocks.SOLIDIFIED_ENERGY_WATER.getRegistryName()));

        event.getRegistry().register(new ItemBlock(ModBlocks.RAREFIED_STONE).setRegistryName(ModBlocks.RAREFIED_STONE.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.FIRE_STONE).setRegistryName(ModBlocks.FIRE_STONE.getRegistryName()));

    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        ElementalCraft.logger.info("Registering Blocks");

        // Ores
        event.getRegistry().register(ModBlocks.AETHER_ORE);
        event.getRegistry().register(ModBlocks.BERYL_ORE);
        event.getRegistry().register(ModBlocks.CITRINE_ORE);
        event.getRegistry().register(ModBlocks.GARNET_ORE);
        event.getRegistry().register(ModBlocks.FLUORITE_ORE);

        // Energy
        event.getRegistry().register(ModBlocks.AETHER_BLOCK);
        event.getRegistry().register(ModBlocks.SOLIDIFIED_ENERGY_AIR);
        event.getRegistry().register(ModBlocks.SOLIDIFIED_ENERGY_EARTH);
        event.getRegistry().register(ModBlocks.SOLIDIFIED_ENERGY_FIRE);
        event.getRegistry().register(ModBlocks.SOLIDIFIED_ENERGY_WATER);

        // Generic
        event.getRegistry().register(ModBlocks.RAREFIED_STONE);
        event.getRegistry().register(ModBlocks.FIRE_STONE);

    }

    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event) {
        ElementalCraft.logger.info("Registering Biomes");
        event.getRegistry().register(ModBiomes.BIOME_FIRE);
        event.getRegistry().register(ModBiomes.BIOME_EARTH);
        ModBiomes.init();
    }

}
