package com.minecraftRPG.mobs;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityFlyingTestC extends EntityLiving{

	public EntityFlyingTest secondPart;
	
	public EntityFlyingTestC(World world) {
		super(world);
		this.setSize(1F, 1F);
		secondPart = new EntityFlyingTest(world, this);
		secondPart.setPosition(this.posX, this.posY, this.posZ + 1);
		world.spawnEntityInWorld(secondPart);
	}
	
	@Override
	protected void fall(float p_70069_1_)
    {
		//NOPE
    }

	@Override
	protected void updateFallState(double par1, boolean par3) 
	{
		//NOPE
	}
	
	@Override
	public boolean isAIEnabled(){
		return false;
	}
	
	@Override
	public void onLivingUpdate()
	{
		if(secondPart == null){
			System.out.println("Hello");
		}else{
			secondPart.setPosition(this.posX + 1, this.posY, this.posZ);
			this.posY = 71;
			//System.out.println(secondPart.posX + "   " + secondPart.posY + "   " + secondPart.posZ + 1);
		}
		//super.onLivingUpdate();
	}
	
	@Override
	protected void applyEntityAttributes(){
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(5.0F);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.0D);
	}
	
	/*@Override
	public void moveEntityWithHeading(float par1, float par2) {
		if(father == null){
			super.moveEntityWithHeading(par1, par2);
		}else{
			this.motionY = 0;
		}
	}*/

}
