package com.godrabbit.rabbitutilities.entities;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityMirror extends EntityMob implements IMob{

	public EntityMirror(World worldIn) {
		super(worldIn);
		this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
		this.tasks.addTask(7, new EntityAIWander(this, 0.2D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
	}

	@Override
	protected void applyEntityAttributes() {
		
		super.applyEntityAttributes();
		
		// standard attributes registered to EntityLivingBase
		 getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);
		 getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.35D);
		 getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.8D);
		 getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(30.0D);
		 getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
	} 
	
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if(source.getEntity() instanceof EntityPlayer) //mirror stare back at me!
		{
			return !((EntityPlayer)(source.getEntity())).attackEntityFrom(source, amount);
		}
		return super.attackEntityFrom(source, amount);
	}
	
	@Override
	protected String getHurtSound() {
		
		return "dig.glass";
	}
	
}
