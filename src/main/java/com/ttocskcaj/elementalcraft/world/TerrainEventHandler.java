package com.ttocskcaj.elementalcraft.world;

import net.minecraftforge.event.terraingen.WorldTypeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TerrainEventHandler {
    @SubscribeEvent
    public static void initBiomeGens(WorldTypeEvent.InitBiomeGens event) {
        System.out.println("Init biome gens");
        System.out.println(event);
    }
}
