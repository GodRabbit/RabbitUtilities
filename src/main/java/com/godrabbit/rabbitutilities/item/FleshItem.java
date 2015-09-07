package com.godrabbit.rabbitutilities.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class FleshItem extends ItemFood{

	public FleshItem() {
		super(2, 0.2f, true);
		
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World world,
			EntityPlayer player) {
		
		super.onFoodEaten(stack, world, player);
		player.addPotionEffect(new PotionEffect(Potion.harm.id, 10, 1, false, false));
		player.addPotionEffect(new PotionEffect(Potion.blindness.id, 400, 4, false, false));
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		
		return EnumAction.EAT;
	}

}
