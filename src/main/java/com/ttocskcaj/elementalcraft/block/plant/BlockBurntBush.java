package com.ttocskcaj.elementalcraft.block.plant;


import com.ttocskcaj.elementalcraft.ElementalCraft;
import com.ttocskcaj.elementalcraft.init.ModBlocks;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class BlockBurntBush extends BlockBush {

    public BlockBurntBush(){
        super(Material.PLANTS);
        setUnlocalizedName("burnt_bush");
        setRegistryName("burnt_bush");
        setCreativeTab(ElementalCraft.creativeTab);
    }
    @Override
    protected boolean canSustainBush(IBlockState state) {
        return state.getBlock() == ModBlocks.ASH_BLOCK || state.getBlock() == ModBlocks.FIRE_STONE;
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
        entityIn.attackEntityFrom(DamageSource.ON_FIRE, 2F);
    }

}
