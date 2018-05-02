package com.ttocskcaj.elementalcraft.world.generation;

import com.ttocskcaj.elementalcraft.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenBigFire extends WorldGenerator {
    /**
     * The maximum radius used when generating a patch of blocks.
     */
    private final int maxRadius;

    public WorldGenBigFire(int maxRadius) {
        this.maxRadius = maxRadius;
    }

    public boolean generate(World worldIn, Random rand, BlockPos position) {

        // Random radius between 2 and maxRadius
        int radius = rand.nextInt(this.maxRadius - 2) + 2;

        for (int iX = position.getX() - radius; iX <= position.getX() + radius; ++iX) {
            for (int iZ = position.getZ() - radius; iZ <= position.getZ() + radius; ++iZ) {
                int width = iX - position.getX();
                int depth = iZ - position.getZ();

                if (width * width + depth * depth <= radius * radius) {

                    // Start 2 blocks below and work up 5 blocks, setting each top block to fire, and the one under to ash.
                    for (int iY = position.getY() - 2; iY <= position.getY() +2; ++iY) {
                        BlockPos blockposThis = new BlockPos(iX, iY, iZ);
                        BlockPos blockposNext = blockposThis.up();
                        Block block = worldIn.getBlockState(blockposThis).getBlock();
                        Block nextBlock = worldIn.getBlockState(blockposThis.up()).getBlock();

                        if (nextBlock == Blocks.AIR && block != Blocks.AIR) {
                            worldIn.setBlockState(blockposThis, ModBlocks.ASH_BLOCK.getDefaultState());
                            worldIn.setBlockState(blockposNext, Blocks.FIRE.getDefaultState());
                            break;
                        }
                    }
                }
            }
        }

        return true;

    }
}
