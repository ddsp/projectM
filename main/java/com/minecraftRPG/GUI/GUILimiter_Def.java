package com.minecraftRPG.GUI;

import java.util.Collection;

import org.lwjgl.opengl.GL11;

import com.minecraftRPG.lib.Strings;

import cpw.mods.fml.common.eventhandler.EventPriority;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

public class GUILimiter_Def extends Gui {
	
	Minecraft mc;
	private static ResourceLocation[] armorLimiterText = 
	          new ResourceLocation[5];
	
	public GUILimiter_Def(Minecraft mc)
	{
		super();
		
		this.mc = mc;
		
		armorLimiterText[4] = new ResourceLocation(
				Strings.IMGMODID+":textures/gui/Limiter_FullArmorGUI(5).png");
		mc.getTextureManager().bindTexture(armorLimiterText[4]);		
		this.drawTexturedModalRect(0, 0, 0, 0, 90, 15);
    }
}
