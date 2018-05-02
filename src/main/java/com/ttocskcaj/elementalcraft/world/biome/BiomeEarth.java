package com.ttocskcaj.elementalcraft.world.biome;


import com.ttocskcaj.elementalcraft.init.ModBlocks;
import com.ttocskcaj.elementalcraft.world.decorator.BiomeDecoratorEarth;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.*;

import java.util.Random;

public class BiomeEarth extends Biome {
    private WorldGenTrees worldGenOak = new WorldGenTrees(false);
    private WorldGenBirchTree worldGenBirch = new WorldGenBirchTree(false, true);
    private WorldGenSavannaTree worldGenAcacia = new WorldGenSavannaTree(false);
    private IBlockState jungleTrunk = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE);
    private IBlockState jungleLeaves = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE).withProperty(BlockLeaves.CHECK_DECAY, false);
    private WorldGenMegaJungle worldGenJungle = new WorldGenMegaJungle(false, 10, 20, jungleTrunk, jungleLeaves);


    public BiomeEarth() {
        super(new BiomeProperties("Elemental Earth").setTemperature(0.7f).setRainDisabled().setBaseHeight(5.0F).setHeightVariation(0.3f));
        setRegistryName("earth_biome");

        this.topBlock = ModBlocks.FERTILE_GRASS.getDefaultState();
        this.fillerBlock = ModBlocks.FERTILE_DIRT.getDefaultState();

        // Remove all mobs.
        spawnableMonsterList.clear();
        spawnableWaterCreatureList.clear();
        spawnableCreatureList.clear();
    }

    @Override
    public BiomeDecorator createBiomeDecorator() {
        BiomeDecoratorEarth biomeDecorator = new BiomeDecoratorEarth();
        return biomeDecorator;
    }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
        int i = 0;
        IBlockState iblockstate = topBlock;
        IBlockState iblockstate1 = fillerBlock;
        IBlockState stone = ModBlocks.EARTH_STONE.getDefaultState();
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
                } else if (iblockstate2 == stone) {
                    if (j == -1) {
                        if (k <= 0) {
                            iblockstate = AIR;
                            iblockstate1 = stone;
                        } else if (j1 <= i + 1) {
                            iblockstate = topBlock;
                            iblockstate1 = fillerBlock;
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

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        switch (rand.nextInt(4)) {
            case 0:
                return worldGenOak;
            case 1:
                return worldGenBirch;
            case 2:
                return worldGenAcacia;
            case 3:
                return worldGenJungle;

        }
        return worldGenOak;
    }

    @Override
    public WorldGenerator getRandomWorldGenForGrass(Random rand) {
        return rand.nextInt(2) == 0 ? new WorldGenTallGrass(BlockTallGrass.EnumType.FERN) : new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
    }
}