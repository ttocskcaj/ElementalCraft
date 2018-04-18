package com.ttocskcaj.elementalcraft.init;

import com.ttocskcaj.elementalcraft.ElementalCraft;
import com.ttocskcaj.elementalcraft.world.fire.WorldProviderFire;
import com.ttocskcaj.elementalcraft.util.Config;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class ModDimensions {

    public static DimensionType FIRE;

    public static void init() {
        registerDimensionTypes();
        registerDimensions();
    }

    private static void registerDimensionTypes() {
        FIRE = DimensionType.register(ElementalCraft.MOD_ID, "ec", Config.fireDimensionID, WorldProviderFire.class, false);
    }

    private static void registerDimensions() {

        DimensionManager.registerDimension(Config.fireDimensionID, FIRE);
    }
}
