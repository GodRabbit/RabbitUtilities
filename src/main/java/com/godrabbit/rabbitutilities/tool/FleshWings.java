package com.godrabbit.rabbitutilities.tool;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FleshWings extends Item{
	
	public FleshWings()
	{
		this.setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn,
			EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return super.onItemUseFinish(stack, worldIn, playerIn);
	}

}
