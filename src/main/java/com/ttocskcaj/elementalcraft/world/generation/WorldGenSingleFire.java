package com.ttocskcaj.elementalcraft.world.generation;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenSingleFire extends WorldGenerator {

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        // Repeat 4 times.
        for (int i = 0; i < 4; ++i) {
            // Pick a random location.
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), 0, rand.nextInt(8) - rand.nextInt(8));

            // Check it's air we're replacing.
            IBlockState blockState = worldIn.getBlockState(blockpos);
            if (blockState.getBlock() == Blocks.AIR) {
                worldIn.setBlockState(blockpos, Blocks.FIRE.getDefaultState(), 2);
            }
        }

        return true;
    }
}
