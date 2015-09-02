package com.minecraftRPG.mobs;

import com.minecraftRPG.lib.Strings;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderTestFlyingEntityC extends RenderLiving {
	
	private static final ResourceLocation mobTextures = new ResourceLocation(Strings.MODID + ":textures/entity/blackWolf.png");
	private static final String __OBFID = "CL_00000984";
	
	public RenderTestFlyingEntityC(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
	}
	
	protected ResourceLocation getEntityTexture(EntityFlyingTestC entity){
		return mobTextures;
	}
	
	protected ResourceLocation getEntityTexture(Entity entity){
		return this.getEntityTexture((EntityFlyingTestC)entity);
	}
}
