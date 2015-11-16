package com.godrabbit.rabbitutilities.block;

import net.minecraft.block.BlockCrops;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class EnderCarrotBlock extends BlockCrops{
	
	protected Item getSeed()
    {
        return Items.carrot;
    }

    protected Item getCrop()
    {
        return Items.ender_pearl;
    }

}
