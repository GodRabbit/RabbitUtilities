package com.godrabbit.rabbitutilities.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class HumanSpongeBlock extends Block{

	protected HumanSpongeBlock() {
		super(Material.sponge);
		this.setLightLevel(1.0f);
		this.setHardness(0.0f);
		this.setResistance(10.5f);
		this.setTickRandomly(true);
		this.setStepSound(soundTypeGrass);
		
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		
		return null;
	}
}
