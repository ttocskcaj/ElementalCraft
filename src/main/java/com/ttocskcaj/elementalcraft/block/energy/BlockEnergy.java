package com.ttocskcaj.elementalcraft.block.energy;

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
import net.minecraftforge.oredict.OreDictionary;


public class BlockEnergy extends BlockMultiBase implements IHasModels, IGetsInitialized {
    public static final PropertyEnum<Type> VARIANT = PropertyEnum.create("type", Type.class);
    public static ItemStack energyAether;
    public static ItemStack energyAir;
    public static ItemStack energyEarth;
    public static ItemStack energyFire;
    public static ItemStack energyWater;

    public BlockEnergy() {
        super(Material.IRON);
        setUnlocalizedName("block_energy");
        setHardness(2.5F);
        setResistance(2F);
        setSoundType(SoundType.METAL);

        setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, Type.AETHER));

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

    @Override
    @SideOnly(Side.CLIENT)
    public void registerModels() {
        for (int i = 0; i < Type.values().length; i++) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), i, new ModelResourceLocation(getRegistryName(), "type=" + Type.byMetadata(i).getName()));
        }
    }

    @Override
    public boolean preInit() {
        this.setRegistryName("block_energy");
        ForgeRegistries.BLOCKS.register(this);

        ItemBlockMulti itemBlock = new ItemBlockMulti(this);
        itemBlock.setRegistryName(this.getRegistryName());
        ForgeRegistries.ITEMS.register(itemBlock);

        energyAether = new ItemStack(this, 1, Type.AETHER.getMetadata());
        energyAir = new ItemStack(this, 1, Type.AIR.getMetadata());
        energyEarth = new ItemStack(this, 1, Type.EARTH.getMetadata());
        energyFire = new ItemStack(this, 1, Type.FIRE.getMetadata());
        energyWater = new ItemStack(this, 1, Type.WATER.getMetadata());

        OreDictionary.registerOre("blockAetherEnergy", energyAether);
        OreDictionary.registerOre("blockAirEnergy", energyAir);
        OreDictionary.registerOre("blockEarthEnergy", energyEarth);
        OreDictionary.registerOre("blockFireEnergy", energyFire);
        OreDictionary.registerOre("blockWaterEnergy", energyWater);


        return true;
    }

    @Override
    public boolean init() {
        return true;
    }


    public enum Type implements IStringSerializable {
        AETHER(0, "aether"),
        AIR(1, "air"),
        EARTH(2, "earth"),
        FIRE(3, "fire"),
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
