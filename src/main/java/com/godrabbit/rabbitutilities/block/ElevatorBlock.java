package com.godrabbit.rabbitutilities.block;

import com.godrabbit.rabbitutilities.world.RabbitTeleporter;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class ElevatorBlock extends Block{

	protected ElevatorBlock() {
		super(Material.piston);

	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos,
			IBlockState state, EntityPlayer player, EnumFacing side,
			float hitX, float hitY, float hitZ) {

		if(!player.isSneaking()) //going up
		{
			//search for another elevator block up [max: 16 blocks]
			for(int i=1; i<=16; i++)
			{
				BlockPos p=new BlockPos(pos.getX(), pos.getY()+i, pos.getZ());

				if(world.getBlockState(p).getBlock() == RabbitBlocks.elevator_block) //found one !
				{
					//do the blocks above the elevator are air?
					if(world.getBlockState(p.up()).getBlock() == Blocks.air && world.getBlockState(p.up().up()).getBlock() == Blocks.air)
					{
						//tp player:
						int dim = player.dimension;
						int x = p.getX();
						int y = p.getY()+1; 
						int z = p.getZ();

						/*if(player instanceof EntityPlayerMP)
						{
							WorldServer worldserver= (WorldServer)world;
							EntityPlayerMP playerMP = (EntityPlayerMP) player;
							//playerMP.setPosition(x, y, z);
							playerMP.mcServer.getConfigurationManager()
							.transferPlayerToDimension(playerMP, dim,
									new RabbitTeleporter(worldserver, x, y, z));
							worldserver.updateEntities();
						}
						else
						{*/

							//player.setPosition(x, y, z);
							player.setPositionAndUpdate(x+0.5, y, z+0.5);
							world.updateEntities();

						//}
						return true;
					}

				}
			}
			return false;
		}
		else //going down
		{
			//search for another elevator block down [max: 16 blocks]
			for(int i=1; i<=16;i++)
			{
				BlockPos p=new BlockPos(pos.getX(), pos.getY()-i, pos.getZ());

				if(world.getBlockState(p).getBlock() == RabbitBlocks.elevator_block) //found one !
				{
					//do the blocks above the elevator are air?
					if(world.getBlockState(p.up()).getBlock() == Blocks.air && world.getBlockState(p.up().up()).getBlock() == Blocks.air)
					{
						//tp player:
						int dim = player.dimension;
						int x = p.getX();
						int y = p.getY()+1; 
						int z = p.getZ();

						/*if(player instanceof EntityPlayerMP)
						{
							WorldServer worldserver= (WorldServer)world;
							EntityPlayerMP playerMP = (EntityPlayerMP) player;
							//playerMP.setPosition(x, y, z);
							playerMP.mcServer.getConfigurationManager()
							.transferPlayerToDimension(playerMP, dim,
									new RabbitTeleporter(worldserver, x, y, z));
						}
						else
						{*/
							//player.setPosition(x, y, z);
							player.setPositionAndUpdate(x+0.5, y, z+0.5);
							world.updateEntities();

						//}
						return true;
					}
				}
			}
			return false;
		}
	}

}
