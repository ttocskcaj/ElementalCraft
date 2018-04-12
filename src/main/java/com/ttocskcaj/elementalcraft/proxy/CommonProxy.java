package com.ttocskcaj.elementalcraft.proxy;

import com.ttocskcaj.elementalcraft.block.elementalblock.BlockElementalBlock;
import com.ttocskcaj.elementalcraft.block.elementalore.BlockElementalOre;
import com.ttocskcaj.elementalcraft.init.ModAssets;

public class CommonProxy {

    public void preInit() {
        ModAssets.addBlock(new BlockElementalOre());
        ModAssets.addBlock(new BlockElementalBlock());
    }

    public void init() {

    }
}
