package com.minecraftRPG.GUI;

import org.lwjgl.opengl.GL11;

import com.minecraftRPG.lib.Strings;
import com.sun.org.apache.xml.internal.security.encryption.Reference;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class ritualsGUI extends GuiScreen{
	int guiWidth = 90;
	int guiHeight = 15; 
	
	@Override
	public void drawScreen(int x, int y, float ticks){
		int guiX = 50;
		int guiY = 50;
		GL11.glColor4f(1, 1, 1, 1);
		mc.renderEngine.bindTexture(new ResourceLocation(Strings.IMGMODID+":textures/gui/Limiter_FullArmorGUI(5).png"));
		drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth, guiHeight);
		
		super.drawScreen(x, y, ticks);
	}

    @Override
    protected void keyTyped(char p_73869_1_, int p_73869_2_)
    {
    	if (p_73869_2_ == 1)
        {
            this.mc.displayGuiScreen((GuiScreen)null);
            this.mc.setIngameFocus();
        }
    }
    
    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }
}
