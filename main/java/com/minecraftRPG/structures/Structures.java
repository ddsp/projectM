package com.minecraftRPG.structures;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

public class Structures implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX,int chunkZ, World world, IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {
		
		if(random.nextInt(200) > 198){
			int x = chunkX * 16 + random.nextInt(16);
            int z = chunkZ * 16 + random.nextInt(16);
           
            BiomeGenBase biome = world.getBiomeGenForCoords(x, z);
           
            if(biome.biomeID == 1 ||
               biome.biomeID == 3)
            {
                new test(x, -1, z, world);
                System.out.println(x + "    " + z);
            }
		}	
	}

}
