package com.ttocskcaj.elementalcraft.world.decorator;

import com.google.common.base.Predicate;
import com.ttocskcaj.elementalcraft.init.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class BiomeDecoratorBase extends BiomeDecorator {
    private ElementalStoneTypesPredicate elementalStoneTypesPredicate;

    public BiomeDecoratorBase() {
        elementalStoneTypesPredicate = new ElementalStoneTypesPredicate();
    }

    protected void generateOre(IBlockState ore, World worldIn, Random random, int minY, int maxY, int size, int chances) {

        for (int j = 0; j < chances; ++j)
        {
            WorldGenMinable generator =  new WorldGenMinable(ore, size, elementalStoneTypesPredicate);
            BlockPos blockpos = this.chunkPos.add(random.nextInt(16), random.nextInt(maxY - minY) + minY, random.nextInt(16));
            generator.generate(worldIn, random, blockpos);
        }
    }
    public static class ElementalStoneTypesPredicate implements Predicate<IBlockState> {
        public ElementalStoneTypesPredicate() {
        }

        public boolean apply(IBlockState inputState) {
            boolean value = inputState != null && (inputState.getBlock() == ModBlocks.FIRE_STONE || inputState.getBlock() == ModBlocks.AIR_STONE || inputState.getBlock() == ModBlocks.WATER_STONE || inputState.getBlock() == ModBlocks.EARTH_STONE);
//            System.out.printf("Tested [%s] for ore generation and returned [%s]\n", inputState, value);
            return value;
        }
    }
}
