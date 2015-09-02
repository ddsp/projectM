package com.minecraftRPG.mobs;

import com.minecraftRPG.main.MinecraftRPG;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

public class MinecraftRPGEntitys {
	
	public static void mainRegistry(){
		registerEntity();
	}
	
	public static void registerEntity(){
		createEntity(EntityBlackWolf.class, "BlackWolf", 0x0004FF, 0xFF00E1, true);
		createEntity(EntitySpiritWolf.class, "SpiritWolf", 0x0004FF, 0xFF00E1, true);
		createEntity(IvisiProj.class, "InvisiTestTr", 0x0004FF, 0xFF00E1, false);
		createEntity(EntityFlyingTestC.class, "FlyingTestC", 0x0004FF, 0xFF00E1, false);
		createEntity(EntityFlyingTest.class, "FlyingTest", 0x0004FF, 0xFF00E1, false);
	}

	public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor, boolean spawns){
		int randomId = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomId);
		EntityRegistry.registerModEntity(entityClass, entityName, randomId, MinecraftRPG.instance, 64, 1, true);
		if(spawns){
			EntityRegistry.addSpawn(entityClass, 2, 0, 1, EnumCreatureType.creature, BiomeGenBase.forest);
			createEgg(randomId, solidColor, spotColor);
		}	
		
	}
	
	private static void createEgg(int randomId, int solidColor, int spotColor){
		EntityList.entityEggs.put(Integer.valueOf(randomId), new EntityList.EntityEggInfo(randomId, solidColor, spotColor));	
	}
}
