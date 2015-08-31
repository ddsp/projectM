package com.minecraftRPG.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.Entity;

public class ModelBlackPendragonArmorV5_2 extends ModelBiped
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
    ModelRenderer Sword3Base;
    ModelRenderer Sword3End1;
    ModelRenderer Sword3End2;
    ModelRenderer Sword3Handle1;
    ModelRenderer Sword3Handle2;
    ModelRenderer Sword3Handle3;
    ModelRenderer Sword3Handle4;
    ModelRenderer Sword4Base;
    ModelRenderer Sword4End1;
    ModelRenderer Sword4End2;
    ModelRenderer Sword4Handle1;
    ModelRenderer Sword4Handle2;
    ModelRenderer Sword4Handle3;
    ModelRenderer Sword4Handle4;
    ModelRenderer NeckFluff1;
    ModelRenderer NeckFluff2;
    ModelRenderer NeckFluff3;
    ModelRenderer NeckFluff4;
    ModelRenderer NeckFluff5;
  
  public ModelBlackPendragonArmorV5_2(float expand)
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
      
      Sword2Base = new ModelRenderer(this, 8, 33);
      Sword2Base.addBox(4F, 15.5F, -2.5F, 1, 1, 18);
      Sword2Base.setRotationPoint(0F, 0F, 0F);
      Sword2Base.setTextureSize(128, 128);
      Sword2Base.mirror = true;
      setRotation(Sword2Base, -0.3665191F, 0F, 0F);
      
      Sword2End1 = new ModelRenderer(this, 53, 34);
      Sword2End1.addBox(4F, 15.6F, 15.5F, 1, 1, 2);
      Sword2End1.setRotationPoint(0F, 0F, 0F);
      Sword2End1.setTextureSize(128, 128);
      Sword2End1.mirror = true;
      setRotation(Sword2End1, -0.3665191F, 0F, 0F);
      
      Sword2End2 = new ModelRenderer(this, 53, 39);
      Sword2End2.addBox(4F, 15.4F, 15.5F, 1, 1, 2);
      Sword2End2.setRotationPoint(0F, 0F, 0F);
      Sword2End2.setTextureSize(128, 128);
      Sword2End2.mirror = true;
      setRotation(Sword2End2, -0.3665191F, 0F, 0F);
      
      Sword2Handle1 = new ModelRenderer(this, 75, 34);
      Sword2Handle1.addBox(4F, 15.6F, -6.5F, 1, 1, 4);
      Sword2Handle1.setRotationPoint(0F, 0F, 0F);
      Sword2Handle1.setTextureSize(128, 128);
      Sword2Handle1.mirror = true;
      setRotation(Sword2Handle1, -0.3665191F, 0F, 0F);
      
      Sword2Handle2 = new ModelRenderer(this, 87, 37);
      Sword2Handle2.addBox(4F, 15.4F, -6.5F, 1, 1, 4);
      Sword2Handle2.setRotationPoint(0F, 0F, 0F);
      Sword2Handle2.setTextureSize(128, 128);
      Sword2Handle2.mirror = true;
      setRotation(Sword2Handle2, -0.3665191F, 0F, 0F);
      
      Sword2Handle3 = new ModelRenderer(this, 75, 40);
      Sword2Handle3.addBox(3.9F, 15.5F, -6.5F, 1, 1, 4);
      Sword2Handle3.setRotationPoint(0F, 0F, 0F);
      Sword2Handle3.setTextureSize(128, 128);
      Sword2Handle3.mirror = true;
      setRotation(Sword2Handle3, -0.3665191F, 0F, 0F);
      
      Sword2Handle4 = new ModelRenderer(this, 87, 43);
      Sword2Handle4.addBox(4.1F, 15.5F, -6.5F, 1, 1, 4);
      Sword2Handle4.setRotationPoint(0F, 0F, 0F);
      Sword2Handle4.setTextureSize(128, 128);
      Sword2Handle4.mirror = true;
      setRotation(Sword2Handle4, -0.3665191F, 0F, 0F);
      
      Sword3Base = new ModelRenderer(this, 8, 33);
      Sword3Base.addBox(4F, 12.7F, -1.3F, 1, 1, 18);
      Sword3Base.setRotationPoint(0F, 0F, 0F);
      Sword3Base.setTextureSize(128, 128);
      Sword3Base.mirror = true;
      setRotation(Sword3Base, -0.4537856F, 0F, 0F);
      
      Sword3End1 = new ModelRenderer(this, 53, 39);
      Sword3End1.addBox(4F, 12.6F, 16.7F, 1, 1, 2);
      Sword3End1.setRotationPoint(0F, 0F, 0F);
      Sword3End1.setTextureSize(128, 128);
      Sword3End1.mirror = true;
      setRotation(Sword3End1, -0.4537856F, 0F, 0F);
      
      Sword3End2 = new ModelRenderer(this, 53, 39);
      Sword3End2.addBox(4F, 12.8F, 16.7F, 1, 1, 2);
      Sword3End2.setRotationPoint(0F, 0F, 0F);
      Sword3End2.setTextureSize(128, 128);
      Sword3End2.mirror = true;
      setRotation(Sword3End2, -0.4537856F, 0F, 0F);
      
      Sword3Handle1 = new ModelRenderer(this, 75, 34);
      Sword3Handle1.addBox(4F, 12.8F, -5.3F, 1, 1, 4);
      Sword3Handle1.setRotationPoint(0F, 0F, 0F);
      Sword3Handle1.setTextureSize(128, 128);
      Sword3Handle1.mirror = true;
      setRotation(Sword3Handle1, -0.4537856F, 0F, 0F);
      
      Sword3Handle2 = new ModelRenderer(this, 87, 37);
      Sword3Handle2.addBox(4F, 12.6F, -5.3F, 1, 1, 4);
      Sword3Handle2.setRotationPoint(0F, 0F, 0F);
      Sword3Handle2.setTextureSize(128, 128);
      Sword3Handle2.mirror = true;
      setRotation(Sword3Handle2, -0.4537856F, 0F, 0F);
      
      Sword3Handle3 = new ModelRenderer(this, 75, 40);
      Sword3Handle3.addBox(3.9F, 12.7F, -5.3F, 1, 1, 4);
      Sword3Handle3.setRotationPoint(0F, 0F, 0F);
      Sword3Handle3.setTextureSize(128, 128);
      Sword3Handle3.mirror = true;
      setRotation(Sword3Handle3, -0.4537856F, 0F, 0F);
      
      Sword3Handle4 = new ModelRenderer(this, 87, 43);
      Sword3Handle4.addBox(4.1F, 12.7F, -5.3F, 1, 1, 4);
      Sword3Handle4.setRotationPoint(0F, 0F, 0F);
      Sword3Handle4.setTextureSize(128, 128);
      Sword3Handle4.mirror = true;
      setRotation(Sword3Handle4, -0.4537856F, 0F, 0F);
      
      Sword4Base = new ModelRenderer(this, 8, 33);
      Sword4Base.addBox(-5F, 12.7F, -1.3F, 1, 1, 18);
      Sword4Base.setRotationPoint(0F, 0F, 0F);
      Sword4Base.setTextureSize(128, 128);
      Sword4Base.mirror = true;
      setRotation(Sword4Base, -0.4537856F, 0F, 0F);
      
      Sword4End1 = new ModelRenderer(this, 53, 39);
      Sword4End1.addBox(-5F, 12.6F, 16.7F, 1, 1, 2);
      Sword4End1.setRotationPoint(0F, 0F, 0F);
      Sword4End1.setTextureSize(128, 128);
      Sword4End1.mirror = true;
      setRotation(Sword4End1, -0.4537856F, 0F, 0F);
      
      Sword4End2 = new ModelRenderer(this, 53, 39);
      Sword4End2.addBox(-5F, 12.8F, 16.7F, 1, 1, 2);
      Sword4End2.setRotationPoint(0F, 0F, 0F);
      Sword4End2.setTextureSize(128, 128);
      Sword4End2.mirror = true;
      setRotation(Sword4End2, -0.4537856F, 0F, 0F);
      
      Sword4Handle1 = new ModelRenderer(this, 75, 34);
      Sword4Handle1.addBox(-5F, 12.8F, -5.3F, 1, 1, 4);
      Sword4Handle1.setRotationPoint(0F, 0F, 0F);
      Sword4Handle1.setTextureSize(128, 128);
      Sword4Handle1.mirror = true;
      setRotation(Sword4Handle1, -0.4537856F, 0F, 0F);
      
      Sword4Handle2 = new ModelRenderer(this, 87, 37);
      Sword4Handle2.addBox(-5F, 12.6F, -5.3F, 1, 1, 4);
      Sword4Handle2.setRotationPoint(0F, 0F, 0F);
      Sword4Handle2.setTextureSize(128, 128);
      Sword4Handle2.mirror = true;
      setRotation(Sword4Handle2, -0.4537856F, 0F, 0F);
      
      Sword4Handle3 = new ModelRenderer(this, 75, 40);
      Sword4Handle3.addBox(-5.1F, 12.7F, -5.3F, 1, 1, 4);
      Sword4Handle3.setRotationPoint(0F, 0F, 0F);
      Sword4Handle3.setTextureSize(128, 128);
      Sword4Handle3.mirror = true;
      setRotation(Sword4Handle3, -0.4537856F, 0F, 0F);
      
      Sword4Handle4 = new ModelRenderer(this, 87, 43);
      Sword4Handle4.addBox(-4.9F, 12.7F, -5.3F, 1, 1, 4);
      Sword4Handle4.setRotationPoint(0F, 0F, 0F);
      Sword4Handle4.setTextureSize(128, 128);
      Sword4Handle4.mirror = true;
      setRotation(Sword4Handle4, -0.4537856F, 0F, 0F);
      
      NeckFluff1 = new ModelRenderer(this, 58, 0);
      NeckFluff1.addBox(4F, -2F, -5F, 1, 2, 10);
      NeckFluff1.setRotationPoint(0F, 0F, 0F);
      NeckFluff1.setTextureSize(128, 128);
      NeckFluff1.mirror = true;
      setRotation(NeckFluff1, 0F, 0F, 0F);
      
      NeckFluff2 = new ModelRenderer(this, 58, 13);
      NeckFluff2.addBox(-4F, -2F, 4F, 8, 2, 1);
      NeckFluff2.setRotationPoint(0F, 0F, 0F);
      NeckFluff2.setTextureSize(128, 128);
      NeckFluff2.mirror = true;
      setRotation(NeckFluff2, 0F, 0F, 0F);
      
      NeckFluff3 = new ModelRenderer(this, 58, 0);
      NeckFluff3.addBox(-5F, -2F, -5F, 1, 2, 10);
      NeckFluff3.setRotationPoint(0F, 0F, 0F);
      NeckFluff3.setTextureSize(128, 128);
      NeckFluff3.mirror = true;
      setRotation(NeckFluff3, 0F, 0F, 0F);
      
      NeckFluff4 = new ModelRenderer(this, 52, 0);
      NeckFluff4.addBox(-4F, -2F, -6F, 1, 2, 1);
      NeckFluff4.setRotationPoint(0F, 0F, 0F);
      NeckFluff4.setTextureSize(128, 128);
      NeckFluff4.mirror = true;
      setRotation(NeckFluff4, 0F, 0F, 0F);
      
      NeckFluff5 = new ModelRenderer(this, 52, 0);
      NeckFluff5.addBox(3F, -2F, -6F, 1, 2, 1);
      NeckFluff5.setRotationPoint(0F, 0F, 0F);
      NeckFluff5.setTextureSize(128, 128);
      NeckFluff5.mirror = true;
      setRotation(NeckFluff5, 0F, 0F, 0F);
      
      this.bipedHead.addChild(NeckFluff1);
      this.bipedHead.addChild(NeckFluff2);
      this.bipedHead.addChild(NeckFluff3);
      this.bipedHead.addChild(NeckFluff4);
      this.bipedHead.addChild(NeckFluff5);
      
      this.bipedBody.addChild(Sword1Base);
      this.bipedBody.addChild(Sword1End1);
      this.bipedBody.addChild(Sword1End2);
      this.bipedBody.addChild(Sword1Handle1);
      this.bipedBody.addChild(Sword1Handle2);
      this.bipedBody.addChild(Sword1Handle3);
      this.bipedBody.addChild(Sword1Handle4);
      
      this.bipedBody.addChild(Sword2Base);
      this.bipedBody.addChild(Sword2End1);
      this.bipedBody.addChild(Sword2End2);
      this.bipedBody.addChild(Sword2Handle1);
      this.bipedBody.addChild(Sword2Handle2);
      this.bipedBody.addChild(Sword2Handle3);
      this.bipedBody.addChild(Sword2Handle4);
      
      this.bipedBody.addChild(Sword3Base);
      this.bipedBody.addChild(Sword3End1);
      this.bipedBody.addChild(Sword3End2);
      this.bipedBody.addChild(Sword3Handle1);
      this.bipedBody.addChild(Sword3Handle2);
      this.bipedBody.addChild(Sword3Handle3);
      this.bipedBody.addChild(Sword3Handle4);
      
      this.bipedBody.addChild(Sword4Base);
      this.bipedBody.addChild(Sword4End1);
      this.bipedBody.addChild(Sword4End2);
      this.bipedBody.addChild(Sword4Handle1);
      this.bipedBody.addChild(Sword4Handle2);
      this.bipedBody.addChild(Sword4Handle3);
      this.bipedBody.addChild(Sword4Handle4);
      
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
