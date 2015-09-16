package com.godrabbit.rabbitutilities.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class JumpScareBlock extends Block{

	protected JumpScareBlock() {
		super(Material.rock);
		this.setHardness(2.7F);
		this.setResistance(3000);
		
		// TODO Auto-generated constructor stub
	}
	

	
	@Override
	public void onLanded(World world, Entity entity) {
		if(entity instanceof EntityLivingBase)
		{
			((EntityLivingBase)entity).setHealth(0.5f);
		}
		//super.onLanded(worldIn, entityIn);
	}

}
