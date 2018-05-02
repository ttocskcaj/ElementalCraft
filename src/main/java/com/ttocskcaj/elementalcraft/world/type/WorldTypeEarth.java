package com.ttocskcaj.elementalcraft.world.type;

import com.ttocskcaj.elementalcraft.init.ModBiomes;
import com.ttocskcaj.elementalcraft.world.chunkgen.ChunkGeneratorEarth;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;

public class WorldTypeEarth extends WorldType {
    public WorldTypeEarth() {
        super("Earth Plane");
    }

    @Override
    public BiomeProvider getBiomeProvider(World world) {
        return new BiomeProviderSingle(ModBiomes.BIOME_EARTH);
    }

    @Override
    public IChunkGenerator getChunkGenerator(World world, String generatorOptions) {
        return new ChunkGeneratorEarth(world, world.getSeed());
    }
}
