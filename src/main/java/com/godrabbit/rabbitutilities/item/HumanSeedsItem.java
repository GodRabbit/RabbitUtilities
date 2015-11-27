package com.godrabbit.rabbitutilities.item;

import com.godrabbit.rabbitutilities.block.RabbitBlocks;
import com.godrabbit.rabbitutilities.entities.EntityLivingFlesh;
import com.godrabbit.rabbitutilities.entities.EntityMirror;
import com.godrabbit.rabbitutilities.gui.GuiFleshBook;
import com.godrabbit.rabbitutilities.libs.DungeonFileFormat;
import com.godrabbit.rabbitutilities.libs.DungeonTemplate;
import com.godrabbit.rabbitutilities.libs.RabbitTemplates;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class HumanSeedsItem extends Item implements IPlantable{

	public HumanSeedsItem()
	{
		this.setMaxStackSize(16);
	}
	
	/*@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player,
			World world, BlockPos pos, EnumFacing side, float hitX,
			float hitY, float hitZ) {
		if(stack.getTagCompound() == null)
			stack.setTagCompound(new NBTTagCompound()); 
		if(!stack.getTagCompound().hasKey("tpX"))
			stack.getTagCompound().setInteger("tpX", player.getPosition().getX());
		if(!stack.getTagCompound().hasKey("tpY"))
			stack.getTagCompound().setInteger("tpY", player.getPosition().getY());
		if(!stack.getTagCompound().hasKey("tpZ"))
			stack.getTagCompound().setInteger("tpZ", player.getPosition().getZ());
		DungeonTemplate temp=new DungeonTemplate();
		
		if(player.isSneaking())
		{
			stack.getTagCompound().setInteger("tpX", player.getPosition().getX());
			stack.getTagCompound().setInteger("tpY", player.getPosition().getY());
			stack.getTagCompound().setInteger("tpZ", player.getPosition().getZ());
		}
		else
		{
			int x=stack.getTagCompound().getInteger("tpX");
			int y=stack.getTagCompound().getInteger("tpY");
			int z=stack.getTagCompound().getInteger("tpZ");
			//temp.fromWorld(world, new BlockPos(x,y,z), 9, 9, 9);
			//temp.spawnInWorld(world, pos);
			//temp.recordToFile("cow", DungeonFileFormat.JavaCode);
			//RabbitTemplates r=new RabbitTemplates();
			RabbitTemplates.House.spawnInWorld(world, pos);
		}
	}	*/
	
	/*
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer playerIn) {
		  if (!world.isRemote)
		    {
		        Minecraft.getMinecraft().displayGuiScreen( //not working??
		              new GuiFleshBook()); 
		    }
		return stack;
	
	}*/
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player,
			World world, BlockPos pos, EnumFacing side, float hitX,
			float hitY, float hitZ) {
		if(side != EnumFacing.UP)
		{
			return false;
		}
		else if(!player.canPlayerEdit(pos.offset(side), side, stack))
		{
			return false;
		}
		else if (world.getBlockState(pos).getBlock().canSustainPlant(world, pos, EnumFacing.UP, this) && world.isAirBlock(pos.up()))
        {
            world.setBlockState(pos.up(), RabbitBlocks.flesh_crops.getDefaultState());
            --stack.stackSize;
            return true;
        }
        else
        {
            return false;
        }
		//return super.onItemUse(stack, player, world, pos, side, hitX, hitY, hitZ);
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		
		return EnumPlantType.Crop;
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
		
		return RabbitBlocks.flesh_crops.getDefaultState();
	}
}
