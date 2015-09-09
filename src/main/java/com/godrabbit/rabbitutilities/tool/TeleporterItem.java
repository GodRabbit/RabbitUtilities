package com.godrabbit.rabbitutilities.tool;

import java.util.List;
import java.util.Random;

import com.godrabbit.rabbitutilities.world.RabbitTeleporter;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class TeleporterItem extends Item{
	
	public TeleporterItem()
	{
		this.setMaxDamage(1500);
	}
	
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player) {
		if(stack.getTagCompound() == null)
			stack.setTagCompound(new NBTTagCompound()); 
		if(!stack.getTagCompound().hasKey("tpX"))
			stack.getTagCompound().setInteger("tpX", player.getPosition().getX());
		if(!stack.getTagCompound().hasKey("tpY"))
			stack.getTagCompound().setInteger("tpY", player.getPosition().getY());
		if(!stack.getTagCompound().hasKey("tpZ"))
			stack.getTagCompound().setInteger("tpZ", player.getPosition().getZ());
		if(!stack.getTagCompound().hasKey("dimid"))
			stack.getTagCompound().setInteger("dimid",player.dimension);
		super.onCreated(stack, world, player);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player,
			List tooltip, boolean advanced) {
		if(stack.getTagCompound() == null)
			stack.setTagCompound(new NBTTagCompound()); 
		if(!stack.getTagCompound().hasKey("tpX"))
			stack.getTagCompound().setInteger("tpX", player.getPosition().getX());
		if(!stack.getTagCompound().hasKey("tpY"))
			stack.getTagCompound().setInteger("tpY", player.getPosition().getY());
		if(!stack.getTagCompound().hasKey("tpZ"))
			stack.getTagCompound().setInteger("tpZ", player.getPosition().getZ());
		if(!stack.getTagCompound().hasKey("dimid"))
			stack.getTagCompound().setInteger("dimid",player.dimension);
		int x=stack.getTagCompound().getInteger("tpX");
		int y=stack.getTagCompound().getInteger("tpY");
		int z=stack.getTagCompound().getInteger("tpZ");
		int dim = stack.getTagCompound().getInteger("dimid");
		String d = dim==0? "Overworld" : (dim == -1? "Nether" :"Unknown???");
		tooltip.add("TP Coor: "+d+" ("+x+","+y+","+z+")");
		
		if(!advanced)
		{
			int maxdmg=stack.getMaxDamage();
			tooltip.add("Charge: "+(maxdmg-stack.getItemDamage())+"/"+stack.getMaxDamage());
		}
		super.addInformation(stack, player, tooltip, advanced);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if(stack.getTagCompound() == null)
			stack.setTagCompound(new NBTTagCompound()); 
		if(!stack.getTagCompound().hasKey("tpX"))
			stack.getTagCompound().setInteger("tpX", player.getPosition().getX());
		if(!stack.getTagCompound().hasKey("tpY"))
			stack.getTagCompound().setInteger("tpY", player.getPosition().getY());
		if(!stack.getTagCompound().hasKey("tpZ"))
			stack.getTagCompound().setInteger("tpZ", player.getPosition().getZ());
		if(!stack.getTagCompound().hasKey("dimid"))
			stack.getTagCompound().setInteger("dimid",player.dimension);
		
		if(!player.isSneaking())
		{
			//tp player cross dimension
			int x=stack.getTagCompound().getInteger("tpX");
			int y=stack.getTagCompound().getInteger("tpY");
			int z=stack.getTagCompound().getInteger("tpZ");
			int dim = stack.getTagCompound().getInteger("dimid");
			
			if(dim != player.dimension) //if cross dimension tp is necessary
			{
				if(player instanceof EntityPlayerMP)
				{
					WorldServer worldserver= (WorldServer)world;
					EntityPlayerMP playerMP = (EntityPlayerMP) player;
					//playerMP.setPosition(x, y, z);
					playerMP.mcServer.getConfigurationManager()
					.transferPlayerToDimension(playerMP, dim,
							new RabbitTeleporter(worldserver, x, y, z));
					
					//dmg item
					int maxdmg=stack.getMaxDamage();
					stack.damageItem(maxdmg/2+1, player);
				
				
					//particles mngmnt
					Random rand = new Random(world.getTotalWorldTime());
					if (world.isRemote)
					{
						for (int i = 0; i < 10; ++i)
						{
		                world.spawnParticle(EnumParticleTypes.PORTAL, x+ (rand.nextDouble() - 0.5D) * (double)2.5, y + rand.nextDouble() * (double)2.5 - 0.25D, z + (rand.nextDouble() - 0.5D) * (double)2.5, (rand.nextDouble() - 0.5D) * 2.0D, -rand.nextDouble(), (rand.nextDouble() - 0.5D) * 2.0D, new int[0]);
						}
					}
					
				}
					
			}
			else{
				player.setPosition(x, y, z);
			
				//dmg item
				int maxdmg=stack.getMaxDamage();
				stack.damageItem(maxdmg/2+1, player);
			
			
				//particles mngmnt
				Random rand = new Random(world.getTotalWorldTime());
				if (world.isRemote)
				{
					for (int i = 0; i < 10; ++i)
					{
	                world.spawnParticle(EnumParticleTypes.PORTAL, x+ (rand.nextDouble() - 0.5D) * (double)2.5, y + rand.nextDouble() * (double)2.5 - 0.25D, z + (rand.nextDouble() - 0.5D) * (double)2.5, (rand.nextDouble() - 0.5D) * 2.0D, -rand.nextDouble(), (rand.nextDouble() - 0.5D) * 2.0D, new int[0]);
					}
				}
			}
		}
		else
		{
			stack.getTagCompound().setInteger("tpX", player.getPosition().getX());
			stack.getTagCompound().setInteger("tpY", player.getPosition().getY());
			stack.getTagCompound().setInteger("tpZ", player.getPosition().getZ());
		}
		return super.onItemRightClick(stack, world, player);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn,
			int itemSlot, boolean isSelected) {
		if(stack.getItemDamage()!=0) //item is fully repaired
		{
			Random rand=new Random(worldIn.getTotalWorldTime());
			int n=rand.nextInt(1000);
			if(n<=3)
			{
				stack.setItemDamage(stack.getItemDamage()-1);
			}
		}
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
	}

}
