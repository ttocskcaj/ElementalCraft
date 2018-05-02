package com.ttocskcaj.elementalcraft.world.biome;


import com.ttocskcaj.elementalcraft.init.ModBlocks;
import com.ttocskcaj.elementalcraft.world.decorator.BiomeDecoratorFire;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;

import java.util.Random;

public class BiomeFire extends Biome {

    public BiomeFire() {
        super(new Biome.BiomeProperties("Elemental Fire").setTemperature(2f).setRainDisabled().setBaseHeight(1.0F)
                .setHeightVariation(6F));
        setRegistryName("fire_biome");

        this.topBlock = ModBlocks.CHARRED_STONE.getDefaultState();
        this.fillerBlock = ModBlocks.FIRE_STONE.getDefaultState();

        // Remove all mobs.
        spawnableMonsterList.clear();
        spawnableWaterCreatureList.clear();
        spawnableCreatureList.clear();

        spawnableMonsterList.add(new Biome.SpawnListEntry(EntityBlaze.class, 128, 4, 128));
        spawnableMonsterList.add(new Biome.SpawnListEntry(EntityMagmaCube.class, 128, 4, 128));


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


        int ashCounter = rand.nextInt(1) + 1;
        for (int yLevel = 255; yLevel >= 0; --yLevel) {
            if (yLevel == 0) {
                chunkPrimerIn.setBlockState(worldZ, yLevel, worldX, BEDROCK);
            } else {
                IBlockState originalBlockState = chunkPrimerIn.getBlockState(worldZ, yLevel, worldX);

                if (originalBlockState.getMaterial() == Material.AIR) {
                    lastBlockWasAir = true;
                }

                // Replace only firestone.
                else if (originalBlockState == fillerBlock) {
                    // Set top layer
                    if (lastBlockWasAir) {
                        chunkPrimerIn.setBlockState(worldZ, yLevel, worldX, this.topBlock);

                    }
                    // Random depth of charred stone.
                    else if (ashCounter >= 0) {
                        chunkPrimerIn.setBlockState(worldZ, yLevel, worldX, this.topBlock);
                        ashCounter--;
                    }

                    lastBlockWasAir = false;


                }
            }
        }
    }

    @Override
    public BiomeDecorator createBiomeDecorator() {
        BiomeDecoratorFire biomeDecorator = new BiomeDecoratorFire();

        biomeDecorator.firePatchChance = 2;

        return biomeDecorator;
    }

}