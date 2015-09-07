package com.godrabbit.rabbitutilities.interfaces;

import com.godrabbit.rabbitutilities.MiningLevels;

public interface IRabbitMiningLevel {
	//to implement by block class which want to be recognized by the Enum MiningLevels
	
	public MiningLevels getMiningLevel();
}
