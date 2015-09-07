package com.godrabbit.rabbitutilities.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class MuscleItem extends ItemFood{

	public MuscleItem() {
		super(4, 0.6F, true);
		this.setMaxStackSize(4);
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn,
			EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 1000, 0, false, false));
		super.onFoodEaten(stack, worldIn, player);
	}
	
	

}
