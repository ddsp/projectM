package com.minecraftRPG.mobs.controller;

import com.minecraftRPG.mobs.entity.EntityFlyingTest;

import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;

public class MultiMobTest{

	protected World world;
	public EntityFlyingTest[] parts; 
	public int posX;
	public int posY;
	public int posZ;
	public EntityFlyingTest center;
	public EntityFlyingTest wolf2;
	
	public MultiMobTest(World world, int x, int y, int z) {
		posX = x;
		posY = y;
		posZ = z;
		//parts = new EntityFlyingTest[]{center = new EntityFlyingTest(world, this, true), wolf2 = new EntityFlyingTest(world, this, false)};
		int s = 1;
		for(EntityFlyingTest part: parts){
			part.setPosition(posX + s, posY, posZ);
			world.spawnEntityInWorld(part);
			part.motionY = 0;
			s++;
		}
	}
	
	public void update(){
		int s = 1;
		for(EntityFlyingTest part: parts){
			part.moveEntity(this.posX + s, this.posY + 3, this.posZ);
			//part.motionY = 0;
			s++;
		}
	}
}
