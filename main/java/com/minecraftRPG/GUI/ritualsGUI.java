package com.minecraftRPG.GUI;

import org.lwjgl.opengl.GL11;

import com.minecraftRPG.lib.Strings;
import com.sun.org.apache.xml.internal.security.encryption.Reference;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class ritualsGUI extends GuiScreen{
	int guiWidth = 148;
	int guiHeight = 80; 
	
	@Override
	public void drawScreen(int x, int y, float ticks){
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) / 2;
		GL11.glColor4f(1, 1, 1, 1);
		drawDefaultBackground();
		mc.renderEngine.bindTexture(new ResourceLocation(Strings.IMGMODID+":textures/gui/testGui.png"));
		drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth, guiHeight);
		
		super.drawScreen(x, y, ticks);
	}
}
