package com.godrabbit.rabbitutilities.block;

import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class QuartzCrops extends FleshCrops{
	
	@Override
	protected Item getSeed() {
		
		return super.getSeed(); //to update when quartz seeds will be created
	}
	
	@Override
	protected Item getCrop() {
		
		return Items.quartz;
	}

}
