package com.ttocskcaj.elementalcraft.world.biome;


import com.ttocskcaj.elementalcraft.init.ModBlocks;
import com.ttocskcaj.elementalcraft.world.decorator.BiomeDecoratorWater;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;

import java.util.Random;

public class BiomeWater extends Biome {

    public BiomeWater() {
        super(new BiomeProperties("Elemental Water").setTemperature(0.4f).setBaseHeight(-1.8F)
                .setHeightVariation(0.3F));
        setRegistryName("water_biome");

        this.topBlock = ModBlocks.WATER_STONE.getDefaultState();
        this.fillerBlock = ModBlocks.WATER_STONE.getDefaultState();

        // Remove all mobs.
        spawnableMonsterList.clear();
        spawnableWaterCreatureList.clear();
        spawnableCreatureList.clear();

    }

    @Override
    public int getSkyColorByTemp(float currentTemperature) {
        return 11751505;
    }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int chunkX, int chunkZ, double noiseVal) {
        int worldX = chunkX & 15;
        int worldZ = chunkZ & 15;
        for (int yLevel = 255; yLevel >= 0; --yLevel) {
            // If level is below 5, randomly start placing bedrock.
            if (yLevel == 0) {
                chunkPrimerIn.setBlockState(worldZ, yLevel, worldX, BEDROCK);
            } else if (yLevel == 1) {
                chunkPrimerIn.setBlockState(worldZ, yLevel, worldX, fillerBlock);
            }
        }
    }

    @Override
    public BiomeDecorator createBiomeDecorator() {
        return new BiomeDecoratorWater();
    }

}