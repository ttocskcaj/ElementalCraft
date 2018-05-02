package com.ttocskcaj.elementalcraft.world.decorator;

import com.ttocskcaj.elementalcraft.init.ModBlocks;
import com.ttocskcaj.elementalcraft.world.generation.WorldGenPatches;
import com.ttocskcaj.elementalcraft.world.generation.WorldGenerationOre;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class BiomeDecoratorWater extends BiomeDecoratorBase {
    /**
     * The salt generator.
     */
    public WorldGenerator patchGen = new WorldGenPatches(ModBlocks.SALT_BLOCK, 7);

    @Override
    public void decorate(World worldIn, Random random, Biome biome, BlockPos pos) {
        if (this.decorating) {
            throw new RuntimeException("Already decorating");
        } else {
            System.out.println("Generating");

            this.chunkPos = pos;

            generateOre(Blocks.GLOWSTONE.getDefaultState(), worldIn, random, 1, 36, 3, 50);
            generateOre(ModBlocks.BERYL_ORE.getDefaultState(), worldIn, random, 1, 50, 5, 4);
            generateOre(ModBlocks.SILVER_ORE.getDefaultState(), worldIn, random, 1, 50, 5, 4);
            generateOre(ModBlocks.AQUAMARINE_ORE.getDefaultState(), worldIn, random, 1, 50, 5, 4);
            generateOre(ModBlocks.WATER_ENERGY_ORE.getDefaultState(), worldIn, random, 1, 30, 5, 2);

            if (random.nextInt(2) == 1) {
                int j = random.nextInt(16) + 8;
                int k = random.nextInt(16) + 8;
                this.patchGen.generate(worldIn, random, worldIn.getTopSolidOrLiquidBlock(this.chunkPos.add(j, 0, k)));
            }

            this.decorating = false;
        }
    }

}