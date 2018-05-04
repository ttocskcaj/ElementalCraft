package com.ttocskcaj.elementalcraft.init;

import com.ttocskcaj.elementalcraft.ElementalCraft;
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

    // Magic
    public static final ItemRingOfTheElements RING_OF_THE_ELEMENTS = new ItemRingOfTheElements();
    public static final ItemPentacle PENTACLE = new ItemPentacle();
    public static final ItemGoldAthame GOLD_ATHAME = new ItemGoldAthame();
    public static final ItemWandCitrine WAND_CITRINE = new ItemWandCitrine();

    // Materials
    public static final ItemAetherShard AETHER_SHARD = new ItemAetherShard();
    public static final ItemAirEnergyShard AIR_ENERGY_SHARD = new ItemAirEnergyShard();
    public static final ItemAquamarine AQUAMARINE = new ItemAquamarine();
    public static final ItemAzurite AZURITE = new ItemAzurite();
    public static final ItemBeryl BERYL = new ItemBeryl();
    public static final ItemBloodstone BLOODSTONE = new ItemBloodstone();
    public static final ItemCitrine CITRINE = new ItemCitrine();
    public static final ItemCrushedAether CRUSHED_AETHER = new ItemCrushedAether();
    public static final ItemEarthEnergyShard EARTH_ENERGY_SHARD = new ItemEarthEnergyShard();
    public static final ItemFireEnergyShard FIRE_ENERGY_SHARD = new ItemFireEnergyShard();
    public static final ItemFluorite FLUORITE = new ItemFluorite();
    public static final ItemGarnet GARNET = new ItemGarnet();
    public static final ItemJade JADE = new ItemJade();
    public static final ItemOnyx ONYX = new ItemOnyx();
    public static final ItemWaterEnergyShard WATER_ENERGY_SHARD = new ItemWaterEnergyShard();

    // Tools
    public static final ItemCrescentWand CRESCENT_WAND = new ItemCrescentWand();
    public static final ItemChalice CHALICE = new ItemChalice();


    @SideOnly(Side.CLIENT)
    public static void initModels() {
        // Magic
        PENTACLE.initModel();
        GOLD_ATHAME.initModel();
        RING_OF_THE_ELEMENTS.initModel();
        WAND_CITRINE.initModel();

        // Materials
        AETHER_SHARD.initModel();
        AIR_ENERGY_SHARD.initModel();
        AQUAMARINE.initModel();
        AZURITE.initModel();
        BERYL.initModel();
        BLOODSTONE.initModel();
        CITRINE.initModel();
        CRUSHED_AETHER.initModel();
        EARTH_ENERGY_SHARD.initModel();
        FLUORITE.initModel();
        GARNET.initModel();
        JADE.initModel();
        ONYX.initModel();
        FIRE_ENERGY_SHARD.initModel();
        WATER_ENERGY_SHARD.initModel();

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

        // Materials
        registry.registerAll(AETHER_SHARD, AIR_ENERGY_SHARD, AQUAMARINE, AZURITE, BERYL, BLOODSTONE, CITRINE, CRUSHED_AETHER, EARTH_ENERGY_SHARD, FIRE_ENERGY_SHARD, FLUORITE, GARNET, JADE, ONYX, WATER_ENERGY_SHARD);

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
