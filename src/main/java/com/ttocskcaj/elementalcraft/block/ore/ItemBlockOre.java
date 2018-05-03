package com.ttocskcaj.elementalcraft.block.ore;

import com.ttocskcaj.elementalcraft.block.ItemBlockBase;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ItemBlockOre extends ItemBlockBase {
    public ItemBlockOre(Block block) {
        super(block);
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

            case "elementalcraft:ore":
                return "tile.ore." + BlockOverworldOre.Type.byMetadata(stack.getMetadata()).getName();
        }
        return null;
    }
}
