package com.minecraftRPG.mobs;

import com.minecraftRPG.lib.Strings;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderBlackWolf extends RenderLiving {
	
	private static final ResourceLocation mobTextures = new ResourceLocation(Strings.MODID + ":textures/entity/blackWolf.png");
	private static final String __OBFID = "CL_00000984";
	
	public RenderBlackWolf(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
	}
	
	protected ResourceLocation getEntityTexture(EntityBlackWolf entity){
		return mobTextures;
	}
	
	protected ResourceLocation getEntityTexture(Entity entity){
		return this.getEntityTexture((EntityBlackWolf)entity);
	}
}
