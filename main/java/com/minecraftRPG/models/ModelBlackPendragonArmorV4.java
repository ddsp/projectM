package com.minecraftRPG.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.Entity;

public class ModelBlackPendragonArmorV4 extends ModelBiped
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
    ModelRenderer Helmet;
    ModelRenderer Chest;
    ModelRenderer SholderRight;
    ModelRenderer SholderLeft;
  
  public ModelBlackPendragonArmorV4(float expand)
  {
	  super(expand, 0, 128, 128);
    
	  Sword1Base = new ModelRenderer(this, 8, 33);
      Sword1Base.addBox(-5F, 15.5F, -2.5F, 1, 1, 18);
      Sword1Base.setRotationPoint(0F, 0F, 0F);
      Sword1Base.setTextureSize(128, 128);
      Sword1Base.mirror = true;
      setRotation(Sword1Base, -0.3665191F, 0F, 0F);
      
      Sword1End1 = new ModelRenderer(this, 53, 34);
      Sword1End1.addBox(-5F, 15.6F, 15.5F, 1, 1, 2);
      Sword1End1.setRotationPoint(0F, 0F, 0F);
      Sword1End1.setTextureSize(128, 128);
      Sword1End1.mirror = true;
      setRotation(Sword1End1, -0.3665191F, 0F, 0F);
      
      Sword1End2 = new ModelRenderer(this, 53, 39);
      Sword1End2.addBox(-5F, 15.4F, 15.5F, 1, 1, 2);
      Sword1End2.setRotationPoint(0F, 0F, 0F);
      Sword1End2.setTextureSize(128, 128);
      Sword1End2.mirror = true;
      setRotation(Sword1End2, -0.3665191F, 0F, 0F);
      
      Sword1Handle1 = new ModelRenderer(this, 75, 34);
      Sword1Handle1.addBox(-5F, 15.6F, -6.5F, 1, 1, 4);
      Sword1Handle1.setRotationPoint(0F, 0F, 0F);
      Sword1Handle1.setTextureSize(128, 128);
      Sword1Handle1.mirror = true;
      setRotation(Sword1Handle1, -0.3665191F, 0F, 0F);
      
      Sword1Handle2 = new ModelRenderer(this, 87, 37);
      Sword1Handle2.addBox(-5F, 15.4F, -6.5F, 1, 1, 4);
      Sword1Handle2.setRotationPoint(0F, 0F, 0F);
      Sword1Handle2.setTextureSize(128, 128);
      Sword1Handle2.mirror = true;
      setRotation(Sword1Handle2, -0.3665191F, 0F, 0F);
      
      Sword1Handle3 = new ModelRenderer(this, 75, 40);
      Sword1Handle3.addBox(-5.1F, 15.5F, -6.5F, 1, 1, 4);
      Sword1Handle3.setRotationPoint(0F, 0F, 0F);
      Sword1Handle3.setTextureSize(128, 128);
      Sword1Handle3.mirror = true;
      setRotation(Sword1Handle3, -0.3665191F, 0F, 0F);
      
      Sword1Handle4 = new ModelRenderer(this, 87, 43);
      Sword1Handle4.addBox(-4.9F, 15.5F, -6.5F, 1, 1, 4);
      Sword1Handle4.setRotationPoint(0F, 0F, 0F);
      Sword1Handle4.setTextureSize(128, 128);
      Sword1Handle4.mirror = true;
      setRotation(Sword1Handle4, -0.3665191F, 0F, 0F);
      
      Helmet = new ModelRenderer(this, 0, 57);
      Helmet.addBox(-4.5F, -8.5F, -4.5F, 9, 9, 9);
      Helmet.setRotationPoint(0F, 0F, 0F);
      Helmet.setTextureSize(128, 128);
      Helmet.mirror = true;
      setRotation(Helmet, 0F, 0F, 0F);
      
      Chest = new ModelRenderer(this, 1, 77);
      Chest.addBox(-4F, 0F, -2.5F, 8, 12, 5);
      Chest.setRotationPoint(0F, 0F, 0F);
      Chest.setTextureSize(128, 128);
      Chest.mirror = true;
      setRotation(Chest, 0F, 0F, 0F);
      
      SholderRight = new ModelRenderer(this, 29, 77);
      SholderRight.addBox(-3.5F, -2.5F, -2.5F, 5, 5, 5);
      SholderRight.setRotationPoint(0F, 0F, 0F);
      SholderRight.setTextureSize(128, 128);
      SholderRight.mirror = true;
      setRotation(SholderRight, 0F, 0F, 0F);
      
      SholderLeft = new ModelRenderer(this, 51, 77);
      SholderLeft.addBox(-1.5F, -2.5F, -2.5F, 5, 5, 5);
      SholderLeft.setRotationPoint(0F, 0F, 0F);
      SholderLeft.setTextureSize(128, 128);
      SholderLeft.mirror = true;
      setRotation(SholderLeft, 0F, 0F, 0F);
      
      this.bipedHead.addChild(Helmet);
      this.bipedRightArm.addChild(SholderRight);
      this.bipedLeftArm.addChild(SholderLeft);
      this.bipedBody.addChild(Sword1Base);
      this.bipedBody.addChild(Sword1End1);
      this.bipedBody.addChild(Sword1End2);
      this.bipedBody.addChild(Sword1Handle1);
      this.bipedBody.addChild(Sword1Handle2);
      this.bipedBody.addChild(Sword1Handle3);
      this.bipedBody.addChild(Sword1Handle4);
      
      
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }
  
  public void render1(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

}
