package com.ttocskcaj.elementalcraft.world.generation;

import com.ttocskcaj.elementalcraft.init.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenBurntBush extends WorldGenerator {

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        for (IBlockState iblockstate = worldIn.getBlockState(position); (iblockstate.getBlock().isAir(iblockstate, worldIn, position) || iblockstate.getBlock().isLeaves(iblockstate, worldIn, position)) && position.getY() > 0; iblockstate = worldIn.getBlockState(position))
        {
            position = position.down();
        }

        for (int i = 0; i < 4; ++i)
        {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.isAirBlock(blockpos) && ModBlocks.burntBush.canBlockStay(worldIn, blockpos, ModBlocks.burntBush.getDefaultState()))
            {
                worldIn.setBlockState(blockpos, ModBlocks.burntBush.getDefaultState(), 2);
            }
        }

        return true;
    }
}
