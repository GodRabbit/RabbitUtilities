package com.godrabbit.rabbitutilities.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.godrabbit.rabbitutilities.item.RabbitItems;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class FleshCrops extends BlockCrops{
	
	@Override
	protected Item getSeed() {
		
		return RabbitItems.human_seeds;
	}
	
	@Override
	protected Item getCrop() {
		
		return RabbitItems.flesh_item;
	}
	
	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos,
			IBlockState state, int fortune) {
		
		List<ItemStack> ret = new ArrayList<ItemStack>();
		//java.util.List<ItemStack> ret = super.getDrops(world, pos, state, fortune);
        int age = ((Integer)state.getValue(AGE)).intValue();
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        
        if (age >= 7)
        {
            int k = 3 + fortune;
            ret.add(new ItemStack(this.getCrop(), 1+fortune));
            //ret.add(new ItemStack(this.getSeed(), 1));
            
            for (int i = 0; i < 1 + fortune; ++i)
            {
                if (rand.nextInt(15) <= 100)
                {
                    ret.add(new ItemStack(this.getSeed(), 1, 0));
                }
            }
        }
        else
        {
        	ret.add(new ItemStack(this.getSeed(), 1));
        }
        return ret;
	}
}
