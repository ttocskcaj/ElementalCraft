package com.ttocskcaj.elementalcraft.biome;


import com.ttocskcaj.elementalcraft.init.ModBlocks;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;

import java.util.Random;

public class BiomeEarth extends Biome {


    public BiomeEarth() {
        super(new BiomeProperties("Elemental Earth").setTemperature(2f).setRainDisabled().setBaseHeight(5.0F).setTemperature(0.3f).setHeightVariation(0.3f));
        setRegistryName("earth_biome");

        this.topBlock = ModBlocks.FERTILE_GRASS.getDefaultState();
        this.fillerBlock = ModBlocks.FERTILE_DIRT.getDefaultState();

    }

    @Override
    public BiomeDecorator createBiomeDecorator() {
        BiomeDecoratorEarth biomeDecorator = new BiomeDecoratorEarth();
        return biomeDecorator;
    }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
        int i = 0;
        IBlockState iblockstate = this.topBlock;
        IBlockState iblockstate1 = this.fillerBlock;
        int j = -1;
        int k = (int) (noiseVal / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
        int l = x & 15;
        int i1 = z & 15;

        for (int j1 = 255; j1 >= 0; --j1) {
            if (j1 <= rand.nextInt(5)) {
                chunkPrimerIn.setBlockState(i1, j1, l, BEDROCK);
            } else {
                IBlockState iblockstate2 = chunkPrimerIn.getBlockState(i1, j1, l);

                if (iblockstate2.getMaterial() == Material.AIR) {
                    j = -1;
                } else if (iblockstate2.getBlock() == ModBlocks.EARTH_STONE) {
                    if (j == -1) {
                        if (k <= 0) {
                            iblockstate = AIR;
                            iblockstate1 = ModBlocks.EARTH_STONE.getDefaultState();
                        } else if (j1 <= i + 1) {
                            iblockstate = this.topBlock;
                            iblockstate1 = this.fillerBlock;
                        }

                        j = k;

                        chunkPrimerIn.setBlockState(i1, j1, l, iblockstate);
                    } else if (j > 0) {
                        --j;
                        chunkPrimerIn.setBlockState(i1, j1, l, iblockstate1);

                        if (j == 0 && iblockstate1.getBlock() == Blocks.SAND && k > 1) {
                            j = rand.nextInt(4) + Math.max(0, j1 - 63);
                            iblockstate1 = iblockstate1.getValue(BlockSand.VARIANT) == BlockSand.EnumType.RED_SAND ? RED_SANDSTONE : SANDSTONE;
                        }
                    }
                }
            }
        }
    }
}