package com.ttocskcaj.elementalcraft.world.air;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.IChunkGenerator;

public class WorldTypeAir extends WorldType {
    public WorldTypeAir() {
        super("Air Plane");
    }

    @Override
    public BiomeProvider getBiomeProvider(World world) {
        return new BiomeProviderAir(world);
    }

    @Override
    public IChunkGenerator getChunkGenerator(World world, String generatorOptions) {
        return new ChunkGeneratorAir(world, world.getSeed());
    }
}
