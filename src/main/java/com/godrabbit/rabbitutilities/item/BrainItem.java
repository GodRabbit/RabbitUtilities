package com.godrabbit.rabbitutilities.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class BrainItem extends ItemFood{

	public BrainItem() {
		super(15, 20.0F, true);
		this.setMaxStackSize(1);
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn,
			EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(Potion.confusion.id, 1000, 0, false, false));
		super.onFoodEaten(stack, worldIn, player);
	}

}
