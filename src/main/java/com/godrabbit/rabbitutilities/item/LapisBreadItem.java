package com.godrabbit.rabbitutilities.item;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LapisBreadItem extends ItemFood{

	public LapisBreadItem() {
		super(6, 6.0f, false);
		
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World world,
			EntityPlayer player) {
		player.addExperience(25);
		Random rand = world.rand;
		int amount=0;
		
		int n=rand.nextInt(93);
		if(n>=55 && n<85)
		{
			amount = 1;
		}
		else if(n>=85 && n<93)
		{
			amount = 2;
		}
		else if(n>=93 && n<98)
		{
			amount = 3;
		}
		else if(n>=98 && n<101)
		{
			amount = 4 ;
		}
		
		player.dropItem(new ItemStack(Items.dye, amount, 4), true, false);
		super.onFoodEaten(stack, world, player);
	}

}
