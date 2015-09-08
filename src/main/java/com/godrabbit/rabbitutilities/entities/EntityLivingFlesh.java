package com.godrabbit.rabbitutilities.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EntityLivingFlesh extends EntityMob{

	public EntityLivingFlesh(World worldIn) {
		super(worldIn);
		//this.moveHelper = new EntitySlime
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(5, new EntityAIWander(this, 0.8D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		
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
	
	@Override
	public boolean attackEntityAsMob(Entity entity) {
       
		if (super.attackEntityAsMob(entity))
        {
            if (entity instanceof EntityLivingBase)
            {
                ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.wither.id, 200));
            }

            return true;
        }
        else
        {
            return false;
        }
	}

}
