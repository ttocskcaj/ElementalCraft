package com.ttocskcaj.elementalcraft.util;

import com.ttocskcaj.elementalcraft.ElementalCraft;
import com.ttocskcaj.elementalcraft.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;

public class Config {
    private static final String CATEGORY_GENERAL = "general";
    private static final String CATEGORY_DIMENSIONS = "dimensions";

    // Config values.
    public static String test = "test";
    public static int dimensionID = 50;
    public static String dimensionSeed = "";

    // Call this from CommonProxy.preInit(). It will create our config if it doesn't
    // exist yet and read the values if it does exist.
    public static void readConfig() {
        Configuration cfg = CommonProxy.config;
        try {
            cfg.load();
            initGeneralConfig(cfg);
            initDimensionConfig(cfg);
        } catch (Exception e1) {
            ElementalCraft.logger.error("Problem loading config file!", e1);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    private static void initGeneralConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");
        // cfg.getBoolean() will get the value in the config if it is already specified there. If not it will create the value.

        test = cfg.getString("test", Config.CATEGORY_GENERAL, "test", "A test config var.");
    }

    private static void initDimensionConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_DIMENSIONS, "Dimension configuration");
        dimensionID = cfg.getInt("dimension_id",Config.CATEGORY_DIMENSIONS, 50, 2, 1024,"The ID for the Elemental Plane world.");
        dimensionSeed = cfg.getString("dimension_id",Config.CATEGORY_DIMENSIONS, "","Enter a seed for the Elemental Plane here, or leave blank to use world seed.");
    }
}
