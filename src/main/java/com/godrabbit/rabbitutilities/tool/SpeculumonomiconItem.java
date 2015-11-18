package com.godrabbit.rabbitutilities.tool;

import java.util.Random;

import com.godrabbit.rabbitutilities.block.RabbitBlocks;
import com.godrabbit.rabbitutilities.entities.EntityMirror;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class SpeculumonomiconItem extends Item{

	public SpeculumonomiconItem()
	{
		this.setMaxStackSize(1);
		this.setMaxDamage(1);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player,
			World world, BlockPos pos, EnumFacing side, float hitX,
			float hitY, float hitZ) {
		//is altar activated
		if(world.getBlockState(pos).getBlock() == RabbitBlocks.ritual_table_basic)
		{
			//is block above altar is empty
			if(world.canSeeSky(pos))
			{
				//spawn mirror
				if(!world.isRemote)
				{
					EntityMirror bob=new EntityMirror(world);
					bob.setPosition(pos.getX()+0.5D, pos.getY()+1, pos.getZ()+0.5D);
					world.spawnEntityInWorld(bob);
				}
				int x=pos.getX();
				int y=pos.getY();
				int z=pos.getZ();
				stack.damageItem(3, player);
				Random rand = new Random(world.getTotalWorldTime());
				if (world.isRemote)
				{
					for (int i = 0; i < 10; ++i)
					{
						world.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, x+ (rand.nextDouble() - 0.5D) , y + rand.nextDouble() * (double)2.5 - 0.25D, z + (rand.nextDouble() - 0.5D) , (rand.nextDouble() - 0.5D) * 2.0D, -rand.nextDouble(), (rand.nextDouble() - 0.5D) * 2.0D, new int[0]);
					}
				}
			}
				
		}
		return super.onItemUse(stack, player, world, pos, side, hitX, hitY, hitZ);
	}
}
