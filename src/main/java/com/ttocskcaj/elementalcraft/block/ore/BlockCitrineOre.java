package com.ttocskcaj.elementalcraft.block.ore;

import com.ttocskcaj.elementalcraft.ElementalCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCitrineOre extends Block {

    public BlockCitrineOre(){
        super(Material.ROCK);
        setUnlocalizedName("citrine_ore");
        setRegistryName("citrine_ore");
        setCreativeTab(ElementalCraft.creativeTab);
        setHardness(4f);
        setResistance(5f);
        setHarvestLevel("pickaxe", 2);
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
