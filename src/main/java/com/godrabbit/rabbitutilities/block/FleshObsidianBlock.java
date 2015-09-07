package com.godrabbit.rabbitutilities.block;

import com.godrabbit.rabbitutilities.MiningLevels;
import com.godrabbit.rabbitutilities.interfaces.IRabbitMiningLevel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class FleshObsidianBlock extends Block implements IRabbitMiningLevel{

	protected FleshObsidianBlock() {
		super(Material.rock);
		setHardness(50.0F);
	    setResistance(2000.0F);
	    setStepSound(soundTypePiston);
	}
	
	@Override
	public boolean canEntityDestroy(IBlockAccess world, BlockPos pos,
			Entity entity) {
		
		if(entity instanceof EntityWither || entity instanceof EntityWitherSkull)
		{
			 return this != Blocks.bedrock && 
					 this != Blocks.end_portal && 
					 this != Blocks.end_portal_frame && 
					 this != Blocks.command_block && 
					 this != RabbitBlocks.flesh_obsidian;
		}
		else if (entity instanceof EntityDragon)	 
	    {
	 
	        return this != Blocks.obsidian && this != Blocks.end_stone && this != Blocks.bedrock;
	 
	    }
	 
	    return true;
	}

	@Override
	public MiningLevels getMiningLevel() {
		return MiningLevels.obsidian;
	}

	
	@Override
	public boolean canDropFromExplosion(Explosion explosionIn) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean canCreatureSpawn(IBlockAccess world, BlockPos pos,
			SpawnPlacementType type) {
		return false;
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos,
			Entity entity) {
		if(entity instanceof EntityWitherSkull)
		{
			world.removeEntity(entity);
			world.setBlockState(pos, this.getDefaultState());
		}
		super.onEntityCollidedWithBlock(world, pos, entity);
	}
	
	//here the magic lays! this is the core!
	@Override
	public void onBlockDestroyedByExplosion(World world, BlockPos pos,
			Explosion explosionIn) {
		world.setBlockState(pos, this.getDefaultState());
		super.onBlockDestroyedByExplosion(world, pos, explosionIn);
	}
	
	
}
