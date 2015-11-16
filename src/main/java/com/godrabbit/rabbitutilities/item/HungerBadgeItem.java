package com.godrabbit.rabbitutilities.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class HungerBadgeItem extends Item{
	
	public HungerBadgeItem()
	{
		this.setMaxStackSize(1);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player,
			List tooltip, boolean advanced) {
		if(player!=null)
		{	
			tooltip.add("Hunger: "+player.getFoodStats().getFoodLevel()+"/20");
			tooltip.add("Sat: "+player.getFoodStats().getSaturationLevel()+"/"+player.getFoodStats().getFoodLevel());
		}
		super.addInformation(stack, player, tooltip, advanced);
	}

}
