package com.ttocskcaj.elementalcraft.biome;


import com.ttocskcaj.elementalcraft.init.ModBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;

import java.util.Random;

public class BiomeAir extends Biome {

    public BiomeAir() {
        super(new BiomeProperties("Elemental Air").setTemperature(2f).setRainDisabled().setBaseHeight(1.0F)
                .setHeightVariation(1F));
        setRegistryName("air_biome");

        this.topBlock = ModBlocks.AIR_STONE.getDefaultState();
        this.fillerBlock = ModBlocks.AIR_STONE.getDefaultState();

        // Remove all mobs.
        spawnableMonsterList.clear();
        spawnableWaterCreatureList.clear();
        spawnableCreatureList.clear();

    }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int chunkX, int chunkZ, double noiseVal) {
        boolean lastBlockWasAir = true;
        int worldX = chunkX & 15;
        int worldZ = chunkZ & 15;


        for (int yLevel = 255; yLevel >= 0; --yLevel) {

            IBlockState originalBlockState = chunkPrimerIn.getBlockState(worldZ, yLevel, worldX);

            if (originalBlockState.getMaterial() == Material.AIR) {
                lastBlockWasAir = true;
            }

            // Replace only airstone.
            else if (originalBlockState.getBlock() == ModBlocks.AIR_STONE) {
                // Set top layer
                if (lastBlockWasAir) {
                    chunkPrimerIn.setBlockState(worldZ, yLevel, worldX, this.topBlock);

                }

                lastBlockWasAir = false;

                // Strip any water and replace with firestone.
            } else if (originalBlockState.getBlock() == Blocks.WATER) {
                chunkPrimerIn.setBlockState(worldZ, yLevel, worldX, this.fillerBlock);
            }
        }

    }

    @Override
    public BiomeDecorator createBiomeDecorator() {
        BiomeDecoratorFire biomeDecorator = new BiomeDecoratorFire();

        biomeDecorator.waterlilyPerChunk = 0;
        biomeDecorator.treesPerChunk = 0;
        biomeDecorator.extraTreeChance = 0F;
        biomeDecorator.flowersPerChunk = 0;
        biomeDecorator.grassPerChunk = 0;
        biomeDecorator.deadBushPerChunk = 0;
        biomeDecorator.mushroomsPerChunk = 0;
        biomeDecorator.reedsPerChunk = 0;

        biomeDecorator.cactiPerChunk = 0;
        biomeDecorator.gravelPatchesPerChunk = 0;
        biomeDecorator.sandPatchesPerChunk = 0;
        biomeDecorator.clayPerChunk = 0;
        biomeDecorator.bigMushroomsPerChunk = 0;
        biomeDecorator.generateFalls = false;
        return getModdedBiomeDecorator(biomeDecorator);
    }

}