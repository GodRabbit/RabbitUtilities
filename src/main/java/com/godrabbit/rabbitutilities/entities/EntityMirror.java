package com.godrabbit.rabbitutilities.entities;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

public class EntityMirror extends EntityMob{

	public EntityMirror(World worldIn) {
		super(worldIn);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void applyEntityAttributes() {
		
		super.applyEntityAttributes();
		
		// standard attributes registered to EntityLivingBase
		 getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
		 getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20D);
		 getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.8D);
		 getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(16.0D);
		 getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
	}
	
}
