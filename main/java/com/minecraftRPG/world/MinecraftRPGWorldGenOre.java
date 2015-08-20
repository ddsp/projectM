package com.minecraftRPG.world;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class MinecraftRPGWorldGenOre {
	
	public static void mainRegistry(){
		initWorldGen();
	}
	
	public static void initWorldGen(){
		registerWorldGen(new WorldGenSilver(), 1);
	}
	
	public static void registerWorldGen(IWorldGenerator worldGenClass, int weightedProbabaility){
		GameRegistry.registerWorldGenerator(worldGenClass, weightedProbabaility);
	}
}
