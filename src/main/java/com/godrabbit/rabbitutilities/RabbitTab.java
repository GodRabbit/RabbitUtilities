package com.godrabbit.rabbitutilities;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class RabbitTab extends CreativeTabs{

	public RabbitTab(String label) {
		super(label);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Item getTabIconItem() {
		
		return Items.dark_oak_door;
	}

}
