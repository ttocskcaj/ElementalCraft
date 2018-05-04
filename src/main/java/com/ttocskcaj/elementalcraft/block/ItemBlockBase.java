package com.ttocskcaj.elementalcraft.block;

import com.ttocskcaj.elementalcraft.block.energy.BlockEnergy;
import com.ttocskcaj.elementalcraft.block.metal.BlockMetal;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockBase extends ItemBlock {
    public ItemBlockBase(Block block) {
        super(block);
        setHasSubtypes(true);
        setMaxDamage(0);
        setNoRepair();
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        switch (getRegistryName().toString()) {
            case "elementalcraft:metal_block":
                return "tile.metal." + BlockMetal.Type.byMetadata(stack.getMetadata()).getName();

            case "elementalcraft:energy_block":
                return "tile.energy." + BlockEnergy.Type.byMetadata(stack.getMetadata()).getName();
        }
        return "unknown";
    }

}
