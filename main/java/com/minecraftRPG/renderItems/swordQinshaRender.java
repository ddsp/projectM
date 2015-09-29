package com.minecraftRPG.renderItems;

import org.lwjgl.opengl.GL11;

import com.minecraftRPG.lib.Strings;
import com.minecraftRPG.models.Unsheaded_Orb;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

@SideOnly(Side.CLIENT)
public class swordQinshaRender implements IItemRenderer{

	private Unsheaded_Orb swordModel;
	   
	   public swordQinshaRender()
	   {
	      this.swordModel = new Unsheaded_Orb();
	   }

	   @Override
	   public boolean handleRenderType(ItemStack item, ItemRenderType type) 
	   {
	      switch(type)
	      {
	      case EQUIPPED:
	      case EQUIPPED_FIRST_PERSON: 
	    	  return true;
	      default: return false;
	      }
	   }

	   @Override
	   public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
	         ItemRendererHelper helper) 
	   {
	      return false;
	   }

	   @Override
	   public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	   {
	      switch(type)
	      {
	         case EQUIPPED:
	         case EQUIPPED_FIRST_PERSON:
	         {
	            
	            GL11.glPushMatrix();
	            
	            //Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Strings.IMGMODID + ":things.png"));
	            
	            GL11.glRotatef(0.0F,  0.0F, 0.0F, 1.0F);
	            GL11.glRotatef(180.0F,  1.0F, 0.0F, 0.0F);
	            GL11.glRotatef(-45.0F,  0.0F, 0.0F, 1.0F);
	            
	            GL11.glTranslatef(0.7F, 0.15F, 0.0f);
	            
	            swordModel.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
	            
	            GL11.glPopMatrix();
	            break;
	      
	         }
	         default:
	            break;
	      }
	   }

}
