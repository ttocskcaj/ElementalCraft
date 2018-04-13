package com.ttocskcaj.elementalcraft.block.elementalblocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockElementalEarthBlock extends Block {

    public BlockElementalEarthBlock(){
        super(Material.ROCK);
        setUnlocalizedName("elemental_earth_block");
        setRegistryName("elemental_earth_block");
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.SOLID;
    }
}
