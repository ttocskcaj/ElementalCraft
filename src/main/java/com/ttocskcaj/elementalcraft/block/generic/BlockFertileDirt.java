package com.ttocskcaj.elementalcraft.block.generic;

import com.ttocskcaj.elementalcraft.ElementalCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFertileDirt extends Block {

    public BlockFertileDirt(){
        super(Material.GROUND);
        setUnlocalizedName("fertile_dirt");
        setRegistryName("fertile_dirt");
        setCreativeTab(ElementalCraft.creativeTab);
        setHardness(0.5f);
        setHarvestLevel("shovel", 0);
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.SOLID;
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
