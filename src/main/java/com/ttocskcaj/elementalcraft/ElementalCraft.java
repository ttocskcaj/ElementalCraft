package com.ttocskcaj.elementalcraft;

import com.ttocskcaj.elementalcraft.command.TeleportCommand;
import com.ttocskcaj.elementalcraft.proxy.CommonProxy;
import com.ttocskcaj.elementalcraft.util.ElementalCraftTab;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = ElementalCraft.MOD_ID, name = ElementalCraft.MOD_NAME, version = ElementalCraft.MOD_VERSION, acceptedMinecraftVersions = ElementalCraft.ACCEPTED_VERSIONS)
public class ElementalCraft {
    public static final String MOD_ID = "elementalcraft";
    public static final String MOD_NAME = "ElementalCraft";
    public static final String MOD_VERSION = "0.1.0-dev";
    public static final String ACCEPTED_VERSIONS = "[1.12.2]";

    @Mod.Instance
    public static ElementalCraft instance;

    @SidedProxy(clientSide = "com.ttocskcaj.elementalcraft.proxy.ClientProxy", serverSide = "com.ttocskcaj.elementalcraft.proxy.ServerProxy")
    public static CommonProxy proxy;

    public static Logger logger;
    public static final ElementalCraftTab creativeTab = new ElementalCraftTab();


    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("Initializing...");
        proxy.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        event.registerServerCommand(new TeleportCommand());
    }
}
