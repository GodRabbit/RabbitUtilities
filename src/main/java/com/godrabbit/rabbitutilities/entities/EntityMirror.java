package com.godrabbit.rabbitutilities.entities;

import com.godrabbit.rabbitutilities.item.RabbitItems;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityMirror extends EntityMob implements IMob{

	int CD=0; //cool down for spawning doppleganger
	final static int MaxCD=500;
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
		 getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
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
	
	@Override
	protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
		
		int j = 1+this.rand.nextInt(2 + p_70628_2_);
        int k;

        for (k = 0; k < j; ++k)
        {
            this.dropItem(RabbitItems.mirror_shard, 1);
        }
		super.dropFewItems(p_70628_1_, p_70628_2_);
	}
	
	/*@Override
	public void onLivingUpdate() {
		if(CD>0)
			CD--;
		
		super.onLivingUpdate();
	}*/
	
	@Override
	public void onCollideWithPlayer(EntityPlayer entity) {
		World world=entity.getEntityWorld();
		BlockPos pos=entity.getPosition();
		/*if(!world.isRemote && CD==0)
		{
			EntityZombie bob=new EntityZombie(world);
			bob.setPosition(pos.getX()+0.5D, pos.getY()+1, pos.getZ()+0.5D);
			world.spawnEntityInWorld(bob);
			CD=MaxCD;
		}*/
		super.onCollideWithPlayer(entity);
	}
}
