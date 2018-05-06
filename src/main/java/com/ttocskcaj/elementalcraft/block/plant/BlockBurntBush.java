package com.ttocskcaj.elementalcraft.block.plant;


import com.ttocskcaj.elementalcraft.ElementalCraft;
import com.ttocskcaj.elementalcraft.block.ItemBlockSingle;
import com.ttocskcaj.elementalcraft.block.generic.BlockStone;
import com.ttocskcaj.elementalcraft.init.ModBlocks;
import com.ttocskcaj.elementalcraft.util.IGetsInitialized;
import com.ttocskcaj.elementalcraft.util.IHasModels;
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
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.ttocskcaj.elementalcraft.block.generic.BlockStone.VARIANT;


public class BlockBurntBush extends BlockBush implements IHasModels, IGetsInitialized {

    public BlockBurntBush(){
        super(Material.PLANTS);
        setUnlocalizedName("burnt_bush");
        setRegistryName("burnt_bush");
        setCreativeTab(ElementalCraft.creativeTab);
    }
    @Override
    protected boolean canSustainBush(IBlockState state) {
        return state.getBlock() == ModBlocks.ash || state.getBlock() == ModBlocks.stone.getDefaultState().withProperty(VARIANT, BlockStone.Type.FIRE);
    }


    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
        entityIn.attackEntityFrom(DamageSource.ON_FIRE, 2F);
    }

    @Override
    public boolean preInit() {
        ForgeRegistries.BLOCKS.register(this);
        ItemBlockSingle itemBlock = new ItemBlockSingle(this);
        itemBlock.setRegistryName(this.getRegistryName());
        ForgeRegistries.ITEMS.register(itemBlock);

        return true;
    }

    @Override
    public boolean init() {
        return true;
    }

    @Override
    public void registerModels() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
