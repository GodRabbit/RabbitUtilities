package com.godrabbit.rabbitutilities.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLivingFlesh extends ModelBase{
	
	public ModelRenderer cube;
	
	public ModelLivingFlesh()
	{
		this.cube = new ModelRenderer(this, 0 , 0);
		this.cube.addBox(0.0F, 0.0F, 0.0F, 16, 16, 16);
		this.cube.setRotationPoint(-8F, 8F, -8F);
		this.cube.setTextureSize(16, 16);
		this.cube.mirror=true;
		
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.cube.render(f5);
		super.render(entity,  f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
	

}
