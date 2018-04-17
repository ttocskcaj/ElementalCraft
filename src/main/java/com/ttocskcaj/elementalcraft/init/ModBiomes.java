package com.ttocskcaj.elementalcraft.init;

import com.ttocskcaj.elementalcraft.biome.BiomeEarth;
import com.ttocskcaj.elementalcraft.biome.BiomeFire;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModBiomes {
    public static final BiomeFire BIOME_FIRE = new BiomeFire();
    public static final BiomeEarth BIOME_EARTH = new BiomeEarth();

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
//        BiomeManager.addStrongholdBiome(BIOME_FIRE);
//        BiomeManager.addVillageBiome(BIOME_FIRE, true);



        // Earth Biome
        BiomeDictionary.addTypes(BIOME_EARTH,
                BiomeDictionary.Type.LUSH,
                BiomeDictionary.Type.MOUNTAIN,
                BiomeDictionary.Type.MAGICAL);
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(BIOME_EARTH, 25));
        BiomeManager.addSpawnBiome(BIOME_EARTH);
//        BiomeManager.addStrongholdBiome(BIOME_EARTH);
//        BiomeManager.addVillageBiome(BIOME_EARTH, true);


    }
}
