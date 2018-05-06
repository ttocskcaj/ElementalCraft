package com.ttocskcaj.elementalcraft.world.generation;

import com.ttocskcaj.elementalcraft.init.ModBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenFireCactus extends WorldGenerator {
    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        {
            for (int i = 0; i < 10; ++i) {
                BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

                if (worldIn.isAirBlock(blockpos)) {
                    // Pick a random height between 1 and 5.
                    int height = 1 + rand.nextInt(4);

                    // Starting at the bottom, build the cactus one block at a time.
                    for (int iHeight = 0; iHeight < height; ++iHeight) {
                        if (ModBlocks.fireCactus.canBlockStay(worldIn, blockpos)) {
                            worldIn.setBlockState(blockpos.up(iHeight), ModBlocks.fireCactus.getDefaultState(), 2);
                        }
                    }
                }
            }

            return true;
        }
    }
}
