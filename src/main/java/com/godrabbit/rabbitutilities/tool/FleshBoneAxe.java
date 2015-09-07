package com.godrabbit.rabbitutilities.tool;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.Vec3;
import net.minecraft.util.Vec3i;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class FleshBoneAxe extends ItemAxe{

	static ToolMaterial flesh_bone=EnumHelper.addToolMaterial("flesh_bone", 5, 15, 15, 1, 70);
	
	public FleshBoneAxe() {
		super(flesh_bone);
		this.setMaxStackSize(1);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity,
			int itemSlot, boolean isSelected) {
		//auto repair mechanism
		Random rand=new Random(entity.ticksExisted);
		int n=rand.nextInt(100);
		if(n<=5)
		{
			stack.setItemDamage(stack.getItemDamage()-1); //add 1 durability
		}
		super.onUpdate(stack, world, entity, itemSlot, isSelected);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		
		//ArrayList<ItemStack> drops=new ArrayList<ItemStack>();
		
		final int N=3;
		if(player.isSneaking())
		{
			for(int i=-N;i<=N;i++)
			{
				for(int k=-N;k<=N;k++)
				{
					for(int j=-N;j<=N;j++)
					{
						Vec3i p=new Vec3i(i,k,j); //loc vec
						
						BlockPos pos=player.getPosition().add(p); //actual position of the block
						
						//get radius around player
						IBlockState b=world.getBlockState(pos);
						Block block=b.getBlock();
						int meta=block.getMetaFromState(b);
						
						if(b!= null && b.getBlock().getMaterial() == Material.wood)
						{
							if(!world.isRemote)
							{
								//player.dropItem(Item.getItemFromBlock(b.getBlock()), 1);
								player.dropItem(new ItemStack(block,1,meta), false, false);
							}
							world.setBlockToAir(pos);
							
							//particles!!!!!!!!
							world.spawnParticle(EnumParticleTypes.CLOUD, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), (double)0, (double)0, (double)0, 0);
							
						}
					}
				}
			}
		}
		//damage item
		stack.setItemDamage(stack.getMaxDamage()-1);
		return super.onItemRightClick(stack, world, player);
	}
	

}
