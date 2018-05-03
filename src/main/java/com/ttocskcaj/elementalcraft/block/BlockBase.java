package com.ttocskcaj.elementalcraft.block;


import com.ttocskcaj.elementalcraft.ElementalCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBase extends Block {
    public BlockBase(Material materialIn) {
        super(materialIn);
        setCreativeTab(ElementalCraft.creativeTab);

    }
}
