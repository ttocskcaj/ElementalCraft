package com.ttocskcaj.elementalcraft.util;

import com.google.common.base.Predicate;
import com.ttocskcaj.elementalcraft.init.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class ModWorldGeneration implements IWorldGenerator {
    private ElementalStoneTypesPredicate elementalStoneTypesPredicate;
    public ModWorldGeneration(){
        elementalStoneTypesPredicate = new ElementalStoneTypesPredicate();
    }
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.getDimension() == 0) {
            generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
        }
        if (world.provider.getDimension() == Config.fireDimensionID) {
            generateFirePlane(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
        }
    }

    private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        generateOre(ModBlocks.AETHER_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 3, 20, 1 + random.nextInt(4), 6);
    }



    private void generateFirePlane(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        //@todo filter ore by biome.
        generateOre(ModBlocks.GARNET_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 23, 35, 1 + random.nextInt(4), 5);
        generateOre(ModBlocks.BLOODSTONE_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 30, 50, 1 + random.nextInt(4), 6);
        generateOre(ModBlocks.EARTH_ENERGY_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 5, 255, 8 + random.nextInt(8), 2);
        generateOre(ModBlocks.NICKEL_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 5, 20, 2 + random.nextInt(3), 12);
    }



    private void generateOre(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances) {
        int deltaY = maxY - minY;

        for (int i = 0; i < chances; i++) {
            BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));

            WorldGenMinable generator = new WorldGenMinable(ore, size, elementalStoneTypesPredicate);
            generator.generate(world, random, pos);

//            ElementalCraft.logger.info("Generated ore: " + ore);
        }
    }


    static class ElementalStoneTypesPredicate implements Predicate<IBlockState>
    {
        private ElementalStoneTypesPredicate()
        {
        }

        public boolean apply(IBlockState inputState)
        {
            if (inputState != null && inputState.getBlock() == ModBlocks.FIRE_STONE)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }

}
