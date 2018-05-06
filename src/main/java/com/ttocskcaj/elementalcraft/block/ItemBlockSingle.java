package com.ttocskcaj.elementalcraft.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBlockSingle extends ItemBlock {
    public ItemBlockSingle(Block block) {
        super(block);
        setHasSubtypes(false);
        setMaxDamage(0);
        setNoRepair();
    }
}
