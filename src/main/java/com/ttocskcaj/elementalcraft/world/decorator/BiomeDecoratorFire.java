package com.ttocskcaj.elementalcraft.world.decorator;

import com.ttocskcaj.elementalcraft.init.ModBlocks;
import com.ttocskcaj.elementalcraft.world.generation.*;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;


import java.util.Random;

public class BiomeDecoratorFire extends BiomeDecoratorBase{
    public WorldGenBigFire fireGen = new WorldGenBigFire(8);
    public int firePatchChance = 20;        // Percentage
    public int singleFirePerChunk = 3;      // Quantity
    public int deadBushPerChunk = 12;       // Quantity
    public int fireCactusPerChunk = 100;    // Quantity

    @Override
    public void decorate(World worldIn, Random random, Biome biome, BlockPos pos) {
        if (this.decorating) {
            throw new RuntimeException("Already decorating");
        } else {
            this.chunkPos = pos;
            // First pass, light scattered ores.
            generateOre(ModBlocks.GARNET_ORE.getDefaultState(), worldIn, random, 3, 250, 9, 6);
            generateOre(ModBlocks.BLOODSTONE_ORE.getDefaultState(), worldIn, random, 3, 250, 9, 6);
            generateOre(ModBlocks.FIRE_ENERGY_ORE.getDefaultState(), worldIn, random, 3, 250, 8, 6);
            generateOre(ModBlocks.NICKEL_ORE.getDefaultState(), worldIn, random, 3, 250, 8, 6);
            generateOre(ModBlocks.GOLD_ORE.getDefaultState(), worldIn, random, 3, 250, 9, 6);

            // Second pass, heavy middle band.
            generateOre(ModBlocks.GARNET_ORE.getDefaultState(), worldIn, random, 80, 100, 5, 8);
            generateOre(ModBlocks.BLOODSTONE_ORE.getDefaultState(), worldIn, random, 90, 120, 5, 8);
            generateOre(ModBlocks.FIRE_ENERGY_ORE.getDefaultState(), worldIn, random, 100, 140, 5, 8);
            generateOre(ModBlocks.NICKEL_ORE.getDefaultState(), worldIn, random, 120, 160, 5, 8);
            generateOre(ModBlocks.GOLD_ORE.getDefaultState(), worldIn, random, 130, 180, 5, 8);

            // Random chance of fire patch
            if (random.nextInt(100) < firePatchChance) {
                // Random offsets.
                int xCenter = random.nextInt(16) + 8;
                int zCenter = random.nextInt(16) + 8;

                // Generate fire patch
                this.fireGen.generate(worldIn, random, worldIn.getTopSolidOrLiquidBlock(this.chunkPos.add(xCenter, 0, zCenter)));
            }

            for (int i = 0; i < this.deadBushPerChunk; ++i) {
                // Random offsets.
                int xCenter = random.nextInt(16) + 8;
                int zCenter = random.nextInt(16) + 8;
                int yCenter = worldIn.getHeight(this.chunkPos.add(xCenter, 0, zCenter)).getY() * 2;

                if (yCenter > 0) {
                    int yLevel = random.nextInt(yCenter);
                    (new WorldGenBurntBush()).generate(worldIn, random, this.chunkPos.add(xCenter, yLevel, zCenter));
                }
            }

            for (int i = 0; i < this.fireCactusPerChunk; i++) {
                // Random offsets.
                int xCenter = random.nextInt(16) + 8;
                int zCenter = random.nextInt(16) + 8;
                int yCenter = worldIn.getHeight(this.chunkPos.add(xCenter, 0, zCenter)).getY() * 2;

                if (yCenter > 0) {
                    int yLevel = random.nextInt(yCenter);
                    (new WorldGenFireCactus()).generate(worldIn, random, this.chunkPos.add(xCenter, yLevel, zCenter));
                }
            }

            for (int i = 0; i < this.singleFirePerChunk; i++) {
                // Random offsets.
                int xCenter = random.nextInt(16) + 8;
                int zCenter = random.nextInt(16) + 8;

                (new WorldGenSingleFire()).generate(worldIn, random, worldIn.getTopSolidOrLiquidBlock(this.chunkPos.add(xCenter, 1, zCenter)));
            }

            this.decorating = false;
        }
    }
}
