package com.godrabbit.rabbitutilities.tool;

import java.util.List;

import com.godrabbit.rabbitutilities.item.RabbitItems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class FleshBucket extends Item{
	
	public FleshBucket()
	{
		this.setMaxDamage(15);
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		
		if(stack.getTagCompound() == null)
			stack.setTagCompound(new NBTTagCompound());
		if(!stack.getTagCompound().hasKey("full"))
			stack.getTagCompound().setInteger("full", 0);
		
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn,
			List tooltip, boolean advanced) {
		if(stack.getTagCompound() == null)
			stack.setTagCompound(new NBTTagCompound());
		if(!stack.getTagCompound().hasKey("full"))
			stack.getTagCompound().setInteger("full", 0);
		int full=stack.getTagCompound().getInteger("full");
		tooltip.add("Lava: "+full+"%");
		super.addInformation(stack, playerIn, tooltip, advanced);
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player,
			Entity entity) {
		if(stack.getTagCompound() == null)
			stack.setTagCompound(new NBTTagCompound());
		if(!stack.getTagCompound().hasKey("full"))
			stack.getTagCompound().setInteger("full", 0);
		int full=stack.getTagCompound().getInteger("full");
		full=full+15;
		entity.setFire(30);
		entity.attackEntityFrom(DamageSource.lava, 2.5f);
		if(full>=100)
		{
			full=0;
			if(!player.worldObj.isRemote)
				player.dropItem(RabbitItems.lava_heart, 1);
			stack.damageItem(1, player);
		}
		stack.getTagCompound().setInteger("full", full);
		return true;
	}

}
