package com.minecraftRPG.main;

import com.minecraftRPG.mobs.BlackWolf;
import com.minecraftRPG.mobs.EntityBlackWolf;
import com.minecraftRPG.mobs.RenderBlackWolf;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy{
	
	public void registerRenderThings(){
		RenderingRegistry.registerEntityRenderingHandler(EntityBlackWolf.class, new RenderBlackWolf(new BlackWolf(), 0));
	}

}
