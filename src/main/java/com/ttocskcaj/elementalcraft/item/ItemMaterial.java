package com.ttocskcaj.elementalcraft.item;

import com.ttocskcaj.elementalcraft.util.IGetsInitialized;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ItemMaterial extends ItemBase implements IGetsInitialized {

    // Crushed
    public static ItemStack crushedAether;
    public static ItemStack crushedGold;
    public static ItemStack crushedIron;
    public static ItemStack crushedLead;
    public static ItemStack crushedNickel;
    public static ItemStack crushedSilver;
    public static ItemStack crushedSteel;
    public static ItemStack crushedTin;

    // Shards
    public static ItemStack shardAether;
    public static ItemStack shardAirEnergy;
    public static ItemStack shardEarthEnergy;
    public static ItemStack shardFireEnergy;
    public static ItemStack shardWaterEnergy;

    // Ingots
    public static ItemStack ingotLead;
    public static ItemStack ingotNickel;
    public static ItemStack ingotSilver;
    public static ItemStack ingotSteel;
    public static ItemStack ingotTin;

    // Gems
    public static ItemStack gemAquamarine;
    public static ItemStack gemAzurite;
    public static ItemStack gemBeryl;
    public static ItemStack gemBloodstone;
    public static ItemStack gemCitrine;
    public static ItemStack gemFluorite;
    public static ItemStack gemGarnet;
    public static ItemStack gemJade;
    public static ItemStack gemOnyx;

    // Nuggets
    public static ItemStack nuggetLead;
    public static ItemStack nuggetNickel;
    public static ItemStack nuggetSilver;
    public static ItemStack nuggetSteel;
    public static ItemStack nuggetTin;

    public ItemMaterial() {
        super();
        setUnlocalizedName("material");
    }

    @Override
    public boolean preInit() {
        ForgeRegistries.ITEMS.register(setRegistryName("material"));

        // Crushed
        crushedAether = addAndRegisterItem(1, "crushedAether", "dustAether");
        crushedGold = addAndRegisterItem(2, "crushedGold", "dustGold");
        crushedIron = addAndRegisterItem(3, "crushedIron", "dustIron");
        crushedLead = addAndRegisterItem(4, "crushedLead", "dustLead");
        crushedNickel = addAndRegisterItem(5, "crushedNickel", "dustNickel");
        crushedSilver = addAndRegisterItem(6, "crushedSilver", "dustSilver");
        crushedSteel = addAndRegisterItem(7, "crushedSteel", "dustSteel");
        crushedTin = addAndRegisterItem(8, "crushedTin", "dustTin");

        // Gems
        gemAquamarine = addAndRegisterItem(20,"gemAquamarine");
        gemAzurite = addAndRegisterItem(21,"gemAzurite");
        gemBeryl = addAndRegisterItem(22,"gemBeryl");
        gemBloodstone = addAndRegisterItem(23,"gemBloodstone");
        gemCitrine = addAndRegisterItem(24,"gemCitrine");
        gemFluorite = addAndRegisterItem(25,"gemFluorite");
        gemGarnet = addAndRegisterItem(26,"gemGarnet");
        gemJade = addAndRegisterItem(27,"gemJade");
        gemOnyx = addAndRegisterItem(28,"gemOnyx");

        // Ingots
        ingotLead = addAndRegisterItem(40, "ingotLead");
        ingotNickel = addAndRegisterItem(41, "ingotNickel");
        ingotSilver = addAndRegisterItem(42, "ingotSilver");
        ingotSteel = addAndRegisterItem(43, "ingotSteel");
        ingotTin = addAndRegisterItem(44, "ingotTin");

        // Nuggets
        nuggetLead = addAndRegisterItem(60, "nuggetLead");
        nuggetNickel = addAndRegisterItem(61, "nuggetNickel");
        nuggetSilver = addAndRegisterItem(62, "nuggetSilver");
        nuggetSteel = addAndRegisterItem(63, "nuggetSteel");
        nuggetTin = addAndRegisterItem(64, "nuggetTin");

        // Shards
        shardAether = addAndRegisterItem(80, "shardAether");
        shardAirEnergy = addAndRegisterItem(81, "shardAirEnergy");
        shardEarthEnergy = addAndRegisterItem(82, "shardEarthEnergy");
        shardFireEnergy = addAndRegisterItem(83, "shardFireEnergy");
        shardWaterEnergy = addAndRegisterItem(84, "shardWaterEnergy");


        return true;
    }

    @Override
    public boolean init() {
        // Smelting recipes for crushed -> ingot
        FurnaceRecipes.instance().addSmeltingRecipe(crushedAether, shardAether, 0.6f);
        FurnaceRecipes.instance().addSmeltingRecipe(crushedGold, new ItemStack(Items.GOLD_INGOT), 0.8f);
        FurnaceRecipes.instance().addSmeltingRecipe(crushedIron, new ItemStack(Items.IRON_INGOT), 0.6f);
        FurnaceRecipes.instance().addSmeltingRecipe(crushedLead, ingotLead, 0.6f);
        FurnaceRecipes.instance().addSmeltingRecipe(crushedNickel, ingotNickel, 0.7f);
        FurnaceRecipes.instance().addSmeltingRecipe(crushedSilver, ingotSilver, 0.8f);
        FurnaceRecipes.instance().addSmeltingRecipe(crushedSteel, ingotSteel, 1f);
        FurnaceRecipes.instance().addSmeltingRecipe(crushedTin, ingotTin, 0.6f);


        return true;
    }
}