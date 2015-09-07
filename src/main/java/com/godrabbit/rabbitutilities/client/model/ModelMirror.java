package com.godrabbit.rabbitutilities.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMirror extends ModelBase{
	
	public ModelRenderer body;
	
	public ModelMirror()
	{
		textureWidth = 128;
	    textureHeight = 128;
	    
	      body = new ModelRenderer(this, 0, 0);
	      body.addBox(-8F, 0F, -16F, 16, 1, 32);
	      body.setRotationPoint(0F, 8F, 0F);
	      body.setTextureSize(128, 128);
	      body.mirror = true;
	      setRotation(body, 1.570796F, 0F, 0F);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z)
	  {
	    model.rotateAngleX = x;
	    model.rotateAngleY = y;
	    model.rotateAngleZ = z;
	  }
	
	@Override
	 public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e)
	 {
	    super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	 }
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.body.render(f5);
		super.render(entity,  f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
}
