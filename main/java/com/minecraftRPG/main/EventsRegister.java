package com.minecraftRPG.main;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraftforge.common.MinecraftForge;

public class EventsRegister {
	
	public static void RegisterEvents(){
		FMLCommonHandler.instance().bus().register(new EventsLibrary());
		MinecraftForge.EVENT_BUS.register(new EventsLibrary());
	}
}
