package com.godrabbit.rabbitutilities.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class JumpScareBlock extends Block{

	protected JumpScareBlock() {
		super(Material.rock);
		this.setHardness(2.7F);
		this.setResistance(3000);
		
	}
	
	@Override
	public void onLanded(World world, Entity entity) {
		if(entity instanceof EntityLivingBase)
		{
			BlockPos pos=entity.getPosition();
			Random rand = new Random(world.getSeed());
			int x=pos.getX();
			int y=pos.getY();
			int z=pos.getZ();
			((EntityLivingBase)entity).setHealth(0.5f); //actual function
			
			//particles
			/*
			for (int i = 0; i < 10; ++i)
			{
				world.spawnParticle(EnumParticleTypes.CRIT_MAGIC, x+ (rand.nextDouble() - 0.5D) , y + rand.nextDouble() * (double)2.5 - 0.25D, z + (rand.nextDouble() - 0.5D) , (rand.nextDouble() - 0.5D) * 2.0D, -rand.nextDouble(), (rand.nextDouble() - 0.5D) * 2.0D, new int[0]);
			}*/
		}
		
	}

}
