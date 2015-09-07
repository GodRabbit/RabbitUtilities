package com.godrabbit.rabbitutilities.events;

import com.godrabbit.rabbitutilities.tool.FleshPickaxe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {
	
	/*@SubscribeEvent
	public void onBlockDrops(BlockEvent.HarvestDropsEvent event)
	{
		if(event.harvester.getCurrentEquippedItem().getItem() instanceof FleshPickaxe)
		{
			ItemStack stack=event.harvester.getCurrentEquippedItem();
			
			//check for silktouch 
			if(stack.getTagCompound() != null && stack.getTagCompound().hasKey("silk") && event.state.getBlock().canSilkHarvest(event.world, event.pos, event.state, event.harvester))
			{
				if(stack.getTagCompound().getInteger("silk")>0)
				{
					event.drops.clear();
					event.drops.add(new ItemStack(Item.getItemFromBlock(event.state.getBlock())));
				}
				
			}
		}
	}*/

}
