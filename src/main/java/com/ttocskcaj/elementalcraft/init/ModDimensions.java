package com.ttocskcaj.elementalcraft.init;

import com.ttocskcaj.elementalcraft.ElementalCraft;
import com.ttocskcaj.elementalcraft.dimension.WorldProviderEP;
import com.ttocskcaj.elementalcraft.util.Config;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class ModDimensions {

    public static DimensionType ELEMENTAL_PLANE;

    public static void init() {
        registerDimensionTypes();
        registerDimensions();
    }

    private static void registerDimensionTypes() {
        ELEMENTAL_PLANE = DimensionType.register(ElementalCraft.MOD_ID, "ec", Config.dimensionID, WorldProviderEP.class, false);
    }

    private static void registerDimensions() {

        DimensionManager.registerDimension(Config.dimensionID, ELEMENTAL_PLANE);
    }
}
