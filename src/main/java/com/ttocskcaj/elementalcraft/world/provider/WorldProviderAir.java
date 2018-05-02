package com.ttocskcaj.elementalcraft.world.provider;

import com.ttocskcaj.elementalcraft.init.ModBiomes;
import com.ttocskcaj.elementalcraft.init.ModDimensions;
import com.ttocskcaj.elementalcraft.world.chunkgen.ChunkGeneratorAir;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.chunk.Chunk;

import javax.annotation.Nullable;

public class WorldProviderAir extends WorldProvider {
    @Override
    public DimensionType getDimensionType() {
        return ModDimensions.AIR;
    }

    @Override
    public ChunkGeneratorAir createChunkGenerator() {
        return new ChunkGeneratorAir(world, world.getSeed());
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
        return new BiomeProviderSingle(ModBiomes.BIOME_AIR);
    }

    @Nullable
    @Override
    public String getSaveFolder() {
        return "DIM-ec-air";
    }

    @Override
    public float calculateCelestialAngle(long worldTime, float partialTicks) {
        // Permanent Dawn
        return 0.75F;
    }
}
