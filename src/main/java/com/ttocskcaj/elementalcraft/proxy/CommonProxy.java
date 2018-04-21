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
        ModItems.register(event.getRegistry());
        ModItems.registerItemBlocks(event.getRegistry());
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        ModBlocks.register(event.getRegistry());

    }

    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event) {
        ElementalCraft.logger.info("Registering Biomes");
        event.getRegistry().register(ModBiomes.BIOME_FIRE);
        event.getRegistry().register(ModBiomes.BIOME_EARTH);
        event.getRegistry().register(ModBiomes.BIOME_AIR);
        ModBiomes.init();
    }

}
