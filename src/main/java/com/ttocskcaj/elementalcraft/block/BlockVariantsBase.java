package com.ttocskcaj.elementalcraft.block;


import com.ttocskcaj.elementalcraft.ElementalCraft;
import com.ttocskcaj.elementalcraft.block.ore.BlockAirOre;
import com.ttocskcaj.elementalcraft.block.ore.BlockEarthOre;
import com.ttocskcaj.elementalcraft.block.ore.BlockFireOre;
import com.ttocskcaj.elementalcraft.block.ore.BlockWaterOre;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockVariantsBase extends Block {
    public BlockVariantsBase(Material materialIn) {
        super(materialIn);
        setCreativeTab(ElementalCraft.creativeTab);
    }
    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        IBlockState newState = getStateFromMeta(stack.getMetadata());
        worldIn.setBlockState(pos, newState);
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random) {
        if (fortune > 0) {
            int i = random.nextInt(fortune + 2) - 1;
            if (i < 0) {
                i = 0;
            }

            return this.quantityDropped(random) * (i + 1);
        } else {
            return this.quantityDropped(random);
        }
    }

    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
        if(this instanceof BlockAirOre || this instanceof BlockEarthOre || this instanceof BlockFireOre || this instanceof BlockWaterOre){
            Random rand = world instanceof World ? ((World) world).rand : new Random();
            return MathHelper.getInt(rand, 1, 3);
        }
        return 0;
    }
}
