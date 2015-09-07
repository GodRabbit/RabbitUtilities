package com.godrabbit.rabbitutilities.tool;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class FUBatItem extends Item{

	public FUBatItem()
	{
		this.setMaxDamage(100);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		
		int x=player.getPosition().getX();
		int y=player.getPosition().getY();
		int z=player.getPosition().getZ();
		AxisAlignedBB area=new AxisAlignedBB(x-10.0,y-10.0,z-10.0,z+10.0,y+10.0,z+10.0);
		
		
		List bats=world.getEntitiesWithinAABB(EntityLivingBase.class, area );
		
		if(bats.isEmpty())
			System.out.println("wat??");
		
		for(Object bat: bats)
		{
			if(bat instanceof EntityBat)
			{
				((EntityBat) bat).setFire(15);
				stack.damageItem(1 , player);
			}
		}
		
		return stack;
	}
}
