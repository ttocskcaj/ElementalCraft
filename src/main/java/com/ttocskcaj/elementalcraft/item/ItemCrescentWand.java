package com.ttocskcaj.elementalcraft.item;

import com.ttocskcaj.elementalcraft.ElementalCraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCrescentWand extends Item {
    public ItemCrescentWand() {
        setRegistryName("crescentwand");
        setUnlocalizedName("crescentwand");
        setCreativeTab(ElementalCraft.creativeTab);

    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
