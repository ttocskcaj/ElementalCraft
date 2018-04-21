package com.ttocskcaj.elementalcraft.init;

import com.ttocskcaj.elementalcraft.biome.BiomeAir;
import com.ttocskcaj.elementalcraft.biome.BiomeEarth;
import com.ttocskcaj.elementalcraft.biome.BiomeFire;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModBiomes {
    public static final BiomeFire BIOME_FIRE = new BiomeFire();
    public static final BiomeEarth BIOME_EARTH = new BiomeEarth();
    public static final BiomeAir BIOME_AIR = new BiomeAir();

    public static void init() {
        // Fire Biome
        BiomeDictionary.addTypes(BIOME_FIRE,
                BiomeDictionary.Type.HOT,
                BiomeDictionary.Type.DRY,
                BiomeDictionary.Type.DEAD,
                BiomeDictionary.Type.MOUNTAIN,
                BiomeDictionary.Type.MAGICAL);
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(BIOME_FIRE, 25));
        BiomeManager.addSpawnBiome(BIOME_FIRE);

        // Earth Biome
        BiomeDictionary.addTypes(BIOME_EARTH,
                BiomeDictionary.Type.LUSH,
                BiomeDictionary.Type.MOUNTAIN,
                BiomeDictionary.Type.MAGICAL);
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(BIOME_EARTH, 25));
        BiomeManager.addSpawnBiome(BIOME_EARTH);

        // Air Biome
        BiomeDictionary.addTypes(BIOME_AIR,
                BiomeDictionary.Type.VOID,
                BiomeDictionary.Type.MAGICAL);
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(BIOME_AIR, 25));
        BiomeManager.addSpawnBiome(BIOME_AIR);



    }
}
