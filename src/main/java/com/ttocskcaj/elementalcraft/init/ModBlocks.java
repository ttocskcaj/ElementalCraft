package com.ttocskcaj.elementalcraft.init;

import com.ttocskcaj.elementalcraft.ElementalCraft;
import com.ttocskcaj.elementalcraft.block.energy.*;
import com.ttocskcaj.elementalcraft.block.generic.*;
import com.ttocskcaj.elementalcraft.block.machine.BlockMachineBase;
import com.ttocskcaj.elementalcraft.block.metal.BlockMetal;
import com.ttocskcaj.elementalcraft.block.ore.*;
import com.ttocskcaj.elementalcraft.block.plant.BlockBurntBush;
import com.ttocskcaj.elementalcraft.block.plant.BlockFireCactus;
import net.minecraft.block.Block;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {
    // Ores
    public static BlockEarthOre earthOre;
    public static BlockAirOre airOre;
    public static BlockFireOre fireOre;
    public static BlockWaterOre waterOre;
    public static BlockOverworldOre overworldOre;

    // Blocks of metal
    public static BlockMetal metal;

    // Energy Blocks
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

    // Plants
    public static final BlockBurntBush BURNT_BUSH = new BlockBurntBush();
    public static final BlockFireCactus FIRE_CACTUS = new BlockFireCactus();

    // Machines
    public static final BlockMachineBase RAREFACTION_APPARATUS = (BlockMachineBase) new BlockMachineBase().setRegistryName("rarefaction_apparatus").setUnlocalizedName("rarefaction_apparatus");

    public static void preInit(){
        // Instantiate and preinit ores.
        airOre = new BlockAirOre();
        airOre.preInit();
        earthOre = new BlockEarthOre();
        earthOre.preInit();
        fireOre = new BlockFireOre();
        fireOre.preInit();
        waterOre = new BlockWaterOre();
        waterOre.preInit();
        overworldOre = new BlockOverworldOre();
        overworldOre.preInit();

        // Instantiate and preinit metal blocks
        metal = new BlockMetal();
        metal.preInit();
    }

    public static void init(){
        // Initialize ores.
        airOre.init();
        earthOre.init();
        fireOre.init();
        waterOre.init();
        overworldOre.init();

        // Initialize metal blocks.
        metal.init();
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        // Ore
        airOre.initModels();
        earthOre.initModels();
        fireOre.initModels();
        waterOre.initModels();
        overworldOre.initModels();

        // Metal Blocks
        metal.initModels();

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

        // Plants
        BURNT_BUSH.initModel();
        FIRE_CACTUS.initModel();

        // Machines
        RAREFACTION_APPARATUS.initModel();
    }

    public static void register(IForgeRegistry<Block> registry) {
        ElementalCraft.logger.info("Registering Blocks");

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

        // Plants
        registry.register(BURNT_BUSH);
        registry.register(FIRE_CACTUS);

        // Machines
        registry.register(RAREFACTION_APPARATUS);

    }
}
