package com.ttocskcaj.elementalcraft.world;

import com.ttocskcaj.elementalcraft.init.ModBiomes;
import com.ttocskcaj.elementalcraft.init.ModDimensions;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.chunk.Chunk;

import javax.annotation.Nullable;

public class WorldProviderEP extends WorldProvider {
    @Override
    public DimensionType getDimensionType() {
        return ModDimensions.ELEMENTAL_PLANE;
    }

    @Override
    public ChunkGeneratorEP createChunkGenerator() {
        return new ChunkGeneratorEP(world, world.getSeed());
    }

    @Override
    public boolean canDoRainSnowIce(Chunk chunk) {
        return false;
    }

    @Override
    public boolean canSnowAt(BlockPos pos, boolean checkLight) {
        return false;
    }

    @Override
    public BiomeProvider getBiomeProvider() {
        return new BiomeProviderEP(world);
    }

    @Nullable
    @Override
    public String getSaveFolder() {
        return "elemental-plane";
    }
}
