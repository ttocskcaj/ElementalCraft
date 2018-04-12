package com.ttocskcaj.elementalcraft;

import com.ttocskcaj.elementalcraft.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = ElementalCraft.MOD_ID, name = ElementalCraft.MOD_NAME, version = ElementalCraft.MOD_VERSION, acceptedMinecraftVersions = ElementalCraft.ACCEPTED_VERSIONS)
public class ElementalCraft {
    static final String MOD_ID = "elementalcraft";
    static final String MOD_NAME = "ElementalCraft";
    static final String MOD_VERSION = "0.1.0-dev";
    static final String ACCEPTED_VERSIONS = "[1.12.2]";

    @Mod.Instance
    public static ElementalCraft instance;

    @SidedProxy(clientSide = "com.ttocskcaj.elementalcraft.proxy.ClientProxy", serverSide = "com.ttocskcaj.elementalcraft.proxy.ServerProxy")
    public static CommonProxy proxy;

    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("Initializing...");
        proxy.init();
    }
}
