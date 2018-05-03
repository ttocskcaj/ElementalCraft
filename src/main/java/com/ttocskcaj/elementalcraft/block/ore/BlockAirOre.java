package com.ttocskcaj.elementalcraft.block.ore;

import com.ttocskcaj.elementalcraft.block.BlockBase;
import com.ttocskcaj.elementalcraft.init.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class BlockAirOre extends BlockBase {
    public static final PropertyEnum<Type> VARIANT = PropertyEnum.create("type", Type.class);
    public static ItemStack oreCitrine;
    public static ItemStack oreAzurite;
    public static ItemStack oreIron;
    public static ItemStack oreTin;
    public static ItemStack oreAirEnergy;

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        IBlockState newState = getStateFromMeta(stack.getMetadata());
        worldIn.setBlockState(pos, newState);
    }

    public BlockAirOre() {
        super(Material.ROCK);
        setUnlocalizedName("air_ore");
        setHardness(3.0F);
        setResistance(5.0F);

        setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, Type.CITRINE));

        setHarvestLevel("pickaxe", 1, getStateFromMeta(Type.CITRINE.getMetadata()));
        setHarvestLevel("pickaxe", 1, getStateFromMeta(Type.AZURITE.getMetadata()));
        setHarvestLevel("pickaxe", 1, getStateFromMeta(Type.IRON.getMetadata()));
        setHarvestLevel("pickaxe", 1, getStateFromMeta(Type.TIN.getMetadata()));
        setHarvestLevel("pickaxe", 2, getStateFromMeta(Type.AIR_ENERGY.getMetadata()));
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

    /* TYPE METHODS */
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
    public void initModels() {
        for (int i = 0; i < Type.values().length; i++) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), i, new ModelResourceLocation(getRegistryName(), "type=" + Type.byMetadata(i).getName()));
        }
    }

    public boolean preInit() {
        this.setRegistryName("air_ore");
        ForgeRegistries.BLOCKS.register(this);

        ItemBlockOre itemBlock = new ItemBlockOre(this);
        itemBlock.setRegistryName(this.getRegistryName());
        ForgeRegistries.ITEMS.register(itemBlock);

        oreCitrine = new ItemStack(this, 1, Type.CITRINE.getMetadata());
        oreAzurite = new ItemStack(this, 1, Type.AZURITE.getMetadata());
        oreIron = new ItemStack(this, 1, Type.IRON.getMetadata());
        oreTin = new ItemStack(this, 1, Type.TIN.getMetadata());
        oreAirEnergy = new ItemStack(this, 1, Type.AIR_ENERGY.getMetadata());

        OreDictionary.registerOre("oreBloodstone", oreCitrine);
        OreDictionary.registerOre("oreGarnet", oreAzurite);
        OreDictionary.registerOre("oreGold", oreIron);
        OreDictionary.registerOre("oreNickel", oreTin);
        OreDictionary.registerOre("oreFireEnergy", oreAirEnergy);


        return true;
    }

    public boolean init() {
        FurnaceRecipes.instance().addSmeltingRecipe(oreIron, new ItemStack(Items.IRON_INGOT), 0.5f);
//        FurnaceRecipes.instance().addSmeltingRecipe(oreNickel, new ItemStack(ModItems.LE), 0.5f); TODO: Tin ingot.

        return true;
    }


    public enum Type implements IStringSerializable {
        CITRINE(0, "citrine"),
        AZURITE(1, "azurite"),
        IRON(2, "iron"),
        TIN(3, "tin"),
        AIR_ENERGY(4, "air_energy");

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
