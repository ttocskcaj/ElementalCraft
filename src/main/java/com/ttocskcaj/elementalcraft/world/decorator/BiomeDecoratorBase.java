package com.ttocskcaj.elementalcraft.world.decorator;

import com.google.common.base.Predicate;
import com.ttocskcaj.elementalcraft.block.generic.BlockStone;
import com.ttocskcaj.elementalcraft.init.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

import static com.ttocskcaj.elementalcraft.block.generic.BlockStone.VARIANT;

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
            if(inputState == null) return false;
            if(inputState == ModBlocks.stone.getDefaultState().withProperty(VARIANT, BlockStone.Type.EARTH)) return true;
            if(inputState == ModBlocks.stone.getDefaultState().withProperty(VARIANT, BlockStone.Type.FIRE)) return true;
            if(inputState == ModBlocks.stone.getDefaultState().withProperty(VARIANT, BlockStone.Type.WATER)) return true;
            if(inputState == ModBlocks.stoneAir.getDefaultState()) return true;
            return false;
        }
    }
}
