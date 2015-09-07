package com.godrabbit.rabbitutilities.block;

import com.godrabbit.rabbitutilities.MiningLevels;
import com.godrabbit.rabbitutilities.interfaces.IRabbitMiningLevel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class AnapaiteOreBlock extends Block implements IRabbitMiningLevel{

	protected AnapaiteOreBlock() {
		super(Material.rock);
		this.setResistance(12.0f);
		this.setHardness(12.0f);
		this.setHarvestLevel("pickaxe", 5); //regular pickaxe wont be able to mine
	}

	@Override
	public MiningLevels getMiningLevel() {
		return MiningLevels.anapaite;
	}

}
