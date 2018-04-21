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

public class BlockAsh extends Block {

    public BlockAsh(){
        super(Material.ROCK);
        setUnlocalizedName("ash_block");
        setRegistryName("ash_block");
        setCreativeTab(ElementalCraft.creativeTab);
        setHardness(1f);
        setResistance(3f);
        setHarvestLevel("pickaxe", 0);
//        setLightLevel(0.01f);
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
