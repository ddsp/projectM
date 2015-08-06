package com.minecraftRPG.tileEntity;

import com.minecraftRPG.blocks.spawner;
import com.minecraftRPG.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;

public class MinecraftRPGtileEntity {
	
	public static void mainRegistry(){
		registerTileEntities();
	}
	
	private static void registerTileEntities(){
		GameRegistry.registerTileEntity(TileEntitySpawnerB.class, Strings.MODID);
	}
}
