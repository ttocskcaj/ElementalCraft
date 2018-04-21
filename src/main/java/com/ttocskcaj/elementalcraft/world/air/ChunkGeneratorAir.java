package com.ttocskcaj.elementalcraft.world.air;


import com.ttocskcaj.elementalcraft.init.ModBlocks;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldEntitySpawner;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.*;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

@SuppressWarnings("Duplicates")
public class ChunkGeneratorAir implements IChunkGenerator {
    private final Random rand1;
    private final Random rand2;
    private final NoiseGeneratorPerlin surfaceNoise;
    private final NoiseGeneratorOctaves scaleNoise;
    private final NoiseGeneratorOctaves forestNoise;
    public NoiseGeneratorOctaves depthNoise;
    private final World world;
    private final boolean mapFeaturesEnabled;
    private final WorldType terrainType;
    private double[] heightMapTop;
    private double[] heightMapBottom;
    private final float[] biomeWeights;

    private IBlockState fillBlock;
    private IBlockState oceanBlock;

    private double[] depthBuffer = new double[256];

    private Biome[] biomesForGeneration;
    double[] mainNoiseRegion;
    double[] minLimitRegion;
    double[] maxLimitRegion;
    double[] depthRegion;

    private double depthNoiseScaleX = 1000D;
    private double depthNoiseScaleZ = 1000D;
    private double depthNoiseScaleExponent = 0.5D;
    private int coordScale = 684;
    private int mainNoiseScaleX = 200;
    private int mainNoiseScaleY = 80;
    private int mainNoiseScaleZ = 200;
    private int heightScale = 684;
    private int biomeDepthOffSet = 0;
    private int biomeScaleOffset = 0;
    private double heightStretch = 12;
    private double baseSize = 8.5D;
    private double lowerLimitScale = 512D;
    private double upperLimitScale = 512D;
    private float biomeDepthWeight = 1.0F;
    private float biomeScaleWeight = 1.0F;

    private MapGenBase caveGenerator = new MapGenCaves();


    public ChunkGeneratorAir(World worldIn, long seed) {

        caveGenerator = net.minecraftforge.event.terraingen.TerrainGen.getModdedMapGen(caveGenerator, net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.CAVE);

        world = worldIn;
        mapFeaturesEnabled = true;
        terrainType = worldIn.getWorldInfo().getTerrainType();
        rand1 = new Random(seed);
        rand2 = new Random(seed * 32984375 / 2342355);

        heightMapTop = new double[825];
        heightMapBottom = new double[825];
        biomeWeights = new float[25];

        surfaceNoise = new NoiseGeneratorPerlin(this.rand1, 4);
        scaleNoise = new NoiseGeneratorOctaves(this.rand1, 10);
        forestNoise = new NoiseGeneratorOctaves(this.rand1, 8);

        for (int i = -2; i <= 2; ++i) {
            for (int j = -2; j <= 2; ++j) {
                float f = 10.0F / MathHelper.sqrt((float) (i * i + j * j) + 0.2F);
                this.biomeWeights[i + 2 + (j + 2) * 5] = f;
            }
        }

        this.fillBlock = ModBlocks.AIR_STONE.getDefaultState();
        this.oceanBlock = Blocks.AIR.getDefaultState();
        worldIn.setSeaLevel(0);
    }

    /**
     * Creates base terrain (air and stone) using heightmaps.
     *
     * @param chunkX
     * @param chunkZ
     * @param primer
     */
    public void generateTerrain(int chunkX, int chunkZ, ChunkPrimer primer) {

        // Get biomes being used in this chunk
        this.biomesForGeneration = this.world.getBiomeProvider().getBiomesForGeneration(this.biomesForGeneration, chunkX * 4 - 2, chunkZ * 4 - 2, 10, 10);

        // Get heightmap for this chunk
        this.heightMapTop = generateHeightmap(chunkX * 4, 0, chunkZ * 4, this.rand1);

        // Divide chunk along x axis
        for (int iX = 0; iX < 4; ++iX) {
            int j = iX * 5;
            int k = (iX + 1) * 5;

            // Divide chunk along z axis
            for (int iZ = 0; iZ < 4; ++iZ) {
                int i1 = (j + iZ) * 33;
                int j1 = (j + iZ + 1) * 33;
                int k1 = (k + iZ) * 33;
                int l1 = (k + iZ + 1) * 33;

                // Divide chunk along y axis.
                // Now have a 4 x 8 x 4 subchunk to work with.
                for (int iY = 0; iY < 32; ++iY) {
                    // Get noise values from heightmap.
                    double d1 = this.heightMapTop[i1 + iY];
                    double d2 = this.heightMapTop[j1 + iY];
                    double d3 = this.heightMapTop[k1 + iY];
                    double d4 = this.heightMapTop[l1 + iY];

                    // Lerp values.
                    double d5 = (this.heightMapTop[i1 + iY + 1] - d1) * 0.125D;
                    double d6 = (this.heightMapTop[j1 + iY + 1] - d2) * 0.125D;
                    double d7 = (this.heightMapTop[k1 + iY + 1] - d3) * 0.125D;
                    double d8 = (this.heightMapTop[l1 + iY + 1] - d4) * 0.125D;

                    // Loop through each Y level in the subchunk
                    for (int jY = 0; jY < 8; ++jY) {
                        double d9 = 0.25D;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * 0.25D;
                        double d13 = (d4 - d2) * 0.25D;

                        // Loop through x axis
                        for (int jX = 0; jX < 4; ++jX) {
                            double d14 = 0.25D;
                            double d16 = (d11 - d10) * 0.25D;
                            double finalNoise = d10 - d16;

                            // Loop through z axis
                            for (int jZ = 0; jZ < 4; ++jZ) {
                                // If the noiseLevel is above 0, and block is above sea level set block to firestone.
                                if ((finalNoise += d16) > 0.0D) {
                                    primer.setBlockState(iX * 4 + jX, iY * 8 + jY, iZ * 4 + jZ, this.fillBlock);
                                }
                                // If block is below sealevel, set to lava.
                                else if (iY * 8 + jY < 0) {
                                    primer.setBlockState(iX * 4 + jX, iY * 8 + jY, iZ * 4 + jZ, this.oceanBlock);
                                }
                            }

                            d10 += d12;
                            d11 += d13;
                        }

                        d1 += d5;
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                    }
                }
            }
        }
    }

    public void replaceBiomeBlocks(int x, int z, ChunkPrimer primer, Biome[] biomesIn) {
        if (!net.minecraftforge.event.ForgeEventFactory.onReplaceBiomeBlocks(this, x, z, primer, this.world)) return;
        double d0 = 0.03125D;
        this.depthBuffer = this.surfaceNoise.getRegion(this.depthBuffer, (double) (x * 16), (double) (z * 16), 16, 16, 0.0625D, 0.0625D, 1.0D);

        // Loop through each x row.
        for (int iX = 0; iX < 16; ++iX) {
            // Loop through each y row.
            for (int iZ = 0; iZ < 16; ++iZ) {
                // Get the biome at this x,z coord?
                Biome biome = biomesIn[iZ + iX * 16];

                // Use the biome to replace blocks at this x, z coord (full y column).
                biome.genTerrainBlocks(this.world, this.rand1, primer, x * 16 + iX, z * 16 + iZ, this.depthBuffer[iZ + iX * 16]);
            }
        }
    }

    /**
     * Generates the chunk at the specified position, from scratch
     */
    public Chunk generateChunk(int x, int z) {

        this.rand1.setSeed((long) x * 341873128712L + (long) z * 132897987541L);
        ChunkPrimer chunkprimer = new ChunkPrimer();
        this.generateTerrain(x, z, chunkprimer);
        this.biomesForGeneration = this.world.getBiomeProvider().getBiomes(this.biomesForGeneration, x * 16, z * 16, 16, 16);
        this.replaceBiomeBlocks(x, z, chunkprimer, this.biomesForGeneration);

        this.caveGenerator.generate(this.world, x, z, chunkprimer);

        Chunk chunk = new Chunk(this.world, chunkprimer, x, z);
        byte[] abyte = chunk.getBiomeArray();

        for (int i = 0; i < abyte.length; ++i) {
            abyte[i] = (byte) Biome.getIdForBiome(this.biomesForGeneration[i]);
        }

        chunk.generateSkylightMap();
        return chunk;
    }

    private double[] generateHeightmap(int x, int y, int z, Random random) {
        double[] heightMap = new double[825];
        NoiseGeneratorOctaves minLimitPerlinNoise = new NoiseGeneratorOctaves(random, 16);
        NoiseGeneratorOctaves maxLimitPerlinNoise = new NoiseGeneratorOctaves(random, 16);
        NoiseGeneratorOctaves mainPerlinNoise = new NoiseGeneratorOctaves(random, 8);
        depthNoise = new NoiseGeneratorOctaves(random, 16);


        this.depthRegion = this.depthNoise.generateNoiseOctaves(this.depthRegion, x, z, 5, 5, (double) this.depthNoiseScaleX, (double) this.depthNoiseScaleZ, (double) this.depthNoiseScaleExponent);
        float f = this.coordScale;
        float f1 = this.heightScale;
        this.mainNoiseRegion = mainPerlinNoise.generateNoiseOctaves(this.mainNoiseRegion, x, y, z, 5, 33, 5, (double) (f / this.mainNoiseScaleX), (double) (f1 / this.mainNoiseScaleY), (double) (f / this.mainNoiseScaleZ));
        this.minLimitRegion = minLimitPerlinNoise.generateNoiseOctaves(this.minLimitRegion, x, y, z, 5, 33, 5, (double) f, (double) f1, (double) f);
        this.maxLimitRegion = maxLimitPerlinNoise.generateNoiseOctaves(this.maxLimitRegion, x, y, z, 5, 33, 5, (double) f, (double) f1, (double) f);
        int i = 0;
        int j = 0;

        for (int k = 0; k < 5; ++k) {
            for (int l = 0; l < 5; ++l) {
                float f2 = 0.0F;
                float f3 = 0.0F;
                float f4 = 0.0F;
                int i1 = 2;
                Biome biome = this.biomesForGeneration[k + 2 + (l + 2) * 10];

                for (int j1 = -2; j1 <= 2; ++j1) {
                    for (int k1 = -2; k1 <= 2; ++k1) {
                        Biome biome1 = this.biomesForGeneration[k + j1 + 2 + (l + k1 + 2) * 10];
                        float f5 = this.biomeDepthOffSet + biome1.getBaseHeight() * this.biomeDepthWeight;
                        float f6 = this.biomeScaleOffset + biome1.getHeightVariation() * this.biomeScaleWeight;

                        if (this.terrainType == WorldType.AMPLIFIED && f5 > 0.0F) {
                            f5 = 1.0F + f5 * 2.0F;
                            f6 = 1.0F + f6 * 4.0F;
                        }

                        float f7 = this.biomeWeights[j1 + 2 + (k1 + 2) * 5] / (f5 + 2.0F);

                        if (biome1.getBaseHeight() > biome.getBaseHeight()) {
                            f7 /= 2.0F;
                        }

                        f2 += f6 * f7;
                        f3 += f5 * f7;
                        f4 += f7;
                    }
                }

                f2 = f2 / f4;
                f3 = f3 / f4;
                f2 = f2 * 0.9F + 0.1F;
                f3 = (f3 * 4.0F - 1.0F) / 8.0F;
                double d7 = this.depthRegion[j] / 8000.0D;

                if (d7 < 0.0D) {
                    d7 = -d7 * 0.3D;
                }

                d7 = d7 * 3.0D - 2.0D;

                if (d7 < 0.0D) {
                    d7 = d7 / 2.0D;

                    if (d7 < -1.0D) {
                        d7 = -1.0D;
                    }

                    d7 = d7 / 1.4D;
                    d7 = d7 / 2.0D;
                } else {
                    if (d7 > 1.0D) {
                        d7 = 1.0D;
                    }

                    d7 = d7 / 8.0D;
                }

                ++j;
                double d8 = (double) f3;
                double d9 = (double) f2;
                d8 = d8 + d7 * 0.2D;
                d8 = d8 * (double) this.baseSize / 8.0D;
                double d0 = (double) this.baseSize + d8 * 4.0D;

                for (int l1 = 0; l1 < 33; ++l1) {
                    double d1 = ((double) l1 - d0) * (double) this.heightStretch * 128.0D / 256.0D / d9;

                    if (d1 < 0.0D) {
                        d1 *= 4.0D;
                    }

                    double d2 = this.minLimitRegion[i] / (double) this.lowerLimitScale;
                    double d3 = this.maxLimitRegion[i] / (double) this.upperLimitScale;
                    double d4 = (this.mainNoiseRegion[i] / 10.0D + 1.0D) / 2.0D;
                    double d5 = MathHelper.clampedLerp(d2, d3, d4) - d1;

                    if (l1 > 29) {
                        double d6 = (double) ((float) (l1 - 29) / 3.0F);
                        d5 = d5 * (1.0D - d6) + -10.0D * d6;
                    }

                    heightMap[i] = d5;
                    ++i;
                }
            }
        }
        return heightMap;
    }

    /**
     * Generate initial structures in this chunk, e.g. mineshafts, temples, lakes, and dungeons
     */
    public void populate(int x, int z) {
        BlockFalling.fallInstantly = true;
        int i = x * 16;
        int j = z * 16;
        BlockPos blockpos = new BlockPos(i, 0, j);
        Biome biome = this.world.getBiome(blockpos.add(16, 0, 16));
        this.rand1.setSeed(this.world.getSeed());
        long k = this.rand1.nextLong() / 2L * 2L + 1L;
        long l = this.rand1.nextLong() / 2L * 2L + 1L;
        this.rand1.setSeed((long) x * k + (long) z * l ^ this.world.getSeed());
        boolean flag = false;
        ChunkPos chunkpos = new ChunkPos(x, z);

        net.minecraftforge.event.ForgeEventFactory.onChunkPopulate(true, this, this.world, this.rand1, x, z, flag);


        biome.decorate(this.world, this.rand1, new BlockPos(i, 0, j));
        if (net.minecraftforge.event.terraingen.TerrainGen.populate(this, this.world, this.rand1, x, z, flag, net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ANIMALS))
            WorldEntitySpawner.performWorldGenSpawning(this.world, biome, i + 8, j + 8, 16, 16, this.rand1);
        blockpos = blockpos.add(8, 0, 8);

        net.minecraftforge.event.ForgeEventFactory.onChunkPopulate(false, this, this.world, this.rand1, x, z, flag);

        BlockFalling.fallInstantly = false;
    }

    /**
     * Called to generate additional structures after initial worldgen, used by ocean monuments
     */
    public boolean generateStructures(Chunk chunkIn, int x, int z) {
        return false;
    }

    // TODO: 16/04/2018 Mobs
    public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
        Biome biome = this.world.getBiome(pos);
        return biome.getSpawnableList(creatureType);
    }

    public boolean isInsideStructure(World worldIn, String structureName, BlockPos pos) {
        return false;
    }

    @Nullable
    public BlockPos getNearestStructurePos(World worldIn, String structureName, BlockPos position, boolean findUnexplored) {
        return null;
    }

    @Override
    public void recreateStructures(Chunk chunkIn, int x, int z) {

    }

}
