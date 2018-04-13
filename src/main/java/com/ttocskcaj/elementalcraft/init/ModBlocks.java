package com.ttocskcaj.elementalcraft.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import java.util.ArrayList;

public class ModAssets {
    public static final  ArrayList<Item> items = new ArrayList<>();
    public static final ArrayList<Block> blocks = new ArrayList<>();
    public static final ArrayList<ItemBlock> itemBlocks = new ArrayList<>();


    public static void addBlock(Block block){
        blocks.add(block);
        ItemBlock itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName(block.getRegistryName());
        itemBlocks.add(itemBlock);
    }
}
