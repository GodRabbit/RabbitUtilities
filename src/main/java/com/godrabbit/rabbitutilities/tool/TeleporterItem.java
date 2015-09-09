package com.godrabbit.rabbitutilities.tool;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class TeleporterItem extends Item{
	
	public TeleporterItem()
	{
		this.setMaxDamage(1500);
	}
	
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player) {
		if(stack.getTagCompound() == null)
			stack.setTagCompound(new NBTTagCompound()); 
		if(!stack.getTagCompound().hasKey("tpX"))
			stack.getTagCompound().setInteger("tpX", player.getPosition().getX());
		if(!stack.getTagCompound().hasKey("tpY"))
			stack.getTagCompound().setInteger("tpY", player.getPosition().getY());
		if(!stack.getTagCompound().hasKey("tpZ"))
			stack.getTagCompound().setInteger("tpZ", player.getPosition().getZ());
		super.onCreated(stack, world, player);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player,
			List tooltip, boolean advanced) {
		if(stack.getTagCompound() == null)
			stack.setTagCompound(new NBTTagCompound()); 
		if(!stack.getTagCompound().hasKey("tpX"))
			stack.getTagCompound().setInteger("tpX", player.getPosition().getX());
		if(!stack.getTagCompound().hasKey("tpY"))
			stack.getTagCompound().setInteger("tpY", player.getPosition().getY());
		if(!stack.getTagCompound().hasKey("tpZ"))
			stack.getTagCompound().setInteger("tpZ", player.getPosition().getZ());
		int x=stack.getTagCompound().getInteger("tpX");
		int y=stack.getTagCompound().getInteger("tpY");
		int z=stack.getTagCompound().getInteger("tpZ");
		tooltip.add("TP Coor: ("+x+","+y+","+z+")");
		
		if(!advanced)
		{
			int maxdmg=stack.getMaxDamage();
			tooltip.add("Charge: "+(maxdmg-stack.getItemDamage())+"/"+stack.getMaxDamage());
		}
		super.addInformation(stack, player, tooltip, advanced);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if(stack.getTagCompound() == null)
			stack.setTagCompound(new NBTTagCompound()); 
		if(!stack.getTagCompound().hasKey("tpX"))
			stack.getTagCompound().setInteger("tpX", player.getPosition().getX());
		if(!stack.getTagCompound().hasKey("tpY"))
			stack.getTagCompound().setInteger("tpY", player.getPosition().getY());
		if(!stack.getTagCompound().hasKey("tpZ"))
			stack.getTagCompound().setInteger("tpZ", player.getPosition().getZ());
		
		if(!player.isSneaking())
		{
			int x=stack.getTagCompound().getInteger("tpX");
			int y=stack.getTagCompound().getInteger("tpY");
			int z=stack.getTagCompound().getInteger("tpZ");
			player.setPosition(x, y, z);
			int maxdmg=stack.getMaxDamage();
			stack.damageItem(maxdmg/2+1, player);
		}
		else
		{
			stack.getTagCompound().setInteger("tpX", player.getPosition().getX());
			stack.getTagCompound().setInteger("tpY", player.getPosition().getY());
			stack.getTagCompound().setInteger("tpZ", player.getPosition().getZ());
		}
		return super.onItemRightClick(stack, world, player);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn,
			int itemSlot, boolean isSelected) {
		if(stack.getItemDamage()!=0) //item is fully repaired
		{
			Random rand=new Random(worldIn.getTotalWorldTime());
			int n=rand.nextInt(1000);
			if(n<=3)
			{
				stack.setItemDamage(stack.getItemDamage()-1);
			}
		}
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
	}

}
