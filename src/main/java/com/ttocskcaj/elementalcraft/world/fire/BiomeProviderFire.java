package com.ttocskcaj.elementalcraft.world.fire;

import com.ttocskcaj.elementalcraft.init.ModBiomes;
import com.ttocskcaj.elementalcraft.world.fire.layers.GenLayerFire;
import com.ttocskcaj.elementalcraft.world.fire.layers.GenLayerFireBiomes;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;


public class BiomeProviderFire extends BiomeProvider {

    public BiomeProviderFire(World world) {
        super(world.getWorldInfo());
        allowedBiomes.clear();
        allowedBiomes.add(ModBiomes.BIOME_FIRE);

        getBiomesToSpawnIn().clear();
        getBiomesToSpawnIn().add(ModBiomes.BIOME_FIRE);
    }

    @Override
    public GenLayer[] getModdedBiomeGenerators(WorldType worldType, long seed, GenLayer[] original) {
        GenLayer biomes = new GenLayerFire(1);

        biomes = new GenLayerFireBiomes(1000, biomes);
        biomes = new GenLayerZoom(1000, biomes);
        biomes = new GenLayerZoom(1001, biomes);
        biomes = new GenLayerZoom(1002, biomes);
        biomes = new GenLayerZoom(1003, biomes);
        biomes = new GenLayerZoom(1004, biomes);

        GenLayer biomeIndexLayer = new GenLayerVoronoiZoom(10L, biomes);
        biomeIndexLayer.initWorldGenSeed(seed);

        return new GenLayer[]{
                biomes,
                biomeIndexLayer
        };
    }
}
