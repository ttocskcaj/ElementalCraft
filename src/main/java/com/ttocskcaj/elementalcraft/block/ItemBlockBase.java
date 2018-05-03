package com.ttocskcaj.elementalcraft.block;

import com.ttocskcaj.elementalcraft.block.ore.BlockAirOre;
import com.ttocskcaj.elementalcraft.block.ore.BlockEarthOre;
import com.ttocskcaj.elementalcraft.block.ore.BlockFireOre;
import com.ttocskcaj.elementalcraft.block.ore.BlockWaterOre;
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
            case "elementalcraft:air_ore":
                return "tile.ore." + BlockAirOre.Type.byMetadata(stack.getMetadata()).getName();

            case "elementalcraft:earth_ore":
                return "tile.ore." + BlockEarthOre.Type.byMetadata(stack.getMetadata()).getName();

            case "elementalcraft:fire_ore":
                return "tile.ore." + BlockFireOre.Type.byMetadata(stack.getMetadata()).getName();

            case "elementalcraft:water_ore":
                return "tile.ore." + BlockWaterOre.Type.byMetadata(stack.getMetadata()).getName();
        }
        return null;
    }

}
