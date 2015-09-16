package com.godrabbit.rabbitutilities.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class DecomposingFleshItem extends Item{
	
	public DecomposingFleshItem()
	{
		this.setMaxStackSize(2);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entity,
			int itemSlot, boolean isSelected) {
		if(entity instanceof EntityPlayer)
		{
			if(!entity.isInvisible())
			{
				((EntityPlayer) entity).addPotionEffect(new PotionEffect(Potion.hunger.id, 100, 9, false, true));
				((EntityPlayer) entity).addPotionEffect(new PotionEffect(Potion.blindness.id, 100, 1, false, true));;
			}
		}
		super.onUpdate(stack, worldIn, entity, itemSlot, isSelected);
	}
}
