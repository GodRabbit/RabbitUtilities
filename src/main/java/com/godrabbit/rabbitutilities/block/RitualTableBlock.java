package com.godrabbit.rabbitutilities.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class RitualTableBlock extends Block{

	protected RitualTableBlock() {
		super(Material.rock);
		this.setHardness(12.0f);
		this.setResistance(1.0f);
		this.setLightLevel(15.0f);
		
	}
	
	@Override
	public boolean isFullBlock() {
		
		return false;
	}
	
	@Override
	public boolean isFullCube() {
		
		return false;
	}
	
	@Override
	public boolean isOpaqueCube() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
