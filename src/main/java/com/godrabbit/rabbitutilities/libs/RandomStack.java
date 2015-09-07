package com.godrabbit.rabbitutilities.libs;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RandomStack {
	
	private ArrayList<WeightedStack> _stacks;
	int sumWeight;
	
	public RandomStack()
	{
		_stacks=new ArrayList<WeightedStack>();
		sumWeight=0;
	}
	
	public void addStack(WeightedStack wstack)
	{
		_stacks.add(wstack);
		sumWeight+=wstack.getWeight();
	}
	
	public void addStack(ItemStack stack, int weight)
	{
		_stacks.add(new WeightedStack(stack, weight));
		sumWeight+=weight;
	}
	
	public void addStack(Item item, int weight)
	{
		_stacks.add(new WeightedStack(new ItemStack(item, 1), weight));
		sumWeight+=weight;
	}
	
	public WeightedStack getWeightedStackAt(int index)
	{
		return _stacks.get(index);
	}
	
	public ItemStack getStackAt(int index)
	{
		return _stacks.get(index).getStack();
	}
	
	public int getSumWeights()
	{
		return sumWeight;
	}
	
	public ItemStack getRandomStack(Random rand)
	{
		int chance=rand.nextInt(sumWeight);
		//int csum=0; //current sum
		int sum=0;//?
		/*if(chance>_stacks.get(0).getWeight()) //stuiped line :|
			return _stacks.get(0).getStack().copy();*/
		for(int i=0;i<_stacks.size();i++)
		{
			sum+=_stacks.get(i).getWeight();
			if(sum>chance)
				return _stacks.get(i).getStack().copy();
		}
		return null;
	}
	
	

}
