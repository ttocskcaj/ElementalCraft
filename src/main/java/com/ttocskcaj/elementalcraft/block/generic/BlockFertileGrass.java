package com.ttocskcaj.elementalcraft.block.generic;

import com.ttocskcaj.elementalcraft.block.BlockSingleBase;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IPlantable;

public class BlockFertileGrass extends BlockSingleBase {

    public BlockFertileGrass() {
        super("fertile_grass", Material.GRASS);
        setHardness(0.6f);
        setHarvestLevel("shovel", 0);
        setSoundType(SoundType.GROUND);
    }

    @Override
    public boolean canSustainPlant(IBlockState blockStateIn, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantIn) {
        IBlockState plantBlockState = plantIn.getPlant(world, pos.offset(direction));
        net.minecraftforge.common.EnumPlantType plantType = plantIn.getPlantType(world, pos.offset(direction));
        if (plantBlockState.getBlock() == Blocks.REEDS) {
            return true;
        }
        if (plantIn instanceof BlockBush) {
            return true;
        }
        switch (plantType) {
            case Desert:
                return false;
            case Nether:
                return false;
            case Crop:
                return false;
            case Cave:
                return false;
            case Plains:
                return true;
            case Water:
                return false;
            case Beach:
                return true;
        }

        return false;
    }
}
