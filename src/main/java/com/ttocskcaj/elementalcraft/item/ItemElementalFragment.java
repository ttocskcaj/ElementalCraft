package com.ttocskcaj.elementalcraft.item;

import com.ttocskcaj.elementalcraft.ElementalCraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemElementalFragment extends Item {
    public ItemElementalFragment() {
        setRegistryName("elemental_fragment");
        setUnlocalizedName("elemental_fragment");
        setCreativeTab(ElementalCraft.creativeTab);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}