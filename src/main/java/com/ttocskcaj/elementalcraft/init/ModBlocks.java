package com.ttocskcaj.elementalcraft.init;

import com.ttocskcaj.elementalcraft.block.energy.*;
import com.ttocskcaj.elementalcraft.block.generic.*;
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

    // Stone
    public static BlockStone stone;
    public static BlockStoneAir stoneAir;

    // Generic
    public static BlockAsh ash;
    public static BlockFertileDirt fertileDirt;
    public static BlockFertileGrass fertileGrass;
    public static BlockSalt salt;

    // Plants
    public static BlockBurntBush burntBush;
    public static BlockFireCactus fireCactus;

    // Machines
//    public static final BlockMachineBase RAREFACTION_APPARATUS = (BlockMachineBase) new BlockMachineBase().setRegistryName("rarefaction_apparatus").setUnlocalizedName("rarefaction_apparatus");

    public static void preInit() {
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

        // Instantiate and preInit stone
        stone = new BlockStone();
        stone.preInit();
        stoneAir = new BlockStoneAir();
        stoneAir.preInit();

        // Instantiate and preInit other generic blocks
        ash = new BlockAsh();
        ash.preInit();
        fertileDirt = new BlockFertileDirt();
        fertileDirt.preInit();
        fertileGrass = new BlockFertileGrass();
        fertileGrass.preInit();
        salt = new BlockSalt();
        salt.preInit();

        // Instantiate and preInit plants
        fireCactus = new BlockFireCactus();
        fireCactus.preInit();
        burntBush = new BlockBurntBush();
        burntBush.preInit();

    }

    public static void init() {
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

        // Initialize stone.
        stone.init();
        stoneAir.init();

        // Initialize other generic blocks.
        ash.init();
        fertileGrass.init();
        fertileDirt.init();
        salt.init();

        // Initialize other generic blocks.
        fireCactus.init();
        burntBush.init();

    }

    @SideOnly(Side.CLIENT)
    public static void registerModels() {
        // Ore
        airOre.registerModels();
        earthOre.registerModels();
        fireOre.registerModels();
        waterOre.registerModels();
        overworldOre.registerModels();

        // Metal Blocks
        metal.registerModels();

        // Energy
        energy.registerModels();

        // Stone
        stone.registerModels();
        stoneAir.registerModels();

        // Generic
        ash.registerModels();
        fertileDirt.registerModels();
        fertileGrass.registerModels();
        salt.registerModels();

        // Plants
        burntBush.registerModels();
        fireCactus.registerModels();

        // Machine
//        RAREFACTION_APPARATUS.initModel();
    }
}
