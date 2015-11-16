package com.godrabbit.rabbitutilities.tool;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

//ID = inter-dimensional
public class IDSword extends Item{
	static final float DMG=0.5f;  //attack damage of the staff
	public IDSword()
	{
		this.setMaxStackSize(32);
		this.setMaxDamage(1);
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player,
			Entity entity) {
		if(entity instanceof EntityLivingBase)
		{
			((EntityLivingBase)entity).attackEntityFrom(DamageSource.magic, DMG*(float)stack.stackSize);
			
			if(!player.capabilities.isCreativeMode)
				stack.damageItem(2, player);
		}
		return super.onLeftClickEntity(stack, player, entity);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player,
			List tooltip, boolean advanced) {
		if(player != null && stack != null)
		{
			tooltip.add(DMG*(float)stack.stackSize+" AD");
		}
		super.addInformation(stack, player, tooltip, advanced);
	}
}
