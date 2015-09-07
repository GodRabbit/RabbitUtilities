package com.godrabbit.rabbitutilities.proxy;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.godrabbit.rabbitutilities.block.RabbitBlocks;
import com.godrabbit.rabbitutilities.client.model.ModelLivingFlesh;
import com.godrabbit.rabbitutilities.client.model.ModelMirror;
import com.godrabbit.rabbitutilities.entities.EntityLivingFlesh;
import com.godrabbit.rabbitutilities.entities.EntityMirror;
import com.godrabbit.rabbitutilities.item.RabbitItems;
import com.godrabbit.rabbitutilities.renderer.RendererLivingFlesh;
import com.godrabbit.rabbitutilities.renderer.RendererMirror;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void registerRenders()
	{
		RabbitBlocks.registerRenders();
		RabbitItems.registerRenders();
		
		RenderingRegistry.registerEntityRenderingHandler(EntityLivingFlesh.class, 
				new RendererLivingFlesh(Minecraft.getMinecraft().getRenderManager(),new ModelLivingFlesh(), 0.0f));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityMirror.class, 
				new RendererMirror(Minecraft.getMinecraft().getRenderManager(),new ModelMirror(), 0.0f));
	}
	
	

}
