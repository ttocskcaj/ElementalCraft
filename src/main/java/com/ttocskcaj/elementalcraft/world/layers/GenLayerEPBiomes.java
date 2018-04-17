package com.ttocskcaj.elementalcraft.world.layers;

import com.ttocskcaj.elementalcraft.init.ModBiomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerEPBiomes extends GenLayer {
    public GenLayerEPBiomes(long l, GenLayer genlayer) {
        super(l);
        parent = genlayer;
    }

    public GenLayerEPBiomes(long seed) {
        super(seed);
    }

    @Override
    public int[] getInts(int x, int z, int width, int depth) {
        int src[] = this.parent.getInts(x, z, width, depth);
        int dest[] = IntCache.getIntCache(width * depth);
        for (int dz = 0; dz < depth; dz++) {
            for (int dx = 0; dx < width; dx++) {
                // get offsets
                initChunkSeed(((dx + x) | 3), ((dz + z) | 3));

                int ox = this.nextInt(3) + 1;
                int oz = this.nextInt(3) + 1;

                if (((dx + x) & 3) == ox && ((dz + z) & 3) == oz) {
                    // determine which of the 4
                    if (((dx + x) & 4) == 0) {
                        if (((dz + z) & 4) == 0) {
                            dest[dx + dz * width] = getBiomeAt(dx + x, dz + z, 0);
                        } else {
                            dest[dx + dz * width] = getBiomeAt(dx + x, dz + z, 1);
                        }
                    } else {
                        if (((dz + z) & 4) == 0) {
                            dest[dx + dz * width] = getBiomeAt(dx + x, dz + z, 2);
                        } else {
                            dest[dx + dz * width] = getBiomeAt(dx + x, dz + z, 3);
                        }
                    }

                } else {
                    dest[dx + dz * width] = src[dx + dz * width];
                }
            }
        }


        return dest;
    }

    /**
     * Determine which map "region" the specified points are in.  Assign the 0-3 of the index to the key biomes based on that region.
     */
    private int getBiomeAt(int mapX, int mapZ, int index) {

        int regionX = (mapX + 4) >> 3;
        int regionZ = (mapZ + 4) >> 3;

        this.initChunkSeed(regionX, regionZ);
        int offset = this.nextInt(4);

        // do we need to shuffle this better?
        // the current version just "rotates" the 4 key biomes
        switch ((index + offset) % 4) {
            case 0:
            default:
                return Biome.getIdForBiome(ModBiomes.BIOME_FIRE);
            case 1:
                return Biome.getIdForBiome(ModBiomes.BIOME_EARTH);
            case 2:
                return Biome.getIdForBiome(ModBiomes.BIOME_FIRE);
            case 3:
                return Biome.getIdForBiome(ModBiomes.BIOME_EARTH);
        }
    }
}
