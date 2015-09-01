package com.minecraftRPG.mobs;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Items;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntitySpiritWolf extends EntityCreature {

	public MultiMobTest father;
	protected boolean center;
	
	public EntitySpiritWolf(World par1World) {
		super(par1World);
		this.setSize(1F, 1F);
		this.tasks.addTask(0, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, 1.0D, true));
	}
	
	public EntitySpiritWolf(World par1World, MultiMobTest t, boolean centerr) {
		super(par1World);
		this.setSize(1F, 1F);
		father = t;
		center = centerr;
		this.tasks.addTask(0, new EntityAIWander(this, 0.0D));
	}
	
	public EntitySpiritWolf(World par1World, EntityLiving entityEnemy) {
		super(par1World);
		this.setSize(1F, 1F);
		this.tasks.addTask(0, new EntityAIAttackOnCollide(this, 1.0D, true));
		
		if(entityEnemy != null){
			this.tasks.addTask(0, new SpiritWolfCAI(this, entityEnemy));
		}
		
	}
	
	@Override
	protected void fall(float p_70069_1_)
    {
		if(father == null){
			super.fall(p_70069_1_);
		}
    }

	@Override
	protected void updateFallState(double par1, boolean par3) 
	{
		System.out.println("true");
		if(father == null){
			super.updateFallState(par1, par3);
		}
	}
	
	@Override
	public boolean isAIEnabled(){
		if(father == null){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public void onLivingUpdate()
	{
		worldObj.spawnParticle("largesmoke", posX, posY, posZ, 0.0D, 0.0D, 0.0D);
		if((father != null) && (center)){
			father.update();
		}
		super.onLivingUpdate();
	}
	
	@Override
	public void moveEntityWithHeading(float par1, float par2) {
		if(father == null){
			super.moveEntityWithHeading(par1, par2);
		}else{
			this.motionY = 0;
		}
	}
	
	@Override
	protected void applyEntityAttributes(){
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(5.0F);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8D);
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entity)
    {
		entity.attackEntityFrom(DamageSource.causeMobDamage(this), 4);
		this.setDead();
        return true;
    }

	@Override
	protected boolean canDespawn()
    {
        return this.ticksExisted > 100;
    }
}
