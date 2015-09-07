package com.godrabbit.rabbitutilities.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LavaHeartItem extends Item{

	public LavaHeartItem()
	{
		
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity,
			int itemSlot, boolean isSelected) {
		if(!entity.isBurning())
		{
			entity.setFire(5);
		}
	}
}
