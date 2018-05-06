package com.ttocskcaj.elementalcraft.block.generic;

import com.ttocskcaj.elementalcraft.block.BlockSingleBase;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockFertileDirt extends BlockSingleBase {
    public BlockFertileDirt(){
        super("fertile_dirt", Material.GROUND);
        setHardness(0.5f);
        setHarvestLevel("shovel", 0);
        setSoundType(SoundType.GROUND);
    }
}
