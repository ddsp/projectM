package com.minecraftRPG.structures;

import com.minecraftRPG.blocks.MinecraftRPGBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class test {
	
	World world;
	
	public test(int x, int y,int z,World worldd){
		world = worldd;
		
		if(y == -1){
			y = findGLev(x, z, world) - 1;
		}
		
		world.setBlock(x, y, z, Blocks.planks);
		
		int limit = z + 3;
		
		
		fazer_chaoParede(z - 3, x, y, z + 3, y + 3, 1, "s");
		fazer_chaoParede(z - 6, x-1, y, z + 6, y + 3, 3, "s");
		fazer_chaoParede(z - 8, x-2, y, z + 8, y + 3, 2,"s");
		fazer_chaoParede(z - 9, x-3, y, z + 9, y + 3, 1,"s");
		fazer_chaoParede(z - 10, x-4, y, z + 10, y + 3, 1,"s");
		fazer_chaoParede(z - 11, x-5, y, z + 11, y + 3, 1,"s");
		fazer_chaoParede(z - 11, x-6, y, z + 11, y + 3, 1,"s");
		fazer_chaoParede(z - 12, x-7, y, z + 12, y + 3, 1,"s");
		fazer_chaoParede(z - 12, x-8, y, z + 12, y + 3, 1,"s");
		fazer_chaoParede(z - 12, x-9, y, z + 12, y + 3, 1,"s");
		fazer_chaoParede(z - 13, x-10, y, z + 13, y + 3, 1,"s");
		fazer_chaoParede(z - 13, x-11, y, z + 13, y + 3, 1,"s");
		fazer_chaoParede(z - 13, x-12, y, z + 13, y + 3, 1,"s");
		fazer_chaoParede(z - 13, x-13, y, z + 13, y + 3, 1,"s");
		fazer_chaoParede(z - 13, x-14, y, z + 13, y + 3, 1,"s");
		world.setBlock(x-13, y+1, z, MinecraftRPGBlocks.spawner);
		fazer_chaoParede(z - 13, x-15, y, z + 13, y + 3, 1,"s");
		fazer_chaoParede(z - 12, x-16, y, z + 12, y + 3, 1,"s");
		fazer_chaoParede(z - 12, x-17, y, z + 12, y + 3, 1,"s");
		fazer_chaoParede(z - 12, x-18, y, z + 12, y + 3, 1,"s");
		fazer_chaoParede(z - 11, x-19, y, z + 11, y + 3, 1,"s");
		fazer_chaoParede(z - 11, x-20, y, z + 11, y + 3, 1,"s");
		fazer_chaoParede(z - 10, x-21, y, z + 10, y + 3, 1,"s");
		fazer_chaoParede(z - 9, x-22, y, z + 9, y + 3, 1,"s");
		fazer_chaoParede(z - 8, x-23, y, z + 8, y + 3, 2,"s");
		fazer_chaoParede(z - 6, x-24, y, z + 6, y + 3, 3,"s");
		fazer_chaoParede(z - 3, x-25, y, z + 3, y + 3, 4,"s");	
	}
	
	public int findGLev(int x, int z, World world){
		
		int y = 1;
		
		while(!world.canBlockSeeTheSky(x, y, z) && (y < 256)){
			y++;
		}		
		
		return y;
	}
	
	//s = start, t = size, pT = wallSize
	public void fazer_chaoParede(int s, int x, int y, int tz, int ty, int pT,String side){		
		
		world.setBlock(x, y, s, Blocks.planks);
		for(int s2 = s + 1; s2 < tz; s2++){
			world.setBlock(x, y, s2, Blocks.planks);
			for(int y2 = y + 1; y2 <= ty; y2++){
				world.setBlock(x, y2, s2, Blocks.air);
			}
		}	
		world.setBlock(x, y, tz, Blocks.planks);
		
		if(side.equals("s")){
			
			for(int pT2 = 0; pT2 < pT; pT2++){
				for(int y2 = y + 1; y2 <= ty; y2++){
					world.setBlock(x, y2, s+pT2, Blocks.stone);
				}
			}
			
			for(int pT2 = 0; pT2 < pT; pT2++){
				for(int y2 = y + 1; y2 <= ty; y2++){
					world.setBlock(x, y2, tz-pT2, Blocks.stone);
				}
			}			
		}
	}
}
