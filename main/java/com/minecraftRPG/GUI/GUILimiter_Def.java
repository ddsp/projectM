package com.minecraftRPG.GUI;

import org.lwjgl.opengl.GL11;

import com.minecraftRPG.armor.MinecraftRPGArmor;
import com.minecraftRPG.lib.Strings;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

public class GUILimiter_Def extends Gui {
	
	Minecraft mc;
	
	public GUILimiter_Def(Minecraft mc)
	{
		super();
		
		this.mc = mc;
    }
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRenderExperienceBar(RenderGameOverlayEvent event)
	{
		if(event.isCancelable() || event.type != ElementType.EXPERIENCE)
	    {      
			return;
	    }
		

		EntityPlayer player = this.mc.thePlayer;
		Boolean veri = true;
		for(ItemStack piece : player.inventory.armorInventory){
			if(piece == null || !(
					piece.getItem().equals(MinecraftRPGArmor.PendragonHelmet) ||
					piece.getItem().equals(MinecraftRPGArmor.PendragonChestplate) ||
					piece.getItem().equals(MinecraftRPGArmor.PendragonLeggins) ||
					piece.getItem().equals(MinecraftRPGArmor.PendragonBoots))){
				veri = false;
			}
		}
		//System.out.println(veri);
		
		if(veri){
			int guiX = 0;
			int guiY = 0;
			
			int guiWidth = 86;
			int guiHeight = 14; 
			
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		    GL11.glDisable(GL11.GL_LIGHTING); 
			mc.renderEngine.bindTexture(new ResourceLocation(Strings.IMGMODID+":textures/gui/Limiter_FullArmorGUI.png"));
			
			drawTexturedModalRect(guiX, guiY, 1, 1+guiHeight*4, guiWidth, guiHeight);
		}
	}
}
