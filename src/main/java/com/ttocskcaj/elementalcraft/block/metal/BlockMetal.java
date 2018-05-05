package com.ttocskcaj.elementalcraft.block.metal;

import com.ttocskcaj.elementalcraft.block.BlockVariantsBase;
import com.ttocskcaj.elementalcraft.block.ItemBlockBase;
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
import net.minecraftforge.oredict.OreDictionary;


public class BlockMetal extends BlockVariantsBase implements IGetsInitialized, IHasModels {
    public static final PropertyEnum<Type> VARIANT = PropertyEnum.create("type", Type.class);
    public static ItemStack metalLead;
    public static ItemStack metalNickel;
    public static ItemStack metalSilver;
    public static ItemStack metalSteel;
    public static ItemStack metalTin;

    public BlockMetal() {
        super(Material.IRON);
        setUnlocalizedName("metal_block");
        setHardness(2.5F);
        setResistance(2F);
        setSoundType(SoundType.METAL);

        setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, Type.LEAD));

        setHarvestLevel("pickaxe", 1);
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
        this.setRegistryName("metal_block");
        ForgeRegistries.BLOCKS.register(this);

        ItemBlockBase itemBlock = new ItemBlockBase(this);
        itemBlock.setRegistryName(this.getRegistryName());
        ForgeRegistries.ITEMS.register(itemBlock);

        metalLead = new ItemStack(this, 1, Type.LEAD.getMetadata());
        metalNickel = new ItemStack(this, 1, Type.NICKEL.getMetadata());
        metalSilver = new ItemStack(this, 1, Type.SILVER.getMetadata());
        metalSteel = new ItemStack(this, 1, Type.STEEL.getMetadata());
        metalTin = new ItemStack(this, 1, Type.TIN.getMetadata());

        OreDictionary.registerOre("blockLead", metalLead);
        OreDictionary.registerOre("blockNickel", metalNickel);
        OreDictionary.registerOre("blockSilver", metalSilver);
        OreDictionary.registerOre("blockSteel", metalSteel);
        OreDictionary.registerOre("blockTin", metalTin);


        return true;
    }

    @Override
    public boolean init() {
        return true;
    }


    public enum Type implements IStringSerializable {
        LEAD(0, "lead"),
        NICKEL(1, "nickel"),
        SILVER(2, "silver"),
        STEEL(3, "steel"),
        TIN(4, "tin");

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
