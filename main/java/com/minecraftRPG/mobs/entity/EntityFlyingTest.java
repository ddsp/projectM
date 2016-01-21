package com.minecraftRPG.mobs.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityFlyingTest extends EntityLiving{

	public EntityFlyingTestC center;
	
	public EntityFlyingTest(World world) {
		super(world);
		this.setSize(1F, 1F);
	}
	
	public EntityFlyingTest(World world, EntityFlyingTestC t) {
		super(world);
		this.setSize(1F, 1F);
		center = t;
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
		
	}
	
	@Override
	protected void applyEntityAttributes(){
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(5.0F);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.0D);
	}
}
