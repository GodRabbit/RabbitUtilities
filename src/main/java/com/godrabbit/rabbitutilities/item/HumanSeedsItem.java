package com.godrabbit.rabbitutilities.item;

import com.godrabbit.rabbitutilities.entities.EntityLivingFlesh;
import com.godrabbit.rabbitutilities.entities.EntityMirror;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class HumanSeedsItem extends Item{

	public HumanSeedsItem()
	{
		
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player,
			World world, BlockPos pos, EnumFacing side, float hitX,
			float hitY, float hitZ) {
		if(!world.isRemote)
		{
			EntityMirror bob=new EntityMirror(world);
			bob.setPosition(pos.getX()+3, pos.getY()+1, pos.getZ()+3);
			world.spawnEntityInWorld(bob);
		}
		return super.onItemUse(stack, player, world, pos, side, hitX, hitY, hitZ);
	}
}
