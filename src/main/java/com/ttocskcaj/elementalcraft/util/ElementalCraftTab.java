package com.ttocskcaj.elementalcraft.util;

import com.ttocskcaj.elementalcraft.ElementalCraft;
import com.ttocskcaj.elementalcraft.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ElementalCraftTab extends CreativeTabs {
    public ElementalCraftTab() {
        super(ElementalCraft.MOD_ID);    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItems.CRESCENT_WAND);
    }
}
