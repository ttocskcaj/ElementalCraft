package com.ttocskcaj.elementalcraft.biome;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;


public abstract class BiomeElemental extends Biome {

    BiomeElemental(BiomeProperties biomeProperties) {
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

    @Override
    public BiomeDecorator createBiomeDecorator() {
        ElementalPlaneBiomeDecorator biomeDecorator = new ElementalPlaneBiomeDecorator();

        biomeDecorator.waterlilyPerChunk = 0;
        biomeDecorator.treesPerChunk = 12;
        biomeDecorator.extraTreeChance = 0F;
        biomeDecorator.flowersPerChunk = 0;
        biomeDecorator.grassPerChunk = 0;
        biomeDecorator.deadBushPerChunk = 20;
        biomeDecorator.mushroomsPerChunk = 3;
        biomeDecorator.reedsPerChunk = 0;
        biomeDecorator.cactiPerChunk = 0;
        biomeDecorator.gravelPatchesPerChunk = 2;
        biomeDecorator.sandPatchesPerChunk = 0;
        biomeDecorator.clayPerChunk = 0;
        biomeDecorator.bigMushroomsPerChunk = 1;
        biomeDecorator.generateFalls = false;
        return getModdedBiomeDecorator(biomeDecorator);
    }
}
