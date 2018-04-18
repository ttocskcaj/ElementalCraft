package com.ttocskcaj.elementalcraft.world.fire.layers;

import com.ttocskcaj.elementalcraft.init.ModBiomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerFire extends GenLayer {
    private Biome[] biomes = new Biome[]{
            ModBiomes.BIOME_EARTH,
            ModBiomes.BIOME_FIRE
    };

    public GenLayerFire(long seed, GenLayer parent) {
        super(seed);
        parent = parent;
    }

    public GenLayerFire(long seed) {
        super(seed);
    }

    @Override
    public int[] getInts(int x, int y, int width, int depth) {
        int dest[] = IntCache.getIntCache(width * depth);
        for (int dz = 0; dz < depth; dz++) {
            for (int dx = 0; dx < width; dx++) {
                initChunkSeed(dx + x, dz + y);
                dest[dx + dz * depth] = Biome.getIdForBiome(biomes[nextInt(biomes.length)]);

            }


        }
        return dest;
    }
}
