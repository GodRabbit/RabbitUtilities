package com.godrabbit.rabbitutilities.tool;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class FleshWings extends Item{
	
	public FleshWings()
	{
		this.setMaxStackSize(1);
		
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		if(stack.getTagCompound() == null)
			stack.setTagCompound(new NBTTagCompound());
		if(!stack.getTagCompound().hasKey("state"))
			stack.getTagCompound().setDouble("state", 0.1);
		super.onCreated(stack, worldIn, playerIn);
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 300;
	}
	
	/*@Override
	public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
		double state =0.1;
		if(stack.getTagCompound() != null && stack.getTagCompound().hasKey("state"))
		{
			state=stack.getTagCompound().getDouble("state"); //stack velocity as you charge
			state+=0.1;
			stack.getTagCompound().setDouble("state", state);
		}
		super.onUsingTick(stack, player, count);
	}*/
	
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn,
			EntityPlayer player, int timeLeft) {
		
		
		int j=this.getMaxItemUseDuration(stack) - timeLeft;
		double state =0.3+j*0.2;
		//state=stack.getTagCompound().getDouble("state");
		Vec3 look=player.getLookVec();
		look=look.normalize();
		player.setVelocity(look.xCoord*state, look.yCoord*state,look.zCoord*state);
		if(stack.getTagCompound() == null)
			stack.setTagCompound(new NBTTagCompound());
		if(!stack.getTagCompound().hasKey("state"))
			stack.getTagCompound().setDouble("state", 0.1);
		
		//super.onPlayerStoppedUsing(stack, worldIn, player, timeLeft);
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		
		return EnumAction.BOW;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn,
			EntityPlayer playerIn) {
		playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
		return super.onItemRightClick(itemStackIn, worldIn, playerIn);
	}

}
