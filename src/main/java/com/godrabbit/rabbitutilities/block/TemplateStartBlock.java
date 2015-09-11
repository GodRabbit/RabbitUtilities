package com.godrabbit.rabbitutilities.block;

import com.godrabbit.rabbitutilities.libs.DungeonFileFormat;
import com.godrabbit.rabbitutilities.libs.DungeonTemplate;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class TemplateStartBlock extends Block{

	protected TemplateStartBlock() {
		super(Material.iron);
		
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos,
			IBlockState state, EntityPlayer player, EnumFacing side,
			float hitX, float hitY, float hitZ) {
		ItemStack stack=player.getCurrentEquippedItem();
		
		if(stack.getItem()==Items.name_tag) //to establish the file name for the dungeon
		{
			String filename=stack.getDisplayName();
			
			//find limits
			
			//search up: y-coor
			int height=1;
			boolean found_up=false;
			while(!found_up)
			{
				BlockPos var=new BlockPos(pos.getX(), pos.getY()+height, pos.getZ());
				if(world.getBlockState(var) == null || height>=220 || world.getBlockState(var).getBlock() == RabbitBlocks.template_end)
				{
					found_up=true;
				}
				height++;
			}
			
			//search east: x-coor
			int east=1;
			boolean found_east=false;
			while(!found_east)
			{
				BlockPos var=new BlockPos(pos.getX()+east, pos.getY(), pos.getZ());
				if(world.getBlockState(var) == null || east>=1000 || world.getBlockState(var).getBlock() == RabbitBlocks.template_end)
				{
					found_east=true;
				}
				east++;
			}
			
			//search south: z-coor
			int south=1;
			boolean found_south=false;
			while(!found_south)
			{
				BlockPos var=new BlockPos(pos.getX(), pos.getY(), pos.getZ()+south);
				if(world.getBlockState(var) == null || south>=1000 || world.getBlockState(var).getBlock() == RabbitBlocks.template_end)
				{
					found_south=true;
				}
				south++;
			}
			
			//get the dungeon template going
			DungeonTemplate dung=new DungeonTemplate(pos);
			dung.fromWorld(world, pos, height, east, south);
			
			//write to file
			dung.recordToFile(filename, DungeonFileFormat.JavaCode);
			
		}
		return super.onBlockActivated(world, pos, state, player, side, hitX, hitY,
				hitZ);
	}

}
