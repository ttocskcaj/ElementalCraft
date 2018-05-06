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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Random;

public class BlockEarthOre extends BlockMultiBase implements IGetsInitialized, IHasModels {
    public static final PropertyEnum<Type> VARIANT = PropertyEnum.create("type", Type.class);
    public static ItemStack oreJade;
    public static ItemStack oreOnyx;
    public static ItemStack oreFluorite;
    public static ItemStack oreLead;
    public static ItemStack oreEarthEnergy;

    public BlockEarthOre() {
        super(Material.ROCK);
        setUnlocalizedName("ore_earth");
        setHardness(3.0F);
        setResistance(5.0F);

        setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, Type.JADE));

        setHarvestLevel("pickaxe", 1, getStateFromMeta(Type.JADE.getMetadata()));
        setHarvestLevel("pickaxe", 1, getStateFromMeta(Type.ONYX.getMetadata()));
        setHarvestLevel("pickaxe", 1, getStateFromMeta(Type.FLUORITE.getMetadata()));
        setHarvestLevel("pickaxe", 1, getStateFromMeta(Type.LEAD.getMetadata()));
        setHarvestLevel("pickaxe", 2, getStateFromMeta(Type.EARTH_ENERGY.getMetadata()));
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
        this.setRegistryName("ore_earth");
        ForgeRegistries.BLOCKS.register(this);

        ItemBlockOre itemBlock = new ItemBlockOre(this);
        itemBlock.setRegistryName(this.getRegistryName());
        ForgeRegistries.ITEMS.register(itemBlock);

        oreJade = new ItemStack(this, 1, Type.JADE.getMetadata());
        oreOnyx = new ItemStack(this, 1, Type.ONYX.getMetadata());
        oreFluorite = new ItemStack(this, 1, Type.FLUORITE.getMetadata());
        oreLead = new ItemStack(this, 1, Type.LEAD.getMetadata());
        oreEarthEnergy = new ItemStack(this, 1, Type.EARTH_ENERGY.getMetadata());

        OreDictionary.registerOre("oreJade", oreJade);
        OreDictionary.registerOre("oreOnyx", oreOnyx);
        OreDictionary.registerOre("oreFluorite", oreFluorite);
        OreDictionary.registerOre("oreLead", oreLead);
        OreDictionary.registerOre("oreEarthEnergy", oreEarthEnergy);

        return true;
    }

    @Override
    public boolean init() {

        FurnaceRecipes.instance().addSmeltingRecipe(oreLead, ItemMaterial.ingotLead,0.8f);

        return true;
    }

    @Override
    public ItemStack getDroppedItemStack(IBlockState state, BlockPos pos, Random rand, int fortune){
        Type variant = state.getValue(VARIANT);
        ItemStack itemStack = ItemStack.EMPTY;

        if (variant.dropsGem()) {
            // Get an ItemStack of the gem that is being dropped.
            if (variant.dropsGem()) {
                if (variant == Type.JADE)
                    itemStack = ItemMaterial.gemJade;
                if (variant == Type.ONYX)
                    itemStack = ItemMaterial.gemOnyx;
                if (variant == Type.FLUORITE)
                    itemStack = ItemMaterial.gemFluorite;
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
        JADE(0, "jade", true),
        ONYX(1, "onyx", true),
        FLUORITE(2, "fluorite", true),
        LEAD(3, "lead", false),
        EARTH_ENERGY(4, "earth_energy", false);

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
            return dropsGem;
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
