package com.minecraftRPG.particles;

import org.lwjgl.opengl.GL11;

import com.minecraftRPG.lib.Strings;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.particle.EntityAuraFX;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class SwordSouls  extends EntityFX
{
	
	private static final ResourceLocation texture = new ResourceLocation(Strings.IMGMODID, "textures/items/SilverIngot.png");
	
    public SwordSouls(World parWorld, double parX, double parY, double parZ) 
    {
        super(parWorld, parX, parY, parZ);
        setGravity(0);
        setMaxAge(50);
        
    }
    
    @Override
	public void renderParticle(Tessellator t, float par2, float par3, float par4, float par5, float par6, float par7) {
    	FMLClientHandler.instance().getClient().getTextureManager().bindTexture(this.texture);
		GL11.glDepthMask(false);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glAlphaFunc(GL11.GL_GREATER, 0.003921569f);
		t.startDrawingQuads();
		t.setBrightness(getBrightnessForRender(par2));
		float scale = 0.1F*particleScale;
        float f11 = (float)(this.prevPosX + (this.posX - this.prevPosX) * par2 - interpPosX);
        float f12 = (float)(this.prevPosY + (this.posY - this.prevPosY) * par2 - interpPosY);
        float f13 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * par2 - interpPosZ);
        t.addVertexWithUV(f11 - par3 * scale - par6 * scale, f12 - par4 * scale, f13 - par5 * scale - par7 * scale, 0, 0);
        t.addVertexWithUV(f11 - par3 * scale + par6 * scale, f12 + par4 * scale, f13 - par5 * scale + par7 * scale, 1, 0);
        t.addVertexWithUV(f11 + par3 * scale + par6 * scale, f12 + par4 * scale, f13 + par5 * scale + par7 * scale, 1, 1);
        t.addVertexWithUV(f11 + par3 * scale - par6 * scale, f12 - par4 * scale, f13 + par5 * scale - par7 * scale, 0, 1);
        t.draw();
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glDepthMask(true);
        GL11.glAlphaFunc(GL11.GL_GREATER, 0.1f);
	}
    
    @Override
    public int getFXLayer(){
    	return 3;
    }
    
    public SwordSouls setMaxAge(int maxAge){
    	particleMaxAge = maxAge;
    	return this;
    }
    
    public SwordSouls setGravity(int gravity){
    	particleGravity = gravity;
    	return this;
    }
    
    public SwordSouls setScale(int scale){
    	particleScale = scale;
    	return this;
    }    
}
