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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class BlockEarthOre extends BlockBase {
    public static final PropertyEnum<Type> VARIANT = PropertyEnum.create("type", Type.class);
    public static ItemStack oreJade;
    public static ItemStack oreOnyx;
    public static ItemStack oreFluorite;
    public static ItemStack oreLead;
    public static ItemStack oreEarthEnergy;

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        IBlockState newState = getStateFromMeta(stack.getMetadata());
        worldIn.setBlockState(pos, newState);
    }

    public BlockEarthOre() {
        super(Material.ROCK);
        setUnlocalizedName("earth_ore");
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
        this.setRegistryName("earth_ore");
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

    public boolean init() {
        FurnaceRecipes.instance().addSmeltingRecipe(oreJade, new ItemStack(ModItems.JADE), 0.5f);
        FurnaceRecipes.instance().addSmeltingRecipe(oreOnyx, new ItemStack(ModItems.ONYX), 0.5f);
        FurnaceRecipes.instance().addSmeltingRecipe(oreFluorite, new ItemStack(ModItems.FLUORITE), 0.5f);
//        FurnaceRecipes.instance().addSmeltingRecipe(oreLead, new ItemStack(ModItems.LE), 0.5f); TODO: Lead ingot.

        return true;
    }


    public enum Type implements IStringSerializable {
        JADE(0, "jade"),
        ONYX(1, "onyx"),
        FLUORITE(2, "fluorite"),
        LEAD(3, "lead"),
        EARTH_ENERGY(4, "earth_energy");

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