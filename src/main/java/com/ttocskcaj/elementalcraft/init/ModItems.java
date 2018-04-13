package com.ttocskcaj.elementalcraft.init;

import com.ttocskcaj.elementalcraft.item.ItemElementalFragment;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {

    public static final ItemElementalFragment itemElementalFragment = new ItemElementalFragment();
    @SideOnly(Side.CLIENT)
    public static void initModels(){
        itemElementalFragment.initModel();
    }
}
