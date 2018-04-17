package com.ttocskcaj.elementalcraft.init;

import com.ttocskcaj.elementalcraft.block.energy.*;
import com.ttocskcaj.elementalcraft.block.generic.FireStone;
import com.ttocskcaj.elementalcraft.block.generic.RarefiedStone;
import com.ttocskcaj.elementalcraft.block.ore.*;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {
    // Ores
    public static final AetherOre AETHER_ORE = new AetherOre();
    public static final GarnetOre GARNET_ORE = new GarnetOre();
    public static final CitrineOre CITRINE_ORE = new CitrineOre();
    public static final FluoriteOre FLUORITE_ORE = new FluoriteOre();
    public static final BerylOre BERYL_ORE = new BerylOre();

    // Energy
    public static final AetherBlock AETHER_BLOCK = new AetherBlock();
    public static final SolidifiedEnergyAir SOLIDIFIED_ENERGY_AIR = new SolidifiedEnergyAir();
    public static final SolidifiedEnergyEarth SOLIDIFIED_ENERGY_EARTH = new SolidifiedEnergyEarth();
    public static final SolidifiedEnergyFire SOLIDIFIED_ENERGY_FIRE = new SolidifiedEnergyFire();
    public static final SolidifiedEnergyWater SOLIDIFIED_ENERGY_WATER = new SolidifiedEnergyWater();

    // Generic
    public static final RarefiedStone RAREFIED_STONE = new RarefiedStone();
    public static final FireStone FIRE_STONE = new FireStone();


    @SideOnly(Side.CLIENT)
    public static void initModels() {
        // Ores
        AETHER_ORE.initModel();
        GARNET_ORE.initModel();
        CITRINE_ORE.initModel();
        FLUORITE_ORE.initModel();
        BERYL_ORE.initModel();

        // Energy
        SOLIDIFIED_ENERGY_WATER.initModel();
        SOLIDIFIED_ENERGY_FIRE.initModel();
        SOLIDIFIED_ENERGY_EARTH.initModel();
        SOLIDIFIED_ENERGY_AIR.initModel();
        AETHER_BLOCK.initModel();

        // Generic
        RAREFIED_STONE.initModel();
        FIRE_STONE.initModel();
    }

}
