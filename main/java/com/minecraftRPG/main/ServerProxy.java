package com.minecraftRPG.main;

import com.minecraftRPG.GUI.MinecraftRPGGuiHandler;
import com.minecraftRPG.lib.Strings;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class ServerProxy {
	public void registerRenderThings(){
		
	}
	
	public void registerNetworkStuff(){
		NetworkRegistry.INSTANCE.registerGuiHandler(MinecraftRPG.instance, new MinecraftRPGGuiHandler());
	}
	
	public void generateMysteriousParticles(Entity player) { }
	
	public ModelBiped getArmorModel(int id){
		
		return null;
	}
}
