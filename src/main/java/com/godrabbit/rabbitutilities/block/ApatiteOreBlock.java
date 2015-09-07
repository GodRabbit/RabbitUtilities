package com.godrabbit.rabbitutilities.block;

import com.godrabbit.rabbitutilities.MiningLevels;
import com.godrabbit.rabbitutilities.interfaces.IRabbitMiningLevel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ApatiteOreBlock extends Block implements IRabbitMiningLevel{

	protected ApatiteOreBlock() {
		super(Material.rock);
		// TODO Auto-generated constructor stub
	}

	@Override
	public MiningLevels getMiningLevel() {
		return MiningLevels.iron;
	}

}
