package com.ttocskcaj.elementalcraft.init;

import com.ttocskcaj.elementalcraft.world.biome.BiomeAir;
import com.ttocskcaj.elementalcraft.world.biome.BiomeEarth;
import com.ttocskcaj.elementalcraft.world.biome.BiomeFire;
import com.ttocskcaj.elementalcraft.world.biome.BiomeWater;
import net.minecraftforge.common.BiomeDictionary;

public class ModBiomes {
    public static final BiomeFire BIOME_FIRE = new BiomeFire();
    public static final BiomeEarth BIOME_EARTH = new BiomeEarth();
    public static final BiomeAir BIOME_AIR = new BiomeAir();
    public static final BiomeWater BIOME_WATER = new BiomeWater();

    public static void init() {
        // Fire Biome
        BiomeDictionary.addTypes(BIOME_FIRE,
                BiomeDictionary.Type.HOT,
                BiomeDictionary.Type.DRY,
                BiomeDictionary.Type.DEAD,
                BiomeDictionary.Type.MOUNTAIN,
                BiomeDictionary.Type.MAGICAL);
//        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(BIOME_FIRE, 25));
//        BiomeManager.addSpawnBiome(BIOME_FIRE);

        // Earth Biome
        BiomeDictionary.addTypes(BIOME_EARTH,
                BiomeDictionary.Type.LUSH,
                BiomeDictionary.Type.MAGICAL);
//        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(BIOME_EARTH, 25));
//        BiomeManager.addSpawnBiome(BIOME_EARTH);

        // Air Biome
        BiomeDictionary.addTypes(BIOME_AIR,
                BiomeDictionary.Type.VOID,
                BiomeDictionary.Type.MAGICAL,
                BiomeDictionary.Type.MOUNTAIN);
//        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(BIOME_AIR, 25));
//        BiomeManager.addSpawnBiome(BIOME_AIR);

        // Water Biome
        BiomeDictionary.addTypes(BIOME_WATER,
                BiomeDictionary.Type.WATER,
                BiomeDictionary.Type.MAGICAL);
//        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(BIOME_WATER, 25));
//        BiomeManager.addSpawnBiome(BIOME_WATER);


    }
}
