package com.ttocskcaj.elementalcraft.item.materials;

import com.ttocskcaj.elementalcraft.ElementalCraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBeryl extends Item {
    public ItemBeryl() {
        setRegistryName("beryl");
        setUnlocalizedName("beryl");
        setCreativeTab(ElementalCraft.creativeTab);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
