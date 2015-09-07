package com.godrabbit.rabbitutilities.tool;

import java.util.Random;

import com.godrabbit.rabbitutilities.item.RabbitItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class FleshEaterSword extends Item{
	
	public FleshEaterSword()
	{
		this.setMaxStackSize(1);
		
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		
		Random rand=new Random(world.getWorldInfo().getRainTime());
		int n=rand.nextInt(101);
		
		if(player.getHealth()<=1.0f)
		{
			player.attackEntityFrom(DamageSource.cactus, 3.0f);
			return stack;
		}
		float half=player.getHealth()/2.0f; //half the player's life
		player.attackEntityFrom(DamageSource.cactus, half);
		
		
		if(n<=50) //every other time drop flesh
		{
				player.dropItem(RabbitItems.flesh_item, 1);
		}
		return stack;
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		
		return EnumAction.BOW;
	}
	
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player) {
	
		float half=player.getHealth()/2.0f; //half the player's life
		player.attackEntityFrom(DamageSource.cactus, half);
		
		world.spawnParticle(EnumParticleTypes.HEART,player.getPosition().getX()+1, player.getPosition().getY(), player.getPosition().getZ(), 0.76, 0.76, 0.55, 2);
		world.spawnParticle(EnumParticleTypes.HEART,player.getPosition().getX(), player.getPosition().getY()+1, player.getPosition().getZ()+1, 0.76, 0.76, 0.55, 2);
		world.spawnParticle(EnumParticleTypes.HEART,player.getPosition().getX()-1, player.getPosition().getY(), player.getPosition().getZ(), 0.76, 0.76, 0.55, 2);
		world.spawnParticle(EnumParticleTypes.HEART,player.getPosition().getX(), player.getPosition().getY()-1, player.getPosition().getZ()-1, 0.76, 0.76, 0.55, 2);
		world.spawnParticle(EnumParticleTypes.HEART,player.getPosition().getX()+1, player.getPosition().getY()-1, player.getPosition().getZ()-2, 0.76, 0.76, 0.55, 2);
		world.spawnParticle(EnumParticleTypes.HEART,player.getPosition().getX()+3, player.getPosition().getY()-1, player.getPosition().getZ()+1, 0.76, 0.76, 0.55, 2);
		world.spawnParticle(EnumParticleTypes.HEART,player.getPosition().getX()-3, player.getPosition().getY()+4, player.getPosition().getZ(), 0.76, 0.76, 0.55, 2);
		world.spawnParticle(EnumParticleTypes.HEART,player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ(), 0.76, 0.76, 0.55, 2);
		world.spawnParticle(EnumParticleTypes.HEART,player.getPosition().getX(), player.getPosition().getY()+1, player.getPosition().getZ(), 0.76, 0.76, 0.55, 2);
		world.spawnParticle(EnumParticleTypes.HEART,player.getPosition().getX()+1, player.getPosition().getY()-1, player.getPosition().getZ()+3, 0.76, 0.76, 0.55, 2);

	}

}
