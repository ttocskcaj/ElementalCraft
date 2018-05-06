package com.ttocskcaj.elementalcraft.block.ore;

import com.ttocskcaj.elementalcraft.block.BlockMultiBase;
import com.ttocskcaj.elementalcraft.item.ItemMaterial;
import com.ttocskcaj.elementalcraft.util.IGetsInitialized;
import com.ttocskcaj.elementalcraft.util.IHasModels;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Random;

public class BlockAirOre extends BlockMultiBase implements IHasModels, IGetsInitialized {
    public static final PropertyEnum<Type> VARIANT = PropertyEnum.create("type", Type.class);
    public static ItemStack oreCitrine;
    public static ItemStack oreAzurite;
    public static ItemStack oreIron;
    public static ItemStack oreTin;
    public static ItemStack oreAirEnergy;

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }


    public BlockAirOre() {
        super(Material.ROCK);
        setUnlocalizedName("ore_air");
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
        this.setRegistryName("ore_air");
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

    @Override
    public boolean init() {
        FurnaceRecipes.instance().addSmeltingRecipe(oreIron, new ItemStack(Items.IRON_INGOT), 0.5f);
        FurnaceRecipes.instance().addSmeltingRecipe(oreTin, ItemMaterial.ingotTin,0.5f);
        return true;
    }

    @Override
    public ItemStack getDroppedItemStack(IBlockState state, BlockPos pos, Random rand, int fortune){
        Type variant = state.getValue(VARIANT);
        ItemStack itemStack = ItemStack.EMPTY;

        if (variant.dropsGem()) {
            // Get an ItemStack of the gem that is being dropped.
            if (variant.dropsGem()) {
                if (variant == Type.CITRINE)
                    itemStack = ItemMaterial.gemCitrine;
                if (variant == Type.AZURITE)
                    itemStack = ItemMaterial.gemAzurite;
            }
        } else {
            // Get the default item to drop (if no gems)
            itemStack = new ItemStack(getItemDropped(state, rand, fortune), 1, getMetaFromState(state));
        }
        return itemStack;
    }

    @Override
    public int quantityDropped(IBlockState state, int fortune, Random random) {
        Type variant = state.getValue(VARIANT);
        if (variant.dropsGem()) {
            return this.quantityDroppedWithBonus(fortune, random);
        }
        return 1;
    }

    public enum Type implements IStringSerializable {
        CITRINE(0, "citrine", true),
        AZURITE(1, "azurite", true),
        IRON(2, "iron", false),
        TIN(3, "tin", false),
        AIR_ENERGY(4, "air_energy", false);

        private static final Type[] METADATA_LOOKUP = new Type[values().length];
        private final int metadata;
        private final String name;
        private final Boolean dropsGem;

        Type(int metadata, String name, Boolean dropsGem) {
            this.metadata = metadata;
            this.name = name;
            this.dropsGem = dropsGem;
        }

        public int getMetadata() {

            return this.metadata;
        }

        @Override
        public String getName() {

            return this.name;
        }

        public Boolean dropsGem() {
            return this.dropsGem;
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
