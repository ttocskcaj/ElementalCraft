package com.ttocskcaj.elementalcraft.block.generic;

import com.ttocskcaj.elementalcraft.block.BlockSingleBase;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockStoneAir extends BlockSingleBase {

    public BlockStoneAir(){
        super("stone_air", Material.ROCK);
        setHardness(1f);
        setResistance(1f);
        setHarvestLevel("pickaxe", 0);
        setSoundType(SoundType.CLOTH);
    }

}
