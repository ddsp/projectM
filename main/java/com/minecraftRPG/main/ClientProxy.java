package com.minecraftRPG.main;

import com.minecraftRPG.mobs.BlackWolf;
import com.minecraftRPG.mobs.EntityBlackWolf;
import com.minecraftRPG.mobs.EntitySpiritWolf;
import com.minecraftRPG.mobs.RenderBlackWolf;
import com.minecraftRPG.mobs.RenderSpiritWolf;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy{
	
	public void registerRenderThings(){
		RenderingRegistry.registerEntityRenderingHandler(EntityBlackWolf.class, new RenderBlackWolf(new BlackWolf(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntitySpiritWolf.class, new RenderSpiritWolf(new BlackWolf(), 0));
	}

}
