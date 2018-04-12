package com.ttocskcaj.elementalcraft;

import com.ttocskcaj.elementalcraft.init.IHasModel;
import com.ttocskcaj.elementalcraft.init.ModAssets;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RegistryHandler {

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        // Register Items
        for (Item item : ModAssets.items) {
            ElementalCraft.logger.info("Registering Item: " + item.getRegistryName());
            event.getRegistry().register(item);
        }

        // Register ItemBlocks
        for (ItemBlock itemBlock : ModAssets.itemBlocks) {
            ElementalCraft.logger.info("Registering ItemBlock: " + itemBlock.getRegistryName());
            event.getRegistry().register(itemBlock);
        }
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        for (Block block : ModAssets.blocks) {
            ElementalCraft.logger.info("Registering Block: " + block.getRegistryName());
            event.getRegistry().register(block);
        }
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        for (Item item : ModAssets.items) {
            if (item instanceof IHasModel) {
                ElementalCraft.logger.info("Registering Item Model: " + item.getRegistryName());
                ((IHasModel) item).registerModels();
            }
        }
        for (ItemBlock itemBlock : ModAssets.itemBlocks) {
            ElementalCraft.logger.info("Registering ItemBlock Model: " + itemBlock.getRegistryName());
            ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(itemBlock.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(itemBlock, 0, itemModelResourceLocation);
        }
    }
}
