package com.godrabbit.rabbitutilities.libs;

import net.minecraft.item.ItemStack;

public class WeightedStack {
	
	private int _weight;
	private ItemStack _stack;
	
	public WeightedStack(ItemStack stack, int weight)
	{
		_stack=stack.copy(); //prevent pointer problems.
		_weight=weight;
	}
	
	public ItemStack getStack()
	{
		return _stack;
	}
	
	public int getWeight()
	{
		return _weight;
	}
	
	public ItemStack getStackCopy()
	{
		return _stack.copy();
	}
}
