package com.ttocskcaj.elementalcraft.biome;


import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;

import java.util.Random;

public class BiomeFire extends BiomeElemental {

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int chunkX, int chunkZ, double noiseVal) {
        int seaLevel = worldIn.getSeaLevel();
        boolean lastBlockWasAir = true;
        int noise = (int) (noiseVal / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
        int worldX = chunkX & 15;
        int worldZ = chunkZ & 15;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();


        for (int yLevel = 255; yLevel >= 0; --yLevel) {
            // If level is below 5, randomly start placing bedrock.
            if (yLevel <= rand.nextInt(5)) {
                chunkPrimerIn.setBlockState(worldZ, yLevel, worldX, BEDROCK);
            } else {
                IBlockState originalBlockState = chunkPrimerIn.getBlockState(worldZ, yLevel, worldX);

                if (originalBlockState.getMaterial() == Material.AIR) {
                    lastBlockWasAir = true;
                }

                // Replace only stone.
                else if (originalBlockState.getBlock() == Blocks.STONE) {
                    // Set top layer
                    if (lastBlockWasAir) {
                        chunkPrimerIn.setBlockState(worldZ, yLevel, worldX, this.topBlock);
                    }

                    // Set all other layers.
                    else {
                        chunkPrimerIn.setBlockState(worldZ, yLevel, worldX, this.fillerBlock);
                    }

                    lastBlockWasAir = false;

                }
            }
//            System.out.println("Set block at y level " + yLevel + ": " + chunkPrimerIn.getBlockState(shiftedZ, yLevel, shiftedX));
        }
    }

    public BiomeFire() {
        super(new Biome.BiomeProperties("Elemental Fire").setTemperature(2f).setRainDisabled().setBaseHeight(1.0F)
                .setHeightVariation(0.2F));
        setRegistryName("fire_biome");

        this.topBlock = Blocks.NETHERRACK.getDefaultState();
        this.fillerBlock = Blocks.NETHER_BRICK.getDefaultState();
    }


}