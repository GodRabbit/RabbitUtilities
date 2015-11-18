package com.godrabbit.rabbitutilities.item;

import java.util.Random;

import com.godrabbit.rabbitutilities.block.RabbitBlocks;
import com.godrabbit.rabbitutilities.entities.EntityMirror;

import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class BrainItem extends ItemFood{

	public BrainItem() {
		super(15, 20.0F, true);
		this.setMaxStackSize(1);
		this.setMaxDamage(1);
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn,
			EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(Potion.confusion.id, 1000, 0, false, false));
		super.onFoodEaten(stack, worldIn, player);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player,
			World world, BlockPos pos, EnumFacing side, float hitX,
			float hitY, float hitZ) {
		//is altar activated
		if(world.getBlockState(pos).getBlock() == RabbitBlocks.ritual_table_basic)
		{
			//is block above altar is empty
			if(world.canSeeSky(pos))
			{
				//spawn Enderman
				if(!world.isRemote)
				{
					EntityEnderman bob=new EntityEnderman(world);
					bob.setPosition(pos.getX()+0.5D, pos.getY()+1, pos.getZ()+0.5D);
					world.spawnEntityInWorld(bob);
				}
				int x=pos.getX();
				int y=pos.getY();
				int z=pos.getZ();
				stack.damageItem(3, player);
				Random rand = new Random(world.getTotalWorldTime());
				//spawn particles
				if (world.isRemote)
				{
					for (int i = 0; i < 10; ++i)
					{
						world.spawnParticle(EnumParticleTypes.PORTAL, x+ (rand.nextDouble() - 0.5D) , y + rand.nextDouble() * (double)2.5 - 0.25D, z + (rand.nextDouble() - 0.5D) , (rand.nextDouble() - 0.5D) * 2.0D, -rand.nextDouble(), (rand.nextDouble() - 0.5D) * 2.0D, new int[0]);
					}
						
				}
						
			}
		}
		
		return super.onItemUse(stack, player, world, pos, side, hitX, hitY, hitZ);
	}

}
