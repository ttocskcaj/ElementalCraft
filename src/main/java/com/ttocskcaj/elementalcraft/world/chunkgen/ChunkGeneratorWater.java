package com.ttocskcaj.elementalcraft.world.chunkgen;


import com.ttocskcaj.elementalcraft.block.generic.BlockStone;
import com.ttocskcaj.elementalcraft.init.ModBlocks;
import com.ttocskcaj.elementalcraft.world.generation.MapGenCavesEC;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.*;

import javax.annotation.Nullable;
import java.util.List;

import static com.ttocskcaj.elementalcraft.block.generic.BlockStone.VARIANT;

public class ChunkGeneratorWater extends ChunkGeneratorBase {
    private MapGenCavesEC caveGenerator = new MapGenCavesEC(0);
    private MapGenBase ravineGenerator = new MapGenRavine();


    private double[] depthBuffer = new double[256];


    private Biome[] biomesForGeneration;

    public ChunkGeneratorWater(World worldIn, long seed) {
        super(worldIn, seed);

        this.fillBlock = ModBlocks.stone.getDefaultState().withProperty(VARIANT, BlockStone.Type.WATER);
        this.oceanBlock = Blocks.WATER.getDefaultState();
        this.seaLevel = 68;
        worldIn.setSeaLevel(this.seaLevel);

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
                biome.genTerrainBlocks(this.world, this.rand, primer, x * 16 + iX, z * 16 + iZ, this.depthBuffer[iZ + iX * 16]);
            }
        }
    }

    /**
     * Generates the chunk at the specified position, from scratch
     */
    public Chunk generateChunk(int chunkX, int chunkZ) {
        this.rand.setSeed((long) chunkX * 341873128712L + (long) chunkZ * 132897987541L);

        ChunkPrimer chunkprimer = new ChunkPrimer();

        this.generateTerrain(chunkX, chunkZ, chunkprimer);

        this.biomesForGeneration = this.world.getBiomeProvider().getBiomes(this.biomesForGeneration, chunkX * 16, chunkZ * 16, 16, 16);

        this.replaceBiomeBlocks(chunkX, chunkZ, chunkprimer, this.biomesForGeneration);
        this.caveGenerator.generate(this.world, chunkX, chunkZ, chunkprimer);
        this.ravineGenerator.generate(this.world, chunkX, chunkZ, chunkprimer);


        Chunk chunk = new Chunk(this.world, chunkprimer, chunkX, chunkZ);
        byte[] aByte = chunk.getBiomeArray();

        for (int i = 0; i < aByte.length; ++i) {
            aByte[i] = (byte) Biome.getIdForBiome(this.biomesForGeneration[i]);
        }

        chunk.generateSkylightMap();
        return chunk;
    }

    /**
     * Generate initial structures in this chunk, e.g. mineshafts, temples, lakes, and dungeons
     */
    public void populate(int chunkX, int chunkZ) {
        BlockFalling.fallInstantly = true;

        int worldX = chunkX * 16;
        int worldZ = chunkZ * 16;

        BlockPos blockpos = new BlockPos(worldX, 0, worldZ);
        Biome biome = this.world.getBiome(blockpos.add(16, 0, 16));

        // Shuffle Seed?
        this.rand.setSeed(this.world.getSeed());
        long k = this.rand.nextLong() / 2L * 2L + 1L;
        long l = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed((long) chunkX * k + (long) chunkZ * l ^ this.world.getSeed());

        biome.decorate(this.world, this.rand, new BlockPos(worldX, 0, worldZ));

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

    /**
     * Recreates data about structures intersecting given chunk (used for example by getPossibleCreatures), without
     * placing any blocks. When called for the first time before any chunk is generated - also initializes the internal
     * state needed by getPossibleCreatures.
     */
    public void recreateStructures(Chunk chunkIn, int x, int z) {

    }
}
