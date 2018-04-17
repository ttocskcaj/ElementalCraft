package com.ttocskcaj.elementalcraft.biome;


import com.ttocskcaj.elementalcraft.init.ModBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenFire;

import java.util.Random;

public class BiomeFire extends BiomeElemental {

    private final WorldGenFire fireFeature = new WorldGenFire();

    public BiomeFire() {
        super(new Biome.BiomeProperties("Elemental Fire").setTemperature(2f).setRainDisabled().setBaseHeight(1.0F)
                .setHeightVariation(6F));
        setRegistryName("fire_biome");

        this.topBlock = ModBlocks.RAREFIED_STONE.getDefaultState();
        this.fillerBlock = ModBlocks.FIRE_STONE.getDefaultState();
    }

    @Override
    public int getSkyColorByTemp(float currentTemperature) {
        return 11751505;
    }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int chunkX, int chunkZ, double noiseVal) {
        boolean lastBlockWasAir = true;
        int worldX = chunkX & 15;
        int worldZ = chunkZ & 15;


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

//                        // Random lava.
//                        if (rand.nextInt(1000) < 1) {
//                            chunkPrimerIn.setBlockState(worldZ, yLevel + 1, worldX, Blocks.FLOWING_LAVA.getDefaultState());
//                        }
                        // Random Fire
                        if (rand.nextInt(20) < 2) {
                            chunkPrimerIn.setBlockState(worldZ, yLevel + 1, worldX, Blocks.FIRE.getDefaultState());
                        }
                    }

                    // Set all other layers.
                    else {
                        chunkPrimerIn.setBlockState(worldZ, yLevel, worldX, this.fillerBlock);
                    }

                    lastBlockWasAir = false;

                } else if (originalBlockState.getBlock() == Blocks.WATER) {
                    chunkPrimerIn.setBlockState(worldZ, yLevel, worldX, this.topBlock);
                }
            }
        }
    }


}