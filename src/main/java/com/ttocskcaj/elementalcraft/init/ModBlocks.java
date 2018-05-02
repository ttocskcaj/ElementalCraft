package com.ttocskcaj.elementalcraft.init;

import com.ttocskcaj.elementalcraft.ElementalCraft;
import com.ttocskcaj.elementalcraft.block.energy.*;
import com.ttocskcaj.elementalcraft.block.generic.*;
import com.ttocskcaj.elementalcraft.block.metal.BlockLead;
import com.ttocskcaj.elementalcraft.block.metal.BlockNickel;
import com.ttocskcaj.elementalcraft.block.metal.BlockSilver;
import com.ttocskcaj.elementalcraft.block.metal.BlockTin;
import com.ttocskcaj.elementalcraft.block.ore.*;
import com.ttocskcaj.elementalcraft.block.plant.BlockBurntBush;
import com.ttocskcaj.elementalcraft.block.plant.BlockFireCactus;
import net.minecraft.block.Block;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {
    // Ores
    public static final BlockAetherOre AETHER_ORE = new BlockAetherOre();
    public static final BlockAirEnergyOre AIR_ENERGY_ORE = new BlockAirEnergyOre();
    public static final BlockGemOre AQUAMARINE_ORE = new BlockGemOre("aquamarine_ore", ModItems.AQUAMARINE, false);
    public static final BlockGemOre AZURITE_ORE = new BlockGemOre("azurite_ore", ModItems.AZURITE, true);
    public static final BlockGemOre BERYL_ORE = new BlockGemOre("beryl_ore", ModItems.BERYL, false);
    public static final BlockGemOre BLOODSTONE_ORE = new BlockGemOre("bloodstone_ore", ModItems.BLOODSTONE, false);
    public static final BlockGemOre CITRINE_ORE = new BlockGemOre("citrine_ore", ModItems.CITRINE, true);
    public static final BlockEarthEnergyOre EARTH_ENERGY_ORE = new BlockEarthEnergyOre();
    public static final BlockFireEnergyOre FIRE_ENERGY_ORE = new BlockFireEnergyOre();
    public static final BlockGemOre FLUORITE_ORE = new BlockGemOre("fluorite_ore", ModItems.FLUORITE, false);
    public static final BlockGemOre GARNET_ORE = new BlockGemOre("garnet_ore", ModItems.GARNET, false);
    public static final BlockGoldOre GOLD_ORE = new BlockGoldOre();
    public static final BlockGemOre JADE_ORE = new BlockGemOre("jade_ore", ModItems.JADE, false);
    public static final BlockLeadOre LEAD_ORE = new BlockLeadOre();
    public static final BlockNickelOre NICKEL_ORE = new BlockNickelOre();
    public static final BlockGemOre ONYX_ORE = new BlockGemOre("onyx_ore", ModItems.ONYX, false);
    public static final BlockSilverOre SILVER_ORE = new BlockSilverOre();
    public static final BlockTinOre TIN_ORE = new BlockTinOre();
    public static final BlockWaterEnergyOre WATER_ENERGY_ORE = new BlockWaterEnergyOre();

    // Energy
    public static final BlockAether AETHER_BLOCK = new BlockAether();
    public static final BlockAirEnergy AIR_ENERGY_BLOCK = new BlockAirEnergy();
    public static final BlockEarthEnergy EARTH_ENERGY_BLOCK = new BlockEarthEnergy();
    public static final BlockFireEnergy FIRE_ENERGY_BLOCK = new BlockFireEnergy();
    public static final BlockWaterEnergy WATER_ENERGY_BLOCK = new BlockWaterEnergy();

    // Generic
    public static final BlockAirStone AIR_STONE = new BlockAirStone();
    public static final BlockAsh ASH_BLOCK = new BlockAsh();
    public static final BlockCharredStone CHARRED_STONE = new BlockCharredStone();
    public static final BlockEarthStone EARTH_STONE = new BlockEarthStone();
    public static final BlockFertileDirt FERTILE_DIRT = new BlockFertileDirt();
    public static final BlockFertileGrass FERTILE_GRASS = new BlockFertileGrass();
    public static final BlockFireStone FIRE_STONE = new BlockFireStone();
    public static final BlockRarefiedStone RAREFIED_STONE = new BlockRarefiedStone();
    public static final BlockSaltBlock SALT_BLOCK = new BlockSaltBlock();
    public static final BlockWaterStone WATER_STONE = new BlockWaterStone();



    // Metal
    public static final BlockLead LEAD_BLOCK = new BlockLead();
    public static final BlockNickel NICKEL_BLOCK = new BlockNickel();
    public static final BlockSilver SILVER_BLOCK = new BlockSilver();
    public static final BlockTin TIN_BLOCK = new BlockTin();

    // Plants
    public static final BlockBurntBush BURNT_BUSH = new BlockBurntBush();
    public static final BlockFireCactus FIRE_CACTUS = new BlockFireCactus();


    @SideOnly(Side.CLIENT)
    public static void initModels() {
        // Ores
        AETHER_ORE.initModel();
        AIR_ENERGY_ORE.initModel();
        AQUAMARINE_ORE.initModel();
        AZURITE_ORE.initModel();
        BERYL_ORE.initModel();
        BLOODSTONE_ORE.initModel();
        CITRINE_ORE.initModel();
        EARTH_ENERGY_ORE.initModel();
        FIRE_ENERGY_ORE.initModel();
        FLUORITE_ORE.initModel();
        GARNET_ORE.initModel();
        GOLD_ORE.initModel();
        JADE_ORE.initModel();
        LEAD_ORE.initModel();
        NICKEL_ORE.initModel();
        ONYX_ORE.initModel();
        SILVER_ORE.initModel();
        TIN_ORE.initModel();
        WATER_ENERGY_ORE.initModel();

        // Energy
        AETHER_BLOCK.initModel();
        AIR_ENERGY_BLOCK.initModel();
        EARTH_ENERGY_BLOCK.initModel();
        FIRE_ENERGY_BLOCK.initModel();
        WATER_ENERGY_BLOCK.initModel();

        // Generic
        AIR_STONE.initModel();
        ASH_BLOCK.initModel();
        FERTILE_DIRT.initModel();
        FERTILE_GRASS.initModel();
        RAREFIED_STONE.initModel();
        SALT_BLOCK.initModel();
        WATER_STONE.initModel();
        CHARRED_STONE.initModel();
        EARTH_STONE.initModel();
        FIRE_STONE.initModel();

        // Metal
        LEAD_BLOCK.initModel();
        NICKEL_BLOCK.initModel();
        SILVER_BLOCK.initModel();
        TIN_BLOCK.initModel();

        // Plants
        BURNT_BUSH.initModel();
        FIRE_CACTUS.initModel();

    }

    public static void register(IForgeRegistry<Block> registry) {
        ElementalCraft.logger.info("Registering Blocks");

        // Ores
        registry.register(AETHER_ORE);
        registry.register(AIR_ENERGY_ORE);
        registry.register(AQUAMARINE_ORE);
        registry.register(AZURITE_ORE);
        registry.register(BERYL_ORE);
        registry.register(BLOODSTONE_ORE);
        registry.register(CITRINE_ORE);
        registry.register(EARTH_ENERGY_ORE);
        registry.register(FIRE_ENERGY_ORE);
        registry.register(FLUORITE_ORE);
        registry.register(GARNET_ORE);
        registry.register(GOLD_ORE);
        registry.register(JADE_ORE);
        registry.register(LEAD_ORE);
        registry.register(NICKEL_ORE);
        registry.register(ONYX_ORE);
        registry.register(SILVER_ORE);
        registry.register(TIN_ORE);
        registry.register(WATER_ENERGY_ORE);

        // Energy
        registry.register(AETHER_BLOCK);
        registry.register(AIR_ENERGY_BLOCK);
        registry.register(EARTH_ENERGY_BLOCK);
        registry.register(FIRE_ENERGY_BLOCK);
        registry.register(WATER_ENERGY_BLOCK);

        // Generic
        registry.register(AIR_STONE);
        registry.register(ASH_BLOCK);
        registry.register(FERTILE_DIRT);
        registry.register(FERTILE_GRASS);
        registry.register(RAREFIED_STONE);
        registry.register(SALT_BLOCK);
        registry.register(FIRE_STONE);
        registry.register(WATER_STONE);
        registry.register(CHARRED_STONE);
        registry.register(EARTH_STONE);

        // Metal
        registry.register(LEAD_BLOCK);
        registry.register(NICKEL_BLOCK);
        registry.register(SILVER_BLOCK);
        registry.register(TIN_BLOCK);

        // Plants
        registry.register(BURNT_BUSH);
        registry.register(FIRE_CACTUS);

    }
}
