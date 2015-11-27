package com.godrabbit.rabbitutilities.tool;



import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3i;
import net.minecraft.world.World;

public class FleshScythe extends Item{
	
	public FleshScythe()
	{
		this.setMaxStackSize(1);
		this.setMaxDamage(420);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player,
			World world, BlockPos pos, EnumFacing side, float hitX,
			float hitY, float hitZ) {
		for(int i=-1;i<=1;i++)
		{
			for(int j=-1;j<=1;j++)
			{
				Vec3i p=new Vec3i(i,0,j); //loc vec
				
				IBlockState bos=world.getBlockState(pos.add(p)); //the current block state
				Block b=bos.getBlock(); //curr block
				
				if(b instanceof BlockCrops) //is it crops?
				{
					if(((Integer)bos.getValue(BlockCrops.AGE)).intValue()>=7) //is it fully grown?
					{
						for(ItemStack d : b.getDrops(world, pos.add(p), bos, 1)) //get drops
						{
							//bos.withProperty(BlockCrops.AGE, 0);
							world.setBlockState(pos.add(p), bos.withProperty(BlockCrops.AGE, 2));
							player.dropItem(d, false, false); //drop items to player
						}
					}
					
					
				}
			}
		}
		return super.onItemUse(stack, player, world, pos, side, hitX, hitY, hitZ);
	}
}
