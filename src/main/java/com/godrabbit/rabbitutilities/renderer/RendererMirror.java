package com.godrabbit.rabbitutilities.renderer;

import com.godrabbit.rabbitutilities.RabbitConst;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RendererMirror extends RenderLiving{
	
	protected ResourceLocation mirrorTexture; 

	public RendererMirror(RenderManager rm, ModelBase mb,
			float shadow) {
		super(rm, mb, shadow);
		mirrorTexture = new ResourceLocation(RabbitConst.MODID+":textures/entity/mirror.png");
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		
		return mirrorTexture;
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase p_77041_1_,
			float p_77041_2_) {
		
		super.preRenderCallback(p_77041_1_, p_77041_2_);
	}

}
