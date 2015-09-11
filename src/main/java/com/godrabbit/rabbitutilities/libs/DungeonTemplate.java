package com.godrabbit.rabbitutilities.libs;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class DungeonTemplate {

	HashMap<BlockPos, IBlockState> _dung;
	BlockPos _start;
	
	public DungeonTemplate()
	{
		_dung=new HashMap<BlockPos, IBlockState>();
		_start=new BlockPos(0,0,0);
	}
	
	public DungeonTemplate(BlockPos start)
	{
		_dung=new HashMap<BlockPos, IBlockState>();
		_start=start;
	}
	
	public void add(IBlockState bs, BlockPos pos)
	{
		_dung.putIfAbsent(pos, bs);
	}
	
	public void add(IBlockState bs, int x, int y, int z)
	{
		BlockPos pos=new BlockPos(x,y,z);
		_dung.putIfAbsent(pos, bs);
	}
	
	public void add(Block b, BlockPos pos)
	{
		_dung.putIfAbsent(pos, b.getDefaultState());
	}
	
	public void add(Block b, int x, int y, int z)
	{
		BlockPos pos=new BlockPos(x,y,z);
		_dung.putIfAbsent(pos, b.getDefaultState());
	}
	
	public void add(Block b, int meta, int x, int y, int z)
	{
		BlockPos pos=new BlockPos(x,y,z);
		IBlockState bs = b.getStateFromMeta(meta);
		_dung.putIfAbsent(pos, bs);
	}
	
	public void fromWorld(World world, BlockPos start, int height, int north, int west)
	{
		this._start=start; //????
		for(int i=start.getX();i<start.getX()+north;i++)
		{
			for(int j=start.getY();j<start.getY()+height;j++)
			{
				for(int k=start.getZ();k<start.getZ()+west;k++)
				{
					BlockPos relpos=new BlockPos(i-start.getX(),j-start.getY(),k-start.getZ()); //relative position
					BlockPos pos= new BlockPos(i, j, k); //actual block position
					IBlockState bs=world.getBlockState(pos);
					if(bs != null && bs.getBlock() != Blocks.air) //dont record air!
						this.add(bs, relpos);
				}
			}
		}
	}
	
	public void spawnInWorld(World world, BlockPos start)
	{
		for(BlockPos pos : this._dung.keySet()) //get relative positions
		{
			IBlockState bs=_dung.get(pos);
			if(bs != null)
			{
				//actual in-world position
				BlockPos apos= new BlockPos(start.getX()+pos.getX(), start.getY()+pos.getY(), start.getZ()+pos.getZ()); 
				world.setBlockState(apos, bs);
			}
		}
	}
}
