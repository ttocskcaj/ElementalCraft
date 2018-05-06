package com.ttocskcaj.elementalcraft.block.generic;

import com.ttocskcaj.elementalcraft.block.BlockMultiBase;
import com.ttocskcaj.elementalcraft.block.ItemBlockMulti;
import com.ttocskcaj.elementalcraft.util.IGetsInitialized;
import com.ttocskcaj.elementalcraft.util.IHasModels;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class BlockStone extends BlockMultiBase implements IGetsInitialized, IHasModels {
    public static final PropertyEnum<Type> VARIANT = PropertyEnum.create("type", Type.class);
    public static ItemStack stoneCharred;
    public static ItemStack stoneEarth;
    public static ItemStack stoneFire;
    public static ItemStack stoneRarefied;
    public static ItemStack stoneWater;

    public BlockStone() {
        super(Material.ROCK);
        setUnlocalizedName("stone");
        setHardness(2.5F);
        setResistance(2F);
        setSoundType(SoundType.STONE);

        setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, Type.RAREFIED));

        setHarvestLevel("pickaxe", 0);
    }
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, VARIANT);
    }

    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> items) {
        for (int i = 0; i < Type.METADATA_LOOKUP.length; i++) {
            items.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(VARIANT, Type.byMetadata(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(VARIANT).getMetadata();
    }

    @Override
    public int damageDropped(IBlockState state) {
        return state.getValue(VARIANT).getMetadata();
    }

    @SideOnly(Side.CLIENT)
    public void registerModels() {
        for (int i = 0; i < Type.values().length; i++) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), i, new ModelResourceLocation(getRegistryName(), "type=" + Type.byMetadata(i).getName()));
        }
    }

    @Override
    public boolean preInit() {
        this.setRegistryName("stone");
        ForgeRegistries.BLOCKS.register(this);

        ItemBlockMulti itemBlock = new ItemBlockMulti(this);
        itemBlock.setRegistryName(this.getRegistryName());
        ForgeRegistries.ITEMS.register(itemBlock);

        stoneCharred = new ItemStack(this, 1, Type.CHARRED.getMetadata());
        stoneEarth = new ItemStack(this, 1, Type.EARTH.getMetadata());
        stoneFire = new ItemStack(this, 1, Type.FIRE.getMetadata());
        stoneRarefied = new ItemStack(this, 1, Type.RAREFIED.getMetadata());
        stoneWater = new ItemStack(this, 1, Type.WATER.getMetadata());

        return true;
    }

    @Override
    public boolean init() {
        return true;
    }


    public enum Type implements IStringSerializable {
        CHARRED(0, "charred"),
        EARTH(1, "earth"),
        FIRE(2, "fire"),
        RAREFIED(3, "rarefied"),
        WATER(4, "water");

        private static final Type[] METADATA_LOOKUP = new Type[values().length];
        private final int metadata;
        private final String name;

        Type(int metadata, String name) {
            this.metadata = metadata;
            this.name = name;
        }

        public int getMetadata() {

            return this.metadata;
        }

        @Override
        public String getName() {

            return this.name;
        }

        public static Type byMetadata(int metadata) {

            if (metadata < 0 || metadata >= METADATA_LOOKUP.length) {
                metadata = 0;
            }
            return METADATA_LOOKUP[metadata];
        }

        static {
            for (Type type : values()) {
                METADATA_LOOKUP[type.getMetadata()] = type;
            }
        }
    }

}
