package com.minecraftRPG.models;

import net.minecraft.entity.Entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;

public class ModelBlackPendragonArmorV3 extends ModelBiped
{
  //fields
    ModelRenderer Sword1Base;
    ModelRenderer Sword1End1;
    ModelRenderer Sword1End2;
    ModelRenderer Sword1Handle1;
    ModelRenderer Sword1Handle2;
    ModelRenderer Sword1Handle3;
    ModelRenderer Sword1Handle4;
    ModelRenderer Sword2Base;
    ModelRenderer Sword2End1;
    ModelRenderer Sword2End2;
    ModelRenderer Sword2Handle1;
    ModelRenderer Sword2Handle2;
    ModelRenderer Sword2Handle3;
    ModelRenderer Sword2Handle4;
  
  public ModelBlackPendragonArmorV3(float expand)
  {
	  super(expand, 0, 64, 64);
   
      Sword1Base = new ModelRenderer(this, 8, 36);
      Sword1Base.addBox(0F, -0.5F, -0.5F, 20, 1, 1);
      Sword1Base.setRotationPoint(0F, 0F, 0F);
      Sword1Base.setTextureSize(128, 128);
      Sword1Base.mirror = true;
      setRotation(Sword1Base, 0F, 0F, 0F);
      
      Sword1End1 = new ModelRenderer(this, 53, 34);
      Sword1End1.addBox(0F, -0.4F, -0.5F, 2, 1, 1);
      Sword1End1.setRotationPoint(0F, 0F, 0F);
      Sword1End1.setTextureSize(128, 128);
      Sword1End1.mirror = true;
      setRotation(Sword1End1, 0F, 0F, 0F);
      
      Sword1End2 = new ModelRenderer(this, 53, 37);
      Sword1End2.addBox(0F, -0.6F, -0.5F, 2, 1, 1);
      Sword1End2.setRotationPoint(0F, 0F, 0F);
      Sword1End2.setTextureSize(128, 128);
      Sword1End2.mirror = true;
      setRotation(Sword1End2, 0F, 0F, 0F);
      
      Sword1Handle1 = new ModelRenderer(this, 60, 34);
      Sword1Handle1.addBox(0F, -0.4F, -0.5F, 4, 1, 1);
      Sword1Handle1.setRotationPoint(0F, 0F, 0F);
      Sword1Handle1.setTextureSize(128, 128);
      Sword1Handle1.mirror = true;
      setRotation(Sword1Handle1, 0F, 0F, 0F);
      
      Sword1Handle2 = new ModelRenderer(this, 60, 37);
      Sword1Handle2.addBox(0F, -0.6F, -0.5F, 4, 1, 1);
      Sword1Handle2.setRotationPoint(0F, 0F, 0F);
      Sword1Handle2.setTextureSize(128, 128);
      Sword1Handle2.mirror = true;
      setRotation(Sword1Handle2, 0F, 0F, 0F);
      
      Sword1Handle3 = new ModelRenderer(this, 60, 40);
      Sword1Handle3.addBox(0F, -0.5F, -0.4F, 4, 1, 1);
      Sword1Handle3.setRotationPoint(0F, 0F, 0F);
      Sword1Handle3.setTextureSize(128, 128);
      Sword1Handle3.mirror = true;
      setRotation(Sword1Handle3, 0F, 0F, 0F);
      
      Sword1Handle4 = new ModelRenderer(this, 60, 43);
      Sword1Handle4.addBox(0F, -0.5F, -0.6F, 4, 1, 1);
      Sword1Handle4.setRotationPoint(0F, 0F, 0F);
      Sword1Handle4.setTextureSize(128, 128);
      Sword1Handle4.mirror = true;
      setRotation(Sword1Handle4, 0F, 0F, 0F);
      
      Sword2Base = new ModelRenderer(this, 8, 50);
      Sword2Base.addBox(0F, -0.5F, -0.5F, 20, 1, 1);
      Sword2Base.setRotationPoint(0F, 0F, 0F);
      Sword2Base.setTextureSize(128, 128);
      Sword2Base.mirror = true;
      setRotation(Sword2Base, 0F, 0F, -0.0349066F);
      
      Sword2End1 = new ModelRenderer(this, 55, 50);
      Sword2End1.addBox(0F, -0.4F, -0.5F, 2, 1, 1);
      Sword2End1.setRotationPoint(0F, 0F, 0F);
      Sword2End1.setTextureSize(128, 128);
      Sword2End1.mirror = true;
      setRotation(Sword2End1, 0F, 0F, 0F);
      
      Sword2End2 = new ModelRenderer(this, 55, 53);
      Sword2End2.addBox(0F, -0.6F, -0.5F, 2, 1, 1);
      Sword2End2.setRotationPoint(0F, 0F, 0F);
      Sword2End2.setTextureSize(128, 128);
      Sword2End2.mirror = true;
      setRotation(Sword2End2, 0F, 0F, -0.0349066F);
      
      Sword2Handle1 = new ModelRenderer(this, 63, 50);
      Sword2Handle1.addBox(0F, -0.5F, -0.5F, 4, 1, 1);
      Sword2Handle1.setRotationPoint(0F, 0F, 0F);
      Sword2Handle1.setTextureSize(128, 128);
      Sword2Handle1.mirror = true;
      setRotation(Sword2Handle1, 0F, 0F, -0.0349066F);
      
      Sword2Handle2 = new ModelRenderer(this, 63, 53);
      Sword2Handle2.addBox(0F, -0.5F, -0.5F, 4, 1, 1);
      Sword2Handle2.setRotationPoint(0F, 0F, 0F);
      Sword2Handle2.setTextureSize(128, 128);
      Sword2Handle2.mirror = true;
      setRotation(Sword2Handle2, 0F, 0F, -0.0349066F);
      
      Sword2Handle3 = new ModelRenderer(this, 63, 56);
      Sword2Handle3.addBox(0F, -0.5F, -0.5F, 4, 1, 1);
      Sword2Handle3.setRotationPoint(0F, 0F, 0F);
      Sword2Handle3.setTextureSize(128, 128);
      Sword2Handle3.mirror = true;
      setRotation(Sword2Handle3, 0F, 0F, -0.0349066F);
      
      Sword2Handle4 = new ModelRenderer(this, 63, 59);
      Sword2Handle4.addBox(0F, -0.5F, -0.5F, 4, 1, 1);
      Sword2Handle4.setRotationPoint(0F, 0F, 0F);
      Sword2Handle4.setTextureSize(128, 128);
      Sword2Handle4.mirror = true;
      setRotation(Sword2Handle4, 0F, 0F, -0.0349066F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Sword1Base.render(f5);
    Sword1End1.render(f5);
    Sword1End2.render(f5);
    Sword1Handle1.render(f5);
    Sword1Handle2.render(f5);
    Sword1Handle3.render(f5);
    Sword1Handle4.render(f5);
    Sword2Base.render(f5);
    Sword2End1.render(f5);
    Sword2End2.render(f5);
    Sword2Handle1.render(f5);
    Sword2Handle2.render(f5);
    Sword2Handle3.render(f5);
    Sword2Handle4.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
}
