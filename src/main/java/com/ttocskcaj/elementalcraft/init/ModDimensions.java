package com.ttocskcaj.elementalcraft.init;

import com.ttocskcaj.elementalcraft.ElementalCraft;
import com.ttocskcaj.elementalcraft.world.provider.WorldProviderAir;
import com.ttocskcaj.elementalcraft.world.provider.WorldProviderEarth;
import com.ttocskcaj.elementalcraft.world.provider.WorldProviderFire;
import com.ttocskcaj.elementalcraft.util.Config;
import com.ttocskcaj.elementalcraft.world.provider.WorldProviderWater;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class ModDimensions {

    public static DimensionType FIRE;
    public static DimensionType AIR;
    public static DimensionType EARTH;
    public static DimensionType WATER;

    public static void init() {
        registerDimensionTypes();
        registerDimensions();
    }

    private static void registerDimensionTypes() {
        FIRE = DimensionType.register(ElementalCraft.MOD_ID, "ec", Config.fireDimensionID, WorldProviderFire.class, false);
        AIR = DimensionType.register(ElementalCraft.MOD_ID, "ec", Config.airDimensionID, WorldProviderAir.class, false);
        EARTH = DimensionType.register(ElementalCraft.MOD_ID, "ec", Config.earthDimensionID, WorldProviderEarth.class, false);
        WATER = DimensionType.register(ElementalCraft.MOD_ID, "ec", Config.waterDimensionID, WorldProviderWater.class, false);
    }

    private static void registerDimensions() {

        DimensionManager.registerDimension(Config.fireDimensionID, FIRE);
        DimensionManager.registerDimension(Config.airDimensionID, AIR);
        DimensionManager.registerDimension(Config.earthDimensionID, EARTH);
        DimensionManager.registerDimension(Config.waterDimensionID, WATER);
    }
}
