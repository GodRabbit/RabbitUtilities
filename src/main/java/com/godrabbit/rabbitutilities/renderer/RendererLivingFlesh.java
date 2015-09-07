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
public class RendererLivingFlesh extends RenderLiving{
	
	
	protected ResourceLocation livingFleshTexture; 
	
	public RendererLivingFlesh(RenderManager rm, ModelBase mb, float shadow) {
		super(rm, mb, shadow);
		livingFleshTexture = new ResourceLocation(RabbitConst.MODID+":textures/entity/living_flesh.png");
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		
		return livingFleshTexture; 
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase p_77041_1_,
			float p_77041_2_) {
		
		super.preRenderCallback(p_77041_1_, p_77041_2_);
	}

}
