package com.ttocskcaj.elementalcraft.init;

import com.ttocskcaj.elementalcraft.ElementalCraft;
import com.ttocskcaj.elementalcraft.item.ItemMaterial;
import com.ttocskcaj.elementalcraft.item.magical.ItemGoldAthame;
import com.ttocskcaj.elementalcraft.item.magical.ItemPentacle;
import com.ttocskcaj.elementalcraft.item.magical.ItemWandCitrine;
import com.ttocskcaj.elementalcraft.item.tools.ItemChalice;
import com.ttocskcaj.elementalcraft.item.tools.ItemCrescentWand;
import com.ttocskcaj.elementalcraft.item.magical.ItemRingOfTheElements;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
    public static ItemMaterial itemMaterial;

    // Magic
    public static final ItemRingOfTheElements RING_OF_THE_ELEMENTS = new ItemRingOfTheElements();
    public static final ItemPentacle PENTACLE = new ItemPentacle();
    public static final ItemGoldAthame GOLD_ATHAME = new ItemGoldAthame();
    public static final ItemWandCitrine WAND_CITRINE = new ItemWandCitrine();

    // Tools
    public static final ItemCrescentWand CRESCENT_WAND = new ItemCrescentWand();
    public static final ItemChalice CHALICE = new ItemChalice();

    public static void preInit(){
        itemMaterial = new ItemMaterial();
        itemMaterial.preInit();
    }
    public static void init(){
        itemMaterial.init();
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        itemMaterial.registerModels();

        // Magic
        PENTACLE.initModel();
        GOLD_ATHAME.initModel();
        RING_OF_THE_ELEMENTS.initModel();
        WAND_CITRINE.initModel();

        // Tools
        CRESCENT_WAND.initModel();
        CHALICE.initModel();
    }

    public static void register(IForgeRegistry<Item> registry) {
        ElementalCraft.logger.info("Registering Items");

        // Magic
        registry.register(RING_OF_THE_ELEMENTS);
        registry.register(PENTACLE);
        registry.register(GOLD_ATHAME);
        registry.register(WAND_CITRINE);

        // Tools
        registry.register(CRESCENT_WAND);
    }
}
