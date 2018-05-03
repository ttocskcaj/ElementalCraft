package com.ttocskcaj.elementalcraft.world.generation;

import com.ttocskcaj.elementalcraft.block.ore.BlockOverworldOre;
import com.ttocskcaj.elementalcraft.init.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

import static com.ttocskcaj.elementalcraft.block.ore.BlockOverworldOre.VARIANT;

public class WorldGenOre implements IWorldGenerator {


    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.getDimension() == 0) {
            generateOre(ModBlocks.overworldOre.getDefaultState().withProperty(VARIANT, BlockOverworldOre.Type.AETHER), world, random, chunkX * 16, chunkZ * 16, 3, 20, 8, 3);
        }
    }



    private void generateOre(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances) {
        int deltaY = maxY - minY;

        for (int i = 0; i < chances; i++) {
            BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));
            WorldGenMinable generator = new WorldGenMinable(ore, size);
            generator.generate(world, random, pos);
        }
    }




}
