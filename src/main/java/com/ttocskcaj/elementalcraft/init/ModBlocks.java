package com.ttocskcaj.elementalcraft.init;

import com.ttocskcaj.elementalcraft.block.elementalblocks.*;
import com.ttocskcaj.elementalcraft.block.elementalore.BlockElementalOre;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {
    public static final BlockElementalOre BLOCK_ELEMENTAL_ORE = new BlockElementalOre();
    public static final BlockElementalBlock BLOCK_ELEMENTAL_BLOCK = new BlockElementalBlock();
    public static final BlockElementalAirBlock BLOCK_ELEMENTAL_AIR_BLOCK = new BlockElementalAirBlock();
    public static final BlockElementalEarthBlock BLOCK_ELEMENTAL_EARTH_BLOCK = new BlockElementalEarthBlock();
    public static final BlockElementalFireBlock BLOCK_ELEMENTAL_FIRE_BLOCK = new BlockElementalFireBlock();
    public static final BlockElementalWaterBlock BLOCK_ELEMENTAL_WATER_BLOCK = new BlockElementalWaterBlock();

    @SideOnly(Side.CLIENT)
    public static void initModels(){
        BLOCK_ELEMENTAL_ORE.initModel();
        BLOCK_ELEMENTAL_WATER_BLOCK.initModel();
        BLOCK_ELEMENTAL_FIRE_BLOCK.initModel();
        BLOCK_ELEMENTAL_EARTH_BLOCK.initModel();
        BLOCK_ELEMENTAL_AIR_BLOCK.initModel();
        BLOCK_ELEMENTAL_BLOCK.initModel();
    }

}
