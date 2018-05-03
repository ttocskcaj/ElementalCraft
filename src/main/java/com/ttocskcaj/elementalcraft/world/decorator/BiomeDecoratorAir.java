package com.ttocskcaj.elementalcraft.world.decorator;

import com.ttocskcaj.elementalcraft.block.ore.BlockAirOre;
import com.ttocskcaj.elementalcraft.init.ModBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;

import java.util.Random;

import static com.ttocskcaj.elementalcraft.block.ore.BlockAirOre.VARIANT;

public class BiomeDecoratorAir extends BiomeDecoratorBase {


    @Override
    public void decorate(World worldIn, Random random, Biome biome, BlockPos pos) {
        if (this.decorating) {
            throw new RuntimeException("Already decorating");
        } else {
            this.chunkPos = pos;
            generateOre(ModBlocks.airOre.getDefaultState().withProperty(VARIANT, BlockAirOre.Type.AIR_ENERGY), worldIn, random, 1, 80, 9, 8);
            generateOre(ModBlocks.airOre.getDefaultState().withProperty(VARIANT, BlockAirOre.Type.TIN), worldIn, random, 40, 160, 9, 10);
            generateOre(ModBlocks.airOre.getDefaultState().withProperty(VARIANT, BlockAirOre.Type.AZURITE), worldIn, random, 160, 200, 9, 8);
            generateOre(ModBlocks.airOre.getDefaultState().withProperty(VARIANT, BlockAirOre.Type.CITRINE), worldIn, random, 100, 180, 9, 8);
            generateOre(ModBlocks.airOre.getDefaultState().withProperty(VARIANT, BlockAirOre.Type.IRON), worldIn, random, 1, 220, 9, 8);

            this.decorating = false;
        }
    }
}
