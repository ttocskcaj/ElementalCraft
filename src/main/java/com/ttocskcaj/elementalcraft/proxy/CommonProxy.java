package com.ttocskcaj.elementalcraft.proxy;

import com.ttocskcaj.elementalcraft.block.elementalblocks.*;
import com.ttocskcaj.elementalcraft.block.elementalore.BlockElementalOre;
import com.ttocskcaj.elementalcraft.init.ModBlocks;
import com.ttocskcaj.elementalcraft.init.ModItems;
import com.ttocskcaj.elementalcraft.util.Config;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

@Mod.EventBusSubscriber
public class CommonProxy {
    // Config instance
    public static Configuration config;

    public void preInit(FMLPreInitializationEvent event) {
        File directory = event.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "elementalcraft.cfg"));
        Config.readConfig();
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
        event.getRegistry().register(ModItems.itemElementalFragment);
        /*
           ItemBlocks
         */
        event.getRegistry().register(new ItemBlock(ModBlocks.blockElementalOre).setRegistryName(ModBlocks.blockElementalOre.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.blockElementalBlock).setRegistryName(ModBlocks.blockElementalBlock.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.blockElementalAirBlock).setRegistryName(ModBlocks.blockElementalAirBlock.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.blockElementalEarthBlock).setRegistryName(ModBlocks.blockElementalEarthBlock.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.blockElementalFireBlock).setRegistryName(ModBlocks.blockElementalFireBlock.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.blockElementalWaterBlock).setRegistryName(ModBlocks.blockElementalWaterBlock.getRegistryName()));

    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(ModBlocks.blockElementalOre);
        event.getRegistry().register(ModBlocks.blockElementalBlock);
        event.getRegistry().register(ModBlocks.blockElementalAirBlock);
        event.getRegistry().register(ModBlocks.blockElementalEarthBlock);
        event.getRegistry().register(ModBlocks.blockElementalFireBlock);
        event.getRegistry().register(ModBlocks.blockElementalWaterBlock);
    }
}
