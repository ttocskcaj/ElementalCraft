package com.ttocskcaj.elementalcraft.init;

import com.ttocskcaj.elementalcraft.ElementalCraft;
import com.ttocskcaj.elementalcraft.item.magical.ItemGoldAthame;
import com.ttocskcaj.elementalcraft.item.magical.ItemPentacle;
import com.ttocskcaj.elementalcraft.item.magical.ItemWandCitrine;
import com.ttocskcaj.elementalcraft.item.materials.*;
import com.ttocskcaj.elementalcraft.item.tools.ItemCrescentWand;
import com.ttocskcaj.elementalcraft.item.magical.ItemRingOfTheElements;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

    // Magic
    public static final ItemRingOfTheElements RING_OF_THE_ELEMENTS = new ItemRingOfTheElements();
    public static final ItemPentacle PENTACLE = new ItemPentacle();
    public static final ItemGoldAthame GOLD_ATHAME = new ItemGoldAthame();
    public static final ItemWandCitrine WAND_CITRINE = new ItemWandCitrine();

    // Materials
    public static final ItemAetherShard AETHER_SHARD = new ItemAetherShard();
    public static final ItemCrushedAether CRUSHED_AETHER = new ItemCrushedAether();
    public static final ItemCitrine CITRINE_GEM = new ItemCitrine();
    public static final ItemFluorite FLUORITE_GEM = new ItemFluorite();
    public static final ItemAirEnergyShard ENERGY_SHARD_AIR = new ItemAirEnergyShard();
    public static final ItemEarthEnergyShard ENERGY_SHARD_EARTH = new ItemEarthEnergyShard();
    public static final ItemFireEnergyShard ENERGY_SHARD_FIRE = new ItemFireEnergyShard();
    public static final ItemWaterEnergyShard ENERGY_SHARD_WATER = new ItemWaterEnergyShard();

    // Tools
    public static final ItemCrescentWand CRESCENT_WAND = new ItemCrescentWand();


    @SideOnly(Side.CLIENT)
    public static void initModels() {
        // Magic
        RING_OF_THE_ELEMENTS.initModel();
        PENTACLE.initModel();
        GOLD_ATHAME.initModel();
        WAND_CITRINE.initModel();

        // Materials
        AETHER_SHARD.initModel();
        CRUSHED_AETHER.initModel();
        CITRINE_GEM.initModel();
        FLUORITE_GEM.initModel();
        ENERGY_SHARD_AIR.initModel();
        ENERGY_SHARD_FIRE.initModel();
        ENERGY_SHARD_EARTH.initModel();
        ENERGY_SHARD_WATER.initModel();

        // Tools
        CRESCENT_WAND.initModel();
    }

    public static void register(IForgeRegistry<Item> registry) {
        ElementalCraft.logger.info("Registering Items");

        // Magic
        registry.register(RING_OF_THE_ELEMENTS);
        registry.register(PENTACLE);
        registry.register(GOLD_ATHAME);
        registry.register(WAND_CITRINE);

        // Materials
        registry.register(AETHER_SHARD);
        registry.register(CRUSHED_AETHER);
        registry.register(CITRINE_GEM);
        registry.register(FLUORITE_GEM);
        registry.register(ENERGY_SHARD_AIR);
        registry.register(ENERGY_SHARD_EARTH);
        registry.register(ENERGY_SHARD_FIRE);
        registry.register(ENERGY_SHARD_WATER);

        // Tools
        registry.register(CRESCENT_WAND);
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        ElementalCraft.logger.info("Creating and registering ItemBlocks");

        // Energy Blocks
        registry.register(new ItemBlock(ModBlocks.AETHER_BLOCK).setRegistryName(ModBlocks.AETHER_BLOCK.getRegistryName()));
        registry.register(new ItemBlock(ModBlocks.AIR_ENERGY_BLOCK).setRegistryName(ModBlocks.AIR_ENERGY_BLOCK.getRegistryName()));
        registry.register(new ItemBlock(ModBlocks.EARTH_ENERGY_BLOCK).setRegistryName(ModBlocks.EARTH_ENERGY_BLOCK.getRegistryName()));
        registry.register(new ItemBlock(ModBlocks.FIRE_ENERGY_BLOCK).setRegistryName(ModBlocks.FIRE_ENERGY_BLOCK.getRegistryName()));
        registry.register(new ItemBlock(ModBlocks.WATER_ENERGY_BLOCK).setRegistryName(ModBlocks.WATER_ENERGY_BLOCK.getRegistryName()));

        // Generic Blocks
        registry.register(new ItemBlock(ModBlocks.AIR_STONE).setRegistryName(ModBlocks.AIR_STONE.getRegistryName()));
        registry.register(new ItemBlock(ModBlocks.ASH_BLOCK).setRegistryName(ModBlocks.ASH_BLOCK.getRegistryName()));
        registry.register(new ItemBlock(ModBlocks.EARTH_STONE).setRegistryName(ModBlocks.EARTH_STONE.getRegistryName()));
        registry.register(new ItemBlock(ModBlocks.FERTILE_DIRT).setRegistryName(ModBlocks.FERTILE_DIRT.getRegistryName()));
        registry.register(new ItemBlock(ModBlocks.FERTILE_GRASS).setRegistryName(ModBlocks.FERTILE_GRASS.getRegistryName()));
        registry.register(new ItemBlock(ModBlocks.FIRE_STONE).setRegistryName(ModBlocks.FIRE_STONE.getRegistryName()));
        registry.register(new ItemBlock(ModBlocks.RAREFIED_STONE).setRegistryName(ModBlocks.RAREFIED_STONE.getRegistryName()));
        registry.register(new ItemBlock(ModBlocks.SALT_BLOCK).setRegistryName(ModBlocks.SALT_BLOCK.getRegistryName()));
        registry.register(new ItemBlock(ModBlocks.WATER_STONE).setRegistryName(ModBlocks.WATER_STONE.getRegistryName()));

        // Metal Blocks
        registry.register(new ItemBlock(ModBlocks.LEAD_BLOCK).setRegistryName(ModBlocks.LEAD_BLOCK.getRegistryName()));
        registry.register(new ItemBlock(ModBlocks.NICKEL_BLOCK).setRegistryName(ModBlocks.NICKEL_BLOCK.getRegistryName()));
        registry.register(new ItemBlock(ModBlocks.SILVER_BLOCK).setRegistryName(ModBlocks.SILVER_BLOCK.getRegistryName()));
        registry.register(new ItemBlock(ModBlocks.TIN_BLOCK).setRegistryName(ModBlocks.TIN_BLOCK.getRegistryName()));


        // Ores
        registry.register(new ItemBlock(ModBlocks.AETHER_ORE).setRegistryName(ModBlocks.AETHER_ORE.getRegistryName()));
        registry.register(new ItemBlock(ModBlocks.AIR_ENERGY_ORE).setRegistryName(ModBlocks.AIR_ENERGY_ORE.getRegistryName()));
        registry.register(new ItemBlock(ModBlocks.EARTH_ENERGY_ORE).setRegistryName(ModBlocks.EARTH_ENERGY_ORE.getRegistryName()));
        registry.register(new ItemBlock(ModBlocks.FIRE_ENERGY_ORE).setRegistryName(ModBlocks.FIRE_ENERGY_ORE.getRegistryName()));
        registry.register(new ItemBlock(ModBlocks.LEAD_ORE).setRegistryName(ModBlocks.LEAD_ORE.getRegistryName()));
        registry.register(new ItemBlock(ModBlocks.NICKEL_ORE).setRegistryName(ModBlocks.NICKEL_ORE.getRegistryName()));
        registry.register(new ItemBlock(ModBlocks.SILVER_ORE).setRegistryName(ModBlocks.SILVER_ORE.getRegistryName()));
        registry.register(new ItemBlock(ModBlocks.TIN_ORE).setRegistryName(ModBlocks.TIN_ORE.getRegistryName()));
        registry.register(new ItemBlock(ModBlocks.WATER_ENERGY_ORE).setRegistryName(ModBlocks.WATER_ENERGY_ORE.getRegistryName()));
    }
}
