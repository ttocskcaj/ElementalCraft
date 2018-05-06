package com.ttocskcaj.elementalcraft.block.generic;

import com.ttocskcaj.elementalcraft.block.BlockSingleBase;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;


public class BlockSalt extends BlockSingleBase {

    public BlockSalt(){
        super("block_salt", Material.GROUND);
        setHarvestLevel("shovel", 0);
        setSoundType(SoundType.SAND);
    }
}
