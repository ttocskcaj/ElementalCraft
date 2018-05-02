package com.ttocskcaj.elementalcraft.world.provider;

import com.ttocskcaj.elementalcraft.init.ModBiomes;
import com.ttocskcaj.elementalcraft.init.ModDimensions;
import com.ttocskcaj.elementalcraft.world.chunkgen.ChunkGeneratorFire;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.chunk.Chunk;

import javax.annotation.Nullable;

public class WorldProviderFire extends WorldProvider {
    @Override
    public DimensionType getDimensionType() {
        return ModDimensions.FIRE;
    }

    @Override
    public ChunkGeneratorFire createChunkGenerator() {
        return new ChunkGeneratorFire(world, world.getSeed() + 3);
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
        return new BiomeProviderSingle(ModBiomes.BIOME_FIRE);
    }

    @Nullable
    @Override
    public String getSaveFolder() {
        return "DIM-ec-fire";
    }

    @Override
    public float calculateCelestialAngle(long worldTime, float partialTicks) {
        // Permanent Day
        return 0F;
    }

}
