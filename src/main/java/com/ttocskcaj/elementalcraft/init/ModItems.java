package com.ttocskcaj.elementalcraft.init;

import com.ttocskcaj.elementalcraft.item.ItemCrescentWand;
import com.ttocskcaj.elementalcraft.item.ItemElementalFragment;
import com.ttocskcaj.elementalcraft.item.ItemRingOfTheElements;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {

    public static final ItemElementalFragment ITEM_ELEMENTAL_FRAGMENT = new ItemElementalFragment();
    public static final ItemCrescentWand ITEM_CRESCENT_WAND = new ItemCrescentWand();
    public static final ItemRingOfTheElements ITEM_RING_OF_THE_ELEMENTS = new ItemRingOfTheElements();


    @SideOnly(Side.CLIENT)
    public static void initModels() {
        ITEM_ELEMENTAL_FRAGMENT.initModel();
        ITEM_CRESCENT_WAND.initModel();
        ITEM_RING_OF_THE_ELEMENTS.initModel();
    }
}
