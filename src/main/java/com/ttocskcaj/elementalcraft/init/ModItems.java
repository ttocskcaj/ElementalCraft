package com.ttocskcaj.elementalcraft.init;

import com.ttocskcaj.elementalcraft.item.magical.ItemGoldAthame;
import com.ttocskcaj.elementalcraft.item.magical.ItemPentacle;
import com.ttocskcaj.elementalcraft.item.magical.ItemWandCitrine;
import com.ttocskcaj.elementalcraft.item.materials.*;
import com.ttocskcaj.elementalcraft.item.tools.ItemCrescentWand;
import com.ttocskcaj.elementalcraft.item.magical.ItemRingOfTheElements;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {

    // Magic
    public static final ItemRingOfTheElements ITEM_RING_OF_THE_ELEMENTS = new ItemRingOfTheElements();
    public static final ItemPentacle ITEM_PENTACLE = new ItemPentacle();
    public static final ItemGoldAthame ITEM_GOLD_ATHAME = new ItemGoldAthame();
    public static final ItemWandCitrine ITEM_WAND_CITRINE = new ItemWandCitrine();

    // Materials
    public static final ItemAetherShard ITEM_AETHER_FRAGMENT = new ItemAetherShard();
    public static final ItemAetherDust ITEM_AETHER_DUST = new ItemAetherDust();
    public static final ItemCitrineGem ITEM_CITRINE_GEM = new ItemCitrineGem();
    public static final ItemFluoriteGem ITEM_FLUORITE_GEM = new ItemFluoriteGem();
    public static final ItemSolidifiedEnergyShardAir ITEM_SOLIDIFIED_ENERGY_SHARD_AIR = new ItemSolidifiedEnergyShardAir();
    public static final ItemSolidifiedEnergyShardEarth ITEM_SOLIDIFIED_ENERGY_SHARD_EARTH = new ItemSolidifiedEnergyShardEarth();
    public static final ItemSolidifiedEnergyShardFire ITEM_SOLIDIFIED_ENERGY_SHARD_FIRE = new ItemSolidifiedEnergyShardFire();
    public static final ItemSolidifiedEnergyShardWater ITEM_SOLIDIFIED_ENERGY_SHARD_WATER = new ItemSolidifiedEnergyShardWater();

    // Tools
    public static final ItemCrescentWand ITEM_CRESCENT_WAND = new ItemCrescentWand();


    @SideOnly(Side.CLIENT)
    public static void initModels() {
        // Magic
        ITEM_RING_OF_THE_ELEMENTS.initModel();
        ITEM_PENTACLE.initModel();
        ITEM_GOLD_ATHAME.initModel();
        ITEM_WAND_CITRINE.initModel();

        // Materials
        ITEM_AETHER_FRAGMENT.initModel();
        ITEM_AETHER_DUST.initModel();
        ITEM_CITRINE_GEM.initModel();
        ITEM_FLUORITE_GEM.initModel();
        ITEM_SOLIDIFIED_ENERGY_SHARD_AIR.initModel();
        ITEM_SOLIDIFIED_ENERGY_SHARD_FIRE.initModel();
        ITEM_SOLIDIFIED_ENERGY_SHARD_EARTH.initModel();
        ITEM_SOLIDIFIED_ENERGY_SHARD_WATER.initModel();

        // Tools
        ITEM_CRESCENT_WAND.initModel();
    }
}
