package com.ttocskcaj.elementalcraft.biome;


public class BiomeEarth extends BiomeElemental {


    public BiomeEarth() {
        super(new BiomeProperties("Elemental Earth").setTemperature(2f).setRainDisabled().setBaseHeight(1.0F)
                .setHeightVariation(6F));
        setRegistryName("earth_biome");

    }


}