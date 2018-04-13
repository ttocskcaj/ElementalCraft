package com.ttocskcaj.elementalcraft.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemElementalFragment extends Item {
    public ItemElementalFragment() {
        setRegistryName("elemental_fragment");
        setUnlocalizedName("elementalcraft.elemental_fragment");
        setCreativeTab(CreativeTabs.MISC);

    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
