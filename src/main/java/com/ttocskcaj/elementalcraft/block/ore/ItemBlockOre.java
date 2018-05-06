package com.ttocskcaj.elementalcraft.block.ore;

import com.ttocskcaj.elementalcraft.block.ItemBlockMulti;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ItemBlockOre extends ItemBlockMulti {
    public ItemBlockOre(Block block) {
        super(block);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        switch (getRegistryName().toString()) {
            case "elementalcraft:ore_air":
                return "tile.ore." + BlockAirOre.Type.byMetadata(stack.getMetadata()).getName();

            case "elementalcraft:ore_earth":
                return "tile.ore." + BlockEarthOre.Type.byMetadata(stack.getMetadata()).getName();

            case "elementalcraft:ore_fire":
                return "tile.ore." + BlockFireOre.Type.byMetadata(stack.getMetadata()).getName();

            case "elementalcraft:ore_water":
                return "tile.ore." + BlockWaterOre.Type.byMetadata(stack.getMetadata()).getName();

            case "elementalcraft:ore":
                return "tile.ore." + BlockOverworldOre.Type.byMetadata(stack.getMetadata()).getName();
        }
        return null;
    }
}
