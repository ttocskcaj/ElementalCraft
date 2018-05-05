package com.ttocskcaj.elementalcraft.item;

import com.google.common.collect.ImmutableList;
import com.ttocskcaj.elementalcraft.ElementalCraft;
import com.ttocskcaj.elementalcraft.util.IHasModels;
import gnu.trove.map.TMap;
import gnu.trove.map.hash.THashMap;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.Map;

public class ItemBase extends Item implements IHasModels {
    protected TMap<Integer, String> itemMap = new THashMap<>();
    protected ArrayList<Integer> itemList = new ArrayList<>();
    public ItemBase(){
        setCreativeTab(ElementalCraft.creativeTab);
        setHasSubtypes(true);
    }

    public ItemStack addAndRegisterItem(int id, String name){
        return addAndRegisterItem(id, name, name);
    }
    public ItemStack addAndRegisterItem(int id, String name, String oreName) {
        ItemStack itemStack;
        if (itemMap.containsKey(id)) {
            itemStack = ItemStack.EMPTY;
            return itemStack;
        }
        itemMap.put(id, name);
        itemList.add(id);

        itemStack =  new ItemStack(this, 1, id);
        OreDictionary.registerOre(oreName, itemStack);
        return itemStack;
    }
    public ImmutableList<ItemStack> getAllItems() {

        ArrayList<ItemStack> items = new ArrayList<>();

        for (int metadata : itemList) {
            items.add(new ItemStack(this, 1, metadata));
        }
        return ImmutableList.copyOf(items);
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {

        if (isInCreativeTab(tab)) {
            for (int metadata : itemList) {
                items.add(new ItemStack(this, 1, metadata));
            }
        }
    }

    @Override
    public boolean isDamageable() {
        return false;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {

        int meta = stack.getMetadata();
        if (!itemMap.containsKey(meta)) {
            return "unknown";
        }
        return getUnlocalizedName() + "." + itemMap.get(meta);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerModels() {
        for (Map.Entry<Integer, String> entry : itemMap.entrySet()) {
            ModelLoader.setCustomModelResourceLocation(this, entry.getKey(), new ModelResourceLocation(getRegistryName(), "type=" + entry.getValue()));
        }
    }
}
