package com.minecraftRPG.GUI;

import org.lwjgl.opengl.GL11;

import com.minecraftRPG.lib.Strings;
import com.sun.org.apache.xml.internal.security.encryption.Reference;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class ritualsGUI extends GuiScreen{
	int guiWidth = 86;
	int guiHeight = 14; 
	
	@Override
	public void drawScreen(int x, int y, float ticks){
		int guiX = 0;
		int guiY = 0;
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	    GL11.glDisable(GL11.GL_LIGHTING); 
		ResourceLocation r = new ResourceLocation(Strings.IMGMODID+":textures/gui/Limiter_FullArmorGUI(5).png");
		mc.renderEngine.bindTexture(new ResourceLocation(Strings.IMGMODID+":textures/gui/Limiter_FullArmorGUI.png"));
		drawTexturedModalRect(guiX, guiY, 1, 1, guiWidth, guiHeight);
		
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
