package com.godrabbit.rabbitutilities.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class FleshLampBlock extends Block{ //wip

	protected FleshLampBlock() {
		super(Material.glass);
		this.setHardness(12.0f);
		this.setResistance(1.0f);
		this.setLightLevel(15.0f);
	}

}
