package com.ttocskcaj.elementalcraft.biome;

import com.ttocskcaj.elementalcraft.world.generation.WorldGenBurntBush;
import com.ttocskcaj.elementalcraft.world.generation.WorldGenBigFire;
import com.ttocskcaj.elementalcraft.world.generation.WorldGenFireCactus;
import com.ttocskcaj.elementalcraft.world.generation.WorldGenSingleFire;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;


import java.util.Random;

public class BiomeDecoratorFire extends BiomeDecorator {
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
