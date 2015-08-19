package com.minecraftRPG.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class AlterPedestalModel extends ModelBase
{
  //fields
    ModelRenderer PedestalBase1;
    ModelRenderer PedestalBase2;
    ModelRenderer PedestalPilar;
    ModelRenderer PedestalTable;
    ModelRenderer Coner1_1;
    ModelRenderer Coner1_2;
    ModelRenderer Coner2_1;
    ModelRenderer Coner2_2;
    ModelRenderer Coner3_1;
    ModelRenderer Coner3_2;
    ModelRenderer Coner4_1;
    ModelRenderer Coner4_2;
  
  public AlterPedestalModel()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      PedestalBase1 = new ModelRenderer(this, 0, 0);
      PedestalBase1.addBox(-7F, 0F, -7F, 14, 2, 14);
      PedestalBase1.setRotationPoint(0F, 20F, 0F);
      PedestalBase1.setTextureSize(128, 64);
      PedestalBase1.mirror = true;
      setRotation(PedestalBase1, 0F, 0F, 0F);
      PedestalBase2 = new ModelRenderer(this, 0, 17);
      PedestalBase2.addBox(-8F, 0F, -8F, 16, 2, 16);
      PedestalBase2.setRotationPoint(0F, 22F, 0F);
      PedestalBase2.setTextureSize(128, 64);
      PedestalBase2.mirror = true;
      setRotation(PedestalBase2, 0F, 0F, 0F);
      PedestalPilar = new ModelRenderer(this, 0, 37);
      PedestalPilar.addBox(-3F, 0F, -3F, 6, 9, 6);
      PedestalPilar.setRotationPoint(0F, 11F, 0F);
      PedestalPilar.setTextureSize(128, 64);
      PedestalPilar.mirror = true;
      setRotation(PedestalPilar, 0F, 0F, 0F);
      PedestalTable = new ModelRenderer(this, 61, 0);
      PedestalTable.addBox(-6F, 0F, -6F, 12, 2, 12);
      PedestalTable.setRotationPoint(0F, 9F, 0F);
      PedestalTable.setTextureSize(128, 64);
      PedestalTable.mirror = true;
      setRotation(PedestalTable, 0F, 0F, 0F);
      Coner1_1 = new ModelRenderer(this, 67, 17);
      Coner1_1.addBox(0F, 0F, -1F, 1, 1, 3);
      Coner1_1.setRotationPoint(5F, 8F, 4F);
      Coner1_1.setTextureSize(128, 64);
      Coner1_1.mirror = true;
      setRotation(Coner1_1, 0F, 0F, 0F);
      Coner1_2 = new ModelRenderer(this, 77, 17);
      Coner1_2.addBox(-2F, 0F, 0F, 3, 1, 1);
      Coner1_2.setRotationPoint(5F, 8F, 5F);
      Coner1_2.setTextureSize(128, 64);
      Coner1_2.mirror = true;
      setRotation(Coner1_2, 0F, 0F, 0F);
      Coner2_1 = new ModelRenderer(this, 92, 17);
      Coner2_1.addBox(0F, 0F, -1F, 1, 1, 3);
      Coner2_1.setRotationPoint(5F, 8F, -5F);
      Coner2_1.setTextureSize(128, 64);
      Coner2_1.mirror = true;
      setRotation(Coner2_1, 0F, 0F, 0F);
      Coner2_2 = new ModelRenderer(this, 102, 17);
      Coner2_2.addBox(-2F, 0F, -1F, 3, 1, 1);
      Coner2_2.setRotationPoint(5F, 8F, -5F);
      Coner2_2.setTextureSize(128, 64);
      Coner2_2.mirror = true;
      setRotation(Coner2_2, 0F, 0F, 0F);
      Coner3_1 = new ModelRenderer(this, 67, 25);
      Coner3_1.addBox(-1F, 0F, -1F, 3, 1, 1);
      Coner3_1.setRotationPoint(-5F, 8F, -5F);
      Coner3_1.setTextureSize(128, 64);
      Coner3_1.mirror = true;
      setRotation(Coner3_1, 0F, 0F, 0F);
      Coner3_2 = new ModelRenderer(this, 77, 25);
      Coner3_2.addBox(-1F, 0F, -1F, 1, 1, 3);
      Coner3_2.setRotationPoint(-5F, 8F, -5F);
      Coner3_2.setTextureSize(128, 64);
      Coner3_2.mirror = true;
      setRotation(Coner3_2, 0F, 0F, 0F);
      Coner4_1 = new ModelRenderer(this, 92, 25);
      Coner4_1.addBox(-1F, 0F, 0F, 3, 1, 1);
      Coner4_1.setRotationPoint(-5F, 8F, 5F);
      Coner4_1.setTextureSize(128, 64);
      Coner4_1.mirror = true;
      setRotation(Coner4_1, 0F, 0F, 0F);
      Coner4_2 = new ModelRenderer(this, 102, 25);
      Coner4_2.addBox(-1F, 0F, -2F, 1, 1, 3);
      Coner4_2.setRotationPoint(-5F, 8F, 5F);
      Coner4_2.setTextureSize(128, 64);
      Coner4_2.mirror = true;
      setRotation(Coner4_2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    PedestalBase1.render(f5);
    PedestalBase2.render(f5);
    PedestalPilar.render(f5);
    PedestalTable.render(f5);
    Coner1_1.render(f5);
    Coner1_2.render(f5);
    Coner2_1.render(f5);
    Coner2_2.render(f5);
    Coner3_1.render(f5);
    Coner3_2.render(f5);
    Coner4_1.render(f5);
    Coner4_2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
