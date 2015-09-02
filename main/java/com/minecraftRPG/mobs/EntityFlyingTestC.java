package com.minecraftRPG.mobs;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityFlyingTestC extends EntityLiving{

	public EntityFlyingTest secondPart;
	public final int FPosX;
	public final int FPosY;
	public final int FPosZ;
	
	public EntityFlyingTestC(World world, int FPoX, int FPoY, int FPoZ) {
		super(world);
		this.setSize(1F, 1F);
		FPosX = FPoX;
		FPosY = FPoY;
		FPosZ = FPoZ;
		secondPart = new EntityFlyingTest(world, this);;
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
		secondPart.setPosition(FPosX, FPosY, FPosZ);
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
