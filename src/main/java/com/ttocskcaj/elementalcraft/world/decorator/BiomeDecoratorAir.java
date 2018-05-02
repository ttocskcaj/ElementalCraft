package com.ttocskcaj.elementalcraft.world.decorator;

import com.ttocskcaj.elementalcraft.init.ModBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;

import java.util.Random;

public class BiomeDecoratorAir extends BiomeDecoratorBase {


    @Override
    public void decorate(World worldIn, Random random, Biome biome, BlockPos pos) {
        if (this.decorating) {
            throw new RuntimeException("Already decorating");
        } else {
            this.chunkPos = pos;
            generateOre(ModBlocks.AIR_ENERGY_ORE.getDefaultState(), worldIn, random, 1, 80, 9, 8);
            generateOre(ModBlocks.TIN_ORE.getDefaultState(), worldIn, random, 40, 160, 9, 10);
            generateOre(ModBlocks.AZURITE_ORE.getDefaultState(), worldIn, random, 160, 200, 9, 8);
            generateOre(ModBlocks.CITRINE_ORE.getDefaultState(), worldIn, random, 100, 180, 9, 8);

            this.decorating = false;
        }
    }
}
