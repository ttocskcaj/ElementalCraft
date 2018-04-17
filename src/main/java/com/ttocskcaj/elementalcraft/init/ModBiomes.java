package com.ttocskcaj.elementalcraft.init;

import com.ttocskcaj.elementalcraft.biome.BiomeEarth;
import com.ttocskcaj.elementalcraft.biome.BiomeFire;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModBiomes {
    public static final BiomeFire BIOME_FIRE = new BiomeFire();
    public static final BiomeEarth BIOME_EARTH = new BiomeEarth();

    public static void init() {
//        ForgeRegistries.BIOMES.register(BIOME_FIRE);
    }
}
