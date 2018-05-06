package com.ttocskcaj.elementalcraft.block.generic;

import com.ttocskcaj.elementalcraft.block.BlockSingleBase;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockAsh extends BlockSingleBase {

    public BlockAsh(){
        super("block_ash", Material.SAND);
        setHardness(1f);
        setResistance(3f);
        setHarvestLevel("pickaxe", 0);
        setSoundType(SoundType.SAND);
    }

    @Override
    public boolean isFireSource(World world, BlockPos pos, EnumFacing side) {
        return true;
    }

}
