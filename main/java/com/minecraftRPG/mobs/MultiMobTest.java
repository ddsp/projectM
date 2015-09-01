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
			part.setPosition(posX + s, posY + 10, posZ);
			world.spawnEntityInWorld(part);
			part.motionY = 0;
			s++;
		}
		System.out.println(parts[0].posY);
	}
	
	public void update(){
		int s = 1;
		for(EntitySpiritWolf part: parts){
			part.setPositionAndUpdate(this.posX + s, this.posY + 10, this.posZ);
			part.motionY = 0;
			s++;
		}
	}
}
