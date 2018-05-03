package com.ttocskcaj.elementalcraft.block.machine;

import com.ttocskcaj.elementalcraft.ElementalCraft;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class BlockMachineBase extends BlockContainer {
    protected static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    public BlockMachineBase() {
        super(Material.IRON);
        setCreativeTab(ElementalCraft.creativeTab);
        setDefaultState(blockState.getBaseState().withProperty(
                FACING, EnumFacing.NORTH));
        setTickRandomly(false);
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        System.out.println("Block activated");
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
//        return new TileEntityGrinder();
        return null;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        // Rotate block to face player
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getAdjustedHorizontalFacing().getOpposite()), 2);
    }

    /**
     * Get items in inventory and drop them.
     */
    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
//        TileEntity tileentity = worldIn.getTileEntity(pos);
//
//            if (tileentity instanceof TileEntityGrinder)
//            {
//                InventoryHelper.dropInventoryItems(worldIn, pos,
//                        (TileEntityGrinder)tileentity);
//                worldIn.updateComparatorOutputLevel(pos, this);
//            }
        super.breakBlock(worldIn, pos, state);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return (state.getValue(FACING)).getIndex();
    }


    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @SideOnly(Side.CLIENT)
    static final class SwitchEnumFacing {
        static final int[] enumFacingArray = new int[EnumFacing.values().length];

        static {
            enumFacingArray[EnumFacing.WEST.ordinal()] = 1;
            enumFacingArray[EnumFacing.EAST.ordinal()] = 2;
            enumFacingArray[EnumFacing.NORTH.ordinal()] = 3;
            enumFacingArray[EnumFacing.SOUTH.ordinal()] = 4;

        }
    }
}
