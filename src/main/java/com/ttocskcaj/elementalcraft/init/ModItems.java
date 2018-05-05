package com.ttocskcaj.elementalcraft.init;

import com.ttocskcaj.elementalcraft.ElementalCraft;
import com.ttocskcaj.elementalcraft.item.ItemMaterial;
import com.ttocskcaj.elementalcraft.item.magical.ItemGoldAthame;
import com.ttocskcaj.elementalcraft.item.magical.ItemPentacle;
import com.ttocskcaj.elementalcraft.item.magical.ItemWandCitrine;
import com.ttocskcaj.elementalcraft.item.materials.*;
import com.ttocskcaj.elementalcraft.item.tools.ItemChalice;
import com.ttocskcaj.elementalcraft.item.tools.ItemCrescentWand;
import com.ttocskcaj.elementalcraft.item.magical.ItemRingOfTheElements;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
    public static ItemMaterial itemMaterial;

    // Magic
    public static final ItemRingOfTheElements RING_OF_THE_ELEMENTS = new ItemRingOfTheElements();
    public static final ItemPentacle PENTACLE = new ItemPentacle();
    public static final ItemGoldAthame GOLD_ATHAME = new ItemGoldAthame();
    public static final ItemWandCitrine WAND_CITRINE = new ItemWandCitrine();

    // Tools
    public static final ItemCrescentWand CRESCENT_WAND = new ItemCrescentWand();
    public static final ItemChalice CHALICE = new ItemChalice();

    public static void preInit(){
        itemMaterial = new ItemMaterial();
        itemMaterial.preInit();
    }
    public static void init(){
        itemMaterial.init();
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        itemMaterial.registerModels();

        // Magic
        PENTACLE.initModel();
        GOLD_ATHAME.initModel();
        RING_OF_THE_ELEMENTS.initModel();
        WAND_CITRINE.initModel();

        // Tools
        CRESCENT_WAND.initModel();
        CHALICE.initModel();
    }

    public static void register(IForgeRegistry<Item> registry) {
        ElementalCraft.logger.info("Registering Items");

        // Magic
        registry.register(RING_OF_THE_ELEMENTS);
        registry.register(PENTACLE);
        registry.register(GOLD_ATHAME);
        registry.register(WAND_CITRINE);

        // Tools
        registry.register(CRESCENT_WAND);
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        ElementalCraft.logger.info("Creating and registering ItemBlocks");

        // Generic Blocks
        registry.register(new ItemBlock(ModBlocks.AIR_STONE).setRegistryName(ModBlocks.AIR_STONE.getRegistryName()));
        registry.register(new ItemBlock(ModBlocks.ASH_BLOCK).setRegistryName(ModBlocks.ASH_BLOCK.getRegistryName()));
        registry.register(new ItemBlock(ModBlocks.CHARRED_STONE).setRegistryName(ModBlocks.CHARRED_STONE.getRegistryName()));
        registry.register(new ItemBlock(ModBlocks.EARTH_STONE).setRegistryName(ModBlocks.EARTH_STONE.getRegistryName()));
        registry.register(new ItemBlock(ModBlocks.FERTILE_DIRT).setRegistryName(ModBlocks.FERTILE_DIRT.getRegistryName()));
        registry.register(new ItemBlock(ModBlocks.FERTILE_GRASS).setRegistryName(ModBlocks.FERTILE_GRASS.getRegistryName()));
        registry.register(new ItemBlock(ModBlocks.FIRE_STONE).setRegistryName(ModBlocks.FIRE_STONE.getRegistryName()));
        registry.register(new ItemBlock(ModBlocks.RAREFIED_STONE).setRegistryName(ModBlocks.RAREFIED_STONE.getRegistryName()));
        registry.register(new ItemBlock(ModBlocks.SALT_BLOCK).setRegistryName(ModBlocks.SALT_BLOCK.getRegistryName()));
        registry.register(new ItemBlock(ModBlocks.WATER_STONE).setRegistryName(ModBlocks.WATER_STONE.getRegistryName()));


        // Plants
        registry.register(new ItemBlock(ModBlocks.BURNT_BUSH).setRegistryName(ModBlocks.BURNT_BUSH.getRegistryName()));
        registry.register(new ItemBlock(ModBlocks.FIRE_CACTUS).setRegistryName(ModBlocks.FIRE_CACTUS.getRegistryName()));

        // Machines
        registry.register(new ItemBlock(ModBlocks.RAREFACTION_APPARATUS).setRegistryName(ModBlocks.RAREFACTION_APPARATUS.getRegistryName()));


    }
}
