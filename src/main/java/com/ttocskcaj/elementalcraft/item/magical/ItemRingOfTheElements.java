package com.ttocskcaj.elementalcraft.item.magical;

import com.ttocskcaj.elementalcraft.ElementalCraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemRingOfTheElements extends Item {
    public ItemRingOfTheElements() {
        setRegistryName("ring_of_the_elements");
        setUnlocalizedName("ring_of_the_elements");
        setCreativeTab(ElementalCraft.creativeTab);

    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
