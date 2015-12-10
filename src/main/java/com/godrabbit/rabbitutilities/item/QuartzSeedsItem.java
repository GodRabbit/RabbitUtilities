package com.godrabbit.rabbitutilities.item;

import com.godrabbit.rabbitutilities.block.RabbitBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class QuartzSeedsItem extends Item implements IPlantable{
	
	public QuartzSeedsItem() {
		this.setMaxStackSize(16);
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		return EnumPlantType.Crop;
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
		
		return RabbitBlocks.quartz_crops.getDefaultState();
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player,
			World world, BlockPos pos, EnumFacing side, float hitX,
			float hitY, float hitZ) {
		if(side != EnumFacing.UP)
		{
			return false;
		}
		else if(!player.canPlayerEdit(pos.offset(side), side, stack))
		{
			return false;
		}
		else if (world.getBlockState(pos).getBlock().canSustainPlant(world, pos, EnumFacing.UP, this) && world.isAirBlock(pos.up()))
        {
            world.setBlockState(pos.up(), RabbitBlocks.quartz_crops.getDefaultState());
            --stack.stackSize;
            return true;
        }
        else
        {
            return false;
        }
	}

}
