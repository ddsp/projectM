package com.minecraftRPG.mobs.entity;

import com.minecraftRPG.mobs.ai.SpiritWolfCAI;

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
	
	public EntitySpiritWolf(World par1World) {
		super(par1World);
		this.setSize(1F, 1F);
		this.tasks.addTask(0, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, 1.0D, true));
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
	public boolean isAIEnabled(){
		return true;
	}
	
	@Override
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
		worldObj.spawnParticle("largesmoke", posX, posY, posZ, 0.0D, 0.0D, 0.0D);
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
