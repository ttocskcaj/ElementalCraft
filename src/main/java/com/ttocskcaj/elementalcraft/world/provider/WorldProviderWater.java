package com.ttocskcaj.elementalcraft.world.provider;

import com.ttocskcaj.elementalcraft.init.ModBiomes;
import com.ttocskcaj.elementalcraft.init.ModDimensions;
import com.ttocskcaj.elementalcraft.world.chunkgen.ChunkGeneratorWater;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.IChunkGenerator;

import javax.annotation.Nullable;

public class WorldProviderWater extends WorldProvider {
    @Override
    public DimensionType getDimensionType() {
        return ModDimensions.WATER;
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new ChunkGeneratorWater(world, world.getSeed() + 4);
//        return new ChunkGeneratorOverworld(world, world.getSeed() + 4, true, null);
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
    public Vec3d getSkyColor(Entity cameraEntity, float partialTicks) {
        return new Vec3d(50, 200, 180);
    }

    @Override
    public BiomeProvider getBiomeProvider() {
        return new BiomeProviderSingle(ModBiomes.BIOME_WATER);
    }

    @Nullable
    @Override
    public String getSaveFolder() {
        return "DIM-ec-water";
    }

    @Override
    public float calculateCelestialAngle(long worldTime, float partialTicks) {
        // Permanent Day
        return 0.25F;
    }

}
