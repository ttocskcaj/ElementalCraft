package com.ttocskcaj.elementalcraft.world.biome;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;


public abstract class BiomeBase extends Biome {

    BiomeBase(BiomeProperties biomeProperties) {
        super(biomeProperties);

        // Remove all mobs.
        spawnableMonsterList.clear();
        spawnableWaterCreatureList.clear();
        spawnableCreatureList.clear();
    }

    @Override
    public float getSpawningChance() {
        return 0F;
    }


}
