package com.ttocskcaj.elementalcraft.proxy;

import com.ttocskcaj.elementalcraft.block.elementalblocks.*;
import com.ttocskcaj.elementalcraft.block.elementalore.BlockElementalOre;
import com.ttocskcaj.elementalcraft.init.ModAssets;

public class CommonProxy {

    public void preInit() {
        ModAssets.addBlock(new BlockElementalOre());
        ModAssets.addBlock(new BlockElementalBlock());
        ModAssets.addBlock(new BlockElementalAirBlock());
        ModAssets.addBlock(new BlockElementalEarthBlock());
        ModAssets.addBlock(new BlockElementalFireBlock());
        ModAssets.addBlock(new BlockElementalWaterBlock());
    }

    public void init() {

    }
}
