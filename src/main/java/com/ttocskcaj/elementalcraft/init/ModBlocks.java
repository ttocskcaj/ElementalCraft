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

    // Blocks of energy
    public static BlockEnergy energy;

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
        // Instantiate and preInit ores.
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

        // Instantiate and preInit metal blocks
        metal = new BlockMetal();
        metal.preInit();

        // Instantiate and preInit energy blocks
        energy = new BlockEnergy();
        energy.preInit();

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

        // Initialize energy blocks.
        energy.init();
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
        energy.initModels();

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
