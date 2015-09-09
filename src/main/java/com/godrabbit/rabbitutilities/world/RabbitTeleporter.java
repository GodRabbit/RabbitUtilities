package com.godrabbit.rabbitutilities.world;

import net.minecraft.entity.Entity;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class RabbitTeleporter extends Teleporter{

	int _x;
	int _y;
	int _z;
	
	public RabbitTeleporter(WorldServer world, int x, int y, int z) {
		super(world);
		// TODO Auto-generated constructor stub
		_x=x;
		_y=y;
		_z=z;
	}
	
	@Override
	public void placeInPortal(Entity entity,  float var4) {
		entity.setPosition(_x, _y, _z);
	}

	

}


