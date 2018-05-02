package com.ttocskcaj.elementalcraft.world.decorator;

import com.ttocskcaj.elementalcraft.init.ModBlocks;
import com.ttocskcaj.elementalcraft.world.generation.WorldGenPatches;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class BiomeDecoratorEarth extends BiomeDecoratorBase {
    private int treesPerChunk = 64;
    private int grassPerChunk = 18;
    public WorldGenerator patchGen = new WorldGenPatches(Blocks.SAND, 7);


    @Override
    public void decorate(World worldIn, Random random, Biome biomeIn, BlockPos pos) {
        if (this.decorating) {
            throw new RuntimeException("Already decorating");
        } else {
            this.chunkPos = pos;
            generateOre(ModBlocks.JADE_ORE.getDefaultState(), worldIn, random, 3, 150, 6, 3);
            generateOre(ModBlocks.ONYX_ORE.getDefaultState(), worldIn, random, 3, 150, 6, 3);
            generateOre(ModBlocks.FLUORITE_ORE.getDefaultState(), worldIn, random, 3, 150, 6, 2);
            generateOre(ModBlocks.LEAD_ORE.getDefaultState(), worldIn, random, 3, 150, 6, 8);
            generateOre(ModBlocks.EARTH_ENERGY_ORE.getDefaultState(), worldIn, random, 45, 60, 5, 2);
            for (int i3 = 0; i3 < this.grassPerChunk; ++i3)
            {
                int j7 = random.nextInt(16) + 8;
                int i11 = random.nextInt(16) + 8;
                int k14 = worldIn.getHeight(this.chunkPos.add(j7, 0, i11)).getY() * 2;

                if (k14 > 0)
                {
                    int l17 = random.nextInt(k14);
                    biomeIn.getRandomWorldGenForGrass(random).generate(worldIn, random, this.chunkPos.add(j7, l17, i11));
                }
            }
            for (int j2 = 0; j2 < treesPerChunk; ++j2)
            {
                int k6 = random.nextInt(16) + 8;
                int l = random.nextInt(16) + 8;
                WorldGenAbstractTree worldgenabstracttree = biomeIn.getRandomTreeFeature(random);
                worldgenabstracttree.setDecorationDefaults();
                BlockPos blockpos = worldIn.getHeight(this.chunkPos.add(k6, 0, l));

                if (worldgenabstracttree.generate(worldIn, random, blockpos))
                {
                    worldgenabstracttree.generateSaplings(worldIn, random, blockpos);
                }
            }
            if (random.nextInt(2) == 1) {
                int j = random.nextInt(16) + 8;
                int k = random.nextInt(16) + 8;
                this.patchGen.generate(worldIn, random, worldIn.getTopSolidOrLiquidBlock(this.chunkPos.add(j, 0, k)));
            }

            this.decorating = false;
        }
    }
}
