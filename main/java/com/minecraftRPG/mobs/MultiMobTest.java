package com.minecraftRPG.mobs;

import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;

public class MultiMobTest{

	protected World world;
	public EntitySpiritWolf[] parts; 
	public int posX;
	public int posY;
	public int posZ;
	public EntitySpiritWolf center;
	public EntitySpiritWolf wolf2;
	
	public MultiMobTest(World world, int x, int y, int z) {
		posX = x;
		posY = y;
		posZ = z;
		parts = new EntitySpiritWolf[]{center = new EntitySpiritWolf(world, this, true), wolf2 = new EntitySpiritWolf(world, this, false)};
		int s = 1;
		for(EntitySpiritWolf part: parts){
			part.setPosition(posX + s, posY, posZ);
			world.spawnEntityInWorld(part);
			s++;
		}
	}
	
	public void update(){
		int s = 1;
		for(EntitySpiritWolf part: parts){
			part.setPositionAndUpdate(posX + s, posY + 10, posZ);
			part.motionY = 0;
			s++;
		}
	}
}
