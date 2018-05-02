package com.ttocskcaj.elementalcraft.world.chunkgen;


import com.ttocskcaj.elementalcraft.init.ModBlocks;
import com.ttocskcaj.elementalcraft.world.generation.MapGenCavesEC;
import com.ttocskcaj.elementalcraft.world.generation.WorldGenLake;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.structure.*;


import javax.annotation.Nullable;
import java.util.List;

public class ChunkGeneratorFire extends ChunkGeneratorBase {
    private double[] depthBuffer = new double[256];
    private MapGenCavesEC caveGenerator;
    private MapGenMineshaft mineshaftGenerator;
    private MapGenBase ravineGenerator;


    private Biome[] biomesForGeneration;
    public ChunkGeneratorFire(World worldIn, long seed) {

        super(worldIn, seed);
        caveGenerator = new MapGenCavesEC(15);
        mineshaftGenerator = new MapGenMineshaft();
        ravineGenerator = new MapGenRavine();

        fillBlock = ModBlocks.FIRE_STONE.getDefaultState();
        oceanBlock = Blocks.LAVA.getDefaultState();
        seaLevel = 22;
        worldIn.setSeaLevel(seaLevel);

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
        this.mineshaftGenerator.generate(this.world, chunkX, chunkZ, chunkprimer);


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

        // Random position for lava lake
        int i2 = this.rand.nextInt(16) + 8;
        int l2 = this.rand.nextInt(this.rand.nextInt(248) + 8);
        int k3 = this.rand.nextInt(16) + 8;

        // Generate Lava Lake
        (new WorldGenLake(Blocks.LAVA, ModBlocks.ASH_BLOCK)).generate(this.world, this.rand, blockpos.add(i2, l2, k3));

        biome.decorate(this.world, this.rand, new BlockPos(worldX, 0, worldZ));

        BlockFalling.fallInstantly = false;
    }

    /**
     * Called to generate additional structures after initial worldgen, used by ocean monuments
     */
    public boolean generateStructures(Chunk chunkIn, int x, int z) {
        return false;
    }

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
