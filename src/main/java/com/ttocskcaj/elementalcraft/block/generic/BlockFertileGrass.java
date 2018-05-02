package com.ttocskcaj.elementalcraft.block.generic;

import com.ttocskcaj.elementalcraft.ElementalCraft;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFertileGrass extends Block {

    public BlockFertileGrass() {
        super(Material.GRASS);
        setUnlocalizedName("fertile_grass");
        setRegistryName("fertile_grass");
        setCreativeTab(ElementalCraft.creativeTab);
        setHardness(0.6f);
        setHarvestLevel("shovel", 0);
        setSoundType(SoundType.GROUND);
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.SOLID;
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
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
